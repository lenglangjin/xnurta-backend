package com.leda.aop;

import com.alibaba.fastjson.JSON;
import com.leda.utils.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * 操作日志记录处理
 * 
 * @author claude
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 配置织入点
     * 排除基础方法如initBinder
     */
    @Pointcut("execution(public * com.leda.controller..*.*(..)) " +
            "&& !execution(* com.leda.controller.BaseController.*(..)) " +
            "&& !@annotation(org.springframework.web.bind.annotation.InitBinder)")
    public void logPointCut() {
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        // 由于在环绕通知中已经处理，这里可以不用重复处理
    }

    /**
     * 拦截异常操作
     * 
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        // 由于在环绕通知中已经处理，这里可以不用重复处理
    }

    /**
     * 环绕通知
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = null;
        Exception exception = null;
        
        try {
            result = pjp.proceed();
            return result;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            long time = System.currentTimeMillis() - startTime;
            // 记录日志
            handleLog(pjp, exception, result);
            log.info("执行耗时：{} ms", time);
        }
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

            StringBuilder sb = new StringBuilder();
            sb.append("\n========================================== Start ==========================================")
              .append(LINE_SEPARATOR);

            // 请求相关信息
            sb.append("请求openid     : ").append(UserContext.getCurrentOpenId()).append(LINE_SEPARATOR);
            sb.append("请求IP     : ").append(getIpAddr(request)).append(LINE_SEPARATOR);
            sb.append("请求URL    : ").append(request.getRequestURL().toString()).append(LINE_SEPARATOR);
            sb.append("请求方式    : ").append(request.getMethod()).append(LINE_SEPARATOR);
            sb.append("请求类名    : ").append(joinPoint.getSignature().getDeclaringTypeName()).append(LINE_SEPARATOR);
            sb.append("请求方法名  : ").append(joinPoint.getSignature().getName()).append(LINE_SEPARATOR);

            // 获取请求参数
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                Map<String, String[]> paramMap = request.getParameterMap();
                if (!paramMap.isEmpty()) {
                    sb.append("请求参数(URL): ").append(JSON.toJSONString(paramMap)).append(LINE_SEPARATOR);
                }
            } else {
                Object[] args = joinPoint.getArgs();
                if (args != null && args.length > 0) {
                    try {
                        String params = JSON.toJSONString(args[0]);
                        if (!"{}".equals(params) && !"[]".equals(params)) {
                            sb.append("请求参数(Body): ").append(params).append(LINE_SEPARATOR);
                        }
                    } catch (Exception ex) {
                        sb.append("请求参数(Body): [参数序列化失败]").append(LINE_SEPARATOR);
                    }
                }
            }

            // 请求头信息
            sb.append("User-Agent : ").append(request.getHeader("User-Agent")).append(LINE_SEPARATOR);

            // 响应结果
            if (jsonResult != null) {
                try {
                    String result = JSON.toJSONString(jsonResult);
                    if (!"{}".equals(result) && !"[]".equals(result)) {
                        sb.append("响应结果    : ").append(result).append(LINE_SEPARATOR);
                    }
                } catch (Exception ex) {
                    sb.append("响应结果    : [结果序列化失败]").append(LINE_SEPARATOR);
                }
            }

            // 异常信息
            if (e != null) {
                sb.append("异常信息    : ").append(e.getMessage()).append(LINE_SEPARATOR);
                sb.append("异常类型    : ").append(e.getClass().getName()).append(LINE_SEPARATOR);
                StackTraceElement[] stackTrace = e.getStackTrace();
                if (stackTrace.length > 0) {
                    sb.append("异常位置    : ").append(stackTrace[0]).append(LINE_SEPARATOR);
                }
            }

            sb.append("=========================================== End ===========================================")
              .append(LINE_SEPARATOR);

            log.info(sb.toString());

        } catch (Exception exp) {
            log.error("记录操作日志异常", exp);
        }
    }

    /**
     * 获取IP地址
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }
}

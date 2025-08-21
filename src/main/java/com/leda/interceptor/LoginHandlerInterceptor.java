//package com.leda.interceptor;
//
//import com.auth0.jwt.interfaces.Claim;
//import com.leda.utils.JwtUtils;
//import com.leda.utils.UserContext;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.nio.file.AccessDeniedException;
//import java.util.Map;
//
//@Slf4j
//@Component
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("token");
//        try {
//            Map<String, Claim> data = JwtUtils.verifyToken(token);
//            setUserContext(data);
//        }catch (Exception e){
//            log.error("token：{}未登陆,{}",token,e.getMessage());
//            throw new AccessDeniedException("请重新登陆");
//        }
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        UserContext.clear();
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//
//    private void setUserContext(Map<String, Claim> data){
//        UserContext.setCurrentUserId(data.get("userid").asLong());
//        UserContext.setCurrentOpenId(data.get("openid").asString());
//    }
//}

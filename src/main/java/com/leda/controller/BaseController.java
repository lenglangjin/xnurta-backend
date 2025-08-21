package com.leda.controller;


import com.github.pagehelper.PageInfo;
import com.leda.core.page.TableDataInfo;
import com.leda.utils.AjaxResult;
import com.leda.utils.DateUtils;
import com.leda.utils.PageUtils;
import com.leda.utils.ServletUtils;
import com.leda.utils.text.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import static com.leda.core.page.TableSupport.PAGE_NUM;
import static com.leda.core.page.TableSupport.PAGE_SIZE;

/**
 * web层通用数据处理
 * 
 * @author frank
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        long total = new PageInfo(list).getTotal();
        Integer pageSize = Convert.toInt(ServletUtils.getParameter(PAGE_SIZE));
        Integer pageNum = Convert.toInt(ServletUtils.getParameter(PAGE_NUM));
        long totalPageNum = total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1;
        rspData.setTotalPageNum(totalPageNum);
        rspData.setCurrentPageNum(pageNum);
        rspData.setTotal(total);
        return rspData;
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.ok();
    }

//    /**
//     * 返回失败消息
//     */
//    public AjaxResult error()
//    {
//        return AjaxResult.ok(500, "操作失败");
//    }
//
//    /**
//     * 返回成功消息
//     */
//    public AjaxResult AjaxResult.ok(String message)
//    {
//        return AjaxResult.ok(message);
//    }
//
//    /**
//     * 返回成功数据
//     */
//    public static AjaxResult AjaxResult.ok(Object data)
//    {
//        return AjaxResult.ok("操作成功", data);
//    }
//
      /**
       * 返回失败消息
       */
      public AjaxResult error(String message)
      {
          return AjaxResult.fail(message);
      }
//
//    /**
//     * 返回错误码消息
//     */
//    public AjaxResult error(AjaxResult.Type type, String message)
//    {
//        return AjaxResult.ok(type, message);
//    }


}

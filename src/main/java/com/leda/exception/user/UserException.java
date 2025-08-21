package com.leda.exception.user;


import com.leda.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author frank
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}

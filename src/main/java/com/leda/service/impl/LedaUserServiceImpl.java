package com.leda.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leda.dto.LedaLoginDto;
import com.leda.entity.LedaUser;
import com.leda.exception.BadRequestException;
import com.leda.exception.BusinessException;
import com.leda.utils.json.JSONObject;
import com.leda.mapper.LedaUserMapper;
import com.leda.service.ILedaUserService;
import com.leda.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LedaUserServiceImpl extends ServiceImpl<LedaUserMapper,LedaUser> implements ILedaUserService {

    @Autowired
    private LedaUserMapper ledaUserMapper;

    @Override
    public Map<String,Object> login(LedaLoginDto ledaLoginDto) {
        //通过code获取openid

        return  null;
    }

}

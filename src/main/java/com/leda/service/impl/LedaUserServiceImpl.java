package com.leda.service.impl;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

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
    private WxMaService wxMaService;

    @Autowired
    private LedaUserMapper ledaUserMapper;

    @Override
    public Map<String,Object> login(LedaLoginDto ledaLoginDto) {
        //通过code获取openid
        //查询数据库是否存在openid，没有则添加，存在登陆成功
        try {
            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(ledaLoginDto.getOpenidCode());
            log.info(JSONObject.valueAsStr(sessionInfo));
//            WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(ledaLoginDto.getPhoneCode());
//            log.info(JSONObject.valueAsStr(phoneNoInfo));

            LedaUser ledaUser = ledaUserMapper.selectByOpenid(sessionInfo.getOpenid());
            if(ledaUser == null) {
                //添加用户
                ledaUser = ledaUser.builder().openid(sessionInfo.getOpenid()).build();
            }else {
                //更新手机号
            }
            ledaUserMapper.insertOrUpdate(ledaUser);
            String token = JwtUtils.createToken(ledaUser.getId(), sessionInfo.getOpenid());
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("user", ledaUser);
            return map;
        } catch (WxErrorException e) {
            throw new BusinessException(e.getError().toString());
        }
    }

}

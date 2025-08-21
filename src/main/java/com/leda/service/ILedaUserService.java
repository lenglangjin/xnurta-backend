package com.leda.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leda.dto.LedaLoginDto;
import com.leda.entity.LedaUser;

import java.util.Map;

public interface ILedaUserService extends IService<LedaUser> {

    Map<String,Object> login(LedaLoginDto ledaLoginDto);
}

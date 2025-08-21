package com.leda.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leda.entity.LedaUser;


public interface LedaUserMapper extends BaseMapper<LedaUser> {

    LedaUser selectByOpenid(String openid);

}

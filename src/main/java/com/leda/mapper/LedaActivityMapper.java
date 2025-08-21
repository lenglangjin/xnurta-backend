package com.leda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leda.entity.LedaActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 活动Mapper接口
 * 
 * @author frank
 * @date 2024-12-19
 */
@Mapper
public interface LedaActivityMapper extends BaseMapper<LedaActivity> {

    /**
     * 查询指定日期需要发送提醒的活动ID列表
     * 
     * @param date 日期，格式：yyyy-MM-dd
     * @return 活动ID列表
     */
    @Select("SELECT id FROM leda_activity " +
            "WHERE DATE(ac_time) = #{date} " +
            "AND is_deleted = 0 " +
            "AND status = 1")
    List<Long> selectActivityIdsByDate(@Param("date") String date);

    /**
     * 查询指定日期的活动列表（包含完整信息）
     * 
     * @param date 日期，格式：yyyy-MM-dd
     * @return 活动列表
     */
    @Select("SELECT * FROM leda_activity " +
            "WHERE DATE(ac_time) = #{date} " +
            "AND is_deleted = 0 " +
            "AND status = 1")
    List<LedaActivity> selectActivitiesByDate(@Param("date") String date);
} 
package com.leda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leda.entity.LedaActivityApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 活动报名Mapper接口
 * 
 * @author frank
 * @date 2024-12-19
 */
@Mapper
public interface LedaActivityApplyMapper extends BaseMapper<LedaActivityApply> {

    /**
     * 查询指定活动的报名用户ID列表
     * 
     * @param activityId 活动ID
     * @return 报名用户ID列表
     */
    @Select("SELECT apply_user_id FROM leda_activity_apply " +
            "WHERE activity_id = #{activityId} " +
            "AND status = 1")
    List<Long> selectUserIdsByActivityId(@Param("activityId") Long activityId);

    /**
     * 查询指定活动的报名记录列表
     * 
     * @param activityId 活动ID
     * @return 报名记录列表
     */
    @Select("SELECT * FROM leda_activity_apply " +
            "WHERE activity_id = #{activityId} " +
            "AND status = 1")
    List<LedaActivityApply> selectByActivityId(@Param("activityId") Long activityId);
} 
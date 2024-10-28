package com.dao;

import com.entity.GongnuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongnuanView;

/**
 * 供暖 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface GongnuanDao extends BaseMapper<GongnuanEntity> {

   List<GongnuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

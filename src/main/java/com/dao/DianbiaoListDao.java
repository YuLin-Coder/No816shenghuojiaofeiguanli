package com.dao;

import com.entity.DianbiaoListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DianbiaoListView;

/**
 * 电表缴费记录 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface DianbiaoListDao extends BaseMapper<DianbiaoListEntity> {

   List<DianbiaoListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

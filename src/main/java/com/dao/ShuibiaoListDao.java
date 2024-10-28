package com.dao;

import com.entity.ShuibiaoListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuibiaoListView;

/**
 * 水表缴费记录 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface ShuibiaoListDao extends BaseMapper<ShuibiaoListEntity> {

   List<ShuibiaoListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

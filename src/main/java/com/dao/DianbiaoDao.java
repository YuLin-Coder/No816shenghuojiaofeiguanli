package com.dao;

import com.entity.DianbiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DianbiaoView;

/**
 * 电表 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface DianbiaoDao extends BaseMapper<DianbiaoEntity> {

   List<DianbiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

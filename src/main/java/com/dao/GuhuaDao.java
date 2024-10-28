package com.dao;

import com.entity.GuhuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuhuaView;

/**
 * 固话 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface GuhuaDao extends BaseMapper<GuhuaEntity> {

   List<GuhuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.dao;

import com.entity.GuhuaListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuhuaListView;

/**
 * 固话缴费记录 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface GuhuaListDao extends BaseMapper<GuhuaListEntity> {

   List<GuhuaListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

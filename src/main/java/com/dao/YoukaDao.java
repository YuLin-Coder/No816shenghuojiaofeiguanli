package com.dao;

import com.entity.YoukaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YoukaView;

/**
 * 油卡 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface YoukaDao extends BaseMapper<YoukaEntity> {

   List<YoukaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.dao;

import com.entity.EtcEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.EtcView;

/**
 * ETC Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface EtcDao extends BaseMapper<EtcEntity> {

   List<EtcView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.dao;

import com.entity.BangzhuzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BangzhuzhongxinView;

/**
 * 帮助中心 Dao 接口
 *
 * @author 
 * @since 2021-04-12
 */
public interface BangzhuzhongxinDao extends BaseMapper<BangzhuzhongxinEntity> {

   List<BangzhuzhongxinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

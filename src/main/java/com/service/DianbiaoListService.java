package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianbiaoListEntity;
import java.util.Map;

/**
 * 电表缴费记录 服务类
 * @author 
 * @since 2021-04-12
 */
public interface DianbiaoListService extends IService<DianbiaoListEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
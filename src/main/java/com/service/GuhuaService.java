package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuhuaEntity;
import java.util.Map;

/**
 * 固话 服务类
 * @author 
 * @since 2021-04-12
 */
public interface GuhuaService extends IService<GuhuaEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YoukaEntity;
import java.util.Map;

/**
 * 油卡 服务类
 * @author 
 * @since 2021-04-12
 */
public interface YoukaService extends IService<YoukaEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
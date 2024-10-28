package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BangzhuzhongxinEntity;
import java.util.Map;

/**
 * 帮助中心 服务类
 * @author 
 * @since 2021-04-12
 */
public interface BangzhuzhongxinService extends IService<BangzhuzhongxinEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.DianbiaoListDao;
import com.entity.DianbiaoListEntity;
import com.service.DianbiaoListService;
import com.entity.view.DianbiaoListView;

/**
 * 电表缴费记录 服务实现类
 * @author 
 * @since 2021-04-12
 */
@Service("dianbiaoListService")
@Transactional
public class DianbiaoListServiceImpl extends ServiceImpl<DianbiaoListDao, DianbiaoListEntity> implements DianbiaoListService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DianbiaoListView> page =new Query<DianbiaoListView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

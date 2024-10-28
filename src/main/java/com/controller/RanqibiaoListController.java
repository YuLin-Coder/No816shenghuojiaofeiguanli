package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.RanqibiaoListEntity;

import com.service.RanqibiaoListService;
import com.entity.view.RanqibiaoListView;
import com.service.RanqibiaoService;
import com.entity.RanqibiaoEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 燃气表缴费记录
 * 后端接口
 * @author
 * @email
 * @date 2021-04-12
*/
@RestController
@Controller
@RequestMapping("/ranqibiaoList")
public class RanqibiaoListController {
    private static final Logger logger = LoggerFactory.getLogger(RanqibiaoListController.class);

    @Autowired
    private RanqibiaoListService ranqibiaoListService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private RanqibiaoService ranqibiaoService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = ranqibiaoListService.queryPage(params);

        //字典表数据转换
        List<RanqibiaoListView> list =(List<RanqibiaoListView>)page.getList();
        for(RanqibiaoListView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RanqibiaoListEntity ranqibiaoList = ranqibiaoListService.selectById(id);
        if(ranqibiaoList !=null){
            //entity转view
            RanqibiaoListView view = new RanqibiaoListView();
            BeanUtils.copyProperties( ranqibiaoList , view );//把实体数据重构到view中

            //级联表
            RanqibiaoEntity ranqibiao = ranqibiaoService.selectById(ranqibiaoList.getRanqibiaoId());
            if(ranqibiao != null){
                BeanUtils.copyProperties( ranqibiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setRanqibiaoId(ranqibiao.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody RanqibiaoListEntity ranqibiaoList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ranqibiaoList:{}",this.getClass().getName(),ranqibiaoList.toString());
        Wrapper<RanqibiaoListEntity> queryWrapper = new EntityWrapper<RanqibiaoListEntity>()
            .eq("ranqibiao_id", ranqibiaoList.getRanqibiaoId())
            .eq("success_types", ranqibiaoList.getSuccessTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RanqibiaoListEntity ranqibiaoListEntity = ranqibiaoListService.selectOne(queryWrapper);
        if(ranqibiaoListEntity==null){
            ranqibiaoList.setInsertTime(new Date());
            ranqibiaoList.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      ranqibiaoList.set
        //  }
            ranqibiaoListService.insert(ranqibiaoList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RanqibiaoListEntity ranqibiaoList, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ranqibiaoList:{}",this.getClass().getName(),ranqibiaoList.toString());
        //根据字段查询是否有相同数据
        Wrapper<RanqibiaoListEntity> queryWrapper = new EntityWrapper<RanqibiaoListEntity>()
            .notIn("id",ranqibiaoList.getId())
            .andNew()
            .eq("ranqibiao_id", ranqibiaoList.getRanqibiaoId())
            .eq("success_types", ranqibiaoList.getSuccessTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RanqibiaoListEntity ranqibiaoListEntity = ranqibiaoListService.selectOne(queryWrapper);
        if(ranqibiaoListEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      ranqibiaoList.set
            //  }
            ranqibiaoListService.updateById(ranqibiaoList);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ranqibiaoListService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = ranqibiaoListService.queryPage(params);

        //字典表数据转换
        List<RanqibiaoListView> list =(List<RanqibiaoListView>)page.getList();
        for(RanqibiaoListView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RanqibiaoListEntity ranqibiaoList = ranqibiaoListService.selectById(id);
            if(ranqibiaoList !=null){
                //entity转view
        RanqibiaoListView view = new RanqibiaoListView();
                BeanUtils.copyProperties( ranqibiaoList , view );//把实体数据重构到view中

                //级联表
                    RanqibiaoEntity ranqibiao = ranqibiaoService.selectById(ranqibiaoList.getRanqibiaoId());
                if(ranqibiao != null){
                    BeanUtils.copyProperties( ranqibiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setRanqibiaoId(ranqibiao.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody RanqibiaoListEntity ranqibiaoList, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,ranqibiaoList:{}",this.getClass().getName(),ranqibiaoList.toString());
        Wrapper<RanqibiaoListEntity> queryWrapper = new EntityWrapper<RanqibiaoListEntity>()
            .eq("ranqibiao_id", ranqibiaoList.getRanqibiaoId())
            .eq("success_types", ranqibiaoList.getSuccessTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    RanqibiaoListEntity ranqibiaoListEntity = ranqibiaoListService.selectOne(queryWrapper);
        if(ranqibiaoListEntity==null){
            ranqibiaoList.setInsertTime(new Date());
            ranqibiaoList.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      ranqibiaoList.set
        //  }
        ranqibiaoListService.insert(ranqibiaoList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}


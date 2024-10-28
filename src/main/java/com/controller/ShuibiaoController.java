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

import com.entity.ShuibiaoEntity;

import com.service.ShuibiaoService;
import com.entity.view.ShuibiaoView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.ShuibiaoListService;
import com.entity.ShuibiaoListEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 水表
 * 后端接口
 * @author
 * @email
 * @date 2021-04-12
*/
@RestController
@Controller
@RequestMapping("/shuibiao")
public class ShuibiaoController {
    private static final Logger logger = LoggerFactory.getLogger(ShuibiaoController.class);

    @Autowired
    private ShuibiaoService shuibiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;
    // 列表详情的表级联service
    @Autowired
    private ShuibiaoListService shuibiaoListService;
//    @Autowired
//    private YonghuService yonghuService;


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
        PageUtils page = shuibiaoService.queryPage(params);

        //字典表数据转换
        List<ShuibiaoView> list =(List<ShuibiaoView>)page.getList();
        for(ShuibiaoView c:list){
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
        ShuibiaoEntity shuibiao = shuibiaoService.selectById(id);
        if(shuibiao !=null){
            //entity转view
            ShuibiaoView view = new ShuibiaoView();
            BeanUtils.copyProperties( shuibiao , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shuibiao.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ShuibiaoEntity shuibiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuibiao:{}",this.getClass().getName(),shuibiao.toString());
        Wrapper<ShuibiaoEntity> queryWrapper = new EntityWrapper<ShuibiaoEntity>()
            .eq("shuibiao_number", shuibiao.getShuibiaoNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuibiaoEntity shuibiaoEntity = shuibiaoService.selectOne(queryWrapper);
        if(shuibiaoEntity==null){
            shuibiao.setCreateTime(new Date());
            String role = String.valueOf(request.getSession().getAttribute("role"));
            if("用户".equals(role)){
                shuibiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            }
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shuibiao.set
        //  }
            shuibiaoService.insert(shuibiao);
            return R.ok();
        }else {
            return R.error(511,"编号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuibiaoEntity shuibiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shuibiao:{}",this.getClass().getName(),shuibiao.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShuibiaoEntity> queryWrapper = new EntityWrapper<ShuibiaoEntity>()
            .notIn("id",shuibiao.getId())
            .andNew()
            .eq("shuibiao_number", shuibiao.getShuibiaoNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuibiaoEntity shuibiaoEntity = shuibiaoService.selectOne(queryWrapper);
        if(shuibiaoEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shuibiao.set
            //  }
            shuibiaoService.updateById(shuibiao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"编号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shuibiaoService.deleteBatchIds(Arrays.asList(ids));
        shuibiaoListService.delete(new EntityWrapper<ShuibiaoListEntity>().in("shuibiao_id",ids));//删除设备缴费记录
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
        PageUtils page = shuibiaoService.queryPage(params);

        //字典表数据转换
        List<ShuibiaoView> list =(List<ShuibiaoView>)page.getList();
        for(ShuibiaoView c:list){
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
        ShuibiaoEntity shuibiao = shuibiaoService.selectById(id);
            if(shuibiao !=null){
                //entity转view
        ShuibiaoView view = new ShuibiaoView();
                BeanUtils.copyProperties( shuibiao , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shuibiao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody ShuibiaoEntity shuibiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuibiao:{}",this.getClass().getName(),shuibiao.toString());
        Wrapper<ShuibiaoEntity> queryWrapper = new EntityWrapper<ShuibiaoEntity>()
            .eq("yonghu_id", shuibiao.getYonghuId())
            .eq("shuibiao_number", shuibiao.getShuibiaoNumber())
            .eq("shuibiao_address", shuibiao.getShuibiaoAddress())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ShuibiaoEntity shuibiaoEntity = shuibiaoService.selectOne(queryWrapper);
        if(shuibiaoEntity==null){
            shuibiao.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shuibiao.set
        //  }
        shuibiaoService.insert(shuibiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 缴费
     */
    @RequestMapping("/jiaofei")
    public R jiaofei(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("jiaofei方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        Integer userId = (Integer) request.getSession().getAttribute("userId");//当前登录人的id
        String role = (String) request.getSession().getAttribute("role");//当前登录人权限
        String jiaofeiMoney = (String) params.get("jiaofeiMoney");//缴费金额
        Integer id = (Integer) params.get("id");//缴费金额

        ShuibiaoEntity shuibiaoEntity = shuibiaoService.selectById(id);
        if(shuibiaoEntity == null){
            return R.error(511,"查询不到电表");
        }
        if("用户".equals(role)){//用户要效验是不是自己的设备
            if(shuibiaoEntity.getYonghuId() != userId){
                return R.error(511,"您不能给不是自己的设备缴费");
            }
        }
        if(jiaofeiMoney == null || jiaofeiMoney == ""){
            return R.error(511,"缴费金额不能为空");
        }
        if(jiaofeiMoney.contains(".")){
            String[] split = jiaofeiMoney.split("\\.");
            if(split.length>1){//证明有小数
                String xiaoshu = split[1];
                if(xiaoshu.length()>2){
                    return R.error(511,"小数位最大为两位");
                }
            }
            String zhengshu = split[0];
            if(zhengshu.length()>6){
                return R.error(511,"整数位最大为6位");
            }
        }else{
            if(jiaofeiMoney.length()>6){
                return R.error(511,"整数位最大为6位");
            }
        }

        Double jiaofeiMoney1 = Double.parseDouble(jiaofeiMoney);
        if(jiaofeiMoney1 != null ){
            YonghuEntity yonghuEntity = null;

            if("用户".equals(role)) {//用户要效验是不是自己的设备
                yonghuEntity = yonghuService.selectById(userId);//当前登录人的信息
            }else if("管理员".equals(role)) {
                yonghuEntity = yonghuService.selectById(shuibiaoEntity.getYonghuId());//管理员获取当前设备的用户id
            }

            if(yonghuEntity == null || yonghuEntity.getNewMoney() == null || yonghuEntity.getNewMoney() == 0 ){
                return R.error(511,"用户 或者 用户金额为空");
            }

            Double oldMoney = yonghuEntity.getNewMoney();

            if((oldMoney - jiaofeiMoney1)<0){
                return R.error(511,"缴费金额大于余额,请重选金额或充值");
            }

            yonghuEntity.setNewMoney(oldMoney - jiaofeiMoney1);//设置用户余额
            ShuibiaoListEntity shuibiaoListEntity = new ShuibiaoListEntity();
            shuibiaoListEntity.setCreateTime(new Date());
            shuibiaoListEntity.setInsertTime(new Date());
            shuibiaoListEntity.setShuibiaoId(shuibiaoEntity.getId());
            shuibiaoListEntity.setShuibiaoListOldMoney(shuibiaoEntity.getShuibiaoMoney());
            shuibiaoListEntity.setShuibiaoListNewMoney(jiaofeiMoney1);
            shuibiaoListEntity.setSuccessTypes(1);

            shuibiaoEntity.setShuibiaoMoney(shuibiaoEntity.getShuibiaoMoney()+jiaofeiMoney1);//设置设备余额
            shuibiaoListService.insert(shuibiaoListEntity);//新增记录
            shuibiaoService.updateById(shuibiaoEntity);//更新设备
            yonghuService.updateById(yonghuEntity);//更新用户

        }

        return R.ok();
    }

}


package com.entity.model;

import com.entity.BangzhuzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 帮助中心
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class BangzhuzhongxinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 名称
     */
    private String bangzhuzhongxinName;


    /**
     * 类型
     */
    private Integer bangzhuzhongxinTypes;


    /**
     * 新闻图片
     */
    private String bangzhuzhongxinPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 详情
     */
    private String bangzhuzhongxinContent;


    /**
     * 创建时间 show2 show1 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：名称
	 */
    public String getBangzhuzhongxinName() {
        return bangzhuzhongxinName;
    }


    /**
	 * 设置：名称
	 */
    public void setBangzhuzhongxinName(String bangzhuzhongxinName) {
        this.bangzhuzhongxinName = bangzhuzhongxinName;
    }
    /**
	 * 获取：类型
	 */
    public Integer getBangzhuzhongxinTypes() {
        return bangzhuzhongxinTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setBangzhuzhongxinTypes(Integer bangzhuzhongxinTypes) {
        this.bangzhuzhongxinTypes = bangzhuzhongxinTypes;
    }
    /**
	 * 获取：新闻图片
	 */
    public String getBangzhuzhongxinPhoto() {
        return bangzhuzhongxinPhoto;
    }


    /**
	 * 设置：新闻图片
	 */
    public void setBangzhuzhongxinPhoto(String bangzhuzhongxinPhoto) {
        this.bangzhuzhongxinPhoto = bangzhuzhongxinPhoto;
    }
    /**
	 * 获取：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：详情
	 */
    public String getBangzhuzhongxinContent() {
        return bangzhuzhongxinContent;
    }


    /**
	 * 设置：详情
	 */
    public void setBangzhuzhongxinContent(String bangzhuzhongxinContent) {
        this.bangzhuzhongxinContent = bangzhuzhongxinContent;
    }
    /**
	 * 获取：创建时间 show2 show1 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 show1 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity.model;

import com.entity.YoukaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 油卡
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class YoukaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 油卡编号
     */
    private String youkaNumber;


    /**
     * 油卡余额
     */
    private Double youkaMoney;


    /**
     * 油卡所属公司
     */
    private Integer youkaTypes;


    /**
     * 油卡开户地址
     */
    private String youkaAddress;


    /**
     * 创建时间
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：油卡编号
	 */
    public String getYoukaNumber() {
        return youkaNumber;
    }


    /**
	 * 设置：油卡编号
	 */
    public void setYoukaNumber(String youkaNumber) {
        this.youkaNumber = youkaNumber;
    }
    /**
	 * 获取：油卡余额
	 */
    public Double getYoukaMoney() {
        return youkaMoney;
    }


    /**
	 * 设置：油卡余额
	 */
    public void setYoukaMoney(Double youkaMoney) {
        this.youkaMoney = youkaMoney;
    }
    /**
	 * 获取：油卡所属公司
	 */
    public Integer getYoukaTypes() {
        return youkaTypes;
    }


    /**
	 * 设置：油卡所属公司
	 */
    public void setYoukaTypes(Integer youkaTypes) {
        this.youkaTypes = youkaTypes;
    }
    /**
	 * 获取：油卡开户地址
	 */
    public String getYoukaAddress() {
        return youkaAddress;
    }


    /**
	 * 设置：油卡开户地址
	 */
    public void setYoukaAddress(String youkaAddress) {
        this.youkaAddress = youkaAddress;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

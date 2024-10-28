package com.entity.model;

import com.entity.EtcEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * ETC
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class EtcModel implements Serializable {
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
     * ETC编号
     */
    private String etcNumber;


    /**
     * ETC余额
     */
    private Double etcMoney;


    /**
     * ETC编号所在地址
     */
    private String etcAddress;


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
	 * 获取：ETC编号
	 */
    public String getEtcNumber() {
        return etcNumber;
    }


    /**
	 * 设置：ETC编号
	 */
    public void setEtcNumber(String etcNumber) {
        this.etcNumber = etcNumber;
    }
    /**
	 * 获取：ETC余额
	 */
    public Double getEtcMoney() {
        return etcMoney;
    }


    /**
	 * 设置：ETC余额
	 */
    public void setEtcMoney(Double etcMoney) {
        this.etcMoney = etcMoney;
    }
    /**
	 * 获取：ETC编号所在地址
	 */
    public String getEtcAddress() {
        return etcAddress;
    }


    /**
	 * 设置：ETC编号所在地址
	 */
    public void setEtcAddress(String etcAddress) {
        this.etcAddress = etcAddress;
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

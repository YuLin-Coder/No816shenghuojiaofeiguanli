package com.entity.model;

import com.entity.GuhuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 固话
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class GuhuaModel implements Serializable {
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
     * 固话编号
     */
    private String guhuaNumber;


    /**
     * 固话余额
     */
    private Double guhuaMoney;


    /**
     * 固话编号所在地址
     */
    private String guhuaAddress;


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
	 * 获取：固话编号
	 */
    public String getGuhuaNumber() {
        return guhuaNumber;
    }


    /**
	 * 设置：固话编号
	 */
    public void setGuhuaNumber(String guhuaNumber) {
        this.guhuaNumber = guhuaNumber;
    }
    /**
	 * 获取：固话余额
	 */
    public Double getGuhuaMoney() {
        return guhuaMoney;
    }


    /**
	 * 设置：固话余额
	 */
    public void setGuhuaMoney(Double guhuaMoney) {
        this.guhuaMoney = guhuaMoney;
    }
    /**
	 * 获取：固话编号所在地址
	 */
    public String getGuhuaAddress() {
        return guhuaAddress;
    }


    /**
	 * 设置：固话编号所在地址
	 */
    public void setGuhuaAddress(String guhuaAddress) {
        this.guhuaAddress = guhuaAddress;
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

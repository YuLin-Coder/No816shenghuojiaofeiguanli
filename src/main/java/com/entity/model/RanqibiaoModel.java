package com.entity.model;

import com.entity.RanqibiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 燃气表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class RanqibiaoModel implements Serializable {
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
     * 燃气表编号
     */
    private String ranqibiaoNumber;


    /**
     * 燃气表余额
     */
    private Double ranqibiaoMoney;


    /**
     * 燃气表编号所在地址
     */
    private String ranqibiaoAddress;


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
	 * 获取：燃气表编号
	 */
    public String getRanqibiaoNumber() {
        return ranqibiaoNumber;
    }


    /**
	 * 设置：燃气表编号
	 */
    public void setRanqibiaoNumber(String ranqibiaoNumber) {
        this.ranqibiaoNumber = ranqibiaoNumber;
    }
    /**
	 * 获取：燃气表余额
	 */
    public Double getRanqibiaoMoney() {
        return ranqibiaoMoney;
    }


    /**
	 * 设置：燃气表余额
	 */
    public void setRanqibiaoMoney(Double ranqibiaoMoney) {
        this.ranqibiaoMoney = ranqibiaoMoney;
    }
    /**
	 * 获取：燃气表编号所在地址
	 */
    public String getRanqibiaoAddress() {
        return ranqibiaoAddress;
    }


    /**
	 * 设置：燃气表编号所在地址
	 */
    public void setRanqibiaoAddress(String ranqibiaoAddress) {
        this.ranqibiaoAddress = ranqibiaoAddress;
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

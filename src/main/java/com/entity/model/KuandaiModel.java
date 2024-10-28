package com.entity.model;

import com.entity.KuandaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宽带
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-12
 */
public class KuandaiModel implements Serializable {
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
     * 宽带编号
     */
    private String kuandaiNumber;


    /**
     * 宽带余额
     */
    private Double kuandaiMoney;


    /**
     * 宽带编号所在地址
     */
    private String kuandaiAddress;


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
	 * 获取：宽带编号
	 */
    public String getKuandaiNumber() {
        return kuandaiNumber;
    }


    /**
	 * 设置：宽带编号
	 */
    public void setKuandaiNumber(String kuandaiNumber) {
        this.kuandaiNumber = kuandaiNumber;
    }
    /**
	 * 获取：宽带余额
	 */
    public Double getKuandaiMoney() {
        return kuandaiMoney;
    }


    /**
	 * 设置：宽带余额
	 */
    public void setKuandaiMoney(Double kuandaiMoney) {
        this.kuandaiMoney = kuandaiMoney;
    }
    /**
	 * 获取：宽带编号所在地址
	 */
    public String getKuandaiAddress() {
        return kuandaiAddress;
    }


    /**
	 * 设置：宽带编号所在地址
	 */
    public void setKuandaiAddress(String kuandaiAddress) {
        this.kuandaiAddress = kuandaiAddress;
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

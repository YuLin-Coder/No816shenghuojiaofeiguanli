package com.entity.vo;

import com.entity.EtcEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * ETC
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("etc")
public class EtcVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * ETC编号
     */

    @TableField(value = "etc_number")
    private String etcNumber;


    /**
     * ETC余额
     */

    @TableField(value = "etc_money")
    private Double etcMoney;


    /**
     * ETC编号所在地址
     */

    @TableField(value = "etc_address")
    private String etcAddress;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：ETC编号
	 */
    public String getEtcNumber() {
        return etcNumber;
    }


    /**
	 * 获取：ETC编号
	 */

    public void setEtcNumber(String etcNumber) {
        this.etcNumber = etcNumber;
    }
    /**
	 * 设置：ETC余额
	 */
    public Double getEtcMoney() {
        return etcMoney;
    }


    /**
	 * 获取：ETC余额
	 */

    public void setEtcMoney(Double etcMoney) {
        this.etcMoney = etcMoney;
    }
    /**
	 * 设置：ETC编号所在地址
	 */
    public String getEtcAddress() {
        return etcAddress;
    }


    /**
	 * 获取：ETC编号所在地址
	 */

    public void setEtcAddress(String etcAddress) {
        this.etcAddress = etcAddress;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.entity.vo;

import com.entity.GongnuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 供暖
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("gongnuan")
public class GongnuanVO implements Serializable {
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
     * 供暖编号
     */

    @TableField(value = "gongnuan_number")
    private String gongnuanNumber;


    /**
     * 供暖余额
     */

    @TableField(value = "gongnuan_money")
    private Double gongnuanMoney;


    /**
     * 供暖编号所在地址
     */

    @TableField(value = "gongnuan_address")
    private String gongnuanAddress;


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
	 * 设置：供暖编号
	 */
    public String getGongnuanNumber() {
        return gongnuanNumber;
    }


    /**
	 * 获取：供暖编号
	 */

    public void setGongnuanNumber(String gongnuanNumber) {
        this.gongnuanNumber = gongnuanNumber;
    }
    /**
	 * 设置：供暖余额
	 */
    public Double getGongnuanMoney() {
        return gongnuanMoney;
    }


    /**
	 * 获取：供暖余额
	 */

    public void setGongnuanMoney(Double gongnuanMoney) {
        this.gongnuanMoney = gongnuanMoney;
    }
    /**
	 * 设置：供暖编号所在地址
	 */
    public String getGongnuanAddress() {
        return gongnuanAddress;
    }


    /**
	 * 获取：供暖编号所在地址
	 */

    public void setGongnuanAddress(String gongnuanAddress) {
        this.gongnuanAddress = gongnuanAddress;
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

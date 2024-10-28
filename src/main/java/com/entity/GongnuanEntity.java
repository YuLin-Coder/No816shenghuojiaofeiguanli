package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 供暖
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("gongnuan")
public class GongnuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongnuanEntity() {

	}

	public GongnuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Gongnuan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongnuanNumber=" + gongnuanNumber +
            ", gongnuanMoney=" + gongnuanMoney +
            ", gongnuanAddress=" + gongnuanAddress +
            ", createTime=" + createTime +
        "}";
    }
}

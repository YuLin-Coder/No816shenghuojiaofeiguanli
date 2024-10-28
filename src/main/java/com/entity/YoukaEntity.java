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
 * 油卡
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("youka")
public class YoukaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YoukaEntity() {

	}

	public YoukaEntity(T t) {
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
     * 油卡编号
     */
    @TableField(value = "youka_number")

    private String youkaNumber;


    /**
     * 油卡余额
     */
    @TableField(value = "youka_money")

    private Double youkaMoney;


    /**
     * 油卡所属公司
     */
    @TableField(value = "youka_types")

    private Integer youkaTypes;


    /**
     * 油卡开户地址
     */
    @TableField(value = "youka_address")

    private String youkaAddress;


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
	 * 设置：油卡编号
	 */
    public String getYoukaNumber() {
        return youkaNumber;
    }


    /**
	 * 获取：油卡编号
	 */

    public void setYoukaNumber(String youkaNumber) {
        this.youkaNumber = youkaNumber;
    }
    /**
	 * 设置：油卡余额
	 */
    public Double getYoukaMoney() {
        return youkaMoney;
    }


    /**
	 * 获取：油卡余额
	 */

    public void setYoukaMoney(Double youkaMoney) {
        this.youkaMoney = youkaMoney;
    }
    /**
	 * 设置：油卡所属公司
	 */
    public Integer getYoukaTypes() {
        return youkaTypes;
    }


    /**
	 * 获取：油卡所属公司
	 */

    public void setYoukaTypes(Integer youkaTypes) {
        this.youkaTypes = youkaTypes;
    }
    /**
	 * 设置：油卡开户地址
	 */
    public String getYoukaAddress() {
        return youkaAddress;
    }


    /**
	 * 获取：油卡开户地址
	 */

    public void setYoukaAddress(String youkaAddress) {
        this.youkaAddress = youkaAddress;
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
        return "Youka{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", youkaNumber=" + youkaNumber +
            ", youkaMoney=" + youkaMoney +
            ", youkaTypes=" + youkaTypes +
            ", youkaAddress=" + youkaAddress +
            ", createTime=" + createTime +
        "}";
    }
}

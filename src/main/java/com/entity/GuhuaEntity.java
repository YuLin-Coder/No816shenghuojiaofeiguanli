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
 * 固话
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("guhua")
public class GuhuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuhuaEntity() {

	}

	public GuhuaEntity(T t) {
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
     * 固话编号
     */
    @TableField(value = "guhua_number")

    private String guhuaNumber;


    /**
     * 固话余额
     */
    @TableField(value = "guhua_money")

    private Double guhuaMoney;


    /**
     * 固话编号所在地址
     */
    @TableField(value = "guhua_address")

    private String guhuaAddress;


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
	 * 设置：固话编号
	 */
    public String getGuhuaNumber() {
        return guhuaNumber;
    }


    /**
	 * 获取：固话编号
	 */

    public void setGuhuaNumber(String guhuaNumber) {
        this.guhuaNumber = guhuaNumber;
    }
    /**
	 * 设置：固话余额
	 */
    public Double getGuhuaMoney() {
        return guhuaMoney;
    }


    /**
	 * 获取：固话余额
	 */

    public void setGuhuaMoney(Double guhuaMoney) {
        this.guhuaMoney = guhuaMoney;
    }
    /**
	 * 设置：固话编号所在地址
	 */
    public String getGuhuaAddress() {
        return guhuaAddress;
    }


    /**
	 * 获取：固话编号所在地址
	 */

    public void setGuhuaAddress(String guhuaAddress) {
        this.guhuaAddress = guhuaAddress;
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
        return "Guhua{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", guhuaNumber=" + guhuaNumber +
            ", guhuaMoney=" + guhuaMoney +
            ", guhuaAddress=" + guhuaAddress +
            ", createTime=" + createTime +
        "}";
    }
}

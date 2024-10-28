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
 * 电表
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("dianbiao")
public class DianbiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DianbiaoEntity() {

	}

	public DianbiaoEntity(T t) {
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
     * 电表编号
     */
    @TableField(value = "dianbiao_number")

    private String dianbiaoNumber;


    /**
     * 电表余额
     */
    @TableField(value = "dianbiao_money")

    private Double dianbiaoMoney;


    /**
     * 电表编号所在地址
     */
    @TableField(value = "dianbiao_address")

    private String dianbiaoAddress;


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
	 * 设置：电表编号
	 */
    public String getDianbiaoNumber() {
        return dianbiaoNumber;
    }


    /**
	 * 获取：电表编号
	 */

    public void setDianbiaoNumber(String dianbiaoNumber) {
        this.dianbiaoNumber = dianbiaoNumber;
    }
    /**
	 * 设置：电表余额
	 */
    public Double getDianbiaoMoney() {
        return dianbiaoMoney;
    }


    /**
	 * 获取：电表余额
	 */

    public void setDianbiaoMoney(Double dianbiaoMoney) {
        this.dianbiaoMoney = dianbiaoMoney;
    }
    /**
	 * 设置：电表编号所在地址
	 */
    public String getDianbiaoAddress() {
        return dianbiaoAddress;
    }


    /**
	 * 获取：电表编号所在地址
	 */

    public void setDianbiaoAddress(String dianbiaoAddress) {
        this.dianbiaoAddress = dianbiaoAddress;
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
        return "Dianbiao{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", dianbiaoNumber=" + dianbiaoNumber +
            ", dianbiaoMoney=" + dianbiaoMoney +
            ", dianbiaoAddress=" + dianbiaoAddress +
            ", createTime=" + createTime +
        "}";
    }
}

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
 * 燃气表
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("ranqibiao")
public class RanqibiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RanqibiaoEntity() {

	}

	public RanqibiaoEntity(T t) {
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
     * 燃气表编号
     */
    @TableField(value = "ranqibiao_number")

    private String ranqibiaoNumber;


    /**
     * 燃气表余额
     */
    @TableField(value = "ranqibiao_money")

    private Double ranqibiaoMoney;


    /**
     * 燃气表编号所在地址
     */
    @TableField(value = "ranqibiao_address")

    private String ranqibiaoAddress;


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
	 * 设置：燃气表编号
	 */
    public String getRanqibiaoNumber() {
        return ranqibiaoNumber;
    }


    /**
	 * 获取：燃气表编号
	 */

    public void setRanqibiaoNumber(String ranqibiaoNumber) {
        this.ranqibiaoNumber = ranqibiaoNumber;
    }
    /**
	 * 设置：燃气表余额
	 */
    public Double getRanqibiaoMoney() {
        return ranqibiaoMoney;
    }


    /**
	 * 获取：燃气表余额
	 */

    public void setRanqibiaoMoney(Double ranqibiaoMoney) {
        this.ranqibiaoMoney = ranqibiaoMoney;
    }
    /**
	 * 设置：燃气表编号所在地址
	 */
    public String getRanqibiaoAddress() {
        return ranqibiaoAddress;
    }


    /**
	 * 获取：燃气表编号所在地址
	 */

    public void setRanqibiaoAddress(String ranqibiaoAddress) {
        this.ranqibiaoAddress = ranqibiaoAddress;
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
        return "Ranqibiao{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", ranqibiaoNumber=" + ranqibiaoNumber +
            ", ranqibiaoMoney=" + ranqibiaoMoney +
            ", ranqibiaoAddress=" + ranqibiaoAddress +
            ", createTime=" + createTime +
        "}";
    }
}

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
 * 宽带
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("kuandai")
public class KuandaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuandaiEntity() {

	}

	public KuandaiEntity(T t) {
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
     * 宽带编号
     */
    @TableField(value = "kuandai_number")

    private String kuandaiNumber;


    /**
     * 宽带余额
     */
    @TableField(value = "kuandai_money")

    private Double kuandaiMoney;


    /**
     * 宽带编号所在地址
     */
    @TableField(value = "kuandai_address")

    private String kuandaiAddress;


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
	 * 设置：宽带编号
	 */
    public String getKuandaiNumber() {
        return kuandaiNumber;
    }


    /**
	 * 获取：宽带编号
	 */

    public void setKuandaiNumber(String kuandaiNumber) {
        this.kuandaiNumber = kuandaiNumber;
    }
    /**
	 * 设置：宽带余额
	 */
    public Double getKuandaiMoney() {
        return kuandaiMoney;
    }


    /**
	 * 获取：宽带余额
	 */

    public void setKuandaiMoney(Double kuandaiMoney) {
        this.kuandaiMoney = kuandaiMoney;
    }
    /**
	 * 设置：宽带编号所在地址
	 */
    public String getKuandaiAddress() {
        return kuandaiAddress;
    }


    /**
	 * 获取：宽带编号所在地址
	 */

    public void setKuandaiAddress(String kuandaiAddress) {
        this.kuandaiAddress = kuandaiAddress;
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
        return "Kuandai{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", kuandaiNumber=" + kuandaiNumber +
            ", kuandaiMoney=" + kuandaiMoney +
            ", kuandaiAddress=" + kuandaiAddress +
            ", createTime=" + createTime +
        "}";
    }
}

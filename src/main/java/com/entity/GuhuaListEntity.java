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
 * 固话缴费记录
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("guhua_list")
public class GuhuaListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuhuaListEntity() {

	}

	public GuhuaListEntity(T t) {
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
    @TableField(value = "guhua_id")

    private Integer guhuaId;


    /**
     * 缴费前余额
     */
    @TableField(value = "guhua_list_old_money")

    private Double guhuaListOldMoney;


    /**
     * 缴费金额(元)
     */
    @TableField(value = "guhua_list_new_money")

    private Double guhuaListNewMoney;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 是否缴费成功
     */
    @TableField(value = "success_types")

    private Integer successTypes;


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
    public Integer getGuhuaId() {
        return guhuaId;
    }


    /**
	 * 获取：用户
	 */

    public void setGuhuaId(Integer guhuaId) {
        this.guhuaId = guhuaId;
    }
    /**
	 * 设置：缴费前余额
	 */
    public Double getGuhuaListOldMoney() {
        return guhuaListOldMoney;
    }


    /**
	 * 获取：缴费前余额
	 */

    public void setGuhuaListOldMoney(Double guhuaListOldMoney) {
        this.guhuaListOldMoney = guhuaListOldMoney;
    }
    /**
	 * 设置：缴费金额(元)
	 */
    public Double getGuhuaListNewMoney() {
        return guhuaListNewMoney;
    }


    /**
	 * 获取：缴费金额(元)
	 */

    public void setGuhuaListNewMoney(Double guhuaListNewMoney) {
        this.guhuaListNewMoney = guhuaListNewMoney;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：缴费时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：是否缴费成功
	 */
    public Integer getSuccessTypes() {
        return successTypes;
    }


    /**
	 * 获取：是否缴费成功
	 */

    public void setSuccessTypes(Integer successTypes) {
        this.successTypes = successTypes;
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
        return "GuhuaList{" +
            "id=" + id +
            ", guhuaId=" + guhuaId +
            ", guhuaListOldMoney=" + guhuaListOldMoney +
            ", guhuaListNewMoney=" + guhuaListNewMoney +
            ", insertTime=" + insertTime +
            ", successTypes=" + successTypes +
            ", createTime=" + createTime +
        "}";
    }
}

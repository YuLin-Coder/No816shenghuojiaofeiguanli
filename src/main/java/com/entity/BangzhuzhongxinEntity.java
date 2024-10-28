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
 * 帮助中心
 *
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("bangzhuzhongxin")
public class BangzhuzhongxinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BangzhuzhongxinEntity() {

	}

	public BangzhuzhongxinEntity(T t) {
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
     * 名称
     */
    @TableField(value = "bangzhuzhongxin_name")

    private String bangzhuzhongxinName;


    /**
     * 类型
     */
    @TableField(value = "bangzhuzhongxin_types")

    private Integer bangzhuzhongxinTypes;


    /**
     * 新闻图片
     */
    @TableField(value = "bangzhuzhongxin_photo")

    private String bangzhuzhongxinPhoto;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 详情
     */
    @TableField(value = "bangzhuzhongxin_content")

    private String bangzhuzhongxinContent;


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
	 * 设置：名称
	 */
    public String getBangzhuzhongxinName() {
        return bangzhuzhongxinName;
    }


    /**
	 * 获取：名称
	 */

    public void setBangzhuzhongxinName(String bangzhuzhongxinName) {
        this.bangzhuzhongxinName = bangzhuzhongxinName;
    }
    /**
	 * 设置：类型
	 */
    public Integer getBangzhuzhongxinTypes() {
        return bangzhuzhongxinTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setBangzhuzhongxinTypes(Integer bangzhuzhongxinTypes) {
        this.bangzhuzhongxinTypes = bangzhuzhongxinTypes;
    }
    /**
	 * 设置：新闻图片
	 */
    public String getBangzhuzhongxinPhoto() {
        return bangzhuzhongxinPhoto;
    }


    /**
	 * 获取：新闻图片
	 */

    public void setBangzhuzhongxinPhoto(String bangzhuzhongxinPhoto) {
        this.bangzhuzhongxinPhoto = bangzhuzhongxinPhoto;
    }
    /**
	 * 设置：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：详情
	 */
    public String getBangzhuzhongxinContent() {
        return bangzhuzhongxinContent;
    }


    /**
	 * 获取：详情
	 */

    public void setBangzhuzhongxinContent(String bangzhuzhongxinContent) {
        this.bangzhuzhongxinContent = bangzhuzhongxinContent;
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
        return "Bangzhuzhongxin{" +
            "id=" + id +
            ", bangzhuzhongxinName=" + bangzhuzhongxinName +
            ", bangzhuzhongxinTypes=" + bangzhuzhongxinTypes +
            ", bangzhuzhongxinPhoto=" + bangzhuzhongxinPhoto +
            ", insertTime=" + insertTime +
            ", bangzhuzhongxinContent=" + bangzhuzhongxinContent +
            ", createTime=" + createTime +
        "}";
    }
}

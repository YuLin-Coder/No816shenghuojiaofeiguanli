package com.entity.vo;

import com.entity.GuhuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 固话
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("guhua")
public class GuhuaVO implements Serializable {
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

}

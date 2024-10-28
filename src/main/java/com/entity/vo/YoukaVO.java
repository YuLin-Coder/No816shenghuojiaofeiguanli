package com.entity.vo;

import com.entity.YoukaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 油卡
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("youka")
public class YoukaVO implements Serializable {
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

}

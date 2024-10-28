package com.entity.vo;

import com.entity.ShuibiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("shuibiao")
public class ShuibiaoVO implements Serializable {
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
     * 水表编号
     */

    @TableField(value = "shuibiao_number")
    private String shuibiaoNumber;


    /**
     * 水表余额
     */

    @TableField(value = "shuibiao_money")
    private Double shuibiaoMoney;


    /**
     * 水表编号所在地址
     */

    @TableField(value = "shuibiao_address")
    private String shuibiaoAddress;


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
	 * 设置：水表编号
	 */
    public String getShuibiaoNumber() {
        return shuibiaoNumber;
    }


    /**
	 * 获取：水表编号
	 */

    public void setShuibiaoNumber(String shuibiaoNumber) {
        this.shuibiaoNumber = shuibiaoNumber;
    }
    /**
	 * 设置：水表余额
	 */
    public Double getShuibiaoMoney() {
        return shuibiaoMoney;
    }


    /**
	 * 获取：水表余额
	 */

    public void setShuibiaoMoney(Double shuibiaoMoney) {
        this.shuibiaoMoney = shuibiaoMoney;
    }
    /**
	 * 设置：水表编号所在地址
	 */
    public String getShuibiaoAddress() {
        return shuibiaoAddress;
    }


    /**
	 * 获取：水表编号所在地址
	 */

    public void setShuibiaoAddress(String shuibiaoAddress) {
        this.shuibiaoAddress = shuibiaoAddress;
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

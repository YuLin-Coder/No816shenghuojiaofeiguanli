package com.entity.vo;

import com.entity.RanqibiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 燃气表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("ranqibiao")
public class RanqibiaoVO implements Serializable {
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

}

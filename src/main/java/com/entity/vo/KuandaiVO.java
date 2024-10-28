package com.entity.vo;

import com.entity.KuandaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宽带
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("kuandai")
public class KuandaiVO implements Serializable {
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

}

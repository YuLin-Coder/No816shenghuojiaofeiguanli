package com.entity.vo;

import com.entity.ShuibiaoListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水表缴费记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("shuibiao_list")
public class ShuibiaoListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "shuibiao_id")
    private Integer shuibiaoId;


    /**
     * 缴费前余额
     */

    @TableField(value = "shuibiao_list_old_money")
    private Double shuibiaoListOldMoney;


    /**
     * 缴费金额(元)
     */

    @TableField(value = "shuibiao_list_new_money")
    private Double shuibiaoListNewMoney;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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
    public Integer getShuibiaoId() {
        return shuibiaoId;
    }


    /**
	 * 获取：用户
	 */

    public void setShuibiaoId(Integer shuibiaoId) {
        this.shuibiaoId = shuibiaoId;
    }
    /**
	 * 设置：缴费前余额
	 */
    public Double getShuibiaoListOldMoney() {
        return shuibiaoListOldMoney;
    }


    /**
	 * 获取：缴费前余额
	 */

    public void setShuibiaoListOldMoney(Double shuibiaoListOldMoney) {
        this.shuibiaoListOldMoney = shuibiaoListOldMoney;
    }
    /**
	 * 设置：缴费金额(元)
	 */
    public Double getShuibiaoListNewMoney() {
        return shuibiaoListNewMoney;
    }


    /**
	 * 获取：缴费金额(元)
	 */

    public void setShuibiaoListNewMoney(Double shuibiaoListNewMoney) {
        this.shuibiaoListNewMoney = shuibiaoListNewMoney;
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

}

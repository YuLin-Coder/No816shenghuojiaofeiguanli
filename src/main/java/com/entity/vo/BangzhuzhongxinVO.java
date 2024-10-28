package com.entity.vo;

import com.entity.BangzhuzhongxinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 帮助中心
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("bangzhuzhongxin")
public class BangzhuzhongxinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 详情
     */

    @TableField(value = "bangzhuzhongxin_content")
    private String bangzhuzhongxinContent;


    /**
     * 创建时间 show2 show1 nameShow
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
	 * 设置：创建时间 show2 show1 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 show1 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

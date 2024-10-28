package com.entity.view;

import com.entity.GuhuaListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 固话缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("guhua_list")
public class GuhuaListView extends GuhuaListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 guhua
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 固话编号
			*/
			private String guhuaNumber;
			/**
			* 固话余额
			*/
			private Double guhuaMoney;
			/**
			* 固话编号所在地址
			*/
			private String guhuaAddress;

	public GuhuaListView() {

	}

	public GuhuaListView(GuhuaListEntity guhuaListEntity) {
		try {
			BeanUtils.copyProperties(this, guhuaListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否缴费成功的值
			*/
			public String getSuccessValue() {
				return successValue;
			}
			/**
			* 设置： 是否缴费成功的值
			*/
			public void setSuccessValue(String successValue) {
				this.successValue = successValue;
			}




















				//级联表的get和set guhua
					/**
					* 获取： 用户
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 固话编号
					*/
					public String getGuhuaNumber() {
						return guhuaNumber;
					}
					/**
					* 设置： 固话编号
					*/
					public void setGuhuaNumber(String guhuaNumber) {
						this.guhuaNumber = guhuaNumber;
					}
					/**
					* 获取： 固话余额
					*/
					public Double getGuhuaMoney() {
						return guhuaMoney;
					}
					/**
					* 设置： 固话余额
					*/
					public void setGuhuaMoney(Double guhuaMoney) {
						this.guhuaMoney = guhuaMoney;
					}
					/**
					* 获取： 固话编号所在地址
					*/
					public String getGuhuaAddress() {
						return guhuaAddress;
					}
					/**
					* 设置： 固话编号所在地址
					*/
					public void setGuhuaAddress(String guhuaAddress) {
						this.guhuaAddress = guhuaAddress;
					}






















}

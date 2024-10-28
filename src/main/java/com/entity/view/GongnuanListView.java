package com.entity.view;

import com.entity.GongnuanListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 供暖缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("gongnuan_list")
public class GongnuanListView extends GongnuanListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 gongnuan
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 供暖编号
			*/
			private String gongnuanNumber;
			/**
			* 供暖余额
			*/
			private Double gongnuanMoney;
			/**
			* 供暖编号所在地址
			*/
			private String gongnuanAddress;

	public GongnuanListView() {

	}

	public GongnuanListView(GongnuanListEntity gongnuanListEntity) {
		try {
			BeanUtils.copyProperties(this, gongnuanListEntity);
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
















				//级联表的get和set gongnuan
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
					* 获取： 供暖编号
					*/
					public String getGongnuanNumber() {
						return gongnuanNumber;
					}
					/**
					* 设置： 供暖编号
					*/
					public void setGongnuanNumber(String gongnuanNumber) {
						this.gongnuanNumber = gongnuanNumber;
					}
					/**
					* 获取： 供暖余额
					*/
					public Double getGongnuanMoney() {
						return gongnuanMoney;
					}
					/**
					* 设置： 供暖余额
					*/
					public void setGongnuanMoney(Double gongnuanMoney) {
						this.gongnuanMoney = gongnuanMoney;
					}
					/**
					* 获取： 供暖编号所在地址
					*/
					public String getGongnuanAddress() {
						return gongnuanAddress;
					}
					/**
					* 设置： 供暖编号所在地址
					*/
					public void setGongnuanAddress(String gongnuanAddress) {
						this.gongnuanAddress = gongnuanAddress;
					}


























}

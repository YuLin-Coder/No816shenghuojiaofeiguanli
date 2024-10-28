package com.entity.view;

import com.entity.ShuibiaoListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 水表缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("shuibiao_list")
public class ShuibiaoListView extends ShuibiaoListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 shuibiao
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 水表编号
			*/
			private String shuibiaoNumber;
			/**
			* 水表余额
			*/
			private Double shuibiaoMoney;
			/**
			* 水表编号所在地址
			*/
			private String shuibiaoAddress;

	public ShuibiaoListView() {

	}

	public ShuibiaoListView(ShuibiaoListEntity shuibiaoListEntity) {
		try {
			BeanUtils.copyProperties(this, shuibiaoListEntity);
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
































				//级联表的get和set shuibiao
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
					* 获取： 水表编号
					*/
					public String getShuibiaoNumber() {
						return shuibiaoNumber;
					}
					/**
					* 设置： 水表编号
					*/
					public void setShuibiaoNumber(String shuibiaoNumber) {
						this.shuibiaoNumber = shuibiaoNumber;
					}
					/**
					* 获取： 水表余额
					*/
					public Double getShuibiaoMoney() {
						return shuibiaoMoney;
					}
					/**
					* 设置： 水表余额
					*/
					public void setShuibiaoMoney(Double shuibiaoMoney) {
						this.shuibiaoMoney = shuibiaoMoney;
					}
					/**
					* 获取： 水表编号所在地址
					*/
					public String getShuibiaoAddress() {
						return shuibiaoAddress;
					}
					/**
					* 设置： 水表编号所在地址
					*/
					public void setShuibiaoAddress(String shuibiaoAddress) {
						this.shuibiaoAddress = shuibiaoAddress;
					}










}

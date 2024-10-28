package com.entity.view;

import com.entity.EtcListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * ETC缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("etc_list")
public class EtcListView extends EtcListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 etc
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* ETC编号
			*/
			private String etcNumber;
			/**
			* ETC余额
			*/
			private Double etcMoney;
			/**
			* ETC编号所在地址
			*/
			private String etcAddress;

	public EtcListView() {

	}

	public EtcListView(EtcListEntity etcListEntity) {
		try {
			BeanUtils.copyProperties(this, etcListEntity);
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












				//级联表的get和set etc
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
					* 获取： ETC编号
					*/
					public String getEtcNumber() {
						return etcNumber;
					}
					/**
					* 设置： ETC编号
					*/
					public void setEtcNumber(String etcNumber) {
						this.etcNumber = etcNumber;
					}
					/**
					* 获取： ETC余额
					*/
					public Double getEtcMoney() {
						return etcMoney;
					}
					/**
					* 设置： ETC余额
					*/
					public void setEtcMoney(Double etcMoney) {
						this.etcMoney = etcMoney;
					}
					/**
					* 获取： ETC编号所在地址
					*/
					public String getEtcAddress() {
						return etcAddress;
					}
					/**
					* 设置： ETC编号所在地址
					*/
					public void setEtcAddress(String etcAddress) {
						this.etcAddress = etcAddress;
					}






























}

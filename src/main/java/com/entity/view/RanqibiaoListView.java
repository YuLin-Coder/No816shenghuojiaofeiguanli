package com.entity.view;

import com.entity.RanqibiaoListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 燃气表缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("ranqibiao_list")
public class RanqibiaoListView extends RanqibiaoListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 ranqibiao
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 燃气表编号
			*/
			private String ranqibiaoNumber;
			/**
			* 燃气表余额
			*/
			private Double ranqibiaoMoney;
			/**
			* 燃气表编号所在地址
			*/
			private String ranqibiaoAddress;

	public RanqibiaoListView() {

	}

	public RanqibiaoListView(RanqibiaoListEntity ranqibiaoListEntity) {
		try {
			BeanUtils.copyProperties(this, ranqibiaoListEntity);
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




























				//级联表的get和set ranqibiao
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
					* 获取： 燃气表编号
					*/
					public String getRanqibiaoNumber() {
						return ranqibiaoNumber;
					}
					/**
					* 设置： 燃气表编号
					*/
					public void setRanqibiaoNumber(String ranqibiaoNumber) {
						this.ranqibiaoNumber = ranqibiaoNumber;
					}
					/**
					* 获取： 燃气表余额
					*/
					public Double getRanqibiaoMoney() {
						return ranqibiaoMoney;
					}
					/**
					* 设置： 燃气表余额
					*/
					public void setRanqibiaoMoney(Double ranqibiaoMoney) {
						this.ranqibiaoMoney = ranqibiaoMoney;
					}
					/**
					* 获取： 燃气表编号所在地址
					*/
					public String getRanqibiaoAddress() {
						return ranqibiaoAddress;
					}
					/**
					* 设置： 燃气表编号所在地址
					*/
					public void setRanqibiaoAddress(String ranqibiaoAddress) {
						this.ranqibiaoAddress = ranqibiaoAddress;
					}














}

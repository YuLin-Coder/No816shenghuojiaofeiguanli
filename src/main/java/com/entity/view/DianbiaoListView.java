package com.entity.view;

import com.entity.DianbiaoListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 电表缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("dianbiao_list")
public class DianbiaoListView extends DianbiaoListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 dianbiao
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 电表编号
			*/
			private String dianbiaoNumber;
			/**
			* 电表余额
			*/
			private Double dianbiaoMoney;
			/**
			* 电表编号所在地址
			*/
			private String dianbiaoAddress;

	public DianbiaoListView() {

	}

	public DianbiaoListView(DianbiaoListEntity dianbiaoListEntity) {
		try {
			BeanUtils.copyProperties(this, dianbiaoListEntity);
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






				//级联表的get和set dianbiao
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
					* 获取： 电表编号
					*/
					public String getDianbiaoNumber() {
						return dianbiaoNumber;
					}
					/**
					* 设置： 电表编号
					*/
					public void setDianbiaoNumber(String dianbiaoNumber) {
						this.dianbiaoNumber = dianbiaoNumber;
					}
					/**
					* 获取： 电表余额
					*/
					public Double getDianbiaoMoney() {
						return dianbiaoMoney;
					}
					/**
					* 设置： 电表余额
					*/
					public void setDianbiaoMoney(Double dianbiaoMoney) {
						this.dianbiaoMoney = dianbiaoMoney;
					}
					/**
					* 获取： 电表编号所在地址
					*/
					public String getDianbiaoAddress() {
						return dianbiaoAddress;
					}
					/**
					* 设置： 电表编号所在地址
					*/
					public void setDianbiaoAddress(String dianbiaoAddress) {
						this.dianbiaoAddress = dianbiaoAddress;
					}




































}

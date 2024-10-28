package com.entity.view;

import com.entity.YoukaListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 油卡缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("youka_list")
public class YoukaListView extends YoukaListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 youka
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 油卡编号
			*/
			private String youkaNumber;
			/**
			* 油卡余额
			*/
			private Double youkaMoney;
			/**
			* 油卡所属公司
			*/
			private Integer youkaTypes;
				/**
				* 油卡所属公司的值
				*/
				private String youkaValue;
			/**
			* 油卡开户地址
			*/
			private String youkaAddress;

	public YoukaListView() {

	}

	public YoukaListView(YoukaListEntity youkaListEntity) {
		try {
			BeanUtils.copyProperties(this, youkaListEntity);
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






































				//级联表的get和set youka
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
					* 获取： 油卡编号
					*/
					public String getYoukaNumber() {
						return youkaNumber;
					}
					/**
					* 设置： 油卡编号
					*/
					public void setYoukaNumber(String youkaNumber) {
						this.youkaNumber = youkaNumber;
					}
					/**
					* 获取： 油卡余额
					*/
					public Double getYoukaMoney() {
						return youkaMoney;
					}
					/**
					* 设置： 油卡余额
					*/
					public void setYoukaMoney(Double youkaMoney) {
						this.youkaMoney = youkaMoney;
					}
					/**
					* 获取： 油卡所属公司
					*/
					public Integer getYoukaTypes() {
						return youkaTypes;
					}
					/**
					* 设置： 油卡所属公司
					*/
					public void setYoukaTypes(Integer youkaTypes) {
						this.youkaTypes = youkaTypes;
					}


						/**
						* 获取： 油卡所属公司的值
						*/
						public String getYoukaValue() {
							return youkaValue;
						}
						/**
						* 设置： 油卡所属公司的值
						*/
						public void setYoukaValue(String youkaValue) {
							this.youkaValue = youkaValue;
						}
					/**
					* 获取： 油卡开户地址
					*/
					public String getYoukaAddress() {
						return youkaAddress;
					}
					/**
					* 设置： 油卡开户地址
					*/
					public void setYoukaAddress(String youkaAddress) {
						this.youkaAddress = youkaAddress;
					}




}

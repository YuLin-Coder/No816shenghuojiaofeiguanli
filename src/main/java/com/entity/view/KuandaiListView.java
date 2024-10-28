package com.entity.view;

import com.entity.KuandaiListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 宽带缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("kuandai_list")
public class KuandaiListView extends KuandaiListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否缴费成功的值
		*/
		private String successValue;



		//级联表 kuandai
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 宽带编号
			*/
			private String kuandaiNumber;
			/**
			* 宽带余额
			*/
			private Double kuandaiMoney;
			/**
			* 宽带编号所在地址
			*/
			private String kuandaiAddress;

	public KuandaiListView() {

	}

	public KuandaiListView(KuandaiListEntity kuandaiListEntity) {
		try {
			BeanUtils.copyProperties(this, kuandaiListEntity);
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
























				//级联表的get和set kuandai
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
					* 获取： 宽带编号
					*/
					public String getKuandaiNumber() {
						return kuandaiNumber;
					}
					/**
					* 设置： 宽带编号
					*/
					public void setKuandaiNumber(String kuandaiNumber) {
						this.kuandaiNumber = kuandaiNumber;
					}
					/**
					* 获取： 宽带余额
					*/
					public Double getKuandaiMoney() {
						return kuandaiMoney;
					}
					/**
					* 设置： 宽带余额
					*/
					public void setKuandaiMoney(Double kuandaiMoney) {
						this.kuandaiMoney = kuandaiMoney;
					}
					/**
					* 获取： 宽带编号所在地址
					*/
					public String getKuandaiAddress() {
						return kuandaiAddress;
					}
					/**
					* 设置： 宽带编号所在地址
					*/
					public void setKuandaiAddress(String kuandaiAddress) {
						this.kuandaiAddress = kuandaiAddress;
					}


















}

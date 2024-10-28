package com.entity.view;

import com.entity.BangzhuzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 帮助中心
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-12
 */
@TableName("bangzhuzhongxin")
public class BangzhuzhongxinView extends BangzhuzhongxinEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 类型的值
		*/
		private String bangzhuzhongxinValue;



	public BangzhuzhongxinView() {

	}

	public BangzhuzhongxinView(BangzhuzhongxinEntity bangzhuzhongxinEntity) {
		try {
			BeanUtils.copyProperties(this, bangzhuzhongxinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getBangzhuzhongxinValue() {
				return bangzhuzhongxinValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setBangzhuzhongxinValue(String bangzhuzhongxinValue) {
				this.bangzhuzhongxinValue = bangzhuzhongxinValue;
			}






















}

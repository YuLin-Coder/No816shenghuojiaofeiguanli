package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ChatEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 客服聊天表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-24 11:35:16
 */
@TableName("chat")
public class ChatView extends ChatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChatView(){
	}
 
 	public ChatView(ChatEntity chatEntity){
 	try {
			BeanUtils.copyProperties(this, chatEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

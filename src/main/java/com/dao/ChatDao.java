package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ChatEntity;
import com.entity.view.ChatView;
import com.entity.vo.ChatVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 客服聊天表
 * 
 * @author 
 * @email 
 * @date 2020-12-24 11:35:16
 */
public interface ChatDao extends BaseMapper<ChatEntity> {
	
	List<ChatVO> selectListVO(@Param("ew") Wrapper<ChatEntity> wrapper);
	
	ChatVO selectVO(@Param("ew") Wrapper<ChatEntity> wrapper);
	
	List<ChatView> selectListView(@Param("ew") Wrapper<ChatEntity> wrapper);

	List<ChatView> selectListView(Pagination page, @Param("ew") Wrapper<ChatEntity> wrapper);
	
	ChatView selectView(@Param("ew") Wrapper<ChatEntity> wrapper);
	
}

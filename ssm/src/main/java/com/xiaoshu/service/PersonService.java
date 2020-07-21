package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.PersonVo;

@Service
public class PersonService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PersonMapper personMapper;
	
	public PageInfo<PersonVo>findPage(PersonVo personVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PersonVo>list=personMapper.findPerson(personVo);
		
		return new PageInfo<>(list);
	}

}

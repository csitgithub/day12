package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CourseMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	public PageInfo<StudentVo> pageAll(StudentVo studentVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> list = studentMapper.pageAll(studentVo);
		return new PageInfo<>(list);
	}
	public void updateBykey(Student student){
		studentMapper.updateByPrimaryKeySelective(student);
	}

	public void add(Student student){
		studentMapper.insert(student);
	}
	public List<Course> findAll(){
		return courseMapper.selectAll();
	}
	
	public Student selectOne(String name){
		Student student = new Student();
		student.setName(name);
		return studentMapper.selectOne(student);
	}
	public	void del(int id){
		studentMapper.deleteByPrimaryKey(id);
	}
}

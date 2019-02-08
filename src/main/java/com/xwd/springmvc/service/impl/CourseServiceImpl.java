package com.xwd.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xwd.springmvc.entity.Chapter;
import com.xwd.springmvc.entity.Course;
import com.xwd.springmvc.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	public Course getCourseById(Integer id) {
		Course course = new Course();
		course.setId(id);
		course.setName("数学");
		course.setImgPath("resources/imgs/course-img.jpg");
		course.setTime(3600);
		course.setLevel(1);
		course.setDescr("数学的奥秘");
		course.setLearningNum(50);
		List<Chapter> list = new ArrayList<Chapter>();
		list.add(new Chapter(1,"chapter1"));
		list.add(new Chapter(2,"chapter2"));
		course.setChapters(list);
		return course;
	}
	
}

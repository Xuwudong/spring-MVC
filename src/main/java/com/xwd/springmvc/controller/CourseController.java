package com.xwd.springmvc.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xwd.springmvc.entity.Course;
import com.xwd.springmvc.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	// @RequestParam用法
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewCourse(@RequestParam("id")Integer id,Model model) {
		log.debug("id : 	{}" , id);
//		System.out.println("id = " + id);
		Course course = courseService.getCourseById(id);
		model.addAttribute(course);
		return "course_overview";
	}
	
	// Restful api @PathVaraible用法
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String viewCourse2(@PathVariable("id")Integer id,Model model) {
		log.debug("id2 :   {}", id);
		Course course = courseService.getCourseById(id);
		model.addAttribute(course);
		return "course_overview";
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET,params="add")
	public String createCourse() {
		return "course_admin/edit";
	}
	
	// @ModelAttribute实现绑定
	// redirect实现重定向
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String doSave(@ModelAttribute Course course) {
		log.debug("Info of Course:");
		log.debug(ReflectionToStringBuilder.toString(course));
		// 业务操作，比如数据库持久化
		course.setId(123);
		return "redirect:view/" + course.getId();
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String showUploadPage() {
		return "course_admin/file";
	}
	
	// 文件上传
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			log.debug("process file:{}",fileName);
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File("C:\\temp\\",System.currentTimeMillis() +fileName));
		}
		return "success";
	}
	
	// json
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Course getCourseInJson(@PathVariable Integer id) {
		return this.courseService.getCourseById(id);
	}
	
	@RequestMapping(value="/resentity/{id}",method=RequestMethod.GET)
	public ResponseEntity<Course> getCourseById2(@PathVariable Integer id){
		Course course = this.courseService.getCourseById(id);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
}

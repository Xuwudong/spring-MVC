package com.xwd.springmvc.entity;

import java.util.List;

public class Course {
	private int id;
	private String name;
	private int time;
	private int level;
	private String descr;
	private int learningNum;
	
	private String imgPath;
	private List<Chapter> chapters;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getLearningNum() {
		return learningNum;
	}
	public void setLearningNum(int learningNum) {
		this.learningNum = learningNum;
	}
	
}

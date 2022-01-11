package com.example.demo.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.topic.Topic;

@Entity
public class Course {
	@Id
	private String id;
	private String name, description;
	@ManyToOne
	private Topic topic;
	
	
	public Course(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Course() {
		
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}

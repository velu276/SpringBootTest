package com.example.demo.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.TopicService;

@RestController
@RequestMapping("topics/{topicId}/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getCourses(topicId);
	}
	
	@RequestMapping("{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(topicService.getTopic(topicId));
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(topicService.getTopic(topicId));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}

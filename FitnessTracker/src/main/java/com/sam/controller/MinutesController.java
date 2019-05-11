package com.sam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.model.Activity;
import com.sam.model.Exercise;
import com.sam.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	ExerciseService exerciseService;
	
	@RequestMapping(value="/addMinutes", method=RequestMethod.GET)
	public String fetchMinutes(Model model) {
		Exercise ex = new Exercise();
		ex.setMinutes(5);
		ex.setActivity("Swim");
		model.addAttribute("exercise", ex);
		return "addMinutes";
		
	}
	
	@RequestMapping(value="/addMinutes", method=RequestMethod.POST)
	public String addMinutes(
			@ModelAttribute("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise type: " + exercise.getActivity());
		return "addMinutes";
		
	}
	
	@RequestMapping(value="/activities", method= RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		
		return exerciseService.findAllActivities();
		
	}
	
//	@RequestMapping(value="/addMoreMinutes")
//	public String addMoreMinutes(
//			@ModelAttribute("exercise") Exercise exercise) {
//		
//		System.out.println("exercising: " + exercise.getMinutes());
//		return "addMinutes";
//		
//	}
	
}

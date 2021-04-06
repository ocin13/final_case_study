package com.casestudy.caseStudy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.caseStudy.entityModels.Statistics;
import com.casestudy.caseStudy.services.StatisticsService;

@RestController
public class StatisticController {
	
	@Autowired
	StatisticsService ss;
	
	@GetMapping("/statistics")
	public Statistics sendStatisticsData() throws IOException {
		return ss.getStatistics();
	}
}

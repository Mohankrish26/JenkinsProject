package org.base;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class CucumberJvmReport {
public static void generateReport(String json) {

	File f = new File("C:\\Users\\91770\\eclipse-workspace\\OmrCucumber\\src\\test\\resources\\Report");
	
	Configuration config = new Configuration(f, "CucumberReport");
	
	config.addClassifications("Browser", "Chrome");
	config.addClassifications("Platform", "Windows");
	config.addClassifications("Build", "2.4.6");
	
	List<String> li = new LinkedList<String>();
	li.add(json);
	
	ReportBuilder rep = new ReportBuilder(li, config);
	rep.generateReports();
	
	
	
	
	
	
	
	
	
	
}
}

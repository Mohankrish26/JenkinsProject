package org.omrcucumber;

import org.base.CucumberJvmReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\91770\\eclipse-workspace\\OmrCucumber\\src\\test\\resources\\Features\\OmrFeature.feature", glue = "org.omrcucumber", plugin = {"pretty", "json:C:\\Users\\91770\\eclipse-workspace\\OmrCucumber\\src\\test\\resources\\Report\\report.json"})
public class RunnerClass {
	@AfterClass
	public static void jvmReport() {

		CucumberJvmReport.generateReport("C:\\Users\\91770\\eclipse-workspace\\OmrCucumber\\src\\test\\resources\\Report\\report.json");
		
	}
	
	
}

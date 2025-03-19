package com.biryani.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.biryani.stepdefinitions",
    		plugin = {
    		        "json:target/surefire-reports/cucumber.json" // Generate JSON report
    		    }
)
public class TestRunner {
}
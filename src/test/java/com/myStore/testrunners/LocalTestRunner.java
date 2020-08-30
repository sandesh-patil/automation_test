package com.myStore.testrunners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@ExtendedCucumberOptions(
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        outputFolder = "target/")

@CucumberOptions(
        plugin = {"pretty", "json:target/report.json", "cucumber-reporting:target/pretty-cucumber",
                "html:target/cucumber-reports" },

        features = {"src/test/resources/features"},
        monochrome = true,

        glue = {"classpath:com.myStore.stepdefinitions"},
        tags={"@myStore11"})
//tags={"~@wip", "~@widget","@priority", "@envall,@production", "~@local"})

//Important: This test runner is the only test engine in Maven test.
@RunWith(ExtendedCucumber.class)
public class LocalTestRunner {


}

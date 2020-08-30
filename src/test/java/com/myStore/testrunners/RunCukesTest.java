package com.myStore.testrunners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@ExtendedCucumberOptions(
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        outputFolder = "target/extendedCucumber/")



@CucumberOptions(  plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
        "rerun:target/rerun.txt"},
        monochrome = true,

        features = {"src/test/resources/features"},

        glue = {"classpath:com.myStore.stepdefinitions"},
        tags={"@myStore11"})


@RunWith(ExtendedCucumber.class)
public class RunCukesTest {



}

package com.search.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/reports"},
        features = {"src/test/resources/features"},
        glue = "com/search/stepDef",
        tags = "@test"
)

public class Runner {

}

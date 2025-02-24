package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepDefinitions"},
    tags = "@activity2",
    strict = true
)

public class ActivitiesRunner {
    //empty
}

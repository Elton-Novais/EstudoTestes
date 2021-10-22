package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Sempre IT\\IdeaProjects\\br.com.netshoes\\src\\test\\java\\feature",
                glue = "passos", plugin = {"pretty"})
public class Runner {
}

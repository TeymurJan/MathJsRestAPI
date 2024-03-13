import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "resources.stepdefinitions",
        plugin = {
                "pretty",
                "json:reports/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner {
    public static void main(String[] args) throws Throwable {
        try {
            System.setProperty("log4j.configuration", "log4j.xml");
            // Define your Cucumber command line arguments as elements in the arguments array
            String[] arguments = {
                    "--glue", "resources.stepdefinitions", // Specify the package containing your step definitions
                    "--plugin", "pretty", // Specify the pretty formatter for readable output
                    "--plugin", "json:reports/cucumber-report/cucumber.json", // Specify JSON formatter for reporting
                    "--plugin", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Specify ExtentReports plugin
                    "--tags", "not @ignore", //Specify the features you want to run
                    "classpath:/features" // Specify the path to your feature files
            };
            Main.main(arguments);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Main method exception: " + e);
        }
    }
}
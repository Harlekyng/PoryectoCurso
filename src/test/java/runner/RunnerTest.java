package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Test",  //Ejecutar varios casos colocar tag ej: "@TSCID782053" Excluir con "~@TAG"
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerTest {

}

/*
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps"
)
public class Runner {

}
*/
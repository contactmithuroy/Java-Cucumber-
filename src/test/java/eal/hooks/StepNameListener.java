package eal.hooks;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepStarted;
import io.cucumber.plugin.event.PickleStepTestStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eal.utilities.LogColor;


/*
Its main purpose is to:
Improve test execution visibility
Clearly show which step is currently running
Make logs readable and traceable during debugging
 
This listener logs the currently executing Cucumber step name, improving traceability and debugging during test execution.

 */
public class StepNameListener implements ConcurrentEventListener {
    private String currentStepName;
    public static final Logger logger = LogManager.getLogger(StepNameListener.class);

    private EventHandler<TestStepStarted> stepHandler = event -> {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            currentStepName = testStep.getStep().getText();
            printStepName(currentStepName);

        }
    };

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, stepHandler);
    }
    
    
    private void printStepName(String currentStepName) {
        System.out.println("  ");
        System.out.println("  ");
        logger.info(LogColor.DarkOrange+"================================================================"+LogColor.RESET);
        logger.warn(LogColor.DarkOrange+"Executing step: " + currentStepName);
        logger.info(LogColor.DarkOrange+"================================================================"+LogColor.RESET);
        System.out.println("  ");
    	
    }
}
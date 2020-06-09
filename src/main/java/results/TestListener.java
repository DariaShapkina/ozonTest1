package results;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pretraining.Screenshot;


public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result){
        Screenshot.takeScreen();
    }
}

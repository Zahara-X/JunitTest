package selenium.retrying;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class RetryWatcher implements TestWatcher {
    private final int COUNT_RETRY = 3;
    private int count = 0;
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
         if(count < COUNT_RETRY) {
             System.out.println("Failed");
             count++;
         }
    }
}
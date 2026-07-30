package selenium.retrying;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class Retry implements TestWatcher {
    private final int COUNT_RETRY = 3;
    private int count = 0;
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Failed");
    }
}
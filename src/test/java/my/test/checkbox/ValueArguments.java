package my.test.checkbox;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class ValueArguments {
    private static final List<List<String>> switchers = List.of(
            List.of("Home", "Desktop", "Documents", "WorkSpace", "Office", "Downloads"),
            List.of("Downloads", "Office", "WorkSpace", "Documents", "Desktop", "Home"));
    private static final List<String> checkBox = List.of(
            "Notes", "Commands", "React", "Angular", "Veu", "Public", "Private", "Classified", "General", "Word File.doc", "Excel File.doc");

    private static final String format = "//div[contains(@class, 'rc-tree-treenode') and not(contains(@class, 'switcher_open')) and .//span[text()='%s']]/span[contains(@class, 'rc-tree-switcher')]";
    private static final String format_2 = "//div[contains(@class, 'rc-tree-treenode') and not(contains(@class, 'switcher_close')) and .//span[text()='%s']]/span[contains(@class, 'rc-tree-switcher')]";
    private static final String format_3 = "//div[contains(@class, 'rc-tree-treenode') and .//span[text()='%s']]/span[contains(@class, 'rc-tree-checkbox')]";
    public static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of(format, format_2, format_3, switchers, checkBox));
    }
}
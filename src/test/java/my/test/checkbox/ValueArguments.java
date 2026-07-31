package my.test.checkbox;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;
@Getter
@Setter
public class ValueArguments {
    private List<List<String>> switchers;
    private List<String> checksBox;
    private String switcher, checkbox, result;
    private String data = """
            You have selected :
            home
            desktop
            documents
            downloads
            notes
            commands
            workspace
            office
            wordFile
            excelFile
            react
            angular
            veu
            public
            private
            classified
            general
            """;

    public ValueArguments() {
        this.switchers = List.of(List.of("Home", "Desktop", "Documents", "WorkSpace", "Office", "Downloads"),
                         List.of("Downloads", "Office", "WorkSpace", "Documents", "Desktop", "Home"));

        this.checksBox = List.of(
                "Notes", "Commands", "React", "Angular", "Veu", "Public", "Private", "Classified", "General", "Word File.doc", "Excel File.doc");
        this.switcher = "//div[contains(@class, 'rc-tree-treenode') and not(contains(@class, 'switcher_open')) and .//span[text()='%s']]/span[contains(@class, 'rc-tree-switcher')]";
        this.checkbox = "//div[contains(@class, 'rc-tree-treenode') and .//span[text()='%s']]/span[contains(@class, 'rc-tree-checkbox')]";
        this.result = "//div[@id='result']";
    }
    public static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of(new ValueArguments(), new ValueArguments()));
    }
}
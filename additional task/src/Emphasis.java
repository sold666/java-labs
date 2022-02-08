import java.util.List;

public class Emphasis extends AbstractMarkdown {
    public Emphasis(List<MarkDown> body) {
        super("*", body);
    }
}

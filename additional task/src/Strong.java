import java.util.List;

public class Strong extends AbstractMarkdown{
    public Strong(List<MarkDown> body) {
        super("__", body);
    }
}

import java.util.List;

public class Strikeout extends AbstractMarkdown{
    public Strikeout(List<MarkDown> body) {
        super("~", body);
    }
}

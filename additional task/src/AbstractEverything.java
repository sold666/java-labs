import java.util.List;

public class AbstractEverything implements MarkDown {
    String str;
    List<MarkDown> list;

    public AbstractEverything(String s_m, List<MarkDown> body) {
        this.str = s_m;
        this.list = body;
    }

    public void toMarkdown(StringBuilder ss) {
        ss.append(str);
        for (MarkDown m : list) {
            m.toMarkdown(ss);
        }
        ss.append(str);
    }
}
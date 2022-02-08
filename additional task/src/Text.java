public class Text implements MarkDown {
    String currentData;

    public Text(String s) {
        this.currentData = s;
    }
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(currentData);
    }
}

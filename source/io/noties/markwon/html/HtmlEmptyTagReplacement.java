package io.noties.markwon.html;

public class HtmlEmptyTagReplacement {
    public String a(b bVar) {
        String name = bVar.name();
        if (TtmlNode.TAG_BR.equals(name)) {
            return "\n";
        }
        if ("img".equals(name)) {
            String str = bVar.b().get("alt");
            if (str == null || str.length() == 0) {
                return "￼";
            }
            return str;
        } else if ("iframe".equals(name)) {
            return " ";
        } else {
            return null;
        }
    }
}

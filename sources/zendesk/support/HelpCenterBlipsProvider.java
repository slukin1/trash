package zendesk.support;

public interface HelpCenterBlipsProvider {
    void articleView(Article article);

    void articleVote(Long l11, int i11);

    void helpCenterSearch(String str);
}

package zendesk.support;

import com.google.gson.annotations.SerializedName;
import zendesk.core.Settings;

public class HelpCenterSettings implements Settings {
    private static HelpCenterSettings DEFAULT = new HelpCenterSettings();
    @SerializedName("help_center_article_voting_enabled")
    private boolean articleVotingEnabled;
    private boolean enabled;
    private String locale;

    public HelpCenterSettings(boolean z11, boolean z12, String str) {
        this.enabled = z11;
        this.articleVotingEnabled = z12;
        this.locale = str;
    }

    public static HelpCenterSettings defaultSettings() {
        return DEFAULT;
    }

    public String getLocale() {
        return this.locale;
    }

    public boolean isArticleVotingEnabled() {
        return this.articleVotingEnabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public HelpCenterSettings() {
    }
}

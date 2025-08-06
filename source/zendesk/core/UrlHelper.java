package zendesk.core;

public class UrlHelper {
    public static boolean isGuideRequest(String str) {
        return str.contains("/api/v2/help_center") || str.contains("/hc/api") || str.contains("/api/mobile/help_center");
    }

    public static boolean isVoteRequest(String str) {
        return str.contains("/up.json") || str.contains("/down.json") || str.contains("/api/v2/help_center/votes/");
    }
}

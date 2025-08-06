package zendesk.support;

class ConversationsSettings {
    private static ConversationsSettings DEFAULT = new ConversationsSettings(false);
    private boolean enabled;

    public ConversationsSettings(boolean z11) {
        this.enabled = z11;
    }

    public static ConversationsSettings defaultSettings() {
        return DEFAULT;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public ConversationsSettings() {
    }
}

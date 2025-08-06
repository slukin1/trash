package zendesk.support;

public class TicketFormSettings {
    private static TicketFormSettings DEFAULT = new TicketFormSettings(false);
    private boolean available;

    public TicketFormSettings(boolean z11) {
        this.available = z11;
    }

    public static TicketFormSettings defaultSettings() {
        return DEFAULT;
    }

    public boolean isAvailable() {
        return this.available;
    }
}

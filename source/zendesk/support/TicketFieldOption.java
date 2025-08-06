package zendesk.support;

public class TicketFieldOption {

    /* renamed from: id  reason: collision with root package name */
    private long f62959id;
    private boolean isDefault;
    private String name;
    private String value;

    public TicketFieldOption(long j11, String str, String str2, boolean z11) {
        this.f62959id = j11;
        this.name = str;
        this.value = str2;
        this.isDefault = z11;
    }

    public static TicketFieldOption create(RawTicketFieldOption rawTicketFieldOption) {
        return new TicketFieldOption(rawTicketFieldOption.getId(), rawTicketFieldOption.getName(), rawTicketFieldOption.getValue(), rawTicketFieldOption.isDefault());
    }

    public long getId() {
        return this.f62959id;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isDefault() {
        return this.isDefault;
    }
}

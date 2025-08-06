package zendesk.support;

import com.google.gson.annotations.SerializedName;

class RawTicketFieldOption {

    /* renamed from: id  reason: collision with root package name */
    private long f62950id;
    @SerializedName("default")
    private boolean isDefault;
    private String name;
    private String rawName;
    private String value;

    public static TicketFieldOption create(RawTicketFieldOption rawTicketFieldOption) {
        return new TicketFieldOption(rawTicketFieldOption.getId(), rawTicketFieldOption.getName(), rawTicketFieldOption.getValue(), rawTicketFieldOption.isDefault());
    }

    public long getId() {
        return this.f62950id;
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

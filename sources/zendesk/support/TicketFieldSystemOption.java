package zendesk.support;

public class TicketFieldSystemOption {
    private String name;
    private String value;

    public TicketFieldSystemOption(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public static TicketFieldSystemOption create(RawTicketFieldSystemOption rawTicketFieldSystemOption) {
        return new TicketFieldSystemOption(rawTicketFieldSystemOption.getName(), rawTicketFieldSystemOption.getValue());
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}

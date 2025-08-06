package zendesk.support;

import java.util.List;
import mz.a;

public class TicketForm {

    /* renamed from: id  reason: collision with root package name */
    private long f62960id;
    private String name;
    private List<TicketField> ticketFields;

    public TicketForm(long j11, String str, List<TicketField> list) {
        this.f62960id = j11;
        this.name = str;
        this.ticketFields = a.c(list);
    }

    public long getId() {
        return this.f62960id;
    }

    public String getName() {
        return this.name;
    }

    public List<TicketField> getTicketFields() {
        return a.c(this.ticketFields);
    }
}

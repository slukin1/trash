package zendesk.support;

import java.util.List;
import mz.a;

class RawTicketFormResponse {
    private List<RawTicketField> ticketFields;
    private List<RawTicketForm> ticketForms;

    public List<RawTicketField> getTicketFields() {
        return a.c(this.ticketFields);
    }

    public List<RawTicketForm> getTicketForms() {
        return a.c(this.ticketForms);
    }
}

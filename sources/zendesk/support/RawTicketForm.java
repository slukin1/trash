package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import mz.a;

class RawTicketForm {
    private Date createdAt;
    private boolean endUserVisible;

    /* renamed from: id  reason: collision with root package name */
    private long f62951id;
    private boolean inAllBrands;
    private boolean inAllOrganizations;
    @SerializedName("active")
    private boolean isActive;
    @SerializedName("default")
    private boolean isDefault;
    private String name;
    private int position;
    private String rawDisplayName;
    private String rawName;
    private List<Long> restrictedBrandIds;
    private List<Long> restrictedOrganizationIds;
    private List<Long> ticketFieldIds;
    private Date updatedAt;
    private String url;

    public static TicketForm create(RawTicketForm rawTicketForm, List<TicketField> list) {
        return new TicketForm(rawTicketForm.getId(), rawTicketForm.getName(), list);
    }

    public long getId() {
        return this.f62951id;
    }

    public String getName() {
        return this.name;
    }

    public List<Long> getTicketFieldIds() {
        return a.c(this.ticketFieldIds);
    }
}

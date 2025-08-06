package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import mz.a;

class RawTicketField {
    private long accountId;
    @SerializedName("isActive")
    private boolean active;
    @SerializedName("isCollapsedForAgents")
    private boolean collapsedForAgents;
    private Date createdAt;
    private List<RawTicketFieldOption> customFieldOptions;
    private String defaultContentKey;
    private String description;
    @SerializedName("isEditableInPortal")
    private boolean editableInPortal;
    @SerializedName("isExportable")
    private boolean exportable;

    /* renamed from: id  reason: collision with root package name */
    private long f62949id;
    private int position;
    private String regexpForValidation;
    @SerializedName("isRequired")
    private boolean required;
    @SerializedName("isRequiredInPortal")
    private boolean requiredInPortal;
    private long subTypeId;
    private List<RawTicketFieldSystemOption> systemFieldOptions;
    private String tag;
    private String title;
    private String titleInPortal;
    private TicketFieldType type;
    private Date updatedAt;
    @SerializedName("isVisibleInPortal")
    private boolean visibleInPortal;

    public List<RawTicketFieldOption> getCustomFieldOptions() {
        return a.c(this.customFieldOptions);
    }

    public String getDescription() {
        return this.description;
    }

    public long getId() {
        return this.f62949id;
    }

    public String getRegexpForValidation() {
        return this.regexpForValidation;
    }

    public List<RawTicketFieldSystemOption> getSystemFieldOptions() {
        return a.c(this.systemFieldOptions);
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleInPortal() {
        return this.titleInPortal;
    }

    public TicketFieldType getType() {
        return this.type;
    }
}

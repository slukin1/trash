package zendesk.support;

import java.util.Date;
import java.util.List;
import mz.a;

public class Request {
    private List<Long> collaboratorIds;
    private EndUserComment comment;
    private Integer commentCount;
    private Date createdAt;
    private List<CustomField> customFields;
    private String description;
    private Date dueAt;
    private Comment firstComment;

    /* renamed from: id  reason: collision with root package name */
    private String f62952id;
    private Comment lastComment;
    private List<User> lastCommentingAgents;
    private List<Long> lastCommentingAgentsIds;
    private Long organizationId;
    private String priority;
    private Date publicUpdatedAt;
    private Long requesterId;
    private RequestStatus status;
    private String subject;
    private String type;
    private Date updatedAt;
    private String url;

    public Request() {
    }

    public List<Long> getCollaboratorIds() {
        return a.c(this.collaboratorIds);
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }

    public Date getCreatedAt() {
        if (this.createdAt == null) {
            return null;
        }
        return new Date(this.createdAt.getTime());
    }

    public List<CustomField> getCustomFields() {
        return this.customFields;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDueAt() {
        if (this.dueAt == null) {
            return null;
        }
        return new Date(this.dueAt.getTime());
    }

    public Comment getFirstComment() {
        return this.firstComment;
    }

    public String getId() {
        return this.f62952id;
    }

    public Comment getLastComment() {
        return this.lastComment;
    }

    public List<User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    public List<Long> getLastCommentingAgentsIds() {
        return a.c(this.lastCommentingAgentsIds);
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public String getPriority() {
        return this.priority;
    }

    public Date getPublicUpdatedAt() {
        if (this.publicUpdatedAt == null) {
            return getUpdatedAt();
        }
        return new Date(this.publicUpdatedAt.getTime());
    }

    public Long getRequesterId() {
        return this.requesterId;
    }

    public RequestStatus getStatus() {
        return this.status;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        if (this.updatedAt == null) {
            return null;
        }
        return new Date(this.updatedAt.getTime());
    }

    public String getUrl() {
        return this.url;
    }

    public void setComment(EndUserComment endUserComment) {
        this.comment = endUserComment;
    }

    public void setLastCommentingAgents(List<User> list) {
        this.lastCommentingAgents = list;
    }

    public Request(String str, RequestStatus requestStatus) {
        this.f62952id = str;
        this.status = requestStatus;
    }
}

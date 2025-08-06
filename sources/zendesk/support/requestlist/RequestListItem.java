package zendesk.support.requestlist;

import java.util.Date;
import java.util.List;
import mz.a;
import mz.f;
import zendesk.support.request.RequestConfiguration;
import zendesk.support.requestlist.RequestInfo;

class RequestListItem {
    private final RequestInfo requestInfo;

    public RequestListItem(RequestInfo requestInfo2) {
        this.requestInfo = requestInfo2;
    }

    public RequestConfiguration.Builder configure(RequestConfiguration.Builder builder) {
        return builder.withRequestInfo(this.requestInfo);
    }

    public String getAvatar() {
        return hasAgentReplied() ? this.requestInfo.getAgentInfos().get(0).getAvatar() : "";
    }

    public String getFirstMessage() {
        return this.requestInfo.getFirstMessageInfo().getBody();
    }

    public long getItemId() {
        int i11;
        String localId = this.requestInfo.getLocalId();
        String remoteId = this.requestInfo.getRemoteId();
        if (f.c(localId)) {
            i11 = localId.hashCode();
        } else {
            i11 = remoteId.hashCode();
        }
        return (long) i11;
    }

    public List<String> getLastCommentingAgentNames() {
        return a.k(this.requestInfo.getAgentInfos(), new jz.a<RequestInfo.AgentInfo, String>() {
            public String apply(RequestInfo.AgentInfo agentInfo) {
                return agentInfo.getName();
            }
        });
    }

    public String getLastMessage() {
        return this.requestInfo.getLastMessageInfo().getBody();
    }

    public Date getLastUpdated() {
        return this.requestInfo.getLastUpdated();
    }

    public boolean hasAgentReplied() {
        return a.i(this.requestInfo.getAgentInfos());
    }

    public boolean isClosed() {
        return this.requestInfo.isClosed();
    }

    public boolean isFailed() {
        return a.i(this.requestInfo.getFailedMessageIds());
    }

    public boolean isUnread() {
        return this.requestInfo.isUnread();
    }
}

package zendesk.support.requestlist;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import zendesk.support.RequestStatus;

public class RequestInfo {
    private final List<AgentInfo> agentInfos;
    private final Set<String> failedMessageIds;
    private final MessageInfo firstMessageInfo;
    private final MessageInfo lastMessageInfo;
    private final Date lastUpdated;
    private final String localId;
    private final String remoteId;
    private final RequestStatus requestStatus;
    private final boolean unread;

    public static class AgentInfo {
        private final String avatar;

        /* renamed from: id  reason: collision with root package name */
        private final String f62987id;
        private final String name;

        public AgentInfo(String str, String str2, String str3) {
            this.f62987id = str;
            this.name = str2;
            this.avatar = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AgentInfo agentInfo = (AgentInfo) obj;
            String str = this.f62987id;
            if (str == null ? agentInfo.f62987id != null : !str.equals(agentInfo.f62987id)) {
                return false;
            }
            String str2 = this.name;
            if (str2 == null ? agentInfo.name != null : !str2.equals(agentInfo.name)) {
                return false;
            }
            String str3 = this.avatar;
            String str4 = agentInfo.avatar;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
            return false;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getId() {
            return this.f62987id;
        }

        public String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.f62987id;
            int i11 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.avatar;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode2 + i11;
        }
    }

    public static class LastUpdatedComparator implements Comparator<RequestInfo> {
        public int compare(RequestInfo requestInfo, RequestInfo requestInfo2) {
            if (requestInfo2 == null) {
                return 1;
            }
            if (requestInfo.getLastUpdated() == null) {
                return requestInfo2.getLastUpdated() == null ? 0 : -1;
            }
            if (requestInfo2.getLastUpdated() == null) {
                return 1;
            }
            return requestInfo2.getLastUpdated().compareTo(requestInfo.getLastUpdated());
        }
    }

    public static class MessageInfo {
        private final String body;
        private final Date date;

        /* renamed from: id  reason: collision with root package name */
        private final String f62988id;

        public MessageInfo(String str, Date date2, String str2) {
            this.f62988id = str;
            this.date = date2;
            this.body = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MessageInfo messageInfo = (MessageInfo) obj;
            String str = this.f62988id;
            if (str == null ? messageInfo.f62988id != null : !str.equals(messageInfo.f62988id)) {
                return false;
            }
            Date date2 = this.date;
            if (date2 == null ? messageInfo.date != null : !date2.equals(messageInfo.date)) {
                return false;
            }
            String str2 = this.body;
            String str3 = messageInfo.body;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
            return false;
        }

        public String getBody() {
            return this.body;
        }

        public Date getDate() {
            return this.date;
        }

        public String getId() {
            return this.f62988id;
        }

        public int hashCode() {
            String str = this.f62988id;
            int i11 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Date date2 = this.date;
            int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
            String str2 = this.body;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }
    }

    public RequestInfo(String str, String str2, RequestStatus requestStatus2, boolean z11, Date date, List<AgentInfo> list, MessageInfo messageInfo, MessageInfo messageInfo2, Set<String> set) {
        this.localId = str;
        this.remoteId = str2;
        this.requestStatus = requestStatus2;
        this.unread = z11;
        this.lastUpdated = date;
        this.agentInfos = list;
        this.firstMessageInfo = messageInfo;
        this.lastMessageInfo = messageInfo2;
        this.failedMessageIds = set;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RequestInfo requestInfo = (RequestInfo) obj;
        if (this.unread != requestInfo.unread) {
            return false;
        }
        String str = this.localId;
        if (str == null ? requestInfo.localId != null : !str.equals(requestInfo.localId)) {
            return false;
        }
        String str2 = this.remoteId;
        if (str2 == null ? requestInfo.remoteId != null : !str2.equals(requestInfo.remoteId)) {
            return false;
        }
        if (this.requestStatus != requestInfo.requestStatus) {
            return false;
        }
        Date date = this.lastUpdated;
        if (date == null ? requestInfo.lastUpdated != null : !date.equals(requestInfo.lastUpdated)) {
            return false;
        }
        List<AgentInfo> list = this.agentInfos;
        if (list == null ? requestInfo.agentInfos != null : !list.equals(requestInfo.agentInfos)) {
            return false;
        }
        MessageInfo messageInfo = this.firstMessageInfo;
        if (messageInfo == null ? requestInfo.firstMessageInfo != null : !messageInfo.equals(requestInfo.firstMessageInfo)) {
            return false;
        }
        MessageInfo messageInfo2 = this.lastMessageInfo;
        if (messageInfo2 == null ? requestInfo.lastMessageInfo != null : !messageInfo2.equals(requestInfo.lastMessageInfo)) {
            return false;
        }
        Set<String> set = this.failedMessageIds;
        if (set != null) {
            return set.equals(requestInfo.failedMessageIds);
        }
        if (requestInfo.failedMessageIds == null) {
            return true;
        }
        return false;
    }

    public List<AgentInfo> getAgentInfos() {
        return this.agentInfos;
    }

    public Set<String> getFailedMessageIds() {
        return this.failedMessageIds;
    }

    public MessageInfo getFirstMessageInfo() {
        return this.firstMessageInfo;
    }

    public MessageInfo getLastMessageInfo() {
        return this.lastMessageInfo;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getRemoteId() {
        return this.remoteId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public int hashCode() {
        String str = this.localId;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.remoteId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        RequestStatus requestStatus2 = this.requestStatus;
        int hashCode3 = (((hashCode2 + (requestStatus2 != null ? requestStatus2.hashCode() : 0)) * 31) + (this.unread ? 1 : 0)) * 31;
        Date date = this.lastUpdated;
        int hashCode4 = (hashCode3 + (date != null ? date.hashCode() : 0)) * 31;
        List<AgentInfo> list = this.agentInfos;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        MessageInfo messageInfo = this.firstMessageInfo;
        int hashCode6 = (hashCode5 + (messageInfo != null ? messageInfo.hashCode() : 0)) * 31;
        MessageInfo messageInfo2 = this.lastMessageInfo;
        int hashCode7 = (hashCode6 + (messageInfo2 != null ? messageInfo2.hashCode() : 0)) * 31;
        Set<String> set = this.failedMessageIds;
        if (set != null) {
            i11 = set.hashCode();
        }
        return hashCode7 + i11;
    }

    public boolean isClosed() {
        return RequestStatus.Closed.equals(this.requestStatus);
    }

    public boolean isUnread() {
        return this.unread;
    }
}

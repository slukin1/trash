package zendesk.support.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zendesk.support.RequestStatus;
import zendesk.support.suas.State;

class StateConversation implements Serializable {
    private final StateIdMapper attachmentIdMapper;
    private final boolean hasAgentReplies;
    private final String localId;
    private final StateIdMapper messageIdMapper;
    private final List<StateMessage> messages;
    private final String remoteId;
    private final RequestStatus status;
    private final List<StateRequestUser> users;

    public static class Builder {
        private StateIdMapper attachmentIdMapper;
        private boolean hasAgentReplies;
        private String localId;
        private StateIdMapper messageIdMapper;
        private List<StateMessage> messages;
        private String remoteId;
        private RequestStatus status;
        private List<StateRequestUser> users;

        public StateConversation build() {
            return new StateConversation(this.localId, this.remoteId, this.status, this.hasAgentReplies, this.messages, this.users, this.attachmentIdMapper, this.messageIdMapper);
        }

        public Builder setAttachmentIdMapper(StateIdMapper stateIdMapper) {
            this.attachmentIdMapper = stateIdMapper;
            return this;
        }

        public Builder setHasAgentReplies(boolean z11) {
            this.hasAgentReplies = z11;
            return this;
        }

        public Builder setLocalId(String str) {
            this.localId = str;
            return this;
        }

        public Builder setMessageIdMapper(StateIdMapper stateIdMapper) {
            this.messageIdMapper = stateIdMapper;
            return this;
        }

        public Builder setMessages(List<StateMessage> list) {
            this.messages = list;
            return this;
        }

        public Builder setRemoteId(String str) {
            this.remoteId = str;
            return this;
        }

        public Builder setStatus(RequestStatus requestStatus) {
            this.status = requestStatus;
            return this;
        }

        public Builder setUsers(List<StateRequestUser> list) {
            this.users = list;
            if (!this.hasAgentReplies) {
                this.hasAgentReplies = StateRequestUser.containsAgent(list);
            }
            return this;
        }

        private Builder(String str, String str2, RequestStatus requestStatus, boolean z11, List<StateMessage> list, List<StateRequestUser> list2, StateIdMapper stateIdMapper, StateIdMapper stateIdMapper2) {
            this.localId = str;
            this.remoteId = str2;
            this.status = requestStatus;
            this.hasAgentReplies = z11;
            this.messages = list;
            this.users = list2;
            this.attachmentIdMapper = stateIdMapper;
            this.messageIdMapper = stateIdMapper2;
        }
    }

    public static StateConversation fromState(State state) {
        StateConversation stateConversation = (StateConversation) state.getState(StateConversation.class);
        if (stateConversation != null) {
            return stateConversation;
        }
        return new StateConversation();
    }

    public StateIdMapper getAttachmentIdMapper() {
        return this.attachmentIdMapper;
    }

    public String getLocalId() {
        return this.localId;
    }

    public StateIdMapper getMessageIdMapper() {
        return this.messageIdMapper;
    }

    public List<StateMessage> getMessages() {
        return this.messages;
    }

    public String getRemoteId() {
        return this.remoteId;
    }

    public RequestStatus getStatus() {
        return this.status;
    }

    public List<StateRequestUser> getUsers() {
        return this.users;
    }

    public boolean hasAgentReplies() {
        return this.hasAgentReplies;
    }

    public Builder newBuilder() {
        return new Builder(this.localId, this.remoteId, this.status, this.hasAgentReplies, this.messages, this.users, this.attachmentIdMapper, this.messageIdMapper);
    }

    public String toString() {
        return "Conversation{localId='" + this.localId + '\'' + ", remoteId='" + this.remoteId + '\'' + ", messages=" + this.messages + ", users=" + this.users + ", attachmentIdMapper=" + this.attachmentIdMapper + ", messageIdMapper=" + this.messageIdMapper + '}';
    }

    private StateConversation(String str, String str2, RequestStatus requestStatus, boolean z11, List<StateMessage> list, List<StateRequestUser> list2, StateIdMapper stateIdMapper, StateIdMapper stateIdMapper2) {
        this.localId = str;
        this.remoteId = str2;
        this.status = requestStatus;
        this.hasAgentReplies = z11;
        this.messages = list;
        this.users = list2;
        this.attachmentIdMapper = stateIdMapper;
        this.messageIdMapper = stateIdMapper2;
    }

    public StateConversation() {
        this.localId = "";
        this.remoteId = "";
        this.status = null;
        this.hasAgentReplies = false;
        this.messages = new ArrayList();
        this.users = new ArrayList();
        this.attachmentIdMapper = new StateIdMapper();
        this.messageIdMapper = new StateIdMapper();
    }
}

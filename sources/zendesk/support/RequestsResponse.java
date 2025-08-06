package zendesk.support;

import java.util.List;
import mz.a;

class RequestsResponse extends ResponseWrapper {
    private List<User> lastCommentingAgents;
    private List<Request> requests;

    public List<User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    public List<Request> getRequests() {
        return a.c(this.requests);
    }
}

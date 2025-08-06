package zendesk.support;

import java.util.List;
import mz.a;

class RequestResponse {
    private List<User> lastCommentingAgents;
    private Request request;

    public List<User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    public Request getRequest() {
        return this.request;
    }
}

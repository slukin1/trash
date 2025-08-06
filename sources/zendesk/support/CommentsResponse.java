package zendesk.support;

import java.util.List;
import mz.a;

public class CommentsResponse extends ResponseWrapper {
    private List<CommentResponse> comments;
    private List<Organization> organizations;
    private List<User> users;

    public List<CommentResponse> getComments() {
        return a.c(this.comments);
    }

    public List<Organization> getOrganizations() {
        return a.c(this.organizations);
    }

    public List<User> getUsers() {
        return a.c(this.users);
    }
}

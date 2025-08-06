package zendesk.support;

import com.zendesk.service.ZendeskCallback;
import java.util.Date;
import java.util.List;

public interface RequestProvider {
    void addComment(String str, EndUserComment endUserComment, ZendeskCallback<Comment> zendeskCallback);

    void createRequest(CreateRequest createRequest, ZendeskCallback<Request> zendeskCallback);

    void getAllRequests(ZendeskCallback<List<Request>> zendeskCallback);

    void getComments(String str, ZendeskCallback<CommentsResponse> zendeskCallback);

    void getCommentsSince(String str, Date date, boolean z11, ZendeskCallback<CommentsResponse> zendeskCallback);

    void getRequest(String str, ZendeskCallback<Request> zendeskCallback);

    void getRequests(String str, ZendeskCallback<List<Request>> zendeskCallback);

    void getTicketFormsById(List<Long> list, ZendeskCallback<List<TicketForm>> zendeskCallback);

    void getUpdatesForDevice(ZendeskCallback<RequestUpdates> zendeskCallback);

    void markRequestAsRead(String str, int i11);

    void markRequestAsUnread(String str);
}

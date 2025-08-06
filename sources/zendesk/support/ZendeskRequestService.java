package zendesk.support;

import com.zendesk.service.ZendeskCallback;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import lz.c;

class ZendeskRequestService {
    private static final String LOG_TAG = "ZendeskRequestService";
    private static final String ROLE_AGENT = "agent";
    private static final String ROLE_USER = "end_user";
    private static final String TICKET_FIELDS_INCLUDE = "ticket_fields";
    private final DateFormat iso8601;
    private final c.b<RequestResponse, Request> requestExtractor = new c.b<RequestResponse, Request>() {
        public Request extract(RequestResponse requestResponse) {
            return ZendeskRequestService.updateLastCommentingAgents(requestResponse.getRequest(), ZendeskRequestService.getAgentMap(requestResponse.getLastCommentingAgents()));
        }
    };
    private final RequestService requestService;
    private final c.b<RequestsResponse, List<Request>> requestsExtractor = new c.b<RequestsResponse, List<Request>>() {
        public List<Request> extract(RequestsResponse requestsResponse) {
            Map access$000 = ZendeskRequestService.getAgentMap(requestsResponse.getLastCommentingAgents());
            ArrayList arrayList = new ArrayList();
            for (Request access$100 : requestsResponse.getRequests()) {
                arrayList.add(ZendeskRequestService.updateLastCommentingAgents(access$100, access$000));
            }
            return arrayList;
        }
    };

    public ZendeskRequestService(RequestService requestService2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.iso8601 = simpleDateFormat;
        this.requestService = requestService2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
    }

    /* access modifiers changed from: private */
    public static Map<Long, User> getAgentMap(List<User> list) {
        HashMap hashMap = new HashMap(list.size());
        for (User next : list) {
            hashMap.put(next.getId(), new User(next.getId(), next.getName(), next.getPhoto(), true, -1L, (List<String>) null, (Map<String, String>) null));
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static Request updateLastCommentingAgents(Request request, Map<Long, User> map) {
        ArrayList arrayList = new ArrayList(request.getLastCommentingAgentsIds().size());
        for (Long l11 : request.getLastCommentingAgentsIds()) {
            arrayList.add(map.get(l11));
        }
        request.setLastCommentingAgents(arrayList);
        return request;
    }

    public void addComment(String str, EndUserComment endUserComment, ZendeskCallback<Request> zendeskCallback) {
        UpdateRequestWrapper updateRequestWrapper = new UpdateRequestWrapper();
        Request request = new Request();
        request.setComment(endUserComment);
        updateRequestWrapper.setRequest(request);
        this.requestService.addComment(str, updateRequestWrapper).enqueue(new c(zendeskCallback, new c.b<RequestResponse, Request>() {
            public Request extract(RequestResponse requestResponse) {
                return requestResponse.getRequest();
            }
        }));
    }

    public void createRequest(String str, CreateRequest createRequest, ZendeskCallback<Request> zendeskCallback) {
        this.requestService.createRequest(str, new CreateRequestWrapper(createRequest)).enqueue(new c(zendeskCallback, new c.b<RequestResponse, Request>() {
            public Request extract(RequestResponse requestResponse) {
                return requestResponse.getRequest();
            }
        }));
    }

    public void getAllRequests(String str, String str2, ZendeskCallback<List<Request>> zendeskCallback) {
        this.requestService.getAllRequests(str, str2).enqueue(new c(zendeskCallback, this.requestsExtractor));
    }

    public void getComments(String str, ZendeskCallback<CommentsResponse> zendeskCallback) {
        this.requestService.getComments(str).enqueue(new c(zendeskCallback));
    }

    public void getCommentsSince(String str, Date date, boolean z11, ZendeskCallback<CommentsResponse> zendeskCallback) {
        this.requestService.getCommentsSince(str, this.iso8601.format(date), z11 ? ROLE_AGENT : null).enqueue(new c(zendeskCallback));
    }

    public void getRequest(String str, String str2, ZendeskCallback<Request> zendeskCallback) {
        this.requestService.getRequest(str, str2).enqueue(new c(zendeskCallback, this.requestExtractor));
    }

    public void getTicketFormsById(String str, ZendeskCallback<RawTicketFormResponse> zendeskCallback) {
        this.requestService.getTicketFormsById(str, TICKET_FIELDS_INCLUDE).enqueue(new c(zendeskCallback));
    }

    public void getAllRequests(String str, String str2, String str3, ZendeskCallback<List<Request>> zendeskCallback) {
        this.requestService.getManyRequests(str, str2, str3).enqueue(new c(zendeskCallback, this.requestsExtractor));
    }
}

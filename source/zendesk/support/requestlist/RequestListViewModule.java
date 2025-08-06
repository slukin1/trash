package zendesk.support.requestlist;

import com.squareup.picasso.Picasso;

public class RequestListViewModule {
    private final RequestListActivity activity;
    private final RequestListConfiguration config;

    public RequestListViewModule(RequestListActivity requestListActivity, RequestListConfiguration requestListConfiguration) {
        this.activity = requestListActivity;
        this.config = requestListConfiguration;
    }

    public RequestListView view(Picasso picasso) {
        return new RequestListView(this.activity, this.config, picasso);
    }
}

package zendesk.support;

import zendesk.support.request.RequestComponent;
import zendesk.support.request.RequestModule;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListViewModule;

public interface SupportSdkComponent {
    public static final String SUPPORT_MAIN_THREAD_EXECUTOR = "SUPPORT_MAIN_THREAD_EXECUTOR";

    void inject(DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver);

    void inject(SdkDependencyProvider sdkDependencyProvider);

    RequestComponent plus(RequestModule requestModule);

    RequestListComponent plus(RequestListModule requestListModule, RequestListViewModule requestListViewModule);
}

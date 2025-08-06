package zendesk.support.requestlist;

import oz.a;
import zendesk.core.ActionHandlerRegistry;

public final class RequestListActivity_MembersInjector implements a<RequestListActivity> {
    private final q00.a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final q00.a<RequestListModel> modelProvider;
    private final q00.a<RequestListPresenter> presenterProvider;
    private final q00.a<RequestListSyncHandler> syncHandlerProvider;
    private final q00.a<RequestListView> viewProvider;

    public RequestListActivity_MembersInjector(q00.a<RequestListPresenter> aVar, q00.a<RequestListView> aVar2, q00.a<RequestListModel> aVar3, q00.a<ActionHandlerRegistry> aVar4, q00.a<RequestListSyncHandler> aVar5) {
        this.presenterProvider = aVar;
        this.viewProvider = aVar2;
        this.modelProvider = aVar3;
        this.actionHandlerRegistryProvider = aVar4;
        this.syncHandlerProvider = aVar5;
    }

    public static a<RequestListActivity> create(q00.a<RequestListPresenter> aVar, q00.a<RequestListView> aVar2, q00.a<RequestListModel> aVar3, q00.a<ActionHandlerRegistry> aVar4, q00.a<RequestListSyncHandler> aVar5) {
        return new RequestListActivity_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static void injectActionHandlerRegistry(RequestListActivity requestListActivity, ActionHandlerRegistry actionHandlerRegistry) {
        requestListActivity.actionHandlerRegistry = actionHandlerRegistry;
    }

    public static void injectModel(RequestListActivity requestListActivity, Object obj) {
        requestListActivity.model = (RequestListModel) obj;
    }

    public static void injectPresenter(RequestListActivity requestListActivity, Object obj) {
        requestListActivity.presenter = (RequestListPresenter) obj;
    }

    public static void injectSyncHandler(RequestListActivity requestListActivity, Object obj) {
        requestListActivity.syncHandler = (RequestListSyncHandler) obj;
    }

    public static void injectView(RequestListActivity requestListActivity, Object obj) {
        requestListActivity.view = (RequestListView) obj;
    }

    public void injectMembers(RequestListActivity requestListActivity) {
        injectPresenter(requestListActivity, this.presenterProvider.get());
        injectView(requestListActivity, this.viewProvider.get());
        injectModel(requestListActivity, this.modelProvider.get());
        injectActionHandlerRegistry(requestListActivity, this.actionHandlerRegistryProvider.get());
        injectSyncHandler(requestListActivity, this.syncHandlerProvider.get());
    }
}

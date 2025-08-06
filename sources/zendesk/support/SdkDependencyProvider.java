package zendesk.support;

import android.annotation.SuppressLint;
import java.util.List;
import java.util.UUID;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.Zendesk;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListConfiguration;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListViewModule;

public enum SdkDependencyProvider {
    INSTANCE;
    
    public static final String NOT_INITIALIZED_LOG = "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Support.INSTANCE.init(...) was called ";
    public List<ActionHandler> actionHandlers;

    /* renamed from: id  reason: collision with root package name */
    private UUID f62954id;
    public ActionHandlerRegistry registry;
    private RequestListModule requestListModule;
    private SupportSdkComponent supportSdkComponent;

    private void registerActionHandlers() {
        for (ActionHandler add : this.actionHandlers) {
            this.registry.add(add);
        }
    }

    public void initForTesting(SupportSdkComponent supportSdkComponent2, UUID uuid) {
        this.supportSdkComponent = supportSdkComponent2;
        this.f62954id = uuid;
    }

    public boolean isInitialized() {
        if (Zendesk.INSTANCE.isInitialized()) {
            Support support = Support.INSTANCE;
            return support.isInitialized() && support.isAuthenticated();
        }
    }

    public RequestListComponent provideRequestListComponent(RequestListActivity requestListActivity, RequestListConfiguration requestListConfiguration) {
        if (this.requestListModule == null) {
            this.requestListModule = new RequestListModule();
        }
        return provideSupportSdkComponent().plus(this.requestListModule, new RequestListViewModule(requestListActivity, requestListConfiguration));
    }

    @SuppressLint({"RestrictedApi"})
    public SupportSdkComponent provideSupportSdkComponent() {
        SupportModule supportModule = Support.INSTANCE.getSupportModule();
        UUID id2 = supportModule.getId();
        if (this.supportSdkComponent == null || !id2.equals(this.f62954id)) {
            this.supportSdkComponent = DaggerSupportSdkComponent.builder().coreModule(Zendesk.INSTANCE.coreModule()).supportModule(supportModule).supportSdkModule(new SupportSdkModule()).build();
            this.f62954id = supportModule.getId();
            this.supportSdkComponent.inject(this);
            registerActionHandlers();
        }
        return this.supportSdkComponent;
    }

    public void initForTesting(SupportSdkComponent supportSdkComponent2, UUID uuid, RequestListModule requestListModule2) {
        initForTesting(supportSdkComponent2, uuid);
        this.requestListModule = requestListModule2;
    }
}

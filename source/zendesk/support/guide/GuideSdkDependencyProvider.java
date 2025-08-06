package zendesk.support.guide;

import android.annotation.SuppressLint;
import java.util.UUID;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.Zendesk;
import zendesk.support.Guide;
import zendesk.support.GuideModule;

enum GuideSdkDependencyProvider {
    INSTANCE;
    
    public static final String NOT_INITIALIZED_LOG = "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Guide.INSTANCE.init(...) was called ";
    public ActionHandler actionHandler;
    private GuideSdkComponent guideSdkComponent;

    /* renamed from: id  reason: collision with root package name */
    private UUID f62963id;
    public ActionHandlerRegistry registry;

    public void initForTesting(GuideSdkComponent guideSdkComponent2, UUID uuid) {
        this.guideSdkComponent = guideSdkComponent2;
        this.f62963id = uuid;
    }

    public boolean isInitialized() {
        return Zendesk.INSTANCE.isInitialized() && Guide.INSTANCE.isInitialized();
    }

    @SuppressLint({"RestrictedApi"})
    public GuideSdkComponent provideGuideSdkComponent() {
        GuideModule guideModule = Guide.INSTANCE.guideModule();
        if (!guideModule.getId().equals(this.f62963id)) {
            this.guideSdkComponent = DaggerGuideSdkComponent.builder().coreModule(Zendesk.INSTANCE.coreModule()).guideModule(guideModule).build();
            this.f62963id = guideModule.getId();
            this.guideSdkComponent.inject(this);
            this.registry.add(this.actionHandler);
        }
        return this.guideSdkComponent;
    }
}

package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class SupportApplicationModule_ProvidesZendeskTrackerFactory implements b<ZendeskTracker> {
    private final SupportApplicationModule module;

    public SupportApplicationModule_ProvidesZendeskTrackerFactory(SupportApplicationModule supportApplicationModule) {
        this.module = supportApplicationModule;
    }

    public static SupportApplicationModule_ProvidesZendeskTrackerFactory create(SupportApplicationModule supportApplicationModule) {
        return new SupportApplicationModule_ProvidesZendeskTrackerFactory(supportApplicationModule);
    }

    public static ZendeskTracker providesZendeskTracker(SupportApplicationModule supportApplicationModule) {
        return (ZendeskTracker) d.f(supportApplicationModule.providesZendeskTracker());
    }

    public ZendeskTracker get() {
        return providesZendeskTracker(this.module);
    }
}

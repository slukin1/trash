package zendesk.support;

import android.content.Context;
import java.util.Locale;

class SupportApplicationModule {
    private ApplicationScope applicationScope;

    public SupportApplicationModule(ApplicationScope applicationScope2) {
        this.applicationScope = applicationScope2;
    }

    public Locale provideLocale() {
        return this.applicationScope.getLocale();
    }

    public SupportSdkMetadata provideMetadata(Context context) {
        return new SupportSdkMetadata(context);
    }

    public ZendeskTracker providesZendeskTracker() {
        return this.applicationScope.getZendeskTracker();
    }
}

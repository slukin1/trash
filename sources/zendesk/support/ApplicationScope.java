package zendesk.support;

import java.util.Locale;
import zendesk.support.ZendeskTracker;

class ApplicationScope {
    private final Locale locale;
    private final ZendeskTracker zendeskTracker;

    public Locale getLocale() {
        return this.locale;
    }

    public ZendeskTracker getZendeskTracker() {
        return this.zendeskTracker;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    private ApplicationScope(Builder builder) {
        this.locale = builder.locale;
        this.zendeskTracker = builder.zendeskTracker;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Locale locale;
        /* access modifiers changed from: private */
        public ZendeskTracker zendeskTracker;

        public Builder() {
            this.locale = Locale.getDefault();
            this.zendeskTracker = new ZendeskTracker.DefaultTracker();
        }

        public ApplicationScope build() {
            return new ApplicationScope(this);
        }

        public Builder locale(Locale locale2) {
            this.locale = locale2;
            return this;
        }

        public Builder zendeskTracker(ZendeskTracker zendeskTracker2) {
            this.zendeskTracker = zendeskTracker2;
            return this;
        }

        public Builder(ApplicationScope applicationScope) {
            this.locale = applicationScope.getLocale();
        }
    }
}

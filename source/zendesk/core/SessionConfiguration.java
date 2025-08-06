package zendesk.core;

import java.util.Locale;

class SessionConfiguration {
    private Identity identity;
    private Locale locale;

    public static class Builder {
        /* access modifiers changed from: private */
        public Identity identity;
        /* access modifiers changed from: private */
        public Locale locale;

        public SessionConfiguration build() {
            return new SessionConfiguration(this);
        }

        public Builder setIdentity(Identity identity2) {
            this.identity = identity2;
            return this;
        }

        public Builder setLocale(Locale locale2) {
            this.locale = locale2;
            return this;
        }

        private Builder(SessionConfiguration sessionConfiguration) {
            this.identity = new Identity() {
            };
            this.locale = Locale.getDefault();
            this.identity = sessionConfiguration.getIdentity();
        }

        public Builder() {
            this.identity = new Identity() {
            };
            this.locale = Locale.getDefault();
        }
    }

    public Identity getIdentity() {
        return this.identity;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    private SessionConfiguration(Builder builder) {
        this.identity = builder.identity;
        this.locale = builder.locale;
    }
}

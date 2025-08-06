package zendesk.support.requestlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import h30.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import zendesk.configurations.Configuration;

public class RequestListConfiguration implements Configuration {
    private final List<Configuration> configurations;
    private final boolean contactUsButtonVisible;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<Configuration> configurations = new ArrayList();
        /* access modifiers changed from: private */
        public boolean contactUsButtonVisible = true;

        private void setConfigurations(List<Configuration> list) {
            this.configurations = list;
        }

        public Configuration config() {
            return new RequestListConfiguration(this);
        }

        public Intent intent(Context context, Configuration... configurationArr) {
            return intent(context, (List<Configuration>) Arrays.asList(configurationArr));
        }

        public void show(Context context, Configuration... configurationArr) {
            context.startActivity(intent(context, configurationArr));
        }

        public Builder withContactUsButtonVisible(boolean z11) {
            this.contactUsButtonVisible = z11;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public Intent intent(Context context, List<Configuration> list) {
            setConfigurations(list);
            Configuration config = config();
            Intent intent = new Intent(context, RequestListActivity.class);
            a.c(intent, config);
            return intent;
        }

        public void show(Context context, List<Configuration> list) {
            context.startActivity(intent(context, list));
        }
    }

    @SuppressLint({"RestrictedApi"})
    public List<Configuration> getConfigurations() {
        return a.a(this.configurations, this);
    }

    public boolean isContactUsButtonVisible() {
        return this.contactUsButtonVisible;
    }

    private RequestListConfiguration(Builder builder) {
        this.contactUsButtonVisible = builder.contactUsButtonVisible;
        this.configurations = builder.configurations;
    }
}

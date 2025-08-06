package zendesk.support;

import okhttp3.OkHttpClient;
import zendesk.core.CustomNetworkConfig;

class HelpCenterCachingNetworkConfig extends CustomNetworkConfig {
    private HelpCenterCachingInterceptor interceptor;

    public HelpCenterCachingNetworkConfig(HelpCenterCachingInterceptor helpCenterCachingInterceptor) {
        this.interceptor = helpCenterCachingInterceptor;
    }

    public void configureOkHttpClient(OkHttpClient.Builder builder) {
        builder.addNetworkInterceptor(this.interceptor);
    }
}

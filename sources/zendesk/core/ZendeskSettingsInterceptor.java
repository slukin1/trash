package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Response;

class ZendeskSettingsInterceptor implements Interceptor {
    private static final String LOG_TAG = "SettingsInterceptor";
    private final SdkSettingsProviderInternal provider;
    private SettingsStorage settingsStorage;

    public ZendeskSettingsInterceptor(SdkSettingsProviderInternal sdkSettingsProviderInternal, SettingsStorage settingsStorage2) {
        this.provider = sdkSettingsProviderInternal;
        this.settingsStorage = settingsStorage2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (!this.settingsStorage.areSettingsUpToDate(1, TimeUnit.HOURS)) {
            Logger.b(LOG_TAG, "Requesting SDK settings.", new Object[0]);
            if (this.provider.getCoreSettings() == null) {
                Logger.b(LOG_TAG, "Retrieved settings are null. Returning 404.", new Object[0]);
                return new Response.Builder().protocol(Protocol.HTTP_2).request(chain.request()).message(chain.request().method()).code(404).build();
            }
        }
        Logger.b(LOG_TAG, "Proceeding with chain.", new Object[0]);
        return chain.proceed(chain.request());
    }
}

package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

class ZendeskPushInterceptor implements Interceptor {
    private static final String LOG_TAG = "ZendeskPushInterceptor";
    private final IdentityStorage identityStorage;
    private final PushDeviceIdStorage pushDeviceIdStorage;
    private final PushRegistrationProviderInternal pushProvider;

    public ZendeskPushInterceptor(PushRegistrationProviderInternal pushRegistrationProviderInternal, PushDeviceIdStorage pushDeviceIdStorage2, IdentityStorage identityStorage2) {
        this.pushProvider = pushRegistrationProviderInternal;
        this.pushDeviceIdStorage = pushDeviceIdStorage2;
        this.identityStorage = identityStorage2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        PushRegistrationRequest pushRegistrationRequest = this.pushDeviceIdStorage.getPushRegistrationRequest();
        if (!(pushRegistrationRequest == null || this.identityStorage.getStoredAccessToken() == null)) {
            Logger.b(LOG_TAG, "Sending stored push registration request", new Object[0]);
            this.pushProvider.sendPushRegistrationRequest(pushRegistrationRequest);
        }
        return chain.proceed(chain.request());
    }
}

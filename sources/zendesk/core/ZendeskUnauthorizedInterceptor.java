package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

class ZendeskUnauthorizedInterceptor implements Interceptor {
    private static final String LOG_TAG = "ZendeskUnauthorizedInterceptor";
    private final IdentityManager identityManager;
    private final SessionStorage sessionStorage;

    public ZendeskUnauthorizedInterceptor(SessionStorage sessionStorage2, IdentityManager identityManager2) {
        this.sessionStorage = sessionStorage2;
        this.identityManager = identityManager2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        if (!proceed.isSuccessful() && 401 == proceed.code()) {
            if (!UrlHelper.isGuideRequest(chain.request().url().toString()) || !(this.identityManager.getIdentity() instanceof AnonymousIdentity)) {
                onHttpUnauthorized();
            } else {
                Logger.b(LOG_TAG, "Unauthorized guide request", new Object[0]);
            }
        }
        return proceed;
    }

    public void onHttpUnauthorized() {
        this.sessionStorage.clear();
    }
}

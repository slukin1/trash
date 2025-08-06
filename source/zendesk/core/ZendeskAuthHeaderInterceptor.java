package zendesk.core;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class ZendeskAuthHeaderInterceptor implements Interceptor {
    private IdentityManager identityManager;

    public ZendeskAuthHeaderInterceptor(IdentityManager identityManager2) {
        this.identityManager = identityManager2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder newBuilder = chain.request().newBuilder();
        Identity identity = this.identityManager.getIdentity();
        String storedAccessTokenAsBearerToken = this.identityManager.getStoredAccessTokenAsBearerToken();
        if (UrlHelper.isGuideRequest(chain.request().url().toString()) && !UrlHelper.isVoteRequest(chain.request().url().toString()) && (identity instanceof AnonymousIdentity)) {
            return chain.proceed(newBuilder.build());
        }
        if (storedAccessTokenAsBearerToken != null) {
            newBuilder.addHeader("Authorization", storedAccessTokenAsBearerToken);
        }
        return chain.proceed(newBuilder.build());
    }
}

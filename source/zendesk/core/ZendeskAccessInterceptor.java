package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

class ZendeskAccessInterceptor implements Interceptor {
    private static final String EMPTY_JSON = "{}";
    private static final String LOG_TAG = "ZendeskAccessInterceptor";
    private static final int RETRY_LIMIT = 3;
    private AccessProvider accessProvider;
    private CoreSettingsStorage coreSettingsStorage;
    private IdentityManager identityManager;
    private int retryCounter;
    private Storage storage;

    public ZendeskAccessInterceptor(IdentityManager identityManager2, AccessProvider accessProvider2, Storage storage2, CoreSettingsStorage coreSettingsStorage2) {
        this.identityManager = identityManager2;
        this.accessProvider = accessProvider2;
        this.storage = storage2;
        this.coreSettingsStorage = coreSettingsStorage2;
    }

    private Response errorResponse(Interceptor.Chain chain, String str) {
        return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_2).code(400).message(str).body(ResponseBody.create(MediaType.parse(Constants.TEXT_JSON), EMPTY_JSON)).build();
    }

    public static String getErrorLogMessage(AuthenticationType authenticationType, Identity identity) {
        StringBuilder sb2 = new StringBuilder(160);
        sb2.append("The expected type of authentication is ");
        if (authenticationType == null) {
            sb2.append("null. Check that settings have been downloaded.");
        } else if (authenticationType == AuthenticationType.ANONYMOUS) {
            sb2.append("anonymous.");
        } else if (authenticationType == AuthenticationType.JWT) {
            sb2.append("jwt.");
        }
        sb2.append(10);
        sb2.append("The local identity is");
        if (identity == null) {
            sb2.append(" not");
        }
        sb2.append(" present.\n");
        if (identity != null) {
            sb2.append("The local identity is ");
            if (identity instanceof AnonymousIdentity) {
                sb2.append("anonymous.");
            } else if (identity instanceof JwtIdentity) {
                sb2.append("jwt.");
            } else {
                sb2.append("unknown.");
            }
        }
        return sb2.toString();
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        retrofit2.Response<AuthenticationResponse> response;
        Identity identity = this.identityManager.getIdentity();
        AuthenticationType authentication = this.coreSettingsStorage.getCoreSettings().getAuthentication();
        if (UrlHelper.isVoteRequest(chain.request().url().toString())) {
            Logger.b(LOG_TAG, "Anonymous Guide vote request. Checking access token.", new Object[0]);
        } else if (UrlHelper.isGuideRequest(chain.request().url().toString()) && (identity instanceof AnonymousIdentity)) {
            Logger.b(LOG_TAG, "Anonymous Guide non-vote request, no need to intercept.", new Object[0]);
            return chain.proceed(chain.request());
        }
        if (this.identityManager.getStoredAccessTokenAsBearerToken() != null) {
            Logger.b(LOG_TAG, "Access token present, no need to intercept.", new Object[0]);
            return chain.proceed(chain.request());
        }
        Logger.b(LOG_TAG, "Access token is required, intercepting.", new Object[0]);
        if (AuthenticationType.ANONYMOUS == authentication && (identity instanceof AnonymousIdentity)) {
            Logger.b(LOG_TAG, "Anonymous Identity found. Requesting and storing auth token.", new Object[0]);
            response = this.accessProvider.getAuthTokenViaAnonymous((AnonymousIdentity) identity);
        } else if (AuthenticationType.JWT != authentication || !(identity instanceof JwtIdentity)) {
            this.storage.clear();
            String errorLogMessage = getErrorLogMessage(authentication, identity);
            Logger.d(LOG_TAG, errorLogMessage, new Object[0]);
            return errorResponse(chain, errorLogMessage);
        } else {
            Logger.b(LOG_TAG, "JWT Identity found. Requesting and storing auth token.", new Object[0]);
            response = this.accessProvider.getAuthTokenViaJwt((JwtIdentity) identity);
        }
        if (response == null) {
            return errorResponse(chain, "Response was null, failed to auth user.");
        }
        if (response.code() == 409) {
            int i11 = this.retryCounter;
            if (i11 >= 3) {
                return errorResponse(chain, "Response was 409, failed to auth user.");
            }
            this.retryCounter = i11 + 1;
            return intercept(chain);
        } else if (response.body() == null) {
            return errorResponse(chain, "Response body was null, failed to auth user.");
        } else {
            AccessToken authentication2 = response.body().getAuthentication();
            if (authentication2 != null) {
                this.identityManager.storeAccessToken(authentication2);
            }
            this.retryCounter = 0;
            return chain.proceed(chain.request());
        }
    }
}

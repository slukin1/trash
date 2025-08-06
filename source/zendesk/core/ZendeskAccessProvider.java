package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import mz.f;
import retrofit2.Response;

class ZendeskAccessProvider implements AccessProvider {
    private static final String LOG_TAG = "ZendeskAccessProvider";
    private final AccessService accessService;
    private final IdentityManager identityManager;

    public ZendeskAccessProvider(IdentityManager identityManager2, AccessService accessService2) {
        this.identityManager = identityManager2;
        this.accessService = accessService2;
    }

    public Response<AuthenticationResponse> getAuthTokenViaAnonymous(AnonymousIdentity anonymousIdentity) {
        Logger.b(LOG_TAG, "Requesting an access token for anonymous identity.", new Object[0]);
        try {
            return this.accessService.getAuthTokenForAnonymous(new AuthenticationRequestWrapper(new ApiAnonymousIdentity(anonymousIdentity, this.identityManager.getSdkGuid()))).execute();
        } catch (IOException e11) {
            Logger.c(LOG_TAG, e11.getMessage(), e11, new Object[0]);
            return null;
        }
    }

    public Response<AuthenticationResponse> getAuthTokenViaJwt(JwtIdentity jwtIdentity) {
        Logger.b(LOG_TAG, "Requesting an access token for jwt identity.", new Object[0]);
        if (f.e(jwtIdentity.getJwtUserIdentifier())) {
            Logger.d(LOG_TAG, AccessProvider.NO_JWT_ERROR_MESSAGE, new Object[0]);
            return null;
        }
        try {
            return this.accessService.getAuthTokenForJwt(new AuthenticationRequestWrapper(jwtIdentity)).execute();
        } catch (IOException e11) {
            Logger.c(LOG_TAG, e11.getMessage(), e11, new Object[0]);
            return null;
        }
    }
}

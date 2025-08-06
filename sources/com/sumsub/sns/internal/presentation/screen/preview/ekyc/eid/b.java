package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import de.authada.library.api.CheckFailedReason;
import de.authada.library.api.SecretWrong;
import de.authada.library.api.authentication.AuthenticationCallback;
import de.authada.library.api.authentication.Pin;
import java.net.URI;

public interface b extends AuthenticationCallback {

    public static final class a {
        public static void a(b bVar, URI uri) {
            AuthenticationCallback.DefaultImpls.onReturnUrl(bVar, uri);
        }
    }

    void a(CheckFailedReason checkFailedReason, Pin pin);

    void a(SecretWrong secretWrong, Pin pin);

    void onEidCardCheckFailed(CheckFailedReason checkFailedReason);

    void onSecretWrong(SecretWrong secretWrong);
}

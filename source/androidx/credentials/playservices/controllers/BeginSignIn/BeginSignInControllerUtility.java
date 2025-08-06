package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import kotlin.jvm.internal.r;

public final class BeginSignInControllerUtility {
    private static final long AUTH_MIN_VERSION_JSON_PARSING = 231815000;
    public static final Companion Companion = new Companion((r) null);
    private static final String TAG = BeginSignInControllerUtility.class.getName();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final BeginSignInRequest.GoogleIdTokenRequestOptions convertToGoogleIdTokenOption(GetGoogleIdOption getGoogleIdOption) {
            BeginSignInRequest.GoogleIdTokenRequestOptions.Builder supported = BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setFilterByAuthorizedAccounts(getGoogleIdOption.getFilterByAuthorizedAccounts()).setNonce(getGoogleIdOption.getNonce()).setRequestVerifiedPhoneNumber(getGoogleIdOption.getRequestVerifiedPhoneNumber()).setServerClientId(getGoogleIdOption.getServerClientId()).setSupported(true);
            if (getGoogleIdOption.getLinkedServiceId() != null) {
                supported.associateLinkedAccounts(getGoogleIdOption.getLinkedServiceId(), getGoogleIdOption.getIdTokenDepositionScopes());
            }
            return supported.build();
        }

        private final long determineDeviceGMSVersionCode(Context context) {
            return (long) context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        private final boolean needsBackwardsCompatibleRequest(long j11) {
            return j11 < BeginSignInControllerUtility.AUTH_MIN_VERSION_JSON_PARSING;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
            if (r5.getAutoSelectEnabled() == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            if (r5.isAutoSelectAllowed() == false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.gms.auth.api.identity.BeginSignInRequest constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest r9, android.content.Context r10) {
            /*
                r8 = this;
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r0 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder
                r0.<init>()
                java.util.List r9 = r9.a()
                java.util.Iterator r9 = r9.iterator()
                r1 = 1
                r2 = 0
                r3 = r2
                r4 = r3
            L_0x0011:
                boolean r5 = r9.hasNext()
                if (r5 == 0) goto L_0x007d
                java.lang.Object r5 = r9.next()
                androidx.credentials.i r5 = (androidx.credentials.i) r5
                boolean r6 = r5 instanceof androidx.credentials.GetPasswordOption
                if (r6 == 0) goto L_0x003e
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r6 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder
                r6.<init>()
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r6 = r6.setSupported(r1)
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions r6 = r6.build()
                r0.setPasswordRequestOptions(r6)
                if (r3 != 0) goto L_0x003c
                boolean r3 = r5.isAutoSelectAllowed()
                if (r3 == 0) goto L_0x003a
                goto L_0x003c
            L_0x003a:
                r3 = r2
                goto L_0x0011
            L_0x003c:
                r3 = r1
                goto L_0x0011
            L_0x003e:
                boolean r6 = r5 instanceof androidx.credentials.n
                if (r6 == 0) goto L_0x0067
                if (r4 != 0) goto L_0x0067
                long r6 = r8.determineDeviceGMSVersionCode(r10)
                boolean r4 = r8.needsBackwardsCompatibleRequest(r6)
                if (r4 == 0) goto L_0x005a
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r4 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.n r5 = (androidx.credentials.n) r5
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions r4 = r4.convertToPlayAuthPasskeyRequest(r5)
                r0.setPasskeysSignInRequestOptions(r4)
                goto L_0x0065
            L_0x005a:
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r4 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.n r5 = (androidx.credentials.n) r5
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeyJsonRequestOptions r4 = r4.convertToPlayAuthPasskeyJsonRequest(r5)
                r0.setPasskeyJsonSignInRequestOptions(r4)
            L_0x0065:
                r4 = r1
                goto L_0x0011
            L_0x0067:
                boolean r6 = r5 instanceof com.google.android.libraries.identity.googleid.GetGoogleIdOption
                if (r6 == 0) goto L_0x0011
                com.google.android.libraries.identity.googleid.GetGoogleIdOption r5 = (com.google.android.libraries.identity.googleid.GetGoogleIdOption) r5
                com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions r6 = r8.convertToGoogleIdTokenOption(r5)
                r0.setGoogleIdTokenRequestOptions(r6)
                if (r3 != 0) goto L_0x003c
                boolean r3 = r5.getAutoSelectEnabled()
                if (r3 == 0) goto L_0x003a
                goto L_0x003c
            L_0x007d:
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r9 = r0.setAutoSelectEnabled(r3)
                com.google.android.gms.auth.api.identity.BeginSignInRequest r9 = r9.build()
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.BeginSignIn.BeginSignInControllerUtility.Companion.constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest, android.content.Context):com.google.android.gms.auth.api.identity.BeginSignInRequest");
        }
    }
}

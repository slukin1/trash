package zendesk.core;

import com.zendesk.logger.Logger;
import java.util.UUID;
import mz.f;

class ZendeskIdentityStorage implements IdentityStorage {
    public static final String BLIPS_UUID_KEY = "blips_buid";
    public static final String IDENTITY_KEY = "zendesk-identity";
    public static final String IDENTITY_TYPE_KEY = "zendesk-identity-type";
    public static final String LOG_TAG = "ZendeskIdentityStorage";
    public static final String TOKEN_KEY = "stored_token";
    public static final String USER_ID_KEY = "user_id";
    public static final String UUID_KEY = "uuid";
    private final BaseStorage identityStorage;

    /* renamed from: zendesk.core.ZendeskIdentityStorage$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$core$AuthenticationType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zendesk.core.AuthenticationType[] r0 = zendesk.core.AuthenticationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$core$AuthenticationType = r0
                zendesk.core.AuthenticationType r1 = zendesk.core.AuthenticationType.JWT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$core$AuthenticationType     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.core.AuthenticationType r1 = zendesk.core.AuthenticationType.ANONYMOUS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.core.ZendeskIdentityStorage.AnonymousClass1.<clinit>():void");
        }
    }

    public ZendeskIdentityStorage(BaseStorage baseStorage) {
        this.identityStorage = baseStorage;
    }

    public void clear() {
        this.identityStorage.clear();
    }

    public String getBlipsUuid() {
        return this.identityStorage.get(BLIPS_UUID_KEY);
    }

    public Identity getIdentity() {
        AuthenticationType authType;
        String str = this.identityStorage.get(IDENTITY_TYPE_KEY);
        if (f.c(str) && (authType = AuthenticationType.getAuthType(str)) != null) {
            int i11 = AnonymousClass1.$SwitchMap$zendesk$core$AuthenticationType[authType.ordinal()];
            if (i11 == 1) {
                Logger.b(LOG_TAG, "Loading Jwt identity", new Object[0]);
                return (Identity) this.identityStorage.get(IDENTITY_KEY, JwtIdentity.class);
            } else if (i11 == 2) {
                Logger.b(LOG_TAG, "Loading Anonymous identity", new Object[0]);
                return (Identity) this.identityStorage.get(IDENTITY_KEY, AnonymousIdentity.class);
            }
        }
        return null;
    }

    public AccessToken getStoredAccessToken() {
        return (AccessToken) this.identityStorage.get(TOKEN_KEY, AccessToken.class);
    }

    public Long getUserId() {
        return (Long) this.identityStorage.get("user_id", Long.class);
    }

    public String getUuid() {
        Logger.b(LOG_TAG, "Fetching UUID from preferences store", new Object[0]);
        String str = this.identityStorage.get(UUID_KEY);
        return f.e(str) ? "" : str;
    }

    public void storeAccessToken(AccessToken accessToken) {
        if (accessToken != null) {
            this.identityStorage.put(TOKEN_KEY, (Object) accessToken);
        }
    }

    public void storeIdentity(Identity identity) {
        if (identity == null) {
            Logger.d(LOG_TAG, "identity is null, will not store the identity", new Object[0]);
            return;
        }
        String str = null;
        if (identity instanceof AnonymousIdentity) {
            Logger.b(LOG_TAG, "Storing anonymous identity", new Object[0]);
            str = AuthenticationType.ANONYMOUS.getAuthenticationType();
        } else if (identity instanceof JwtIdentity) {
            Logger.b(LOG_TAG, "Storing jwt identity", new Object[0]);
            str = AuthenticationType.JWT.getAuthenticationType();
        } else {
            Logger.d(LOG_TAG, "Unknown authentication type, identity will not be stored", new Object[0]);
        }
        if (str != null) {
            this.identityStorage.put(IDENTITY_KEY, (Object) identity);
            this.identityStorage.put(IDENTITY_TYPE_KEY, str);
        }
    }

    public void storeSdkGuid(String str) {
        Logger.b(LOG_TAG, "Storing new UUID in preference store", new Object[0]);
        this.identityStorage.put(UUID_KEY, str);
    }

    public void storeUserId(Long l11) {
        if (l11 != null) {
            this.identityStorage.put("user_id", (Object) l11);
        }
    }

    public String updateBlipsUuid() {
        String uuid = UUID.randomUUID().toString();
        Logger.b(LOG_TAG, "Generate new Blips BUID", new Object[0]);
        this.identityStorage.put(BLIPS_UUID_KEY, uuid);
        return uuid;
    }

    public String updateSdkGuid() {
        String uuid = UUID.randomUUID().toString();
        storeSdkGuid(uuid);
        return uuid;
    }
}

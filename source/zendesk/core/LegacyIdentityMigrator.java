package zendesk.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.zendesk.logger.Logger;
import mz.f;
import zendesk.core.AnonymousIdentity;

class LegacyIdentityMigrator {
    private static final String ANONYMOUS_EMAIL_KEY = "email";
    private static final String ANONYMOUS_NAME_KEY = "name";
    private static final String JWT_TOKEN_KEY = "token";
    private static final String LEGACY_ACCESS_TOKEN_KEY = "access_token";
    private static final String LEGACY_ACCESS_TOKEN_USER_ID_KEY = "user_id";
    private static final String LEGACY_IDENTITY_KEY = "zendesk-identity";
    private static final String LEGACY_IDENTITY_TYPE_KEY = "zendesk-identity-type";
    private static final String LEGACY_PUSH_DEVICE_ID_KEY = "identifier";
    private static final String LEGACY_PUSH_RESPONSE_KEY = "pushRegResponseIdentifier";
    private static final String LEGACY_SDK_GUID_KEY = "uuid";
    private static final String LEGACY_STORED_TOKEN_KEY = "stored_token";
    private static final String LEGACY_USER_ID_KEY = "user_id";
    private static final String LOG_TAG = "LegacyIdentityStorage";
    private IdentityManager identityManager;
    private IdentityStorage identityStorage;
    private SharedPreferencesStorage legacyIdentityStorage;
    private SharedPreferencesStorage legacyPushStorage;
    private PushDeviceIdStorage pushDeviceIdStorage;

    /* renamed from: zendesk.core.LegacyIdentityMigrator$1  reason: invalid class name */
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
                zendesk.core.AuthenticationType r1 = zendesk.core.AuthenticationType.ANONYMOUS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$core$AuthenticationType     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.core.AuthenticationType r1 = zendesk.core.AuthenticationType.JWT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.core.LegacyIdentityMigrator.AnonymousClass1.<clinit>():void");
        }
    }

    public LegacyIdentityMigrator(SharedPreferencesStorage sharedPreferencesStorage, SharedPreferencesStorage sharedPreferencesStorage2, IdentityStorage identityStorage2, IdentityManager identityManager2, PushDeviceIdStorage pushDeviceIdStorage2) {
        this.legacyIdentityStorage = sharedPreferencesStorage;
        this.legacyPushStorage = sharedPreferencesStorage2;
        this.identityStorage = identityStorage2;
        this.identityManager = identityManager2;
        this.pushDeviceIdStorage = pushDeviceIdStorage2;
    }

    private void clear() {
        this.legacyIdentityStorage.remove("zendesk-identity-type");
        this.legacyIdentityStorage.remove("zendesk-identity");
        this.legacyIdentityStorage.remove("stored_token");
        this.legacyIdentityStorage.remove("uuid");
        this.legacyIdentityStorage.remove("user_id");
        this.legacyPushStorage.remove(LEGACY_PUSH_RESPONSE_KEY);
    }

    private AccessToken getLegacyAccessToken() {
        String str = this.legacyIdentityStorage.get("stored_token");
        if (f.e(str)) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(str);
            if (parse != null) {
                if (parse.isJsonObject()) {
                    JsonObject asJsonObject = parse.getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("access_token");
                    JsonElement jsonElement2 = asJsonObject.get("user_id");
                    if (!(jsonElement == null || jsonElement2 == null)) {
                        return new AccessToken(jsonElement.getAsString(), jsonElement2.getAsString());
                    }
                }
            }
            return null;
        } catch (JsonSyntaxException e11) {
            Logger.k(LOG_TAG, "Unable to read legacy AccessToken.", e11, new Object[0]);
            return null;
        }
    }

    private Identity getLegacyIdentity() {
        AuthenticationType legacyIdentityType = getLegacyIdentityType();
        if (legacyIdentityType == null) {
            return null;
        }
        int i11 = AnonymousClass1.$SwitchMap$zendesk$core$AuthenticationType[legacyIdentityType.ordinal()];
        if (i11 == 1) {
            return readLegacyAnonymousIdentity();
        }
        if (i11 != 2) {
            return null;
        }
        return readLegacyJwtIdentity();
    }

    private AuthenticationType getLegacyIdentityType() {
        return AuthenticationType.getAuthType(this.legacyIdentityStorage.get("zendesk-identity-type"));
    }

    private String getLegacyPushId() {
        String str = this.legacyPushStorage.get(LEGACY_PUSH_RESPONSE_KEY);
        if (f.c(str)) {
            try {
                JsonElement parse = new JsonParser().parse(str);
                if (parse != null) {
                    if (parse.isJsonObject()) {
                        JsonElement jsonElement = parse.getAsJsonObject().get("identifier");
                        if (jsonElement != null) {
                            return jsonElement.getAsString();
                        }
                    }
                }
                return null;
            } catch (JsonSyntaxException e11) {
                Logger.k(LOG_TAG, "Unable to read legacy push device ID.", e11, new Object[0]);
            }
        }
        return null;
    }

    private String getLegacySdkGuid() {
        return this.legacyIdentityStorage.get("uuid");
    }

    private long getLegacyUserId() {
        return this.legacyIdentityStorage.getLong("user_id");
    }

    private AnonymousIdentity readLegacyAnonymousIdentity() {
        String str = this.legacyIdentityStorage.get("zendesk-identity");
        if (f.e(str)) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(str);
            if (parse != null) {
                if (parse.isJsonObject()) {
                    JsonObject asJsonObject = parse.getAsJsonObject();
                    AnonymousIdentity.Builder builder = new AnonymousIdentity.Builder();
                    JsonElement jsonElement = asJsonObject.get("email");
                    if (jsonElement != null) {
                        builder.withEmailIdentifier(jsonElement.getAsString());
                    }
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    if (jsonElement2 != null) {
                        builder.withNameIdentifier(jsonElement2.getAsString());
                    }
                    return (AnonymousIdentity) builder.build();
                }
            }
            return null;
        } catch (JsonSyntaxException e11) {
            Logger.k(LOG_TAG, "Unable to read legacy AnonymousIdentity.", e11, new Object[0]);
            return null;
        }
    }

    private JwtIdentity readLegacyJwtIdentity() {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String str = this.legacyIdentityStorage.get("zendesk-identity");
        if (f.e(str)) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(str);
            if (parse == null || (asJsonObject = parse.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("token")) == null) {
                return null;
            }
            return new JwtIdentity(jsonElement.getAsString());
        } catch (JsonSyntaxException e11) {
            Logger.k(LOG_TAG, "Unable to read legacy JwtIdentity.", e11, new Object[0]);
            return null;
        }
    }

    public void checkAndMigrateIdentity() {
        Identity legacyIdentity = getLegacyIdentity();
        if (legacyIdentity != null) {
            this.identityStorage.storeIdentity(legacyIdentity);
            long legacyUserId = getLegacyUserId();
            if (legacyUserId != 0) {
                this.identityStorage.storeUserId(Long.valueOf(legacyUserId));
            }
            AccessToken legacyAccessToken = getLegacyAccessToken();
            if (legacyAccessToken != null) {
                this.identityManager.storeAccessToken(legacyAccessToken);
            }
            if (getLegacyIdentityType() == AuthenticationType.ANONYMOUS) {
                String legacySdkGuid = getLegacySdkGuid();
                if (f.c(legacySdkGuid)) {
                    this.identityStorage.storeSdkGuid(legacySdkGuid);
                }
            }
            String legacyPushId = getLegacyPushId();
            if (f.c(legacyPushId)) {
                this.pushDeviceIdStorage.storeRegisteredDeviceId(legacyPushId);
            }
            clear();
        }
    }
}

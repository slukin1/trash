package zendesk.core;

import com.zendesk.logger.Logger;
import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.io.IOException;
import java.util.Locale;
import lz.c;
import mz.f;
import retrofit2.Response;

class ZendeskPushRegistrationProvider implements PushRegistrationProvider, PushRegistrationProviderInternal {
    private static final String LOG_TAG = "PushRegistrationProvider";
    private static final c.b<PushRegistrationResponseWrapper, String> PUSH_RESPONSE_EXTRACTOR = new c.b<PushRegistrationResponseWrapper, String>() {
        public String extract(PushRegistrationResponseWrapper pushRegistrationResponseWrapper) {
            return (pushRegistrationResponseWrapper == null || pushRegistrationResponseWrapper.getRegistrationResponse() == null || !f.c(pushRegistrationResponseWrapper.getRegistrationResponse().getIdentifier())) ? "" : pushRegistrationResponseWrapper.getRegistrationResponse().getIdentifier();
        }
    };
    /* access modifiers changed from: private */
    public final BlipsCoreProvider blipsProvider;
    private final IdentityManager identityManager;
    /* access modifiers changed from: private */
    public final Locale locale;
    /* access modifiers changed from: private */
    public final PushDeviceIdStorage pushIdStorage;
    private final PushRegistrationService pushService;
    private final SettingsProvider settingsProvider;

    public enum TokenType {
        Identifier((String) null),
        UrbanAirshipChannelId("urban_airship_channel_id");
        
        public final String name;

        private TokenType(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public ZendeskPushRegistrationProvider(PushRegistrationService pushRegistrationService, IdentityManager identityManager2, SettingsProvider settingsProvider2, BlipsCoreProvider blipsCoreProvider, PushDeviceIdStorage pushDeviceIdStorage, Locale locale2) {
        this.pushService = pushRegistrationService;
        this.identityManager = identityManager2;
        this.settingsProvider = settingsProvider2;
        this.blipsProvider = blipsCoreProvider;
        this.pushIdStorage = pushDeviceIdStorage;
        this.locale = locale2;
    }

    private boolean checkForStoredPushRegistration(String str, ZendeskCallback<String> zendeskCallback) {
        if (!f.c(str)) {
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("Invalid identifier provided."));
            }
            Logger.l(LOG_TAG, "Invalid identifier provided.", new Object[0]);
            return true;
        } else if (!this.pushIdStorage.hasRegisteredDeviceId() || !str.equals(this.pushIdStorage.getRegisteredDeviceId())) {
            if (this.pushIdStorage.hasRegisteredDeviceId()) {
                this.pushIdStorage.removeRegisteredDeviceId();
                Logger.b(LOG_TAG, "Removing stored push registration response because a new one has been provided.", new Object[0]);
            }
            return false;
        } else {
            if (zendeskCallback != null) {
                zendeskCallback.onSuccess(str);
            }
            Logger.b(LOG_TAG, "Skipping registration because device is already registered with this ID.", new Object[0]);
            return true;
        }
    }

    private void getAuthTypeAndRequest(String str, TokenType tokenType, ZendeskCallback<String> zendeskCallback) {
        if (!checkForStoredPushRegistration(str, zendeskCallback)) {
            final ZendeskCallback<String> zendeskCallback2 = zendeskCallback;
            final String str2 = str;
            final TokenType tokenType2 = tokenType;
            this.settingsProvider.getCoreSettings(new PassThroughErrorZendeskCallback<CoreSettings>(zendeskCallback) {
                public void onSuccess(CoreSettings coreSettings) {
                    AuthenticationType authentication = coreSettings.getAuthentication();
                    if (authentication == null) {
                        ZendeskCallback zendeskCallback = zendeskCallback2;
                        if (zendeskCallback != null) {
                            zendeskCallback.onError(new ErrorResponseAdapter("Authentication type is null."));
                            return;
                        }
                        return;
                    }
                    ZendeskPushRegistrationProvider zendeskPushRegistrationProvider = ZendeskPushRegistrationProvider.this;
                    PushRegistrationRequest access$100 = zendeskPushRegistrationProvider.getPushRegistrationRequest(str2, zendeskPushRegistrationProvider.locale, authentication, tokenType2);
                    if (ZendeskPushRegistrationProvider.this.hasNoStoredAccessToken()) {
                        ZendeskPushRegistrationProvider.this.storePendingPushRegistrationRequest(access$100, zendeskCallback2);
                    } else {
                        ZendeskPushRegistrationProvider.this.sendPushRegistrationRequest(access$100, zendeskCallback2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public PushRegistrationRequest getPushRegistrationRequest(String str, Locale locale2, AuthenticationType authenticationType, TokenType tokenType) {
        PushRegistrationRequest pushRegistrationRequest = new PushRegistrationRequest();
        pushRegistrationRequest.setIdentifier(str);
        pushRegistrationRequest.setLocale(mz.c.d(locale2));
        if (tokenType == TokenType.UrbanAirshipChannelId) {
            pushRegistrationRequest.setTokenType(tokenType.name);
        }
        if (AuthenticationType.ANONYMOUS == authenticationType) {
            pushRegistrationRequest.setSdkGuid(this.identityManager.getSdkGuid());
        }
        return pushRegistrationRequest;
    }

    /* access modifiers changed from: private */
    public boolean hasNoStoredAccessToken() {
        return this.identityManager.getStoredAccessTokenAsBearerToken() == null;
    }

    /* access modifiers changed from: private */
    public void onSuccessfulRegistration(String str) {
        this.pushIdStorage.storeRegisteredDeviceId(str);
        this.pushIdStorage.removePushRegistrationRequest();
        this.blipsProvider.corePushEnabled();
    }

    /* access modifiers changed from: private */
    public void sendPushRegistrationRequest(PushRegistrationRequest pushRegistrationRequest, final ZendeskCallback<String> zendeskCallback) {
        this.pushService.registerDevice(new PushRegistrationRequestWrapper(pushRegistrationRequest)).enqueue(new c(new PassThroughErrorZendeskCallback<String>(zendeskCallback) {
            public void onSuccess(String str) {
                ZendeskPushRegistrationProvider.this.onSuccessfulRegistration(str);
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(str);
                }
            }
        }, PUSH_RESPONSE_EXTRACTOR));
    }

    /* access modifiers changed from: private */
    public void storePendingPushRegistrationRequest(PushRegistrationRequest pushRegistrationRequest, ZendeskCallback<String> zendeskCallback) {
        this.pushIdStorage.storePushRegistrationRequest(pushRegistrationRequest);
        if (zendeskCallback != null) {
            zendeskCallback.onSuccess(pushRegistrationRequest.getIdentifier());
        }
    }

    public boolean isRegisteredForPush() {
        return this.pushIdStorage.hasRegisteredDeviceId();
    }

    public void registerWithDeviceIdentifier(String str, ZendeskCallback<String> zendeskCallback) {
        getAuthTypeAndRequest(str, TokenType.Identifier, zendeskCallback);
    }

    public void registerWithUAChannelId(String str, ZendeskCallback<String> zendeskCallback) {
        getAuthTypeAndRequest(str, TokenType.UrbanAirshipChannelId, zendeskCallback);
    }

    public void unregisterDevice(final ZendeskCallback<Void> zendeskCallback) {
        String registeredDeviceId = this.pushIdStorage.getRegisteredDeviceId();
        final Long userId = this.identityManager.getUserId();
        if (registeredDeviceId != null) {
            this.pushService.unregisterDevice(registeredDeviceId).enqueue(new c(new PassThroughErrorZendeskCallback<Void>(zendeskCallback) {
                public void onSuccess(Void voidR) {
                    ZendeskPushRegistrationProvider.this.pushIdStorage.removeRegisteredDeviceId();
                    ZendeskPushRegistrationProvider.this.blipsProvider.corePushDisabled(userId);
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onSuccess(voidR);
                    }
                }
            }));
        }
    }

    public String sendPushRegistrationRequest(PushRegistrationRequest pushRegistrationRequest) {
        try {
            Response<PushRegistrationResponseWrapper> execute = this.pushService.registerDevice(new PushRegistrationRequestWrapper(pushRegistrationRequest)).execute();
            if (execute.body() == null || execute.body().getRegistrationResponse() == null) {
                return "";
            }
            String identifier = execute.body().getRegistrationResponse().getIdentifier();
            onSuccessfulRegistration(identifier);
            return identifier;
        } catch (IOException e11) {
            Logger.c(LOG_TAG, "Push registration request failed.", e11, new Object[0]);
            return "";
        }
    }
}

package zendesk.core;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import lz.a;
import lz.c;
import mz.f;

class ZendeskBlipsProvider implements BlipsProvider, BlipsCoreProvider {
    public static final String ACTION_CORE_INIT = "init";
    public static final String ACTION_CORE_PUSH_OFF = "PushOff";
    public static final String ACTION_CORE_PUSH_ON = "PushOn";
    public static final String BLIPS_CORE_CATEGORY = "CoreSDK";
    private static final String BLIP_VALUE_STRING = "payload";
    private static final String CHANNEL_CORE_SDK = "core_sdk";
    private static final String CODE_FIELD_NAME_STRING = "code";
    private static final String CODE_VALUE_JAVA_STRING = "java";
    private static final String CORE_VERSION_STRING = "4.1.0";
    private static final String DEVICE_INFO_FIELD_STRING = "device";
    private static final String LOG_TAG = "ZendeskBlipsProvider";
    private final String appId;
    /* access modifiers changed from: private */
    public final BlipsService blipsService;
    private final CoreSettingsStorage coreSettingsStorage;
    private final DeviceInfo deviceInfo;
    private final Executor executor;
    private final IdentityManager identityManager;
    /* access modifiers changed from: private */
    public final Serializer serializer;

    public ZendeskBlipsProvider(BlipsService blipsService2, DeviceInfo deviceInfo2, Serializer serializer2, IdentityManager identityManager2, String str, CoreSettingsStorage coreSettingsStorage2, Executor executor2) {
        this.blipsService = blipsService2;
        this.deviceInfo = deviceInfo2;
        this.serializer = serializer2;
        this.identityManager = identityManager2;
        this.appId = str;
        this.coreSettingsStorage = coreSettingsStorage2;
        this.executor = executor2;
    }

    private Map<String, Object> addDeviceInfoToValue(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("device", this.deviceInfo.getInfo());
        if (map != null && !map.isEmpty()) {
            hashMap.put("payload", map);
        }
        return hashMap;
    }

    public void coreInitialized() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", "java");
        sendBlip(new UserAction("4.1.0", CHANNEL_CORE_SDK, BLIPS_CORE_CATEGORY, ACTION_CORE_INIT, (String) null, hashMap), BlipsGroup.REQUIRED);
    }

    public void corePushDisabled(Long l11) {
        sendBlip(BlipsGroup.REQUIRED, new UserAction("4.1.0", CHANNEL_CORE_SDK, BLIPS_CORE_CATEGORY, ACTION_CORE_PUSH_OFF), l11);
    }

    public void corePushEnabled() {
        sendBlip(new UserAction("4.1.0", CHANNEL_CORE_SDK, BLIPS_CORE_CATEGORY, ACTION_CORE_PUSH_ON), BlipsGroup.REQUIRED);
    }

    public BlipsRequest createBlipsRequest(UserAction userAction, String str, String str2, Long l11) {
        return BlipsRequest.buildUserAction(str, BlipsFormatHelper.nowAsString(new Date()), l11, str2, userAction.getVersion(), userAction.getChannel(), userAction.getCategory(), userAction.getAction(), userAction.getLabel(), addDeviceInfoToValue(userAction.getValue()));
    }

    public void dispatchBlip(final BlipsRequest blipsRequest) {
        this.executor.execute(new Runnable() {
            public void run() {
                ZendeskBlipsProvider.this.blipsService.send(ZendeskBlipsProvider.this.serializer.serialize(blipsRequest)).enqueue(new c(new ZendeskCallback<Void>() {
                    public void onError(a aVar) {
                        Logger.b(ZendeskBlipsProvider.LOG_TAG, "Unable to send Blip | Error: %s", aVar.getReason());
                    }

                    public void onSuccess(Void voidR) {
                    }
                }));
            }
        });
    }

    public void sendBlip(UserAction userAction, BlipsGroup blipsGroup) {
        sendBlip(blipsGroup, userAction, this.identityManager.getUserId());
    }

    public void sendBlip(BlipsGroup blipsGroup, UserAction userAction, Long l11) {
        if (this.coreSettingsStorage.getBlipsSettings().getBlipsPermissions().isEnabled(blipsGroup) && f.c(userAction.getChannel())) {
            dispatchBlip(createBlipsRequest(userAction, this.identityManager.getBlipsUuid(), this.appId, l11));
        }
    }

    public BlipsRequest createBlipsRequest(PageView pageView, String str, String str2, Long l11) {
        return BlipsRequest.buildPageView(str, BlipsFormatHelper.nowAsString(new Date()), l11, str2, pageView.getVersion(), pageView.getChannel(), pageView.getUrl(), pageView.getNavigatorLanguage(), pageView.getPageTitle(), pageView.getPageId(), pageView.getPageLocale(), addDeviceInfoToValue(pageView.getValue()));
    }

    public void sendBlip(PageView pageView, BlipsGroup blipsGroup) {
        if (this.coreSettingsStorage.getBlipsSettings().getBlipsPermissions().isEnabled(blipsGroup) && f.c(pageView.getChannel())) {
            dispatchBlip(createBlipsRequest(pageView, this.identityManager.getBlipsUuid(), this.appId, this.identityManager.getUserId()));
        }
    }
}

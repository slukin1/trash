package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public abstract class Service {

    public static abstract class ServiceEvent {
        private static final int PLATFORM = 1;
        public Service service;

        public ServiceEvent(Service service2) {
            this.service = service2;
        }

        public HashMap<String, Object> filterShareContent(int i11, Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
            Platform platform;
            try {
                platform = ShareSDK.getPlatform(ShareSDK.platformIdToName(i11));
            } catch (Throwable th2) {
                SSDKLog b11 = SSDKLog.b();
                b11.a("ShareSDK Service filterShareContent catch: " + th2, new Object[0]);
                platform = null;
            }
            if (platform == null) {
                return null;
            }
            f.a filterShareContent = platform.filterShareContent(shareParams, hashMap);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("shareID", filterShareContent.f13362a);
            hashMap2.put("shareContent", new Hashon().fromJson(filterShareContent.toString()));
            SSDKLog.b().c("filterShareContent ==>>%s", hashMap2);
            return hashMap2;
        }

        public final void toString(final ShareSDKCallback<String> shareSDKCallback) {
            DH.requester(MobSDK.getContext()).getDeviceDataNotAES().getDetailNetworkTypeForStatic().getDeviceKey().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("deviceid", dHResponse.getDeviceKey());
                        hashMap.put("appkey", MobSDK.getAppkey());
                        hashMap.put("apppkg", DH.SyncMtd.getPackageName());
                        hashMap.put("appver", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                        hashMap.put("sdkver", Integer.valueOf(ServiceEvent.this.service.getServiceVersionInt()));
                        hashMap.put("plat", 1);
                        hashMap.put("networktype", dHResponse.getDetailNetworkTypeForStatic());
                        hashMap.put("deviceData", dHResponse.getDeviceDataNotAES());
                        shareSDKCallback.onCallback(new Hashon().fromHashMap(hashMap));
                    } catch (Throwable th2) {
                        SSDKLog.b().a(th2);
                    }
                }
            });
        }
    }

    @Deprecated
    public String getDeviceKey() {
        return null;
    }

    public void getDeviceKey(final ShareSDKCallback<String> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                String deviceKey = dHResponse.getDeviceKey();
                if (TextUtils.isEmpty(deviceKey)) {
                    ShareSDKCallback shareSDKCallback = shareSDKCallback;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(null);
                        return;
                    }
                    return;
                }
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(deviceKey);
                }
            }
        });
    }

    public abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void onBind() {
    }

    public void onUnbind() {
    }
}

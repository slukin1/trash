package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.ConfigData;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mob.MobSDK;
import com.mob.tools.RxMob;
import com.mob.tools.utils.DH;
import java.util.HashMap;

public class Protocol$1 extends RxMob.QuickSubscribe<ConfigData> {
    public final /* synthetic */ boolean val$defaultConfUrl;

    public Protocol$1(boolean z11) {
        this.val$defaultConfUrl = z11;
    }

    public void doNext(RxMob.Subscriber<ConfigData> subscriber) throws Throwable {
        boolean b11 = AppStatus.a().b();
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", MobSDK.getAppkey());
        hashMap.put("plat", "1");
        hashMap.put("sysver", DH.SyncMtd.getOSVersionName());
        hashMap.put("appver", DH.SyncMtd.getAppVersionName());
        hashMap.put("apppkg", DH.SyncMtd.getPackageName());
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, DH.SyncMtd.getModel());
        hashMap.put("duid", e.i());
        hashMap.put("status", String.valueOf(b11));
        subscriber.onNext((ConfigData) e.b(hashMap, e.b(e.b(this.val$defaultConfUrl)), ConfigData.class));
    }
}

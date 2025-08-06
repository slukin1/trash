package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.ConfigData;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.RxMob;

public class Protocol$2 extends RxMob.Subscriber<ConfigData> {
    public final /* synthetic */ String val$sdkTag;

    public Protocol$2(String str) {
        this.val$sdkTag = str;
    }

    public void onNext(ConfigData configData) {
        if (e.e(configData)) {
            f.a(e.f13721b.fromObject(configData));
        }
        EventRecorder.addEnd(this.val$sdkTag, "event_id_config");
        ConfigData unused = e.f13722c = configData;
    }
}

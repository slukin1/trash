package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$5 extends RxMob.QuickSubscribe<SceneData> {
    public final /* synthetic */ String val$linkId;

    public AsyncProtocolInMain$5(String str) {
        this.val$linkId = str;
    }

    public void doNext(RxMob.Subscriber<SceneData> subscriber) {
        subscriber.onNext(e.a(this.val$linkId));
    }
}

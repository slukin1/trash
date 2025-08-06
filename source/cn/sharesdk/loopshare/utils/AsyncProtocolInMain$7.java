package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$7 extends RxMob.QuickSubscribe<SceneData> {
    public final /* synthetic */ String val$mobId;

    public AsyncProtocolInMain$7(String str) {
        this.val$mobId = str;
    }

    public void doNext(RxMob.Subscriber<SceneData> subscriber) {
        subscriber.onNext(e.a(this.val$mobId));
    }
}

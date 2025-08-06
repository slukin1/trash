package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$9 extends RxMob.QuickSubscribe<SceneData> {
    public final /* synthetic */ int val$status;

    public AsyncProtocolInMain$9(int i11) {
        this.val$status = i11;
    }

    public void doNext(RxMob.Subscriber<SceneData> subscriber) {
        subscriber.onNext(e.a(this.val$status));
    }
}

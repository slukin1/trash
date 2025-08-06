package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.beans.LinkData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$1 extends RxMob.QuickSubscribe<LinkData> {
    public final /* synthetic */ Scene val$scene;

    public AsyncProtocolInMain$1(Scene scene) {
        this.val$scene = scene;
    }

    public void doNext(RxMob.Subscriber<LinkData> subscriber) {
        subscriber.onNext(e.a(this.val$scene.getPath(), this.val$scene.getParams()));
    }
}

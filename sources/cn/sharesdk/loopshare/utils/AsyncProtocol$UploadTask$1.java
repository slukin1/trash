package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.LogData;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.tools.RxMob;

public class AsyncProtocol$UploadTask$1 extends RxMob.QuickSubscribe<LogData> {
    public final /* synthetic */ AsyncProtocol.b this$0;

    public AsyncProtocol$UploadTask$1(AsyncProtocol.b bVar) {
        this.this$0 = bVar;
    }

    public void doNext(RxMob.Subscriber<LogData> subscriber) throws Throwable {
        String a11 = this.this$0.f13685d;
        AsyncProtocol.b bVar = this.this$0;
        subscriber.onNext(e.a(a11, bVar.f13683b, bVar.f13684c));
    }
}

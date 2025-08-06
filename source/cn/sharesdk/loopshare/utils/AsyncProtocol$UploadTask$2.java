package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.LogData;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.tools.RxMob;

public class AsyncProtocol$UploadTask$2 extends RxMob.Subscriber<LogData> {
    public final /* synthetic */ AsyncProtocol.b this$0;

    public AsyncProtocol$UploadTask$2(AsyncProtocol.b bVar) {
        this.this$0 = bVar;
    }

    private void onEnd(LogData logData) {
        if (logData == null || 200 != logData.h()) {
            this.this$0.b();
        }
    }

    public void onError(Throwable th2) {
        onEnd((LogData) null);
    }

    public void onNext(LogData logData) {
        onEnd(logData);
    }
}

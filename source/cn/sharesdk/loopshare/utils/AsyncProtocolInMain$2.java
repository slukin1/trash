package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.beans.LinkData;
import cn.sharesdk.loopshare.beans.ServerData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$2 extends RxMob.Subscriber<LinkData> {
    public final /* synthetic */ ActionListener val$listener;

    public AsyncProtocolInMain$2(ActionListener actionListener) {
        this.val$listener = actionListener;
    }

    public void onNext(LinkData linkData) {
        if (this.val$listener != null) {
            if (ServerData.a((ServerData) linkData)) {
                this.val$listener.onResult(linkData.a());
                return;
            }
            this.val$listener.onError(new Throwable(linkData.i()));
        }
    }
}

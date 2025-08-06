package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$4 extends RxMob.Subscriber<ConfigData> {
    public final /* synthetic */ AsyncProtocol.DataListener val$l;

    public AsyncProtocolInMain$4(AsyncProtocol.DataListener dataListener) {
        this.val$l = dataListener;
    }

    public void onNext(ConfigData configData) {
        AsyncProtocol.DataListener dataListener = this.val$l;
        if (dataListener != null) {
            dataListener.onReceiveData(configData);
        }
    }
}

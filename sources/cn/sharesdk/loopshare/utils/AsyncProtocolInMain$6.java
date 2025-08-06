package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$6 extends RxMob.Subscriber<SceneData> {
    public final /* synthetic */ AsyncProtocol.DataListener val$l;

    public AsyncProtocolInMain$6(AsyncProtocol.DataListener dataListener) {
        this.val$l = dataListener;
    }

    public void onNext(SceneData sceneData) {
        AsyncProtocol.DataListener dataListener = this.val$l;
        if (dataListener != null) {
            dataListener.onReceiveData(sceneData);
        }
    }
}

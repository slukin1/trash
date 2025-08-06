package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;

public class AsyncProtocolInMain$8 extends RxMob.Subscriber<SceneData> {
    public final /* synthetic */ ActionListener val$listener;

    public AsyncProtocolInMain$8(ActionListener actionListener) {
        this.val$listener = actionListener;
    }

    public void onNext(SceneData sceneData) {
        ActionListener actionListener = this.val$listener;
        if (actionListener != null) {
            actionListener.onResult(sceneData);
        }
    }
}

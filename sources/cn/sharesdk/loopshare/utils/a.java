package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.utils.AsyncProtocol;
import com.mob.tools.RxMob;

public class a {
    public static void a(Scene scene, ActionListener<String> actionListener) {
        RxMob.Subscribable create = RxMob.create(new AsyncProtocolInMain$1(scene));
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.UI_THREAD);
        create.subscribe(new AsyncProtocolInMain$2(actionListener));
    }

    public static void a(AsyncProtocol.DataListener<ConfigData> dataListener) {
        RxMob.Subscribable create = RxMob.create(new AsyncProtocolInMain$3());
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.UI_THREAD);
        create.subscribe(new AsyncProtocolInMain$4(dataListener));
    }

    public static void a(String str, AsyncProtocol.DataListener<SceneData> dataListener) {
        RxMob.Subscribable create = RxMob.create(new AsyncProtocolInMain$5(str));
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.UI_THREAD);
        create.subscribe(new AsyncProtocolInMain$6(dataListener));
    }

    public static void a(int i11, AsyncProtocol.DataListener<SceneData> dataListener) {
        RxMob.Subscribable create = RxMob.create(new AsyncProtocolInMain$9(i11));
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.UI_THREAD);
        create.subscribe(new AsyncProtocolInMain$10(dataListener));
    }
}

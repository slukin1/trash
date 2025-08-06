package com.tencent.qcloud.tuikit.tuibarrage.manager;

import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;

public abstract class TUIBarrageCallBack {
    public void onCustomCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
    }

    public abstract void onFailed(int i11, String str);

    public void onTextCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
    }
}

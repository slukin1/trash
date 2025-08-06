package com.tencent.qcloud.tuikit.tuibarrage.view;

import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;

public interface ITUIBarrageListener {
    void onFailed(int i11, String str);

    void onSuccess(int i11, TUIBarrageMessage tUIBarrageMessage);
}

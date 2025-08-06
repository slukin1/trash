package com.tencent.qcloud.tuikit.tuibarrage.manager;

import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;

public interface IHbBarrageManager {
    void addBarrageCallBack(TUIBarrageCallBack tUIBarrageCallBack);

    void init(String str);

    void receiveCustomBarrage(TUIBarrageMessage tUIBarrageMessage);

    void receiveTextBarrage(TUIBarrageMessage tUIBarrageMessage);

    void sendCustomBarrage(TUIBarrageMessage tUIBarrageMessage, TUIBarrageCallBack tUIBarrageCallBack);

    void sendTextBarrage(String str, TUIBarrageCallBack tUIBarrageCallBack);
}

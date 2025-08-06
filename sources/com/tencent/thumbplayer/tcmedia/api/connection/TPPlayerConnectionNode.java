package com.tencent.thumbplayer.tcmedia.api.connection;

import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.tcmedia.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode {
    private TPNativePlayerConnectionNode nativeNode = new TPNativePlayerConnectionNode();

    public boolean addAction(@TPPlayerConnectionConstant.Action int i11) {
        return this.nativeNode.addAction(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, i11));
    }

    public TPNativePlayerConnectionNode getNativeNode() {
        return this.nativeNode;
    }

    public void removeAction(@TPPlayerConnectionConstant.Action int i11) {
        this.nativeNode.removeAction(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, i11));
    }

    public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int i11, int i12, long j11) {
        return this.nativeNode.setLongActionConfig(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionAction.class, i11), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapConnectionConfig.class, i12), j11);
    }
}

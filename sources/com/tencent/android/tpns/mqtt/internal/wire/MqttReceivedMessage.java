package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttMessage;

public class MqttReceivedMessage extends MqttMessage {
    public int getMessageId() {
        return super.getId();
    }

    public void setDuplicate(boolean z11) {
        super.setDuplicate(z11);
    }

    public void setMessageId(int i11) {
        super.setId(i11);
    }
}

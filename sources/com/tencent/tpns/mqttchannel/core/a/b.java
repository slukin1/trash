package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;

public abstract class b extends IMqttCallback.a {
    public abstract void callback(int i11, String str);

    public final void handleCallback(final int i11, final String str) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                b.this.callback(i11, str);
            }
        });
    }
}

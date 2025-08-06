package com.huobi.app.startuptasks;

import com.huobi.app.rms.wrapper.HBDynamicPathFetchImpl;
import e6.c;
import e6.i;

public final class RMSTask extends BaseAppStartTask {
    public void c() {
        HBDynamicPathFetchImpl hBDynamicPathFetchImpl = new HBDynamicPathFetchImpl();
        i.q().p(hBDynamicPathFetchImpl);
        c.r("RMS").p(hBDynamicPathFetchImpl);
    }
}

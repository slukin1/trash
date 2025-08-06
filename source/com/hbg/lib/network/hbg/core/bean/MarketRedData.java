package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MarketRedData implements Serializable {
    public int contentTableCount;
    public int moniterCount;
    public int newsflashCount;

    public boolean displayCollectionRed() {
        return this.moniterCount > 0;
    }

    public boolean displayContentTabRed() {
        return this.contentTableCount > 0;
    }

    public boolean displayTabRed() {
        return this.moniterCount > 0 || this.contentTableCount > 0;
    }
}

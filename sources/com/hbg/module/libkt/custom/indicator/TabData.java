package com.hbg.module.libkt.custom.indicator;

import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class TabData implements Serializable {
    private final String name;
    private int tabId;
    private final int type;

    public TabData(String str, int i11, int i12) {
        this.name = str;
        this.type = i11;
        this.tabId = i12;
    }

    public static /* synthetic */ TabData copy$default(TabData tabData, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = tabData.name;
        }
        if ((i13 & 2) != 0) {
            i11 = tabData.type;
        }
        if ((i13 & 4) != 0) {
            i12 = tabData.tabId;
        }
        return tabData.copy(str, i11, i12);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.tabId;
    }

    public final TabData copy(String str, int i11, int i12) {
        return new TabData(str, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabData)) {
            return false;
        }
        TabData tabData = (TabData) obj;
        return x.b(this.name, tabData.name) && this.type == tabData.type && this.tabId == tabData.tabId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.type) * 31) + this.tabId;
    }

    public final void setTabId(int i11) {
        this.tabId = i11;
    }

    public String toString() {
        return "TabData(name=" + this.name + ", type=" + this.type + ", tabId=" + this.tabId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabData(String str, int i11, int i12, int i13, r rVar) {
        this(str, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
    }
}

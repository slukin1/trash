package com.huobi.zeroswap.model;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class ZeroSwapTabModel implements Serializable {
    private final List<TabItemModel> tabs;

    public ZeroSwapTabModel() {
        this((List) null, 1, (r) null);
    }

    public ZeroSwapTabModel(List<TabItemModel> list) {
        this.tabs = list;
    }

    public static /* synthetic */ ZeroSwapTabModel copy$default(ZeroSwapTabModel zeroSwapTabModel, List<TabItemModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = zeroSwapTabModel.tabs;
        }
        return zeroSwapTabModel.copy(list);
    }

    public final List<TabItemModel> component1() {
        return this.tabs;
    }

    public final ZeroSwapTabModel copy(List<TabItemModel> list) {
        return new ZeroSwapTabModel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZeroSwapTabModel) && x.b(this.tabs, ((ZeroSwapTabModel) obj).tabs);
    }

    public final List<TabItemModel> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        return this.tabs.hashCode();
    }

    public String toString() {
        return "ZeroSwapTabModel(tabs=" + this.tabs + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ZeroSwapTabModel(List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }
}

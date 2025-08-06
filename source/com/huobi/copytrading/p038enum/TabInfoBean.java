package com.huobi.copytrading.p038enum;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.x;

/* renamed from: com.huobi.copytrading.enum.TabInfoBean  reason: invalid package */
public final class TabInfoBean implements Serializable {
    private final ActionBar actionBar;
    private final Integer hasTraderRight;
    private final History history;
    private final String isTrader;
    private final List<Tab> tabs;

    public TabInfoBean(History history2, List<Tab> list, ActionBar actionBar2, String str, Integer num) {
        this.history = history2;
        this.tabs = list;
        this.actionBar = actionBar2;
        this.isTrader = str;
        this.hasTraderRight = num;
    }

    public static /* synthetic */ TabInfoBean copy$default(TabInfoBean tabInfoBean, History history2, List<Tab> list, ActionBar actionBar2, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            history2 = tabInfoBean.history;
        }
        if ((i11 & 2) != 0) {
            list = tabInfoBean.tabs;
        }
        List<Tab> list2 = list;
        if ((i11 & 4) != 0) {
            actionBar2 = tabInfoBean.actionBar;
        }
        ActionBar actionBar3 = actionBar2;
        if ((i11 & 8) != 0) {
            str = tabInfoBean.isTrader;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            num = tabInfoBean.hasTraderRight;
        }
        return tabInfoBean.copy(history2, list2, actionBar3, str2, num);
    }

    public final History component1() {
        return this.history;
    }

    public final List<Tab> component2() {
        return this.tabs;
    }

    public final ActionBar component3() {
        return this.actionBar;
    }

    public final String component4() {
        return this.isTrader;
    }

    public final Integer component5() {
        return this.hasTraderRight;
    }

    public final TabInfoBean copy(History history2, List<Tab> list, ActionBar actionBar2, String str, Integer num) {
        return new TabInfoBean(history2, list, actionBar2, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabInfoBean)) {
            return false;
        }
        TabInfoBean tabInfoBean = (TabInfoBean) obj;
        return x.b(this.history, tabInfoBean.history) && x.b(this.tabs, tabInfoBean.tabs) && x.b(this.actionBar, tabInfoBean.actionBar) && x.b(this.isTrader, tabInfoBean.isTrader) && x.b(this.hasTraderRight, tabInfoBean.hasTraderRight);
    }

    public final ActionBar getActionBar() {
        return this.actionBar;
    }

    public final Integer getHasTraderRight() {
        return this.hasTraderRight;
    }

    public final History getHistory() {
        return this.history;
    }

    public final List<Tab> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        History history2 = this.history;
        int i11 = 0;
        int hashCode = (history2 == null ? 0 : history2.hashCode()) * 31;
        List<Tab> list = this.tabs;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        ActionBar actionBar2 = this.actionBar;
        int hashCode3 = (hashCode2 + (actionBar2 == null ? 0 : actionBar2.hashCode())) * 31;
        String str = this.isTrader;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.hasTraderRight;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode4 + i11;
    }

    public final String isTrader() {
        return this.isTrader;
    }

    public String toString() {
        return "TabInfoBean(history=" + this.history + ", tabs=" + this.tabs + ", actionBar=" + this.actionBar + ", isTrader=" + this.isTrader + ", hasTraderRight=" + this.hasTraderRight + ')';
    }
}

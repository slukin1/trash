package com.huobi.copytrading.p038enum;

import java.io.Serializable;
import kotlin.jvm.internal.x;

/* renamed from: com.huobi.copytrading.enum.ActionBar  reason: invalid package */
public final class ActionBar implements Serializable {
    private final String icon;
    private final String title;

    public ActionBar(String str, String str2) {
        this.title = str;
        this.icon = str2;
    }

    public static /* synthetic */ ActionBar copy$default(ActionBar actionBar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = actionBar.title;
        }
        if ((i11 & 2) != 0) {
            str2 = actionBar.icon;
        }
        return actionBar.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final ActionBar copy(String str, String str2) {
        return new ActionBar(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionBar)) {
            return false;
        }
        ActionBar actionBar = (ActionBar) obj;
        return x.b(this.title, actionBar.title) && x.b(this.icon, actionBar.icon);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.icon;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "ActionBar(title=" + this.title + ", icon=" + this.icon + ')';
    }
}

package com.huobi.edgeengine.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class NavModel implements Serializable {
    private final Action action;
    private final String icon;
    private final String text;

    public NavModel(String str, Action action2, String str2) {
        this.icon = str;
        this.action = action2;
        this.text = str2;
    }

    public static /* synthetic */ NavModel copy$default(NavModel navModel, String str, Action action2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = navModel.icon;
        }
        if ((i11 & 2) != 0) {
            action2 = navModel.action;
        }
        if ((i11 & 4) != 0) {
            str2 = navModel.text;
        }
        return navModel.copy(str, action2, str2);
    }

    public final String component1() {
        return this.icon;
    }

    public final Action component2() {
        return this.action;
    }

    public final String component3() {
        return this.text;
    }

    public final NavModel copy(String str, Action action2, String str2) {
        return new NavModel(str, action2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavModel)) {
            return false;
        }
        NavModel navModel = (NavModel) obj;
        return x.b(this.icon, navModel.icon) && x.b(this.action, navModel.action) && x.b(this.text, navModel.text);
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.icon;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Action action2 = this.action;
        int hashCode2 = (hashCode + (action2 == null ? 0 : action2.hashCode())) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "NavModel(icon=" + this.icon + ", action=" + this.action + ", text=" + this.text + ')';
    }
}

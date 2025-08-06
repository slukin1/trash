package com.huobi.edgeengine.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class Action implements Serializable {
    private final String parameter;
    private final String type;

    public Action(String str, String str2) {
        this.type = str;
        this.parameter = str2;
    }

    public static /* synthetic */ Action copy$default(Action action, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = action.type;
        }
        if ((i11 & 2) != 0) {
            str2 = action.parameter;
        }
        return action.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.parameter;
    }

    public final Action copy(String str, String str2) {
        return new Action(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return x.b(this.type, action.type) && x.b(this.parameter, action.parameter);
    }

    public final String getParameter() {
        return this.parameter;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parameter;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "Action(type=" + this.type + ", parameter=" + this.parameter + ')';
    }
}

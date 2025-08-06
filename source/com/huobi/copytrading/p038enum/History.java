package com.huobi.copytrading.p038enum;

import java.io.Serializable;
import kotlin.jvm.internal.x;

/* renamed from: com.huobi.copytrading.enum.History  reason: invalid package */
public final class History implements Serializable {
    private final String module;
    private final String template;

    public History(String str, String str2) {
        this.module = str;
        this.template = str2;
    }

    public static /* synthetic */ History copy$default(History history, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = history.module;
        }
        if ((i11 & 2) != 0) {
            str2 = history.template;
        }
        return history.copy(str, str2);
    }

    public final String component1() {
        return this.module;
    }

    public final String component2() {
        return this.template;
    }

    public final History copy(String str, String str2) {
        return new History(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof History)) {
            return false;
        }
        History history = (History) obj;
        return x.b(this.module, history.module) && x.b(this.template, history.template);
    }

    public final String getModule() {
        return this.module;
    }

    public final String getTemplate() {
        return this.template;
    }

    public int hashCode() {
        String str = this.module;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.template;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "History(module=" + this.module + ", template=" + this.template + ')';
    }
}

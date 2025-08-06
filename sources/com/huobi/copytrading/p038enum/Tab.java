package com.huobi.copytrading.p038enum;

import java.io.Serializable;
import kotlin.jvm.internal.x;

/* renamed from: com.huobi.copytrading.enum.Tab  reason: invalid package */
public final class Tab implements Serializable {
    private final String module;
    private final String onAppear;
    private final String onSelectedIndex;
    private final String onTitleChange;
    private final String template;
    private final String title;

    public Tab(String str, String str2, String str3, String str4, String str5, String str6) {
        this.module = str;
        this.onAppear = str2;
        this.onTitleChange = str3;
        this.template = str4;
        this.title = str5;
        this.onSelectedIndex = str6;
    }

    public static /* synthetic */ Tab copy$default(Tab tab, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tab.module;
        }
        if ((i11 & 2) != 0) {
            str2 = tab.onAppear;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tab.onTitleChange;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tab.template;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tab.title;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tab.onSelectedIndex;
        }
        return tab.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.module;
    }

    public final String component2() {
        return this.onAppear;
    }

    public final String component3() {
        return this.onTitleChange;
    }

    public final String component4() {
        return this.template;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.onSelectedIndex;
    }

    public final Tab copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new Tab(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tab)) {
            return false;
        }
        Tab tab = (Tab) obj;
        return x.b(this.module, tab.module) && x.b(this.onAppear, tab.onAppear) && x.b(this.onTitleChange, tab.onTitleChange) && x.b(this.template, tab.template) && x.b(this.title, tab.title) && x.b(this.onSelectedIndex, tab.onSelectedIndex);
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOnAppear() {
        return this.onAppear;
    }

    public final String getOnSelectedIndex() {
        return this.onSelectedIndex;
    }

    public final String getOnTitleChange() {
        return this.onTitleChange;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.module;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.onAppear;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.onTitleChange;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.template;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.onSelectedIndex;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode5 + i11;
    }

    public String toString() {
        return "Tab(module=" + this.module + ", onAppear=" + this.onAppear + ", onTitleChange=" + this.onTitleChange + ", template=" + this.template + ", title=" + this.title + ", onSelectedIndex=" + this.onSelectedIndex + ')';
    }
}

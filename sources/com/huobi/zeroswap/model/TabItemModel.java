package com.huobi.zeroswap.model;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class TabItemModel implements Serializable {
    private final String module;
    private final String onAppear;
    private final String template;
    private final String title;

    public TabItemModel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (r) null);
    }

    public TabItemModel(String str, String str2, String str3, String str4) {
        this.title = str;
        this.template = str2;
        this.module = str3;
        this.onAppear = str4;
    }

    public static /* synthetic */ TabItemModel copy$default(TabItemModel tabItemModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tabItemModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tabItemModel.template;
        }
        if ((i11 & 4) != 0) {
            str3 = tabItemModel.module;
        }
        if ((i11 & 8) != 0) {
            str4 = tabItemModel.onAppear;
        }
        return tabItemModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.template;
    }

    public final String component3() {
        return this.module;
    }

    public final String component4() {
        return this.onAppear;
    }

    public final TabItemModel copy(String str, String str2, String str3, String str4) {
        return new TabItemModel(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabItemModel)) {
            return false;
        }
        TabItemModel tabItemModel = (TabItemModel) obj;
        return x.b(this.title, tabItemModel.title) && x.b(this.template, tabItemModel.template) && x.b(this.module, tabItemModel.module) && x.b(this.onAppear, tabItemModel.onAppear);
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOnAppear() {
        return this.onAppear;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.template.hashCode()) * 31) + this.module.hashCode()) * 31) + this.onAppear.hashCode();
    }

    public String toString() {
        return "TabItemModel(title=" + this.title + ", template=" + this.template + ", module=" + this.module + ", onAppear=" + this.onAppear + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabItemModel(String str, String str2, String str3, String str4, int i11, r rVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4);
    }
}

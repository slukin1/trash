package com.huobi.edgeengine.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class EdgeEngineNavModel implements Serializable {
    private final String backgroundColor;
    private final NavModel left;
    private final NavModel right;
    private final String title;
    private final String titleKey;

    public EdgeEngineNavModel(NavModel navModel, NavModel navModel2, String str, String str2, String str3) {
        this.left = navModel;
        this.right = navModel2;
        this.title = str;
        this.titleKey = str2;
        this.backgroundColor = str3;
    }

    public static /* synthetic */ EdgeEngineNavModel copy$default(EdgeEngineNavModel edgeEngineNavModel, NavModel navModel, NavModel navModel2, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            navModel = edgeEngineNavModel.left;
        }
        if ((i11 & 2) != 0) {
            navModel2 = edgeEngineNavModel.right;
        }
        NavModel navModel3 = navModel2;
        if ((i11 & 4) != 0) {
            str = edgeEngineNavModel.title;
        }
        String str4 = str;
        if ((i11 & 8) != 0) {
            str2 = edgeEngineNavModel.titleKey;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            str3 = edgeEngineNavModel.backgroundColor;
        }
        return edgeEngineNavModel.copy(navModel, navModel3, str4, str5, str3);
    }

    public final NavModel component1() {
        return this.left;
    }

    public final NavModel component2() {
        return this.right;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.titleKey;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final EdgeEngineNavModel copy(NavModel navModel, NavModel navModel2, String str, String str2, String str3) {
        return new EdgeEngineNavModel(navModel, navModel2, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeEngineNavModel)) {
            return false;
        }
        EdgeEngineNavModel edgeEngineNavModel = (EdgeEngineNavModel) obj;
        return x.b(this.left, edgeEngineNavModel.left) && x.b(this.right, edgeEngineNavModel.right) && x.b(this.title, edgeEngineNavModel.title) && x.b(this.titleKey, edgeEngineNavModel.titleKey) && x.b(this.backgroundColor, edgeEngineNavModel.backgroundColor);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final NavModel getLeft() {
        return this.left;
    }

    public final NavModel getRight() {
        return this.right;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleKey() {
        return this.titleKey;
    }

    public int hashCode() {
        NavModel navModel = this.left;
        int i11 = 0;
        int hashCode = (navModel == null ? 0 : navModel.hashCode()) * 31;
        NavModel navModel2 = this.right;
        int hashCode2 = (hashCode + (navModel2 == null ? 0 : navModel2.hashCode())) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.titleKey;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "EdgeEngineNavModel(left=" + this.left + ", right=" + this.right + ", title=" + this.title + ", titleKey=" + this.titleKey + ", backgroundColor=" + this.backgroundColor + ')';
    }
}

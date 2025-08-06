package com.huochat.community.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public class CommunitySymbolBean implements Serializable {
    private String baseCurrency;
    private String communityId;
    private String communityName;

    /* renamed from: id  reason: collision with root package name */
    private String f38698id;
    private String priceCurrency;
    private String symbol;

    public CommunitySymbolBean() {
        this.f38698id = "0";
        this.communityId = "-1";
        this.communityName = "";
        this.symbol = "";
        this.baseCurrency = "";
        this.priceCurrency = "";
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CommunitySymbolBean)) {
            return false;
        }
        String symbol2 = getSymbol();
        if ((symbol2 == null || symbol2.length() == 0) || !StringsKt__StringsJVMKt.x(getSymbol(), ((CommunitySymbolBean) obj).getSymbol(), false, 2, (Object) null)) {
            String communityId2 = getCommunityId();
            if ((communityId2 == null || communityId2.length() == 0) || !StringsKt__StringsJVMKt.x(getCommunityId(), ((CommunitySymbolBean) obj).getCommunityId(), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public final String getBaseCurrency() {
        return this.baseCurrency;
    }

    public final String getCommunityId() {
        String str = this.communityId;
        if ((str == null || str.length() == 0) || x.b(this.communityId, "-1")) {
            this.communityId = this.f38698id;
        }
        return this.communityId;
    }

    public final String getCommunityName() {
        return this.communityName;
    }

    public final String getId() {
        return this.f38698id;
    }

    public final String getPriceCurrency() {
        return this.priceCurrency;
    }

    public final String getSymbol() {
        String lowerCase;
        String str = this.symbol;
        boolean z11 = false;
        if (str == null || str.length() == 0) {
            String str2 = this.baseCurrency;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = this.priceCurrency;
                if (str3 == null || str3.length() == 0) {
                    z11 = true;
                }
                if (!z11) {
                    this.symbol = (this.baseCurrency + this.priceCurrency).toLowerCase();
                }
            }
        }
        String str4 = this.symbol;
        return (str4 == null || (lowerCase = str4.toLowerCase()) == null) ? "" : lowerCase;
    }

    public final void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public final void setCommunityId(String str) {
        this.communityId = str;
    }

    public final void setCommunityName(String str) {
        this.communityName = str;
    }

    public final void setId(String str) {
        this.f38698id = str;
    }

    public final void setPriceCurrency(String str) {
        this.priceCurrency = str;
    }

    public final void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "CommunitySymbolBean(id=" + this.f38698id + ", communityName=" + this.communityName + ", baseCurrency=" + this.baseCurrency + ", priceCurrency=" + this.priceCurrency + ", symbol=" + getSymbol() + ')';
    }

    public CommunitySymbolBean(String str, String str2, String str3) {
        this();
        this.f38698id = str;
        this.communityId = str;
        this.communityName = str2;
        this.symbol = str3;
    }
}

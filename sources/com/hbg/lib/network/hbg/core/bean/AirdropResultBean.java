package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropResultBean {
    private final String currentUrl;
    private final List<AirdropDrawDetailBean> drawDetailList;
    private final String nextUrl;
    private final Boolean result;

    public AirdropResultBean() {
        this((Boolean) null, (List) null, (String) null, (String) null, 15, (r) null);
    }

    public AirdropResultBean(Boolean bool, List<AirdropDrawDetailBean> list, String str, String str2) {
        this.result = bool;
        this.drawDetailList = list;
        this.currentUrl = str;
        this.nextUrl = str2;
    }

    public static /* synthetic */ AirdropResultBean copy$default(AirdropResultBean airdropResultBean, Boolean bool, List<AirdropDrawDetailBean> list, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = airdropResultBean.result;
        }
        if ((i11 & 2) != 0) {
            list = airdropResultBean.drawDetailList;
        }
        if ((i11 & 4) != 0) {
            str = airdropResultBean.currentUrl;
        }
        if ((i11 & 8) != 0) {
            str2 = airdropResultBean.nextUrl;
        }
        return airdropResultBean.copy(bool, list, str, str2);
    }

    public final Boolean component1() {
        return this.result;
    }

    public final List<AirdropDrawDetailBean> component2() {
        return this.drawDetailList;
    }

    public final String component3() {
        return this.currentUrl;
    }

    public final String component4() {
        return this.nextUrl;
    }

    public final AirdropResultBean copy(Boolean bool, List<AirdropDrawDetailBean> list, String str, String str2) {
        return new AirdropResultBean(bool, list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropResultBean)) {
            return false;
        }
        AirdropResultBean airdropResultBean = (AirdropResultBean) obj;
        return x.b(this.result, airdropResultBean.result) && x.b(this.drawDetailList, airdropResultBean.drawDetailList) && x.b(this.currentUrl, airdropResultBean.currentUrl) && x.b(this.nextUrl, airdropResultBean.nextUrl);
    }

    public final String getCurrentUrl() {
        return this.currentUrl;
    }

    public final List<AirdropDrawDetailBean> getDrawDetailList() {
        return this.drawDetailList;
    }

    public final String getNextUrl() {
        return this.nextUrl;
    }

    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.result;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<AirdropDrawDetailBean> list = this.drawDetailList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.currentUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "AirdropResultBean(result=" + this.result + ", drawDetailList=" + this.drawDetailList + ", currentUrl=" + this.currentUrl + ", nextUrl=" + this.nextUrl + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirdropResultBean(Boolean bool, List list, String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2);
    }
}

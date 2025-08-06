package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropRuleBean {
    private final int awardRule;
    private final String content;

    /* renamed from: id  reason: collision with root package name */
    private final Integer f70220id;
    private final Integer prizeTime;

    public AirdropRuleBean() {
        this((Integer) null, (String) null, 0, (Integer) null, 15, (r) null);
    }

    public AirdropRuleBean(Integer num, String str, int i11, Integer num2) {
        this.f70220id = num;
        this.content = str;
        this.awardRule = i11;
        this.prizeTime = num2;
    }

    public static /* synthetic */ AirdropRuleBean copy$default(AirdropRuleBean airdropRuleBean, Integer num, String str, int i11, Integer num2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            num = airdropRuleBean.f70220id;
        }
        if ((i12 & 2) != 0) {
            str = airdropRuleBean.content;
        }
        if ((i12 & 4) != 0) {
            i11 = airdropRuleBean.awardRule;
        }
        if ((i12 & 8) != 0) {
            num2 = airdropRuleBean.prizeTime;
        }
        return airdropRuleBean.copy(num, str, i11, num2);
    }

    public final Integer component1() {
        return this.f70220id;
    }

    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.awardRule;
    }

    public final Integer component4() {
        return this.prizeTime;
    }

    public final AirdropRuleBean copy(Integer num, String str, int i11, Integer num2) {
        return new AirdropRuleBean(num, str, i11, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropRuleBean)) {
            return false;
        }
        AirdropRuleBean airdropRuleBean = (AirdropRuleBean) obj;
        return x.b(this.f70220id, airdropRuleBean.f70220id) && x.b(this.content, airdropRuleBean.content) && this.awardRule == airdropRuleBean.awardRule && x.b(this.prizeTime, airdropRuleBean.prizeTime);
    }

    public final int getAwardRule() {
        return this.awardRule;
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getId() {
        return this.f70220id;
    }

    public final Integer getPrizeTime() {
        return this.prizeTime;
    }

    public int hashCode() {
        Integer num = this.f70220id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.awardRule) * 31;
        Integer num2 = this.prizeTime;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "AirdropRuleBean(id=" + this.f70220id + ", content=" + this.content + ", awardRule=" + this.awardRule + ", prizeTime=" + this.prizeTime + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirdropRuleBean(Integer num, String str, int i11, Integer num2, int i12, r rVar) {
        this((i12 & 1) != 0 ? null : num, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? 1 : i11, (i12 & 8) != 0 ? null : num2);
    }
}

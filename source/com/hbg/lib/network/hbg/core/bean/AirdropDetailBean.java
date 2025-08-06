package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropDetailBean {
    private final Integer awarded;
    private final Long finishTime;
    private final Long firstTimeMillis;

    /* renamed from: id  reason: collision with root package name */
    private final Integer f70219id;
    private final AirdropMaterialBean material;
    private final AirdropRuleBean rule;
    private final Long startTime;

    public AirdropDetailBean() {
        this((Integer) null, (Integer) null, (Long) null, (Long) null, (Long) null, (AirdropRuleBean) null, (AirdropMaterialBean) null, 127, (r) null);
    }

    public AirdropDetailBean(Integer num, Integer num2, Long l11, Long l12, Long l13, AirdropRuleBean airdropRuleBean, AirdropMaterialBean airdropMaterialBean) {
        this.f70219id = num;
        this.awarded = num2;
        this.startTime = l11;
        this.finishTime = l12;
        this.firstTimeMillis = l13;
        this.rule = airdropRuleBean;
        this.material = airdropMaterialBean;
    }

    public static /* synthetic */ AirdropDetailBean copy$default(AirdropDetailBean airdropDetailBean, Integer num, Integer num2, Long l11, Long l12, Long l13, AirdropRuleBean airdropRuleBean, AirdropMaterialBean airdropMaterialBean, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = airdropDetailBean.f70219id;
        }
        if ((i11 & 2) != 0) {
            num2 = airdropDetailBean.awarded;
        }
        Integer num3 = num2;
        if ((i11 & 4) != 0) {
            l11 = airdropDetailBean.startTime;
        }
        Long l14 = l11;
        if ((i11 & 8) != 0) {
            l12 = airdropDetailBean.finishTime;
        }
        Long l15 = l12;
        if ((i11 & 16) != 0) {
            l13 = airdropDetailBean.firstTimeMillis;
        }
        Long l16 = l13;
        if ((i11 & 32) != 0) {
            airdropRuleBean = airdropDetailBean.rule;
        }
        AirdropRuleBean airdropRuleBean2 = airdropRuleBean;
        if ((i11 & 64) != 0) {
            airdropMaterialBean = airdropDetailBean.material;
        }
        return airdropDetailBean.copy(num, num3, l14, l15, l16, airdropRuleBean2, airdropMaterialBean);
    }

    public final Integer component1() {
        return this.f70219id;
    }

    public final Integer component2() {
        return this.awarded;
    }

    public final Long component3() {
        return this.startTime;
    }

    public final Long component4() {
        return this.finishTime;
    }

    public final Long component5() {
        return this.firstTimeMillis;
    }

    public final AirdropRuleBean component6() {
        return this.rule;
    }

    public final AirdropMaterialBean component7() {
        return this.material;
    }

    public final AirdropDetailBean copy(Integer num, Integer num2, Long l11, Long l12, Long l13, AirdropRuleBean airdropRuleBean, AirdropMaterialBean airdropMaterialBean) {
        return new AirdropDetailBean(num, num2, l11, l12, l13, airdropRuleBean, airdropMaterialBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropDetailBean)) {
            return false;
        }
        AirdropDetailBean airdropDetailBean = (AirdropDetailBean) obj;
        return x.b(this.f70219id, airdropDetailBean.f70219id) && x.b(this.awarded, airdropDetailBean.awarded) && x.b(this.startTime, airdropDetailBean.startTime) && x.b(this.finishTime, airdropDetailBean.finishTime) && x.b(this.firstTimeMillis, airdropDetailBean.firstTimeMillis) && x.b(this.rule, airdropDetailBean.rule) && x.b(this.material, airdropDetailBean.material);
    }

    public final Integer getAwarded() {
        return this.awarded;
    }

    public final Long getFinishTime() {
        return this.finishTime;
    }

    public final Long getFirstTimeMillis() {
        return this.firstTimeMillis;
    }

    public final Integer getId() {
        return this.f70219id;
    }

    public final AirdropMaterialBean getMaterial() {
        return this.material;
    }

    public final AirdropRuleBean getRule() {
        return this.rule;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        Integer num = this.f70219id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.awarded;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l11 = this.startTime;
        int hashCode3 = (hashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.finishTime;
        int hashCode4 = (hashCode3 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.firstTimeMillis;
        int hashCode5 = (hashCode4 + (l13 == null ? 0 : l13.hashCode())) * 31;
        AirdropRuleBean airdropRuleBean = this.rule;
        int hashCode6 = (hashCode5 + (airdropRuleBean == null ? 0 : airdropRuleBean.hashCode())) * 31;
        AirdropMaterialBean airdropMaterialBean = this.material;
        if (airdropMaterialBean != null) {
            i11 = airdropMaterialBean.hashCode();
        }
        return hashCode6 + i11;
    }

    public String toString() {
        return "AirdropDetailBean(id=" + this.f70219id + ", awarded=" + this.awarded + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", firstTimeMillis=" + this.firstTimeMillis + ", rule=" + this.rule + ", material=" + this.material + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AirdropDetailBean(java.lang.Integer r7, java.lang.Integer r8, java.lang.Long r9, java.lang.Long r10, java.lang.Long r11, com.hbg.lib.network.hbg.core.bean.AirdropRuleBean r12, com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r13, int r14, kotlin.jvm.internal.r r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.hbg.core.bean.AirdropDetailBean.<init>(java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.Long, java.lang.Long, com.hbg.lib.network.hbg.core.bean.AirdropRuleBean, com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean, int, kotlin.jvm.internal.r):void");
    }
}

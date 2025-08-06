package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropMaterialBean {
    private final String articleListImageUrl;
    private final Integer interactive;
    private final String openImageUrl;
    private final String openRedEnvelopeStyleImageUrl;
    private final String openSphericalStyleImageUrl;
    private final Integer openStyle;
    private final String shareImageUrl;
    private final String shareText;
    private final String shareUrl;
    private final String showImageUrl;
    private final String sideImageUrl;
    private final String subtitle;
    private final String title;

    public AirdropMaterialBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, 8191, (r) null);
    }

    public AirdropMaterialBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11) {
        this.showImageUrl = str;
        this.openImageUrl = str2;
        this.openSphericalStyleImageUrl = str3;
        this.openRedEnvelopeStyleImageUrl = str4;
        this.sideImageUrl = str5;
        this.articleListImageUrl = str6;
        this.title = str7;
        this.subtitle = str8;
        this.interactive = num;
        this.openStyle = num2;
        this.shareImageUrl = str9;
        this.shareUrl = str10;
        this.shareText = str11;
    }

    public static /* synthetic */ AirdropMaterialBean copy$default(AirdropMaterialBean airdropMaterialBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11, int i11, Object obj) {
        AirdropMaterialBean airdropMaterialBean2 = airdropMaterialBean;
        int i12 = i11;
        return airdropMaterialBean.copy((i12 & 1) != 0 ? airdropMaterialBean2.showImageUrl : str, (i12 & 2) != 0 ? airdropMaterialBean2.openImageUrl : str2, (i12 & 4) != 0 ? airdropMaterialBean2.openSphericalStyleImageUrl : str3, (i12 & 8) != 0 ? airdropMaterialBean2.openRedEnvelopeStyleImageUrl : str4, (i12 & 16) != 0 ? airdropMaterialBean2.sideImageUrl : str5, (i12 & 32) != 0 ? airdropMaterialBean2.articleListImageUrl : str6, (i12 & 64) != 0 ? airdropMaterialBean2.title : str7, (i12 & 128) != 0 ? airdropMaterialBean2.subtitle : str8, (i12 & 256) != 0 ? airdropMaterialBean2.interactive : num, (i12 & 512) != 0 ? airdropMaterialBean2.openStyle : num2, (i12 & 1024) != 0 ? airdropMaterialBean2.shareImageUrl : str9, (i12 & 2048) != 0 ? airdropMaterialBean2.shareUrl : str10, (i12 & 4096) != 0 ? airdropMaterialBean2.shareText : str11);
    }

    public final String component1() {
        return this.showImageUrl;
    }

    public final Integer component10() {
        return this.openStyle;
    }

    public final String component11() {
        return this.shareImageUrl;
    }

    public final String component12() {
        return this.shareUrl;
    }

    public final String component13() {
        return this.shareText;
    }

    public final String component2() {
        return this.openImageUrl;
    }

    public final String component3() {
        return this.openSphericalStyleImageUrl;
    }

    public final String component4() {
        return this.openRedEnvelopeStyleImageUrl;
    }

    public final String component5() {
        return this.sideImageUrl;
    }

    public final String component6() {
        return this.articleListImageUrl;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final Integer component9() {
        return this.interactive;
    }

    public final AirdropMaterialBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11) {
        return new AirdropMaterialBean(str, str2, str3, str4, str5, str6, str7, str8, num, num2, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropMaterialBean)) {
            return false;
        }
        AirdropMaterialBean airdropMaterialBean = (AirdropMaterialBean) obj;
        return x.b(this.showImageUrl, airdropMaterialBean.showImageUrl) && x.b(this.openImageUrl, airdropMaterialBean.openImageUrl) && x.b(this.openSphericalStyleImageUrl, airdropMaterialBean.openSphericalStyleImageUrl) && x.b(this.openRedEnvelopeStyleImageUrl, airdropMaterialBean.openRedEnvelopeStyleImageUrl) && x.b(this.sideImageUrl, airdropMaterialBean.sideImageUrl) && x.b(this.articleListImageUrl, airdropMaterialBean.articleListImageUrl) && x.b(this.title, airdropMaterialBean.title) && x.b(this.subtitle, airdropMaterialBean.subtitle) && x.b(this.interactive, airdropMaterialBean.interactive) && x.b(this.openStyle, airdropMaterialBean.openStyle) && x.b(this.shareImageUrl, airdropMaterialBean.shareImageUrl) && x.b(this.shareUrl, airdropMaterialBean.shareUrl) && x.b(this.shareText, airdropMaterialBean.shareText);
    }

    public final String getArticleListImageUrl() {
        return this.articleListImageUrl;
    }

    public final Integer getInteractive() {
        return this.interactive;
    }

    public final String getOpenImageUrl() {
        return this.openImageUrl;
    }

    public final String getOpenRedEnvelopeStyleImageUrl() {
        return this.openRedEnvelopeStyleImageUrl;
    }

    public final String getOpenSphericalStyleImageUrl() {
        return this.openSphericalStyleImageUrl;
    }

    public final Integer getOpenStyle() {
        return this.openStyle;
    }

    public final String getShareImageUrl() {
        return this.shareImageUrl;
    }

    public final String getShareText() {
        return this.shareText;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getShowImageUrl() {
        return this.showImageUrl;
    }

    public final String getSideImageUrl() {
        return this.sideImageUrl;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.showImageUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.openImageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.openSphericalStyleImageUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.openRedEnvelopeStyleImageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sideImageUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.articleListImageUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.title;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.subtitle;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.interactive;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.openStyle;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.shareImageUrl;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.shareUrl;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.shareText;
        if (str11 != null) {
            i11 = str11.hashCode();
        }
        return hashCode12 + i11;
    }

    public String toString() {
        return "AirdropMaterialBean(showImageUrl=" + this.showImageUrl + ", openImageUrl=" + this.openImageUrl + ", openSphericalStyleImageUrl=" + this.openSphericalStyleImageUrl + ", openRedEnvelopeStyleImageUrl=" + this.openRedEnvelopeStyleImageUrl + ", sideImageUrl=" + this.sideImageUrl + ", articleListImageUrl=" + this.articleListImageUrl + ", title=" + this.title + ", subtitle=" + this.subtitle + ", interactive=" + this.interactive + ", openStyle=" + this.openStyle + ", shareImageUrl=" + this.shareImageUrl + ", shareUrl=" + this.shareUrl + ", shareText=" + this.shareText + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AirdropMaterialBean(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.jvm.internal.r r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}

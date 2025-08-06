package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropDrawDetailBean {
    private final Integer awardId;
    private final String awardPictureUrl;
    private final String count;
    private final String desc;
    private final String properties;
    private final String title;
    private final Integer type;

    public AirdropDrawDetailBean() {
        this((Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (r) null);
    }

    public AirdropDrawDetailBean(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5) {
        this.awardId = num;
        this.type = num2;
        this.desc = str;
        this.count = str2;
        this.properties = str3;
        this.title = str4;
        this.awardPictureUrl = str5;
    }

    public static /* synthetic */ AirdropDrawDetailBean copy$default(AirdropDrawDetailBean airdropDrawDetailBean, Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = airdropDrawDetailBean.awardId;
        }
        if ((i11 & 2) != 0) {
            num2 = airdropDrawDetailBean.type;
        }
        Integer num3 = num2;
        if ((i11 & 4) != 0) {
            str = airdropDrawDetailBean.desc;
        }
        String str6 = str;
        if ((i11 & 8) != 0) {
            str2 = airdropDrawDetailBean.count;
        }
        String str7 = str2;
        if ((i11 & 16) != 0) {
            str3 = airdropDrawDetailBean.properties;
        }
        String str8 = str3;
        if ((i11 & 32) != 0) {
            str4 = airdropDrawDetailBean.title;
        }
        String str9 = str4;
        if ((i11 & 64) != 0) {
            str5 = airdropDrawDetailBean.awardPictureUrl;
        }
        return airdropDrawDetailBean.copy(num, num3, str6, str7, str8, str9, str5);
    }

    public final Integer component1() {
        return this.awardId;
    }

    public final Integer component2() {
        return this.type;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.count;
    }

    public final String component5() {
        return this.properties;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.awardPictureUrl;
    }

    public final AirdropDrawDetailBean copy(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5) {
        return new AirdropDrawDetailBean(num, num2, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropDrawDetailBean)) {
            return false;
        }
        AirdropDrawDetailBean airdropDrawDetailBean = (AirdropDrawDetailBean) obj;
        return x.b(this.awardId, airdropDrawDetailBean.awardId) && x.b(this.type, airdropDrawDetailBean.type) && x.b(this.desc, airdropDrawDetailBean.desc) && x.b(this.count, airdropDrawDetailBean.count) && x.b(this.properties, airdropDrawDetailBean.properties) && x.b(this.title, airdropDrawDetailBean.title) && x.b(this.awardPictureUrl, airdropDrawDetailBean.awardPictureUrl);
    }

    public final Integer getAwardId() {
        return this.awardId;
    }

    public final String getAwardPictureUrl() {
        return this.awardPictureUrl;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getProperties() {
        return this.properties;
    }

    public final String getProperty(String str) {
        Object obj;
        String obj2;
        String str2 = this.properties;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        try {
            JSONObject parseObject = JSON.parseObject(this.properties);
            if (!parseObject.containsKey(str) || (obj = parseObject.get(str)) == null || (obj2 = obj.toString()) == null) {
                return "";
            }
            return obj2;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.awardId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.type;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.desc;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.count;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.properties;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.awardPictureUrl;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode6 + i11;
    }

    public String toString() {
        return "AirdropDrawDetailBean(awardId=" + this.awardId + ", type=" + this.type + ", desc=" + this.desc + ", count=" + this.count + ", properties=" + this.properties + ", title=" + this.title + ", awardPictureUrl=" + this.awardPictureUrl + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AirdropDrawDetailBean(java.lang.Integer r7, java.lang.Integer r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.r r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.hbg.core.bean.AirdropDrawDetailBean.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}

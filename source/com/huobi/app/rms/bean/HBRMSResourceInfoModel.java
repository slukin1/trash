package com.huobi.app.rms.bean;

import com.huobi.app.rms.HBRMSManager;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class HBRMSResourceInfoModel implements Serializable {
    public static final a Companion = new a((r) null);
    private float beginDate;
    private String configId;
    private HBRMSResourceDownloadMode downloadOpp;
    private float endDate;
    private String extra;
    private boolean isResourceExist;
    private String maxVersion;
    private String md5;
    private String minVersion;
    private String name;
    private String packageId;
    private String packageName;
    private String packageUrl;
    private int platform;
    private String resourceName;
    private HBRMSResourceType resourceType;
    private String resourceTypeEnName;
    private boolean status;
    private boolean unzip;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final HBRMSResourceDownloadMode c(int i11) {
            HBRMSResourceDownloadMode hBRMSResourceDownloadMode;
            HBRMSResourceDownloadMode[] values = HBRMSResourceDownloadMode.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    hBRMSResourceDownloadMode = null;
                    break;
                }
                hBRMSResourceDownloadMode = values[i12];
                if (hBRMSResourceDownloadMode.getValue() == i11) {
                    break;
                }
                i12++;
            }
            return hBRMSResourceDownloadMode == null ? HBRMSResourceDownloadMode.Async : hBRMSResourceDownloadMode;
        }

        public final HBRMSResourceType d(int i11) {
            HBRMSResourceType hBRMSResourceType;
            HBRMSResourceType[] values = HBRMSResourceType.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    hBRMSResourceType = null;
                    break;
                }
                hBRMSResourceType = values[i12];
                if (hBRMSResourceType.getValue() == i11) {
                    break;
                }
                i12++;
            }
            return hBRMSResourceType == null ? HBRMSResourceType.Unknown : hBRMSResourceType;
        }
    }

    public HBRMSResourceInfoModel() {
        this((String) null, (String) null, (HBRMSResourceType) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0.0f, 0, false, (HBRMSResourceDownloadMode) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, 524287, (r) null);
    }

    public HBRMSResourceInfoModel(String str, String str2, HBRMSResourceType hBRMSResourceType, String str3, String str4, String str5, String str6, float f11, float f12, int i11, boolean z11, HBRMSResourceDownloadMode hBRMSResourceDownloadMode, String str7, String str8, String str9, String str10, String str11, boolean z12, boolean z13) {
        this.configId = str;
        this.name = str2;
        this.resourceType = hBRMSResourceType;
        this.packageUrl = str3;
        this.packageName = str4;
        this.packageId = str5;
        this.md5 = str6;
        this.beginDate = f11;
        this.endDate = f12;
        this.platform = i11;
        this.status = z11;
        this.downloadOpp = hBRMSResourceDownloadMode;
        this.minVersion = str7;
        this.maxVersion = str8;
        this.extra = str9;
        this.resourceTypeEnName = str10;
        this.resourceName = str11;
        this.unzip = z12;
        this.isResourceExist = z13;
    }

    public static /* synthetic */ HBRMSResourceInfoModel copy$default(HBRMSResourceInfoModel hBRMSResourceInfoModel, String str, String str2, HBRMSResourceType hBRMSResourceType, String str3, String str4, String str5, String str6, float f11, float f12, int i11, boolean z11, HBRMSResourceDownloadMode hBRMSResourceDownloadMode, String str7, String str8, String str9, String str10, String str11, boolean z12, boolean z13, int i12, Object obj) {
        HBRMSResourceInfoModel hBRMSResourceInfoModel2 = hBRMSResourceInfoModel;
        int i13 = i12;
        return hBRMSResourceInfoModel.copy((i13 & 1) != 0 ? hBRMSResourceInfoModel2.configId : str, (i13 & 2) != 0 ? hBRMSResourceInfoModel2.name : str2, (i13 & 4) != 0 ? hBRMSResourceInfoModel2.resourceType : hBRMSResourceType, (i13 & 8) != 0 ? hBRMSResourceInfoModel2.packageUrl : str3, (i13 & 16) != 0 ? hBRMSResourceInfoModel2.packageName : str4, (i13 & 32) != 0 ? hBRMSResourceInfoModel2.packageId : str5, (i13 & 64) != 0 ? hBRMSResourceInfoModel2.md5 : str6, (i13 & 128) != 0 ? hBRMSResourceInfoModel2.beginDate : f11, (i13 & 256) != 0 ? hBRMSResourceInfoModel2.endDate : f12, (i13 & 512) != 0 ? hBRMSResourceInfoModel2.platform : i11, (i13 & 1024) != 0 ? hBRMSResourceInfoModel2.status : z11, (i13 & 2048) != 0 ? hBRMSResourceInfoModel2.downloadOpp : hBRMSResourceDownloadMode, (i13 & 4096) != 0 ? hBRMSResourceInfoModel2.minVersion : str7, (i13 & 8192) != 0 ? hBRMSResourceInfoModel2.maxVersion : str8, (i13 & 16384) != 0 ? hBRMSResourceInfoModel2.extra : str9, (i13 & 32768) != 0 ? hBRMSResourceInfoModel2.resourceTypeEnName : str10, (i13 & 65536) != 0 ? hBRMSResourceInfoModel2.resourceName : str11, (i13 & 131072) != 0 ? hBRMSResourceInfoModel2.unzip : z12, (i13 & 262144) != 0 ? hBRMSResourceInfoModel2.isResourceExist : z13);
    }

    public final String component1() {
        return this.configId;
    }

    public final int component10() {
        return this.platform;
    }

    public final boolean component11() {
        return this.status;
    }

    public final HBRMSResourceDownloadMode component12() {
        return this.downloadOpp;
    }

    public final String component13() {
        return this.minVersion;
    }

    public final String component14() {
        return this.maxVersion;
    }

    public final String component15() {
        return this.extra;
    }

    public final String component16() {
        return this.resourceTypeEnName;
    }

    public final String component17() {
        return this.resourceName;
    }

    public final boolean component18() {
        return this.unzip;
    }

    public final boolean component19() {
        return this.isResourceExist;
    }

    public final String component2() {
        return this.name;
    }

    public final HBRMSResourceType component3() {
        return this.resourceType;
    }

    public final String component4() {
        return this.packageUrl;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.packageId;
    }

    public final String component7() {
        return this.md5;
    }

    public final float component8() {
        return this.beginDate;
    }

    public final float component9() {
        return this.endDate;
    }

    public final HBRMSResourceInfoModel copy(String str, String str2, HBRMSResourceType hBRMSResourceType, String str3, String str4, String str5, String str6, float f11, float f12, int i11, boolean z11, HBRMSResourceDownloadMode hBRMSResourceDownloadMode, String str7, String str8, String str9, String str10, String str11, boolean z12, boolean z13) {
        return new HBRMSResourceInfoModel(str, str2, hBRMSResourceType, str3, str4, str5, str6, f11, f12, i11, z11, hBRMSResourceDownloadMode, str7, str8, str9, str10, str11, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HBRMSResourceInfoModel)) {
            return false;
        }
        HBRMSResourceInfoModel hBRMSResourceInfoModel = (HBRMSResourceInfoModel) obj;
        return x.b(this.configId, hBRMSResourceInfoModel.configId) && x.b(this.name, hBRMSResourceInfoModel.name) && this.resourceType == hBRMSResourceInfoModel.resourceType && x.b(this.packageUrl, hBRMSResourceInfoModel.packageUrl) && x.b(this.packageName, hBRMSResourceInfoModel.packageName) && x.b(this.packageId, hBRMSResourceInfoModel.packageId) && x.b(this.md5, hBRMSResourceInfoModel.md5) && Float.compare(this.beginDate, hBRMSResourceInfoModel.beginDate) == 0 && Float.compare(this.endDate, hBRMSResourceInfoModel.endDate) == 0 && this.platform == hBRMSResourceInfoModel.platform && this.status == hBRMSResourceInfoModel.status && this.downloadOpp == hBRMSResourceInfoModel.downloadOpp && x.b(this.minVersion, hBRMSResourceInfoModel.minVersion) && x.b(this.maxVersion, hBRMSResourceInfoModel.maxVersion) && x.b(this.extra, hBRMSResourceInfoModel.extra) && x.b(this.resourceTypeEnName, hBRMSResourceInfoModel.resourceTypeEnName) && x.b(this.resourceName, hBRMSResourceInfoModel.resourceName) && this.unzip == hBRMSResourceInfoModel.unzip && this.isResourceExist == hBRMSResourceInfoModel.isResourceExist;
    }

    public final float getBeginDate() {
        return this.beginDate;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final HBRMSResourceDownloadMode getDownloadOpp() {
        return this.downloadOpp;
    }

    public final float getEndDate() {
        return this.endDate;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMaxVersion() {
        return this.maxVersion;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getMinVersion() {
        return this.minVersion;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPackageUrl() {
        return this.packageUrl;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final String getResourceDownloadFilePath() {
        return getZipLocalDirPath() + '/' + this.md5 + ".zip";
    }

    public final String getResourceName() {
        return this.resourceName;
    }

    public final String getResourcePath() {
        return HBRMSManager.f42145q.a().J(this);
    }

    public final HBRMSResourceType getResourceType() {
        return this.resourceType;
    }

    public final String getResourceTypeEnName() {
        return this.resourceTypeEnName;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final boolean getUnzip() {
        return this.unzip;
    }

    public final String getZipLocalDirPath() {
        return HBRMSManager.f42145q.a().L(this.resourceType);
    }

    public int hashCode() {
        String str = this.configId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        HBRMSResourceType hBRMSResourceType = this.resourceType;
        int hashCode3 = (hashCode2 + (hBRMSResourceType == null ? 0 : hBRMSResourceType.hashCode())) * 31;
        String str3 = this.packageUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.packageName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.packageId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.md5;
        int hashCode7 = (((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Float.floatToIntBits(this.beginDate)) * 31) + Float.floatToIntBits(this.endDate)) * 31) + this.platform) * 31;
        boolean z11 = this.status;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode8 = (((hashCode7 + (z11 ? 1 : 0)) * 31) + this.downloadOpp.hashCode()) * 31;
        String str7 = this.minVersion;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.maxVersion;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.extra;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.resourceTypeEnName;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.resourceName;
        if (str11 != null) {
            i11 = str11.hashCode();
        }
        int i12 = (hashCode12 + i11) * 31;
        boolean z13 = this.unzip;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isResourceExist;
        if (!z14) {
            z12 = z14;
        }
        return i13 + (z12 ? 1 : 0);
    }

    public final boolean isDownloadSuccess() {
        return HBRMSManager.f42145q.a().D(this);
    }

    public final boolean isResourceExist() {
        return this.isResourceExist;
    }

    public final void setBeginDate(float f11) {
        this.beginDate = f11;
    }

    public final void setConfigId(String str) {
        this.configId = str;
    }

    public final void setDownloadOpp(HBRMSResourceDownloadMode hBRMSResourceDownloadMode) {
        this.downloadOpp = hBRMSResourceDownloadMode;
    }

    public final void setEndDate(float f11) {
        this.endDate = f11;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final void setMaxVersion(String str) {
        this.maxVersion = str;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setMinVersion(String str) {
        this.minVersion = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPackageId(String str) {
        this.packageId = str;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public final void setPlatform(int i11) {
        this.platform = i11;
    }

    public final void setResourceExist(boolean z11) {
        this.isResourceExist = z11;
    }

    public final void setResourceName(String str) {
        this.resourceName = str;
    }

    public final void setResourceType(HBRMSResourceType hBRMSResourceType) {
        this.resourceType = hBRMSResourceType;
    }

    public final void setResourceTypeEnName(String str) {
        this.resourceTypeEnName = str;
    }

    public final void setStatus(boolean z11) {
        this.status = z11;
    }

    public final void setUnzip(boolean z11) {
        this.unzip = z11;
    }

    public String toString() {
        return "HBRMSResourceInfoModel(configId=" + this.configId + ", name=" + this.name + ", resourceType=" + this.resourceType + ", packageUrl=" + this.packageUrl + ", packageName=" + this.packageName + ", packageId=" + this.packageId + ", md5=" + this.md5 + ", beginDate=" + this.beginDate + ", endDate=" + this.endDate + ", platform=" + this.platform + ", status=" + this.status + ", downloadOpp=" + this.downloadOpp + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + ", extra=" + this.extra + ", resourceTypeEnName=" + this.resourceTypeEnName + ", resourceName=" + this.resourceName + ", unzip=" + this.unzip + ", isResourceExist=" + this.isResourceExist + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HBRMSResourceInfoModel(java.lang.String r21, java.lang.String r22, com.huobi.app.rms.bean.HBRMSResourceType r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, float r28, float r29, int r30, boolean r31, com.huobi.app.rms.bean.HBRMSResourceDownloadMode r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, boolean r38, boolean r39, int r40, kotlin.jvm.internal.r r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r22
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r23
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r24
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r25
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r26
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            r10 = 0
            if (r9 == 0) goto L_0x0041
            r9 = r10
            goto L_0x0043
        L_0x0041:
            r9 = r28
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r10 = r29
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r30
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r31
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r14 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.UnNeedLoad
            goto L_0x0063
        L_0x0061:
            r14 = r32
        L_0x0063:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            r15 = 0
            goto L_0x006b
        L_0x0069:
            r15 = r33
        L_0x006b:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0071
            r2 = 0
            goto L_0x0073
        L_0x0071:
            r2 = r34
        L_0x0073:
            r12 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x0079
            r12 = 0
            goto L_0x007b
        L_0x0079:
            r12 = r35
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0085
            r16 = 0
            goto L_0x0087
        L_0x0085:
            r16 = r36
        L_0x0087:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            goto L_0x0092
        L_0x0090:
            r17 = r37
        L_0x0092:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009b
            r18 = 1
            goto L_0x009d
        L_0x009b:
            r18 = r38
        L_0x009d:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00a5
            r0 = 0
            goto L_0x00a7
        L_0x00a5:
            r0 = r39
        L_0x00a7:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r12
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.bean.HBRMSResourceInfoModel.<init>(java.lang.String, java.lang.String, com.huobi.app.rms.bean.HBRMSResourceType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, float, int, boolean, com.huobi.app.rms.bean.HBRMSResourceDownloadMode, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.r):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HBRMSResourceInfoModel(com.hbg.lib.network.hbg.core.bean.AppResConfigBean r26) {
        /*
            r25 = this;
            r0 = r26
            long r1 = r0.f70221id
            java.lang.String r4 = java.lang.String.valueOf(r1)
            java.lang.String r5 = r0.md5
            com.huobi.app.rms.bean.HBRMSResourceInfoModel$a r1 = Companion
            int r2 = r0.resourceType
            com.huobi.app.rms.bean.HBRMSResourceType r6 = r1.d(r2)
            java.lang.String r7 = r0.packageUrl
            java.lang.String r8 = r0.packageName
            java.lang.String r9 = r0.packageId
            java.lang.String r10 = r0.md5
            long r2 = r0.beginDate
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r11 = r2 * r3
            long r12 = r0.endDate
            float r2 = (float) r12
            float r12 = r2 * r3
            int r13 = r0.platform
            int r2 = r0.status
            if (r2 == 0) goto L_0x002e
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r14 = r2
            int r2 = r0.downloadOpp
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r15 = r1.c(r2)
            java.lang.String r2 = r0.minVersion
            r16 = r2
            java.lang.String r2 = r0.maxVersion
            r17 = r2
            java.lang.String r2 = r0.extra
            r18 = r2
            int r2 = r0.resourceType
            com.huobi.app.rms.bean.HBRMSResourceType r2 = r1.d(r2)
            java.lang.String r19 = r2.name()
            int r0 = r0.resourceType
            com.huobi.app.rms.bean.HBRMSResourceType r0 = r1.d(r0)
            java.lang.String r20 = r0.name()
            r21 = 0
            r22 = 0
            r23 = 393216(0x60000, float:5.51013E-40)
            r24 = 0
            r3 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.bean.HBRMSResourceInfoModel.<init>(com.hbg.lib.network.hbg.core.bean.AppResConfigBean):void");
    }
}

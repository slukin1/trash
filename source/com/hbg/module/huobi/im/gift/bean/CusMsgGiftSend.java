package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fluttercandies.photo_manager.core.entity.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;

public final class CusMsgGiftSend implements Parcelable {
    public static final Parcelable.Creator<CusMsgGiftSend> CREATOR = new Creator();
    private Integer activeJackpot;
    private String activeRule;
    private Long currentTime;
    private Long finishTime;
    private String groupId;

    /* renamed from: id  reason: collision with root package name */
    private Integer f19720id;
    private int joinActivity;
    private Long liveWatchTaskTotalTime;
    private long liveWatchTime;
    private long liveWatchTimeRemain;
    private int minUpdateSecond;
    private List<Prize> prizeList;
    private Integer prizeTime;
    private int redPotId;
    private Integer rule;
    private Long startTime;
    private String subtitle;
    private Integer taskTime;
    private String title;

    public static final class Creator implements Parcelable.Creator<CusMsgGiftSend> {
        /* renamed from: a */
        public final CusMsgGiftSend createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Long l11 = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int readInt = parcel.readInt();
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            long readLong = parcel.readLong();
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                Parcel parcel2 = parcel;
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(Prize.CREATOR.createFromParcel(parcel));
                }
                Parcel parcel3 = parcel;
                arrayList = arrayList2;
            }
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            Long valueOf8 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt3 = parcel.readInt();
            long readLong2 = parcel.readLong();
            if (parcel.readInt() != 0) {
                l11 = Long.valueOf(parcel.readLong());
            }
            return new CusMsgGiftSend(valueOf, readInt, valueOf2, valueOf3, readLong, valueOf4, arrayList, valueOf5, valueOf6, valueOf7, readString, valueOf8, readString2, readString3, readString4, readInt3, readLong2, l11, parcel.readInt());
        }

        /* renamed from: b */
        public final CusMsgGiftSend[] newArray(int i11) {
            return new CusMsgGiftSend[i11];
        }
    }

    public CusMsgGiftSend(Integer num, int i11, Long l11, Long l12, long j11, Integer num2, List<Prize> list, Integer num3, Integer num4, Integer num5, String str, Long l13, String str2, String str3, String str4, int i12, long j12, Long l14, int i13) {
        this.activeJackpot = num;
        this.redPotId = i11;
        this.currentTime = l11;
        this.finishTime = l12;
        this.liveWatchTime = j11;
        this.f19720id = num2;
        this.prizeList = list;
        this.prizeTime = num3;
        this.taskTime = num4;
        this.rule = num5;
        this.activeRule = str;
        this.startTime = l13;
        this.subtitle = str2;
        this.title = str3;
        this.groupId = str4;
        this.joinActivity = i12;
        this.liveWatchTimeRemain = j12;
        this.liveWatchTaskTotalTime = l14;
        this.minUpdateSecond = i13;
    }

    public static /* synthetic */ CusMsgGiftSend copy$default(CusMsgGiftSend cusMsgGiftSend, Integer num, int i11, Long l11, Long l12, long j11, Integer num2, List list, Integer num3, Integer num4, Integer num5, String str, Long l13, String str2, String str3, String str4, int i12, long j12, Long l14, int i13, int i14, Object obj) {
        CusMsgGiftSend cusMsgGiftSend2 = cusMsgGiftSend;
        int i15 = i14;
        return cusMsgGiftSend.copy((i15 & 1) != 0 ? cusMsgGiftSend2.activeJackpot : num, (i15 & 2) != 0 ? cusMsgGiftSend2.redPotId : i11, (i15 & 4) != 0 ? cusMsgGiftSend2.currentTime : l11, (i15 & 8) != 0 ? cusMsgGiftSend2.finishTime : l12, (i15 & 16) != 0 ? cusMsgGiftSend2.liveWatchTime : j11, (i15 & 32) != 0 ? cusMsgGiftSend2.f19720id : num2, (i15 & 64) != 0 ? cusMsgGiftSend2.prizeList : list, (i15 & 128) != 0 ? cusMsgGiftSend2.prizeTime : num3, (i15 & 256) != 0 ? cusMsgGiftSend2.taskTime : num4, (i15 & 512) != 0 ? cusMsgGiftSend2.rule : num5, (i15 & 1024) != 0 ? cusMsgGiftSend2.activeRule : str, (i15 & 2048) != 0 ? cusMsgGiftSend2.startTime : l13, (i15 & 4096) != 0 ? cusMsgGiftSend2.subtitle : str2, (i15 & 8192) != 0 ? cusMsgGiftSend2.title : str3, (i15 & 16384) != 0 ? cusMsgGiftSend2.groupId : str4, (i15 & 32768) != 0 ? cusMsgGiftSend2.joinActivity : i12, (i15 & 65536) != 0 ? cusMsgGiftSend2.liveWatchTimeRemain : j12, (i15 & 131072) != 0 ? cusMsgGiftSend2.liveWatchTaskTotalTime : l14, (i15 & 262144) != 0 ? cusMsgGiftSend2.minUpdateSecond : i13);
    }

    public final Integer component1() {
        return this.activeJackpot;
    }

    public final Integer component10() {
        return this.rule;
    }

    public final String component11() {
        return this.activeRule;
    }

    public final Long component12() {
        return this.startTime;
    }

    public final String component13() {
        return this.subtitle;
    }

    public final String component14() {
        return this.title;
    }

    public final String component15() {
        return this.groupId;
    }

    public final int component16() {
        return this.joinActivity;
    }

    public final long component17() {
        return this.liveWatchTimeRemain;
    }

    public final Long component18() {
        return this.liveWatchTaskTotalTime;
    }

    public final int component19() {
        return this.minUpdateSecond;
    }

    public final int component2() {
        return this.redPotId;
    }

    public final Long component3() {
        return this.currentTime;
    }

    public final Long component4() {
        return this.finishTime;
    }

    public final long component5() {
        return this.liveWatchTime;
    }

    public final Integer component6() {
        return this.f19720id;
    }

    public final List<Prize> component7() {
        return this.prizeList;
    }

    public final Integer component8() {
        return this.prizeTime;
    }

    public final Integer component9() {
        return this.taskTime;
    }

    public final CusMsgGiftSend copy(Integer num, int i11, Long l11, Long l12, long j11, Integer num2, List<Prize> list, Integer num3, Integer num4, Integer num5, String str, Long l13, String str2, String str3, String str4, int i12, long j12, Long l14, int i13) {
        return new CusMsgGiftSend(num, i11, l11, l12, j11, num2, list, num3, num4, num5, str, l13, str2, str3, str4, i12, j12, l14, i13);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgGiftSend)) {
            return false;
        }
        CusMsgGiftSend cusMsgGiftSend = (CusMsgGiftSend) obj;
        return x.b(this.activeJackpot, cusMsgGiftSend.activeJackpot) && this.redPotId == cusMsgGiftSend.redPotId && x.b(this.currentTime, cusMsgGiftSend.currentTime) && x.b(this.finishTime, cusMsgGiftSend.finishTime) && this.liveWatchTime == cusMsgGiftSend.liveWatchTime && x.b(this.f19720id, cusMsgGiftSend.f19720id) && x.b(this.prizeList, cusMsgGiftSend.prizeList) && x.b(this.prizeTime, cusMsgGiftSend.prizeTime) && x.b(this.taskTime, cusMsgGiftSend.taskTime) && x.b(this.rule, cusMsgGiftSend.rule) && x.b(this.activeRule, cusMsgGiftSend.activeRule) && x.b(this.startTime, cusMsgGiftSend.startTime) && x.b(this.subtitle, cusMsgGiftSend.subtitle) && x.b(this.title, cusMsgGiftSend.title) && x.b(this.groupId, cusMsgGiftSend.groupId) && this.joinActivity == cusMsgGiftSend.joinActivity && this.liveWatchTimeRemain == cusMsgGiftSend.liveWatchTimeRemain && x.b(this.liveWatchTaskTotalTime, cusMsgGiftSend.liveWatchTaskTotalTime) && this.minUpdateSecond == cusMsgGiftSend.minUpdateSecond;
    }

    public final Integer getActiveJackpot() {
        return this.activeJackpot;
    }

    public final String getActiveRule() {
        return this.activeRule;
    }

    public final Long getCurrentTime() {
        return this.currentTime;
    }

    public final Long getFinishTime() {
        return this.finishTime;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Integer getId() {
        return this.f19720id;
    }

    public final int getJoinActivity() {
        return this.joinActivity;
    }

    public final Long getLiveWatchTaskTotalTime() {
        return this.liveWatchTaskTotalTime;
    }

    public final long getLiveWatchTime() {
        return this.liveWatchTime;
    }

    public final long getLiveWatchTimeRemain() {
        return this.liveWatchTimeRemain;
    }

    public final int getMinUpdateSecond() {
        return this.minUpdateSecond;
    }

    public final List<Prize> getPrizeList() {
        return this.prizeList;
    }

    public final Integer getPrizeTime() {
        return this.prizeTime;
    }

    public final int getRedPotId() {
        return this.redPotId;
    }

    public final Integer getRule() {
        return this.rule;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Integer getTaskTime() {
        return this.taskTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.activeJackpot;
        int i11 = 0;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.redPotId) * 31;
        Long l11 = this.currentTime;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.finishTime;
        int hashCode3 = (((hashCode2 + (l12 == null ? 0 : l12.hashCode())) * 31) + a.a(this.liveWatchTime)) * 31;
        Integer num2 = this.f19720id;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<Prize> list = this.prizeList;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.prizeTime;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.taskTime;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.rule;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str = this.activeRule;
        int hashCode9 = (hashCode8 + (str == null ? 0 : str.hashCode())) * 31;
        Long l13 = this.startTime;
        int hashCode10 = (hashCode9 + (l13 == null ? 0 : l13.hashCode())) * 31;
        String str2 = this.subtitle;
        int hashCode11 = (hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode12 = (hashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.groupId;
        int hashCode13 = (((((hashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.joinActivity) * 31) + a.a(this.liveWatchTimeRemain)) * 31;
        Long l14 = this.liveWatchTaskTotalTime;
        if (l14 != null) {
            i11 = l14.hashCode();
        }
        return ((hashCode13 + i11) * 31) + this.minUpdateSecond;
    }

    public final void setActiveJackpot(Integer num) {
        this.activeJackpot = num;
    }

    public final void setActiveRule(String str) {
        this.activeRule = str;
    }

    public final void setCurrentTime(Long l11) {
        this.currentTime = l11;
    }

    public final void setFinishTime(Long l11) {
        this.finishTime = l11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setId(Integer num) {
        this.f19720id = num;
    }

    public final void setJoinActivity(int i11) {
        this.joinActivity = i11;
    }

    public final void setLiveWatchTaskTotalTime(Long l11) {
        this.liveWatchTaskTotalTime = l11;
    }

    public final void setLiveWatchTime(long j11) {
        this.liveWatchTime = j11;
    }

    public final void setLiveWatchTimeRemain(long j11) {
        this.liveWatchTimeRemain = j11;
    }

    public final void setMinUpdateSecond(int i11) {
        this.minUpdateSecond = i11;
    }

    public final void setPrizeList(List<Prize> list) {
        this.prizeList = list;
    }

    public final void setPrizeTime(Integer num) {
        this.prizeTime = num;
    }

    public final void setRedPotId(int i11) {
        this.redPotId = i11;
    }

    public final void setRule(Integer num) {
        this.rule = num;
    }

    public final void setStartTime(Long l11) {
        this.startTime = l11;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final void setTaskTime(Integer num) {
        this.taskTime = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "CusMsgGiftSend(activeJackpot=" + this.activeJackpot + ", redPotId=" + this.redPotId + ", currentTime=" + this.currentTime + ", finishTime=" + this.finishTime + ", liveWatchTime=" + this.liveWatchTime + ", id=" + this.f19720id + ", prizeList=" + this.prizeList + ", prizeTime=" + this.prizeTime + ", taskTime=" + this.taskTime + ", rule=" + this.rule + ", activeRule=" + this.activeRule + ", startTime=" + this.startTime + ", subtitle=" + this.subtitle + ", title=" + this.title + ", groupId=" + this.groupId + ", joinActivity=" + this.joinActivity + ", liveWatchTimeRemain=" + this.liveWatchTimeRemain + ", liveWatchTaskTotalTime=" + this.liveWatchTaskTotalTime + ", minUpdateSecond=" + this.minUpdateSecond + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Integer num = this.activeJackpot;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.redPotId);
        Long l11 = this.currentTime;
        if (l11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l11.longValue());
        }
        Long l12 = this.finishTime;
        if (l12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l12.longValue());
        }
        parcel.writeLong(this.liveWatchTime);
        Integer num2 = this.f19720id;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        List<Prize> list = this.prizeList;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Prize writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i11);
            }
        }
        Integer num3 = this.prizeTime;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.taskTime;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        Integer num5 = this.rule;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        parcel.writeString(this.activeRule);
        Long l13 = this.startTime;
        if (l13 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l13.longValue());
        }
        parcel.writeString(this.subtitle);
        parcel.writeString(this.title);
        parcel.writeString(this.groupId);
        parcel.writeInt(this.joinActivity);
        parcel.writeLong(this.liveWatchTimeRemain);
        Long l14 = this.liveWatchTaskTotalTime;
        if (l14 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l14.longValue());
        }
        parcel.writeInt(this.minUpdateSecond);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CusMsgGiftSend(java.lang.Integer r26, int r27, java.lang.Long r28, java.lang.Long r29, long r30, java.lang.Integer r32, java.util.List r33, java.lang.Integer r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.String r37, java.lang.Long r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, int r42, long r43, java.lang.Long r45, int r46, int r47, kotlin.jvm.internal.r r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r4 = 0
            goto L_0x000a
        L_0x0008:
            r4 = r26
        L_0x000a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0010
            r5 = 0
            goto L_0x0012
        L_0x0010:
            r5 = r27
        L_0x0012:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            r6 = 0
            goto L_0x001a
        L_0x0018:
            r6 = r28
        L_0x001a:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0020
            r7 = 0
            goto L_0x0022
        L_0x0020:
            r7 = r29
        L_0x0022:
            r1 = r0 & 16
            r8 = 0
            if (r1 == 0) goto L_0x002a
            r10 = r8
            goto L_0x002c
        L_0x002a:
            r10 = r30
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            r1 = 0
            goto L_0x0034
        L_0x0032:
            r1 = r32
        L_0x0034:
            r12 = r0 & 64
            if (r12 == 0) goto L_0x003a
            r12 = 0
            goto L_0x003c
        L_0x003a:
            r12 = r33
        L_0x003c:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0042
            r13 = 0
            goto L_0x0044
        L_0x0042:
            r13 = r34
        L_0x0044:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x004a
            r14 = 0
            goto L_0x004c
        L_0x004a:
            r14 = r35
        L_0x004c:
            r15 = r0 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x0052
            r15 = 0
            goto L_0x0054
        L_0x0052:
            r15 = r36
        L_0x0054:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x005a
            r2 = 0
            goto L_0x005c
        L_0x005a:
            r2 = r37
        L_0x005c:
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0063
            r16 = 0
            goto L_0x0065
        L_0x0063:
            r16 = r38
        L_0x0065:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x006c
            r17 = 0
            goto L_0x006e
        L_0x006c:
            r17 = r39
        L_0x006e:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0075
            r18 = 0
            goto L_0x0077
        L_0x0075:
            r18 = r40
        L_0x0077:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007e
            r19 = 0
            goto L_0x0080
        L_0x007e:
            r19 = r41
        L_0x0080:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0089
            r20 = 0
            goto L_0x008b
        L_0x0089:
            r20 = r42
        L_0x008b:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0093
            r21 = r8
            goto L_0x0095
        L_0x0093:
            r21 = r43
        L_0x0095:
            r3 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x009d
            r23 = 0
            goto L_0x009f
        L_0x009d:
            r23 = r45
        L_0x009f:
            r3 = r25
            r8 = r10
            r10 = r1
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r2
            r24 = r46
            r3.<init>(r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend.<init>(java.lang.Integer, int, java.lang.Long, java.lang.Long, long, java.lang.Integer, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, int, long, java.lang.Long, int, int, kotlin.jvm.internal.r):void");
    }
}

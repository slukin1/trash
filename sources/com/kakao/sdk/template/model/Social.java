package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006$"}, d2 = {"Lcom/kakao/sdk/template/model/Social;", "Landroid/os/Parcelable;", "likeCount", "", "commentCount", "sharedCount", "viewCount", "subscriberCount", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCommentCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLikeCount", "getSharedCount", "getSubscriberCount", "getViewCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Social;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Social implements Parcelable {
    public static final Parcelable.Creator<Social> CREATOR = new Creator();
    private final Integer commentCount;
    private final Integer likeCount;
    private final Integer sharedCount;
    private final Integer subscriberCount;
    private final Integer viewCount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Social> {
        /* renamed from: a */
        public final Social createFromParcel(Parcel parcel) {
            return new Social(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final Social[] newArray(int i11) {
            return new Social[i11];
        }
    }

    public Social() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 31, (r) null);
    }

    public Social(Integer num) {
        this(num, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 30, (r) null);
    }

    public Social(Integer num, Integer num2) {
        this(num, num2, (Integer) null, (Integer) null, (Integer) null, 28, (r) null);
    }

    public Social(Integer num, Integer num2, Integer num3) {
        this(num, num2, num3, (Integer) null, (Integer) null, 24, (r) null);
    }

    public Social(Integer num, Integer num2, Integer num3, Integer num4) {
        this(num, num2, num3, num4, (Integer) null, 16, (r) null);
    }

    public Social(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.likeCount = num;
        this.commentCount = num2;
        this.sharedCount = num3;
        this.viewCount = num4;
        this.subscriberCount = num5;
    }

    public static /* synthetic */ Social copy$default(Social social, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = social.likeCount;
        }
        if ((i11 & 2) != 0) {
            num2 = social.commentCount;
        }
        Integer num6 = num2;
        if ((i11 & 4) != 0) {
            num3 = social.sharedCount;
        }
        Integer num7 = num3;
        if ((i11 & 8) != 0) {
            num4 = social.viewCount;
        }
        Integer num8 = num4;
        if ((i11 & 16) != 0) {
            num5 = social.subscriberCount;
        }
        return social.copy(num, num6, num7, num8, num5);
    }

    public final Integer component1() {
        return this.likeCount;
    }

    public final Integer component2() {
        return this.commentCount;
    }

    public final Integer component3() {
        return this.sharedCount;
    }

    public final Integer component4() {
        return this.viewCount;
    }

    public final Integer component5() {
        return this.subscriberCount;
    }

    public final Social copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        return new Social(num, num2, num3, num4, num5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Social)) {
            return false;
        }
        Social social = (Social) obj;
        return x.b(this.likeCount, social.likeCount) && x.b(this.commentCount, social.commentCount) && x.b(this.sharedCount, social.sharedCount) && x.b(this.viewCount, social.viewCount) && x.b(this.subscriberCount, social.subscriberCount);
    }

    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final Integer getLikeCount() {
        return this.likeCount;
    }

    public final Integer getSharedCount() {
        return this.sharedCount;
    }

    public final Integer getSubscriberCount() {
        return this.subscriberCount;
    }

    public final Integer getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        Integer num = this.likeCount;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.commentCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.sharedCount;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.viewCount;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.subscriberCount;
        if (num5 != null) {
            i11 = num5.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "Social(likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", sharedCount=" + this.sharedCount + ", viewCount=" + this.viewCount + ", subscriberCount=" + this.subscriberCount + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Integer num = this.likeCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.commentCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.sharedCount;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.viewCount;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        Integer num5 = this.subscriberCount;
        if (num5 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num5.intValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Social(java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, int r10, kotlin.jvm.internal.r r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.template.model.Social.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.r):void");
    }
}

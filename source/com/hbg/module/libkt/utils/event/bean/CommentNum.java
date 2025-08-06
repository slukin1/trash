package com.hbg.module.libkt.utils.event.bean;

import com.fluttercandies.photo_manager.core.entity.a;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CommentNum {

    /* renamed from: a  reason: collision with root package name */
    public int f24874a;

    /* renamed from: b  reason: collision with root package name */
    public long f24875b;

    /* renamed from: c  reason: collision with root package name */
    public String f24876c;

    /* renamed from: d  reason: collision with root package name */
    public int f24877d;

    /* renamed from: e  reason: collision with root package name */
    public int f24878e;

    /* renamed from: f  reason: collision with root package name */
    public CommentInfo f24879f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24880g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24881h;

    /* renamed from: i  reason: collision with root package name */
    public String f24882i;

    public CommentNum() {
        this(0, 0, (String) null, 0, 0, (CommentInfo) null, false, false, (String) null, 511, (r) null);
    }

    public CommentNum(int i11, long j11, String str, int i12, int i13, CommentInfo commentInfo, boolean z11, boolean z12, String str2) {
        this.f24874a = i11;
        this.f24875b = j11;
        this.f24876c = str;
        this.f24877d = i12;
        this.f24878e = i13;
        this.f24879f = commentInfo;
        this.f24880g = z11;
        this.f24881h = z12;
        this.f24882i = str2;
    }

    public final String a() {
        return this.f24882i;
    }

    public final int b() {
        return this.f24878e;
    }

    public final CommentInfo c() {
        return this.f24879f;
    }

    public final String d() {
        return this.f24876c;
    }

    public final int e() {
        return this.f24874a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentNum)) {
            return false;
        }
        CommentNum commentNum = (CommentNum) obj;
        return this.f24874a == commentNum.f24874a && this.f24875b == commentNum.f24875b && x.b(this.f24876c, commentNum.f24876c) && this.f24877d == commentNum.f24877d && this.f24878e == commentNum.f24878e && x.b(this.f24879f, commentNum.f24879f) && this.f24880g == commentNum.f24880g && this.f24881h == commentNum.f24881h && x.b(this.f24882i, commentNum.f24882i);
    }

    public final boolean f() {
        return this.f24880g;
    }

    public final int g() {
        return this.f24877d;
    }

    public final long h() {
        return this.f24875b;
    }

    public int hashCode() {
        int a11 = ((this.f24874a * 31) + a.a(this.f24875b)) * 31;
        String str = this.f24876c;
        int i11 = 0;
        int hashCode = (((((a11 + (str == null ? 0 : str.hashCode())) * 31) + this.f24877d) * 31) + this.f24878e) * 31;
        CommentInfo commentInfo = this.f24879f;
        int hashCode2 = (hashCode + (commentInfo == null ? 0 : commentInfo.hashCode())) * 31;
        boolean z11 = this.f24880g;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.f24881h;
        if (!z13) {
            z12 = z13;
        }
        int i13 = (i12 + (z12 ? 1 : 0)) * 31;
        String str2 = this.f24882i;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i13 + i11;
    }

    public final boolean i() {
        return this.f24881h;
    }

    public String toString() {
        return "CommentNum(from=" + this.f24874a + ", topicId=" + this.f24875b + ", commentId=" + this.f24876c + ", num=" + this.f24877d + ", childPos=" + this.f24878e + ", commentData=" + this.f24879f + ", fromDetail=" + this.f24880g + ", isDel=" + this.f24881h + ", childCommentId=" + this.f24882i + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CommentNum(int r13, long r14, java.lang.String r16, int r17, int r18, com.hbg.lib.network.hbg.core.bean.CommentInfo r19, boolean r20, boolean r21, java.lang.String r22, int r23, kotlin.jvm.internal.r r24) {
        /*
            r12 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = r13
        L_0x0009:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0010
            r2 = 0
            goto L_0x0011
        L_0x0010:
            r2 = r14
        L_0x0011:
            r4 = r0 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0019
            r4 = r5
            goto L_0x001b
        L_0x0019:
            r4 = r16
        L_0x001b:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0022
            r6 = r7
            goto L_0x0024
        L_0x0022:
            r6 = r17
        L_0x0024:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002a
            r8 = -1
            goto L_0x002c
        L_0x002a:
            r8 = r18
        L_0x002c:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0032
            r9 = 0
            goto L_0x0034
        L_0x0032:
            r9 = r19
        L_0x0034:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003a
            r10 = r7
            goto L_0x003c
        L_0x003a:
            r10 = r20
        L_0x003c:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r7 = r21
        L_0x0043:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = r22
        L_0x004a:
            r13 = r12
            r14 = r1
            r15 = r2
            r17 = r4
            r18 = r6
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r7
            r23 = r5
            r13.<init>(r14, r15, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.utils.event.bean.CommentNum.<init>(int, long, java.lang.String, int, int, com.hbg.lib.network.hbg.core.bean.CommentInfo, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}

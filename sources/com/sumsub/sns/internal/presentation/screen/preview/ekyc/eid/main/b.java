package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main;

import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class b implements a.l {

    /* renamed from: a  reason: collision with root package name */
    public final a.C0436a f35776a;

    public static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35777b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35778c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35779d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f35780e;

        /* renamed from: f  reason: collision with root package name */
        public final SNSIconHandler.SNSEidIcons f35781f;

        /* renamed from: g  reason: collision with root package name */
        public final a.i f35782g;

        /* renamed from: h  reason: collision with root package name */
        public final a.C0436a f35783h;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, SNSIconHandler.SNSEidIcons sNSEidIcons, a.i iVar, a.C0436a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (i11 & 8) != 0 ? null : charSequence4, (i11 & 16) != 0 ? null : sNSEidIcons, (i11 & 32) != 0 ? null : iVar, aVar);
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, SNSIconHandler.SNSEidIcons sNSEidIcons, a.i iVar, a.C0436a aVar) {
            return new a(charSequence, charSequence2, charSequence3, charSequence4, sNSEidIcons, iVar, aVar);
        }

        public final CharSequence b() {
            return this.f35777b;
        }

        public final CharSequence c() {
            return this.f35778c;
        }

        public final CharSequence d() {
            return this.f35779d;
        }

        public final CharSequence e() {
            return this.f35780e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f35777b, aVar.f35777b) && x.b(this.f35778c, aVar.f35778c) && x.b(this.f35779d, aVar.f35779d) && x.b(this.f35780e, aVar.f35780e) && this.f35781f == aVar.f35781f && x.b(this.f35782g, aVar.f35782g) && x.b(this.f35783h, aVar.f35783h);
        }

        public final SNSIconHandler.SNSEidIcons f() {
            return this.f35781f;
        }

        public final a.i g() {
            return this.f35782g;
        }

        public final a.C0436a h() {
            return this.f35783h;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35777b;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35778c;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35779d;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f35780e;
            int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            SNSIconHandler.SNSEidIcons sNSEidIcons = this.f35781f;
            int hashCode5 = (hashCode4 + (sNSEidIcons == null ? 0 : sNSEidIcons.hashCode())) * 31;
            a.i iVar = this.f35782g;
            if (iVar != null) {
                i11 = iVar.hashCode();
            }
            return ((hashCode5 + i11) * 31) + this.f35783h.hashCode();
        }

        public final a.C0436a i() {
            return this.f35783h;
        }

        public final a.i j() {
            return this.f35782g;
        }

        public final CharSequence k() {
            return this.f35780e;
        }

        public final SNSIconHandler.SNSEidIcons l() {
            return this.f35781f;
        }

        public final CharSequence m() {
            return this.f35779d;
        }

        public final CharSequence n() {
            return this.f35778c;
        }

        public final CharSequence o() {
            return this.f35777b;
        }

        public String toString() {
            return "Info(title=" + this.f35777b + ", subtitle=" + this.f35778c + ", moreInfo=" + this.f35779d + ", buttonText=" + this.f35780e + ", icon=" + this.f35781f + ", buttonAction=" + this.f35782g + ", analyticsWrapper=" + this.f35783h + ')';
        }

        public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, SNSIconHandler.SNSEidIcons sNSEidIcons, a.i iVar, a.C0436a aVar) {
            super(aVar, (r) null);
            this.f35777b = charSequence;
            this.f35778c = charSequence2;
            this.f35779d = charSequence3;
            this.f35780e = charSequence4;
            this.f35781f = sNSEidIcons;
            this.f35782g = iVar;
            this.f35783h = aVar;
        }

        public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, SNSIconHandler.SNSEidIcons sNSEidIcons, a.i iVar, a.C0436a aVar2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = aVar.f35777b;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = aVar.f35778c;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = aVar.f35779d;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i11 & 8) != 0) {
                charSequence4 = aVar.f35780e;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i11 & 16) != 0) {
                sNSEidIcons = aVar.f35781f;
            }
            SNSIconHandler.SNSEidIcons sNSEidIcons2 = sNSEidIcons;
            if ((i11 & 32) != 0) {
                iVar = aVar.f35782g;
            }
            a.i iVar2 = iVar;
            if ((i11 & 64) != 0) {
                aVar2 = aVar.f35783h;
            }
            return aVar.a(charSequence, charSequence5, charSequence6, charSequence7, sNSEidIcons2, iVar2, aVar2);
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$b  reason: collision with other inner class name */
    public static final class C0466b extends b {

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35784b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35785c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35786d;

        /* renamed from: e  reason: collision with root package name */
        public final a.i f35787e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f35788f;

        /* renamed from: g  reason: collision with root package name */
        public final a.i f35789g;

        /* renamed from: h  reason: collision with root package name */
        public final a.C0436a f35790h;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0466b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a.i iVar, CharSequence charSequence4, a.i iVar2, a.C0436a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (i11 & 8) != 0 ? null : iVar, (i11 & 16) != 0 ? null : charSequence4, (i11 & 32) != 0 ? null : iVar2, aVar);
        }

        public final C0466b a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a.i iVar, CharSequence charSequence4, a.i iVar2, a.C0436a aVar) {
            return new C0466b(charSequence, charSequence2, charSequence3, iVar, charSequence4, iVar2, aVar);
        }

        public final CharSequence b() {
            return this.f35784b;
        }

        public final CharSequence c() {
            return this.f35785c;
        }

        public final CharSequence d() {
            return this.f35786d;
        }

        public final a.i e() {
            return this.f35787e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0466b)) {
                return false;
            }
            C0466b bVar = (C0466b) obj;
            return x.b(this.f35784b, bVar.f35784b) && x.b(this.f35785c, bVar.f35785c) && x.b(this.f35786d, bVar.f35786d) && x.b(this.f35787e, bVar.f35787e) && x.b(this.f35788f, bVar.f35788f) && x.b(this.f35789g, bVar.f35789g) && x.b(this.f35790h, bVar.f35790h);
        }

        public final CharSequence f() {
            return this.f35788f;
        }

        public final a.i g() {
            return this.f35789g;
        }

        public final a.C0436a h() {
            return this.f35790h;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35784b;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35785c;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35786d;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            a.i iVar = this.f35787e;
            int hashCode4 = (hashCode3 + (iVar == null ? 0 : iVar.hashCode())) * 31;
            CharSequence charSequence4 = this.f35788f;
            int hashCode5 = (hashCode4 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            a.i iVar2 = this.f35789g;
            if (iVar2 != null) {
                i11 = iVar2.hashCode();
            }
            return ((hashCode5 + i11) * 31) + this.f35790h.hashCode();
        }

        public final a.C0436a i() {
            return this.f35790h;
        }

        public final a.i j() {
            return this.f35789g;
        }

        public final CharSequence k() {
            return this.f35788f;
        }

        public final a.i l() {
            return this.f35787e;
        }

        public final CharSequence m() {
            return this.f35786d;
        }

        public final CharSequence n() {
            return this.f35785c;
        }

        public final CharSequence o() {
            return this.f35784b;
        }

        public String toString() {
            return "LegalInfo(title=" + this.f35784b + ", subtitle=" + this.f35785c + ", infoButtonText=" + this.f35786d + ", infoButtonAction=" + this.f35787e + ", buttonText=" + this.f35788f + ", buttonAction=" + this.f35789g + ", analyticsWrapper=" + this.f35790h + ')';
        }

        public C0466b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a.i iVar, CharSequence charSequence4, a.i iVar2, a.C0436a aVar) {
            super(aVar, (r) null);
            this.f35784b = charSequence;
            this.f35785c = charSequence2;
            this.f35786d = charSequence3;
            this.f35787e = iVar;
            this.f35788f = charSequence4;
            this.f35789g = iVar2;
            this.f35790h = aVar;
        }

        public static /* synthetic */ C0466b a(C0466b bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a.i iVar, CharSequence charSequence4, a.i iVar2, a.C0436a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = bVar.f35784b;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = bVar.f35785c;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = bVar.f35786d;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i11 & 8) != 0) {
                iVar = bVar.f35787e;
            }
            a.i iVar3 = iVar;
            if ((i11 & 16) != 0) {
                charSequence4 = bVar.f35788f;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i11 & 32) != 0) {
                iVar2 = bVar.f35789g;
            }
            a.i iVar4 = iVar2;
            if ((i11 & 64) != 0) {
                aVar = bVar.f35790h;
            }
            return bVar.a(charSequence, charSequence5, charSequence6, iVar3, charSequence7, iVar4, aVar);
        }
    }

    public static final class c extends b {

        /* renamed from: b  reason: collision with root package name */
        public static final c f35791b = new c();

        public c() {
            super((a.C0436a) null, (r) null);
        }
    }

    public static final class d extends b {

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35792b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35793c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35794d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f35795e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f35796f;

        /* renamed from: g  reason: collision with root package name */
        public final a.i f35797g;

        /* renamed from: h  reason: collision with root package name */
        public final a.i f35798h;

        /* renamed from: i  reason: collision with root package name */
        public final a.i f35799i;

        /* renamed from: j  reason: collision with root package name */
        public final a.C0436a f35800j;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ d(java.lang.CharSequence r14, java.lang.CharSequence r15, java.lang.CharSequence r16, java.lang.CharSequence r17, java.lang.CharSequence r18, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.i r19, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.i r20, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.i r21, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.C0436a r22, int r23, kotlin.jvm.internal.r r24) {
            /*
                r13 = this;
                r0 = r23
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r4 = r2
                goto L_0x000a
            L_0x0009:
                r4 = r14
            L_0x000a:
                r1 = r0 & 2
                if (r1 == 0) goto L_0x0010
                r5 = r2
                goto L_0x0011
            L_0x0010:
                r5 = r15
            L_0x0011:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x0017
                r6 = r2
                goto L_0x0019
            L_0x0017:
                r6 = r16
            L_0x0019:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x001f
                r7 = r2
                goto L_0x0021
            L_0x001f:
                r7 = r17
            L_0x0021:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0027
                r8 = r2
                goto L_0x0029
            L_0x0027:
                r8 = r18
            L_0x0029:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x002f
                r9 = r2
                goto L_0x0031
            L_0x002f:
                r9 = r19
            L_0x0031:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0037
                r10 = r2
                goto L_0x0039
            L_0x0037:
                r10 = r20
            L_0x0039:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x003f
                r11 = r2
                goto L_0x0041
            L_0x003f:
                r11 = r21
            L_0x0041:
                r3 = r13
                r12 = r22
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b.d.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$a, int, kotlin.jvm.internal.r):void");
        }

        public final d a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, a.i iVar, a.i iVar2, a.i iVar3, a.C0436a aVar) {
            return new d(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, iVar, iVar2, iVar3, aVar);
        }

        public final CharSequence b() {
            return this.f35792b;
        }

        public final CharSequence c() {
            return this.f35793c;
        }

        public final CharSequence d() {
            return this.f35794d;
        }

        public final CharSequence e() {
            return this.f35795e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f35792b, dVar.f35792b) && x.b(this.f35793c, dVar.f35793c) && x.b(this.f35794d, dVar.f35794d) && x.b(this.f35795e, dVar.f35795e) && x.b(this.f35796f, dVar.f35796f) && x.b(this.f35797g, dVar.f35797g) && x.b(this.f35798h, dVar.f35798h) && x.b(this.f35799i, dVar.f35799i) && x.b(this.f35800j, dVar.f35800j);
        }

        public final CharSequence f() {
            return this.f35796f;
        }

        public final a.i g() {
            return this.f35797g;
        }

        public final a.i h() {
            return this.f35798h;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35792b;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35793c;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35794d;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f35795e;
            int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            CharSequence charSequence5 = this.f35796f;
            int hashCode5 = (hashCode4 + (charSequence5 == null ? 0 : charSequence5.hashCode())) * 31;
            a.i iVar = this.f35797g;
            int hashCode6 = (hashCode5 + (iVar == null ? 0 : iVar.hashCode())) * 31;
            a.i iVar2 = this.f35798h;
            int hashCode7 = (hashCode6 + (iVar2 == null ? 0 : iVar2.hashCode())) * 31;
            a.i iVar3 = this.f35799i;
            if (iVar3 != null) {
                i11 = iVar3.hashCode();
            }
            return ((hashCode7 + i11) * 31) + this.f35800j.hashCode();
        }

        public final a.i i() {
            return this.f35799i;
        }

        public final a.C0436a j() {
            return this.f35800j;
        }

        public final a.C0436a k() {
            return this.f35800j;
        }

        public final a.i l() {
            return this.f35798h;
        }

        public final CharSequence m() {
            return this.f35796f;
        }

        public final a.i n() {
            return this.f35799i;
        }

        public final CharSequence o() {
            return this.f35794d;
        }

        public final a.i p() {
            return this.f35797g;
        }

        public final CharSequence q() {
            return this.f35795e;
        }

        public final CharSequence r() {
            return this.f35793c;
        }

        public final CharSequence s() {
            return this.f35792b;
        }

        public String toString() {
            return "PinTypeSelection(title=" + this.f35792b + ", subtitle=" + this.f35793c + ", pinTypeText=" + this.f35794d + ", sixDigitPin=" + this.f35795e + ", fiveDigitPin=" + this.f35796f + ", sixDigitAction=" + this.f35797g + ", fiveDigitAction=" + this.f35798h + ", pinTypeAction=" + this.f35799i + ", analyticsWrapper=" + this.f35800j + ')';
        }

        public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, a.i iVar, a.i iVar2, a.i iVar3, a.C0436a aVar) {
            super(aVar, (r) null);
            this.f35792b = charSequence;
            this.f35793c = charSequence2;
            this.f35794d = charSequence3;
            this.f35795e = charSequence4;
            this.f35796f = charSequence5;
            this.f35797g = iVar;
            this.f35798h = iVar2;
            this.f35799i = iVar3;
            this.f35800j = aVar;
        }

        public static /* synthetic */ d a(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, a.i iVar, a.i iVar2, a.i iVar3, a.C0436a aVar, int i11, Object obj) {
            d dVar2 = dVar;
            int i12 = i11;
            return dVar.a((i12 & 1) != 0 ? dVar2.f35792b : charSequence, (i12 & 2) != 0 ? dVar2.f35793c : charSequence2, (i12 & 4) != 0 ? dVar2.f35794d : charSequence3, (i12 & 8) != 0 ? dVar2.f35795e : charSequence4, (i12 & 16) != 0 ? dVar2.f35796f : charSequence5, (i12 & 32) != 0 ? dVar2.f35797g : iVar, (i12 & 64) != 0 ? dVar2.f35798h : iVar2, (i12 & 128) != 0 ? dVar2.f35799i : iVar3, (i12 & 256) != 0 ? dVar2.f35800j : aVar);
        }
    }

    public static final class e extends b {

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35801b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35802c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35803d;

        /* renamed from: e  reason: collision with root package name */
        public final Integer f35804e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f35805f;

        /* renamed from: g  reason: collision with root package name */
        public final a.i f35806g;

        /* renamed from: h  reason: collision with root package name */
        public final a.C0436a f35807h;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Integer num, CharSequence charSequence4, a.i iVar, a.C0436a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : charSequence4, (i11 & 32) != 0 ? null : iVar, aVar);
        }

        public final e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Integer num, CharSequence charSequence4, a.i iVar, a.C0436a aVar) {
            return new e(charSequence, charSequence2, charSequence3, num, charSequence4, iVar, aVar);
        }

        public final CharSequence b() {
            return this.f35801b;
        }

        public final CharSequence c() {
            return this.f35802c;
        }

        public final CharSequence d() {
            return this.f35803d;
        }

        public final Integer e() {
            return this.f35804e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f35801b, eVar.f35801b) && x.b(this.f35802c, eVar.f35802c) && x.b(this.f35803d, eVar.f35803d) && x.b(this.f35804e, eVar.f35804e) && x.b(this.f35805f, eVar.f35805f) && x.b(this.f35806g, eVar.f35806g) && x.b(this.f35807h, eVar.f35807h);
        }

        public final CharSequence f() {
            return this.f35805f;
        }

        public final a.i g() {
            return this.f35806g;
        }

        public final a.C0436a h() {
            return this.f35807h;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35801b;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35802c;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35803d;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            Integer num = this.f35804e;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            CharSequence charSequence4 = this.f35805f;
            int hashCode5 = (hashCode4 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            a.i iVar = this.f35806g;
            if (iVar != null) {
                i11 = iVar.hashCode();
            }
            return ((hashCode5 + i11) * 31) + this.f35807h.hashCode();
        }

        public final a.C0436a i() {
            return this.f35807h;
        }

        public final a.i j() {
            return this.f35806g;
        }

        public final CharSequence k() {
            return this.f35805f;
        }

        public final Integer l() {
            return this.f35804e;
        }

        public final CharSequence m() {
            return this.f35803d;
        }

        public final CharSequence n() {
            return this.f35802c;
        }

        public final CharSequence o() {
            return this.f35801b;
        }

        public String toString() {
            return "Scanning(title=" + this.f35801b + ", subtitle=" + this.f35802c + ", status=" + this.f35803d + ", progress=" + this.f35804e + ", buttonText=" + this.f35805f + ", buttonAction=" + this.f35806g + ", analyticsWrapper=" + this.f35807h + ')';
        }

        public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Integer num, CharSequence charSequence4, a.i iVar, a.C0436a aVar) {
            super(aVar, (r) null);
            this.f35801b = charSequence;
            this.f35802c = charSequence2;
            this.f35803d = charSequence3;
            this.f35804e = num;
            this.f35805f = charSequence4;
            this.f35806g = iVar;
            this.f35807h = aVar;
        }

        public static /* synthetic */ e a(e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Integer num, CharSequence charSequence4, a.i iVar, a.C0436a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = eVar.f35801b;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = eVar.f35802c;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = eVar.f35803d;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i11 & 8) != 0) {
                num = eVar.f35804e;
            }
            Integer num2 = num;
            if ((i11 & 16) != 0) {
                charSequence4 = eVar.f35805f;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i11 & 32) != 0) {
                iVar = eVar.f35806g;
            }
            a.i iVar2 = iVar;
            if ((i11 & 64) != 0) {
                aVar = eVar.f35807h;
            }
            return eVar.a(charSequence, charSequence5, charSequence6, num2, charSequence7, iVar2, aVar);
        }
    }

    public static final class f extends b {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35808b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35809c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35810d;

        /* renamed from: e  reason: collision with root package name */
        public final String f35811e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f35812f;

        /* renamed from: g  reason: collision with root package name */
        public final a.i f35813g;

        /* renamed from: h  reason: collision with root package name */
        public final a.C0436a f35814h;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ f(boolean z11, CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, a.i iVar, a.C0436a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? null : charSequence, (i11 & 4) != 0 ? null : charSequence2, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : charSequence3, (i11 & 32) != 0 ? null : iVar, aVar);
        }

        public final f a(boolean z11, CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, a.i iVar, a.C0436a aVar) {
            return new f(z11, charSequence, charSequence2, str, charSequence3, iVar, aVar);
        }

        public final boolean b() {
            return this.f35808b;
        }

        public final CharSequence c() {
            return this.f35809c;
        }

        public final CharSequence d() {
            return this.f35810d;
        }

        public final String e() {
            return this.f35811e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f35808b == fVar.f35808b && x.b(this.f35809c, fVar.f35809c) && x.b(this.f35810d, fVar.f35810d) && x.b(this.f35811e, fVar.f35811e) && x.b(this.f35812f, fVar.f35812f) && x.b(this.f35813g, fVar.f35813g) && x.b(this.f35814h, fVar.f35814h);
        }

        public final CharSequence f() {
            return this.f35812f;
        }

        public final a.i g() {
            return this.f35813g;
        }

        public final a.C0436a h() {
            return this.f35814h;
        }

        public int hashCode() {
            boolean z11 = this.f35808b;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            CharSequence charSequence = this.f35809c;
            int i12 = 0;
            int hashCode = (i11 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f35810d;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            String str = this.f35811e;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            CharSequence charSequence3 = this.f35812f;
            int hashCode4 = (hashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            a.i iVar = this.f35813g;
            if (iVar != null) {
                i12 = iVar.hashCode();
            }
            return ((hashCode4 + i12) * 31) + this.f35814h.hashCode();
        }

        public final a.C0436a i() {
            return this.f35814h;
        }

        public final a.i j() {
            return this.f35813g;
        }

        public final CharSequence k() {
            return this.f35812f;
        }

        public final String l() {
            return this.f35811e;
        }

        public final boolean m() {
            return this.f35808b;
        }

        public final CharSequence n() {
            return this.f35810d;
        }

        public final CharSequence o() {
            return this.f35809c;
        }

        public String toString() {
            return "Status(success=" + this.f35808b + ", title=" + this.f35809c + ", text=" + this.f35810d + ", icon=" + this.f35811e + ", buttonText=" + this.f35812f + ", buttonAction=" + this.f35813g + ", analyticsWrapper=" + this.f35814h + ')';
        }

        public f(boolean z11, CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, a.i iVar, a.C0436a aVar) {
            super(aVar, (r) null);
            this.f35808b = z11;
            this.f35809c = charSequence;
            this.f35810d = charSequence2;
            this.f35811e = str;
            this.f35812f = charSequence3;
            this.f35813g = iVar;
            this.f35814h = aVar;
        }

        public static /* synthetic */ f a(f fVar, boolean z11, CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, a.i iVar, a.C0436a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = fVar.f35808b;
            }
            if ((i11 & 2) != 0) {
                charSequence = fVar.f35809c;
            }
            CharSequence charSequence4 = charSequence;
            if ((i11 & 4) != 0) {
                charSequence2 = fVar.f35810d;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i11 & 8) != 0) {
                str = fVar.f35811e;
            }
            String str2 = str;
            if ((i11 & 16) != 0) {
                charSequence3 = fVar.f35812f;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i11 & 32) != 0) {
                iVar = fVar.f35813g;
            }
            a.i iVar2 = iVar;
            if ((i11 & 64) != 0) {
                aVar = fVar.f35814h;
            }
            return fVar.a(z11, charSequence4, charSequence5, str2, charSequence6, iVar2, aVar);
        }
    }

    public /* synthetic */ b(a.C0436a aVar, r rVar) {
        this(aVar);
    }

    public final a.C0436a a() {
        return this.f35776a;
    }

    public b(a.C0436a aVar) {
        this.f35776a = aVar;
    }
}

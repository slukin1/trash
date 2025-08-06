package com.sumsub.sns.internal.presentation.screen.preview.selfie;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.VideoRequiredType;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.domain.model.a;
import com.sumsub.sns.internal.domain.q;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.presentation.screen.preview.a;
import d10.p;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class a extends com.sumsub.sns.internal.presentation.screen.preview.a<d> {
    public static final C0483a F = new C0483a((r) null);
    public static final String G = "KEY_FILE";
    public static final String H = "KEY_PHRASE";
    public final q D;
    public final j1<File> E;

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.selfie.a$a  reason: collision with other inner class name */
    public static final class C0483a {
        public /* synthetic */ C0483a(r rVar) {
            this();
        }

        public C0483a() {
        }
    }

    public static final class b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final c f36205a;

        public b(c cVar) {
            this.f36205a = cVar;
        }

        public final c a() {
            return this.f36205a;
        }

        public final c b() {
            return this.f36205a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f36205a, ((b) obj).f36205a);
        }

        public int hashCode() {
            return this.f36205a.hashCode();
        }

        public String toString() {
            return "ShowSelfiePicker(params=" + this.f36205a + ')';
        }

        public final b a(c cVar) {
            return new b(cVar);
        }

        public static /* synthetic */ b a(b bVar, c cVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                cVar = bVar.f36205a;
            }
            return bVar.a(cVar);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f36206a;

        /* renamed from: b  reason: collision with root package name */
        public final String f36207b;

        public c(String str, String str2) {
            this.f36206a = str;
            this.f36207b = str2;
        }

        public final String a() {
            return this.f36206a;
        }

        public final String b() {
            return this.f36207b;
        }

        public final String c() {
            return this.f36206a;
        }

        public final String d() {
            return this.f36207b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f36206a, cVar.f36206a) && x.b(this.f36207b, cVar.f36207b);
        }

        public int hashCode() {
            int hashCode = this.f36206a.hashCode() * 31;
            String str = this.f36207b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "VideoParams(idDocSetType=" + this.f36206a + ", type=" + this.f36207b + ')';
        }

        public final c a(String str, String str2) {
            return new c(str, str2);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f36206a;
            }
            if ((i11 & 2) != 0) {
                str2 = cVar.f36207b;
            }
            return cVar.a(str, str2);
        }
    }

    public static final class d extends a.d {

        /* renamed from: a  reason: collision with root package name */
        public final File f36208a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f36209b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f36210c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f36211d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f36212e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f36213f;

        public d() {
            this((File) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 63, (r) null);
        }

        public final File a() {
            return this.f36208a;
        }

        public final CharSequence b() {
            return this.f36209b;
        }

        public final CharSequence c() {
            return this.f36210c;
        }

        public final CharSequence d() {
            return this.f36211d;
        }

        public final CharSequence e() {
            return this.f36212e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f36208a, dVar.f36208a) && x.b(this.f36209b, dVar.f36209b) && x.b(this.f36210c, dVar.f36210c) && x.b(this.f36211d, dVar.f36211d) && x.b(this.f36212e, dVar.f36212e) && this.f36213f == dVar.f36213f;
        }

        public final boolean f() {
            return this.f36213f;
        }

        public final CharSequence g() {
            return this.f36212e;
        }

        public final CharSequence h() {
            return this.f36211d;
        }

        public int hashCode() {
            File file = this.f36208a;
            int i11 = 0;
            int hashCode = (file == null ? 0 : file.hashCode()) * 31;
            CharSequence charSequence = this.f36209b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f36210c;
            int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f36211d;
            int hashCode4 = (hashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f36212e;
            if (charSequence4 != null) {
                i11 = charSequence4.hashCode();
            }
            int i12 = (hashCode4 + i11) * 31;
            boolean z11 = this.f36213f;
            if (z11) {
                z11 = true;
            }
            return i12 + (z11 ? 1 : 0);
        }

        public final boolean i() {
            return this.f36213f;
        }

        public final CharSequence j() {
            return this.f36210c;
        }

        public final CharSequence k() {
            return this.f36209b;
        }

        public final File l() {
            return this.f36208a;
        }

        public String toString() {
            return "ViewState(videoFile=" + this.f36208a + ", title=" + this.f36209b + ", subtitle=" + this.f36210c + ", buttonPositive=" + this.f36211d + ", buttonNegative=" + this.f36212e + ", showContent=" + this.f36213f + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ d(java.io.File r5, java.lang.CharSequence r6, java.lang.CharSequence r7, java.lang.CharSequence r8, java.lang.CharSequence r9, boolean r10, int r11, kotlin.jvm.internal.r r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                r0 = 0
                if (r12 == 0) goto L_0x0007
                r12 = r0
                goto L_0x0008
            L_0x0007:
                r12 = r5
            L_0x0008:
                r5 = r11 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r11 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r11 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r11 & 16
                if (r5 == 0) goto L_0x0022
                goto L_0x0023
            L_0x0022:
                r0 = r9
            L_0x0023:
                r5 = r11 & 32
                if (r5 == 0) goto L_0x0028
                r10 = 0
            L_0x0028:
                r11 = r10
                r5 = r4
                r6 = r12
                r7 = r1
                r8 = r2
                r9 = r3
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d.<init>(java.io.File, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, boolean, int, kotlin.jvm.internal.r):void");
        }

        public final d a(File file, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11) {
            return new d(file, charSequence, charSequence2, charSequence3, charSequence4, z11);
        }

        public d(File file, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11) {
            this.f36208a = file;
            this.f36209b = charSequence;
            this.f36210c = charSequence2;
            this.f36211d = charSequence3;
            this.f36212e = charSequence4;
            this.f36213f = z11;
        }

        public static /* synthetic */ d a(d dVar, File file, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                file = dVar.f36208a;
            }
            if ((i11 & 2) != 0) {
                charSequence = dVar.f36209b;
            }
            CharSequence charSequence5 = charSequence;
            if ((i11 & 4) != 0) {
                charSequence2 = dVar.f36210c;
            }
            CharSequence charSequence6 = charSequence2;
            if ((i11 & 8) != 0) {
                charSequence3 = dVar.f36211d;
            }
            CharSequence charSequence7 = charSequence3;
            if ((i11 & 16) != 0) {
                charSequence4 = dVar.f36212e;
            }
            CharSequence charSequence8 = charSequence4;
            if ((i11 & 32) != 0) {
                z11 = dVar.f36213f;
            }
            return dVar.a(file, charSequence5, charSequence6, charSequence7, charSequence8, z11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$onPrepare$2", f = "SNSPreviewSelfieViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<File, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36214a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36215b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f36216c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$onPrepare$2$1", f = "SNSPreviewSelfieViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.selfie.a$e$a  reason: collision with other inner class name */
        public static final class C0484a extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36217a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f36218b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ File f36219c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0484a(File file, kotlin.coroutines.c<? super C0484a> cVar) {
                super(2, cVar);
                this.f36219c = file;
            }

            /* renamed from: a */
            public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
                return ((C0484a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0484a aVar = new C0484a(this.f36219c, cVar);
                aVar.f36218b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f36217a == 0) {
                    k.b(obj);
                    return d.a((d) this.f36218b, this.f36219c, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 62, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f36216c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(File file, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(file, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f36216c, cVar);
            eVar.f36215b = obj;
            return eVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36214a == 0) {
                k.b(obj);
                com.sumsub.sns.core.presentation.base.a.a(this.f36216c, false, new C0484a((File) this.f36215b, (kotlin.coroutines.c<? super C0484a>) null), 1, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$onPrepare$3", f = "SNSPreviewSelfieViewModel.kt", l = {58, 59, 60, 61}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36220a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36221b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36222c;

        /* renamed from: d  reason: collision with root package name */
        public int f36223d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f36225f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f36225f = aVar;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((f) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f fVar = new f(this.f36225f, cVar);
            fVar.f36224e = obj;
            return fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x009c A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r10.f36223d
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0058
                if (r1 == r5) goto L_0x0050
                if (r1 == r4) goto L_0x0044
                if (r1 == r3) goto L_0x0034
                if (r1 != r2) goto L_0x002c
                java.lang.Object r0 = r10.f36222c
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r10.f36221b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r10.f36220a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r10.f36224e
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r3 = (com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d) r3
                kotlin.k.b(r11)
                r4 = r0
                r0 = r3
            L_0x0029:
                r3 = r1
                goto L_0x00be
            L_0x002c:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0034:
                java.lang.Object r1 = r10.f36221b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r10.f36220a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r10.f36224e
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r4 = (com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d) r4
                kotlin.k.b(r11)
                goto L_0x00a1
            L_0x0044:
                java.lang.Object r1 = r10.f36220a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r4 = r10.f36224e
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r4 = (com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d) r4
                kotlin.k.b(r11)
                goto L_0x0088
            L_0x0050:
                java.lang.Object r1 = r10.f36224e
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r1 = (com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d) r1
                kotlin.k.b(r11)
                goto L_0x0071
            L_0x0058:
                kotlin.k.b(r11)
                java.lang.Object r11 = r10.f36224e
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r11 = (com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d) r11
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a r1 = r10.f36225f
                r10.f36224e = r11
                r10.f36223d = r5
                java.lang.String r5 = "sns_preview_video_title"
                java.lang.Object r1 = r1.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r10)
                if (r1 != r0) goto L_0x006e
                return r0
            L_0x006e:
                r9 = r1
                r1 = r11
                r11 = r9
            L_0x0071:
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a r5 = r10.f36225f
                r10.f36224e = r1
                r10.f36220a = r11
                r10.f36223d = r4
                java.lang.String r4 = "sns_preview_video_subtitle"
                java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r10)
                if (r4 != r0) goto L_0x0084
                return r0
            L_0x0084:
                r9 = r1
                r1 = r11
                r11 = r4
                r4 = r9
            L_0x0088:
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a r5 = r10.f36225f
                r10.f36224e = r4
                r10.f36220a = r1
                r10.f36221b = r11
                r10.f36223d = r3
                java.lang.String r3 = "sns_preview_video_action_accept"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r10)
                if (r3 != r0) goto L_0x009d
                return r0
            L_0x009d:
                r9 = r1
                r1 = r11
                r11 = r3
                r3 = r9
            L_0x00a1:
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a r5 = r10.f36225f
                r10.f36224e = r4
                r10.f36220a = r3
                r10.f36221b = r1
                r10.f36222c = r11
                r10.f36223d = r2
                java.lang.String r2 = "sns_preview_video_action_retake"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r10)
                if (r2 != r0) goto L_0x00b8
                return r0
            L_0x00b8:
                r0 = r4
                r4 = r11
                r11 = r2
                r2 = r3
                goto L_0x0029
            L_0x00be:
                r5 = r11
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1 = 0
                r6 = 0
                r7 = 33
                r8 = 0
                com.sumsub.sns.internal.presentation.screen.preview.selfie.a$d r11 = com.sumsub.sns.internal.presentation.screen.preview.selfie.a.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.selfie.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$onTakeAnotherDataClicked$1", f = "SNSPreviewSelfieViewModel.kt", l = {81}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36226a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f36227b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f36227b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f36227b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36226a;
            if (i11 == 0) {
                k.b(obj);
                com.sumsub.sns.internal.core.data.source.dynamic.b a11 = this.f36227b.t();
                this.f36226a = 1;
                obj = com.sumsub.sns.internal.core.data.source.dynamic.h.i(a11, false, this, 1, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f36227b.a((com.sumsub.sns.internal.core.data.model.g) ((com.sumsub.sns.internal.core.data.source.dynamic.e) obj).d());
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$showContent$1", f = "SNSPreviewSelfieViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36228a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36229b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36230c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(boolean z11, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f36230c = z11;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((h) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            h hVar = new h(this.f36230c, cVar);
            hVar.f36229b = obj;
            return hVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36228a == 0) {
                k.b(obj);
                return d.a((d) this.f36229b, (File) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, this.f36230c, 31, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$uploadDataOrMoveToStatusScreen$1", f = "SNSPreviewSelfieViewModel.kt", l = {115}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36231a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f36232b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f36233c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar, File file, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f36232b = aVar;
            this.f36233c = file;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f36232b, this.f36233c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36231a;
            if (i11 == 0) {
                k.b(obj);
                q d12 = this.f36232b.D;
                q.a aVar = new q.a(this.f36232b.u(), this.f36233c, this.f36232b.B());
                this.f36231a = 1;
                obj = d12.b(aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.domain.model.a aVar2 = (com.sumsub.sns.internal.core.domain.model.a) obj;
            a aVar3 = this.f36232b;
            if (aVar2.b()) {
                aVar3.a(((a.b) aVar2).d());
            } else if (aVar2.a()) {
                aVar3.a((Exception) ((a.C0372a) aVar2).d());
            }
            return Unit.f56620a;
        }
    }

    public a(Document document, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, q qVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(document, savedStateHandle, aVar, bVar, dVar);
        this.D = qVar;
        this.E = savedStateHandle.g(G, null);
        c.a(c.f36237b, "Preview Selfie is created", (Throwable) null, 4, (Object) null);
    }

    /* renamed from: A */
    public d e() {
        return new d((File) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 63, (r) null);
    }

    public final String B() {
        return (String) x().f(H);
    }

    public final void C() {
        File value = this.E.getValue();
        if (value != null) {
            String B = B();
            if (!(B == null || B.length() == 0)) {
                b(true);
                c.a(c.f36237b, "Uploading video selfie fallback. File - " + value.getAbsolutePath() + ", Phrase - " + B(), (Throwable) null, 4, (Object) null);
                n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new i(this, value, (kotlin.coroutines.c<? super i>) null), 3, (Object) null);
                return;
            }
        }
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
    }

    public void y() {
        C();
    }

    public void z() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g(this, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
    }

    public void b(o oVar) {
        c.a(c.f36237b, "Preview selfie error handling... " + oVar, (Throwable) null, 4, (Object) null);
        if (oVar instanceof o.e) {
            C();
        } else {
            super.b(oVar);
        }
    }

    public void c(boolean z11) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new h(z11, (kotlin.coroutines.c<? super h>) null), 1, (Object) null);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        b0.b(this.E, m0.a(this), new e(this, (kotlin.coroutines.c<? super e>) null));
        com.sumsub.sns.core.presentation.base.a.a(this, false, new f(this, (kotlin.coroutines.c<? super f>) null), 1, (Object) null);
        m();
        return Unit.f56620a;
    }

    public Object a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
        if (x().f(G) == null) {
            a(gVar);
        } else {
            b(false);
            c(true);
        }
        return Unit.f56620a;
    }

    public final void a(File file, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onHandleVideoSelfie. File - ");
        sb2.append(file != null ? file.getAbsolutePath() : null);
        sb2.append(", Phrase size - ");
        sb2.append(str != null ? Integer.valueOf(str.length()) : null);
        c.a(c.f36237b, sb2.toString(), (Throwable) null, 4, (Object) null);
        if (file != null) {
            if (!(str == null || str.length() == 0)) {
                x().k(G, file);
                x().k(H, str);
                b(false);
                c(true);
                return;
            }
        }
        if (this.E.getValue() == null) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
        }
    }

    public final void a(Object obj) {
        c.a(c.f36237b, "Video Selfie uploaded successful. Document is " + u().getType(), (Throwable) null, 4, (Object) null);
        a(u());
    }

    public final void a(Exception exc) {
        c.a(c.f36237b, "An error while uploading video selfie", exc);
        b(false);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) exc, u().getType().c(), (Object) null, 4, (Object) null);
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar) {
        if (gVar == null) {
            c.a(c.f36237b, "applicant null!", (Throwable) null, 4, (Object) null);
            com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), c.f36237b, "applicant null!", (Throwable) null, 4, (Object) null);
            return;
        }
        g.c.a a11 = gVar.a(u().getType());
        c.a(c.f36237b, "showPicker: docSet=" + a11, (Throwable) null, 4, (Object) null);
        if (x.b(a11 != null ? a11.r() : null, VideoRequiredType.Enabled.getValue())) {
            c.a(c.f36237b, "showPicker: show video selfie", (Throwable) null, 4, (Object) null);
            a((a.j) new b(new c(u().getType().c(), v())));
        }
    }
}

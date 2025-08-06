package com.sumsub.sns.internal.presentation.screen.preview.photo.identity;

import android.graphics.Bitmap;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.model.SNSDocumentDefinition;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.analytics.GlobalStatePayload;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.o0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.domain.o;
import com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import d10.p;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class SNSPreviewIdentityDocumentViewModel extends SNSPreviewPhotoDocumentViewModel {
    public static final /* synthetic */ l<Object>[] Z = {Reflection.e(new MutablePropertyReference1Impl(SNSPreviewIdentityDocumentViewModel.class, "showSelectorOnStart", "getShowSelectorOnStart()Z", 0))};
    public final com.sumsub.sns.internal.core.data.source.extensions.a X;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a Y;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel$DocumentSideness;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "SINGLE", "DOUBLE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum DocumentSideness {
        UNKNOWN,
        SINGLE,
        DOUBLE
    }

    public static final class a implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f36100a;

        public a(String str) {
            this.f36100a = str;
        }

        public final String a() {
            return this.f36100a;
        }

        public final String b() {
            return this.f36100a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && x.b(this.f36100a, ((a) obj).f36100a);
        }

        public int hashCode() {
            return this.f36100a.hashCode();
        }

        public String toString() {
            return "SelectorRequest(documentType=" + this.f36100a + ')';
        }

        public final a a(String str) {
            return new a(str);
        }

        public static /* synthetic */ a a(a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f36100a;
            }
            return aVar.a(str);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {113}, m = "findPreferredDocumentInSelector")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36101a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36102b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36103c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36104d;

        /* renamed from: e  reason: collision with root package name */
        public int f36105e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
            this.f36104d = sNSPreviewIdentityDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36103c = obj;
            this.f36105e |= Integer.MIN_VALUE;
            return this.f36104d.a((Map<String, SNSDocumentDefinition>) null, (kotlin.coroutines.c<? super SNSDocumentDefinition>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {95, 99}, m = "onDataLoaded")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36106a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36107b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36108c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36109d;

        /* renamed from: e  reason: collision with root package name */
        public int f36110e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f36109d = sNSPreviewIdentityDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36108c = obj;
            this.f36110e |= Integer.MIN_VALUE;
            return this.f36109d.a((com.sumsub.sns.internal.core.data.model.g) null, (com.sumsub.sns.internal.core.data.model.e) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$onDocumentAndCountrySelected$1", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {174}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36111a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36112b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f36112b = sNSPreviewIdentityDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f36112b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36111a;
            if (i11 == 0) {
                k.b(obj);
                SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel = this.f36112b;
                this.f36111a = 1;
                if (sNSPreviewIdentityDocumentViewModel.c(false, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {71}, m = "onPrepare")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36113a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36115c;

        /* renamed from: d  reason: collision with root package name */
        public int f36116d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f36115c = sNSPreviewIdentityDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36114b = obj;
            this.f36116d |= Integer.MIN_VALUE;
            return this.f36115c.d(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {191}, m = "preparePickerRequest")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36117a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36118b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36119c;

        /* renamed from: d  reason: collision with root package name */
        public int f36120d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36121e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36122f;

        /* renamed from: g  reason: collision with root package name */
        public int f36123g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f36122f = sNSPreviewIdentityDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36121e = obj;
            this.f36123g |= Integer.MIN_VALUE;
            return this.f36122f.a(false, (com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c<? super SNSPreviewPhotoDocumentViewModel.f>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {178, 181}, m = "resolveSecondSide")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36124a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36125b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36126c;

        /* renamed from: d  reason: collision with root package name */
        public int f36127d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f36126c = sNSPreviewIdentityDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36125b = obj;
            this.f36127d |= Integer.MIN_VALUE;
            return this.f36126c.b(false, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$showDocumentTypeSelector$1", f = "SNSPreviewIdentityDocumentViewModel.kt", l = {128, 129, 130}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36128a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36129b;

        /* renamed from: c  reason: collision with root package name */
        public int f36130c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f36131d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewIdentityDocumentViewModel f36132e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(boolean z11, SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f36131d = z11;
            this.f36132e = sNSPreviewIdentityDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f36131d, this.f36132e, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00c3 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ee A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f36130c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x003d
                if (r1 == r6) goto L_0x0035
                if (r1 == r4) goto L_0x0028
                if (r1 != r3) goto L_0x0020
                java.lang.Object r0 = r14.f36129b
                com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                java.lang.Object r1 = r14.f36128a
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
                kotlin.k.b(r15)
                goto L_0x00c6
            L_0x0020:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0028:
                java.lang.Object r1 = r14.f36129b
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
                java.lang.Object r4 = r14.f36128a
                java.util.Map r4 = (java.util.Map) r4
                kotlin.k.b(r15)
                goto L_0x00ad
            L_0x0035:
                java.lang.Object r1 = r14.f36128a
                java.util.Map r1 = (java.util.Map) r1
                kotlin.k.b(r15)
                goto L_0x008e
            L_0x003d:
                kotlin.k.b(r15)
                com.sumsub.sns.internal.camera.photo.presentation.document.b r7 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r1 = "showDocumentTypeSelector, fromWarning="
                r15.append(r1)
                boolean r1 = r14.f36131d
                r15.append(r1)
                java.lang.String r9 = r15.toString()
                r10 = 0
                r11 = 4
                r12 = 0
                java.lang.String r8 = "DocCapture"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r7, r8, r9, r10, r11, r12)
                com.sumsub.sns.internal.core.common.e0 r15 = com.sumsub.sns.internal.core.common.e0.f32018a
                java.util.Map r15 = r15.getPreferredDocumentsDefinitions()
                if (r15 == 0) goto L_0x0139
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r1 = r14.f36132e
                com.sumsub.sns.internal.core.data.model.Document r1 = r1.u()
                boolean r1 = r1.isSubmitted()
                if (r1 != 0) goto L_0x0139
                boolean r1 = r14.f36131d
                if (r1 != 0) goto L_0x0139
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r1 = r14.f36132e
                com.sumsub.sns.internal.core.data.source.dynamic.b r7 = r1.t()
                r14.f36128a = r15
                r14.f36130c = r6
                r8 = 0
                r9 = 0
                r11 = 3
                r12 = 0
                r10 = r14
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r7, r8, r9, r10, r11, r12)
                if (r1 != r0) goto L_0x008b
                return r0
            L_0x008b:
                r13 = r1
                r1 = r15
                r15 = r13
            L_0x008e:
                com.sumsub.sns.internal.core.data.source.dynamic.e r15 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r15
                java.lang.Object r15 = r15.d()
                com.sumsub.sns.internal.core.data.model.g r15 = (com.sumsub.sns.internal.core.data.model.g) r15
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r7 = r14.f36132e
                com.sumsub.sns.internal.core.data.source.dynamic.b r7 = r7.t()
                r14.f36128a = r1
                r14.f36129b = r15
                r14.f36130c = r4
                java.lang.Object r4 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r7, r2, r14, r6, r5)
                if (r4 != r0) goto L_0x00a9
                return r0
            L_0x00a9:
                r13 = r1
                r1 = r15
                r15 = r4
                r4 = r13
            L_0x00ad:
                com.sumsub.sns.internal.core.data.source.dynamic.e r15 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r15
                java.lang.Object r15 = r15.d()
                com.sumsub.sns.internal.core.data.model.e r15 = (com.sumsub.sns.internal.core.data.model.e) r15
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r7 = r14.f36132e
                r14.f36128a = r1
                r14.f36129b = r15
                r14.f36130c = r3
                java.lang.Object r3 = r7.a((java.util.Map<java.lang.String, com.sumsub.sns.core.data.model.SNSDocumentDefinition>) r4, (kotlin.coroutines.c<? super com.sumsub.sns.core.data.model.SNSDocumentDefinition>) r14)
                if (r3 != r0) goto L_0x00c4
                return r0
            L_0x00c4:
                r0 = r15
                r15 = r3
            L_0x00c6:
                com.sumsub.sns.core.data.model.SNSDocumentDefinition r15 = (com.sumsub.sns.core.data.model.SNSDocumentDefinition) r15
                if (r15 == 0) goto L_0x00d0
                java.lang.String r3 = r15.getCountry()
                if (r3 != 0) goto L_0x00d8
            L_0x00d0:
                if (r1 == 0) goto L_0x00d7
                java.lang.String r3 = r1.u()
                goto L_0x00d8
            L_0x00d7:
                r3 = r5
            L_0x00d8:
                if (r15 == 0) goto L_0x00df
                java.lang.String r1 = r15.getIdDocType()
                goto L_0x00e0
            L_0x00df:
                r1 = r5
            L_0x00e0:
                if (r0 == 0) goto L_0x00ec
                java.util.Map r0 = r0.v()
                if (r0 == 0) goto L_0x00ec
                java.lang.Object r5 = r0.get(r3)
            L_0x00ec:
                if (r3 == 0) goto L_0x0139
                if (r1 == 0) goto L_0x00f8
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r1)
                r0 = r0 ^ r6
                if (r0 != r6) goto L_0x00f8
                r2 = r6
            L_0x00f8:
                if (r2 == 0) goto L_0x0139
                if (r5 == 0) goto L_0x0139
                com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Picked preferred document: "
                r0.append(r1)
                r0.append(r15)
                java.lang.String r1 = ", country="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r8 = r0.toString()
                r9 = 0
                r10 = 4
                r11 = 0
                java.lang.String r7 = "DocCapture"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r0 = r14.f36132e
                java.lang.String r15 = r15.getIdDocType()
                if (r15 == 0) goto L_0x012d
                r0.b((java.lang.String) r3, (java.lang.String) r15)
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            L_0x012d:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "Required value was null."
                java.lang.String r0 = r0.toString()
                r15.<init>(r0)
                throw r15
            L_0x0139:
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r15 = r14.f36132e
                com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$a r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$a
                com.sumsub.sns.internal.core.data.model.Document r1 = r15.u()
                com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
                java.lang.String r1 = r1.c()
                r0.<init>(r1)
                r15.a((com.sumsub.sns.core.presentation.base.a.j) r0)
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewIdentityDocumentViewModel(Document document, SavedStateHandle savedStateHandle, o oVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.data.source.extensions.a aVar2, o0 o0Var, com.sumsub.sns.internal.ml.core.e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> eVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(document, savedStateHandle, aVar, bVar, aVar2, oVar, o0Var, eVar, dVar);
        this.X = aVar2;
        SavedStateHandle savedStateHandle2 = savedStateHandle;
        this.Y = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "showSelectorOnStart", Boolean.TRUE);
    }

    public void M() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "onRestartStep", (Throwable) null, 4, (Object) null);
        if (H()) {
            super.M();
            return;
        }
        R();
        h(true);
    }

    public final boolean T() {
        return e0.f32018a.getPreferredDocumentsDefinitions() != null;
    }

    public final boolean U() {
        return ((Boolean) this.Y.a(this, Z[0])).booleanValue();
    }

    public final boolean V() {
        if (J() == IdentitySide.Front) {
            if (!G().isEmpty()) {
                return true;
            }
        } else if (G().size() > 1) {
            return true;
        }
        return false;
    }

    public final void W() {
        if (V() || H() || T()) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) null, (Object) null, (Long) null, 7, (Object) null);
        } else {
            X();
        }
    }

    public final void X() {
        R();
        a((n) null);
    }

    public final void Y() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "restartStep", (Throwable) null, 4, (Object) null);
        if (J() == IdentitySide.Front) {
            a(this, false, 1, (Object) null);
        } else {
            super.a((com.sumsub.sns.internal.core.data.model.l) null);
        }
    }

    public final void Z() {
        com.sumsub.sns.internal.core.analytics.b.f31873a.a(GlobalStatePayload.IdDocSubType, J().getValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.e
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$e r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.e) r0
            int r1 = r0.f36116d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36116d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$e r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$e
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f36114b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36116d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f36113a
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f36113a = r4
            r0.f36116d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            r0.m()
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.d(kotlin.coroutines.c):java.lang.Object");
    }

    public Object f(kotlin.coroutines.c<? super CharSequence> cVar) {
        return this.X.a(com.sumsub.sns.internal.core.data.model.q.a(com.sumsub.sns.internal.core.data.model.q.f32683c.a(v()), h(), (CharSequence) null, 2, (Object) null));
    }

    public final void g(boolean z11) {
        this.Y.a(this, Z[0], Boolean.valueOf(z11));
    }

    public final n1 h(boolean z11) {
        return i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h(z11, this, (kotlin.coroutines.c<? super h>) null), 3, (Object) null);
    }

    public final void b(String str, String str2) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "onDocumentAndCountrySelected: c=" + str + ", t=" + str2, (Throwable) null, 4, (Object) null);
        a(str, str2);
        n1 unused = i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new d(this, (kotlin.coroutines.c<? super d>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r13, com.sumsub.sns.internal.core.data.model.e r14, kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r13 = r15 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.c
            if (r13 == 0) goto L_0x0013
            r13 = r15
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$c r13 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.c) r13
            int r0 = r13.f36110e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r13.f36110e = r0
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$c r13 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$c
            r13.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r13.f36108c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r13.f36110e
            r2 = 2
            r3 = 0
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0043
            if (r1 == r4) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.k.b(r15)
            goto L_0x00c5
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            java.lang.Object r14 = r13.f36107b
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r1 = r13.f36106a
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel) r1
            kotlin.k.b(r15)
            goto L_0x00a5
        L_0x0043:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "onDataLoaded: shouldSkipSelector="
            r15.append(r1)
            boolean r1 = r12.H()
            r15.append(r1)
            java.lang.String r1 = " showSelectorOnStart="
            r15.append(r1)
            boolean r1 = r12.U()
            r15.append(r1)
            java.lang.String r8 = r15.toString()
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
            boolean r15 = r12.H()
            if (r15 == 0) goto L_0x00c8
            if (r14 == 0) goto L_0x007e
            java.util.Map r14 = r14.v()
            goto L_0x007f
        L_0x007e:
            r14 = r5
        L_0x007f:
            if (r14 == 0) goto L_0x008f
            java.util.Set r14 = r14.keySet()
            if (r14 == 0) goto L_0x008f
            java.lang.Object r14 = kotlin.collections.CollectionsKt___CollectionsKt.b0(r14)
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L_0x0097
        L_0x008f:
            java.lang.String r14 = r12.s()
            if (r14 != 0) goto L_0x0097
            java.lang.String r14 = "ATA"
        L_0x0097:
            r13.f36106a = r12
            r13.f36107b = r14
            r13.f36110e = r4
            java.lang.Object r15 = r12.b((java.lang.String) r14, (kotlin.coroutines.c<? super java.util.List<java.lang.String>>) r13)
            if (r15 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            r1 = r12
        L_0x00a5:
            java.util.List r15 = (java.util.List) r15
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r15)
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L_0x00b5
            com.sumsub.sns.internal.core.data.model.q$e r15 = com.sumsub.sns.internal.core.data.model.q.e.f32691f
            java.lang.String r15 = r15.b()
        L_0x00b5:
            r1.a((java.lang.String) r14, (java.lang.String) r15)
            r13.f36106a = r5
            r13.f36107b = r5
            r13.f36110e = r2
            java.lang.Object r13 = r1.c((boolean) r3, (kotlin.coroutines.c<? super kotlin.Unit>) r13)
            if (r13 != r0) goto L_0x00c5
            return r0
        L_0x00c5:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        L_0x00c8:
            boolean r13 = r12.U()
            if (r13 == 0) goto L_0x00d4
            r12.g(r3)
            a(r12, r3, r4, r5)
        L_0x00d4:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.a(com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.internal.core.data.model.e, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(boolean r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.g
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$g r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.g) r0
            int r1 = r0.f36127d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36127d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$g r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$g
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f36125b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36127d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r7)
            goto L_0x005d
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f36124a
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r6 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel) r6
            kotlin.k.b(r7)
            goto L_0x004b
        L_0x003c:
            kotlin.k.b(r7)
            r0.f36124a = r5
            r0.f36127d = r4
            java.lang.Object r7 = r5.a((boolean) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness>) r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness) r7
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r2 = com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness.UNKNOWN
            if (r7 != r2) goto L_0x0060
            r7 = 0
            r0.f36124a = r7
            r0.f36127d = r3
            java.lang.Object r6 = r6.i((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        L_0x0060:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r0 = com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness.DOUBLE
            if (r7 != r0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            r6.d((boolean) r4)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.b(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "Preview photo error handling... " + oVar, (Throwable) null, 4, (Object) null);
        if (oVar instanceof o.e) {
            y();
        } else {
            super.b(oVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map<java.lang.String, com.sumsub.sns.core.data.model.SNSDocumentDefinition> r6, kotlin.coroutines.c<? super com.sumsub.sns.core.data.model.SNSDocumentDefinition> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$b r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.b) r0
            int r1 = r0.f36105e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36105e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$b r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$b
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f36103c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36105e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.f36102b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.f36101a
            com.sumsub.sns.core.data.model.SNSDocumentDefinition r0 = (com.sumsub.sns.core.data.model.SNSDocumentDefinition) r0
            kotlin.k.b(r7)
            goto L_0x006f
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.model.Document r7 = r5.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r7 = r7.getType()
            java.lang.String r7 = r7.c()
            java.lang.Object r6 = r6.get(r7)
            com.sumsub.sns.core.data.model.SNSDocumentDefinition r6 = (com.sumsub.sns.core.data.model.SNSDocumentDefinition) r6
            if (r6 != 0) goto L_0x0052
            return r4
        L_0x0052:
            java.lang.String r7 = r6.getCountry()
            if (r7 != 0) goto L_0x0059
            return r4
        L_0x0059:
            java.lang.String r2 = r6.getIdDocType()
            if (r2 != 0) goto L_0x0060
            return r4
        L_0x0060:
            r0.f36101a = r6
            r0.f36102b = r2
            r0.f36105e = r3
            java.lang.Object r7 = r5.b((java.lang.String) r7, (kotlin.coroutines.c<? super java.util.List<java.lang.String>>) r0)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r0 = r6
            r6 = r2
        L_0x006f:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0075:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0089
            java.lang.Object r1 = r7.next()
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = kotlin.jvm.internal.x.b(r2, r6)
            if (r2 == 0) goto L_0x0075
            goto L_0x008a
        L_0x0089:
            r1 = r4
        L_0x008a:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x008f
            r4 = r0
        L_0x008f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.a(java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ n1 a(SNSPreviewIdentityDocumentViewModel sNSPreviewIdentityDocumentViewModel, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return sNSPreviewIdentityDocumentViewModel.h(z11);
    }

    public String a(Map<String, String> map, String str) {
        if (!H()) {
            return super.a(map, str);
        }
        String str2 = str + "_noSelector";
        String str3 = null;
        if ((map != null ? map.get(str2) : null) != null) {
            return str2;
        }
        if ((map != null ? map.get(str) : null) != null) {
            return str;
        }
        if (map != null) {
            str3 = map.get("default_noSelector");
        }
        if (str3 != null) {
            return "default_noSelector";
        }
        return "default";
    }

    public final void a(String str, String str2) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "applyCountryAndType: c=" + str + ", t=" + str2, (Throwable) null, 4, (Object) null);
        b(str);
        c(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(boolean r18, com.sumsub.sns.internal.core.data.model.g r19, kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.f
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$f r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.f) r2
            int r3 = r2.f36123g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36123g = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$f r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$f
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36121e
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36123g
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0044
            if (r4 != r6) goto L_0x003c
            int r3 = r2.f36120d
            boolean r4 = r2.f36119c
            java.lang.Object r7 = r2.f36118b
            com.sumsub.sns.internal.core.data.model.Document r7 = (com.sumsub.sns.internal.core.data.model.Document) r7
            java.lang.Object r2 = r2.f36117a
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel) r2
            kotlin.k.b(r1)
            r14 = r4
            r10 = r7
            goto L_0x0063
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.core.data.model.Document r7 = r17.u()
            r2.f36117a = r0
            r2.f36118b = r7
            r1 = r18
            r2.f36119c = r1
            r2.f36120d = r5
            r2.f36123g = r6
            java.lang.Object r2 = r0.h((kotlin.coroutines.c<? super java.util.List<? extends com.sumsub.sns.internal.core.data.model.IdentitySide>>) r2)
            if (r2 != r3) goto L_0x005e
            return r3
        L_0x005e:
            r14 = r1
            r1 = r2
            r3 = r5
            r10 = r7
            r2 = r0
        L_0x0063:
            r11 = r1
            java.util.List r11 = (java.util.List) r11
            com.sumsub.sns.internal.core.data.model.e r1 = r2.d()
            if (r1 == 0) goto L_0x0080
            com.sumsub.sns.internal.core.data.model.Document r4 = r2.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()
            java.lang.String r4 = r4.c()
            boolean r1 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r1, (java.lang.String) r4)
            if (r1 != r6) goto L_0x0080
            r1 = r6
            goto L_0x0081
        L_0x0080:
            r1 = r5
        L_0x0081:
            if (r1 != 0) goto L_0x0094
            com.sumsub.sns.internal.core.data.model.Document r1 = r2.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
            boolean r1 = r1.h()
            if (r1 == 0) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            r12 = r5
            goto L_0x0095
        L_0x0094:
            r12 = r6
        L_0x0095:
            boolean r1 = r2.H()
            r4 = 0
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = r2.v()
            r13 = r1
            goto L_0x00a3
        L_0x00a2:
            r13 = r4
        L_0x00a3:
            com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture$PreferredMode r1 = com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture.PreferredMode.MANUAL
            com.sumsub.sns.internal.core.data.model.IdentitySide r7 = r2.J()
            com.sumsub.sns.internal.core.data.model.IdentitySide r8 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            if (r7 != r8) goto L_0x00e2
            java.util.List r2 = r2.G()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)
            com.sumsub.sns.internal.core.data.model.n r2 = (com.sumsub.sns.internal.core.data.model.n) r2
            if (r2 == 0) goto L_0x00dd
            com.sumsub.sns.internal.core.data.model.IdentitySide r7 = r2.o()
            com.sumsub.sns.internal.core.data.model.IdentitySide r8 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            if (r7 != r8) goto L_0x00c3
            r7 = r6
            goto L_0x00c4
        L_0x00c3:
            r7 = r5
        L_0x00c4:
            if (r7 == 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r2 = r4
        L_0x00c8:
            if (r2 == 0) goto L_0x00dd
            com.sumsub.sns.internal.ml.badphotos.models.b r2 = r2.l()
            if (r2 == 0) goto L_0x00dd
            java.lang.Boolean r2 = r2.r()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r6)
            boolean r2 = kotlin.jvm.internal.x.b(r2, r7)
            goto L_0x00de
        L_0x00dd:
            r2 = r5
        L_0x00de:
            if (r2 != 0) goto L_0x00e2
            r2 = r6
            goto L_0x00e3
        L_0x00e2:
            r2 = r5
        L_0x00e3:
            if (r2 == 0) goto L_0x00e7
            r15 = r1
            goto L_0x00e8
        L_0x00e7:
            r15 = r4
        L_0x00e8:
            r16 = 0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f
            if (r3 == 0) goto L_0x00f0
            r9 = r6
            goto L_0x00f1
        L_0x00f0:
            r9 = r5
        L_0x00f1:
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.a(boolean, com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    public void a(n nVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "id preview - on picker result: " + nVar + ", shouldSkipSelector=" + H(), (Throwable) null, 4, (Object) null);
        if (nVar != null || H()) {
            super.a(nVar);
            return;
        }
        List L0 = CollectionsKt___CollectionsKt.L0(G());
        L0.clear();
        a((List<n>) L0);
        a(IdentitySide.Front);
        Z();
        if (!T()) {
            a(this, false, 1, (Object) null);
        } else {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) null, (Object) null, (Long) null, 7, (Object) null);
        }
    }
}

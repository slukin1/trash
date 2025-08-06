package com.sumsub.sns.internal.presentation.screen.preview.photo;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.lifecycle.SavedStateHandle;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.analytics.GlobalStatePayload;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.domain.o;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.ml.core.e;
import com.sumsub.sns.internal.presentation.screen.preview.a;
import com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;
import okhttp3.internal.Util;

public abstract class SNSPreviewPhotoDocumentViewModel extends com.sumsub.sns.internal.presentation.screen.preview.a<g> {
    public static final a O = new a((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] P;
    public static final String Q = "seamlessVideo";
    public static final String R = "KEY_RESULTS";
    public static final String S = "KEY_COMPOSITE_RESULTS";
    public static final String T = "KEY_IDENTITY_SIDE";
    public static final int U = 1920;
    public static final int V = 360;
    public static final String W = "SNSPreviewPhotoDocumentViewModel";
    public final com.sumsub.sns.internal.core.data.source.extensions.a D;
    public final com.sumsub.sns.internal.domain.o E;
    public final com.sumsub.sns.internal.core.common.o0 F;
    public final com.sumsub.sns.internal.ml.core.e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> G;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a H;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a I;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a J;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a K;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a L;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a M;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a N;

    public static final class Content {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35868a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35869b;

        /* renamed from: c  reason: collision with root package name */
        public final a f35870c;

        /* renamed from: d  reason: collision with root package name */
        public final a f35871d;

        /* renamed from: e  reason: collision with root package name */
        public final Icon f35872e;

        /* renamed from: f  reason: collision with root package name */
        public final State f35873f;

        /* renamed from: g  reason: collision with root package name */
        public final b f35874g;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$Content$ButtonAction;", "", "(Ljava/lang/String;I)V", "CONTINUE", "TRY_AGAIN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum ButtonAction {
            CONTINUE,
            TRY_AGAIN
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$Content$Icon;", "", "(Ljava/lang/String;I)V", "WARNING", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum Icon {
            WARNING
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$Content$State;", "", "(Ljava/lang/String;I)V", "OK", "WARNING", "BLOCKING", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum State {
            OK,
            WARNING,
            BLOCKING
        }

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final ButtonAction f35875a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f35876b;

            public a(ButtonAction buttonAction, CharSequence charSequence) {
                this.f35875a = buttonAction;
                this.f35876b = charSequence;
            }

            public final ButtonAction a() {
                return this.f35875a;
            }

            public final CharSequence b() {
                return this.f35876b;
            }

            public final ButtonAction c() {
                return this.f35875a;
            }

            public final CharSequence d() {
                return this.f35876b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f35875a == aVar.f35875a && kotlin.jvm.internal.x.b(this.f35876b, aVar.f35876b);
            }

            public int hashCode() {
                int hashCode = this.f35875a.hashCode() * 31;
                CharSequence charSequence = this.f35876b;
                return hashCode + (charSequence == null ? 0 : charSequence.hashCode());
            }

            public String toString() {
                return "ButtonDescription(action=" + this.f35875a + ", text=" + this.f35876b + ')';
            }

            public final a a(ButtonAction buttonAction, CharSequence charSequence) {
                return new a(buttonAction, charSequence);
            }

            public static /* synthetic */ a a(a aVar, ButtonAction buttonAction, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    buttonAction = aVar.f35875a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = aVar.f35876b;
                }
                return aVar.a(buttonAction, charSequence);
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f35877a;

            /* renamed from: b  reason: collision with root package name */
            public final int f35878b;

            public b(CharSequence charSequence, int i11) {
                this.f35877a = charSequence;
                this.f35878b = i11;
            }

            public final CharSequence a() {
                return this.f35877a;
            }

            public final int b() {
                return this.f35878b;
            }

            public final CharSequence c() {
                return this.f35877a;
            }

            public final int d() {
                return this.f35878b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return kotlin.jvm.internal.x.b(this.f35877a, bVar.f35877a) && this.f35878b == bVar.f35878b;
            }

            public int hashCode() {
                CharSequence charSequence = this.f35877a;
                return ((charSequence == null ? 0 : charSequence.hashCode()) * 31) + this.f35878b;
            }

            public String toString() {
                return "Progress(title=" + this.f35877a + ", value=" + this.f35878b + ')';
            }

            public final b a(CharSequence charSequence, int i11) {
                return new b(charSequence, i11);
            }

            public static /* synthetic */ b a(b bVar, CharSequence charSequence, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    charSequence = bVar.f35877a;
                }
                if ((i12 & 2) != 0) {
                    i11 = bVar.f35878b;
                }
                return bVar.a(charSequence, i11);
            }
        }

        public Content(CharSequence charSequence, CharSequence charSequence2, a aVar, a aVar2, Icon icon, State state, b bVar) {
            this.f35868a = charSequence;
            this.f35869b = charSequence2;
            this.f35870c = aVar;
            this.f35871d = aVar2;
            this.f35872e = icon;
            this.f35873f = state;
            this.f35874g = bVar;
        }

        public final CharSequence a() {
            return this.f35868a;
        }

        public final CharSequence b() {
            return this.f35869b;
        }

        public final a c() {
            return this.f35870c;
        }

        public final a d() {
            return this.f35871d;
        }

        public final Icon e() {
            return this.f35872e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return kotlin.jvm.internal.x.b(this.f35868a, content.f35868a) && kotlin.jvm.internal.x.b(this.f35869b, content.f35869b) && kotlin.jvm.internal.x.b(this.f35870c, content.f35870c) && kotlin.jvm.internal.x.b(this.f35871d, content.f35871d) && this.f35872e == content.f35872e && this.f35873f == content.f35873f && kotlin.jvm.internal.x.b(this.f35874g, content.f35874g);
        }

        public final State f() {
            return this.f35873f;
        }

        public final b g() {
            return this.f35874g;
        }

        public final a h() {
            return this.f35871d;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35868a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35869b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            a aVar = this.f35870c;
            int hashCode3 = (hashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            a aVar2 = this.f35871d;
            int hashCode4 = (hashCode3 + (aVar2 == null ? 0 : aVar2.hashCode())) * 31;
            Icon icon = this.f35872e;
            int hashCode5 = (((hashCode4 + (icon == null ? 0 : icon.hashCode())) * 31) + this.f35873f.hashCode()) * 31;
            b bVar = this.f35874g;
            if (bVar != null) {
                i11 = bVar.hashCode();
            }
            return hashCode5 + i11;
        }

        public final a i() {
            return this.f35870c;
        }

        public final Icon j() {
            return this.f35872e;
        }

        public final b k() {
            return this.f35874g;
        }

        public final State l() {
            return this.f35873f;
        }

        public final CharSequence m() {
            return this.f35869b;
        }

        public final CharSequence n() {
            return this.f35868a;
        }

        public String toString() {
            return "Content(title=" + this.f35868a + ", subtitle=" + this.f35869b + ", buttonPositive=" + this.f35870c + ", buttonNegative=" + this.f35871d + ", icon=" + this.f35872e + ", state=" + this.f35873f + ", progress=" + this.f35874g + ')';
        }

        public final Content a(CharSequence charSequence, CharSequence charSequence2, a aVar, a aVar2, Icon icon, State state, b bVar) {
            return new Content(charSequence, charSequence2, aVar, aVar2, icon, state, bVar);
        }

        public static /* synthetic */ Content a(Content content, CharSequence charSequence, CharSequence charSequence2, a aVar, a aVar2, Icon icon, State state, b bVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = content.f35868a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = content.f35869b;
            }
            CharSequence charSequence3 = charSequence2;
            if ((i11 & 4) != 0) {
                aVar = content.f35870c;
            }
            a aVar3 = aVar;
            if ((i11 & 8) != 0) {
                aVar2 = content.f35871d;
            }
            a aVar4 = aVar2;
            if ((i11 & 16) != 0) {
                icon = content.f35872e;
            }
            Icon icon2 = icon;
            if ((i11 & 32) != 0) {
                state = content.f35873f;
            }
            State state2 = state;
            if ((i11 & 64) != 0) {
                bVar = content.f35874g;
            }
            return content.a(charSequence, charSequence3, aVar3, aVar4, icon2, state2, bVar);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Content(CharSequence charSequence, CharSequence charSequence2, a aVar, a aVar2, Icon icon, State state, b bVar, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : aVar, (i11 & 8) != 0 ? null : aVar2, (i11 & 16) != 0 ? null : icon, state, (i11 & 64) != 0 ? null : bVar);
        }
    }

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedError$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35879a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35880b;

        public a0(kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((a0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a0 a0Var = new a0(cVar);
            a0Var.f35880b = obj;
            return a0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35879a == 0) {
                kotlin.k.b(obj);
                g gVar = (g) this.f35880b;
                Content f11 = gVar.f();
                return g.a(gVar, (List) null, (k) null, false, true, f11 != null ? Content.a(f11, (CharSequence) null, (CharSequence) null, (Content.a) null, (Content.a) null, (Content.Icon) null, (Content.State) null, (Content.b) null, 63, (Object) null) : null, 7, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final int f35881a;

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel.readInt());
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(int i11) {
            this.f35881a = i11;
        }

        public final int a() {
            return this.f35881a;
        }

        public final int b() {
            return this.f35881a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f35881a == ((b) obj).f35881a;
        }

        public int hashCode() {
            return this.f35881a;
        }

        public String toString() {
            return "DocumentProperties(rotation=" + this.f35881a + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f35881a);
        }

        public final b a(int i11) {
            return new b(i11);
        }

        public static /* synthetic */ b a(b bVar, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = bVar.f35881a;
            }
            return bVar.a(i11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {701, 798}, m = "onDocumentsUploadedSuccess")
    public static final class b0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35882a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35883b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35884c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35885d;

        /* renamed from: e  reason: collision with root package name */
        public int f35886e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super b0> cVar) {
            super(cVar);
            this.f35885d = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35884c = obj;
            this.f35886e |= Integer.MIN_VALUE;
            return this.f35885d.a((List<com.sumsub.sns.internal.core.data.model.remote.k>) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class c implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.s f35887a;

        public c(com.sumsub.sns.internal.core.data.model.s sVar) {
            this.f35887a = sVar;
        }

        public final com.sumsub.sns.internal.core.data.model.s a() {
            return this.f35887a;
        }

        public final com.sumsub.sns.internal.core.data.model.s b() {
            return this.f35887a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && kotlin.jvm.internal.x.b(this.f35887a, ((c) obj).f35887a);
        }

        public int hashCode() {
            return this.f35887a.hashCode();
        }

        public String toString() {
            return "MRTDDocumentAction(document=" + this.f35887a + ')';
        }

        public final c a(com.sumsub.sns.internal.core.data.model.s sVar) {
            return new c(sVar);
        }

        public static /* synthetic */ c a(c cVar, com.sumsub.sns.internal.core.data.model.s sVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sVar = cVar.f35887a;
            }
            return cVar.a(sVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedSuccess$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {727, 747, 752, 753, 762, 764, 769}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35888a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35889b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35890c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35891d;

        /* renamed from: e  reason: collision with root package name */
        public Object f35892e;

        /* renamed from: f  reason: collision with root package name */
        public Object f35893f;

        /* renamed from: g  reason: collision with root package name */
        public Object f35894g;

        /* renamed from: h  reason: collision with root package name */
        public Object f35895h;

        /* renamed from: i  reason: collision with root package name */
        public int f35896i;

        /* renamed from: j  reason: collision with root package name */
        public int f35897j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f35898k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ List<com.sumsub.sns.internal.core.data.model.remote.k> f35899l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35900m;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedSuccess$2$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35901a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f35902b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Spanned f35903c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ k f35904d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Spanned spanned, k kVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35903c = spanned;
                this.f35904d = kVar;
            }

            /* renamed from: a */
            public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
                return ((a) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f35903c, this.f35904d, cVar);
                aVar.f35902b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f35901a == 0) {
                    kotlin.k.b(obj);
                    g gVar = (g) this.f35902b;
                    Content f11 = gVar.f();
                    return g.a(gVar, (List) null, this.f35904d, false, false, f11 != null ? Content.a(f11, this.f35903c, (CharSequence) null, (Content.a) null, (Content.a) null, (Content.Icon) null, (Content.State) null, (Content.b) null, 126, (Object) null) : null, 9, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public static final class b extends Lambda implements d10.l<Spanned, CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public static final b f35905a = new b();

            public b() {
                super(1);
            }

            /* renamed from: a */
            public final CharSequence invoke(Spanned spanned) {
                return spanned;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(List<com.sumsub.sns.internal.core.data.model.remote.k> list, SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super c0> cVar) {
            super(2, cVar);
            this.f35899l = list;
            this.f35900m = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c0 c0Var = new c0(this.f35899l, this.f35900m, cVar);
            c0Var.f35898k = obj;
            return c0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0325, code lost:
            r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7;
            r10 = r15.f35900m;
            r15.f35898k = r9;
            r15.f35888a = r4;
            r15.f35889b = r8;
            r15.f35890c = r3;
            r15.f35891d = r7;
            r15.f35896i = r2;
            r15.f35897j = 4;
            r10 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r10, "sns_preview_photo_title", (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x033e, code lost:
            if (r10 != r1) goto L_0x0341;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0340, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0341, code lost:
            r26 = r7;
            r7 = r3;
            r3 = r26;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0346, code lost:
            r3 = r8.a(r7.a(r3, (java.lang.CharSequence) r10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0350, code lost:
            if (r2 == 0) goto L_0x0375;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0352, code lost:
            r7 = r15.f35900m;
            r15.f35898k = r9;
            r15.f35888a = r4;
            r15.f35889b = r3;
            r15.f35890c = null;
            r15.f35891d = null;
            r15.f35896i = r2;
            r15.f35897j = 5;
            r7 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r7, "sns_preview_idDocError_action_retake", (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0369, code lost:
            if (r7 != r1) goto L_0x036c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x036b, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x036c, code lost:
            r8 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x036d, code lost:
            r7 = (java.lang.String) r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x036f, code lost:
            r26 = r2;
            r2 = r1;
            r1 = r26;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0375, code lost:
            r7 = r15.f35900m;
            r15.f35898k = r9;
            r15.f35888a = r4;
            r15.f35889b = r3;
            r15.f35890c = null;
            r15.f35891d = null;
            r15.f35896i = r2;
            r15.f35897j = 6;
            r7 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r7, "sns_preview_idDocWarning_action_continue", (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x038c, code lost:
            if (r7 != r1) goto L_0x038f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x038e, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x038f, code lost:
            r8 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0390, code lost:
            r7 = (java.lang.String) r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0393, code lost:
            if (r1 == 0) goto L_0x039b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0395, code lost:
            r9 = r4;
            r11 = null;
            r10 = r7;
            r2 = r8;
            r4 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x039b, code lost:
            r9 = r15.f35900m;
            r15.f35898k = r8;
            r15.f35888a = r4;
            r15.f35889b = r3;
            r15.f35890c = r7;
            r15.f35896i = r1;
            r15.f35897j = 7;
            r9 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r9, "sns_preview_idDocWarning_action_retake", (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x03b0, code lost:
            if (r9 != r2) goto L_0x03b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b2, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b3, code lost:
            r2 = r7;
            r7 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x03b5, code lost:
            r10 = r2;
            r2 = r8;
            r11 = (java.lang.String) r9;
            r4 = r15;
            r9 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x03bf, code lost:
            if (r1 == 0) goto L_0x03c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x03c1, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x03c3, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c4, code lost:
            r5 = r7;
            r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k((java.lang.CharSequence) null, r9, r10, r11, r12, false, 32, (kotlin.jvm.internal.r) null);
            com.sumsub.sns.core.presentation.base.a.a(r4.f35900m, false, new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c0.a(r3, r5, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c0.a>) null), 1, (java.lang.Object) null);
            r1 = "Got warnings: " + r4.f35899l + " for " + com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f(r4.f35900m).getType().c();
            com.sumsub.sns.internal.log.a.f34862a.a(com.sumsub.sns.internal.log.LoggerType.KIBANA).w(com.sumsub.sns.internal.log.c.a(r2), r1, new java.lang.IllegalArgumentException(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x041f, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x011c, code lost:
            r8 = (java.util.List) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0120, code lost:
            if (r2 == 0) goto L_0x01c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0122, code lost:
            r10 = r0.f35899l;
            r11 = new java.util.ArrayList();
            r10 = r10.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0131, code lost:
            if (r10.hasNext() == false) goto L_0x0147;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0133, code lost:
            r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r10.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0139, code lost:
            if (r12 == null) goto L_0x0140;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x013b, code lost:
            r12 = r12.j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0140, code lost:
            r12 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0141, code lost:
            if (r12 == null) goto L_0x012d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0143, code lost:
            r11.add(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0147, code lost:
            r10 = r0.f35900m;
            r12 = new java.util.ArrayList();
            r11 = r11.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0156, code lost:
            if (r11.hasNext() == false) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0158, code lost:
            r13 = (java.util.List) r11.next();
            r14 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r13, 10));
            r13 = r13.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x016f, code lost:
            if (r13.hasNext() == false) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0171, code lost:
            r14.add(r10.d((java.lang.String) r13.next()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x017f, code lost:
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r12, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0183, code lost:
            r10 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r12);
            r11 = r0.f35900m;
            r12 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r10, 10));
            r10 = r10.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x019a, code lost:
            if (r10.hasNext() == false) goto L_0x01bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x019c, code lost:
            r13 = (java.lang.String) r10.next();
            r14 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a6, code lost:
            if (r14 == null) goto L_0x01b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a8, code lost:
            r14 = com.sumsub.sns.internal.core.data.model.f.j(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ac, code lost:
            if (r14 == null) goto L_0x01b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ae, code lost:
            r14 = r14.get(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b4, code lost:
            if (r14 != null) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b7, code lost:
            r13 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b8, code lost:
            r12.add(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01bc, code lost:
            r10 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r12, 1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c2, code lost:
            r10 = r0.f35899l;
            r11 = new java.util.ArrayList();
            r10 = r10.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d1, code lost:
            if (r10.hasNext() == false) goto L_0x01e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d3, code lost:
            r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r10.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d9, code lost:
            if (r12 == null) goto L_0x01e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01db, code lost:
            r12 = r12.u();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e0, code lost:
            r12 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e1, code lost:
            if (r12 == null) goto L_0x01cd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e3, code lost:
            r11.add(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e7, code lost:
            r10 = r0.f35900m;
            r12 = new java.util.ArrayList();
            r11 = r11.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f6, code lost:
            if (r11.hasNext() == false) goto L_0x0223;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f8, code lost:
            r13 = (java.util.List) r11.next();
            r14 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r13, 10));
            r13 = r13.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x020f, code lost:
            if (r13.hasNext() == false) goto L_0x021f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0211, code lost:
            r14.add(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r10, (java.lang.String) r13.next()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x021f, code lost:
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r12, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0223, code lost:
            r10 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r12);
            r11 = r0.f35900m;
            r12 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r10, 10));
            r10 = r10.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x023a, code lost:
            if (r10.hasNext() == false) goto L_0x025c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x023c, code lost:
            r13 = (java.lang.String) r10.next();
            r14 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0246, code lost:
            if (r14 == null) goto L_0x0258;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0248, code lost:
            r14 = com.sumsub.sns.internal.core.data.model.f.p(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x024c, code lost:
            if (r14 == null) goto L_0x0258;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x024e, code lost:
            r14 = r14.get(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0254, code lost:
            if (r14 != null) goto L_0x0257;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0257, code lost:
            r13 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0258, code lost:
            r12.add(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x025c, code lost:
            r10 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r12, 1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0260, code lost:
            r10 = ((java.lang.String) kotlin.collections.CollectionsKt___CollectionsKt.m0(r10)).toString();
            r11 = r0.f35900m;
            r9 = "{docTypes}";
            r15 = r0;
            r14 = r7;
            r7 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r8, 10));
            r12 = r8.iterator();
            r8 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0284, code lost:
            if (r12.hasNext() == false) goto L_0x02cd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0286, code lost:
            r13 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.h(r11);
            r4 = com.sumsub.sns.internal.core.data.model.q.f32683c.a((java.lang.String) r12.next());
            r15.f35898k = r14;
            r15.f35888a = r11;
            r15.f35889b = r7;
            r15.f35890c = r12;
            r15.f35891d = r4;
            r15.f35892e = r13;
            r15.f35893f = r8;
            r15.f35894g = r9;
            r15.f35895h = r7;
            r15.f35896i = r2;
            r15.f35897j = 2;
            r10 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(r11, (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b0, code lost:
            if (r10 != r1) goto L_0x02b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b2, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b3, code lost:
            r16 = r15;
            r15 = r14;
            r14 = r11;
            r11 = r4;
            r4 = r13;
            r13 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x02ba, code lost:
            r7.add(r4.a(com.sumsub.sns.internal.core.data.model.q.a(r11, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r10, (java.lang.CharSequence) null, 2, (java.lang.Object) null)));
            r7 = r13;
            r11 = r14;
            r14 = r15;
            r15 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x02cd, code lost:
            r8 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, kotlin.collections.CollectionsKt___CollectionsKt.k0((java.util.List) r7, "\n", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c0.b.f35905a, 30, (java.lang.Object) null), false, 4, (java.lang.Object) null);
            r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.h(r15.f35900m);
            r4 = com.sumsub.sns.internal.core.data.model.q.f32683c.a(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.i(r15.f35900m));
            r7 = r15.f35900m;
            r15.f35898k = r14;
            r15.f35888a = r8;
            r15.f35889b = r3;
            r15.f35890c = r4;
            r15.f35891d = null;
            r15.f35892e = null;
            r15.f35893f = null;
            r15.f35894g = null;
            r15.f35895h = null;
            r15.f35896i = r2;
            r15.f35897j = 3;
            r7 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(r7, (kotlin.coroutines.c) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x031b, code lost:
            if (r7 != r1) goto L_0x031e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x031d, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x031e, code lost:
            r9 = r14;
            r26 = r8;
            r8 = r3;
            r3 = r4;
            r4 = r26;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                r27 = this;
                r0 = r27
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f35897j
                r3 = 2
                r5 = 1
                r6 = 0
                switch(r2) {
                    case 0: goto L_0x00db;
                    case 1: goto L_0x00cf;
                    case 2: goto L_0x009a;
                    case 3: goto L_0x007e;
                    case 4: goto L_0x005e;
                    case 5: goto L_0x0047;
                    case 6: goto L_0x0030;
                    case 7: goto L_0x0016;
                    default: goto L_0x000e;
                }
            L_0x000e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0016:
                int r1 = r0.f35896i
                java.lang.Object r2 = r0.f35890c
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r0.f35889b
                android.text.Spanned r3 = (android.text.Spanned) r3
                java.lang.Object r7 = r0.f35888a
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f35898k
                kotlinx.coroutines.h0 r8 = (kotlinx.coroutines.h0) r8
                kotlin.k.b(r28)
                r9 = r28
                r15 = r0
                goto L_0x03b5
            L_0x0030:
                int r2 = r0.f35896i
                java.lang.Object r3 = r0.f35889b
                android.text.Spanned r3 = (android.text.Spanned) r3
                java.lang.Object r7 = r0.f35888a
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f35898k
                kotlinx.coroutines.h0 r8 = (kotlinx.coroutines.h0) r8
                kotlin.k.b(r28)
                r15 = r0
                r4 = r7
                r7 = r28
                goto L_0x0390
            L_0x0047:
                int r2 = r0.f35896i
                java.lang.Object r3 = r0.f35889b
                android.text.Spanned r3 = (android.text.Spanned) r3
                java.lang.Object r7 = r0.f35888a
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f35898k
                kotlinx.coroutines.h0 r8 = (kotlinx.coroutines.h0) r8
                kotlin.k.b(r28)
                r15 = r0
                r4 = r7
                r7 = r28
                goto L_0x036d
            L_0x005e:
                int r2 = r0.f35896i
                java.lang.Object r3 = r0.f35891d
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r3 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r3
                java.lang.Object r7 = r0.f35890c
                com.sumsub.sns.internal.core.data.model.q r7 = (com.sumsub.sns.internal.core.data.model.q) r7
                java.lang.Object r8 = r0.f35889b
                com.sumsub.sns.internal.core.data.source.extensions.a r8 = (com.sumsub.sns.internal.core.data.source.extensions.a) r8
                java.lang.Object r9 = r0.f35888a
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r10 = r0.f35898k
                kotlinx.coroutines.h0 r10 = (kotlinx.coroutines.h0) r10
                kotlin.k.b(r28)
                r15 = r0
                r4 = r9
                r9 = r10
                r10 = r28
                goto L_0x0346
            L_0x007e:
                int r2 = r0.f35896i
                java.lang.Object r3 = r0.f35890c
                com.sumsub.sns.internal.core.data.model.q r3 = (com.sumsub.sns.internal.core.data.model.q) r3
                java.lang.Object r7 = r0.f35889b
                com.sumsub.sns.internal.core.data.source.extensions.a r7 = (com.sumsub.sns.internal.core.data.source.extensions.a) r7
                java.lang.Object r8 = r0.f35888a
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r0.f35898k
                kotlinx.coroutines.h0 r9 = (kotlinx.coroutines.h0) r9
                kotlin.k.b(r28)
                r15 = r0
                r4 = r8
                r8 = r7
                r7 = r28
                goto L_0x0325
            L_0x009a:
                int r2 = r0.f35896i
                java.lang.Object r7 = r0.f35895h
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r0.f35894g
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r0.f35893f
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r10 = r0.f35892e
                com.sumsub.sns.internal.core.data.source.extensions.a r10 = (com.sumsub.sns.internal.core.data.source.extensions.a) r10
                java.lang.Object r11 = r0.f35891d
                com.sumsub.sns.internal.core.data.model.q r11 = (com.sumsub.sns.internal.core.data.model.q) r11
                java.lang.Object r12 = r0.f35890c
                java.util.Iterator r12 = (java.util.Iterator) r12
                java.lang.Object r13 = r0.f35889b
                java.util.Collection r13 = (java.util.Collection) r13
                java.lang.Object r14 = r0.f35888a
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r14 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r14
                java.lang.Object r15 = r0.f35898k
                kotlinx.coroutines.h0 r15 = (kotlinx.coroutines.h0) r15
                kotlin.k.b(r28)
                r16 = r0
                r4 = r10
                r10 = r28
                r26 = r9
                r9 = r8
                r8 = r26
                goto L_0x02ba
            L_0x00cf:
                int r2 = r0.f35896i
                java.lang.Object r7 = r0.f35898k
                kotlinx.coroutines.h0 r7 = (kotlinx.coroutines.h0) r7
                kotlin.k.b(r28)
                r8 = r28
                goto L_0x011c
            L_0x00db:
                kotlin.k.b(r28)
                java.lang.Object r2 = r0.f35898k
                r7 = r2
                kotlinx.coroutines.h0 r7 = (kotlinx.coroutines.h0) r7
                java.util.List<com.sumsub.sns.internal.core.data.model.remote.k> r2 = r0.f35899l
                boolean r8 = r2 instanceof java.util.Collection
                if (r8 == 0) goto L_0x00f0
                boolean r8 = r2.isEmpty()
                if (r8 == 0) goto L_0x00f0
                goto L_0x010c
            L_0x00f0:
                java.util.Iterator r2 = r2.iterator()
            L_0x00f4:
                boolean r8 = r2.hasNext()
                if (r8 == 0) goto L_0x010c
                java.lang.Object r8 = r2.next()
                com.sumsub.sns.internal.core.data.model.remote.k r8 = (com.sumsub.sns.internal.core.data.model.remote.k) r8
                if (r8 == 0) goto L_0x0107
                boolean r8 = r8.w()
                goto L_0x0108
            L_0x0107:
                r8 = 0
            L_0x0108:
                if (r8 == 0) goto L_0x00f4
                r2 = r5
                goto L_0x010d
            L_0x010c:
                r2 = 0
            L_0x010d:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r8 = r0.f35900m
                r0.f35898k = r7
                r0.f35896i = r2
                r0.f35897j = r5
                java.lang.Object r8 = r8.g((kotlin.coroutines.c<? super java.util.List<java.lang.String>>) r0)
                if (r8 != r1) goto L_0x011c
                return r1
            L_0x011c:
                java.util.List r8 = (java.util.List) r8
                r9 = 10
                if (r2 == 0) goto L_0x01c2
                java.util.List<com.sumsub.sns.internal.core.data.model.remote.k> r10 = r0.f35899l
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                java.util.Iterator r10 = r10.iterator()
            L_0x012d:
                boolean r12 = r10.hasNext()
                if (r12 == 0) goto L_0x0147
                java.lang.Object r12 = r10.next()
                com.sumsub.sns.internal.core.data.model.remote.k r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r12
                if (r12 == 0) goto L_0x0140
                java.util.List r12 = r12.j()
                goto L_0x0141
            L_0x0140:
                r12 = r6
            L_0x0141:
                if (r12 == 0) goto L_0x012d
                r11.add(r12)
                goto L_0x012d
            L_0x0147:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = r0.f35900m
                java.util.ArrayList r12 = new java.util.ArrayList
                r12.<init>()
                java.util.Iterator r11 = r11.iterator()
            L_0x0152:
                boolean r13 = r11.hasNext()
                if (r13 == 0) goto L_0x0183
                java.lang.Object r13 = r11.next()
                java.util.List r13 = (java.util.List) r13
                java.util.ArrayList r14 = new java.util.ArrayList
                int r15 = kotlin.collections.CollectionsKt__IterablesKt.u(r13, r9)
                r14.<init>(r15)
                java.util.Iterator r13 = r13.iterator()
            L_0x016b:
                boolean r15 = r13.hasNext()
                if (r15 == 0) goto L_0x017f
                java.lang.Object r15 = r13.next()
                java.lang.String r15 = (java.lang.String) r15
                java.lang.String r15 = r10.d((java.lang.String) r15)
                r14.add(r15)
                goto L_0x016b
            L_0x017f:
                boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r12, r14)
                goto L_0x0152
            L_0x0183:
                java.util.Set r10 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r12)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r11 = r0.f35900m
                java.util.ArrayList r12 = new java.util.ArrayList
                int r13 = kotlin.collections.CollectionsKt__IterablesKt.u(r10, r9)
                r12.<init>(r13)
                java.util.Iterator r10 = r10.iterator()
            L_0x0196:
                boolean r13 = r10.hasNext()
                if (r13 == 0) goto L_0x01bc
                java.lang.Object r13 = r10.next()
                java.lang.String r13 = (java.lang.String) r13
                com.sumsub.sns.internal.core.data.model.e r14 = r11.d()
                if (r14 == 0) goto L_0x01b8
                java.util.Map r14 = com.sumsub.sns.internal.core.data.model.f.j(r14)
                if (r14 == 0) goto L_0x01b8
                java.lang.Object r14 = r14.get(r13)
                java.lang.String r14 = (java.lang.String) r14
                if (r14 != 0) goto L_0x01b7
                goto L_0x01b8
            L_0x01b7:
                r13 = r14
            L_0x01b8:
                r12.add(r13)
                goto L_0x0196
            L_0x01bc:
                java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r12, r5)
                goto L_0x0260
            L_0x01c2:
                java.util.List<com.sumsub.sns.internal.core.data.model.remote.k> r10 = r0.f35899l
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                java.util.Iterator r10 = r10.iterator()
            L_0x01cd:
                boolean r12 = r10.hasNext()
                if (r12 == 0) goto L_0x01e7
                java.lang.Object r12 = r10.next()
                com.sumsub.sns.internal.core.data.model.remote.k r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r12
                if (r12 == 0) goto L_0x01e0
                java.util.List r12 = r12.u()
                goto L_0x01e1
            L_0x01e0:
                r12 = r6
            L_0x01e1:
                if (r12 == 0) goto L_0x01cd
                r11.add(r12)
                goto L_0x01cd
            L_0x01e7:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = r0.f35900m
                java.util.ArrayList r12 = new java.util.ArrayList
                r12.<init>()
                java.util.Iterator r11 = r11.iterator()
            L_0x01f2:
                boolean r13 = r11.hasNext()
                if (r13 == 0) goto L_0x0223
                java.lang.Object r13 = r11.next()
                java.util.List r13 = (java.util.List) r13
                java.util.ArrayList r14 = new java.util.ArrayList
                int r15 = kotlin.collections.CollectionsKt__IterablesKt.u(r13, r9)
                r14.<init>(r15)
                java.util.Iterator r13 = r13.iterator()
            L_0x020b:
                boolean r15 = r13.hasNext()
                if (r15 == 0) goto L_0x021f
                java.lang.Object r15 = r13.next()
                java.lang.String r15 = (java.lang.String) r15
                java.lang.String r15 = r10.e((java.lang.String) r15)
                r14.add(r15)
                goto L_0x020b
            L_0x021f:
                boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r12, r14)
                goto L_0x01f2
            L_0x0223:
                java.util.Set r10 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r12)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r11 = r0.f35900m
                java.util.ArrayList r12 = new java.util.ArrayList
                int r13 = kotlin.collections.CollectionsKt__IterablesKt.u(r10, r9)
                r12.<init>(r13)
                java.util.Iterator r10 = r10.iterator()
            L_0x0236:
                boolean r13 = r10.hasNext()
                if (r13 == 0) goto L_0x025c
                java.lang.Object r13 = r10.next()
                java.lang.String r13 = (java.lang.String) r13
                com.sumsub.sns.internal.core.data.model.e r14 = r11.d()
                if (r14 == 0) goto L_0x0258
                java.util.Map r14 = com.sumsub.sns.internal.core.data.model.f.p(r14)
                if (r14 == 0) goto L_0x0258
                java.lang.Object r14 = r14.get(r13)
                java.lang.String r14 = (java.lang.String) r14
                if (r14 != 0) goto L_0x0257
                goto L_0x0258
            L_0x0257:
                r13 = r14
            L_0x0258:
                r12.add(r13)
                goto L_0x0236
            L_0x025c:
                java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r12, r5)
            L_0x0260:
                java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r10)
                java.lang.String r10 = (java.lang.String) r10
                java.lang.String r10 = r10.toString()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r11 = r0.f35900m
                java.util.ArrayList r12 = new java.util.ArrayList
                int r9 = kotlin.collections.CollectionsKt__IterablesKt.u(r8, r9)
                r12.<init>(r9)
                java.util.Iterator r8 = r8.iterator()
                java.lang.String r9 = "{docTypes}"
                r15 = r0
                r14 = r7
                r7 = r12
                r12 = r8
                r8 = r10
            L_0x0280:
                boolean r10 = r12.hasNext()
                if (r10 == 0) goto L_0x02cd
                java.lang.Object r10 = r12.next()
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.core.data.source.extensions.a r13 = r11.D
                com.sumsub.sns.internal.core.data.model.q$a r4 = com.sumsub.sns.internal.core.data.model.q.f32683c
                com.sumsub.sns.internal.core.data.model.q r4 = r4.a(r10)
                r15.f35898k = r14
                r15.f35888a = r11
                r15.f35889b = r7
                r15.f35890c = r12
                r15.f35891d = r4
                r15.f35892e = r13
                r15.f35893f = r8
                r15.f35894g = r9
                r15.f35895h = r7
                r15.f35896i = r2
                r15.f35897j = r3
                java.lang.Object r10 = r11.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r15)
                if (r10 != r1) goto L_0x02b3
                return r1
            L_0x02b3:
                r16 = r15
                r15 = r14
                r14 = r11
                r11 = r4
                r4 = r13
                r13 = r7
            L_0x02ba:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r10 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r10
                java.lang.CharSequence r10 = com.sumsub.sns.internal.core.data.model.q.a(r11, r10, r6, r3, r6)
                android.text.Spanned r4 = r4.a(r10)
                r7.add(r4)
                r7 = r13
                r11 = r14
                r14 = r15
                r15 = r16
                goto L_0x0280
            L_0x02cd:
                r17 = r7
                java.util.List r17 = (java.util.List) r17
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$c0$b r23 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c0.b.f35905a
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r24 = 30
                r25 = 0
                java.lang.String r18 = "\n"
                java.lang.String r10 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r17, r18, r19, r20, r21, r22, r23, r24, r25)
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r8 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, r10, r11, r12, r13)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = r15.f35900m
                com.sumsub.sns.internal.core.data.source.extensions.a r3 = r3.D
                com.sumsub.sns.internal.core.data.model.q$a r4 = com.sumsub.sns.internal.core.data.model.q.f32683c
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r15.f35900m
                java.lang.String r7 = r7.v()
                com.sumsub.sns.internal.core.data.model.q r4 = r4.a(r7)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r15.f35900m
                r15.f35898k = r14
                r15.f35888a = r8
                r15.f35889b = r3
                r15.f35890c = r4
                r15.f35891d = r6
                r15.f35892e = r6
                r15.f35893f = r6
                r15.f35894g = r6
                r15.f35895h = r6
                r15.f35896i = r2
                r9 = 3
                r15.f35897j = r9
                java.lang.Object r7 = r7.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r15)
                if (r7 != r1) goto L_0x031e
                return r1
            L_0x031e:
                r9 = r14
                r26 = r8
                r8 = r3
                r3 = r4
                r4 = r26
            L_0x0325:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = r15.f35900m
                r15.f35898k = r9
                r15.f35888a = r4
                r15.f35889b = r8
                r15.f35890c = r3
                r15.f35891d = r7
                r15.f35896i = r2
                r11 = 4
                r15.f35897j = r11
                java.lang.String r11 = "sns_preview_photo_title"
                java.lang.Object r10 = r10.a((java.lang.String) r11, (kotlin.coroutines.c<? super java.lang.String>) r15)
                if (r10 != r1) goto L_0x0341
                return r1
            L_0x0341:
                r26 = r7
                r7 = r3
                r3 = r26
            L_0x0346:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                java.lang.CharSequence r3 = r7.a(r3, r10)
                android.text.Spanned r3 = r8.a(r3)
                if (r2 == 0) goto L_0x0375
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r15.f35900m
                r15.f35898k = r9
                r15.f35888a = r4
                r15.f35889b = r3
                r15.f35890c = r6
                r15.f35891d = r6
                r15.f35896i = r2
                r8 = 5
                r15.f35897j = r8
                java.lang.String r8 = "sns_preview_idDocError_action_retake"
                java.lang.Object r7 = r7.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r15)
                if (r7 != r1) goto L_0x036c
                return r1
            L_0x036c:
                r8 = r9
            L_0x036d:
                java.lang.String r7 = (java.lang.String) r7
            L_0x036f:
                r26 = r2
                r2 = r1
                r1 = r26
                goto L_0x0393
            L_0x0375:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r15.f35900m
                r15.f35898k = r9
                r15.f35888a = r4
                r15.f35889b = r3
                r15.f35890c = r6
                r15.f35891d = r6
                r15.f35896i = r2
                r8 = 6
                r15.f35897j = r8
                java.lang.String r8 = "sns_preview_idDocWarning_action_continue"
                java.lang.Object r7 = r7.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r15)
                if (r7 != r1) goto L_0x038f
                return r1
            L_0x038f:
                r8 = r9
            L_0x0390:
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x036f
            L_0x0393:
                if (r1 == 0) goto L_0x039b
                r9 = r4
                r11 = r6
                r10 = r7
                r2 = r8
                r4 = r15
                goto L_0x03bc
            L_0x039b:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r9 = r15.f35900m
                r15.f35898k = r8
                r15.f35888a = r4
                r15.f35889b = r3
                r15.f35890c = r7
                r15.f35896i = r1
                r10 = 7
                r15.f35897j = r10
                java.lang.String r10 = "sns_preview_idDocWarning_action_retake"
                java.lang.Object r9 = r9.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r15)
                if (r9 != r2) goto L_0x03b3
                return r2
            L_0x03b3:
                r2 = r7
                r7 = r4
            L_0x03b5:
                java.lang.String r9 = (java.lang.String) r9
                r10 = r2
                r2 = r8
                r11 = r9
                r4 = r15
                r9 = r7
            L_0x03bc:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k r15 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k
                r8 = 0
                if (r1 == 0) goto L_0x03c3
                r12 = r5
                goto L_0x03c4
            L_0x03c3:
                r12 = 0
            L_0x03c4:
                r13 = 0
                r14 = 32
                r1 = 0
                r7 = r15
                r5 = r15
                r15 = r1
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r1 = r4.f35900m
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$c0$a r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$c0$a
                r7.<init>(r3, r5, r6)
                r3 = 0
                r5 = 1
                com.sumsub.sns.core.presentation.base.a.a(r1, r3, r7, r5, r6)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Got warnings: "
                r1.append(r3)
                java.util.List<com.sumsub.sns.internal.core.data.model.remote.k> r3 = r4.f35899l
                r1.append(r3)
                java.lang.String r3 = " for "
                r1.append(r3)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = r4.f35900m
                com.sumsub.sns.internal.core.data.model.Document r3 = r3.u()
                com.sumsub.sns.internal.core.data.model.DocumentType r3 = r3.getType()
                java.lang.String r3 = r3.c()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a
                r4 = 1
                com.sumsub.sns.internal.log.LoggerType[] r4 = new com.sumsub.sns.internal.log.LoggerType[r4]
                com.sumsub.sns.internal.log.LoggerType r5 = com.sumsub.sns.internal.log.LoggerType.KIBANA
                r6 = 0
                r4[r6] = r5
                com.sumsub.log.logger.Logger r3 = r3.a((com.sumsub.sns.internal.log.LoggerType[]) r4)
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r2)
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                r4.<init>(r1)
                r3.w(r2, r1, r4)
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f35906a;

        /* renamed from: b  reason: collision with root package name */
        public final File f35907b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35908c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f35909d;

        public d(Bitmap bitmap, File file, int i11, boolean z11) {
            this.f35906a = bitmap;
            this.f35907b = file;
            this.f35908c = i11;
            this.f35909d = z11;
        }

        public final Bitmap a() {
            return this.f35906a;
        }

        public final File b() {
            return this.f35907b;
        }

        public final int c() {
            return this.f35908c;
        }

        public final boolean d() {
            return this.f35909d;
        }

        public final File e() {
            return this.f35907b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.jvm.internal.x.b(this.f35906a, dVar.f35906a) && kotlin.jvm.internal.x.b(this.f35907b, dVar.f35907b) && this.f35908c == dVar.f35908c && this.f35909d == dVar.f35909d;
        }

        public final Bitmap f() {
            return this.f35906a;
        }

        public final int g() {
            return this.f35908c;
        }

        public final boolean h() {
            return this.f35909d;
        }

        public int hashCode() {
            Bitmap bitmap = this.f35906a;
            int i11 = 0;
            int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
            File file = this.f35907b;
            if (file != null) {
                i11 = file.hashCode();
            }
            int i12 = (((hashCode + i11) * 31) + this.f35908c) * 31;
            boolean z11 = this.f35909d;
            if (z11) {
                z11 = true;
            }
            return i12 + (z11 ? 1 : 0);
        }

        public String toString() {
            return "PhotoDocument(photo=" + this.f35906a + ", file=" + this.f35907b + ", rotation=" + this.f35908c + ", rotationAvailable=" + this.f35909d + ')';
        }

        public final d a(Bitmap bitmap, File file, int i11, boolean z11) {
            return new d(bitmap, file, i11, z11);
        }

        public static /* synthetic */ d a(d dVar, Bitmap bitmap, File file, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                bitmap = dVar.f35906a;
            }
            if ((i12 & 2) != 0) {
                file = dVar.f35907b;
            }
            if ((i12 & 4) != 0) {
                i11 = dVar.f35908c;
            }
            if ((i12 & 8) != 0) {
                z11 = dVar.f35909d;
            }
            return dVar.a(bitmap, file, i11, z11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedSuccess$6", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35911b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedSuccess$6$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35912a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f35913b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
                return ((a) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f35913b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f35912a == 0) {
                    kotlin.k.b(obj);
                    return g.a((g) this.f35913b, (List) null, (k) null, true, false, (Content) null, 25, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super d0> cVar) {
            super(2, cVar);
            this.f35911b = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d0(this.f35911b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35910a == 0) {
                kotlin.k.b(obj);
                this.f35911b.c(false);
                com.sumsub.sns.core.presentation.base.a.a(this.f35911b, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static abstract class e implements a.j, Parcelable {

        public static final class a extends e {
            public static final Parcelable.Creator<a> CREATOR = new C0475a();

            /* renamed from: a  reason: collision with root package name */
            public final f f35914a;

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$a$a  reason: collision with other inner class name */
            public static final class C0475a implements Parcelable.Creator<a> {
                /* renamed from: a */
                public final a createFromParcel(Parcel parcel) {
                    return new a(f.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final a[] newArray(int i11) {
                    return new a[i11];
                }
            }

            public a(f fVar) {
                super((kotlin.jvm.internal.r) null);
                this.f35914a = fVar;
            }

            public final f a() {
                return this.f35914a;
            }

            public final f b() {
                return this.f35914a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.x.b(this.f35914a, ((a) obj).f35914a);
            }

            public int hashCode() {
                return this.f35914a.hashCode();
            }

            public String toString() {
                return "PhotoPickerRequestAction(pickerRequest=" + this.f35914a + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f35914a.writeToParcel(parcel, i11);
            }

            public final a a(f fVar) {
                return new a(fVar);
            }

            public static /* synthetic */ a a(a aVar, f fVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    fVar = aVar.f35914a;
                }
                return aVar.a(fVar);
            }
        }

        public static final class b extends e {
            public static final Parcelable.Creator<b> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public final f f35915a;

            public static final class a implements Parcelable.Creator<b> {
                /* renamed from: a */
                public final b createFromParcel(Parcel parcel) {
                    return new b(f.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final b[] newArray(int i11) {
                    return new b[i11];
                }
            }

            public b(f fVar) {
                super((kotlin.jvm.internal.r) null);
                this.f35915a = fVar;
            }

            public final f a() {
                return this.f35915a;
            }

            public final f b() {
                return this.f35915a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && kotlin.jvm.internal.x.b(this.f35915a, ((b) obj).f35915a);
            }

            public int hashCode() {
                return this.f35915a.hashCode();
            }

            public String toString() {
                return "SelfieRequestAction(pickerRequest=" + this.f35915a + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f35915a.writeToParcel(parcel, i11);
            }

            public final b a(f fVar) {
                return new b(fVar);
            }

            public static /* synthetic */ b a(b bVar, f fVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    fVar = bVar.f35915a;
                }
                return bVar.a(fVar);
            }
        }

        public /* synthetic */ e(kotlin.jvm.internal.r rVar) {
            this();
        }

        public e() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onPhotoRotationChanged$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35916a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f35918c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f35919d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35920e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(File file, int i11, SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super e0> cVar) {
            super(2, cVar);
            this.f35918c = file;
            this.f35919d = i11;
            this.f35920e = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((e0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e0 e0Var = new e0(this.f35918c, this.f35919d, this.f35920e, cVar);
            e0Var.f35917b = obj;
            return e0Var;
        }

        public final Object invokeSuspend(Object obj) {
            d dVar;
            String str;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35916a == 0) {
                kotlin.k.b(obj);
                g gVar = (g) this.f35917b;
                List<d> g11 = gVar.g();
                File file = this.f35918c;
                int i11 = this.f35919d;
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f35920e;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
                for (d dVar2 : g11) {
                    if (kotlin.jvm.internal.x.b(dVar2.e(), file)) {
                        dVar = d.a(dVar2, (Bitmap) null, (File) null, i11, false, 11, (Object) null);
                    } else {
                        Map g12 = sNSPreviewPhotoDocumentViewModel.E();
                        File e11 = dVar2.e();
                        if (e11 == null || (str = e11.getAbsolutePath()) == null) {
                            str = "";
                        }
                        b bVar = (b) g12.get(str);
                        dVar = d.a(dVar2, (Bitmap) null, (File) null, bVar != null ? bVar.b() : 0, false, 11, (Object) null);
                    }
                    arrayList.add(dVar);
                }
                return g.a(gVar, arrayList, (k) null, false, false, (Content) null, 30, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final boolean f35921a;

        /* renamed from: b  reason: collision with root package name */
        public final Document f35922b;

        /* renamed from: c  reason: collision with root package name */
        public final List<IdentitySide> f35923c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f35924d;

        /* renamed from: e  reason: collision with root package name */
        public final String f35925e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f35926f;

        /* renamed from: g  reason: collision with root package name */
        public final DocCapture.PreferredMode f35927g;

        /* renamed from: h  reason: collision with root package name */
        public final com.sumsub.sns.internal.ml.badphotos.models.b f35928h;

        public static final class a implements Parcelable.Creator<f> {
            /* renamed from: a */
            public final f createFromParcel(Parcel parcel) {
                boolean z11 = parcel.readInt() != 0;
                Document createFromParcel = Document.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(IdentitySide.valueOf(parcel.readString()));
                }
                boolean z12 = parcel.readInt() != 0;
                String readString = parcel.readString();
                boolean z13 = parcel.readInt() != 0;
                com.sumsub.sns.internal.ml.badphotos.models.b bVar = null;
                DocCapture.PreferredMode valueOf = parcel.readInt() == 0 ? null : DocCapture.PreferredMode.valueOf(parcel.readString());
                if (parcel.readInt() != 0) {
                    bVar = com.sumsub.sns.internal.ml.badphotos.models.b.CREATOR.createFromParcel(parcel);
                }
                return new f(z11, createFromParcel, arrayList, z12, readString, z13, valueOf, bVar);
            }

            /* renamed from: a */
            public final f[] newArray(int i11) {
                return new f[i11];
            }
        }

        public f(boolean z11, Document document, List<? extends IdentitySide> list, boolean z12, String str, boolean z13, DocCapture.PreferredMode preferredMode, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
            this.f35921a = z11;
            this.f35922b = document;
            this.f35923c = list;
            this.f35924d = z12;
            this.f35925e = str;
            this.f35926f = z13;
            this.f35927g = preferredMode;
            this.f35928h = bVar;
        }

        public final boolean a() {
            return this.f35921a;
        }

        public final Document b() {
            return this.f35922b;
        }

        public final List<IdentitySide> c() {
            return this.f35923c;
        }

        public final boolean d() {
            return this.f35924d;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f35925e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f35921a == fVar.f35921a && kotlin.jvm.internal.x.b(this.f35922b, fVar.f35922b) && kotlin.jvm.internal.x.b(this.f35923c, fVar.f35923c) && this.f35924d == fVar.f35924d && kotlin.jvm.internal.x.b(this.f35925e, fVar.f35925e) && this.f35926f == fVar.f35926f && this.f35927g == fVar.f35927g && kotlin.jvm.internal.x.b(this.f35928h, fVar.f35928h);
        }

        public final boolean f() {
            return this.f35926f;
        }

        public final DocCapture.PreferredMode g() {
            return this.f35927g;
        }

        public final com.sumsub.sns.internal.ml.badphotos.models.b h() {
            return this.f35928h;
        }

        public int hashCode() {
            boolean z11 = this.f35921a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int hashCode = (((((z11 ? 1 : 0) * true) + this.f35922b.hashCode()) * 31) + this.f35923c.hashCode()) * 31;
            boolean z13 = this.f35924d;
            if (z13) {
                z13 = true;
            }
            int i11 = (hashCode + (z13 ? 1 : 0)) * 31;
            String str = this.f35925e;
            int i12 = 0;
            int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            boolean z14 = this.f35926f;
            if (!z14) {
                z12 = z14;
            }
            int i13 = (hashCode2 + (z12 ? 1 : 0)) * 31;
            DocCapture.PreferredMode preferredMode = this.f35927g;
            int hashCode3 = (i13 + (preferredMode == null ? 0 : preferredMode.hashCode())) * 31;
            com.sumsub.sns.internal.ml.badphotos.models.b bVar = this.f35928h;
            if (bVar != null) {
                i12 = bVar.hashCode();
            }
            return hashCode3 + i12;
        }

        public final Document i() {
            return this.f35922b;
        }

        public final boolean j() {
            return this.f35924d;
        }

        public final String k() {
            return this.f35925e;
        }

        public final DocCapture.PreferredMode l() {
            return this.f35927g;
        }

        public final com.sumsub.sns.internal.ml.badphotos.models.b m() {
            return this.f35928h;
        }

        public final boolean n() {
            return this.f35926f;
        }

        public final List<IdentitySide> o() {
            return this.f35923c;
        }

        public final boolean p() {
            return this.f35921a;
        }

        public String toString() {
            return "PickerRequest(isSeamless=" + this.f35921a + ", document=" + this.f35922b + ", sides=" + this.f35923c + ", gallery=" + this.f35924d + ", identityType=" + this.f35925e + ", retake=" + this.f35926f + ", preferredMode=" + this.f35927g + ", previousQualityResult=" + this.f35928h + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f35921a ? 1 : 0);
            this.f35922b.writeToParcel(parcel, i11);
            List<IdentitySide> list = this.f35923c;
            parcel.writeInt(list.size());
            for (IdentitySide name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeInt(this.f35924d ? 1 : 0);
            parcel.writeString(this.f35925e);
            parcel.writeInt(this.f35926f ? 1 : 0);
            DocCapture.PreferredMode preferredMode = this.f35927g;
            if (preferredMode == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(preferredMode.name());
            }
            com.sumsub.sns.internal.ml.badphotos.models.b bVar = this.f35928h;
            if (bVar == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            bVar.writeToParcel(parcel, i11);
        }

        public final f a(boolean z11, Document document, List<? extends IdentitySide> list, boolean z12, String str, boolean z13, DocCapture.PreferredMode preferredMode, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
            return new f(z11, document, list, z12, str, z13, preferredMode, bVar);
        }

        public static /* synthetic */ f a(f fVar, boolean z11, Document document, List list, boolean z12, String str, boolean z13, DocCapture.PreferredMode preferredMode, com.sumsub.sns.internal.ml.badphotos.models.b bVar, int i11, Object obj) {
            f fVar2 = fVar;
            int i12 = i11;
            return fVar.a((i12 & 1) != 0 ? fVar2.f35921a : z11, (i12 & 2) != 0 ? fVar2.f35922b : document, (i12 & 4) != 0 ? fVar2.f35923c : list, (i12 & 8) != 0 ? fVar2.f35924d : z12, (i12 & 16) != 0 ? fVar2.f35925e : str, (i12 & 32) != 0 ? fVar2.f35926f : z13, (i12 & 64) != 0 ? fVar2.f35927g : preferredMode, (i12 & 128) != 0 ? fVar2.f35928h : bVar);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ f(boolean z11, Document document, List list, boolean z12, String str, boolean z13, DocCapture.PreferredMode preferredMode, com.sumsub.sns.internal.ml.badphotos.models.b bVar, int i11, kotlin.jvm.internal.r rVar) {
            this(z11, document, list, z12, (i11 & 16) != 0 ? null : str, (i11 & 32) != 0 ? false : z13, preferredMode, bVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {194, 195}, m = "onPrepare$suspendImpl")
    public static final class f0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35929a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35931c;

        /* renamed from: d  reason: collision with root package name */
        public int f35932d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super f0> cVar) {
            super(cVar);
            this.f35931c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35930b = obj;
            this.f35932d |= Integer.MIN_VALUE;
            return SNSPreviewPhotoDocumentViewModel.f(this.f35931c, this);
        }
    }

    public static final class g extends a.d {

        /* renamed from: a  reason: collision with root package name */
        public final List<d> f35933a;

        /* renamed from: b  reason: collision with root package name */
        public final k f35934b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f35935c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f35936d;

        /* renamed from: e  reason: collision with root package name */
        public final Content f35937e;

        public g() {
            this((List) null, (k) null, false, false, (Content) null, 31, (kotlin.jvm.internal.r) null);
        }

        public final List<d> a() {
            return this.f35933a;
        }

        public final k b() {
            return this.f35934b;
        }

        public final boolean c() {
            return this.f35935c;
        }

        public final boolean d() {
            return this.f35936d;
        }

        public final Content e() {
            return this.f35937e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return kotlin.jvm.internal.x.b(this.f35933a, gVar.f35933a) && kotlin.jvm.internal.x.b(this.f35934b, gVar.f35934b) && this.f35935c == gVar.f35935c && this.f35936d == gVar.f35936d && kotlin.jvm.internal.x.b(this.f35937e, gVar.f35937e);
        }

        public final Content f() {
            return this.f35937e;
        }

        public final List<d> g() {
            return this.f35933a;
        }

        public final boolean h() {
            return this.f35935c;
        }

        public int hashCode() {
            int hashCode = this.f35933a.hashCode() * 31;
            k kVar = this.f35934b;
            int i11 = 0;
            int hashCode2 = (hashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
            boolean z11 = this.f35935c;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.f35936d;
            if (!z13) {
                z12 = z13;
            }
            int i13 = (i12 + (z12 ? 1 : 0)) * 31;
            Content content = this.f35937e;
            if (content != null) {
                i11 = content.hashCode();
            }
            return i13 + i11;
        }

        public final boolean i() {
            return this.f35936d;
        }

        public final k j() {
            return this.f35934b;
        }

        public String toString() {
            return "SNSPreviewPhotoDocumentViewState(documents=" + this.f35933a + ", warning=" + this.f35934b + ", rotationAvailable=" + this.f35935c + ", showContent=" + this.f35936d + ", content=" + this.f35937e + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ g(java.util.List r4, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k r5, boolean r6, boolean r7, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content r8, int r9, kotlin.jvm.internal.r r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0008
                java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x0008:
                r10 = r9 & 2
                r0 = 0
                if (r10 == 0) goto L_0x000f
                r10 = r0
                goto L_0x0010
            L_0x000f:
                r10 = r5
            L_0x0010:
                r5 = r9 & 4
                r1 = 0
                if (r5 == 0) goto L_0x0017
                r2 = r1
                goto L_0x0018
            L_0x0017:
                r2 = r6
            L_0x0018:
                r5 = r9 & 8
                if (r5 == 0) goto L_0x001d
                goto L_0x001e
            L_0x001d:
                r1 = r7
            L_0x001e:
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0023
                goto L_0x0024
            L_0x0023:
                r0 = r8
            L_0x0024:
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r2
                r9 = r1
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g.<init>(java.util.List, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k, boolean, boolean, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content, int, kotlin.jvm.internal.r):void");
        }

        public final g a(List<d> list, k kVar, boolean z11, boolean z12, Content content) {
            return new g(list, kVar, z11, z12, content);
        }

        public static /* synthetic */ g a(g gVar, List<d> list, k kVar, boolean z11, boolean z12, Content content, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = gVar.f35933a;
            }
            if ((i11 & 2) != 0) {
                kVar = gVar.f35934b;
            }
            k kVar2 = kVar;
            if ((i11 & 4) != 0) {
                z11 = gVar.f35935c;
            }
            boolean z13 = z11;
            if ((i11 & 8) != 0) {
                z12 = gVar.f35936d;
            }
            boolean z14 = z12;
            if ((i11 & 16) != 0) {
                content = gVar.f35937e;
            }
            return gVar.a(list, kVar2, z13, z14, content);
        }

        public g(List<d> list, k kVar, boolean z11, boolean z12, Content content) {
            this.f35933a = list;
            this.f35934b = kVar;
            this.f35935c = z11;
            this.f35936d = z12;
            this.f35937e = content;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onPrepare$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {196}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35938a;

        /* renamed from: b  reason: collision with root package name */
        public int f35939b;

        /* renamed from: c  reason: collision with root package name */
        public int f35940c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35941d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35942e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super g0> cVar) {
            super(2, cVar);
            this.f35942e = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((g0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            g0 g0Var = new g0(this.f35942e, cVar);
            g0Var.f35941d = obj;
            return g0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r12.f35940c
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                int r0 = r12.f35939b
                int r1 = r12.f35938a
                java.lang.Object r4 = r12.f35941d
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r4
                kotlin.k.b(r13)
                goto L_0x003b
            L_0x0018:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0020:
                kotlin.k.b(r13)
                java.lang.Object r13 = r12.f35941d
                r4 = r13
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r4
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r13 = r12.f35942e
                r12.f35941d = r4
                r12.f35938a = r3
                r12.f35939b = r3
                r12.f35940c = r2
                java.lang.Object r13 = r13.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r12)
                if (r13 != r0) goto L_0x0039
                return r0
            L_0x0039:
                r0 = r3
                r1 = r0
            L_0x003b:
                r6 = 0
                r5 = 0
                if (r1 == 0) goto L_0x0041
                r7 = r2
                goto L_0x0042
            L_0x0041:
                r7 = r3
            L_0x0042:
                if (r0 == 0) goto L_0x0046
                r8 = r2
                goto L_0x0047
            L_0x0046:
                r8 = r3
            L_0x0047:
                r9 = r13
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r9 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r9
                r10 = 15
                r11 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r13 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g.a(r4, r5, r6, r7, r8, r9, r10, r11)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35943a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35944b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35945c;

        public h(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f35943a = charSequence;
            this.f35944b = charSequence2;
            this.f35945c = charSequence3;
        }

        public final CharSequence a() {
            return this.f35943a;
        }

        public final CharSequence b() {
            return this.f35944b;
        }

        public final CharSequence c() {
            return this.f35945c;
        }

        public final CharSequence d() {
            return this.f35945c;
        }

        public final CharSequence e() {
            return this.f35944b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return kotlin.jvm.internal.x.b(this.f35943a, hVar.f35943a) && kotlin.jvm.internal.x.b(this.f35944b, hVar.f35944b) && kotlin.jvm.internal.x.b(this.f35945c, hVar.f35945c);
        }

        public final CharSequence f() {
            return this.f35943a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35943a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35944b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35945c;
            if (charSequence3 != null) {
                i11 = charSequence3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "ShowAnotherSideAction(message=" + this.f35943a + ", buttonPositive=" + this.f35944b + ", buttonNegative=" + this.f35945c + ')';
        }

        public final h a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new h(charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ h a(h hVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = hVar.f35943a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = hVar.f35944b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = hVar.f35945c;
            }
            return hVar.a(charSequence, charSequence2, charSequence3);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onRestartStep$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {1173}, m = "invokeSuspend")
    public static final class h0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35947b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super h0> cVar) {
            super(2, cVar);
            this.f35947b = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h0(this.f35947b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35946a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f35947b;
                this.f35946a = 1;
                if (sNSPreviewPhotoDocumentViewModel.c(true, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class i implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.domain.model.c f35948a;

        /* renamed from: b  reason: collision with root package name */
        public final Parcelable f35949b;

        public i(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
            this.f35948a = cVar;
            this.f35949b = parcelable;
        }

        public final com.sumsub.sns.internal.core.domain.model.c a() {
            return this.f35948a;
        }

        public final Parcelable b() {
            return this.f35949b;
        }

        public final com.sumsub.sns.internal.core.domain.model.c c() {
            return this.f35948a;
        }

        public final Parcelable d() {
            return this.f35949b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return kotlin.jvm.internal.x.b(this.f35948a, iVar.f35948a) && kotlin.jvm.internal.x.b(this.f35949b, iVar.f35949b);
        }

        public int hashCode() {
            int hashCode = this.f35948a.hashCode() * 31;
            Parcelable parcelable = this.f35949b;
            return hashCode + (parcelable == null ? 0 : parcelable.hashCode());
        }

        public String toString() {
            return "ShowInstructions(introParams=" + this.f35948a + ", payload=" + this.f35949b + ')';
        }

        public final i a(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
            return new i(cVar, parcelable);
        }

        public static /* synthetic */ i a(i iVar, com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                cVar = iVar.f35948a;
            }
            if ((i11 & 2) != 0) {
                parcelable = iVar.f35949b;
            }
            return iVar.a(cVar, parcelable);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onTakeAnotherDataClicked$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {221}, m = "invokeSuspend")
    public static final class i0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35951b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super i0> cVar) {
            super(2, cVar);
            this.f35951b = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i0(this.f35951b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35950a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f35951b;
                this.f35950a = 1;
                if (sNSPreviewPhotoDocumentViewModel.c(true, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class j implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final e.a<com.sumsub.sns.internal.ml.badphotos.models.a> f35952a;

        public j(e.a<com.sumsub.sns.internal.ml.badphotos.models.a> aVar) {
            this.f35952a = aVar;
        }

        public final e.a<com.sumsub.sns.internal.ml.badphotos.models.a> a() {
            return this.f35952a;
        }

        public final e.a<com.sumsub.sns.internal.ml.badphotos.models.a> b() {
            return this.f35952a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && kotlin.jvm.internal.x.b(this.f35952a, ((j) obj).f35952a);
        }

        public int hashCode() {
            return this.f35952a.hashCode();
        }

        public String toString() {
            return "ShowPhotoAnalyzeDebugInfoAction(debugPhotoQualityResult=" + this.f35952a + ')';
        }

        public final j a(e.a<com.sumsub.sns.internal.ml.badphotos.models.a> aVar) {
            return new j(aVar);
        }

        public static /* synthetic */ j a(j jVar, e.a<com.sumsub.sns.internal.ml.badphotos.models.a> aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                aVar = jVar.f35952a;
            }
            return jVar.a(aVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onUploadDocuments$3", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {645, 655}, m = "invokeSuspend")
    public static final class j0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f35955c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f35956d;

        public static final class a extends Lambda implements d10.l<Integer, Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35957a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel) {
                super(1);
                this.f35957a = sNSPreviewPhotoDocumentViewModel;
            }

            public final void a(int i11) {
                this.f35957a.b(i11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.f56620a;
            }
        }

        public /* synthetic */ class b extends AdaptedFunctionReference implements d10.p<Exception, kotlin.coroutines.c<? super Unit>, Object> {
            public b(Object obj) {
                super(2, obj, SNSPreviewPhotoDocumentViewModel.class, "onDocumentsUploadedError", "onDocumentsUploadedError(Ljava/lang/Exception;)V", 4);
            }

            /* renamed from: a */
            public final Object invoke(Exception exc, kotlin.coroutines.c<? super Unit> cVar) {
                return ((SNSPreviewPhotoDocumentViewModel) this.receiver).a(exc);
            }
        }

        public /* synthetic */ class c extends FunctionReferenceImpl implements d10.p<List<? extends com.sumsub.sns.internal.core.data.model.remote.k>, kotlin.coroutines.c<? super Unit>, Object> {
            public c(Object obj) {
                super(2, obj, SNSPreviewPhotoDocumentViewModel.class, "onDocumentsUploadedSuccess", "onDocumentsUploadedSuccess(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            /* renamed from: a */
            public final Object invoke(List<com.sumsub.sns.internal.core.data.model.remote.k> list, kotlin.coroutines.c<? super Unit> cVar) {
                return ((SNSPreviewPhotoDocumentViewModel) this.receiver).a(list, cVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, boolean z11, boolean z12, kotlin.coroutines.c<? super j0> cVar) {
            super(2, cVar);
            this.f35954b = sNSPreviewPhotoDocumentViewModel;
            this.f35955c = z11;
            this.f35956d = z12;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j0(this.f35954b, this.f35955c, this.f35956d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35953a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f35954b.E.a((d10.l<? super Integer, Unit>) new a(this.f35954b));
                com.sumsub.sns.internal.domain.o k11 = this.f35954b.E;
                o.a aVar = new o.a(this.f35954b.u(), this.f35954b.s(), this.f35954b.G(), this.f35955c, this.f35956d);
                this.f35953a = 1;
                obj = k11.b(aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                kotlin.k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b bVar = new b(this.f35954b);
            c cVar = new c(this.f35954b);
            this.f35953a = 2;
            if (com.sumsub.sns.internal.core.domain.base.c.a((com.sumsub.sns.internal.core.domain.model.a) obj, bVar, cVar, this) == d11) {
                return d11;
            }
            return Unit.f56620a;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }
    }

    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35958a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35959b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35960c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35961d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f35962e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f35963f;

        public k(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, boolean z12) {
            this.f35958a = charSequence;
            this.f35959b = charSequence2;
            this.f35960c = charSequence3;
            this.f35961d = charSequence4;
            this.f35962e = z11;
            this.f35963f = z12;
        }

        public final CharSequence a() {
            return this.f35958a;
        }

        public final CharSequence b() {
            return this.f35959b;
        }

        public final CharSequence c() {
            return this.f35960c;
        }

        public final CharSequence d() {
            return this.f35961d;
        }

        public final boolean e() {
            return this.f35962e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return kotlin.jvm.internal.x.b(this.f35958a, kVar.f35958a) && kotlin.jvm.internal.x.b(this.f35959b, kVar.f35959b) && kotlin.jvm.internal.x.b(this.f35960c, kVar.f35960c) && kotlin.jvm.internal.x.b(this.f35961d, kVar.f35961d) && this.f35962e == kVar.f35962e && this.f35963f == kVar.f35963f;
        }

        public final boolean f() {
            return this.f35963f;
        }

        public final CharSequence g() {
            return this.f35960c;
        }

        public final CharSequence h() {
            return this.f35961d;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35958a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35959b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35960c;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f35961d;
            if (charSequence4 != null) {
                i11 = charSequence4.hashCode();
            }
            int i12 = (hashCode3 + i11) * 31;
            boolean z11 = this.f35962e;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i13 = (i12 + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.f35963f;
            if (!z13) {
                z12 = z13;
            }
            return i13 + (z12 ? 1 : 0);
        }

        public final CharSequence i() {
            return this.f35959b;
        }

        public final boolean j() {
            return this.f35963f;
        }

        public final CharSequence k() {
            return this.f35958a;
        }

        public final boolean l() {
            return this.f35962e;
        }

        public String toString() {
            return "WarningResult(title=" + this.f35958a + ", message=" + this.f35959b + ", buttonPrimary=" + this.f35960c + ", buttonSecondary=" + this.f35961d + ", isFatal=" + this.f35962e + ", showIcon=" + this.f35963f + ')';
        }

        public final k a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, boolean z12) {
            return new k(charSequence, charSequence2, charSequence3, charSequence4, z11, z12);
        }

        public static /* synthetic */ k a(k kVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, boolean z12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = kVar.f35958a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = kVar.f35959b;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = kVar.f35960c;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i11 & 8) != 0) {
                charSequence4 = kVar.f35961d;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i11 & 16) != 0) {
                z11 = kVar.f35962e;
            }
            boolean z13 = z11;
            if ((i11 & 32) != 0) {
                z12 = kVar.f35963f;
            }
            return kVar.a(charSequence, charSequence5, charSequence6, charSequence7, z13, z12);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ k(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, boolean z12, int i11, kotlin.jvm.internal.r rVar) {
            this(charSequence, charSequence2, charSequence3, charSequence4, z11, (i11 & 32) != 0 ? true : z12);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {813}, m = "prepareAvailableDocuments")
    public static final class k0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35964a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35965b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35966c;

        /* renamed from: d  reason: collision with root package name */
        public int f35967d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super k0> cVar) {
            super(cVar);
            this.f35966c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35965b = obj;
            this.f35967d |= Integer.MIN_VALUE;
            return this.f35966c.g((kotlin.coroutines.c<? super List<String>>) this);
        }
    }

    public /* synthetic */ class l {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35968a;

        static {
            int[] iArr = new int[SNSPreviewIdentityDocumentViewModel.DocumentSideness.values().length];
            iArr[SNSPreviewIdentityDocumentViewModel.DocumentSideness.DOUBLE.ordinal()] = 1;
            iArr[SNSPreviewIdentityDocumentViewModel.DocumentSideness.SINGLE.ordinal()] = 2;
            f35968a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {1017}, m = "preparePickerRequest$suspendImpl")
    public static final class l0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35969a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35970b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35971c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35972d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35973e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f35974f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35975g;

        /* renamed from: h  reason: collision with root package name */
        public int f35976h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super l0> cVar) {
            super(cVar);
            this.f35975g = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35974f = obj;
            this.f35976h |= Integer.MIN_VALUE;
            return SNSPreviewPhotoDocumentViewModel.a(this.f35975g, false, (com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {836}, m = "analyzePhoto")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35977a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35978b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35979c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35980d;

        /* renamed from: e  reason: collision with root package name */
        public int f35981e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super m> cVar) {
            super(cVar);
            this.f35980d = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35979c = obj;
            this.f35981e |= Integer.MIN_VALUE;
            return this.f35980d.a((Bitmap) null, (IdentitySide) null, (kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {1039}, m = "preparePickerRequestSides")
    public static final class m0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35982a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35984c;

        /* renamed from: d  reason: collision with root package name */
        public int f35985d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super m0> cVar) {
            super(cVar);
            this.f35984c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35983b = obj;
            this.f35985d |= Integer.MIN_VALUE;
            return this.f35984c.h((kotlin.coroutines.c<? super List<? extends IdentitySide>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {566}, m = "checkQuality")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35986a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35988c;

        /* renamed from: d  reason: collision with root package name */
        public int f35989d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super n> cVar) {
            super(cVar);
            this.f35988c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35987b = obj;
            this.f35989d |= Integer.MIN_VALUE;
            return this.f35988c.a((Bitmap) null, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (IdentitySide) null, (kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$removePickedFiles$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class n0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List<File> f35991b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(List<? extends File> list, kotlin.coroutines.c<? super n0> cVar) {
            super(2, cVar);
            this.f35991b = list;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n0(this.f35991b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35990a == 0) {
                kotlin.k.b(obj);
                for (File file : this.f35991b) {
                    boolean delete = file.delete();
                    com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
                    com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "deleting " + file.getAbsolutePath() + " success=" + delete, (Throwable) null, 4, (Object) null);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$checkQuality$photoQualityCheck$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {566}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f35993b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f35994c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IdentitySide f35995d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, Bitmap bitmap, IdentitySide identitySide, kotlin.coroutines.c<? super o> cVar) {
            super(1, cVar);
            this.f35993b = sNSPreviewPhotoDocumentViewModel;
            this.f35994c = bitmap;
            this.f35995d = identitySide;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>> cVar) {
            return ((o) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new o(this.f35993b, this.f35994c, this.f35995d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35992a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f35993b;
                Bitmap bitmap = this.f35994c;
                IdentitySide identitySide = this.f35995d;
                this.f35992a = 1;
                obj = sNSPreviewPhotoDocumentViewModel.a(bitmap, identitySide, (kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$sendLog$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class o0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35996a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35997b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35998c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Exception f35999d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o0(String str, Exception exc, kotlin.coroutines.c<? super o0> cVar) {
            super(2, cVar);
            this.f35998c = str;
            this.f35999d = exc;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((o0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            o0 o0Var = new o0(this.f35998c, this.f35999d, cVar);
            o0Var.f35997b = obj;
            return o0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35996a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(com.sumsub.sns.internal.log.c.a((kotlinx.coroutines.h0) this.f35997b), this.f35998c, this.f35999d);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {526}, m = "decodeImage")
    public static final class p extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36000a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36002c;

        /* renamed from: d  reason: collision with root package name */
        public int f36003d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super p> cVar) {
            super(cVar);
            this.f36002c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36001b = obj;
            this.f36003d |= Integer.MIN_VALUE;
            return this.f36002c.a((com.sumsub.sns.internal.core.data.model.n) null, (kotlin.coroutines.c<? super Bitmap>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showContent$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class p0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36004a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36005b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36006c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p0(boolean z11, kotlin.coroutines.c<? super p0> cVar) {
            super(2, cVar);
            this.f36006c = z11;
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((p0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            p0 p0Var = new p0(this.f36006c, cVar);
            p0Var.f36005b = obj;
            return p0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36004a == 0) {
                kotlin.k.b(obj);
                return g.a((g) this.f36005b, (List) null, (k) null, false, this.f36006c, (Content) null, 23, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {537}, m = "decodePdf")
    public static final class q extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36007a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36008b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36009c;

        /* renamed from: d  reason: collision with root package name */
        public int f36010d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super q> cVar) {
            super(cVar);
            this.f36009c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36008b = obj;
            this.f36010d |= Integer.MIN_VALUE;
            return this.f36009c.b((com.sumsub.sns.internal.core.data.model.n) null, (kotlin.coroutines.c<? super Bitmap>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {954, 966}, m = "showPhotoPicker")
    public static final class q0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36011a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36012b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36013c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36014d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36015e;

        /* renamed from: f  reason: collision with root package name */
        public int f36016f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super q0> cVar) {
            super(cVar);
            this.f36015e = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36014d = obj;
            this.f36016f |= Integer.MIN_VALUE;
            return this.f36015e.c(false, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$decodePdf$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36017a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f36019c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(Throwable th2, kotlin.coroutines.c<? super r> cVar) {
            super(2, cVar);
            this.f36019c = th2;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((r) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            r rVar = new r(this.f36019c, cVar);
            rVar.f36018b = obj;
            return rVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36017a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(com.sumsub.sns.internal.log.c.a((kotlinx.coroutines.h0) this.f36018b), "Can't decode PDF", this.f36019c);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showPhotoPicker$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class r0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36020a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36021b;

        public r0(kotlin.coroutines.c<? super r0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((r0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            r0 r0Var = new r0(cVar);
            r0Var.f36021b = obj;
            return r0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36020a == 0) {
                kotlin.k.b(obj);
                return g.a((g) this.f36021b, (List) null, (k) null, false, false, (Content) null, 23, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {1076}, m = "documentSideness")
    public static final class s extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36022a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36023b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36024c;

        /* renamed from: d  reason: collision with root package name */
        public int f36025d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super s> cVar) {
            super(cVar);
            this.f36024c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36023b = obj;
            this.f36025d |= Integer.MIN_VALUE;
            return this.f36024c.a(false, (kotlin.coroutines.c<? super SNSPreviewIdentityDocumentViewModel.DocumentSideness>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showResultsPreview$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {436, 440, 457, 460, 477, 481, 514}, m = "invokeSuspend")
    public static final class s0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36026a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36027b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36028c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36029d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36030e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36031f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36032g;

        /* renamed from: h  reason: collision with root package name */
        public Object f36033h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36034i;

        /* renamed from: j  reason: collision with root package name */
        public Object f36035j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f36036k;

        /* renamed from: l  reason: collision with root package name */
        public int f36037l;

        /* renamed from: m  reason: collision with root package name */
        public int f36038m;

        /* renamed from: n  reason: collision with root package name */
        public int f36039n;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36040o;

        /* renamed from: p  reason: collision with root package name */
        public final /* synthetic */ List<com.sumsub.sns.internal.core.data.model.n> f36041p;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showResultsPreview$1$2", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36042a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f36043b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(g gVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36043b = gVar;
            }

            /* renamed from: a */
            public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
                return ((a) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36043b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f36042a == 0) {
                    kotlin.k.b(obj);
                    return g.a(this.f36043b, (List) null, (k) null, false, true, (Content) null, 23, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, List<com.sumsub.sns.internal.core.data.model.n> list, kotlin.coroutines.c<? super s0> cVar) {
            super(2, cVar);
            this.f36040o = sNSPreviewPhotoDocumentViewModel;
            this.f36041p = list;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((s0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s0(this.f36040o, this.f36041p, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0393, code lost:
            r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0395, code lost:
            r2.add(r4);
            r2 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x039a, code lost:
            r2 = (java.util.List) r2;
            r1 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x03a4, code lost:
            if (r1.hasNext() == false) goto L_0x03bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x03a6, code lost:
            r4 = r1.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x03b3, code lost:
            if (((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4).l() != com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.BLOCKING) goto L_0x03b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x03b5, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x03b7, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x03b8, code lost:
            if (r7 == false) goto L_0x03a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x03bb, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x03bc, code lost:
            r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x03be, code lost:
            if (r4 != null) goto L_0x03eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x03c0, code lost:
            r1 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x03c8, code lost:
            if (r1.hasNext() == false) goto L_0x03df;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x03ca, code lost:
            r4 = r1.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x03d7, code lost:
            if (((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4).l() != com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.WARNING) goto L_0x03db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x03d9, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x03db, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x03dc, code lost:
            if (r7 == false) goto L_0x03c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x03df, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x03e0, code lost:
            r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x03e2, code lost:
            if (r4 != null) goto L_0x03eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x03e4, code lost:
            r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x03eb, code lost:
            r25 = r4;
            r1 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r10, 10));
            r2 = r10.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0400, code lost:
            if (r2.hasNext() == false) goto L_0x043c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x0402, code lost:
            r4 = (com.sumsub.sns.internal.core.data.model.n) r2.next();
            r7 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x040c, code lost:
            if (r7 != null) goto L_0x040f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x040e, code lost:
            r7 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x040f, code lost:
            r9 = (android.graphics.Bitmap) r12.get(r7);
            r4 = r4.m();
            r10 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b) r13.element.get(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x0425, code lost:
            if (r10 == null) goto L_0x042c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0427, code lost:
            r10 = r10.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x042c, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x042d, code lost:
            r1.add(new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.d(r9, r4, r10, r13.element.containsKey(r7)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x043c, code lost:
            r20 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g(r1, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k) null, true, false, r25, 10, (kotlin.jvm.internal.r) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0450, code lost:
            r3 = r2.f36041p;
            r4 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r3, 10));
            r3 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0465, code lost:
            if (r3.hasNext() == false) goto L_0x047b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0467, code lost:
            r4.add(new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.d((android.graphics.Bitmap) null, r3.next().k(), 0, false));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x047b, code lost:
            r3 = r2.f36040o;
            r2.f36026a = r4;
            r2.f36027b = null;
            r2.f36028c = null;
            r2.f36029d = null;
            r2.f36030e = null;
            r2.f36031f = null;
            r2.f36032g = null;
            r2.f36037l = 0;
            r2.f36038m = 0;
            r2.f36039n = 7;
            r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r3, (kotlin.coroutines.c) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0497, code lost:
            if (r3 != r1) goto L_0x049a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0499, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x049a, code lost:
            r8 = r4;
            r1 = 0;
            r4 = r2;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x049e, code lost:
            r12 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x04a7, code lost:
            if (r2 == 0) goto L_0x04ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x04a9, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x04ab, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x04ac, code lost:
            if (r1 == 0) goto L_0x04b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x04ae, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x04b0, code lost:
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x04b1, code lost:
            r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g(r8, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k) null, r10, r11, r12, 10, (kotlin.jvm.internal.r) null);
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x04b7, code lost:
            r3.f36040o.b(false);
            com.sumsub.sns.core.presentation.base.a.a(r3.f36040o, false, new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.s0.a(r2, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.s0.a>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x04ca, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x015c, code lost:
            if (r9.hasNext() == false) goto L_0x02d9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x015e, code lost:
            r8 = (com.sumsub.sns.internal.core.data.model.n) r9.next();
            r7 = r8.k();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0169, code lost:
            if (r7 == null) goto L_0x0170;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x016b, code lost:
            r7 = com.sumsub.sns.internal.core.common.m0.a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0170, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0171, code lost:
            r14 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            r15 = new java.lang.StringBuilder();
            r15.append("processing ");
            r5 = r8.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0181, code lost:
            if (r5 == null) goto L_0x0188;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0183, code lost:
            r5 = r5.getName();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0188, code lost:
            r5 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0189, code lost:
            r15.append(r5);
            r15.append(", mimeType=");
            r15.append(r7);
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r14, com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture.f31492c, r15.toString(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
            r5 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x01a7, code lost:
            if (r5 != null) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x01aa, code lost:
            r7 = kotlin.jvm.internal.x.b(r7, "application/pdf");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x01b0, code lost:
            if (r7 == false) goto L_0x01dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x01b2, code lost:
            r2.f36026a = r13;
            r2.f36027b = r12;
            r2.f36028c = r11;
            r2.f36029d = r10;
            r2.f36030e = r9;
            r2.f36031f = r8;
            r2.f36032g = r5;
            r2.f36036k = r7;
            r2.f36039n = r4;
            r14 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(r10, r8, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x01c8, code lost:
            if (r14 != r1) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x01ca, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x01cb, code lost:
            r28 = r5;
            r5 = r2;
            r2 = r7;
            r7 = r28;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x01d1, code lost:
            r14 = (android.graphics.Bitmap) r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x01d3, code lost:
            r28 = r11;
            r11 = r8;
            r8 = r14;
            r14 = r13;
            r13 = r12;
            r12 = r28;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x01dc, code lost:
            r2.f36026a = r13;
            r2.f36027b = r12;
            r2.f36028c = r11;
            r2.f36029d = r10;
            r2.f36030e = r9;
            r2.f36031f = r8;
            r2.f36032g = r5;
            r2.f36036k = r7;
            r2.f36039n = 2;
            r14 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r10, r8, (kotlin.coroutines.c) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x01f3, code lost:
            if (r14 != r1) goto L_0x01f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x01f5, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01f6, code lost:
            r28 = r5;
            r5 = r2;
            r2 = r7;
            r7 = r28;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01fc, code lost:
            r14 = (android.graphics.Bitmap) r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01ff, code lost:
            if (r8 != null) goto L_0x0211;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0201, code lost:
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture.f31492c, "bitmap null", (java.lang.Throwable) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0211, code lost:
            r13.put(r7, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0214, code lost:
            if (r2 == false) goto L_0x021c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0216, code lost:
            r2 = r5;
            r11 = r12;
            r12 = r13;
            r13 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0224, code lost:
            if (r14.element.containsKey(r7) != false) goto L_0x026a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0226, code lost:
            r2 = r14.element;
            r15 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.j(r10);
            r5.f36026a = r14;
            r5.f36027b = r13;
            r5.f36028c = r12;
            r5.f36029d = r10;
            r5.f36030e = r9;
            r5.f36031f = r11;
            r5.f36032g = r7;
            r5.f36033h = r8;
            r5.f36034i = r7;
            r5.f36035j = r2;
            r5.f36039n = 3;
            r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b(r15, r8, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0249, code lost:
            if (r3 != r1) goto L_0x024c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x024b, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x024c, code lost:
            r15 = r14;
            r14 = r13;
            r13 = r12;
            r12 = r10;
            r10 = r11;
            r11 = r9;
            r9 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0253, code lost:
            r2.put(r7, new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(((java.lang.Number) r3).intValue()));
            r3 = r8;
            r2 = r9;
            r7 = r10;
            r8 = r11;
            r9 = r12;
            r10 = r13;
            r11 = r14;
            r12 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x026a, code lost:
            r2 = r7;
            r3 = r8;
            r8 = r9;
            r9 = r10;
            r7 = r11;
            r10 = r12;
            r11 = r13;
            r12 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0272, code lost:
            r4 = r7.l();
            r13 = r7.o();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x027a, code lost:
            if (r13 != null) goto L_0x0280;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x027c, code lost:
            r13 = r9.J();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0280, code lost:
            r5.f36026a = r12;
            r5.f36027b = r11;
            r5.f36028c = r10;
            r5.f36029d = r9;
            r5.f36030e = r8;
            r5.f36031f = r7;
            r5.f36032g = r2;
            r5.f36033h = null;
            r5.f36034i = null;
            r5.f36035j = null;
            r5.f36039n = 4;
            r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r9, r3, r4, r13, (kotlin.coroutines.c) r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x029b, code lost:
            if (r3 != r1) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x029d, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x029e, code lost:
            r3 = (com.sumsub.sns.internal.ml.core.e.a) r3;
            r11.put(r2, r3);
            r20 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            r2 = new java.lang.StringBuilder();
            r2.append("Photo quality for ");
            r4 = r7.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x02b3, code lost:
            if (r4 == null) goto L_0x02ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x02b5, code lost:
            r4 = r4.getName();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x02ba, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x02bb, code lost:
            r2.append(r4);
            r2.append(" -> ");
            r2.append(r3);
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r20, com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture.f31492c, r2.toString(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
            r2 = r5;
            r4 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x02d9, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r2.f36040o, okhttp3.internal.Util.toImmutableMap(r13.element));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x02ec, code lost:
            if ((!r12.isEmpty()) == false) goto L_0x0450;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x02ee, code lost:
            r3 = r2.f36041p;
            r4 = new java.util.ArrayList();
            r3 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x02fd, code lost:
            if (r3.hasNext() == false) goto L_0x0315;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x02ff, code lost:
            r5 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x030a, code lost:
            if (r5.m() == null) goto L_0x030e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x030c, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x030e, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x030f, code lost:
            if (r7 == false) goto L_0x02f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0311, code lost:
            r4.add(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0315, code lost:
            r3 = r2.f36040o;
            r5 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r4, 10));
            r7 = r4.iterator();
            r9 = r3;
            r10 = r4;
            r3 = r2;
            r2 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x032a, code lost:
            r5 = "";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0330, code lost:
            if (r7.hasNext() == false) goto L_0x039a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0332, code lost:
            r4 = (com.sumsub.sns.internal.core.data.model.n) r7.next();
            r8 = r4.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x033c, code lost:
            if (r8 == null) goto L_0x0343;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x033e, code lost:
            r8 = r8.getAbsolutePath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0343, code lost:
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0344, code lost:
            if (r8 != null) goto L_0x0347;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0347, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0348, code lost:
            r5 = (com.sumsub.sns.internal.ml.core.e.a) r11.get(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x034e, code lost:
            if (r5 == null) goto L_0x0378;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0350, code lost:
            r4 = r4.o();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0354, code lost:
            if (r4 != null) goto L_0x0358;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0356, code lost:
            r4 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0098, code lost:
            r13 = r12;
            r12 = r11;
            r11 = r10;
            r10 = r9;
            r9 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0358, code lost:
            r3.f36026a = r13;
            r3.f36027b = r12;
            r3.f36028c = r11;
            r3.f36029d = r10;
            r3.f36030e = r9;
            r3.f36031f = r2;
            r3.f36032g = r7;
            r3.f36033h = r2;
            r3.f36039n = 5;
            r4 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r9, r4, r5, (kotlin.coroutines.c) r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x036f, code lost:
            if (r4 != r1) goto L_0x0372;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0371, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0372, code lost:
            r8 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0373, code lost:
            r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0375, code lost:
            if (r4 != null) goto L_0x0395;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0378, code lost:
            r8 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0379, code lost:
            r3.f36026a = r13;
            r3.f36027b = r12;
            r3.f36028c = r11;
            r3.f36029d = r10;
            r3.f36030e = r9;
            r3.f36031f = r8;
            r3.f36032g = r7;
            r3.f36033h = r2;
            r3.f36039n = 6;
            r4 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(r9, (kotlin.coroutines.c) r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0390, code lost:
            if (r4 != r1) goto L_0x0393;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0392, code lost:
            return r1;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                r29 = this;
                r0 = r29
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36039n
                r4 = 1
                r6 = 0
                switch(r2) {
                    case 0: goto L_0x011b;
                    case 1: goto L_0x00f5;
                    case 2: goto L_0x00cf;
                    case 3: goto L_0x009f;
                    case 4: goto L_0x0076;
                    case 5: goto L_0x004e;
                    case 6: goto L_0x0026;
                    case 7: goto L_0x0015;
                    default: goto L_0x000d;
                }
            L_0x000d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0015:
                int r1 = r0.f36038m
                int r2 = r0.f36037l
                java.lang.Object r3 = r0.f36026a
                java.util.List r3 = (java.util.List) r3
                kotlin.k.b(r30)
                r4 = r0
                r8 = r3
                r3 = r30
                goto L_0x049e
            L_0x0026:
                java.lang.Object r2 = r0.f36033h
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r7 = r0.f36032g
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f36031f
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r9 = r0.f36030e
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r9 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r9
                java.lang.Object r10 = r0.f36029d
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r0.f36028c
                java.util.Map r11 = (java.util.Map) r11
                java.lang.Object r12 = r0.f36027b
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
                kotlin.k.b(r30)
                r4 = r30
                r3 = r0
                goto L_0x0393
            L_0x004e:
                java.lang.Object r2 = r0.f36033h
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r7 = r0.f36032g
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f36031f
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r9 = r0.f36030e
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r9 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r9
                java.lang.Object r10 = r0.f36029d
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r0.f36028c
                java.util.Map r11 = (java.util.Map) r11
                java.lang.Object r12 = r0.f36027b
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
                kotlin.k.b(r30)
                r4 = r30
                r3 = r0
                goto L_0x0373
            L_0x0076:
                java.lang.Object r2 = r0.f36032g
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r7 = r0.f36031f
                com.sumsub.sns.internal.core.data.model.n r7 = (com.sumsub.sns.internal.core.data.model.n) r7
                java.lang.Object r8 = r0.f36030e
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r0.f36029d
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r9 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r9
                java.lang.Object r10 = r0.f36028c
                java.util.Map r10 = (java.util.Map) r10
                java.lang.Object r11 = r0.f36027b
                java.util.Map r11 = (java.util.Map) r11
                java.lang.Object r12 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref$ObjectRef) r12
                kotlin.k.b(r30)
                r3 = r30
                r5 = r0
            L_0x0098:
                r13 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r8
                goto L_0x029e
            L_0x009f:
                java.lang.Object r2 = r0.f36035j
                java.util.Map r2 = (java.util.Map) r2
                java.lang.Object r7 = r0.f36034i
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f36033h
                android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
                java.lang.Object r9 = r0.f36032g
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r10 = r0.f36031f
                com.sumsub.sns.internal.core.data.model.n r10 = (com.sumsub.sns.internal.core.data.model.n) r10
                java.lang.Object r11 = r0.f36030e
                java.util.Iterator r11 = (java.util.Iterator) r11
                java.lang.Object r12 = r0.f36029d
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r12 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r12
                java.lang.Object r13 = r0.f36028c
                java.util.Map r13 = (java.util.Map) r13
                java.lang.Object r14 = r0.f36027b
                java.util.Map r14 = (java.util.Map) r14
                java.lang.Object r15 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r15 = (kotlin.jvm.internal.Ref$ObjectRef) r15
                kotlin.k.b(r30)
                r3 = r30
                r5 = r0
                goto L_0x0253
            L_0x00cf:
                boolean r2 = r0.f36036k
                java.lang.Object r7 = r0.f36032g
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f36031f
                com.sumsub.sns.internal.core.data.model.n r8 = (com.sumsub.sns.internal.core.data.model.n) r8
                java.lang.Object r9 = r0.f36030e
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r10 = r0.f36029d
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r10
                java.lang.Object r11 = r0.f36028c
                java.util.Map r11 = (java.util.Map) r11
                java.lang.Object r12 = r0.f36027b
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
                kotlin.k.b(r30)
                r14 = r30
                r5 = r0
                goto L_0x01fc
            L_0x00f5:
                boolean r2 = r0.f36036k
                java.lang.Object r7 = r0.f36032g
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f36031f
                com.sumsub.sns.internal.core.data.model.n r8 = (com.sumsub.sns.internal.core.data.model.n) r8
                java.lang.Object r9 = r0.f36030e
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r10 = r0.f36029d
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r10
                java.lang.Object r11 = r0.f36028c
                java.util.Map r11 = (java.util.Map) r11
                java.lang.Object r12 = r0.f36027b
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f36026a
                kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
                kotlin.k.b(r30)
                r14 = r30
                r5 = r0
                goto L_0x01d1
            L_0x011b:
                kotlin.k.b(r30)
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r0.f36040o
                java.util.Map r7 = r7.E()
                java.util.Map r7 = kotlin.collections.MapsKt__MapsKt.y(r7)
                r2.element = r7
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = r0.f36040o
                java.util.Map r7 = r7.E()
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L_0x0142
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>()
                r2.element = r7
            L_0x0142:
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>()
                java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
                r8.<init>()
                java.util.List<com.sumsub.sns.internal.core.data.model.n> r9 = r0.f36041p
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10 = r0.f36040o
                java.util.Iterator r9 = r9.iterator()
                r13 = r2
                r12 = r7
                r11 = r8
                r2 = r0
            L_0x0158:
                boolean r7 = r9.hasNext()
                if (r7 == 0) goto L_0x02d9
                java.lang.Object r7 = r9.next()
                r8 = r7
                com.sumsub.sns.internal.core.data.model.n r8 = (com.sumsub.sns.internal.core.data.model.n) r8
                java.io.File r7 = r8.k()
                if (r7 == 0) goto L_0x0170
                java.lang.String r7 = com.sumsub.sns.internal.core.common.m0.a(r7)
                goto L_0x0171
            L_0x0170:
                r7 = r6
            L_0x0171:
                com.sumsub.sns.internal.camera.photo.presentation.document.b r14 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r5 = "processing "
                r15.append(r5)
                java.io.File r5 = r8.m()
                if (r5 == 0) goto L_0x0188
                java.lang.String r5 = r5.getName()
                goto L_0x0189
            L_0x0188:
                r5 = r6
            L_0x0189:
                r15.append(r5)
                java.lang.String r5 = ", mimeType="
                r15.append(r5)
                r15.append(r7)
                java.lang.String r16 = r15.toString()
                r17 = 0
                r18 = 4
                r19 = 0
                java.lang.String r15 = "DocCapture"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r14, r15, r16, r17, r18, r19)
                java.lang.String r5 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b((com.sumsub.sns.internal.core.data.model.n) r8)
                if (r5 != 0) goto L_0x01aa
                goto L_0x0158
            L_0x01aa:
                java.lang.String r14 = "application/pdf"
                boolean r7 = kotlin.jvm.internal.x.b(r7, r14)
                if (r7 == 0) goto L_0x01dc
                r2.f36026a = r13
                r2.f36027b = r12
                r2.f36028c = r11
                r2.f36029d = r10
                r2.f36030e = r9
                r2.f36031f = r8
                r2.f36032g = r5
                r2.f36036k = r7
                r2.f36039n = r4
                java.lang.Object r14 = r10.b((com.sumsub.sns.internal.core.data.model.n) r8, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r2)
                if (r14 != r1) goto L_0x01cb
                return r1
            L_0x01cb:
                r28 = r5
                r5 = r2
                r2 = r7
                r7 = r28
            L_0x01d1:
                android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14
            L_0x01d3:
                r28 = r11
                r11 = r8
                r8 = r14
                r14 = r13
                r13 = r12
                r12 = r28
                goto L_0x01ff
            L_0x01dc:
                r2.f36026a = r13
                r2.f36027b = r12
                r2.f36028c = r11
                r2.f36029d = r10
                r2.f36030e = r9
                r2.f36031f = r8
                r2.f36032g = r5
                r2.f36036k = r7
                r14 = 2
                r2.f36039n = r14
                java.lang.Object r14 = r10.a((com.sumsub.sns.internal.core.data.model.n) r8, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r2)
                if (r14 != r1) goto L_0x01f6
                return r1
            L_0x01f6:
                r28 = r5
                r5 = r2
                r2 = r7
                r7 = r28
            L_0x01fc:
                android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14
                goto L_0x01d3
            L_0x01ff:
                if (r8 != 0) goto L_0x0211
                com.sumsub.sns.internal.camera.photo.presentation.document.b r20 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                r23 = 0
                r24 = 4
                r25 = 0
                java.lang.String r21 = "DocCapture"
                java.lang.String r22 = "bitmap null"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r20, r21, r22, r23, r24, r25)
                goto L_0x0216
            L_0x0211:
                r13.put(r7, r8)
                if (r2 == 0) goto L_0x021c
            L_0x0216:
                r2 = r5
                r11 = r12
                r12 = r13
                r13 = r14
                goto L_0x0158
            L_0x021c:
                T r2 = r14.element
                java.util.Map r2 = (java.util.Map) r2
                boolean r2 = r2.containsKey(r7)
                if (r2 != 0) goto L_0x026a
                T r2 = r14.element
                java.util.Map r2 = (java.util.Map) r2
                com.sumsub.sns.internal.core.common.o0 r15 = r10.F
                r5.f36026a = r14
                r5.f36027b = r13
                r5.f36028c = r12
                r5.f36029d = r10
                r5.f36030e = r9
                r5.f36031f = r11
                r5.f36032g = r7
                r5.f36033h = r8
                r5.f36034i = r7
                r5.f36035j = r2
                r3 = 3
                r5.f36039n = r3
                java.lang.Object r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b(r15, r8, r5)
                if (r3 != r1) goto L_0x024c
                return r1
            L_0x024c:
                r15 = r14
                r14 = r13
                r13 = r12
                r12 = r10
                r10 = r11
                r11 = r9
                r9 = r7
            L_0x0253:
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b r4 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b
                r4.<init>(r3)
                r2.put(r7, r4)
                r3 = r8
                r2 = r9
                r7 = r10
                r8 = r11
                r9 = r12
                r10 = r13
                r11 = r14
                r12 = r15
                goto L_0x0272
            L_0x026a:
                r2 = r7
                r3 = r8
                r8 = r9
                r9 = r10
                r7 = r11
                r10 = r12
                r11 = r13
                r12 = r14
            L_0x0272:
                com.sumsub.sns.internal.ml.badphotos.models.b r4 = r7.l()
                com.sumsub.sns.internal.core.data.model.IdentitySide r13 = r7.o()
                if (r13 != 0) goto L_0x0280
                com.sumsub.sns.internal.core.data.model.IdentitySide r13 = r9.J()
            L_0x0280:
                r5.f36026a = r12
                r5.f36027b = r11
                r5.f36028c = r10
                r5.f36029d = r9
                r5.f36030e = r8
                r5.f36031f = r7
                r5.f36032g = r2
                r5.f36033h = r6
                r5.f36034i = r6
                r5.f36035j = r6
                r14 = 4
                r5.f36039n = r14
                java.lang.Object r3 = r9.a((android.graphics.Bitmap) r3, (com.sumsub.sns.internal.ml.badphotos.models.b) r4, (com.sumsub.sns.internal.core.data.model.IdentitySide) r13, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.core.e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>) r5)
                if (r3 != r1) goto L_0x0098
                return r1
            L_0x029e:
                com.sumsub.sns.internal.ml.core.e$a r3 = (com.sumsub.sns.internal.ml.core.e.a) r3
                r11.put(r2, r3)
                com.sumsub.sns.internal.camera.photo.presentation.document.b r20 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Photo quality for "
                r2.append(r4)
                java.io.File r4 = r7.m()
                if (r4 == 0) goto L_0x02ba
                java.lang.String r4 = r4.getName()
                goto L_0x02bb
            L_0x02ba:
                r4 = r6
            L_0x02bb:
                r2.append(r4)
                java.lang.String r4 = " -> "
                r2.append(r4)
                r2.append(r3)
                java.lang.String r22 = r2.toString()
                r23 = 0
                r24 = 4
                r25 = 0
                java.lang.String r21 = "DocCapture"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r20, r21, r22, r23, r24, r25)
                r2 = r5
                r4 = 1
                goto L_0x0158
            L_0x02d9:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = r2.f36040o
                T r4 = r13.element
                java.util.Map r4 = (java.util.Map) r4
                java.util.Map r4 = okhttp3.internal.Util.toImmutableMap(r4)
                r3.d((java.util.Map<java.lang.String, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b>) r4)
                boolean r3 = r12.isEmpty()
                r4 = 1
                r3 = r3 ^ r4
                if (r3 == 0) goto L_0x0450
                java.util.List<com.sumsub.sns.internal.core.data.model.n> r3 = r2.f36041p
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Iterator r3 = r3.iterator()
            L_0x02f9:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L_0x0315
                java.lang.Object r5 = r3.next()
                r7 = r5
                com.sumsub.sns.internal.core.data.model.n r7 = (com.sumsub.sns.internal.core.data.model.n) r7
                java.io.File r7 = r7.m()
                if (r7 == 0) goto L_0x030e
                r7 = 1
                goto L_0x030f
            L_0x030e:
                r7 = 0
            L_0x030f:
                if (r7 == 0) goto L_0x02f9
                r4.add(r5)
                goto L_0x02f9
            L_0x0315:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = r2.f36040o
                java.util.ArrayList r5 = new java.util.ArrayList
                r7 = 10
                int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r4, r7)
                r5.<init>(r8)
                java.util.Iterator r7 = r4.iterator()
                r9 = r3
                r10 = r4
                r3 = r2
                r2 = r5
            L_0x032a:
                boolean r4 = r7.hasNext()
                java.lang.String r5 = ""
                if (r4 == 0) goto L_0x039a
                java.lang.Object r4 = r7.next()
                com.sumsub.sns.internal.core.data.model.n r4 = (com.sumsub.sns.internal.core.data.model.n) r4
                java.io.File r8 = r4.m()
                if (r8 == 0) goto L_0x0343
                java.lang.String r8 = r8.getAbsolutePath()
                goto L_0x0344
            L_0x0343:
                r8 = r6
            L_0x0344:
                if (r8 != 0) goto L_0x0347
                goto L_0x0348
            L_0x0347:
                r5 = r8
            L_0x0348:
                java.lang.Object r5 = r11.get(r5)
                com.sumsub.sns.internal.ml.core.e$a r5 = (com.sumsub.sns.internal.ml.core.e.a) r5
                if (r5 == 0) goto L_0x0378
                com.sumsub.sns.internal.core.data.model.IdentitySide r4 = r4.o()
                if (r4 != 0) goto L_0x0358
                com.sumsub.sns.internal.core.data.model.IdentitySide r4 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            L_0x0358:
                r3.f36026a = r13
                r3.f36027b = r12
                r3.f36028c = r11
                r3.f36029d = r10
                r3.f36030e = r9
                r3.f36031f = r2
                r3.f36032g = r7
                r3.f36033h = r2
                r8 = 5
                r3.f36039n = r8
                java.lang.Object r4 = r9.a((com.sumsub.sns.internal.core.data.model.IdentitySide) r4, (com.sumsub.sns.internal.ml.core.e.a<com.sumsub.sns.internal.ml.badphotos.models.a>) r5, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r3)
                if (r4 != r1) goto L_0x0372
                return r1
            L_0x0372:
                r8 = r2
            L_0x0373:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4
                if (r4 != 0) goto L_0x0395
                goto L_0x0379
            L_0x0378:
                r8 = r2
            L_0x0379:
                r3.f36026a = r13
                r3.f36027b = r12
                r3.f36028c = r11
                r3.f36029d = r10
                r3.f36030e = r9
                r3.f36031f = r8
                r3.f36032g = r7
                r3.f36033h = r2
                r4 = 6
                r3.f36039n = r4
                java.lang.Object r4 = r9.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r3)
                if (r4 != r1) goto L_0x0393
                return r1
            L_0x0393:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4
            L_0x0395:
                r2.add(r4)
                r2 = r8
                goto L_0x032a
            L_0x039a:
                java.util.List r2 = (java.util.List) r2
                java.util.Iterator r1 = r2.iterator()
            L_0x03a0:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x03bb
                java.lang.Object r4 = r1.next()
                r7 = r4
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r7
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r7 = r7.l()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r8 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.BLOCKING
                if (r7 != r8) goto L_0x03b7
                r7 = 1
                goto L_0x03b8
            L_0x03b7:
                r7 = 0
            L_0x03b8:
                if (r7 == 0) goto L_0x03a0
                goto L_0x03bc
            L_0x03bb:
                r4 = r6
            L_0x03bc:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4
                if (r4 != 0) goto L_0x03eb
                java.util.Iterator r1 = r2.iterator()
            L_0x03c4:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x03df
                java.lang.Object r4 = r1.next()
                r7 = r4
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r7
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r7 = r7.l()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r8 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.WARNING
                if (r7 != r8) goto L_0x03db
                r7 = 1
                goto L_0x03dc
            L_0x03db:
                r7 = 0
            L_0x03dc:
                if (r7 == 0) goto L_0x03c4
                goto L_0x03e0
            L_0x03df:
                r4 = r6
            L_0x03e0:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4
                if (r4 != 0) goto L_0x03eb
                java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r2)
                r4 = r1
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r4
            L_0x03eb:
                r25 = r4
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt__IterablesKt.u(r10, r2)
                r1.<init>(r2)
                java.util.Iterator r2 = r10.iterator()
            L_0x03fc:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x043c
                java.lang.Object r4 = r2.next()
                com.sumsub.sns.internal.core.data.model.n r4 = (com.sumsub.sns.internal.core.data.model.n) r4
                java.lang.String r7 = com.sumsub.sns.internal.presentation.screen.preview.photo.a.b((com.sumsub.sns.internal.core.data.model.n) r4)
                if (r7 != 0) goto L_0x040f
                r7 = r5
            L_0x040f:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d r8 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d
                java.lang.Object r9 = r12.get(r7)
                android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
                java.io.File r4 = r4.m()
                T r10 = r13.element
                java.util.Map r10 = (java.util.Map) r10
                java.lang.Object r10 = r10.get(r7)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b r10 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b) r10
                if (r10 == 0) goto L_0x042c
                int r10 = r10.b()
                goto L_0x042d
            L_0x042c:
                r10 = 0
            L_0x042d:
                T r11 = r13.element
                java.util.Map r11 = (java.util.Map) r11
                boolean r7 = r11.containsKey(r7)
                r8.<init>(r9, r4, r10, r7)
                r1.add(r8)
                goto L_0x03fc
            L_0x043c:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g
                r22 = 0
                r23 = 1
                r24 = 0
                r26 = 10
                r27 = 0
                r20 = r2
                r21 = r1
                r20.<init>(r21, r22, r23, r24, r25, r26, r27)
                goto L_0x04b7
            L_0x0450:
                java.util.List<com.sumsub.sns.internal.core.data.model.n> r3 = r2.f36041p
                java.util.ArrayList r4 = new java.util.ArrayList
                r5 = 10
                int r5 = kotlin.collections.CollectionsKt__IterablesKt.u(r3, r5)
                r4.<init>(r5)
                java.util.Iterator r3 = r3.iterator()
            L_0x0461:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L_0x047b
                java.lang.Object r5 = r3.next()
                com.sumsub.sns.internal.core.data.model.n r5 = (com.sumsub.sns.internal.core.data.model.n) r5
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d
                java.io.File r5 = r5.k()
                r8 = 0
                r7.<init>(r6, r5, r8, r8)
                r4.add(r7)
                goto L_0x0461
            L_0x047b:
                r8 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = r2.f36040o
                r2.f36026a = r4
                r2.f36027b = r6
                r2.f36028c = r6
                r2.f36029d = r6
                r2.f36030e = r6
                r2.f36031f = r6
                r2.f36032g = r6
                r2.f36037l = r8
                r2.f36038m = r8
                r5 = 7
                r2.f36039n = r5
                java.lang.Object r3 = r3.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r2)
                if (r3 != r1) goto L_0x049a
                return r1
            L_0x049a:
                r8 = r4
                r1 = 0
                r4 = r2
                r2 = 0
            L_0x049e:
                r9 = 0
                r12 = r3
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r12 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r12
                r13 = 10
                r14 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g
                if (r2 == 0) goto L_0x04ab
                r10 = 1
                goto L_0x04ac
            L_0x04ab:
                r10 = 0
            L_0x04ac:
                if (r1 == 0) goto L_0x04b0
                r11 = 1
                goto L_0x04b1
            L_0x04b0:
                r11 = 0
            L_0x04b1:
                r7 = r3
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                r2 = r3
                r3 = r4
            L_0x04b7:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r1 = r3.f36040o
                r4 = 0
                r1.b((boolean) r4)
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r1 = r3.f36040o
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$s0$a r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$s0$a
                r3.<init>(r2, r6)
                r2 = 1
                com.sumsub.sns.core.presentation.base.a.a(r1, r4, r3, r2, r6)
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.s0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {861, 862, 865, 869}, m = "getContent")
    public static final class t extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36044a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36045b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36046c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36047d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36049f;

        /* renamed from: g  reason: collision with root package name */
        public int f36050g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super t> cVar) {
            super(cVar);
            this.f36049f = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36048e = obj;
            this.f36050g |= Integer.MIN_VALUE;
            return this.f36049f.e((kotlin.coroutines.c<? super Content>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {300, 301, 302}, m = "showSecondSidePrompt")
    public static final class t0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36051a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36052b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36053c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36055e;

        /* renamed from: f  reason: collision with root package name */
        public int f36056f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super t0> cVar) {
            super(cVar);
            this.f36055e = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36054d = obj;
            this.f36056f |= Integer.MIN_VALUE;
            return this.f36055e.i((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {879, 885, 886, 893, 899, 909, 913}, m = "getContent")
    public static final class u extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36057a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36058b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36059c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36060d;

        /* renamed from: e  reason: collision with root package name */
        public float f36061e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f36062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36063g;

        /* renamed from: h  reason: collision with root package name */
        public int f36064h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super u> cVar) {
            super(cVar);
            this.f36063g = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36062f = obj;
            this.f36064h |= Integer.MIN_VALUE;
            return this.f36063g.a((IdentitySide) null, (e.a<com.sumsub.sns.internal.ml.badphotos.models.a>) null, (kotlin.coroutines.c<? super Content>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showUploadingState$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {676}, m = "invokeSuspend")
    public static final class u0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36065a;

        /* renamed from: b  reason: collision with root package name */
        public int f36066b;

        /* renamed from: c  reason: collision with root package name */
        public int f36067c;

        /* renamed from: d  reason: collision with root package name */
        public int f36068d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36069e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36070f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super u0> cVar) {
            super(2, cVar);
            this.f36070f = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((u0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            u0 u0Var = new u0(this.f36070f, cVar);
            u0Var.f36069e = obj;
            return u0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36068d
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x002a
                if (r2 != r3) goto L_0x0022
                int r1 = r0.f36067c
                int r2 = r0.f36066b
                java.lang.Object r3 = r0.f36065a
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r3
                java.lang.Object r5 = r0.f36069e
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r5
                kotlin.k.b(r17)
                r15 = r5
                r5 = r3
                r3 = r17
                goto L_0x0051
            L_0x0022:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002a:
                kotlin.k.b(r17)
                java.lang.Object r2 = r0.f36069e
                r5 = r2
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r5
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r2 = r5.f()
                if (r2 == 0) goto L_0x006e
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r6 = r0.f36070f
                r0.f36069e = r5
                r0.f36065a = r2
                r0.f36066b = r4
                r0.f36067c = r4
                r0.f36068d = r3
                java.lang.String r3 = "sns_preview_uploading_title"
                java.lang.Object r3 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r3 != r1) goto L_0x004d
                return r1
            L_0x004d:
                r1 = r4
                r15 = r5
                r5 = r2
                r2 = r1
            L_0x0051:
                r11 = 0
                r10 = 0
                r9 = 0
                r8 = 0
                r7 = 0
                r6 = 0
                java.lang.String r3 = (java.lang.String) r3
                if (r3 != 0) goto L_0x005d
                java.lang.String r3 = " "
            L_0x005d:
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r12 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b
                r12.<init>(r3, r4)
                r13 = 63
                r14 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r3 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                r10 = r1
                r9 = r2
                r11 = r3
                r6 = r15
                goto L_0x0073
            L_0x006e:
                r3 = 0
                r11 = r3
                r9 = r4
                r10 = r9
                r6 = r5
            L_0x0073:
                r7 = 0
                r8 = 0
                r12 = 15
                r13 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g.a(r6, r7, r8, r9, r10, r11, r12, r13)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.u0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {1097}, m = "idDocList")
    public static final class v extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36071a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36072b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36073c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36074d;

        /* renamed from: e  reason: collision with root package name */
        public int f36075e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super v> cVar) {
            super(cVar);
            this.f36074d = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36073c = obj;
            this.f36075e |= Integer.MIN_VALUE;
            return this.f36074d.b((String) null, (kotlin.coroutines.c<? super List<String>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$updateLoadingProgress$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class v0 extends SuspendLambda implements d10.p<g, kotlin.coroutines.c<? super g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36076a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36077b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f36078c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(int i11, kotlin.coroutines.c<? super v0> cVar) {
            super(2, cVar);
            this.f36078c = i11;
        }

        /* renamed from: a */
        public final Object invoke(g gVar, kotlin.coroutines.c<? super g> cVar) {
            return ((v0) create(gVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            v0 v0Var = new v0(this.f36078c, cVar);
            v0Var.f36077b = obj;
            return v0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content} */
        /* JADX WARNING: type inference failed for: r1v9, types: [com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r0.f36076a
                if (r1 != 0) goto L_0x0046
                kotlin.k.b(r18)
                java.lang.Object r1 = r0.f36077b
                r2 = r1
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g) r2
                r3 = 0
                r4 = 0
                r5 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r7 = r2.f()
                r1 = 0
                if (r7 == 0) goto L_0x003b
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r14 = r2.f()
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r14 = r14.k()
                if (r14 == 0) goto L_0x0032
                int r15 = r0.f36078c
                r6 = 1
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$b r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.b.a(r14, r1, r15, r6, r1)
            L_0x0032:
                r14 = r1
                r15 = 63
                r16 = 0
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            L_0x003b:
                r7 = r1
                r8 = 15
                r9 = 0
                r1 = 0
                r6 = r1
                com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g.a(r2, r3, r4, r5, r6, r7, r8, r9)
                return r1
            L_0x0046:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.v0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDataIsReadableClicked$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {257, 263}, m = "invokeSuspend")
    public static final class w extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36079a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36080b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super w> cVar) {
            super(2, cVar);
            this.f36080b = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((w) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new w(this.f36080b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36079a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSEventHandler eventHandler = com.sumsub.sns.internal.core.common.e0.f32018a.getEventHandler();
                if (eventHandler != null) {
                    eventHandler.onEvent(new SNSEvent.PhotoAccepted(this.f36080b.u().getType().c()));
                }
                this.f36080b.A();
                com.sumsub.sns.internal.core.data.source.dynamic.b e11 = this.f36080b.t();
                this.f36079a = 1;
                obj = com.sumsub.sns.internal.core.data.source.dynamic.h.i(e11, false, this, 1, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                kotlin.k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.data.model.g gVar = (com.sumsub.sns.internal.core.data.model.g) ((com.sumsub.sns.internal.core.data.source.dynamic.e) obj).d();
            g.c.a a11 = gVar != null ? gVar.a(this.f36080b.u().getType()) : null;
            if (!(a11 != null && a11.w())) {
                if (!(a11 != null && a11.v())) {
                    com.sumsub.sns.internal.core.data.model.l b11 = this.f36080b.C();
                    if (b11 != null && b11.d()) {
                        this.f36080b.N();
                    } else if (this.f36080b.J() == IdentitySide.Front) {
                        SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f36080b;
                        this.f36079a = 2;
                        if (SNSPreviewPhotoDocumentViewModel.b(sNSPreviewPhotoDocumentViewModel, false, this, 1, (Object) null) == d11) {
                            return d11;
                        }
                    } else if (this.f36080b.J() == IdentitySide.Back) {
                        this.f36080b.N();
                    }
                    return Unit.f56620a;
                }
            }
            this.f36080b.N();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {200}, m = "updateSeamlessMode")
    public static final class w0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36081a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36082b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36083c;

        /* renamed from: d  reason: collision with root package name */
        public int f36084d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super w0> cVar) {
            super(cVar);
            this.f36083c = sNSPreviewPhotoDocumentViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36082b = obj;
            this.f36084d |= Integer.MIN_VALUE;
            return this.f36083c.j((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class x extends Lambda implements d10.l<com.sumsub.sns.internal.core.data.model.n, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.n f36085a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(com.sumsub.sns.internal.core.data.model.n nVar) {
            super(1);
            this.f36085a = nVar;
        }

        /* renamed from: a */
        public final Boolean invoke(com.sumsub.sns.internal.core.data.model.n nVar) {
            return Boolean.valueOf(nVar.o() == this.f36085a.o());
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentSideAnswerClicked$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {235}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36087b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super y> cVar) {
            super(2, cVar);
            this.f36087b = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((y) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new y(this.f36087b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36086a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f36087b;
                this.f36086a = 1;
                if (sNSPreviewPhotoDocumentViewModel.c(false, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsPicked$1", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class z extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36088a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.l f36089b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f36090c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(com.sumsub.sns.internal.core.data.model.l lVar, SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c<? super z> cVar) {
            super(2, cVar);
            this.f36089b = lVar;
            this.f36090c = sNSPreviewPhotoDocumentViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((z) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new z(this.f36089b, this.f36090c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36088a == 0) {
                kotlin.k.b(obj);
                for (com.sumsub.sns.internal.core.data.model.n nVar : this.f36089b.c()) {
                    com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
                    com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "result: " + nVar, (Throwable) null, 4, (Object) null);
                }
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.f36090c;
                List<com.sumsub.sns.internal.core.data.model.n> c11 = this.f36089b.c();
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel2 = this.f36090c;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(c11, 10));
                for (com.sumsub.sns.internal.core.data.model.n nVar2 : c11) {
                    String i11 = sNSPreviewPhotoDocumentViewModel2.v();
                    if (!(!kotlin.jvm.internal.x.b(nVar2.p(), DocCapture.f31491b))) {
                        i11 = null;
                    }
                    arrayList.add(com.sumsub.sns.internal.core.data.model.n.a(nVar2, (File) null, (File) null, (String) null, i11 == null ? DocCapture.f31491b : i11, (IdentitySide) null, false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (n.b) null, false, 503, (Object) null));
                }
                sNSPreviewPhotoDocumentViewModel.a((List<com.sumsub.sns.internal.core.data.model.n>) arrayList);
                this.f36090c.b(IdentitySide.Front);
                this.f36090c.c(this.f36089b.c());
                SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel3 = this.f36090c;
                List<com.sumsub.sns.internal.core.data.model.n> G = sNSPreviewPhotoDocumentViewModel3.G();
                ArrayList arrayList2 = new ArrayList();
                for (T next : G) {
                    if (!kotlin.jvm.internal.x.b(((com.sumsub.sns.internal.core.data.model.n) next).p(), DocCapture.f31491b)) {
                        arrayList2.add(next);
                    }
                }
                sNSPreviewPhotoDocumentViewModel3.b((List<com.sumsub.sns.internal.core.data.model.n>) arrayList2);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Class<SNSPreviewPhotoDocumentViewModel> cls = SNSPreviewPhotoDocumentViewModel.class;
        P = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "side", "getSide()Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "compositePickerResults", "getCompositePickerResults()Lcom/sumsub/sns/internal/core/data/model/CompositeDocumentPickerResult;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "pickerResults", "getPickerResults()Ljava/util/List;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "showPhotoPickerOnStart", "getShowPhotoPickerOnStart()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "checkPhotoQualityResultMap", "getCheckPhotoQualityResultMap()Ljava/util/Map;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "documentProperties", "getDocumentProperties()Ljava/util/Map;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "isSeamlessMode", "isSeamlessMode()Z", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewPhotoDocumentViewModel(Document document, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.data.source.extensions.a aVar2, com.sumsub.sns.internal.domain.o oVar, com.sumsub.sns.internal.core.common.o0 o0Var, com.sumsub.sns.internal.ml.core.e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> eVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(document, savedStateHandle, aVar, bVar, dVar);
        SavedStateHandle savedStateHandle2 = savedStateHandle;
        this.D = aVar2;
        this.E = oVar;
        this.F = o0Var;
        this.G = eVar;
        IdentitySide identitySide = IdentitySide.Front;
        this.H = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, T, identitySide);
        this.I = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, S, null);
        this.J = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, R, CollectionsKt__CollectionsKt.k());
        this.K = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "showPhotoPickerOnStart", Boolean.TRUE);
        this.L = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "analyticsPayload", MapsKt__MapsJVMKt.e(kotlin.l.a(identitySide.getValue(), new com.sumsub.sns.internal.ml.badphotos.models.b((String) null, (String) null, (Float) null, (Long) null, (Float) null, (Float) null, (Integer) null, (Integer) null, (Boolean) null, 511, (kotlin.jvm.internal.r) null))));
        this.M = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "documentProperties", MapsKt__MapsKt.h());
        this.N = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "isSeamlessMode", Boolean.FALSE);
    }

    public final void A() {
        List<com.sumsub.sns.internal.core.data.model.n> G2 = G();
        ArrayList arrayList = new ArrayList();
        for (T next : G2) {
            if (a.b((com.sumsub.sns.internal.core.data.model.n) next) != null) {
                arrayList.add(next);
            }
        }
        ArrayList<com.sumsub.sns.internal.core.data.model.n> arrayList2 = new ArrayList<>();
        for (Object next2 : arrayList) {
            Map<String, b> E2 = E();
            String a11 = a.b((com.sumsub.sns.internal.core.data.model.n) next2);
            if (a11 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            } else if (E2.containsKey(a11)) {
                arrayList2.add(next2);
            }
        }
        for (com.sumsub.sns.internal.core.data.model.n nVar : arrayList2) {
            Map<String, b> E3 = E();
            String a12 = a.b(nVar);
            if (a12 != null) {
                b bVar = E3.get(a12);
                if (bVar != null) {
                    a(nVar, bVar.b());
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
    }

    public final Map<String, com.sumsub.sns.internal.ml.badphotos.models.b> B() {
        return (Map) this.L.a(this, P[4]);
    }

    public final com.sumsub.sns.internal.core.data.model.l C() {
        return (com.sumsub.sns.internal.core.data.model.l) this.I.a(this, P[1]);
    }

    /* renamed from: D */
    public g e() {
        return new g((List) null, (k) null, false, false, (Content) null, 31, (kotlin.jvm.internal.r) null);
    }

    public final Map<String, b> E() {
        return (Map) this.M.a(this, P[5]);
    }

    public final Map<String, Object> F() {
        Map a11;
        Map<String, Object> y11;
        T t11;
        T t12;
        boolean z11;
        n.b q11;
        Map a12;
        IdentitySide J2 = J();
        if (K()) {
            J2 = IdentitySide.Front;
        }
        com.sumsub.sns.internal.ml.badphotos.models.b bVar = B().get(J2.getValue());
        if (bVar == null || (a11 = a.b(bVar)) == null || (y11 = MapsKt__MapsKt.y(a11)) == null) {
            return MapsKt__MapsKt.h();
        }
        com.sumsub.sns.internal.core.data.model.l C = C();
        boolean z12 = false;
        y11.put("isSeamless", Boolean.valueOf(C != null && C.d()));
        com.sumsub.sns.internal.ml.badphotos.models.b bVar2 = B().get(IdentitySide.Back.getValue());
        if (bVar2 != null) {
            y11.put(n0.j.a.f32230k, a.b(bVar2));
        }
        Iterator<T> it2 = G().iterator();
        while (true) {
            t11 = null;
            if (!it2.hasNext()) {
                t12 = null;
                break;
            }
            t12 = it2.next();
            if (((com.sumsub.sns.internal.core.data.model.n) t12).t()) {
                break;
            }
        }
        com.sumsub.sns.internal.core.data.model.n nVar = (com.sumsub.sns.internal.core.data.model.n) t12;
        if (!(nVar == null || (q11 = nVar.q()) == null || (a12 = a.b(q11)) == null)) {
            y11.put(Q, a12);
        }
        Iterator<T> it3 = G().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            T next = it3.next();
            if (((com.sumsub.sns.internal.core.data.model.n) next).o() == J2) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                t11 = next;
                break;
            }
        }
        com.sumsub.sns.internal.core.data.model.n nVar2 = (com.sumsub.sns.internal.core.data.model.n) t11;
        if (nVar2 != null && nVar2.s()) {
            z12 = true;
        }
        y11.put("isFromGallery", Boolean.valueOf(z12));
        return y11;
    }

    public final List<com.sumsub.sns.internal.core.data.model.n> G() {
        return (List) this.J.a(this, P[2]);
    }

    public final boolean H() {
        com.sumsub.sns.internal.core.data.model.e d11 = d();
        if (d11 != null) {
            return com.sumsub.sns.internal.core.data.model.f.d(d11, u().getType().c());
        }
        return false;
    }

    public final boolean I() {
        return ((Boolean) this.K.a(this, P[3])).booleanValue();
    }

    public final IdentitySide J() {
        return (IdentitySide) this.H.a(this, P[0]);
    }

    public final boolean K() {
        return ((Boolean) this.N.a(this, P[6])).booleanValue();
    }

    public final void L() {
        Q();
    }

    public void M() {
        R();
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h0(this, (kotlin.coroutines.c<? super h0>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0134 A[EDGE_INSN: B:80:0x0134->B:66:0x0134 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N() {
        /*
            r19 = this;
            r6 = r19
            com.sumsub.sns.internal.camera.photo.presentation.document.b r0 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.String r1 = "DocCapture"
            java.lang.String r2 = "onUploadDocuments"
            r3 = 0
            r4 = 4
            r5 = 0
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r0, r1, r2, r3, r4, r5)
            r19.S()
            java.util.List r0 = r19.G()
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0030
            com.sumsub.sns.internal.core.common.q$b r2 = new com.sumsub.sns.internal.core.common.q$b
            r2.<init>(r1)
            r3 = 0
            r4 = 0
            r5 = 6
            r7 = 0
            r0 = r19
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (com.sumsub.sns.internal.core.common.q) r1, (java.lang.Object) r2, (java.lang.Long) r3, (int) r4, (java.lang.Object) r5)
            return
        L_0x0030:
            java.util.List r0 = r19.G()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x003d:
            boolean r3 = r0.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r0.next()
            r5 = r3
            com.sumsub.sns.internal.core.data.model.n r5 = (com.sumsub.sns.internal.core.data.model.n) r5
            boolean r5 = r5.t()
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x003d
            r2.add(r3)
            goto L_0x003d
        L_0x0056:
            int r0 = r2.size()
            if (r0 != r4) goto L_0x005e
            r0 = r4
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            if (r0 == 0) goto L_0x00cd
            java.util.List r0 = r19.G()
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0070
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0070
            goto L_0x008d
        L_0x0070:
            java.util.Iterator r0 = r0.iterator()
        L_0x0074:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r0.next()
            com.sumsub.sns.internal.core.data.model.n r2 = (com.sumsub.sns.internal.core.data.model.n) r2
            com.sumsub.sns.internal.core.data.model.IdentitySide r2 = r2.o()
            if (r2 == 0) goto L_0x0088
            r2 = r4
            goto L_0x0089
        L_0x0088:
            r2 = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0074
            r0 = r4
            goto L_0x008e
        L_0x008d:
            r0 = r1
        L_0x008e:
            if (r0 == 0) goto L_0x00cd
            java.util.List r0 = r19.G()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.u(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x00a3:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00c6
            java.lang.Object r3 = r0.next()
            r7 = r3
            com.sumsub.sns.internal.core.data.model.n r7 = (com.sumsub.sns.internal.core.data.model.n) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 495(0x1ef, float:6.94E-43)
            r18 = 0
            com.sumsub.sns.internal.core.data.model.n r3 = com.sumsub.sns.internal.core.data.model.n.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r2.add(r3)
            goto L_0x00a3
        L_0x00c6:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r2)
            r6.a((java.util.List<com.sumsub.sns.internal.core.data.model.n>) r0)
        L_0x00cd:
            boolean r0 = r19.K()
            if (r0 == 0) goto L_0x0100
            java.util.List r0 = r19.G()
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x00e2
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x00e2
            goto L_0x00fa
        L_0x00e2:
            java.util.Iterator r0 = r0.iterator()
        L_0x00e6:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00fa
            java.lang.Object r2 = r0.next()
            com.sumsub.sns.internal.core.data.model.n r2 = (com.sumsub.sns.internal.core.data.model.n) r2
            boolean r2 = r2.t()
            if (r2 == 0) goto L_0x00e6
            r0 = r1
            goto L_0x00fb
        L_0x00fa:
            r0 = r4
        L_0x00fb:
            if (r0 == 0) goto L_0x00fe
            goto L_0x0100
        L_0x00fe:
            r0 = r1
            goto L_0x0101
        L_0x0100:
            r0 = r4
        L_0x0101:
            java.util.List r2 = r19.G()
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0110
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0110
            goto L_0x0134
        L_0x0110:
            java.util.Iterator r2 = r2.iterator()
        L_0x0114:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0134
            java.lang.Object r3 = r2.next()
            com.sumsub.sns.internal.core.data.model.n r3 = (com.sumsub.sns.internal.core.data.model.n) r3
            boolean r5 = r3.n()
            if (r5 == 0) goto L_0x0130
            com.sumsub.sns.internal.core.data.model.IdentitySide r3 = r3.o()
            com.sumsub.sns.internal.core.data.model.IdentitySide r5 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            if (r3 != r5) goto L_0x0130
            r3 = r4
            goto L_0x0131
        L_0x0130:
            r3 = r1
        L_0x0131:
            if (r3 == 0) goto L_0x0114
            r1 = r4
        L_0x0134:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r7 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "uploading docs, parallel="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.h0 r13 = androidx.lifecycle.m0.a(r19)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$j0 r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$j0
            r3 = 0
            r2.<init>(r6, r0, r1, r3)
            r14 = 0
            r15 = 0
            r17 = 3
            r18 = 0
            r16 = r2
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.N():void");
    }

    public void O() {
        M();
    }

    public final void P() {
        a(u());
    }

    public final void Q() {
        List<com.sumsub.sns.internal.core.data.model.n> G2 = G();
        ArrayList arrayList = new ArrayList();
        for (com.sumsub.sns.internal.core.data.model.n m11 : G2) {
            File m12 = m11.m();
            if (m12 != null) {
                arrayList.add(m12);
            }
        }
        if (!arrayList.isEmpty()) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "deleting " + arrayList.size() + " files", (Throwable) null, 4, (Object) null);
            n1 unused = kotlinx.coroutines.i.d(g1.f57277b, kotlinx.coroutines.v0.b(), (CoroutineStart) null, new n0(arrayList, (kotlin.coroutines.c<? super n0>) null), 2, (Object) null);
        }
    }

    public final void R() {
        a(IdentitySide.Front);
        List L0 = CollectionsKt___CollectionsKt.L0(G());
        L0.clear();
        a((List<com.sumsub.sns.internal.core.data.model.n>) L0);
    }

    public final void S() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new u0(this, (kotlin.coroutines.c<? super u0>) null), 1, (Object) null);
    }

    public Object a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
        return a(this, gVar, eVar, (kotlin.coroutines.c) cVar);
    }

    public Object b(boolean z11, kotlin.coroutines.c<? super Unit> cVar) {
        return a(this, z11, (kotlin.coroutines.c) cVar);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        return f(this, cVar);
    }

    public Object f(kotlin.coroutines.c<? super CharSequence> cVar) {
        return a("sns_preview_photo_title", (kotlin.coroutines.c<? super String>) cVar);
    }

    public void m() {
        if (!G().isEmpty()) {
            b(G());
        } else {
            super.m();
        }
    }

    public void p() {
        Q();
    }

    public void y() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "onDataIsReadableClicked", (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new w(this, (kotlin.coroutines.c<? super w>) null), 3, (Object) null);
    }

    public void z() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "onTakeAnotherDataClicked", (Throwable) null, 4, (Object) null);
        SNSEventHandler eventHandler = com.sumsub.sns.internal.core.common.e0.f32018a.getEventHandler();
        if (eventHandler != null) {
            eventHandler.onEvent(new SNSEvent.PhotoDeclined(u().getType().c()));
        }
        com.sumsub.sns.internal.core.data.model.l C = C();
        boolean z11 = true;
        if (C == null || !C.d()) {
            z11 = false;
        }
        if (z11) {
            a((List<com.sumsub.sns.internal.core.data.model.n>) CollectionsKt__CollectionsKt.k());
        }
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new i0(this, (kotlin.coroutines.c<? super i0>) null), 3, (Object) null);
    }

    public Object a(boolean z11, com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super f> cVar) {
        return a(this, z11, gVar, (kotlin.coroutines.c) cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r11 = r11.v();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.c<? super java.util.List<java.lang.String>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k0
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k0 r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.k0) r0
            int r1 = r0.f35967d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35967d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k0 r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$k0
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f35965b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35967d
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            java.lang.Object r0 = r0.f35964a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r0
            kotlin.k.b(r11)
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0037:
            kotlin.k.b(r11)
            com.sumsub.sns.internal.core.data.source.dynamic.b r11 = r10.t()
            r0.f35964a = r10
            r0.f35967d = r5
            java.lang.Object r11 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r11, r3, r0, r5, r4)
            if (r11 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r10
        L_0x004a:
            com.sumsub.sns.internal.core.data.source.dynamic.e r11 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r11
            java.lang.Object r11 = r11.d()
            com.sumsub.sns.internal.core.data.model.g r11 = (com.sumsub.sns.internal.core.data.model.g) r11
            if (r11 != 0) goto L_0x0071
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r1 = new com.sumsub.sns.internal.log.LoggerType[r5]
            com.sumsub.sns.internal.log.LoggerType r2 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r1[r3] = r2
            com.sumsub.log.logger.Logger r4 = r11.a((com.sumsub.sns.internal.log.LoggerType[]) r1)
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r0)
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "applicant null!"
            com.sumsub.log.logger.a.b(r4, r5, r6, r7, r8, r9)
            java.util.List r11 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            return r11
        L_0x0071:
            com.sumsub.sns.internal.core.data.model.Document r1 = r0.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
            java.util.List r11 = r11.b(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.u(r11, r2)
            r1.<init>(r2)
            java.util.Iterator r11 = r11.iterator()
        L_0x008c:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r11.next()
            com.sumsub.sns.internal.core.data.model.q r2 = (com.sumsub.sns.internal.core.data.model.q) r2
            java.lang.String r2 = r2.b()
            r1.add(r2)
            goto L_0x008c
        L_0x00a0:
            com.sumsub.sns.internal.core.data.model.e r11 = r0.d()
            if (r11 == 0) goto L_0x00b5
            java.util.Map r11 = r11.v()
            if (r11 == 0) goto L_0x00b5
            java.lang.String r0 = r0.s()
            java.lang.Object r11 = r11.get(r0)
            goto L_0x00b6
        L_0x00b5:
            r11 = r4
        L_0x00b6:
            boolean r0 = r11 instanceof java.util.Map
            if (r0 == 0) goto L_0x00bd
            r4 = r11
            java.util.Map r4 = (java.util.Map) r4
        L_0x00bd:
            if (r4 == 0) goto L_0x00f1
            java.util.Set r11 = r4.keySet()
            if (r11 == 0) goto L_0x00f1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x00ce:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r11.next()
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00ce
            r0.add(r2)
            goto L_0x00ce
        L_0x00e0:
            java.util.Set r11 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r1)
            java.util.Set r11 = kotlin.collections.CollectionsKt___CollectionsKt.g0(r0, r11)
            if (r11 == 0) goto L_0x00f1
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r11)
            if (r11 == 0) goto L_0x00f1
            goto L_0x00f5
        L_0x00f1:
            java.util.List r11 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x00f5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.g(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.coroutines.c<? super java.util.List<? extends com.sumsub.sns.internal.core.data.model.IdentitySide>> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.m0
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m0 r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.m0) r0
            int r1 = r0.f35985d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35985d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m0 r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m0
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f35983b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35985d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r0 = r0.f35982a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r0
            kotlin.k.b(r12)
            goto L_0x0070
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0036:
            kotlin.k.b(r12)
            boolean r12 = r11.K()
            com.sumsub.sns.internal.camera.photo.presentation.document.b r5 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "isSeamlessMode="
            r2.append(r6)
            r2.append(r12)
            java.lang.String r7 = r2.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r5, r6, r7, r8, r9, r10)
            if (r12 != 0) goto L_0x0063
            com.sumsub.sns.internal.core.data.model.IdentitySide r12 = r11.J()
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r12)
            return r12
        L_0x0063:
            r0.f35982a = r11
            r0.f35985d = r4
            r12 = 0
            java.lang.Object r12 = a((com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r11, (boolean) r3, (kotlin.coroutines.c) r0, (int) r4, (java.lang.Object) r12)
            if (r12 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r0 = r11
        L_0x0070:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r12 = (com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness) r12
            int[] r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.l.f35968a
            int r12 = r12.ordinal()
            r12 = r1[r12]
            r1 = 2
            if (r12 == r4) goto L_0x00a3
            if (r12 == r1) goto L_0x009c
            boolean r12 = r0.K()
            if (r12 == 0) goto L_0x0095
            com.sumsub.sns.internal.core.data.model.IdentitySide[] r12 = new com.sumsub.sns.internal.core.data.model.IdentitySide[r1]
            com.sumsub.sns.internal.core.data.model.IdentitySide r0 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            r12[r3] = r0
            com.sumsub.sns.internal.core.data.model.IdentitySide r0 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            r12[r4] = r0
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.n(r12)
            goto L_0x00fb
        L_0x0095:
            com.sumsub.sns.internal.core.data.model.IdentitySide r12 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r12)
            goto L_0x00fb
        L_0x009c:
            com.sumsub.sns.internal.core.data.model.IdentitySide r12 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r12)
            goto L_0x00fb
        L_0x00a3:
            com.sumsub.sns.internal.core.data.model.IdentitySide[] r12 = new com.sumsub.sns.internal.core.data.model.IdentitySide[r1]
            com.sumsub.sns.internal.core.data.model.IdentitySide r1 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            r12[r3] = r1
            com.sumsub.sns.internal.core.data.model.IdentitySide r1 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            r12[r4] = r1
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.n(r12)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x00ba:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x00fa
            java.lang.Object r2 = r12.next()
            r5 = r2
            com.sumsub.sns.internal.core.data.model.IdentitySide r5 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r5
            java.util.List r6 = r0.G()
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L_0x00d6
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x00d6
            goto L_0x00f3
        L_0x00d6:
            java.util.Iterator r6 = r6.iterator()
        L_0x00da:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f3
            java.lang.Object r7 = r6.next()
            com.sumsub.sns.internal.core.data.model.n r7 = (com.sumsub.sns.internal.core.data.model.n) r7
            com.sumsub.sns.internal.core.data.model.IdentitySide r7 = r7.o()
            if (r7 != r5) goto L_0x00ee
            r7 = r4
            goto L_0x00ef
        L_0x00ee:
            r7 = r3
        L_0x00ef:
            if (r7 == 0) goto L_0x00da
            r5 = r3
            goto L_0x00f4
        L_0x00f3:
            r5 = r4
        L_0x00f4:
            if (r5 == 0) goto L_0x00ba
            r1.add(r2)
            goto L_0x00ba
        L_0x00fa:
            r12 = r1
        L_0x00fb:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.h(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.t0
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t0 r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.t0) r0
            int r1 = r0.f36056f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36056f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t0 r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t0
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36054d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36056f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0063
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r1 = r0.f36053c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r2 = r0.f36052b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r0 = r0.f36051a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r0
            kotlin.k.b(r8)
            goto L_0x00a4
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0044:
            java.lang.Object r2 = r0.f36053c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f36052b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r4
            java.lang.Object r5 = r0.f36051a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r8)
            r6 = r4
            r4 = r2
            r2 = r6
            goto L_0x008d
        L_0x0057:
            java.lang.Object r2 = r0.f36052b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r2
            java.lang.Object r5 = r0.f36051a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r8)
            goto L_0x0077
        L_0x0063:
            kotlin.k.b(r8)
            r0.f36051a = r7
            r0.f36052b = r7
            r0.f36056f = r5
            java.lang.String r8 = "sns_prompt_doubleSide_text"
            java.lang.Object r8 = r7.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r8 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r2 = r7
            r5 = r2
        L_0x0077:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.f36051a = r5
            r0.f36052b = r2
            r0.f36053c = r8
            r0.f36056f = r4
            java.lang.String r4 = "sns_prompt_doubleSide_action_yes"
            java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x008a
            return r1
        L_0x008a:
            r6 = r4
            r4 = r8
            r8 = r6
        L_0x008d:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.f36051a = r2
            r0.f36052b = r4
            r0.f36053c = r8
            r0.f36056f = r3
            java.lang.String r3 = "sns_prompt_doubleSide_action_no"
            java.lang.Object r0 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            r1 = r8
            r8 = r0
            r0 = r2
            r2 = r4
        L_0x00a4:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$h r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$h
            r3.<init>(r2, r1, r8)
            r0.a((com.sumsub.sns.core.presentation.base.a.j) r3)
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.i(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.w0
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$w0 r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.w0) r0
            int r1 = r0.f36084d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36084d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$w0 r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$w0
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f36082b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36084d
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            java.lang.Object r0 = r0.f36081a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r0
            kotlin.k.b(r12)
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0037:
            kotlin.k.b(r12)
            com.sumsub.sns.internal.core.data.source.dynamic.b r12 = r11.t()
            r0.f36081a = r11
            r0.f36084d = r5
            java.lang.Object r12 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r12, r4, r0, r5, r3)
            if (r12 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r11
        L_0x004a:
            com.sumsub.sns.internal.core.data.source.dynamic.e r12 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r12
            java.lang.Object r12 = r12.d()
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            if (r12 == 0) goto L_0x00a8
            com.sumsub.sns.internal.core.data.model.g$c r12 = r12.I()
            java.util.List r12 = r12.g()
            java.util.Iterator r12 = r12.iterator()
        L_0x0060:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0080
            java.lang.Object r1 = r12.next()
            r2 = r1
            com.sumsub.sns.internal.core.data.model.g$c$a r2 = (com.sumsub.sns.internal.core.data.model.g.c.a) r2
            com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.m()
            com.sumsub.sns.internal.core.data.model.Document r6 = r0.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r6 = r6.getType()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r6)
            if (r2 == 0) goto L_0x0060
            r3 = r1
        L_0x0080:
            com.sumsub.sns.internal.core.data.model.g$c$a r3 = (com.sumsub.sns.internal.core.data.model.g.c.a) r3
            if (r3 == 0) goto L_0x00a8
            com.sumsub.sns.internal.core.data.model.Document r12 = r0.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r12 = r12.getType()
            boolean r12 = r12.g()
            if (r12 == 0) goto L_0x00a5
            boolean r12 = r3.u()
            if (r12 == 0) goto L_0x00a5
            com.sumsub.sns.internal.ff.a r12 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r12 = r12.f()
            boolean r12 = r12.g()
            if (r12 != 0) goto L_0x00a5
            r4 = r5
        L_0x00a5:
            r0.e((boolean) r4)
        L_0x00a8:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r5 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "isSeamlessMode="
            r12.append(r1)
            boolean r0 = r0.K()
            r12.append(r0)
            java.lang.String r7 = r12.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.j(kotlin.coroutines.c):java.lang.Object");
    }

    public final void c(Map<String, com.sumsub.sns.internal.ml.badphotos.models.b> map) {
        this.L.a(this, P[4], map);
    }

    public final void f(boolean z11) {
        this.K.a(this, P[3], Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object f(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5, kotlin.coroutines.c r6) {
        /*
            boolean r0 = r6 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f0 r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f0) r0
            int r1 = r0.f35932d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35932d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f0 r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f0
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f35930b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35932d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r5 = r0.f35929a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r6)
            goto L_0x0059
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            java.lang.Object r5 = r0.f35929a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r6)
            goto L_0x004e
        L_0x0040:
            kotlin.k.b(r6)
            r0.f35929a = r5
            r0.f35932d = r4
            java.lang.Object r6 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r0.f35929a = r5
            r0.f35932d = r3
            java.lang.Object r6 = r5.j((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g0 r6 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$g0
            r0 = 0
            r6.<init>(r5, r0)
            r1 = 0
            com.sumsub.sns.core.presentation.base.a.a(r5, r1, r6, r4, r0)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel, kotlin.coroutines.c):java.lang.Object");
    }

    public void c(boolean z11) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new p0(z11, (kotlin.coroutines.c<? super p0>) null), 1, (Object) null);
    }

    public final void d(Map<String, b> map) {
        this.M.a(this, P[5], map);
    }

    public final void e(boolean z11) {
        this.N.a(this, P[6], Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(boolean r34, kotlin.coroutines.c<? super kotlin.Unit> r35) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            r2 = r35
            boolean r3 = r2 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.q0
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q0 r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.q0) r3
            int r4 = r3.f36016f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f36016f = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q0 r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q0
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f36014d
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f36016f
            r6 = 2
            r7 = 0
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x004f
            if (r5 == r9) goto L_0x0045
            if (r5 != r6) goto L_0x003d
            java.lang.Object r1 = r3.f36012b
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            java.lang.Object r3 = r3.f36011a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r3
            kotlin.k.b(r2)
            goto L_0x00c9
        L_0x003d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0045:
            boolean r1 = r3.f36013c
            java.lang.Object r5 = r3.f36011a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r2)
            goto L_0x007f
        L_0x004f:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r10 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "showPhotoPicker, retake="
            r2.append(r5)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r13 = 0
            r14 = 4
            r15 = 0
            java.lang.String r11 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r33.t()
            r3.f36011a = r0
            r3.f36013c = r1
            r3.f36016f = r9
            java.lang.Object r2 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r2, r8, r3, r9, r7)
            if (r2 != r4) goto L_0x007e
            return r4
        L_0x007e:
            r5 = r0
        L_0x007f:
            com.sumsub.sns.internal.core.data.source.dynamic.e r2 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r2
            java.lang.Object r2 = r2.d()
            com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2
            if (r2 != 0) goto L_0x00a4
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r2 = new com.sumsub.sns.internal.log.LoggerType[r9]
            com.sumsub.sns.internal.log.LoggerType r3 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r2[r8] = r3
            com.sumsub.log.logger.Logger r9 = r1.a((com.sumsub.sns.internal.log.LoggerType[]) r2)
            java.lang.String r10 = com.sumsub.sns.internal.log.c.a(r5)
            r12 = 0
            r13 = 4
            r14 = 0
            java.lang.String r11 = "applicant null!"
            com.sumsub.log.logger.a.b(r9, r10, r11, r12, r13, r14)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x00a4:
            java.util.Map r10 = kotlin.collections.MapsKt__MapsKt.h()
            r5.d((java.util.Map<java.lang.String, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b>) r10)
            r5.b((boolean) r8)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$r0 r10 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$r0
            r10.<init>(r7)
            com.sumsub.sns.core.presentation.base.a.a(r5, r8, r10, r9, r7)
            r3.f36011a = r5
            r3.f36012b = r2
            r3.f36016f = r6
            java.lang.Object r1 = r5.a((boolean) r1, (com.sumsub.sns.internal.core.data.model.g) r2, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f>) r3)
            if (r1 != r4) goto L_0x00c3
            return r4
        L_0x00c3:
            r3 = r5
            r32 = r2
            r2 = r1
            r1 = r32
        L_0x00c9:
            r10 = r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f r10 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f) r10
            boolean r11 = r3.K()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 254(0xfe, float:3.56E-43)
            r20 = 0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f r2 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            com.sumsub.sns.internal.core.data.model.Document r4 = r3.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()
            com.sumsub.sns.internal.core.data.model.g$c$a r1 = r1.a((com.sumsub.sns.internal.core.data.model.DocumentType) r4)
            if (r1 == 0) goto L_0x00f8
            boolean r4 = r1.w()
            if (r4 != r9) goto L_0x00f8
            r4 = r9
            goto L_0x00f9
        L_0x00f8:
            r4 = r8
        L_0x00f9:
            if (r4 != 0) goto L_0x0184
            if (r1 == 0) goto L_0x0104
            boolean r1 = r1.v()
            if (r1 != r9) goto L_0x0104
            r8 = r9
        L_0x0104:
            if (r8 == 0) goto L_0x0108
            goto L_0x0184
        L_0x0108:
            boolean r1 = r2.n()
            if (r1 == 0) goto L_0x0142
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$a r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$a
            java.util.Map r4 = r3.B()
            com.sumsub.sns.internal.core.data.model.IdentitySide r5 = com.sumsub.sns.internal.core.data.model.IdentitySide.Front
            java.lang.String r5 = r5.getValue()
            java.lang.Object r4 = r4.get(r5)
            r29 = r4
            com.sumsub.sns.internal.ml.badphotos.models.b r29 = (com.sumsub.sns.internal.ml.badphotos.models.b) r29
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 127(0x7f, float:1.78E-43)
            r31 = 0
            r21 = r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f r2 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.f.a(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r1.<init>(r2)
            r3.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            goto L_0x01c0
        L_0x0142:
            java.util.List r1 = r2.o()
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r1)
            com.sumsub.sns.internal.core.data.model.IdentitySide r4 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            if (r1 != r4) goto L_0x0155
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r1 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.SCAN_BACKSIDE
            java.lang.String r1 = r1.getSceneName()
            goto L_0x015b
        L_0x0155:
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r1 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.SCAN_FRONTSIDE
            java.lang.String r1 = r1.getSceneName()
        L_0x015b:
            r6 = r1
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$i r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$i
            com.sumsub.sns.internal.core.domain.model.c r11 = new com.sumsub.sns.internal.core.domain.model.c
            com.sumsub.sns.internal.core.data.model.Document r4 = r2.i()
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()
            java.lang.String r5 = r4.c()
            java.lang.String r7 = r2.k()
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$a r4 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$a
            r4.<init>(r2)
            r1.<init>(r11, r4)
            r3.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            goto L_0x01c0
        L_0x0184:
            boolean r1 = r2.n()
            if (r1 == 0) goto L_0x0193
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$b r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$b
            r1.<init>(r2)
            r3.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            goto L_0x01c0
        L_0x0193:
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r1 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.PHOTOSELFIE
            java.lang.String r6 = r1.getSceneName()
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$i r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$i
            com.sumsub.sns.internal.core.domain.model.c r11 = new com.sumsub.sns.internal.core.domain.model.c
            com.sumsub.sns.internal.core.data.model.Document r4 = r2.i()
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()
            java.lang.String r5 = r4.c()
            java.lang.String r7 = r2.k()
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$b r4 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$e$b
            r4.<init>(r2)
            r1.<init>(r11, r4)
            r3.a((com.sumsub.sns.core.presentation.base.a.j) r1)
        L_0x01c0:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.c(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public void d(boolean z11) {
        boolean z12 = true;
        if (z11) {
            if (J() == IdentitySide.Front) {
                a(J().getValue(), new com.sumsub.sns.internal.ml.badphotos.models.b((String) null, (String) null, (Float) null, (Long) null, (Float) null, (Float) null, (Integer) null, (Integer) null, (Boolean) null, 511, (kotlin.jvm.internal.r) null));
                a(IdentitySide.Back);
            }
            a(this, (IdentitySide) null, 1, (Object) null);
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new y(this, (kotlin.coroutines.c<? super y>) null), 3, (Object) null);
            return;
        }
        if (!G().isEmpty()) {
            List<com.sumsub.sns.internal.core.data.model.n> G2 = G();
            if (!(G2 instanceof Collection) || !G2.isEmpty()) {
                Iterator<T> it2 = G2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((com.sumsub.sns.internal.core.data.model.n) it2.next()).n()) {
                            z12 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z12) {
                a(u());
                return;
            }
        }
        N();
    }

    public final String e(String str) {
        com.sumsub.sns.internal.core.data.model.e d11 = d();
        return a(d11 != null ? com.sumsub.sns.internal.core.data.model.f.p(d11) : null, str);
    }

    public final void b(com.sumsub.sns.internal.core.data.model.l lVar) {
        this.I.a(this, P[1], lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.t
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.t) r0
            int r1 = r0.f36050g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36050g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$t
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f36048e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36050g
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x007d
            if (r2 == r6) goto L_0x0075
            if (r2 == r5) goto L_0x0068
            if (r2 == r4) goto L_0x0051
            if (r2 != r3) goto L_0x0049
            java.lang.Object r1 = r0.f36047d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1
            java.lang.Object r2 = r0.f36046c
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a) r2
            java.lang.Object r3 = r0.f36045b
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r0 = r0.f36044a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.k.b(r13)
            r10 = r1
            r1 = r0
            r0 = r10
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x00dc
        L_0x0049:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0051:
            java.lang.Object r2 = r0.f36047d
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r2
            java.lang.Object r4 = r0.f36046c
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r0.f36045b
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r0.f36044a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r6 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r6
            kotlin.k.b(r13)
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x00ba
        L_0x0068:
            java.lang.Object r2 = r0.f36045b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r5 = r0.f36044a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r13)
            r6 = r5
            goto L_0x00a0
        L_0x0075:
            java.lang.Object r2 = r0.f36044a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r2
            kotlin.k.b(r13)
            goto L_0x008c
        L_0x007d:
            kotlin.k.b(r13)
            r0.f36044a = r12
            r0.f36050g = r6
            java.lang.Object r13 = r12.f((kotlin.coroutines.c<? super java.lang.CharSequence>) r0)
            if (r13 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r2 = r12
        L_0x008c:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r0.f36044a = r2
            r0.f36045b = r13
            r0.f36050g = r5
            java.lang.String r5 = "sns_preview_photo_subtitle"
            java.lang.Object r5 = r2.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r6 = r2
            r2 = r13
            r13 = r5
        L_0x00a0:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r5 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.CONTINUE
            r0.f36044a = r6
            r0.f36045b = r2
            r0.f36046c = r13
            r0.f36047d = r5
            r0.f36050g = r4
            java.lang.String r4 = "sns_preview_photo_action_accept"
            java.lang.Object r4 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            r10 = r4
            r4 = r13
            r13 = r10
        L_0x00ba:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a
            r7.<init>(r5, r13)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r13 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN
            r0.f36044a = r2
            r0.f36045b = r4
            r0.f36046c = r7
            r0.f36047d = r13
            r0.f36050g = r3
            java.lang.String r3 = "sns_preview_photo_action_retake"
            java.lang.Object r0 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            r1 = r2
            r2 = r4
            r3 = r7
            r10 = r0
            r0 = r13
            r13 = r10
        L_0x00dc:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r4 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a
            r4.<init>(r0, r13)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r6 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.OK
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r13 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content
            r5 = 0
            r7 = 0
            r8 = 80
            r9 = 0
            r0 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(IdentitySide identitySide) {
        String str;
        com.sumsub.sns.internal.core.analytics.b bVar = com.sumsub.sns.internal.core.analytics.b.f31873a;
        GlobalStatePayload globalStatePayload = GlobalStatePayload.IdDocSubType;
        if (identitySide == null || (str = identitySide.getValue()) == null) {
            str = J().getValue();
        }
        bVar.a(globalStatePayload, str);
    }

    public static /* synthetic */ Object b(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return sNSPreviewPhotoDocumentViewModel.b(z11, (kotlin.coroutines.c<? super Unit>) cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveSecondSide");
    }

    public final void b(com.sumsub.sns.internal.core.data.model.n nVar) {
        b((List<com.sumsub.sns.internal.core.data.model.n>) CollectionsKt__CollectionsJVMKt.e(nVar));
    }

    public final void b(List<com.sumsub.sns.internal.core.data.model.n> list) {
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new s0(this, list, (kotlin.coroutines.c<? super s0>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.sumsub.sns.internal.core.data.model.n r12, kotlin.coroutines.c<? super android.graphics.Bitmap> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.q
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.q) r0
            int r1 = r0.f36010d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36010d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$q
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f36008b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36010d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r12 = r0.f36007a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r12 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r12
            kotlin.k.b(r13)     // Catch:{ all -> 0x002e }
            goto L_0x004f
        L_0x002e:
            r13 = move-exception
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            kotlin.k.b(r13)
            java.io.File r12 = r12.k()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x0093
            r13 = 1920(0x780, float:2.69E-42)
            r0.f36007a = r11     // Catch:{ all -> 0x0053 }
            r0.f36010d = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = com.sumsub.sns.internal.core.common.m0.b((java.io.File) r12, (int) r13, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r0)     // Catch:{ all -> 0x0053 }
            if (r13 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r12 = r11
        L_0x004f:
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13     // Catch:{ all -> 0x002e }
            r4 = r13
            goto L_0x0093
        L_0x0053:
            r13 = move-exception
            r12 = r11
        L_0x0055:
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r12)
            java.lang.String r2 = r13.getMessage()
            if (r2 != 0) goto L_0x0063
            java.lang.String r2 = ""
        L_0x0063:
            r0.e(r1, r2, r13)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r0 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decodePdf errro: "
            r1.append(r2)
            java.lang.String r2 = r13.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DocCapture"
            r0.b(r2, r1, r13)
            kotlinx.coroutines.h0 r5 = androidx.lifecycle.m0.a(r12)
            kotlinx.coroutines.v1 r6 = kotlinx.coroutines.v1.f57574b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$r r8 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$r
            r8.<init>(r13, r4)
            r7 = 0
            r9 = 2
            r10 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r5, r6, r7, r8, r9, r10)
        L_0x0093:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(com.sumsub.sns.internal.core.data.model.n, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(IdentitySide identitySide) {
        this.H.a(this, P[0], identitySide);
    }

    public final void a(List<com.sumsub.sns.internal.core.data.model.n> list) {
        this.J.a(this, P[2], list);
    }

    public String d(String str) {
        com.sumsub.sns.internal.core.data.model.e d11 = d();
        return a(d11 != null ? com.sumsub.sns.internal.core.data.model.f.j(d11) : null, str);
    }

    public static /* synthetic */ void a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, IdentitySide identitySide, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                identitySide = null;
            }
            sNSPreviewPhotoDocumentViewModel.b(identitySide);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAnalyticSideType");
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "Preview photo error handling... " + oVar, (Throwable) null, 4, (Object) null);
        if (oVar instanceof o.e) {
            N();
        }
    }

    public static /* synthetic */ Object a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, boolean z11, kotlin.coroutines.c cVar) {
        Object i11 = sNSPreviewPhotoDocumentViewModel.i((kotlin.coroutines.c<? super Unit>) cVar);
        return i11 == IntrinsicsKt__IntrinsicsKt.d() ? i11 : Unit.f56620a;
    }

    public final void a(com.sumsub.sns.internal.core.data.model.n nVar, int i11) {
        int i12 = i11 % 360;
        if (i12 != 0) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("applyRotation: ");
            File m11 = nVar.m();
            sb2.append(m11 != null ? m11.getName() : null);
            sb2.append(" -> ");
            sb2.append(i11);
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, sb2.toString(), (Throwable) null, 4, (Object) null);
            if (i12 <= 0) {
                i12 += 360;
            }
            try {
                m1.a aVar = new m1.a(nVar.m());
                aVar.c0("Orientation", String.valueOf(com.sumsub.sns.internal.core.common.i.b(i12 + aVar.s())));
                aVar.X();
            } catch (Exception e11) {
                a("Can't apply rotation", e11);
            }
        }
    }

    public final void b(int i11) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new v0(i11, (kotlin.coroutines.c<? super v0>) null), 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
        r0 = r0.v();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(java.lang.String r11, kotlin.coroutines.c<? super java.util.List<java.lang.String>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.v
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$v r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.v) r0
            int r1 = r0.f36075e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36075e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$v r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$v
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f36073c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36075e
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r5) goto L_0x0033
            java.lang.Object r11 = r0.f36072b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r0 = r0.f36071a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r0
            kotlin.k.b(r12)
            goto L_0x0050
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            kotlin.k.b(r12)
            com.sumsub.sns.internal.core.data.source.dynamic.b r12 = r10.t()
            r0.f36071a = r10
            r0.f36072b = r11
            r0.f36075e = r5
            java.lang.Object r12 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r12, r3, r0, r5, r4)
            if (r12 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r10
        L_0x0050:
            com.sumsub.sns.internal.core.data.source.dynamic.e r12 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r12
            java.lang.Object r12 = r12.d()
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            if (r12 != 0) goto L_0x0077
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r12 = new com.sumsub.sns.internal.log.LoggerType[r5]
            com.sumsub.sns.internal.log.LoggerType r1 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r12[r3] = r1
            com.sumsub.log.logger.Logger r4 = r11.a((com.sumsub.sns.internal.log.LoggerType[]) r12)
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r0)
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "applicant null!"
            com.sumsub.log.logger.a.b(r4, r5, r6, r7, r8, r9)
            java.util.List r11 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            return r11
        L_0x0077:
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = new com.sumsub.sns.internal.core.data.model.DocumentType
            com.sumsub.sns.internal.core.data.model.Document r2 = r0.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.getType()
            java.lang.String r2 = r2.c()
            r1.<init>(r2)
            java.util.List r12 = r12.b(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.u(r12, r2)
            r1.<init>(r2)
            java.util.Iterator r12 = r12.iterator()
        L_0x009b:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x00af
            java.lang.Object r2 = r12.next()
            com.sumsub.sns.internal.core.data.model.q r2 = (com.sumsub.sns.internal.core.data.model.q) r2
            java.lang.String r2 = r2.b()
            r1.add(r2)
            goto L_0x009b
        L_0x00af:
            java.util.List r12 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r1)
            java.util.Set r1 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r12)
            com.sumsub.sns.internal.core.data.model.e r0 = r0.d()
            if (r0 == 0) goto L_0x00c8
            java.util.Map r0 = r0.v()
            if (r0 == 0) goto L_0x00c8
            java.lang.Object r11 = r0.get(r11)
            goto L_0x00c9
        L_0x00c8:
            r11 = r4
        L_0x00c9:
            boolean r0 = r11 instanceof java.util.Map
            if (r0 == 0) goto L_0x00d0
            java.util.Map r11 = (java.util.Map) r11
            goto L_0x00d1
        L_0x00d0:
            r11 = r4
        L_0x00d1:
            if (r11 == 0) goto L_0x00f0
            java.util.Set r11 = r11.keySet()
            if (r11 == 0) goto L_0x00f0
            java.util.Set r11 = kotlin.collections.CollectionsKt___CollectionsKt.g0(r11, r1)
            if (r11 == 0) goto L_0x00f0
            boolean r0 = r11.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x00e7
            r4 = r11
        L_0x00e7:
            if (r4 == 0) goto L_0x00f0
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r4)
            if (r11 == 0) goto L_0x00f0
            r12 = r11
        L_0x00f0:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(com.sumsub.sns.internal.core.data.model.l lVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "on picker results: " + lVar, (Throwable) null, 4, (Object) null);
        if (lVar != null) {
            b(lVar);
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new z(lVar, this, (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
        }
    }

    public void a(com.sumsub.sns.internal.core.data.model.n nVar) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "on picker result: " + nVar, (Throwable) null, 4, (Object) null);
        if (nVar == null) {
            if (G().isEmpty()) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
            } else {
                if (J() == IdentitySide.Back) {
                    a(IdentitySide.Front);
                }
                a(this, (IdentitySide) null, 1, (Object) null);
            }
            c(true);
            b(false);
            return;
        }
        List L0 = CollectionsKt___CollectionsKt.L0(G());
        boolean unused = CollectionsKt__MutableCollectionsKt.G(L0, new x(nVar));
        if (nVar.p() == null) {
            L0.add(com.sumsub.sns.internal.core.data.model.n.a(nVar, (File) null, (File) null, (String) null, v(), (IdentitySide) null, false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (n.b) null, false, 503, (Object) null));
        } else {
            L0.add(nVar);
        }
        a((List<com.sumsub.sns.internal.core.data.model.n>) L0);
        a(J().getValue(), nVar.l());
        b(nVar);
    }

    public static /* synthetic */ Object c(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return sNSPreviewPhotoDocumentViewModel.c(z11, (kotlin.coroutines.c<? super Unit>) cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPhotoPicker");
    }

    public final void c(List<com.sumsub.sns.internal.core.data.model.n> list) {
        for (com.sumsub.sns.internal.core.data.model.n nVar : list) {
            if (!nVar.t()) {
                IdentitySide o11 = nVar.o();
                a(o11 != null ? o11.getValue() : null, nVar.l());
            }
        }
    }

    public final void a(String str, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
        if (str == null) {
            str = IdentitySide.Front.getValue();
        }
        com.sumsub.sns.internal.ml.badphotos.models.b bVar2 = B().get(str);
        com.sumsub.sns.internal.ml.badphotos.models.b a11 = (bVar != null || bVar2 == null) ? bVar : com.sumsub.sns.internal.ml.badphotos.models.b.a(bVar2, (String) null, (String) null, (Float) null, (Long) null, (Float) null, (Float) null, (Integer) null, (Integer) null, Boolean.FALSE, 255, (Object) null);
        if (a11 != null) {
            Map y11 = MapsKt__MapsKt.y(B());
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar3 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar3, DocCapture.f31492c, "updateCheckPhotoQualityResults side=" + str + ", " + bVar, (Throwable) null, 4, (Object) null);
            y11.put(str, a11);
            c((Map<String, com.sumsub.sns.internal.ml.badphotos.models.b>) y11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.n r6, kotlin.coroutines.c<? super android.graphics.Bitmap> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.p
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$p r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.p) r0
            int r1 = r0.f36003d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36003d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$p r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$p
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f36001b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36003d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r6 = r0.f36000a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r6 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r6
            kotlin.k.b(r7)     // Catch:{ all -> 0x002e }
            goto L_0x004f
        L_0x002e:
            r7 = move-exception
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            kotlin.k.b(r7)
            java.io.File r6 = r6.k()     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x006b
            r7 = 1920(0x780, float:2.69E-42)
            r0.f36000a = r5     // Catch:{ all -> 0x0053 }
            r0.f36003d = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r7 = com.sumsub.sns.internal.core.common.m0.a((java.io.File) r6, (int) r7, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r0)     // Catch:{ all -> 0x0053 }
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r6 = r5
        L_0x004f:
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7     // Catch:{ all -> 0x002e }
            r3 = r7
            goto L_0x006b
        L_0x0053:
            r7 = move-exception
            r6 = r5
        L_0x0055:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r0 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.String r1 = "DocCapture"
            java.lang.String r2 = "Can't decode image"
            r0.b(r1, r2, r7)
            boolean r0 = r7 instanceof java.lang.Exception
            if (r0 == 0) goto L_0x0065
            java.lang.Exception r7 = (java.lang.Exception) r7
            goto L_0x0066
        L_0x0065:
            r7 = r3
        L_0x0066:
            if (r7 == 0) goto L_0x006b
            r6.a((java.lang.String) r2, (java.lang.Exception) r7)
        L_0x006b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(com.sumsub.sns.internal.core.data.model.n, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r16, com.sumsub.sns.internal.ml.badphotos.models.b r17, com.sumsub.sns.internal.core.data.model.IdentitySide r18, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.core.e.a<com.sumsub.sns.internal.ml.badphotos.models.a>> r19) {
        /*
            r15 = this;
            r7 = r15
            r0 = r19
            boolean r1 = r0 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.n
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$n r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.n) r1
            int r2 = r1.f35989d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.f35989d = r2
            goto L_0x001b
        L_0x0016:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$n r1 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$n
            r1.<init>(r15, r0)
        L_0x001b:
            r4 = r1
            java.lang.Object r0 = r4.f35987b
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f35989d
            r2 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            java.lang.Object r1 = r4.f35986a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r1
            kotlin.k.b(r0)
            goto L_0x00af
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            kotlin.k.b(r0)
            if (r17 == 0) goto L_0x007d
            boolean r0 = r17.s()
            if (r0 != 0) goto L_0x007d
            com.sumsub.sns.internal.camera.photo.presentation.document.b r9 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r12 = 0
            r13 = 4
            r14 = 0
            java.lang.String r10 = "DocCapture"
            java.lang.String r11 = "taking previous quality check result"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r9, r10, r11, r12, r13, r14)
            com.sumsub.sns.internal.ml.core.e$a$d r0 = new com.sumsub.sns.internal.ml.core.e$a$d
            com.sumsub.sns.internal.ml.badphotos.models.a r1 = new com.sumsub.sns.internal.ml.badphotos.models.a
            java.lang.String r2 = r17.l()
            if (r2 != 0) goto L_0x005d
            java.lang.String r2 = ""
        L_0x005d:
            java.lang.Float r3 = r17.n()
            if (r3 == 0) goto L_0x0068
            float r3 = r3.floatValue()
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            java.lang.Long r4 = r17.o()
            if (r4 == 0) goto L_0x0074
            long r4 = r4.longValue()
            goto L_0x0076
        L_0x0074:
            r4 = 0
        L_0x0076:
            r1.<init>(r2, r3, r4)
            r0.<init>(r1)
            goto L_0x0093
        L_0x007d:
            r0 = 0
            if (r17 == 0) goto L_0x0085
            java.lang.String r1 = r17.m()
            goto L_0x0086
        L_0x0085:
            r1 = r0
        L_0x0086:
            java.lang.String r3 = "skip"
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x0095
            com.sumsub.sns.internal.ml.core.e$a$c r0 = new com.sumsub.sns.internal.ml.core.e$a$c
            r0.<init>()
        L_0x0093:
            r1 = r7
            goto L_0x00b1
        L_0x0095:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$o r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$o
            r1 = r16
            r5 = r18
            r3.<init>(r15, r1, r5, r0)
            r4.f35986a = r7
            r4.f35989d = r2
            r1 = 0
            r5 = 1
            r6 = 0
            r0 = r15
            java.lang.Object r0 = com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (long) r1, (d10.l) r3, (kotlin.coroutines.c) r4, (int) r5, (java.lang.Object) r6)
            if (r0 != r8) goto L_0x00ae
            return r8
        L_0x00ae:
            r1 = r7
        L_0x00af:
            com.sumsub.sns.internal.ml.core.e$a r0 = (com.sumsub.sns.internal.ml.core.e.a) r0
        L_0x00b1:
            com.sumsub.sns.internal.ff.a r2 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r2 = r2.w()
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x00c5
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$j r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$j
            r2.<init>(r0)
            r1.a((com.sumsub.sns.core.presentation.base.a.j) r2)
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(android.graphics.Bitmap, com.sumsub.sns.internal.ml.badphotos.models.b, com.sumsub.sns.internal.core.data.model.IdentitySide, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(String str, Exception exc) {
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), v1.f57574b, (CoroutineStart) null, new o0(str, exc, (kotlin.coroutines.c<? super o0>) null), 2, (Object) null);
    }

    public static /* synthetic */ Object a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c cVar) {
        if (!sNSPreviewPhotoDocumentViewModel.I()) {
            return Unit.f56620a;
        }
        sNSPreviewPhotoDocumentViewModel.f(false);
        Object c11 = sNSPreviewPhotoDocumentViewModel.c(false, (kotlin.coroutines.c<? super Unit>) cVar);
        return c11 == IntrinsicsKt__IntrinsicsKt.d() ? c11 : Unit.f56620a;
    }

    public String a(Map<String, String> map, String str) {
        return (map != null ? map.get(str) : null) != null ? str : "default";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0217, code lost:
        if (kotlin.jvm.internal.x.b(r2 != null ? r2.h() : null, r5.s()) == false) goto L_0x0219;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0135 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0136 A[EDGE_INSN: B:135:0x0136->B:63:0x0136 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0133 A[LOOP:1: B:39:0x00e5->B:61:0x0133, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.List<com.sumsub.sns.internal.core.data.model.remote.k> r24, kotlin.coroutines.c<? super kotlin.Unit> r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            boolean r3 = r2 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b0
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b0 r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.b0) r3
            int r4 = r3.f35886e
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f35886e = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b0 r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$b0
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f35884c
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f35886e
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x004d
            if (r5 == r8) goto L_0x0041
            if (r5 != r6) goto L_0x0039
            java.lang.Object r1 = r3.f35882a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r1
            kotlin.k.b(r2)
            goto L_0x02a3
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            java.lang.Object r1 = r3.f35883b
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.f35882a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r5
            kotlin.k.b(r2)
            goto L_0x0091
        L_0x004d:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r10 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Data for document is uploaded. Document is "
            r2.append(r5)
            com.sumsub.sns.internal.core.data.model.Document r5 = r23.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r5 = r5.getType()
            java.lang.String r5 = r5.c()
            r2.append(r5)
            java.lang.String r5 = " idDocs: "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r13 = 0
            r14 = 4
            r15 = 0
            java.lang.String r11 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r23.t()
            r3.f35882a = r0
            r3.f35883b = r1
            r3.f35886e = r8
            java.lang.Object r2 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r2, r7, r3, r8, r9)
            if (r2 != r4) goto L_0x0090
            return r4
        L_0x0090:
            r5 = r0
        L_0x0091:
            com.sumsub.sns.internal.core.data.source.dynamic.e r2 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r2
            java.lang.Object r2 = r2.d()
            com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2
            if (r2 != 0) goto L_0x00b6
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r2 = new com.sumsub.sns.internal.log.LoggerType[r8]
            com.sumsub.sns.internal.log.LoggerType r3 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r2[r7] = r3
            com.sumsub.log.logger.Logger r8 = r1.a((com.sumsub.sns.internal.log.LoggerType[]) r2)
            java.lang.String r9 = com.sumsub.sns.internal.log.c.a(r5)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r10 = "applicant null!"
            com.sumsub.log.logger.a.b(r8, r9, r10, r11, r12, r13)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x00b6:
            boolean r10 = r1 instanceof java.util.Collection
            if (r10 == 0) goto L_0x00c1
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto L_0x00c1
            goto L_0x00e0
        L_0x00c1:
            java.util.Iterator r10 = r1.iterator()
        L_0x00c5:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00e0
            java.lang.Object r11 = r10.next()
            com.sumsub.sns.internal.core.data.model.remote.k r11 = (com.sumsub.sns.internal.core.data.model.remote.k) r11
            if (r11 == 0) goto L_0x00db
            boolean r11 = r11.l()
            if (r11 != r8) goto L_0x00db
            r11 = r8
            goto L_0x00dc
        L_0x00db:
            r11 = r7
        L_0x00dc:
            if (r11 == 0) goto L_0x00c5
            r10 = r8
            goto L_0x00e1
        L_0x00e0:
            r10 = r7
        L_0x00e1:
            java.util.Iterator r11 = r1.iterator()
        L_0x00e5:
            boolean r12 = r11.hasNext()
            java.lang.String r13 = "mrtdSeed"
            if (r12 == 0) goto L_0x0135
            java.lang.Object r12 = r11.next()
            r14 = r12
            com.sumsub.sns.internal.core.data.model.remote.k r14 = (com.sumsub.sns.internal.core.data.model.remote.k) r14
            if (r14 == 0) goto L_0x012f
            java.util.List r14 = r14.s()
            if (r14 == 0) goto L_0x012f
            java.util.Iterator r14 = r14.iterator()
        L_0x0100:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x011b
            java.lang.Object r15 = r14.next()
            r16 = r15
            com.sumsub.sns.internal.core.data.model.remote.e r16 = (com.sumsub.sns.internal.core.data.model.remote.e) r16
            java.lang.String r6 = r16.c()
            boolean r6 = kotlin.jvm.internal.x.b(r6, r13)
            if (r6 == 0) goto L_0x0119
            goto L_0x011c
        L_0x0119:
            r6 = 2
            goto L_0x0100
        L_0x011b:
            r15 = r9
        L_0x011c:
            com.sumsub.sns.internal.core.data.model.remote.e r15 = (com.sumsub.sns.internal.core.data.model.remote.e) r15
            if (r15 == 0) goto L_0x012f
            java.lang.String r6 = r15.e()
            if (r6 == 0) goto L_0x012f
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.z(r6)
            r6 = r6 ^ r8
            if (r6 != r8) goto L_0x012f
            r6 = r8
            goto L_0x0130
        L_0x012f:
            r6 = r7
        L_0x0130:
            if (r6 == 0) goto L_0x0133
            goto L_0x0136
        L_0x0133:
            r6 = 2
            goto L_0x00e5
        L_0x0135:
            r12 = r9
        L_0x0136:
            com.sumsub.sns.internal.core.data.model.remote.k r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r12
            if (r12 == 0) goto L_0x01b7
            java.lang.String r15 = r2.B()
            com.sumsub.sns.internal.core.data.model.Document r16 = r5.u()
            java.lang.String r17 = r12.o()
            java.lang.String r18 = r12.h()
            java.util.List r2 = r12.s()
            if (r2 == 0) goto L_0x0178
            java.util.Iterator r2 = r2.iterator()
        L_0x0154:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x016c
            java.lang.Object r6 = r2.next()
            r11 = r6
            com.sumsub.sns.internal.core.data.model.remote.e r11 = (com.sumsub.sns.internal.core.data.model.remote.e) r11
            java.lang.String r11 = r11.c()
            boolean r11 = kotlin.jvm.internal.x.b(r11, r13)
            if (r11 == 0) goto L_0x0154
            goto L_0x016d
        L_0x016c:
            r6 = r9
        L_0x016d:
            com.sumsub.sns.internal.core.data.model.remote.e r6 = (com.sumsub.sns.internal.core.data.model.remote.e) r6
            if (r6 == 0) goto L_0x0178
            java.lang.String r2 = r6.e()
            r19 = r2
            goto L_0x017a
        L_0x0178:
            r19 = r9
        L_0x017a:
            java.util.List r2 = r12.s()
            if (r2 == 0) goto L_0x01aa
            java.util.Iterator r2 = r2.iterator()
        L_0x0184:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x019e
            java.lang.Object r6 = r2.next()
            r11 = r6
            com.sumsub.sns.internal.core.data.model.remote.e r11 = (com.sumsub.sns.internal.core.data.model.remote.e) r11
            java.lang.String r11 = r11.c()
            java.lang.String r13 = "mrtdDataFilesToRead"
            boolean r11 = kotlin.jvm.internal.x.b(r11, r13)
            if (r11 == 0) goto L_0x0184
            goto L_0x019f
        L_0x019e:
            r6 = r9
        L_0x019f:
            com.sumsub.sns.internal.core.data.model.remote.e r6 = (com.sumsub.sns.internal.core.data.model.remote.e) r6
            if (r6 == 0) goto L_0x01aa
            java.lang.String r2 = r6.e()
            r20 = r2
            goto L_0x01ac
        L_0x01aa:
            r20 = r9
        L_0x01ac:
            java.lang.String r21 = r12.q()
            com.sumsub.sns.internal.core.data.model.s r2 = new com.sumsub.sns.internal.core.data.model.s
            r14 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            goto L_0x01b8
        L_0x01b7:
            r2 = r9
        L_0x01b8:
            if (r10 == 0) goto L_0x01cd
            kotlinx.coroutines.h0 r11 = androidx.lifecycle.m0.a(r5)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$c0 r14 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$c0
            r14.<init>(r1, r5, r9)
            r12 = 0
            r13 = 0
            r15 = 3
            r16 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r11, r12, r13, r14, r15, r16)
            goto L_0x02a2
        L_0x01cd:
            if (r2 == 0) goto L_0x01e3
            com.sumsub.sns.internal.camera.photo.presentation.document.b r17 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r18 = "DocCapture"
            java.lang.String r19 = "Got MRTD seed"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r17, r18, r19, r20, r21, r22)
            r5.a((com.sumsub.sns.internal.core.data.model.s) r2)
            goto L_0x02a2
        L_0x01e3:
            int r2 = r1.size()
            if (r2 != r8) goto L_0x028b
            java.lang.Object r2 = r1.get(r7)
            com.sumsub.sns.internal.core.data.model.remote.k r2 = (com.sumsub.sns.internal.core.data.model.remote.k) r2
            if (r2 == 0) goto L_0x01f6
            java.lang.String r2 = r2.o()
            goto L_0x01f7
        L_0x01f6:
            r2 = r9
        L_0x01f7:
            java.lang.String r6 = r5.v()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r6)
            if (r2 == 0) goto L_0x0219
            java.lang.Object r2 = r1.get(r7)
            com.sumsub.sns.internal.core.data.model.remote.k r2 = (com.sumsub.sns.internal.core.data.model.remote.k) r2
            if (r2 == 0) goto L_0x020e
            java.lang.String r2 = r2.h()
            goto L_0x020f
        L_0x020e:
            r2 = r9
        L_0x020f:
            java.lang.String r6 = r5.s()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r6)
            if (r2 != 0) goto L_0x028b
        L_0x0219:
            java.lang.Object r2 = r1.get(r7)
            com.sumsub.sns.internal.core.data.model.remote.k r2 = (com.sumsub.sns.internal.core.data.model.remote.k) r2
            if (r2 == 0) goto L_0x022a
            java.lang.String r2 = r2.o()
            if (r2 == 0) goto L_0x022a
            r5.c((java.lang.String) r2)
        L_0x022a:
            java.lang.Object r1 = r1.get(r7)
            com.sumsub.sns.internal.core.data.model.remote.k r1 = (com.sumsub.sns.internal.core.data.model.remote.k) r1
            if (r1 == 0) goto L_0x023b
            java.lang.String r1 = r1.h()
            if (r1 == 0) goto L_0x023b
            r5.b((java.lang.String) r1)
        L_0x023b:
            java.util.List r1 = r5.G()
            java.util.ArrayList r2 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r6)
            r2.<init>(r6)
            java.util.Iterator r1 = r1.iterator()
        L_0x024e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x027a
            java.lang.Object r6 = r1.next()
            r10 = r6
            com.sumsub.sns.internal.core.data.model.n r10 = (com.sumsub.sns.internal.core.data.model.n) r10
            java.lang.String r14 = r5.v()
            java.lang.String r13 = r5.s()
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 1
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 467(0x1d3, float:6.54E-43)
            r21 = 0
            com.sumsub.sns.internal.core.data.model.n r6 = com.sumsub.sns.internal.core.data.model.n.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2.add(r6)
            goto L_0x024e
        L_0x027a:
            r5.a((java.util.List<com.sumsub.sns.internal.core.data.model.n>) r2)
            r3.f35882a = r5
            r3.f35883b = r9
            r1 = 2
            r3.f35886e = r1
            java.lang.Object r1 = r5.b((boolean) r8, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
            if (r1 != r4) goto L_0x02a2
            return r4
        L_0x028b:
            kotlinx.coroutines.h0 r8 = androidx.lifecycle.m0.a(r5)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d0 r11 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$d0
            r11.<init>(r5, r9)
            r9 = 0
            r10 = 0
            r12 = 3
            r13 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r8, r9, r10, r11, r12, r13)
            com.sumsub.sns.internal.core.data.model.Document r1 = r5.u()
            r5.a((com.sumsub.sns.internal.core.data.model.Document) r1)
        L_0x02a2:
            r1 = r5
        L_0x02a3:
            r1.b((boolean) r7)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(com.sumsub.sns.internal.core.data.model.s sVar) {
        a((a.j) new c(sVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r19, com.sumsub.sns.internal.core.data.model.IdentitySide r20, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.core.e.a<com.sumsub.sns.internal.ml.badphotos.models.a>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.m
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.m) r2
            int r3 = r2.f35981e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f35981e = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$m
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f35979c
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f35981e
            r5 = 1
            if (r4 == 0) goto L_0x003d
            if (r4 != r5) goto L_0x0035
            java.lang.Object r3 = r2.f35978b
            com.sumsub.sns.internal.core.data.model.IdentitySide r3 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r3
            java.lang.Object r2 = r2.f35977a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r2
            kotlin.k.b(r1)
            goto L_0x0061
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "DocCapture"
            java.lang.String r8 = "analyzePhoto ... "
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
            com.sumsub.sns.internal.ml.core.e<android.graphics.Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> r1 = r0.G
            r2.f35977a = r0
            r4 = r20
            r2.f35978b = r4
            r2.f35981e = r5
            r5 = r19
            java.lang.Object r1 = r1.a(r5, r2)
            if (r1 != r3) goto L_0x005f
            return r3
        L_0x005f:
            r2 = r0
            r3 = r4
        L_0x0061:
            com.sumsub.sns.internal.ml.core.e$a r1 = (com.sumsub.sns.internal.ml.core.e.a) r1
            boolean r4 = r1 instanceof com.sumsub.sns.internal.ml.core.e.a.d
            r5 = 0
            if (r4 == 0) goto L_0x006c
            r4 = r1
            com.sumsub.sns.internal.ml.core.e$a$d r4 = (com.sumsub.sns.internal.ml.core.e.a.d) r4
            goto L_0x006d
        L_0x006c:
            r4 = r5
        L_0x006d:
            if (r4 == 0) goto L_0x0076
            java.lang.Object r4 = r4.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r4 = (com.sumsub.sns.internal.ml.badphotos.models.a) r4
            goto L_0x0077
        L_0x0076:
            r4 = r5
        L_0x0077:
            java.util.Map r6 = r2.B()
            java.lang.String r7 = r3.getValue()
            java.lang.Object r6 = r6.get(r7)
            com.sumsub.sns.internal.ml.badphotos.models.b r6 = (com.sumsub.sns.internal.ml.badphotos.models.b) r6
            r7 = 0
            if (r6 == 0) goto L_0x0093
            java.lang.Integer r6 = r6.j()
            if (r6 == 0) goto L_0x0093
            int r6 = r6.intValue()
            goto L_0x0094
        L_0x0093:
            r6 = r7
        L_0x0094:
            if (r4 == 0) goto L_0x00aa
            float r8 = r4.c()
            com.sumsub.sns.internal.ml.badphotos.c$a r9 = com.sumsub.sns.internal.ml.badphotos.c.f34958h
            com.sumsub.sns.internal.ml.badphotos.c r9 = r9.a()
            float r9 = r9.l()
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x00aa
            int r6 = r6 + 1
        L_0x00aa:
            java.lang.String r3 = r3.getValue()
            com.sumsub.sns.internal.ml.badphotos.models.b r15 = new com.sumsub.sns.internal.ml.badphotos.models.b
            java.lang.String r9 = r1.a()
            if (r4 == 0) goto L_0x00bc
            java.lang.String r8 = r4.b()
            r10 = r8
            goto L_0x00bd
        L_0x00bc:
            r10 = r5
        L_0x00bd:
            if (r4 == 0) goto L_0x00c9
            float r8 = r4.c()
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.a.b(r8)
            r11 = r8
            goto L_0x00ca
        L_0x00c9:
            r11 = r5
        L_0x00ca:
            if (r4 == 0) goto L_0x00d4
            long r4 = r4.a()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.a.d(r4)
        L_0x00d4:
            r12 = r5
            com.sumsub.sns.internal.ml.badphotos.c$a r4 = com.sumsub.sns.internal.ml.badphotos.c.f34958h
            com.sumsub.sns.internal.ml.badphotos.c r5 = r4.a()
            float r5 = r5.l()
            java.lang.Float r13 = kotlin.coroutines.jvm.internal.a.b(r5)
            com.sumsub.sns.internal.ml.badphotos.c r5 = r4.a()
            float r5 = r5.k()
            java.lang.Float r14 = kotlin.coroutines.jvm.internal.a.b(r5)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.a.c(r6)
            com.sumsub.sns.internal.ml.badphotos.c r4 = r4.a()
            int r4 = r4.m()
            java.lang.Integer r16 = kotlin.coroutines.jvm.internal.a.c(r4)
            java.lang.Boolean r17 = kotlin.coroutines.jvm.internal.a.a(r7)
            r8 = r15
            r4 = r15
            r15 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2.a((java.lang.String) r3, (com.sumsub.sns.internal.ml.badphotos.models.b) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(android.graphics.Bitmap, com.sumsub.sns.internal.core.data.model.IdentitySide, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b1, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e0, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36057a = r8;
        r3.f36058b = r5;
        r3.f36059c = r7;
        r3.f36060d = r2;
        r3.f36061e = r1;
        r3.f36064h = 3;
        r9 = r8.a("sns_preview_imageIssues_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f5, code lost:
        if (r9 != r4) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f7, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f8, code lost:
        r18 = r5;
        r17 = r7;
        r5 = r8;
        r8 = r2;
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ff, code lost:
        r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content(r8, (java.lang.CharSequence) r2, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a) null, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a) null, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.Icon.WARNING, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.WARNING, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.b) null, 76, (kotlin.jvm.internal.r) null);
        r7 = r5.B().get(r18.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0121, code lost:
        if (r7 == null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0123, code lost:
        r7 = r7.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0127, code lost:
        if (r7 == null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0129, code lost:
        r7 = r7.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x012e, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0136, code lost:
        if (r1 < r17.k()) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0138, code lost:
        r3.f36057a = null;
        r3.f36058b = null;
        r3.f36059c = null;
        r3.f36060d = null;
        r3.f36064h = 4;
        r2 = r5.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0147, code lost:
        if (r2 != r4) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0149, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0151, code lost:
        if (r1 >= r17.l()) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0157, code lost:
        if (r7 > r17.m()) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0159, code lost:
        r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN;
        r3.f36057a = r7;
        r3.f36058b = r1;
        r3.f36059c = null;
        r3.f36060d = null;
        r3.f36064h = 5;
        r3 = r5.a("sns_preview_photo_action_retake", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016a, code lost:
        if (r3 != r4) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x016d, code lost:
        r19 = r3;
        r3 = r7;
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0188, code lost:
        r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.CONTINUE;
        r3.f36057a = r5;
        r3.f36058b = r7;
        r3.f36059c = r1;
        r3.f36060d = null;
        r3.f36064h = 6;
        r7 = r5.a("sns_preview_photo_action_accept", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x019b, code lost:
        if (r7 != r4) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x019d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x019e, code lost:
        r19 = r5;
        r5 = r7;
        r2 = r7;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a4, code lost:
        r8 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r1, (java.lang.CharSequence) r2);
        r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN;
        r3.f36057a = r5;
        r3.f36058b = r8;
        r3.f36059c = r1;
        r3.f36064h = 7;
        r2 = r7.a("sns_preview_photo_action_retake", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ba, code lost:
        if (r2 != r4) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01bc, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bd, code lost:
        r3 = r5;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r3, (java.lang.CharSequence) null, (java.lang.CharSequence) null, r6, new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r1, (java.lang.CharSequence) r2), (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.Icon) null, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State) null, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.b) null, 115, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r3, (java.lang.CharSequence) null, (java.lang.CharSequence) null, new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r1, (java.lang.CharSequence) r2), (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a) null, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.Icon) null, com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.BLOCKING, (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.b) null, 91, (java.lang.Object) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.IdentitySide r21, com.sumsub.sns.internal.ml.core.e.a<com.sumsub.sns.internal.ml.badphotos.models.a> r22, kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content> r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = r23
            boolean r3 = r2 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.u
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$u r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.u) r3
            int r4 = r3.f36064h
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f36064h = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$u r3 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$u
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f36062f
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f36064h
            java.lang.String r6 = "sns_preview_photo_action_retake"
            switch(r5) {
                case 0: goto L_0x00a0;
                case 1: goto L_0x009c;
                case 2: goto L_0x0085;
                case 3: goto L_0x0068;
                case 4: goto L_0x0063;
                case 5: goto L_0x0056;
                case 6: goto L_0x0045;
                case 7: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0033:
            java.lang.Object r1 = r3.f36059c
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1
            java.lang.Object r4 = r3.f36058b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a) r4
            java.lang.Object r3 = r3.f36057a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r3
            kotlin.k.b(r2)
            r6 = r4
            goto L_0x01bf
        L_0x0045:
            java.lang.Object r1 = r3.f36059c
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1
            java.lang.Object r5 = r3.f36058b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r5 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r5
            java.lang.Object r7 = r3.f36057a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r7
            kotlin.k.b(r2)
            goto L_0x01a4
        L_0x0056:
            java.lang.Object r1 = r3.f36058b
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction) r1
            java.lang.Object r3 = r3.f36057a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r3 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content) r3
            kotlin.k.b(r2)
            goto L_0x0172
        L_0x0063:
            kotlin.k.b(r2)
            goto L_0x014a
        L_0x0068:
            float r1 = r3.f36061e
            java.lang.Object r5 = r3.f36060d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r7 = r3.f36059c
            com.sumsub.sns.internal.ml.badphotos.c r7 = (com.sumsub.sns.internal.ml.badphotos.c) r7
            java.lang.Object r8 = r3.f36058b
            com.sumsub.sns.internal.core.data.model.IdentitySide r8 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r8
            java.lang.Object r9 = r3.f36057a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r9 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r9
            kotlin.k.b(r2)
            r17 = r7
            r18 = r8
            r8 = r5
            r5 = r9
            goto L_0x00ff
        L_0x0085:
            float r1 = r3.f36061e
            java.lang.Object r5 = r3.f36059c
            com.sumsub.sns.internal.ml.badphotos.c r5 = (com.sumsub.sns.internal.ml.badphotos.c) r5
            java.lang.Object r7 = r3.f36058b
            com.sumsub.sns.internal.core.data.model.IdentitySide r7 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r7
            java.lang.Object r8 = r3.f36057a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r8 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r8
            kotlin.k.b(r2)
            r19 = r7
            r7 = r5
            r5 = r19
            goto L_0x00e0
        L_0x009c:
            kotlin.k.b(r2)
            goto L_0x00b1
        L_0x00a0:
            kotlin.k.b(r2)
            boolean r2 = r1 instanceof com.sumsub.sns.internal.ml.core.e.a.d
            if (r2 != 0) goto L_0x00b2
            r1 = 1
            r3.f36064h = r1
            java.lang.Object r2 = r0.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r3)
            if (r2 != r4) goto L_0x00b1
            return r4
        L_0x00b1:
            return r2
        L_0x00b2:
            com.sumsub.sns.internal.ml.badphotos.c$a r2 = com.sumsub.sns.internal.ml.badphotos.c.f34958h
            com.sumsub.sns.internal.ml.badphotos.c r2 = r2.a()
            com.sumsub.sns.internal.ml.core.e$a$d r1 = (com.sumsub.sns.internal.ml.core.e.a.d) r1
            java.lang.Object r1 = r1.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r1 = (com.sumsub.sns.internal.ml.badphotos.models.a) r1
            float r1 = r1.c()
            r3.f36057a = r0
            r5 = r21
            r3.f36058b = r5
            r3.f36059c = r2
            r3.f36061e = r1
            r7 = 2
            r3.f36064h = r7
            java.lang.String r7 = "sns_preview_imageIssues_title"
            java.lang.Object r7 = r0.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r7 != r4) goto L_0x00da
            return r4
        L_0x00da:
            r8 = r0
            r19 = r7
            r7 = r2
            r2 = r19
        L_0x00e0:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36057a = r8
            r3.f36058b = r5
            r3.f36059c = r7
            r3.f36060d = r2
            r3.f36061e = r1
            r9 = 3
            r3.f36064h = r9
            java.lang.String r9 = "sns_preview_imageIssues_subtitle"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r9 != r4) goto L_0x00f8
            return r4
        L_0x00f8:
            r18 = r5
            r17 = r7
            r5 = r8
            r8 = r2
            r2 = r9
        L_0x00ff:
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$Icon r12 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.Icon.WARNING
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r13 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.WARNING
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content
            r10 = 0
            r11 = 0
            r14 = 0
            r15 = 76
            r16 = 0
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.util.Map r7 = r5.B()
            java.lang.String r8 = r18.getValue()
            java.lang.Object r7 = r7.get(r8)
            com.sumsub.sns.internal.ml.badphotos.models.b r7 = (com.sumsub.sns.internal.ml.badphotos.models.b) r7
            if (r7 == 0) goto L_0x012e
            java.lang.Integer r7 = r7.j()
            if (r7 == 0) goto L_0x012e
            int r7 = r7.intValue()
            goto L_0x012f
        L_0x012e:
            r7 = 0
        L_0x012f:
            float r8 = r17.k()
            int r8 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r9 = 0
            if (r8 < 0) goto L_0x014b
            r3.f36057a = r9
            r3.f36058b = r9
            r3.f36059c = r9
            r3.f36060d = r9
            r1 = 4
            r3.f36064h = r1
            java.lang.Object r2 = r5.e((kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content>) r3)
            if (r2 != r4) goto L_0x014a
            return r4
        L_0x014a:
            return r2
        L_0x014b:
            float r8 = r17.l()
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0188
            int r1 = r17.m()
            if (r7 > r1) goto L_0x0188
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN
            r3.f36057a = r2
            r3.f36058b = r1
            r3.f36059c = r9
            r3.f36060d = r9
            r7 = 5
            r3.f36064h = r7
            java.lang.Object r3 = r5.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x016d
            return r4
        L_0x016d:
            r19 = r3
            r3 = r2
            r2 = r19
        L_0x0172:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r6 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a
            r6.<init>(r1, r2)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$State r9 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.State.BLOCKING
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 91
            r12 = 0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x01d2
        L_0x0188:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.CONTINUE
            r3.f36057a = r5
            r3.f36058b = r2
            r3.f36059c = r1
            r3.f36060d = r9
            r7 = 6
            r3.f36064h = r7
            java.lang.String r7 = "sns_preview_photo_action_accept"
            java.lang.Object r7 = r5.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r7 != r4) goto L_0x019e
            return r4
        L_0x019e:
            r19 = r5
            r5 = r2
            r2 = r7
            r7 = r19
        L_0x01a4:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r8 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a
            r8.<init>(r1, r2)
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$ButtonAction r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.ButtonAction.TRY_AGAIN
            r3.f36057a = r5
            r3.f36058b = r8
            r3.f36059c = r1
            r2 = 7
            r3.f36064h = r2
            java.lang.Object r2 = r7.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x01bd
            return r4
        L_0x01bd:
            r3 = r5
            r6 = r8
        L_0x01bf:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a r7 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content$a
            r7.<init>(r1, r2)
            r4 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 115(0x73, float:1.61E-43)
            r12 = 0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$Content r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.Content.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x01d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(com.sumsub.sns.internal.core.data.model.IdentitySide, com.sumsub.sns.internal.ml.core.e$a, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(Exception exc) {
        com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Exception while uploading identity photos", exc);
        com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a.b(DocCapture.f31492c, "Exception while uploading identity photos", exc);
        b(false);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) exc, v(), (Object) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new a0((kotlin.coroutines.c<? super a0>) null), 1, (Object) null);
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof a.j) {
            a((a.j) parcelable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (kotlin.jvm.internal.x.b(r0 != null ? r0.r() : null, com.sumsub.sns.internal.core.data.model.VideoRequiredType.Disabled.getValue()) != false) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r17, boolean r18, com.sumsub.sns.internal.core.data.model.g r19, kotlin.coroutines.c r20) {
        /*
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.l0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$l0 r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.l0) r2
            int r3 = r2.f35976h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f35976h = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$l0 r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$l0
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f35974f
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f35976h
            r5 = 1
            if (r4 == 0) goto L_0x0049
            if (r4 != r5) goto L_0x0041
            boolean r0 = r2.f35973e
            boolean r3 = r2.f35972d
            java.lang.Object r4 = r2.f35971c
            com.sumsub.sns.internal.core.data.model.Document r4 = (com.sumsub.sns.internal.core.data.model.Document) r4
            java.lang.Object r6 = r2.f35970b
            com.sumsub.sns.internal.core.data.model.g r6 = (com.sumsub.sns.internal.core.data.model.g) r6
            java.lang.Object r2 = r2.f35969a
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel) r2
            kotlin.k.b(r1)
            r7 = r0
            r0 = r2
            r12 = r3
            r8 = r4
            goto L_0x006f
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            kotlin.k.b(r1)
            boolean r1 = r17.K()
            com.sumsub.sns.internal.core.data.model.Document r4 = r17.u()
            r2.f35969a = r0
            r6 = r19
            r2.f35970b = r6
            r2.f35971c = r4
            r7 = r18
            r2.f35972d = r7
            r2.f35973e = r1
            r2.f35976h = r5
            java.lang.Object r2 = r0.h((kotlin.coroutines.c<? super java.util.List<? extends com.sumsub.sns.internal.core.data.model.IdentitySide>>) r2)
            if (r2 != r3) goto L_0x006b
            return r3
        L_0x006b:
            r8 = r4
            r12 = r7
            r7 = r1
            r1 = r2
        L_0x006f:
            r9 = r1
            java.util.List r9 = (java.util.List) r9
            com.sumsub.sns.internal.core.data.model.Document r1 = r0.u()
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
            com.sumsub.sns.internal.core.data.model.e r0 = r0.d()
            r2 = 0
            if (r0 == 0) goto L_0x008d
            java.lang.String r3 = r1.c()
            boolean r0 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r0, (java.lang.String) r3)
            if (r0 != r5) goto L_0x008d
            r0 = r5
            goto L_0x008e
        L_0x008d:
            r0 = r2
        L_0x008e:
            if (r0 != 0) goto L_0x00b7
            boolean r0 = r1.h()
            if (r0 != 0) goto L_0x00b7
            boolean r0 = r1.k()
            if (r0 == 0) goto L_0x00b5
            com.sumsub.sns.internal.core.data.model.g$c$a r0 = r6.a((com.sumsub.sns.internal.core.data.model.DocumentType) r1)
            if (r0 == 0) goto L_0x00a7
            java.lang.String r0 = r0.r()
            goto L_0x00a8
        L_0x00a7:
            r0 = 0
        L_0x00a8:
            com.sumsub.sns.internal.core.data.model.VideoRequiredType r1 = com.sumsub.sns.internal.core.data.model.VideoRequiredType.Disabled
            java.lang.String r1 = r1.getValue()
            boolean r0 = kotlin.jvm.internal.x.b(r0, r1)
            if (r0 == 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r10 = r2
            goto L_0x00b8
        L_0x00b7:
            r10 = r5
        L_0x00b8:
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 16
            r16 = 0
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$f
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel, boolean, com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x009b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x023b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r18, kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.s
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$s r2 = (com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.s) r2
            int r3 = r2.f36025d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36025d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$s r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$s
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36023b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36025d
            java.lang.String r5 = "doubleSided"
            r6 = 2
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x003e
            if (r4 != r8) goto L_0x0036
            java.lang.Object r2 = r2.f36022a
            java.util.Map r2 = (java.util.Map) r2
            kotlin.k.b(r1)
            goto L_0x0109
        L_0x0036:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003e:
            kotlin.k.b(r1)
            java.lang.String r1 = r17.s()
            if (r1 == 0) goto L_0x00ea
            com.sumsub.sns.internal.core.data.model.e r4 = r17.d()
            if (r4 == 0) goto L_0x00ea
            java.util.Map r4 = r4.v()
            if (r4 == 0) goto L_0x00ea
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r1)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r4
            int r4 = r1.size()
            int r4 = r4 - r8
            kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r7, r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x006b:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x00d6
            r11 = r4
            kotlin.collections.IntIterator r11 = (kotlin.collections.IntIterator) r11
            int r11 = r11.a()
            T r12 = r10.element
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r11 = r1.get(r11)
            java.lang.Object r11 = r12.get(r11)
            boolean r12 = r11 instanceof java.util.Map
            if (r12 == 0) goto L_0x008b
            java.util.Map r11 = (java.util.Map) r11
            goto L_0x008c
        L_0x008b:
            r11 = 0
        L_0x008c:
            if (r11 == 0) goto L_0x00ea
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x009b:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00cc
            java.lang.Object r13 = r11.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            boolean r15 = r14 instanceof java.lang.String
            if (r15 != 0) goto L_0x00b0
            r14 = 0
        L_0x00b0:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L_0x00b5
            goto L_0x00c0
        L_0x00b5:
            java.lang.Object r13 = r13.getValue()
            boolean r15 = r13 instanceof java.lang.Object
            if (r15 != 0) goto L_0x00be
            r13 = 0
        L_0x00be:
            if (r13 != 0) goto L_0x00c2
        L_0x00c0:
            r13 = 0
            goto L_0x00c6
        L_0x00c2:
            kotlin.Pair r13 = kotlin.l.a(r14, r13)
        L_0x00c6:
            if (r13 == 0) goto L_0x009b
            r12.add(r13)
            goto L_0x009b
        L_0x00cc:
            java.util.Map r11 = kotlin.collections.MapsKt__MapsKt.s(r12)
            if (r11 != 0) goto L_0x00d3
            goto L_0x00ea
        L_0x00d3:
            r10.element = r11
            goto L_0x006b
        L_0x00d6:
            T r4 = r10.element
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r1)
            java.lang.Object r1 = r4.get(r1)
            boolean r4 = r1 instanceof java.util.Map
            if (r4 != 0) goto L_0x00e7
            r1 = 0
        L_0x00e7:
            java.util.Map r1 = (java.util.Map) r1
            goto L_0x00eb
        L_0x00ea:
            r1 = 0
        L_0x00eb:
            boolean r4 = r17.H()
            if (r4 == 0) goto L_0x01e7
            if (r18 != 0) goto L_0x01e7
            java.lang.String r4 = r17.s()
            if (r4 == 0) goto L_0x028c
            r2.f36022a = r1
            r2.f36025d = r8
            java.lang.Object r2 = r0.b((java.lang.String) r4, (kotlin.coroutines.c<? super java.util.List<java.lang.String>>) r2)
            if (r2 != r3) goto L_0x0104
            return r3
        L_0x0104:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x0109:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r4)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x011a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01cb
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            if (r2 == 0) goto L_0x01c5
            java.lang.String[] r10 = new java.lang.String[r6]
            r10[r7] = r4
            r10[r8] = r5
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.n(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r2
            int r11 = r4.size()
            int r11 = r11 - r8
            kotlin.ranges.h r11 = kotlin.ranges.RangesKt___RangesKt.o(r7, r11)
            java.util.Iterator r11 = r11.iterator()
        L_0x0146:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01b1
            r12 = r11
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12
            int r12 = r12.a()
            T r13 = r10.element
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r12 = r4.get(r12)
            java.lang.Object r12 = r13.get(r12)
            boolean r13 = r12 instanceof java.util.Map
            if (r13 == 0) goto L_0x0166
            java.util.Map r12 = (java.util.Map) r12
            goto L_0x0167
        L_0x0166:
            r12 = 0
        L_0x0167:
            if (r12 == 0) goto L_0x01c5
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0176:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x01a7
            java.lang.Object r14 = r12.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r15 = r14.getKey()
            boolean r9 = r15 instanceof java.lang.String
            if (r9 != 0) goto L_0x018b
            r15 = 0
        L_0x018b:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L_0x0190
            goto L_0x019b
        L_0x0190:
            java.lang.Object r9 = r14.getValue()
            boolean r14 = r9 instanceof java.lang.Object
            if (r14 != 0) goto L_0x0199
            r9 = 0
        L_0x0199:
            if (r9 != 0) goto L_0x019d
        L_0x019b:
            r9 = 0
            goto L_0x01a1
        L_0x019d:
            kotlin.Pair r9 = kotlin.l.a(r15, r9)
        L_0x01a1:
            if (r9 == 0) goto L_0x0176
            r13.add(r9)
            goto L_0x0176
        L_0x01a7:
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.s(r13)
            if (r9 != 0) goto L_0x01ae
            goto L_0x01c5
        L_0x01ae:
            r10.element = r9
            goto L_0x0146
        L_0x01b1:
            T r9 = r10.element
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r4)
            java.lang.Object r4 = r9.get(r4)
            boolean r9 = r4 instanceof java.lang.Boolean
            if (r9 != 0) goto L_0x01c2
            r4 = 0
        L_0x01c2:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x01c6
        L_0x01c5:
            r4 = 0
        L_0x01c6:
            r3.add(r4)
            goto L_0x011a
        L_0x01cb:
            java.util.Set r1 = kotlin.collections.CollectionsKt___CollectionsKt.N0(r3)
            int r2 = r1.size()
            if (r2 != r8) goto L_0x01d7
            r2 = r8
            goto L_0x01d8
        L_0x01d7:
            r2 = r7
        L_0x01d8:
            if (r2 == 0) goto L_0x01db
            goto L_0x01dc
        L_0x01db:
            r1 = 0
        L_0x01dc:
            if (r1 == 0) goto L_0x028c
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.Z(r1)
            r9 = r1
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x028d
        L_0x01e7:
            if (r1 == 0) goto L_0x028c
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r3 = r17.v()
            r2[r7] = r3
            r2[r8] = r5
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.n(r2)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r1
            int r1 = r2.size()
            int r1 = r1 - r8
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r7, r1)
            java.util.Iterator r1 = r1.iterator()
        L_0x020b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0276
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.a()
            T r5 = r3.element
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r4 = r2.get(r4)
            java.lang.Object r4 = r5.get(r4)
            boolean r5 = r4 instanceof java.util.Map
            if (r5 == 0) goto L_0x022b
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x022c
        L_0x022b:
            r4 = 0
        L_0x022c:
            if (r4 == 0) goto L_0x028c
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x023b:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x026c
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r9 = r6.getKey()
            boolean r10 = r9 instanceof java.lang.String
            if (r10 != 0) goto L_0x0250
            r9 = 0
        L_0x0250:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x0255
            goto L_0x0260
        L_0x0255:
            java.lang.Object r6 = r6.getValue()
            boolean r10 = r6 instanceof java.lang.Object
            if (r10 != 0) goto L_0x025e
            r6 = 0
        L_0x025e:
            if (r6 != 0) goto L_0x0262
        L_0x0260:
            r6 = 0
            goto L_0x0266
        L_0x0262:
            kotlin.Pair r6 = kotlin.l.a(r9, r6)
        L_0x0266:
            if (r6 == 0) goto L_0x023b
            r5.add(r6)
            goto L_0x023b
        L_0x026c:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r5)
            if (r4 != 0) goto L_0x0273
            goto L_0x028c
        L_0x0273:
            r3.element = r4
            goto L_0x020b
        L_0x0276:
            T r1 = r3.element
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)
            java.lang.Object r1 = r1.get(r2)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 != 0) goto L_0x0288
            r9 = 0
            goto L_0x0289
        L_0x0288:
            r9 = r1
        L_0x0289:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x028d
        L_0x028c:
            r9 = 0
        L_0x028d:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r8)
            boolean r1 = kotlin.jvm.internal.x.b(r9, r1)
            if (r1 == 0) goto L_0x029a
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness.DOUBLE
            goto L_0x02a9
        L_0x029a:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            boolean r1 = kotlin.jvm.internal.x.b(r9, r1)
            if (r1 == 0) goto L_0x02a7
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness.SINGLE
            goto L_0x02a9
        L_0x02a7:
            com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel$DocumentSideness r1 = com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel.DocumentSideness.UNKNOWN
        L_0x02a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.a(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return sNSPreviewPhotoDocumentViewModel.a(z11, (kotlin.coroutines.c<? super SNSPreviewIdentityDocumentViewModel.DocumentSideness>) cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: documentSideness");
    }

    public final void a(File file, int i11) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "onPhotoRotationChanged: " + file.getName() + " -> " + i11, (Throwable) null, 4, (Object) null);
        String absolutePath = file.getAbsolutePath();
        Map y11 = MapsKt__MapsKt.y(E());
        b bVar2 = (b) y11.get(absolutePath);
        if (bVar2 != null) {
            y11.put(absolutePath, bVar2.a(i11));
            d((Map<String, b>) Util.toImmutableMap(y11));
            com.sumsub.sns.core.presentation.base.a.a(this, false, new e0(file, i11, this, (kotlin.coroutines.c<? super e0>) null), 1, (Object) null);
        }
    }

    public final void a(int i11) {
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "onPageSelected: " + i11, (Throwable) null, 4, (Object) null);
    }

    public void a(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (oVar instanceof o.e) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) null, (Object) null, (Long) null, 7, (Object) null);
        } else {
            super.a(oVar);
        }
    }
}

package com.sumsub.sns.presentation.screen;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.presentation.intro.IntroScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public class b implements a.j {

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f39579a;

        /* renamed from: b  reason: collision with root package name */
        public final Parcelable f39580b;

        public a(boolean z11, Parcelable parcelable) {
            this.f39579a = z11;
            this.f39580b = parcelable;
        }

        public final boolean a() {
            return this.f39579a;
        }

        public final Parcelable b() {
            return this.f39580b;
        }

        public final Parcelable c() {
            return this.f39580b;
        }

        public final boolean d() {
            return this.f39579a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f39579a == aVar.f39579a && x.b(this.f39580b, aVar.f39580b);
        }

        public int hashCode() {
            boolean z11 = this.f39579a;
            if (z11) {
                z11 = true;
            }
            return ((z11 ? 1 : 0) * true) + this.f39580b.hashCode();
        }

        public String toString() {
            return "AfterInstructionsEvent(success=" + this.f39579a + ", payload=" + this.f39580b + ')';
        }

        public final a a(boolean z11, Parcelable parcelable) {
            return new a(z11, parcelable);
        }

        public static /* synthetic */ a a(a aVar, boolean z11, Parcelable parcelable, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = aVar.f39579a;
            }
            if ((i11 & 2) != 0) {
                parcelable = aVar.f39580b;
            }
            return aVar.a(z11, parcelable);
        }
    }

    /* renamed from: com.sumsub.sns.presentation.screen.b$b  reason: collision with other inner class name */
    public static final class C0521b extends b {

        /* renamed from: a  reason: collision with root package name */
        public final SNSCompletionResult f39581a;

        public C0521b(SNSCompletionResult sNSCompletionResult) {
            this.f39581a = sNSCompletionResult;
        }

        public final SNSCompletionResult a() {
            return this.f39581a;
        }

        public final SNSCompletionResult b() {
            return this.f39581a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0521b) && x.b(this.f39581a, ((C0521b) obj).f39581a);
        }

        public int hashCode() {
            return this.f39581a.hashCode();
        }

        public String toString() {
            return "Cancel(result=" + this.f39581a + ')';
        }

        public final C0521b a(SNSCompletionResult sNSCompletionResult) {
            return new C0521b(sNSCompletionResult);
        }

        public static /* synthetic */ C0521b a(C0521b bVar, SNSCompletionResult sNSCompletionResult, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sNSCompletionResult = bVar.f39581a;
            }
            return bVar.a(sNSCompletionResult);
        }
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final o f39582a;

        public c(o oVar) {
            this.f39582a = oVar;
        }

        public final o a() {
            return this.f39582a;
        }

        public final o b() {
            return this.f39582a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f39582a, ((c) obj).f39582a);
        }

        public int hashCode() {
            return this.f39582a.hashCode();
        }

        public String toString() {
            return "HandleError(error=" + this.f39582a + ')';
        }

        public final c a(o oVar) {
            return new c(oVar);
        }

        public static /* synthetic */ c a(c cVar, o oVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                oVar = cVar.f39582a;
            }
            return cVar.a(oVar);
        }
    }

    public static abstract class d extends b implements Parcelable {

        /* renamed from: a  reason: collision with root package name */
        public com.sumsub.sns.internal.core.domain.model.c f39583a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f39584b;

        public static final class a extends d {
            public static final Parcelable.Creator<a> CREATOR = new C0522a();

            /* renamed from: c  reason: collision with root package name */
            public static final a f39585c = new a();

            /* renamed from: com.sumsub.sns.presentation.screen.b$d$a$a  reason: collision with other inner class name */
            public static final class C0522a implements Parcelable.Creator<a> {
                /* renamed from: a */
                public final a createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return a.f39585c;
                }

                /* renamed from: a */
                public final a[] newArray(int i11) {
                    return new a[i11];
                }
            }

            public a() {
                super((com.sumsub.sns.internal.core.domain.model.c) null, false, 3, (r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        /* renamed from: com.sumsub.sns.presentation.screen.b$d$b  reason: collision with other inner class name */
        public static final class C0523b extends d {
            public static final Parcelable.Creator<C0523b> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39586c;

            /* renamed from: com.sumsub.sns.presentation.screen.b$d$b$a */
            public static final class a implements Parcelable.Creator<C0523b> {
                /* renamed from: a */
                public final C0523b createFromParcel(Parcel parcel) {
                    return new C0523b(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final C0523b[] newArray(int i11) {
                    return new C0523b[i11];
                }
            }

            public C0523b(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.DATA.getSceneName(), (String) null, false, 12, (r) null), false, 2, (r) null);
                this.f39586c = document;
            }

            public final C0523b a(Document document) {
                return new C0523b(document);
            }

            public final Document d() {
                return this.f39586c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39586c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0523b) && x.b(this.f39586c, ((C0523b) obj).f39586c);
            }

            public int hashCode() {
                return this.f39586c.hashCode();
            }

            public String toString() {
                return "ApplicantData(doc=" + this.f39586c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39586c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ C0523b a(C0523b bVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = bVar.f39586c;
                }
                return bVar.a(document);
            }
        }

        public static final class c extends d {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public static final c f39587c = new c();

            public static final class a implements Parcelable.Creator<c> {
                /* renamed from: a */
                public final c createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return c.f39587c;
                }

                /* renamed from: a */
                public final c[] newArray(int i11) {
                    return new c[i11];
                }
            }

            public c() {
                super((com.sumsub.sns.internal.core.domain.model.c) null, false, 3, (r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        /* renamed from: com.sumsub.sns.presentation.screen.b$d$d  reason: collision with other inner class name */
        public static final class C0524d extends d {
            public static final Parcelable.Creator<C0524d> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39588c;

            /* renamed from: com.sumsub.sns.presentation.screen.b$d$d$a */
            public static final class a implements Parcelable.Creator<C0524d> {
                /* renamed from: a */
                public final C0524d createFromParcel(Parcel parcel) {
                    return new C0524d(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final C0524d[] newArray(int i11) {
                    return new C0524d[i11];
                }
            }

            public C0524d(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.CONFIRMATION.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39588c = document;
            }

            public final C0524d a(Document document) {
                return new C0524d(document);
            }

            public final Document d() {
                return this.f39588c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39588c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0524d) && x.b(this.f39588c, ((C0524d) obj).f39588c);
            }

            public int hashCode() {
                return this.f39588c.hashCode();
            }

            public String toString() {
                return "ConfirmEmail(doc=" + this.f39588c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39588c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ C0524d a(C0524d dVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = dVar.f39588c;
                }
                return dVar.a(document);
            }
        }

        public static final class e extends d {
            public static final Parcelable.Creator<e> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39589c;

            public static final class a implements Parcelable.Creator<e> {
                /* renamed from: a */
                public final e createFromParcel(Parcel parcel) {
                    return new e(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final e[] newArray(int i11) {
                    return new e[i11];
                }
            }

            public e(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.CONFIRMATION.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39589c = document;
            }

            public final e a(Document document) {
                return new e(document);
            }

            public final Document d() {
                return this.f39589c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39589c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && x.b(this.f39589c, ((e) obj).f39589c);
            }

            public int hashCode() {
                return this.f39589c.hashCode();
            }

            public String toString() {
                return "ConfirmPhone(doc=" + this.f39589c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39589c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ e a(e eVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = eVar.f39589c;
                }
                return eVar.a(document);
            }
        }

        public static final class f extends d {
            public static final Parcelable.Creator<f> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39590c;

            public static final class a implements Parcelable.Creator<f> {
                /* renamed from: a */
                public final f createFromParcel(Parcel parcel) {
                    return new f(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final f[] newArray(int i11) {
                    return new f[i11];
                }
            }

            public f(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.EKYC.getSceneName(), (String) null, false, 12, (r) null), false, 2, (r) null);
                this.f39590c = document;
            }

            public final f a(Document document) {
                return new f(document);
            }

            public final Document d() {
                return this.f39590c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39590c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && x.b(this.f39590c, ((f) obj).f39590c);
            }

            public int hashCode() {
                return this.f39590c.hashCode();
            }

            public String toString() {
                return "Ekyc(doc=" + this.f39590c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39590c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ f a(f fVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = fVar.f39590c;
                }
                return fVar.a(document);
            }
        }

        public static final class g extends d {
            public static final Parcelable.Creator<g> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39591c;

            public static final class a implements Parcelable.Creator<g> {
                /* renamed from: a */
                public final g createFromParcel(Parcel parcel) {
                    return new g(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final g[] newArray(int i11) {
                    return new g[i11];
                }
            }

            public g(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.GEO.getSceneName(), (String) null, false, 12, (r) null), false, 2, (r) null);
                this.f39591c = document;
            }

            public final g a(Document document) {
                return new g(document);
            }

            public final Document d() {
                return this.f39591c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39591c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && x.b(this.f39591c, ((g) obj).f39591c);
            }

            public int hashCode() {
                return this.f39591c.hashCode();
            }

            public String toString() {
                return "Geolocation(doc=" + this.f39591c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39591c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ g a(g gVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = gVar.f39591c;
                }
                return gVar.a(document);
            }
        }

        public static final class h extends d {
            public static final Parcelable.Creator<h> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39592c;

            public static final class a implements Parcelable.Creator<h> {
                /* renamed from: a */
                public final h createFromParcel(Parcel parcel) {
                    return new h(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final h[] newArray(int i11) {
                    return new h[i11];
                }
            }

            public h(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.FACESCAN.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39592c = document;
            }

            public final h a(Document document) {
                return new h(document);
            }

            public final Document d() {
                return this.f39592c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39592c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof h) && x.b(this.f39592c, ((h) obj).f39592c);
            }

            public int hashCode() {
                return this.f39592c.hashCode();
            }

            public String toString() {
                return "Liveness(doc=" + this.f39592c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39592c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ h a(h hVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = hVar.f39592c;
                }
                return hVar.a(document);
            }
        }

        public static final class i extends d {
            public static final Parcelable.Creator<i> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39593c;

            public static final class a implements Parcelable.Creator<i> {
                /* renamed from: a */
                public final i createFromParcel(Parcel parcel) {
                    return new i(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final i[] newArray(int i11) {
                    return new i[i11];
                }
            }

            public i(Document document) {
                super((com.sumsub.sns.internal.core.domain.model.c) null, false, 3, (r) null);
                this.f39593c = document;
            }

            public final i a(Document document) {
                return new i(document);
            }

            public final Document d() {
                return this.f39593c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39593c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof i) && x.b(this.f39593c, ((i) obj).f39593c);
            }

            public int hashCode() {
                return this.f39593c.hashCode();
            }

            public String toString() {
                return "PreviewIdentity(doc=" + this.f39593c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39593c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ i a(i iVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = iVar.f39593c;
                }
                return iVar.a(document);
            }
        }

        public static final class j extends d {
            public static final Parcelable.Creator<j> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39594c;

            public static final class a implements Parcelable.Creator<j> {
                /* renamed from: a */
                public final j createFromParcel(Parcel parcel) {
                    return new j(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final j[] newArray(int i11) {
                    return new j[i11];
                }
            }

            public j(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.PORTRAIT_SELFIE.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39594c = document;
            }

            public final j a(Document document) {
                return new j(document);
            }

            public final Document d() {
                return this.f39594c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39594c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof j) && x.b(this.f39594c, ((j) obj).f39594c);
            }

            public int hashCode() {
                return this.f39594c.hashCode();
            }

            public String toString() {
                return "PreviewPhotoSelfie(doc=" + this.f39594c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39594c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ j a(j jVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = jVar.f39594c;
                }
                return jVar.a(document);
            }
        }

        public static final class k extends d {
            public static final Parcelable.Creator<k> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39595c;

            public static final class a implements Parcelable.Creator<k> {
                /* renamed from: a */
                public final k createFromParcel(Parcel parcel) {
                    return new k(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final k[] newArray(int i11) {
                    return new k[i11];
                }
            }

            public k(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.PHOTOSELFIE.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39595c = document;
            }

            public final k a(Document document) {
                return new k(document);
            }

            public final Document d() {
                return this.f39595c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39595c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof k) && x.b(this.f39595c, ((k) obj).f39595c);
            }

            public int hashCode() {
                return this.f39595c.hashCode();
            }

            public String toString() {
                return "PreviewSelfieWithDocument(doc=" + this.f39595c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39595c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ k a(k kVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = kVar.f39595c;
                }
                return kVar.a(document);
            }
        }

        public static final class l extends d {
            public static final Parcelable.Creator<l> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39596c;

            public static final class a implements Parcelable.Creator<l> {
                /* renamed from: a */
                public final l createFromParcel(Parcel parcel) {
                    return new l(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final l[] newArray(int i11) {
                    return new l[i11];
                }
            }

            public l(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.VIDEOSELFIE.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39596c = document;
            }

            public final l a(Document document) {
                return new l(document);
            }

            public final Document d() {
                return this.f39596c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39596c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof l) && x.b(this.f39596c, ((l) obj).f39596c);
            }

            public int hashCode() {
                return this.f39596c.hashCode();
            }

            public String toString() {
                return "PreviewVideoSelfie(doc=" + this.f39596c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39596c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ l a(l lVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = lVar.f39596c;
                }
                return lVar.a(document);
            }
        }

        public static final class m extends d {
            public static final Parcelable.Creator<m> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39597c;

            public static final class a implements Parcelable.Creator<m> {
                /* renamed from: a */
                public final m createFromParcel(Parcel parcel) {
                    return new m(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final m[] newArray(int i11) {
                    return new m[i11];
                }
            }

            public m(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.SCAN_FRONTSIDE.getSceneName(), (String) null, false, 12, (r) null), false, 2, (r) null);
                this.f39597c = document;
            }

            public final m a(Document document) {
                return new m(document);
            }

            public final Document d() {
                return this.f39597c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39597c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof m) && x.b(this.f39597c, ((m) obj).f39597c);
            }

            public int hashCode() {
                return this.f39597c.hashCode();
            }

            public String toString() {
                return "ProofOfAddress(doc=" + this.f39597c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39597c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ m a(m mVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = mVar.f39597c;
                }
                return mVar.a(document);
            }
        }

        public static final class n extends d {
            public static final Parcelable.Creator<n> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final Document f39598c;

            public static final class a implements Parcelable.Creator<n> {
                /* renamed from: a */
                public final n createFromParcel(Parcel parcel) {
                    return new n(Document.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: a */
                public final n[] newArray(int i11) {
                    return new n[i11];
                }
            }

            public n(Document document) {
                super(new com.sumsub.sns.internal.core.domain.model.c(document.getType().c(), IntroScene.QUESTIONNAIRE.getSceneName(), (String) null, false, 12, (r) null), true, (r) null);
                this.f39598c = document;
            }

            public final n a(Document document) {
                return new n(document);
            }

            public final Document d() {
                return this.f39598c;
            }

            public int describeContents() {
                return 0;
            }

            public final Document e() {
                return this.f39598c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof n) && x.b(this.f39598c, ((n) obj).f39598c);
            }

            public int hashCode() {
                return this.f39598c.hashCode();
            }

            public String toString() {
                return "Questionnaire(doc=" + this.f39598c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                this.f39598c.writeToParcel(parcel, i11);
            }

            public static /* synthetic */ n a(n nVar, Document document, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    document = nVar.f39598c;
                }
                return nVar.a(document);
            }
        }

        public static final class o extends d {
            public static final Parcelable.Creator<o> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public final List<Document> f39599c;

            public static final class a implements Parcelable.Creator<o> {
                /* renamed from: a */
                public final o createFromParcel(Parcel parcel) {
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i11 = 0; i11 != readInt; i11++) {
                        arrayList.add(Document.CREATOR.createFromParcel(parcel));
                    }
                    return new o(arrayList);
                }

                /* renamed from: a */
                public final o[] newArray(int i11) {
                    return new o[i11];
                }
            }

            public o(List<Document> list) {
                super(new com.sumsub.sns.internal.core.domain.model.c(DocumentType.f32356k, IntroScene.VIDEO_IDENT.getSceneName(), (String) null, false, 12, (r) null), false, 2, (r) null);
                this.f39599c = list;
            }

            public final o a(List<Document> list) {
                return new o(list);
            }

            public final List<Document> d() {
                return this.f39599c;
            }

            public int describeContents() {
                return 0;
            }

            public final List<Document> e() {
                return this.f39599c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof o) && x.b(this.f39599c, ((o) obj).f39599c);
            }

            public int hashCode() {
                return this.f39599c.hashCode();
            }

            public String toString() {
                return "VideoIdent(docs=" + this.f39599c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                List<Document> list = this.f39599c;
                parcel.writeInt(list.size());
                for (Document writeToParcel : list) {
                    writeToParcel.writeToParcel(parcel, i11);
                }
            }

            public static /* synthetic */ o a(o oVar, List<Document> list, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    list = oVar.f39599c;
                }
                return oVar.a(list);
            }
        }

        public /* synthetic */ d(com.sumsub.sns.internal.core.domain.model.c cVar, boolean z11, r rVar) {
            this(cVar, z11);
        }

        public void a(com.sumsub.sns.internal.core.domain.model.c cVar) {
            this.f39583a = cVar;
        }

        public com.sumsub.sns.internal.core.domain.model.c b() {
            return this.f39583a;
        }

        public final boolean c() {
            return this instanceof h;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(com.sumsub.sns.internal.core.domain.model.c cVar, boolean z11, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : cVar, (i11 & 2) != 0 ? false : z11, (r) null);
        }

        public boolean a() {
            return this.f39584b;
        }

        public d(com.sumsub.sns.internal.core.domain.model.c cVar, boolean z11) {
            this.f39583a = cVar;
            this.f39584b = z11;
        }
    }

    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.presentation.intro.f f39600a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f39601b;

        /* renamed from: c  reason: collision with root package name */
        public final String f39602c;

        public e(com.sumsub.sns.internal.core.presentation.intro.f fVar, boolean z11, String str) {
            this.f39600a = fVar;
            this.f39601b = z11;
            this.f39602c = str;
        }

        public final com.sumsub.sns.internal.core.presentation.intro.f a() {
            return this.f39600a;
        }

        public final boolean b() {
            return this.f39601b;
        }

        public final String c() {
            return this.f39602c;
        }

        public final boolean d() {
            return this.f39601b;
        }

        public final String e() {
            return this.f39602c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f39600a, eVar.f39600a) && this.f39601b == eVar.f39601b && x.b(this.f39602c, eVar.f39602c);
        }

        public final com.sumsub.sns.internal.core.presentation.intro.f f() {
            return this.f39600a;
        }

        public int hashCode() {
            int hashCode = this.f39600a.hashCode() * 31;
            boolean z11 = this.f39601b;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            String str = this.f39602c;
            return i11 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ShowInstructions(stepInfo=" + this.f39600a + ", cancelOnBackPressed=" + this.f39601b + ", countryCode=" + this.f39602c + ')';
        }

        public final e a(com.sumsub.sns.internal.core.presentation.intro.f fVar, boolean z11, String str) {
            return new e(fVar, z11, str);
        }

        public static /* synthetic */ e a(e eVar, com.sumsub.sns.internal.core.presentation.intro.f fVar, boolean z11, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                fVar = eVar.f39600a;
            }
            if ((i11 & 2) != 0) {
                z11 = eVar.f39601b;
            }
            if ((i11 & 4) != 0) {
                str = eVar.f39602c;
            }
            return eVar.a(fVar, z11, str);
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f39603a = new f();
    }
}

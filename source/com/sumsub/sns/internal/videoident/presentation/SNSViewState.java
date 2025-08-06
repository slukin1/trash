package com.sumsub.sns.internal.videoident.presentation;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.source.applicant.remote.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0011\u0010\n\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState;", "Lcom/sumsub/sns/core/presentation/base/a$l;", "", "getHasVideo", "()Z", "hasVideo", "isError", "isVideoCall", "isPreview", "isWaiting", "isReconnecting", "isLoading", "<init>", "()V", "a", "ErrorState", "b", "c", "d", "e", "VideoStepState", "Lcom/sumsub/sns/internal/videoident/presentation/a$c;", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$b;", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$c;", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$d;", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$e;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@Keep
public abstract class SNSViewState implements a.l {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$ErrorState;", "", "(Ljava/lang/String;I)V", "GENERAL", "UPLOAD_ERROR", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ErrorState {
        GENERAL,
        UPLOAD_ERROR
    }

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$VideoStepState;", "", "(Ljava/lang/String;I)V", "PREVIEW", "WAITING", "VIDEO_CALL", "RECONNECTING", "ERROR", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum VideoStepState {
        PREVIEW,
        WAITING,
        VIDEO_CALL,
        RECONNECTING,
        ERROR
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f36607a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f36608b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f36609c;

        public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f36607a = charSequence;
            this.f36608b = charSequence2;
            this.f36609c = charSequence3;
        }

        public final CharSequence a() {
            return this.f36607a;
        }

        public final CharSequence b() {
            return this.f36608b;
        }

        public final CharSequence c() {
            return this.f36609c;
        }

        public final CharSequence d() {
            return this.f36609c;
        }

        public final CharSequence e() {
            return this.f36608b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f36607a, aVar.f36607a) && x.b(this.f36608b, aVar.f36608b) && x.b(this.f36609c, aVar.f36609c);
        }

        public final CharSequence f() {
            return this.f36607a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f36607a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f36608b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f36609c;
            if (charSequence3 != null) {
                i11 = charSequence3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "ConfirmExitDialog(message=" + this.f36607a + ", buttonPositive=" + this.f36608b + ", buttonNegative=" + this.f36609c + ')';
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new a(charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = aVar.f36607a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = aVar.f36608b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = aVar.f36609c;
            }
            return aVar.a(charSequence, charSequence2, charSequence3);
        }
    }

    public static final class b extends SNSViewState {

        /* renamed from: a  reason: collision with root package name */
        public final String f36610a;

        /* renamed from: b  reason: collision with root package name */
        public final List<n> f36611b;

        public b(String str, List<n> list) {
            super((r) null);
            this.f36610a = str;
            this.f36611b = list;
        }

        public final String a() {
            return this.f36610a;
        }

        public final List<n> b() {
            return this.f36611b;
        }

        public final List<n> c() {
            return this.f36611b;
        }

        public final String d() {
            return this.f36610a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f36610a, bVar.f36610a) && x.b(this.f36611b, bVar.f36611b);
        }

        public int hashCode() {
            String str = this.f36610a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f36611b.hashCode();
        }

        public String toString() {
            return "LanguageSelection(selectedLanguage=" + this.f36610a + ", languages=" + this.f36611b + ')';
        }

        public final b a(String str, List<n> list) {
            return new b(str, list);
        }

        public static /* synthetic */ b a(b bVar, String str, List<n> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f36610a;
            }
            if ((i11 & 2) != 0) {
                list = bVar.f36611b;
            }
            return bVar.a(str, list);
        }
    }

    public static final class c extends SNSViewState {

        /* renamed from: a  reason: collision with root package name */
        public static final c f36612a = new c();

        public c() {
            super((r) null);
        }
    }

    public static final class d extends SNSViewState {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f36613a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f36614b;

        /* renamed from: c  reason: collision with root package name */
        public final f f36615c;

        public d() {
            this(false, false, (f) null, 7, (r) null);
        }

        public final boolean a() {
            return this.f36613a;
        }

        public final boolean b() {
            return this.f36614b;
        }

        public final f c() {
            return this.f36615c;
        }

        public final f d() {
            return this.f36615c;
        }

        public final boolean e() {
            return this.f36613a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f36613a == dVar.f36613a && this.f36614b == dVar.f36614b && x.b(this.f36615c, dVar.f36615c);
        }

        public final boolean f() {
            return this.f36614b;
        }

        public int hashCode() {
            boolean z11 = this.f36613a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            boolean z13 = this.f36614b;
            if (!z13) {
                z12 = z13;
            }
            int i12 = (i11 + (z12 ? 1 : 0)) * 31;
            f fVar = this.f36615c;
            return i12 + (fVar == null ? 0 : fVar.hashCode());
        }

        public String toString() {
            return "Permissions(showCameraExplanation=" + this.f36613a + ", showMicrophoneExplanation=" + this.f36614b + ", explanationDialog=" + this.f36615c + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(boolean z11, boolean z12, f fVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12, (i11 & 4) != 0 ? null : fVar);
        }

        public final d a(boolean z11, boolean z12, f fVar) {
            return new d(z11, z12, fVar);
        }

        public d(boolean z11, boolean z12, f fVar) {
            super((r) null);
            this.f36613a = z11;
            this.f36614b = z12;
            this.f36615c = fVar;
        }

        public static /* synthetic */ d a(d dVar, boolean z11, boolean z12, f fVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = dVar.f36613a;
            }
            if ((i11 & 2) != 0) {
                z12 = dVar.f36614b;
            }
            if ((i11 & 4) != 0) {
                fVar = dVar.f36615c;
            }
            return dVar.a(z11, z12, fVar);
        }
    }

    public static final class e extends SNSViewState {

        /* renamed from: y  reason: collision with root package name */
        public static final a f36616y = new a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final VideoStepState f36617a;

        /* renamed from: b  reason: collision with root package name */
        public final ErrorState f36618b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36619c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f36620d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f36621e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f36622f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f36623g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f36624h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f36625i;

        /* renamed from: j  reason: collision with root package name */
        public final CharSequence f36626j;

        /* renamed from: k  reason: collision with root package name */
        public final ButtonAction f36627k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f36628l;

        /* renamed from: m  reason: collision with root package name */
        public CharSequence f36629m;

        /* renamed from: n  reason: collision with root package name */
        public final k f36630n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f36631o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f36632p;

        /* renamed from: q  reason: collision with root package name */
        public e f36633q;

        /* renamed from: r  reason: collision with root package name */
        public CharSequence f36634r;

        /* renamed from: s  reason: collision with root package name */
        public List<SNSStepViewItem> f36635s;

        /* renamed from: t  reason: collision with root package name */
        public Bitmap f36636t;

        /* renamed from: u  reason: collision with root package name */
        public final e f36637u;

        /* renamed from: v  reason: collision with root package name */
        public AnalyticsCallState f36638v;

        /* renamed from: w  reason: collision with root package name */
        public a f36639w;

        /* renamed from: x  reason: collision with root package name */
        public a.C0498a f36640x;

        public static final class a {

            /* renamed from: com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a$a  reason: collision with other inner class name */
            public static final class C0498a {

                /* renamed from: a  reason: collision with root package name */
                public final String f36641a;

                /* renamed from: b  reason: collision with root package name */
                public final String f36642b;

                /* renamed from: c  reason: collision with root package name */
                public final String f36643c;

                public C0498a(String str, String str2, String str3) {
                    this.f36641a = str;
                    this.f36642b = str2;
                    this.f36643c = str3;
                }

                public final String a() {
                    return this.f36641a;
                }

                public final String b() {
                    return this.f36642b;
                }

                public final String c() {
                    return this.f36643c;
                }

                public final String d() {
                    return this.f36643c;
                }

                public final String e() {
                    return this.f36642b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0498a)) {
                        return false;
                    }
                    C0498a aVar = (C0498a) obj;
                    return x.b(this.f36641a, aVar.f36641a) && x.b(this.f36642b, aVar.f36642b) && x.b(this.f36643c, aVar.f36643c);
                }

                public final String f() {
                    return this.f36641a;
                }

                public int hashCode() {
                    String str = this.f36641a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f36642b;
                    int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.f36643c;
                    if (str3 != null) {
                        i11 = str3.hashCode();
                    }
                    return hashCode2 + i11;
                }

                public String toString() {
                    return "LanguageState(title=" + this.f36641a + ", language=" + this.f36642b + ", change=" + this.f36643c + ')';
                }

                public final C0498a a(String str, String str2, String str3) {
                    return new C0498a(str, str2, str3);
                }

                public static /* synthetic */ C0498a a(C0498a aVar, String str, String str2, String str3, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = aVar.f36641a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = aVar.f36642b;
                    }
                    if ((i11 & 4) != 0) {
                        str3 = aVar.f36643c;
                    }
                    return aVar.a(str, str2, str3);
                }
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public static /* synthetic */ e a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, C0498a aVar2, boolean z11, int i11, Object obj) {
                if ((i11 & 8) != 0) {
                    aVar2 = null;
                }
                return aVar.a(charSequence, charSequence2, charSequence3, aVar2, z11);
            }

            public a() {
            }

            public final e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, C0498a aVar, boolean z11) {
                CharSequence charSequence4 = charSequence2;
                CharSequence charSequence5 = charSequence3;
                boolean z12 = z11;
                return new e(VideoStepState.PREVIEW, (ErrorState) null, false, true, true, z12, true, charSequence4, charSequence5, charSequence, ButtonAction.START_CALL, (CharSequence) null, (CharSequence) null, (k) null, true, false, (e) null, (CharSequence) null, (List) null, (Bitmap) null, (e) null, AnalyticsCallState.PREPARING, (a) null, aVar, 1839106, (r) null);
            }

            public final e a(CharSequence charSequence, CharSequence charSequence2, List<SNSStepViewItem> list, a aVar) {
                CharSequence charSequence3 = charSequence2;
                return new e(VideoStepState.WAITING, (ErrorState) null, false, true, false, false, true, (CharSequence) null, charSequence3, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, true, false, (e) null, charSequence, list, (Bitmap) null, (e) null, AnalyticsCallState.WAITING_FOR_OPERATOR, aVar, (C0498a) null, 9965570, (r) null);
            }

            public final e a(CharSequence charSequence, e eVar, List<SNSStepViewItem> list, a aVar) {
                return new e(VideoStepState.VIDEO_CALL, (ErrorState) null, false, true, false, false, true, (CharSequence) null, charSequence, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, true, true, eVar, (CharSequence) null, list, (Bitmap) null, (e) null, AnalyticsCallState.IN_PROGRESS, aVar, (C0498a) null, 9965570, (r) null);
            }

            public final e a(CharSequence charSequence, CharSequence charSequence2, a aVar) {
                return new e(VideoStepState.VIDEO_CALL, (ErrorState) null, false, true, false, false, true, charSequence, charSequence2, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, true, true, (e) null, (CharSequence) null, CollectionsKt__CollectionsKt.k(), (Bitmap) null, (e) null, AnalyticsCallState.IN_PROGRESS, aVar, (C0498a) null, 9965570, (r) null);
            }

            public static /* synthetic */ e a(a aVar, ErrorState errorState, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ButtonAction buttonAction, a aVar2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    errorState = ErrorState.GENERAL;
                }
                return aVar.a(errorState, charSequence, charSequence2, charSequence3, buttonAction, aVar2);
            }

            public final e a(ErrorState errorState, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ButtonAction buttonAction, a aVar) {
                VideoStepState videoStepState = VideoStepState.ERROR;
                k kVar = r0;
                k kVar2 = new k(charSequence, charSequence2);
                return new e(videoStepState, errorState, false, true, true, true, true, (CharSequence) null, (CharSequence) null, charSequence3, buttonAction, (CharSequence) null, (CharSequence) null, kVar, true, false, (e) null, (CharSequence) null, CollectionsKt__CollectionsKt.k(), (Bitmap) null, (e) null, (AnalyticsCallState) null, aVar, (C0498a) null, 12062720, (r) null);
            }

            public final e a(CharSequence charSequence, ButtonAction buttonAction, CharSequence charSequence2, Bitmap bitmap, a aVar) {
                return new e(VideoStepState.VIDEO_CALL, (ErrorState) null, false, true, true, true, true, (CharSequence) null, (CharSequence) null, charSequence, buttonAction, charSequence2, (CharSequence) null, (k) null, true, true, (e) null, (CharSequence) null, CollectionsKt__CollectionsKt.k(), bitmap, (e) null, AnalyticsCallState.IN_PROGRESS, aVar, (C0498a) null, 8392706, (r) null);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ e(com.sumsub.sns.internal.videoident.presentation.SNSViewState.VideoStepState r29, com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, java.lang.CharSequence r36, java.lang.CharSequence r37, java.lang.CharSequence r38, com.sumsub.sns.internal.videoident.presentation.ButtonAction r39, java.lang.CharSequence r40, java.lang.CharSequence r41, com.sumsub.sns.internal.videoident.presentation.k r42, boolean r43, boolean r44, com.sumsub.sns.internal.videoident.presentation.e r45, java.lang.CharSequence r46, java.util.List r47, android.graphics.Bitmap r48, com.sumsub.sns.internal.videoident.presentation.SNSViewState.e r49, com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r50, com.sumsub.sns.internal.videoident.presentation.SNSViewState.a r51, com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.C0498a r52, int r53, kotlin.jvm.internal.r r54) {
            /*
                r28 = this;
                r0 = r53
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000b
            L_0x0009:
                r5 = r30
            L_0x000b:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x0012
                r1 = 0
                r6 = r1
                goto L_0x0014
            L_0x0012:
                r6 = r31
            L_0x0014:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L_0x001b
                r16 = r2
                goto L_0x001d
            L_0x001b:
                r16 = r41
            L_0x001d:
                r1 = 262144(0x40000, float:3.67342E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0029
                java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                r22 = r1
                goto L_0x002b
            L_0x0029:
                r22 = r47
            L_0x002b:
                r1 = 524288(0x80000, float:7.34684E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0033
                r23 = r2
                goto L_0x0035
            L_0x0033:
                r23 = r48
            L_0x0035:
                r1 = 1048576(0x100000, float:1.469368E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x003d
                r24 = r2
                goto L_0x003f
            L_0x003d:
                r24 = r49
            L_0x003f:
                r1 = 2097152(0x200000, float:2.938736E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0047
                r25 = r2
                goto L_0x0049
            L_0x0047:
                r25 = r50
            L_0x0049:
                r1 = 4194304(0x400000, float:5.877472E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0051
                r26 = r2
                goto L_0x0053
            L_0x0051:
                r26 = r51
            L_0x0053:
                r1 = 8388608(0x800000, float:1.17549435E-38)
                r0 = r0 & r1
                if (r0 == 0) goto L_0x005b
                r27 = r2
                goto L_0x005d
            L_0x005b:
                r27 = r52
            L_0x005d:
                r3 = r28
                r4 = r29
                r7 = r32
                r8 = r33
                r9 = r34
                r10 = r35
                r11 = r36
                r12 = r37
                r13 = r38
                r14 = r39
                r15 = r40
                r17 = r42
                r18 = r43
                r19 = r44
                r20 = r45
                r21 = r46
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.<init>(com.sumsub.sns.internal.videoident.presentation.SNSViewState$VideoStepState, com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState, boolean, boolean, boolean, boolean, boolean, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, com.sumsub.sns.internal.videoident.presentation.ButtonAction, java.lang.CharSequence, java.lang.CharSequence, com.sumsub.sns.internal.videoident.presentation.k, boolean, boolean, com.sumsub.sns.internal.videoident.presentation.e, java.lang.CharSequence, java.util.List, android.graphics.Bitmap, com.sumsub.sns.internal.videoident.presentation.SNSViewState$e, com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState, com.sumsub.sns.internal.videoident.presentation.SNSViewState$a, com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a$a, int, kotlin.jvm.internal.r):void");
        }

        public final boolean A() {
            return this.f36622f;
        }

        public final CharSequence B() {
            return this.f36626j;
        }

        public final CharSequence C() {
            return this.f36628l;
        }

        public final CharSequence D() {
            return this.f36625i;
        }

        public final CharSequence E() {
            return this.f36624h;
        }

        public final CharSequence F() {
            return this.f36629m;
        }

        public final k G() {
            return this.f36630n;
        }

        public final a H() {
            return this.f36639w;
        }

        public final List<SNSStepViewItem> I() {
            return this.f36635s;
        }

        public final ErrorState J() {
            return this.f36618b;
        }

        public final a.C0498a K() {
            return this.f36640x;
        }

        public final CharSequence L() {
            return this.f36634r;
        }

        public final Bitmap M() {
            return this.f36636t;
        }

        public final e N() {
            return this.f36637u;
        }

        public final e O() {
            return this.f36633q;
        }

        public final boolean P() {
            return this.f36621e;
        }

        public final boolean Q() {
            return this.f36631o;
        }

        public final boolean R() {
            return this.f36620d;
        }

        public final boolean S() {
            return this.f36619c;
        }

        public final boolean T() {
            return this.f36632p;
        }

        public final boolean U() {
            return this.f36623g;
        }

        public final VideoStepState V() {
            return this.f36617a;
        }

        public final VideoStepState a() {
            return this.f36617a;
        }

        public final CharSequence b() {
            return this.f36626j;
        }

        public final ButtonAction c() {
            return this.f36627k;
        }

        public final CharSequence d() {
            return this.f36628l;
        }

        public final CharSequence e() {
            return this.f36629m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f36617a == eVar.f36617a && this.f36618b == eVar.f36618b && this.f36619c == eVar.f36619c && this.f36620d == eVar.f36620d && this.f36621e == eVar.f36621e && this.f36622f == eVar.f36622f && this.f36623g == eVar.f36623g && x.b(this.f36624h, eVar.f36624h) && x.b(this.f36625i, eVar.f36625i) && x.b(this.f36626j, eVar.f36626j) && this.f36627k == eVar.f36627k && x.b(this.f36628l, eVar.f36628l) && x.b(this.f36629m, eVar.f36629m) && x.b(this.f36630n, eVar.f36630n) && this.f36631o == eVar.f36631o && this.f36632p == eVar.f36632p && x.b(this.f36633q, eVar.f36633q) && x.b(this.f36634r, eVar.f36634r) && x.b(this.f36635s, eVar.f36635s) && x.b(this.f36636t, eVar.f36636t) && x.b(this.f36637u, eVar.f36637u) && this.f36638v == eVar.f36638v && x.b(this.f36639w, eVar.f36639w) && x.b(this.f36640x, eVar.f36640x);
        }

        public final k f() {
            return this.f36630n;
        }

        public final boolean g() {
            return this.f36631o;
        }

        public final boolean h() {
            return this.f36632p;
        }

        public int hashCode() {
            int hashCode = this.f36617a.hashCode() * 31;
            ErrorState errorState = this.f36618b;
            int i11 = 0;
            int hashCode2 = (hashCode + (errorState == null ? 0 : errorState.hashCode())) * 31;
            boolean z11 = this.f36619c;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.f36620d;
            if (z13) {
                z13 = true;
            }
            int i13 = (i12 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f36621e;
            if (z14) {
                z14 = true;
            }
            int i14 = (i13 + (z14 ? 1 : 0)) * 31;
            boolean z15 = this.f36622f;
            if (z15) {
                z15 = true;
            }
            int i15 = (i14 + (z15 ? 1 : 0)) * 31;
            boolean z16 = this.f36623g;
            if (z16) {
                z16 = true;
            }
            int i16 = (i15 + (z16 ? 1 : 0)) * 31;
            CharSequence charSequence = this.f36624h;
            int hashCode3 = (i16 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f36625i;
            int hashCode4 = (hashCode3 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f36626j;
            int hashCode5 = (hashCode4 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            ButtonAction buttonAction = this.f36627k;
            int hashCode6 = (hashCode5 + (buttonAction == null ? 0 : buttonAction.hashCode())) * 31;
            CharSequence charSequence4 = this.f36628l;
            int hashCode7 = (hashCode6 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            CharSequence charSequence5 = this.f36629m;
            int hashCode8 = (hashCode7 + (charSequence5 == null ? 0 : charSequence5.hashCode())) * 31;
            k kVar = this.f36630n;
            int hashCode9 = (hashCode8 + (kVar == null ? 0 : kVar.hashCode())) * 31;
            boolean z17 = this.f36631o;
            if (z17) {
                z17 = true;
            }
            int i17 = (hashCode9 + (z17 ? 1 : 0)) * 31;
            boolean z18 = this.f36632p;
            if (!z18) {
                z12 = z18;
            }
            int i18 = (i17 + (z12 ? 1 : 0)) * 31;
            e eVar = this.f36633q;
            int hashCode10 = (i18 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            CharSequence charSequence6 = this.f36634r;
            int hashCode11 = (((hashCode10 + (charSequence6 == null ? 0 : charSequence6.hashCode())) * 31) + this.f36635s.hashCode()) * 31;
            Bitmap bitmap = this.f36636t;
            int hashCode12 = (hashCode11 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
            e eVar2 = this.f36637u;
            int hashCode13 = (hashCode12 + (eVar2 == null ? 0 : eVar2.hashCode())) * 31;
            AnalyticsCallState analyticsCallState = this.f36638v;
            int hashCode14 = (hashCode13 + (analyticsCallState == null ? 0 : analyticsCallState.hashCode())) * 31;
            a aVar = this.f36639w;
            int hashCode15 = (hashCode14 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            a.C0498a aVar2 = this.f36640x;
            if (aVar2 != null) {
                i11 = aVar2.hashCode();
            }
            return hashCode15 + i11;
        }

        public final e i() {
            return this.f36633q;
        }

        public final CharSequence j() {
            return this.f36634r;
        }

        public final List<SNSStepViewItem> k() {
            return this.f36635s;
        }

        public final ErrorState l() {
            return this.f36618b;
        }

        public final Bitmap m() {
            return this.f36636t;
        }

        public final e n() {
            return this.f36637u;
        }

        public final AnalyticsCallState o() {
            return this.f36638v;
        }

        public final a p() {
            return this.f36639w;
        }

        public final a.C0498a q() {
            return this.f36640x;
        }

        public final boolean r() {
            return this.f36619c;
        }

        public final boolean s() {
            return this.f36620d;
        }

        public final boolean t() {
            return this.f36621e;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i.a((Object) this));
            sb2.append(" (");
            sb2.append(this.f36617a);
            sb2.append(", progress=");
            sb2.append(this.f36619c);
            sb2.append(", title=");
            sb2.append(this.f36624h);
            sb2.append(", docs=");
            sb2.append(this.f36635s);
            sb2.append(", preview=");
            sb2.append(this.f36636t != null);
            sb2.append(')');
            return sb2.toString();
        }

        public final boolean u() {
            return this.f36622f;
        }

        public final boolean v() {
            return this.f36623g;
        }

        public final CharSequence w() {
            return this.f36624h;
        }

        public final CharSequence x() {
            return this.f36625i;
        }

        public final AnalyticsCallState y() {
            return this.f36638v;
        }

        public final ButtonAction z() {
            return this.f36627k;
        }

        public final e a(VideoStepState videoStepState, ErrorState errorState, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ButtonAction buttonAction, CharSequence charSequence4, CharSequence charSequence5, k kVar, boolean z16, boolean z17, e eVar, CharSequence charSequence6, List<SNSStepViewItem> list, Bitmap bitmap, e eVar2, AnalyticsCallState analyticsCallState, a aVar, a.C0498a aVar2) {
            return new e(videoStepState, errorState, z11, z12, z13, z14, z15, charSequence, charSequence2, charSequence3, buttonAction, charSequence4, charSequence5, kVar, z16, z17, eVar, charSequence6, list, bitmap, eVar2, analyticsCallState, aVar, aVar2);
        }

        public final void b(CharSequence charSequence) {
            this.f36625i = charSequence;
        }

        public final void c(CharSequence charSequence) {
            this.f36624h = charSequence;
        }

        public final void d(CharSequence charSequence) {
            this.f36629m = charSequence;
        }

        public final void e(CharSequence charSequence) {
            this.f36634r = charSequence;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(VideoStepState videoStepState, ErrorState errorState, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ButtonAction buttonAction, CharSequence charSequence4, CharSequence charSequence5, k kVar, boolean z16, boolean z17, e eVar, CharSequence charSequence6, List<SNSStepViewItem> list, Bitmap bitmap, e eVar2, AnalyticsCallState analyticsCallState, a aVar, a.C0498a aVar2) {
            super((r) null);
            this.f36617a = videoStepState;
            this.f36618b = errorState;
            this.f36619c = z11;
            this.f36620d = z12;
            this.f36621e = z13;
            this.f36622f = z14;
            this.f36623g = z15;
            this.f36624h = charSequence;
            this.f36625i = charSequence2;
            this.f36626j = charSequence3;
            this.f36627k = buttonAction;
            this.f36628l = charSequence4;
            this.f36629m = charSequence5;
            this.f36630n = kVar;
            this.f36631o = z16;
            this.f36632p = z17;
            this.f36633q = eVar;
            this.f36634r = charSequence6;
            this.f36635s = list;
            this.f36636t = bitmap;
            this.f36637u = eVar2;
            this.f36638v = analyticsCallState;
            this.f36639w = aVar;
            this.f36640x = aVar2;
        }

        public static /* synthetic */ e a(e eVar, VideoStepState videoStepState, ErrorState errorState, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ButtonAction buttonAction, CharSequence charSequence4, CharSequence charSequence5, k kVar, boolean z16, boolean z17, e eVar2, CharSequence charSequence6, List list, Bitmap bitmap, e eVar3, AnalyticsCallState analyticsCallState, a aVar, a.C0498a aVar2, int i11, Object obj) {
            e eVar4 = eVar;
            int i12 = i11;
            return eVar.a((i12 & 1) != 0 ? eVar4.f36617a : videoStepState, (i12 & 2) != 0 ? eVar4.f36618b : errorState, (i12 & 4) != 0 ? eVar4.f36619c : z11, (i12 & 8) != 0 ? eVar4.f36620d : z12, (i12 & 16) != 0 ? eVar4.f36621e : z13, (i12 & 32) != 0 ? eVar4.f36622f : z14, (i12 & 64) != 0 ? eVar4.f36623g : z15, (i12 & 128) != 0 ? eVar4.f36624h : charSequence, (i12 & 256) != 0 ? eVar4.f36625i : charSequence2, (i12 & 512) != 0 ? eVar4.f36626j : charSequence3, (i12 & 1024) != 0 ? eVar4.f36627k : buttonAction, (i12 & 2048) != 0 ? eVar4.f36628l : charSequence4, (i12 & 4096) != 0 ? eVar4.f36629m : charSequence5, (i12 & 8192) != 0 ? eVar4.f36630n : kVar, (i12 & 16384) != 0 ? eVar4.f36631o : z16, (i12 & 32768) != 0 ? eVar4.f36632p : z17, (i12 & 65536) != 0 ? eVar4.f36633q : eVar2, (i12 & 131072) != 0 ? eVar4.f36634r : charSequence6, (i12 & 262144) != 0 ? eVar4.f36635s : list, (i12 & 524288) != 0 ? eVar4.f36636t : bitmap, (i12 & 1048576) != 0 ? eVar4.f36637u : eVar3, (i12 & 2097152) != 0 ? eVar4.f36638v : analyticsCallState, (i12 & 4194304) != 0 ? eVar4.f36639w : aVar, (i12 & 8388608) != 0 ? eVar4.f36640x : aVar2);
        }

        public final void a(boolean z11) {
            this.f36619c = z11;
        }

        public final void a(CharSequence charSequence) {
            this.f36628l = charSequence;
        }

        public final void a(e eVar) {
            this.f36633q = eVar;
        }

        public final void a(List<SNSStepViewItem> list) {
            this.f36635s = list;
        }

        public final void a(Bitmap bitmap) {
            this.f36636t = bitmap;
        }

        public final void a(AnalyticsCallState analyticsCallState) {
            this.f36638v = analyticsCallState;
        }

        public final void a(a aVar) {
            this.f36639w = aVar;
        }

        public final void a(a.C0498a aVar) {
            this.f36640x = aVar;
        }
    }

    public /* synthetic */ SNSViewState(r rVar) {
        this();
    }

    public final boolean getHasVideo() {
        return isPreview() || isVideoCall() || isWaiting();
    }

    public final boolean isError() {
        return (this instanceof e) && ((e) this).V() == VideoStepState.ERROR;
    }

    public final boolean isLoading() {
        if (!x.b(this, c.f36612a)) {
            e eVar = this instanceof e ? this : null;
            if (eVar != null ? eVar.S() : false) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean isPreview() {
        return (this instanceof e) && ((e) this).V() == VideoStepState.PREVIEW;
    }

    public final boolean isReconnecting() {
        return (this instanceof e) && ((e) this).V() == VideoStepState.RECONNECTING;
    }

    public final boolean isVideoCall() {
        return (this instanceof e) && ((e) this).V() == VideoStepState.VIDEO_CALL;
    }

    public final boolean isWaiting() {
        return (this instanceof e) && ((e) this).V() == VideoStepState.WAITING;
    }

    private SNSViewState() {
    }
}

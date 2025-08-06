package com.sumsub.sns.internal.core.presentation.screen.verification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import d10.s;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class SNSVerificationStepViewModel extends com.sumsub.sns.core.presentation.base.a<e> {
    public static final String A = "sns_confirmation_contact_phone_subtitle";
    public static final String B = "sns_confirmation_contact_action_send";
    public static final String C = "sns_confirmation_code_email_title";
    public static final String D = "sns_confirmation_code_email_subtitle";
    public static final String E = "sns_confirmation_code_phone_title";
    public static final String F = "sns_confirmation_code_phone_subtitle";
    public static final String G = "sns_confirmation_contact_email_isNotValid";
    public static final String H = "sns_confirmation_code_resendCountdown";
    public static final String I = "sns_confirmation_code_action_resend";
    public static final String J = "sns_confirmation_result_phone_success_title";
    public static final String K = "sns_confirmation_result_email_success_title";
    public static final String L = "sns_confirmation_result_phone_failure_title";
    public static final String M = "sns_confirmation_result_email_failure_title";
    public static final String N = "sns_confirmation_code_isNotValid";
    public static final long O = 60;
    public static final int P = 6;
    public static final long Q = 1000;

    /* renamed from: q  reason: collision with root package name */
    public static final a f33908q = new a((kotlin.jvm.internal.r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f33909r;

    /* renamed from: s  reason: collision with root package name */
    public static final String f33910s = "sns_verification_step";

    /* renamed from: t  reason: collision with root package name */
    public static final String f33911t = "sns_verification_error";

    /* renamed from: u  reason: collision with root package name */
    public static final String f33912u = "sns_verification_countdown";

    /* renamed from: v  reason: collision with root package name */
    public static final String f33913v = "sns_verification_response";

    /* renamed from: w  reason: collision with root package name */
    public static final String f33914w = "sns_confirmation_contact_email_title";

    /* renamed from: x  reason: collision with root package name */
    public static final String f33915x = "sns_confirmation_contact_email_subtitle";

    /* renamed from: y  reason: collision with root package name */
    public static final String f33916y = "sns_confirmation_contact_email_placeholder";

    /* renamed from: z  reason: collision with root package name */
    public static final String f33917z = "sns_confirmation_contact_phone_title";
    public final ValidationIdentifierType R;
    public final com.sumsub.sns.internal.core.domain.d S;
    public final com.sumsub.sns.internal.core.domain.n T;
    public final com.sumsub.sns.internal.core.domain.a U;
    public final com.sumsub.sns.internal.core.data.source.dynamic.b V;
    public final SavedStateHandle W;
    public n1 X;
    public final h0 Y = i0.a(f1.b(Executors.newSingleThreadExecutor()));
    public final com.sumsub.sns.internal.core.presentation.screen.base.a Z;

    /* renamed from: a0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f33918a0;

    /* renamed from: b0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f33919b0;

    /* renamed from: c0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f33920c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f33921d0;

    /* renamed from: e0  reason: collision with root package name */
    public final j1<e> f33922e0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$Step;", "", "(Ljava/lang/String;I)V", "INIT", "VERIFY_CODE", "STATUS", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Step {
        INIT,
        VERIFY_CODE,
        STATUS
    }

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f33923a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f33924b;

        /* renamed from: c  reason: collision with root package name */
        public final Integer f33925c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33926d;

        /* renamed from: e  reason: collision with root package name */
        public final String f33927e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f33928f;

        /* renamed from: g  reason: collision with root package name */
        public final long f33929g;

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                return new b((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readLong());
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(CharSequence charSequence, CharSequence charSequence2, Integer num, String str, String str2, Long l11, long j11) {
            this.f33923a = charSequence;
            this.f33924b = charSequence2;
            this.f33925c = num;
            this.f33926d = str;
            this.f33927e = str2;
            this.f33928f = l11;
            this.f33929g = j11;
        }

        public final CharSequence a() {
            return this.f33923a;
        }

        public final CharSequence b() {
            return this.f33924b;
        }

        public final Integer c() {
            return this.f33925c;
        }

        public final String d() {
            return this.f33926d;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f33927e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f33923a, bVar.f33923a) && x.b(this.f33924b, bVar.f33924b) && x.b(this.f33925c, bVar.f33925c) && x.b(this.f33926d, bVar.f33926d) && x.b(this.f33927e, bVar.f33927e) && x.b(this.f33928f, bVar.f33928f) && this.f33929g == bVar.f33929g;
        }

        public final Long f() {
            return this.f33928f;
        }

        public final long g() {
            return this.f33929g;
        }

        public final Long h() {
            return this.f33928f;
        }

        public int hashCode() {
            CharSequence charSequence = this.f33923a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f33924b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            Integer num = this.f33925c;
            int hashCode3 = (((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.f33926d.hashCode()) * 31) + this.f33927e.hashCode()) * 31;
            Long l11 = this.f33928f;
            if (l11 != null) {
                i11 = l11.hashCode();
            }
            return ((hashCode3 + i11) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f33929g);
        }

        public final String i() {
            return this.f33927e;
        }

        public final String j() {
            return this.f33926d;
        }

        public final long k() {
            return this.f33929g;
        }

        public final CharSequence l() {
            return this.f33924b;
        }

        public final CharSequence m() {
            return this.f33923a;
        }

        public final Integer n() {
            return this.f33925c;
        }

        public String toString() {
            return "CountdownData(title=" + this.f33923a + ", subtitle=" + this.f33924b + ", verificationCodeLength=" + this.f33925c + ", identifier=" + this.f33926d + ", id=" + this.f33927e + ", endTime=" + this.f33928f + ", secondsRemaining=" + this.f33929g + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            TextUtils.writeToParcel(this.f33923a, parcel, i11);
            TextUtils.writeToParcel(this.f33924b, parcel, i11);
            Integer num = this.f33925c;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.f33926d);
            parcel.writeString(this.f33927e);
            Long l11 = this.f33928f;
            if (l11 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l11.longValue());
            }
            parcel.writeLong(this.f33929g);
        }

        public final b a(CharSequence charSequence, CharSequence charSequence2, Integer num, String str, String str2, Long l11, long j11) {
            return new b(charSequence, charSequence2, num, str, str2, l11, j11);
        }

        public static /* synthetic */ b a(b bVar, CharSequence charSequence, CharSequence charSequence2, Integer num, String str, String str2, Long l11, long j11, int i11, Object obj) {
            b bVar2 = bVar;
            return bVar.a((i11 & 1) != 0 ? bVar2.f33923a : charSequence, (i11 & 2) != 0 ? bVar2.f33924b : charSequence2, (i11 & 4) != 0 ? bVar2.f33925c : num, (i11 & 8) != 0 ? bVar2.f33926d : str, (i11 & 16) != 0 ? bVar2.f33927e : str2, (i11 & 32) != 0 ? bVar2.f33928f : l11, (i11 & 64) != 0 ? bVar2.f33929g : j11);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ b(java.lang.CharSequence r13, java.lang.CharSequence r14, java.lang.Integer r15, java.lang.String r16, java.lang.String r17, java.lang.Long r18, long r19, int r21, kotlin.jvm.internal.r r22) {
            /*
                r12 = this;
                r0 = r21 & 64
                if (r0 == 0) goto L_0x001f
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
                r1 = 0
                if (r18 == 0) goto L_0x0014
                long r3 = r18.longValue()
                long r5 = java.lang.System.currentTimeMillis()
                long r3 = r3 - r5
                goto L_0x0015
            L_0x0014:
                r3 = r1
            L_0x0015:
                long r3 = r0.toSeconds(r3)
                long r0 = kotlin.ranges.RangesKt___RangesKt.e(r3, r1)
                r10 = r0
                goto L_0x0021
            L_0x001f:
                r10 = r19
            L_0x0021:
                r3 = r12
                r4 = r13
                r5 = r14
                r6 = r15
                r7 = r16
                r8 = r17
                r9 = r18
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Long, long, int, kotlin.jvm.internal.r):void");
        }
    }

    public static abstract class c implements a.j {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f33930a = new a();

            public a() {
                super((kotlin.jvm.internal.r) null);
            }
        }

        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final b f33931a = new b();

            public b() {
                super((kotlin.jvm.internal.r) null);
            }
        }

        public /* synthetic */ c(kotlin.jvm.internal.r rVar) {
            this();
        }

        public c() {
        }
    }

    public static final class d extends AbstractSavedStateViewModelFactory {

        /* renamed from: a  reason: collision with root package name */
        public final ValidationIdentifierType f33932a;

        /* renamed from: b  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.a f33933b;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(androidx.savedstate.c cVar, ValidationIdentifierType validationIdentifierType, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, kotlin.jvm.internal.r rVar) {
            this(cVar, validationIdentifierType, aVar, (i11 & 8) != 0 ? null : bundle);
        }

        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            return new SNSVerificationStepViewModel(this.f33932a, new com.sumsub.sns.internal.core.domain.d(this.f33933b.n(), this.f33933b.p()), new com.sumsub.sns.internal.core.domain.n(this.f33933b.g()), new com.sumsub.sns.internal.core.domain.a(this.f33933b.g()), this.f33933b.n(), this.f33933b.p(), savedStateHandle);
        }

        public d(androidx.savedstate.c cVar, ValidationIdentifierType validationIdentifierType, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
            super(cVar, bundle);
            this.f33932a = validationIdentifierType;
            this.f33933b = aVar;
        }
    }

    public static abstract class e implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f33934a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f33935b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f33936c;

        public static final class a extends e {

            /* renamed from: d  reason: collision with root package name */
            public static final a f33937d = new a();

            public a() {
                super((CharSequence) null, (CharSequence) null, (CharSequence) null, 7, (kotlin.jvm.internal.r) null);
            }
        }

        public static final class b extends e {

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f33938d;

            /* renamed from: e  reason: collision with root package name */
            public final CharSequence f33939e;

            /* renamed from: f  reason: collision with root package name */
            public final String f33940f;

            /* renamed from: g  reason: collision with root package name */
            public final CharSequence f33941g;

            /* renamed from: h  reason: collision with root package name */
            public final boolean f33942h;

            public b(CharSequence charSequence, CharSequence charSequence2, String str, CharSequence charSequence3, boolean z11) {
                super(charSequence, charSequence2, (CharSequence) null, 4, (kotlin.jvm.internal.r) null);
                this.f33938d = charSequence;
                this.f33939e = charSequence2;
                this.f33940f = str;
                this.f33941g = charSequence3;
                this.f33942h = z11;
            }

            public CharSequence b() {
                return this.f33939e;
            }

            public CharSequence c() {
                return this.f33938d;
            }

            public final String d() {
                return this.f33940f;
            }

            public final CharSequence e() {
                return this.f33941g;
            }

            public final boolean f() {
                return this.f33942h;
            }
        }

        public static final class c extends e {

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f33943d;

            /* renamed from: e  reason: collision with root package name */
            public final CharSequence f33944e;

            /* renamed from: f  reason: collision with root package name */
            public final CharSequence f33945f;

            /* renamed from: g  reason: collision with root package name */
            public final CharSequence f33946g;

            /* renamed from: h  reason: collision with root package name */
            public final Integer f33947h;

            /* renamed from: i  reason: collision with root package name */
            public final CharSequence f33948i;

            /* renamed from: j  reason: collision with root package name */
            public final String f33949j;

            /* renamed from: k  reason: collision with root package name */
            public final String f33950k;

            public c() {
                this((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (Integer) null, (CharSequence) null, (String) null, (String) null, 255, (kotlin.jvm.internal.r) null);
            }

            public final c a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Integer num, CharSequence charSequence5, String str, String str2) {
                return new c(charSequence, charSequence2, charSequence3, charSequence4, num, charSequence5, str, str2);
            }

            public CharSequence b() {
                return this.f33944e;
            }

            public CharSequence c() {
                return this.f33943d;
            }

            public final CharSequence d() {
                return c();
            }

            public final CharSequence e() {
                return b();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return x.b(c(), cVar.c()) && x.b(b(), cVar.b()) && x.b(this.f33945f, cVar.f33945f) && x.b(this.f33946g, cVar.f33946g) && x.b(this.f33947h, cVar.f33947h) && x.b(this.f33948i, cVar.f33948i) && x.b(this.f33949j, cVar.f33949j) && x.b(this.f33950k, cVar.f33950k);
            }

            public final CharSequence f() {
                return this.f33945f;
            }

            public final CharSequence g() {
                return this.f33946g;
            }

            public final Integer h() {
                return this.f33947h;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = (((c() == null ? 0 : c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
                CharSequence charSequence = this.f33945f;
                int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
                CharSequence charSequence2 = this.f33946g;
                int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                Integer num = this.f33947h;
                int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                CharSequence charSequence3 = this.f33948i;
                if (charSequence3 != null) {
                    i11 = charSequence3.hashCode();
                }
                return ((((hashCode4 + i11) * 31) + this.f33949j.hashCode()) * 31) + this.f33950k.hashCode();
            }

            public final CharSequence i() {
                return this.f33948i;
            }

            public final String j() {
                return this.f33949j;
            }

            public final String k() {
                return this.f33950k;
            }

            public final CharSequence l() {
                return this.f33948i;
            }

            public final String m() {
                return this.f33950k;
            }

            public final String n() {
                return this.f33949j;
            }

            public final CharSequence o() {
                return this.f33946g;
            }

            public final CharSequence p() {
                return this.f33945f;
            }

            public final Integer q() {
                return this.f33947h;
            }

            public String toString() {
                return "VerifyCode(title=" + c() + ", subtitle=" + b() + ", timer=" + this.f33945f + ", resendButton=" + this.f33946g + ", verificationCodeLength=" + this.f33947h + ", error=" + this.f33948i + ", identifier=" + this.f33949j + ", id=" + this.f33950k + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ c(java.lang.CharSequence r10, java.lang.CharSequence r11, java.lang.CharSequence r12, java.lang.CharSequence r13, java.lang.Integer r14, java.lang.CharSequence r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.r r19) {
                /*
                    r9 = this;
                    r0 = r18
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r10
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r11
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r12
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r13
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0026
                L_0x0025:
                    r6 = r14
                L_0x0026:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002b
                    goto L_0x002c
                L_0x002b:
                    r2 = r15
                L_0x002c:
                    r7 = r0 & 64
                    java.lang.String r8 = ""
                    if (r7 == 0) goto L_0x0034
                    r7 = r8
                    goto L_0x0036
                L_0x0034:
                    r7 = r16
                L_0x0036:
                    r0 = r0 & 128(0x80, float:1.794E-43)
                    if (r0 == 0) goto L_0x003b
                    goto L_0x003d
                L_0x003b:
                    r8 = r17
                L_0x003d:
                    r10 = r9
                    r11 = r1
                    r12 = r3
                    r13 = r4
                    r14 = r5
                    r15 = r6
                    r16 = r2
                    r17 = r7
                    r18 = r8
                    r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.c.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.Integer, java.lang.CharSequence, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
            }

            public static /* synthetic */ c a(c cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Integer num, CharSequence charSequence5, String str, String str2, int i11, Object obj) {
                c cVar2 = cVar;
                int i12 = i11;
                return cVar.a((i12 & 1) != 0 ? cVar.c() : charSequence, (i12 & 2) != 0 ? cVar.b() : charSequence2, (i12 & 4) != 0 ? cVar2.f33945f : charSequence3, (i12 & 8) != 0 ? cVar2.f33946g : charSequence4, (i12 & 16) != 0 ? cVar2.f33947h : num, (i12 & 32) != 0 ? cVar2.f33948i : charSequence5, (i12 & 64) != 0 ? cVar2.f33949j : str, (i12 & 128) != 0 ? cVar2.f33950k : str2);
            }

            public c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Integer num, CharSequence charSequence5, String str, String str2) {
                super(charSequence, charSequence2, (CharSequence) null, 4, (kotlin.jvm.internal.r) null);
                this.f33943d = charSequence;
                this.f33944e = charSequence2;
                this.f33945f = charSequence3;
                this.f33946g = charSequence4;
                this.f33947h = num;
                this.f33948i = charSequence5;
                this.f33949j = str;
                this.f33950k = str2;
            }
        }

        public static final class d extends e {

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f33951d;

            /* renamed from: e  reason: collision with root package name */
            public final CharSequence f33952e;

            /* renamed from: f  reason: collision with root package name */
            public final CharSequence f33953f;

            /* renamed from: g  reason: collision with root package name */
            public final CharSequence f33954g;

            /* renamed from: h  reason: collision with root package name */
            public final CharSequence f33955h;

            /* renamed from: i  reason: collision with root package name */
            public final CharSequence f33956i;

            public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
                super(charSequence, charSequence2, charSequence3, (kotlin.jvm.internal.r) null);
                this.f33951d = charSequence;
                this.f33952e = charSequence2;
                this.f33953f = charSequence3;
                this.f33954g = charSequence4;
                this.f33955h = charSequence5;
                this.f33956i = charSequence6;
            }

            public final d a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
                return new d(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, charSequence6);
            }

            public CharSequence b() {
                return this.f33952e;
            }

            public CharSequence c() {
                return this.f33951d;
            }

            public final CharSequence d() {
                return c();
            }

            public final CharSequence e() {
                return b();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return x.b(c(), dVar.c()) && x.b(b(), dVar.b()) && x.b(a(), dVar.a()) && x.b(this.f33954g, dVar.f33954g) && x.b(this.f33955h, dVar.f33955h) && x.b(this.f33956i, dVar.f33956i);
            }

            public final CharSequence f() {
                return a();
            }

            public final CharSequence g() {
                return this.f33954g;
            }

            public final CharSequence h() {
                return this.f33955h;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = (((((c() == null ? 0 : c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31) + (a() == null ? 0 : a().hashCode())) * 31;
                CharSequence charSequence = this.f33954g;
                int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
                CharSequence charSequence2 = this.f33955h;
                int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                CharSequence charSequence3 = this.f33956i;
                if (charSequence3 != null) {
                    i11 = charSequence3.hashCode();
                }
                return hashCode3 + i11;
            }

            public final CharSequence i() {
                return this.f33956i;
            }

            public final CharSequence j() {
                return this.f33955h;
            }

            public final CharSequence k() {
                return this.f33954g;
            }

            public final CharSequence l() {
                return this.f33956i;
            }

            public String toString() {
                return "VerifyEmail(title=" + c() + ", subtitle=" + b() + ", initialValue=" + a() + ", hint=" + this.f33954g + ", error=" + this.f33955h + ", primaryButton=" + this.f33956i + ')';
            }

            public static /* synthetic */ d a(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = dVar.c();
                }
                if ((i11 & 2) != 0) {
                    charSequence2 = dVar.b();
                }
                CharSequence charSequence7 = charSequence2;
                if ((i11 & 4) != 0) {
                    charSequence3 = dVar.a();
                }
                CharSequence charSequence8 = charSequence3;
                if ((i11 & 8) != 0) {
                    charSequence4 = dVar.f33954g;
                }
                CharSequence charSequence9 = charSequence4;
                if ((i11 & 16) != 0) {
                    charSequence5 = dVar.f33955h;
                }
                CharSequence charSequence10 = charSequence5;
                if ((i11 & 32) != 0) {
                    charSequence6 = dVar.f33956i;
                }
                return dVar.a(charSequence, charSequence7, charSequence8, charSequence9, charSequence10, charSequence6);
            }

            public CharSequence a() {
                return this.f33953f;
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$e  reason: collision with other inner class name */
        public static final class C0383e extends e {

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f33957d;

            /* renamed from: e  reason: collision with root package name */
            public final CharSequence f33958e;

            /* renamed from: f  reason: collision with root package name */
            public final CharSequence f33959f;

            /* renamed from: g  reason: collision with root package name */
            public final com.sumsub.sns.internal.core.domain.e f33960g;

            /* renamed from: h  reason: collision with root package name */
            public final CharSequence f33961h;

            /* renamed from: i  reason: collision with root package name */
            public final CharSequence f33962i;

            public C0383e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, com.sumsub.sns.internal.core.domain.e eVar, CharSequence charSequence4, CharSequence charSequence5) {
                super(charSequence, charSequence2, charSequence3, (kotlin.jvm.internal.r) null);
                this.f33957d = charSequence;
                this.f33958e = charSequence2;
                this.f33959f = charSequence3;
                this.f33960g = eVar;
                this.f33961h = charSequence4;
                this.f33962i = charSequence5;
            }

            public final C0383e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, com.sumsub.sns.internal.core.domain.e eVar, CharSequence charSequence4, CharSequence charSequence5) {
                return new C0383e(charSequence, charSequence2, charSequence3, eVar, charSequence4, charSequence5);
            }

            public CharSequence b() {
                return this.f33958e;
            }

            public CharSequence c() {
                return this.f33957d;
            }

            public final CharSequence d() {
                return c();
            }

            public final CharSequence e() {
                return b();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0383e)) {
                    return false;
                }
                C0383e eVar = (C0383e) obj;
                return x.b(c(), eVar.c()) && x.b(b(), eVar.b()) && x.b(a(), eVar.a()) && x.b(this.f33960g, eVar.f33960g) && x.b(this.f33961h, eVar.f33961h) && x.b(this.f33962i, eVar.f33962i);
            }

            public final CharSequence f() {
                return a();
            }

            public final com.sumsub.sns.internal.core.domain.e g() {
                return this.f33960g;
            }

            public final CharSequence h() {
                return this.f33961h;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = (((((((c() == null ? 0 : c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + this.f33960g.hashCode()) * 31;
                CharSequence charSequence = this.f33961h;
                int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
                CharSequence charSequence2 = this.f33962i;
                if (charSequence2 != null) {
                    i11 = charSequence2.hashCode();
                }
                return hashCode2 + i11;
            }

            public final CharSequence i() {
                return this.f33962i;
            }

            public final com.sumsub.sns.internal.core.domain.e j() {
                return this.f33960g;
            }

            public final CharSequence k() {
                return this.f33961h;
            }

            public final CharSequence l() {
                return this.f33962i;
            }

            public String toString() {
                return "VerifyPhone(title=" + c() + ", subtitle=" + b() + ", initialValue=" + a() + ", countryResultData=" + this.f33960g + ", error=" + this.f33961h + ", primaryButton=" + this.f33962i + ')';
            }

            public static /* synthetic */ C0383e a(C0383e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, com.sumsub.sns.internal.core.domain.e eVar2, CharSequence charSequence4, CharSequence charSequence5, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = eVar.c();
                }
                if ((i11 & 2) != 0) {
                    charSequence2 = eVar.b();
                }
                CharSequence charSequence6 = charSequence2;
                if ((i11 & 4) != 0) {
                    charSequence3 = eVar.a();
                }
                CharSequence charSequence7 = charSequence3;
                if ((i11 & 8) != 0) {
                    eVar2 = eVar.f33960g;
                }
                com.sumsub.sns.internal.core.domain.e eVar3 = eVar2;
                if ((i11 & 16) != 0) {
                    charSequence4 = eVar.f33961h;
                }
                CharSequence charSequence8 = charSequence4;
                if ((i11 & 32) != 0) {
                    charSequence5 = eVar.f33962i;
                }
                return eVar.a(charSequence, charSequence6, charSequence7, eVar3, charSequence8, charSequence5);
            }

            public CharSequence a() {
                return this.f33959f;
            }
        }

        public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, kotlin.jvm.internal.r rVar) {
            this(charSequence, charSequence2, charSequence3);
        }

        public CharSequence a() {
            return this.f33936c;
        }

        public CharSequence b() {
            return this.f33935b;
        }

        public CharSequence c() {
            return this.f33934a;
        }

        public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f33934a = charSequence;
            this.f33935b = charSequence2;
            this.f33936c = charSequence3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (kotlin.jvm.internal.r) null);
        }
    }

    public /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33963a;

        static {
            int[] iArr = new int[ValidationIdentifierType.values().length];
            iArr[ValidationIdentifierType.EMAIL.ordinal()] = 1;
            iArr[ValidationIdentifierType.PHONE.ordinal()] = 2;
            iArr[ValidationIdentifierType.UNKNOWN.ordinal()] = 3;
            f33963a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel", f = "SNSVerificationStepViewModel.kt", l = {235, 237, 241, 245}, m = "buildCountDownData")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33964a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33965b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33966c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f33967d;

        /* renamed from: e  reason: collision with root package name */
        public int f33968e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f33967d = sNSVerificationStepViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33966c = obj;
            this.f33968e |= Integer.MIN_VALUE;
            return this.f33967d.a((b0) null, (kotlin.coroutines.c<? super b>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel", f = "SNSVerificationStepViewModel.kt", l = {89, 94, 95, 97, 99, 104, 107, 108, 111, 120, 124}, m = "buildInitState")
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33969a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33970b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33971c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33972d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33973e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f33974f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f33975g;

        /* renamed from: h  reason: collision with root package name */
        public int f33976h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
            this.f33975g = sNSVerificationStepViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33974f = obj;
            this.f33976h |= Integer.MIN_VALUE;
            return this.f33975g.a((CharSequence) null, (kotlin.coroutines.c<? super e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel", f = "SNSVerificationStepViewModel.kt", l = {168, 170, 180, 182, 186}, m = "buildStatusState")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33977a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33978b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33979c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f33980d;

        /* renamed from: e  reason: collision with root package name */
        public int f33981e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
            this.f33980d = sNSVerificationStepViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33979c = obj;
            this.f33981e |= Integer.MIN_VALUE;
            return this.f33980d.b((b0) null, (kotlin.coroutines.c<? super e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel", f = "SNSVerificationStepViewModel.kt", l = {142, 151}, m = "buildVerifyCodeState")
    public static final class j extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33982a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33983b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33984c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33985d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33986e;

        /* renamed from: f  reason: collision with root package name */
        public long f33987f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f33988g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f33989h;

        /* renamed from: i  reason: collision with root package name */
        public int f33990i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super j> cVar) {
            super(cVar);
            this.f33989h = sNSVerificationStepViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33988g = obj;
            this.f33990i |= Integer.MIN_VALUE;
            return this.f33989h.a((b) null, (kotlin.coroutines.c<? super e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$checkCode$$inlined$launchOnViewModelScope$1", f = "SNSVerificationStepViewModel.kt", l = {450, 452, 458}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33991a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33992b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f33993c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f33994d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f33995e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f33996f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f33997g;

        /* renamed from: h  reason: collision with root package name */
        public Object f33998h;

        /* renamed from: i  reason: collision with root package name */
        public Object f33999i;

        /* renamed from: j  reason: collision with root package name */
        public Object f34000j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, SNSVerificationStepViewModel sNSVerificationStepViewModel, String str2, String str3) {
            super(2, cVar);
            this.f33993c = aVar;
            this.f33994d = str;
            this.f33995e = sNSVerificationStepViewModel;
            this.f33996f = str2;
            this.f33997g = str3;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            k kVar = new k(this.f33993c, this.f33994d, cVar, this.f33995e, this.f33996f, this.f33997g);
            kVar.f33992b = obj;
            return kVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
            com.sumsub.sns.core.presentation.base.a.a(r11.f33993c, (java.lang.Throwable) r12, r11.f33994d, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00dc, code lost:
            r3 = r12;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x001e, B:11:0x0031] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x001e, B:17:0x003d] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x001e, B:23:0x0054] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0097 A[Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf A[ExcHandler: Exception (r12v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:6:0x001e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f33991a
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x004d
                if (r1 == r5) goto L_0x0039
                if (r1 == r4) goto L_0x002b
                if (r1 != r3) goto L_0x0023
                java.lang.Object r0 = r11.f34000j
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r0 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r0
                java.lang.Object r1 = r11.f33999i
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r3 = r11.f33992b
                kotlinx.coroutines.h0 r3 = (kotlinx.coroutines.h0) r3
                kotlin.k.b(r12)     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                goto L_0x00c0
            L_0x0023:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x002b:
                java.lang.Object r1 = r11.f33998h
                java.lang.Object r4 = r11.f33992b
                kotlinx.coroutines.h0 r4 = (kotlinx.coroutines.h0) r4
                kotlin.k.b(r12)     // Catch:{ CancellationException -> 0x0036, Exception -> 0x00cf }
                r12 = r4
                goto L_0x008c
            L_0x0036:
                r3 = r4
                goto L_0x00dd
            L_0x0039:
                java.lang.Object r1 = r11.f33992b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r12)     // Catch:{ CancellationException -> 0x004a, Exception -> 0x00cf }
                kotlin.Result r12 = (kotlin.Result) r12     // Catch:{ CancellationException -> 0x004a, Exception -> 0x00cf }
                java.lang.Object r12 = r12.m3081unboximpl()     // Catch:{ CancellationException -> 0x004a, Exception -> 0x00cf }
                r10 = r1
                r1 = r12
                r12 = r10
                goto L_0x0074
            L_0x004a:
                r3 = r1
                goto L_0x00dd
            L_0x004d:
                kotlin.k.b(r12)
                java.lang.Object r12 = r11.f33992b
                kotlinx.coroutines.h0 r12 = (kotlinx.coroutines.h0) r12
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r6 = 0
                r1.a((java.lang.CharSequence) r6)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r1.b((boolean) r5)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.domain.a r1 = r1.U     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.String r6 = r11.f33996f     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.String r7 = r11.f33997g     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33992b = r12     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33991a = r5     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.Object r1 = r1.a(r6, r7, r11)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                if (r1 != r0) goto L_0x0074
                return r0
            L_0x0074:
                boolean r5 = kotlin.Result.m3079isSuccessimpl(r1)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                if (r5 == 0) goto L_0x0091
                r5 = r1
                com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r5 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r5     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33992b = r12     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33998h = r1     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33991a = r4     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.Object r4 = r6.c(r5, r11)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                if (r4 != r0) goto L_0x008c
                return r0
            L_0x008c:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r4 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r4.b((boolean) r2)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
            L_0x0091:
                java.lang.Throwable r4 = kotlin.Result.m3075exceptionOrNullimpl(r1)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                if (r4 == 0) goto L_0x00eb
                com.sumsub.sns.internal.log.a r5 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.String r6 = com.sumsub.sns.internal.log.c.a(r6)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.String r7 = "request code error"
                r5.e(r6, r7, r4)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r5 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r5.a((java.lang.Throwable) r4)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r5 = r11.f33995e     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33992b = r12     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33998h = r1     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33999i = r4     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f34000j = r5     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                r11.f33991a = r3     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                java.lang.Object r1 = r5.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r11)     // Catch:{ CancellationException -> 0x00dc, Exception -> 0x00cf }
                if (r1 != r0) goto L_0x00bc
                return r0
            L_0x00bc:
                r3 = r12
                r12 = r1
                r1 = r4
                r0 = r5
            L_0x00c0:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r12 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                java.lang.String r12 = com.sumsub.sns.internal.core.common.o.a((java.lang.Throwable) r1, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12)     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                r0.a((java.lang.CharSequence) r12)     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r12 = r11.f33995e     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                r12.b((boolean) r2)     // Catch:{ CancellationException -> 0x00dd, Exception -> 0x00cf }
                goto L_0x00eb
            L_0x00cf:
                r12 = move-exception
                r1 = r12
                com.sumsub.sns.core.presentation.base.a r0 = r11.f33993c
                java.lang.String r2 = r11.f33994d
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x00eb
            L_0x00dc:
                r3 = r12
            L_0x00dd:
                com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r3)
                r7 = 0
                r8 = 4
                r9 = 0
                java.lang.String r6 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r4, r5, r6, r7, r8, r9)
            L_0x00eb:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$onPrepare$3$1", f = "SNSVerificationStepViewModel.kt", l = {198}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b0 f34003c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(SNSVerificationStepViewModel sNSVerificationStepViewModel, b0 b0Var, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f34002b = sNSVerificationStepViewModel;
            this.f34003c = b0Var;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f34002b, this.f34003c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34001a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSVerificationStepViewModel sNSVerificationStepViewModel = this.f34002b;
                b0 b0Var = this.f34003c;
                this.f34001a = 1;
                if (sNSVerificationStepViewModel.c(b0Var, this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$requestCode$$inlined$launchOnViewModelScope$1", f = "SNSVerificationStepViewModel.kt", l = {454, 464, 466, 472}, m = "invokeSuspend")
    public static final class m extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34004a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34005b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f34006c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f34007d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f34009f;

        /* renamed from: g  reason: collision with root package name */
        public Object f34010g;

        /* renamed from: h  reason: collision with root package name */
        public Object f34011h;

        /* renamed from: i  reason: collision with root package name */
        public Object f34012i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, SNSVerificationStepViewModel sNSVerificationStepViewModel, String str2) {
            super(2, cVar);
            this.f34006c = aVar;
            this.f34007d = str;
            this.f34008e = sNSVerificationStepViewModel;
            this.f34009f = str2;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((m) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            m mVar = new m(this.f34006c, this.f34007d, cVar, this.f34008e, this.f34009f);
            mVar.f34005b = obj;
            return mVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
            r2 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x015f, code lost:
            r4 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0161, code lost:
            r13 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0162, code lost:
            com.sumsub.sns.core.presentation.base.a.a(r12.f34006c, (java.lang.Throwable) r13, r12.f34007d, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x016e, code lost:
            r2 = r13;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0021, B:12:0x0038] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0021, B:15:0x0041] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0021, B:23:0x0063] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0021, B:44:0x00f0] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00f6 A[Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0161 A[ExcHandler: Exception (r13v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0021] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x00f0=Splitter:B:44:0x00f0, B:61:0x0149=Splitter:B:61:0x0149, B:32:0x009c=Splitter:B:32:0x009c, B:34:0x00af=Splitter:B:34:0x00af, B:51:0x010f=Splitter:B:51:0x010f} */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x0149=Splitter:B:61:0x0149, B:32:0x009c=Splitter:B:32:0x009c} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r12.f34004a
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x005c
                if (r1 == r6) goto L_0x004f
                if (r1 == r4) goto L_0x003d
                if (r1 == r3) goto L_0x002e
                if (r1 != r2) goto L_0x0026
                java.lang.Object r0 = r12.f34012i
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r0 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r0
                java.lang.Object r1 = r12.f34011h
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = r12.f34005b
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r13)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                goto L_0x0149
            L_0x0026:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x002e:
                java.lang.Object r1 = r12.f34011h
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r1
                java.lang.Object r3 = r12.f34010g
                java.lang.Object r4 = r12.f34005b
                kotlinx.coroutines.h0 r4 = (kotlinx.coroutines.h0) r4
                kotlin.k.b(r13)     // Catch:{ CancellationException -> 0x0170, Exception -> 0x0161 }
                goto L_0x010f
            L_0x003d:
                java.lang.Object r1 = r12.f34005b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r13)     // Catch:{ CancellationException -> 0x004c, Exception -> 0x0161 }
                kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x004c, Exception -> 0x0161 }
                java.lang.Object r13 = r13.m3081unboximpl()     // Catch:{ CancellationException -> 0x004c, Exception -> 0x0161 }
                goto L_0x00f0
            L_0x004c:
                r2 = r1
                goto L_0x016f
            L_0x004f:
                java.lang.Object r0 = r12.f34010g
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r0 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r0
                java.lang.Object r1 = r12.f34005b
                r2 = r1
                kotlinx.coroutines.h0 r2 = (kotlinx.coroutines.h0) r2
                kotlin.k.b(r13)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                goto L_0x009c
            L_0x005c:
                kotlin.k.b(r13)
                java.lang.Object r13 = r12.f34005b
                kotlinx.coroutines.h0 r13 = (kotlinx.coroutines.h0) r13
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r1.f33921d0 = r6     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.String r1 = r12.f34009f     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r8 = 0
                r7.a((java.lang.CharSequence) r8)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r7.b((boolean) r6)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r7 = r7.R     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r9 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.EMAIL     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r7 != r9) goto L_0x00af
                com.sumsub.sns.internal.core.presentation.screen.base.b r7 = com.sumsub.sns.internal.core.presentation.screen.base.b.f33883a     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                boolean r7 = r7.a(r1)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r7 != 0) goto L_0x00af
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.String r2 = "sns_confirmation_contact_email_isNotValid"
                r12.f34005b = r13     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r12.f34010g = r1     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r12.f34004a = r6     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.Object r2 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r12)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r2 != r0) goto L_0x0098
                return r0
            L_0x0098:
                r0 = r1
                r11 = r2
                r2 = r13
                r13 = r11
            L_0x009c:
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r0.a((java.lang.CharSequence) r13)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r13 = r12.f34008e     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$Step r0 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step.INIT     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r13.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step) r0)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r13 = r12.f34008e     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r13.b((boolean) r5)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                goto L_0x017e
            L_0x00af:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r6 = r6.R     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r7 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.PHONE     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r6 != r7) goto L_0x00d2
                java.lang.String r6 = "+"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.M(r1, r6, r5, r4, r8)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r6 != 0) goto L_0x00d2
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r6.<init>()     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r7 = 43
                r6.append(r7)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r6.append(r1)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.String r1 = r6.toString()     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
            L_0x00d2:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.domain.n r6 = r6.T     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = r12.f34008e     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r7 = r7.R     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.String r7 = r7.getType()     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r12.f34005b = r13     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                r12.f34004a = r4     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                java.lang.Object r1 = r6.a(r7, r1, r12)     // Catch:{ CancellationException -> 0x016e, Exception -> 0x0161 }
                if (r1 != r0) goto L_0x00ed
                return r0
            L_0x00ed:
                r11 = r1
                r1 = r13
                r13 = r11
            L_0x00f0:
                boolean r4 = kotlin.Result.m3079isSuccessimpl(r13)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                if (r4 == 0) goto L_0x011b
                r4 = r13
                com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r4 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r4     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r12.f34008e     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34005b = r1     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34010g = r13     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34011h = r6     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34004a = r3     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                java.lang.Object r3 = r6.a((com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b>) r12)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                if (r3 != r0) goto L_0x010a
                return r0
            L_0x010a:
                r4 = r1
                r1 = r6
                r11 = r3
                r3 = r13
                r13 = r11
            L_0x010f:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r13 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r13     // Catch:{ CancellationException -> 0x0170, Exception -> 0x0161 }
                r1.b((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r13)     // Catch:{ CancellationException -> 0x0170, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r13 = r12.f34008e     // Catch:{ CancellationException -> 0x0170, Exception -> 0x0161 }
                r13.b((boolean) r5)     // Catch:{ CancellationException -> 0x0170, Exception -> 0x0161 }
                r13 = r3
                r1 = r4
            L_0x011b:
                java.lang.Throwable r3 = kotlin.Result.m3075exceptionOrNullimpl(r13)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                if (r3 == 0) goto L_0x017e
                com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r6 = r12.f34008e     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                java.lang.String r6 = com.sumsub.sns.internal.log.c.a(r6)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                java.lang.String r7 = "request code error"
                r4.e(r6, r7, r3)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r4 = r12.f34008e     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r4.a((java.lang.Throwable) r3)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r4 = r12.f34008e     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34005b = r1     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34010g = r13     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34011h = r3     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34012i = r4     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                r12.f34004a = r2     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                java.lang.Object r13 = r4.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r12)     // Catch:{ CancellationException -> 0x015f, Exception -> 0x0161 }
                if (r13 != r0) goto L_0x0146
                return r0
            L_0x0146:
                r2 = r1
                r1 = r3
                r0 = r4
            L_0x0149:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r13 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r13     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                java.lang.String r13 = com.sumsub.sns.internal.core.common.o.a((java.lang.Throwable) r1, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r13)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r0.a((java.lang.CharSequence) r13)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r13 = r12.f34008e     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$Step r0 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step.INIT     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r13.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step) r0)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r13 = r12.f34008e     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                r13.b((boolean) r5)     // Catch:{ CancellationException -> 0x016f, Exception -> 0x0161 }
                goto L_0x017e
            L_0x015f:
                r4 = r1
                goto L_0x0170
            L_0x0161:
                r13 = move-exception
                r1 = r13
                com.sumsub.sns.core.presentation.base.a r0 = r12.f34006c
                java.lang.String r2 = r12.f34007d
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x017e
            L_0x016e:
                r2 = r13
            L_0x016f:
                r4 = r2
            L_0x0170:
                com.sumsub.sns.internal.log.a r5 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r6 = com.sumsub.sns.internal.log.c.a(r4)
                r8 = 0
                r9 = 4
                r10 = 0
                java.lang.String r7 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r5, r6, r7, r8, r9, r10)
            L_0x017e:
                kotlin.Unit r13 = kotlin.Unit.f56620a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$startCountdownTimer$1", f = "SNSVerificationStepViewModel.kt", l = {273}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34013a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f34015c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(SNSVerificationStepViewModel sNSVerificationStepViewModel, b bVar, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f34014b = sNSVerificationStepViewModel;
            this.f34015c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n(this.f34014b, this.f34015c, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
            r12 = r12.h();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f34013a
                r3 = 1
                if (r2 == 0) goto L_0x0019
                if (r2 != r3) goto L_0x0011
                kotlin.k.b(r20)
                goto L_0x002a
            L_0x0011:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0019:
                kotlin.k.b(r20)
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r2 = r0.f34014b
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r4 = r0.f34015c
                r2.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r4)
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r2 = r0.f34014b
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$Step r4 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step.VERIFY_CODE
                r2.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step) r4)
            L_0x002a:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = r0.f34015c
                java.lang.Long r2 = r2.h()
                if (r2 == 0) goto L_0x0095
                long r4 = java.lang.System.currentTimeMillis()
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = r0.f34015c
                java.lang.Long r2 = r2.h()
                long r6 = r2.longValue()
                int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r2 >= 0) goto L_0x0095
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r2 = r0.f34014b
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r4 = r2.r()
                if (r4 == 0) goto L_0x0086
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r12 = r0.f34014b
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r12 = r12.r()
                r13 = 0
                if (r12 == 0) goto L_0x006e
                java.lang.Long r12 = r12.h()
                if (r12 == 0) goto L_0x006e
                long r15 = r12.longValue()
                long r17 = java.lang.System.currentTimeMillis()
                long r15 = r15 - r17
                r9 = r15
                goto L_0x006f
            L_0x006e:
                r9 = r13
            L_0x006f:
                long r9 = r11.toSeconds(r9)
                long r13 = kotlin.ranges.RangesKt___RangesKt.e(r9, r13)
                r15 = 63
                r16 = 0
                r9 = 0
                r10 = 0
                r11 = r13
                r13 = r15
                r14 = r16
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r4 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r13, r14)
                goto L_0x0087
            L_0x0086:
                r4 = 0
            L_0x0087:
                r2.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r4)
                r0.f34013a = r3
                r4 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r4, r0)
                if (r2 != r1) goto L_0x002a
                return r1
            L_0x0095:
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = r0.f34014b
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = r0.f34015c
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r11 = 31
                r12 = 0
                com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.a(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12)
                r1.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r2)
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel", f = "SNSVerificationStepViewModel.kt", l = {320, 321, 323}, m = "verifyCheckCodeResponse")
    public static final class o extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34016a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34017b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34018c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f34019d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34020e;

        /* renamed from: f  reason: collision with root package name */
        public int f34021f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super o> cVar) {
            super(cVar);
            this.f34020e = sNSVerificationStepViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34019d = obj;
            this.f34021f |= Integer.MIN_VALUE;
            return this.f34020e.c((b0) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$verifyCheckCodeResponse$2", f = "SNSVerificationStepViewModel.kt", l = {305}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34022a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34023b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super p> cVar) {
            super(2, cVar);
            this.f34023b = sNSVerificationStepViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((p) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new p(this.f34023b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34022a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f34022a = 1;
                if (DelayKt.b(2000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f34023b.a((a.j) c.a.f33930a);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$viewState$1", f = "SNSVerificationStepViewModel.kt", l = {75, 76, 77}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements s<Step, CharSequence, b, b0, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34024a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34025b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f34026c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f34027d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34028e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34029f;

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f34030a;

            static {
                int[] iArr = new int[Step.values().length];
                iArr[Step.INIT.ordinal()] = 1;
                iArr[Step.VERIFY_CODE.ordinal()] = 2;
                iArr[Step.STATUS.ordinal()] = 3;
                f34030a = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super q> cVar) {
            super(5, cVar);
            this.f34029f = sNSVerificationStepViewModel;
        }

        /* renamed from: a */
        public final Object invoke(Step step, CharSequence charSequence, b bVar, b0 b0Var, kotlin.coroutines.c<? super e> cVar) {
            q qVar = new q(this.f34029f, cVar);
            qVar.f34025b = step;
            qVar.f34026c = charSequence;
            qVar.f34027d = bVar;
            qVar.f34028e = b0Var;
            return qVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34024a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                CharSequence charSequence = (CharSequence) this.f34026c;
                b bVar = (b) this.f34027d;
                b0 b0Var = (b0) this.f34028e;
                int i12 = a.f34030a[((Step) this.f34025b).ordinal()];
                if (i12 == 1) {
                    SNSVerificationStepViewModel sNSVerificationStepViewModel = this.f34029f;
                    this.f34025b = null;
                    this.f34026c = null;
                    this.f34027d = null;
                    this.f34024a = 1;
                    obj = sNSVerificationStepViewModel.a(charSequence, (kotlin.coroutines.c<? super e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                    return (e) obj;
                } else if (i12 == 2) {
                    SNSVerificationStepViewModel sNSVerificationStepViewModel2 = this.f34029f;
                    this.f34025b = null;
                    this.f34026c = null;
                    this.f34027d = null;
                    this.f34024a = 2;
                    obj = sNSVerificationStepViewModel2.a(bVar, (kotlin.coroutines.c<? super e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                    return (e) obj;
                } else if (i12 == 3) {
                    SNSVerificationStepViewModel sNSVerificationStepViewModel3 = this.f34029f;
                    this.f34025b = null;
                    this.f34026c = null;
                    this.f34027d = null;
                    this.f34024a = 3;
                    obj = sNSVerificationStepViewModel3.b(b0Var, (kotlin.coroutines.c<? super e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                return (e) obj;
            } else if (i11 == 2) {
                kotlin.k.b(obj);
                return (e) obj;
            } else if (i11 == 3) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (e) obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$viewState$2", f = "SNSVerificationStepViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super e>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34031a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34032b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel f34033c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(SNSVerificationStepViewModel sNSVerificationStepViewModel, kotlin.coroutines.c<? super r> cVar) {
            super(3, cVar);
            this.f34033c = sNSVerificationStepViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super e> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            r rVar = new r(this.f34033c, cVar);
            rVar.f34032b = th2;
            return rVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f34031a == 0) {
                kotlin.k.b(obj);
                Throwable th2 = (Throwable) this.f34032b;
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a(this.f34033c);
                aVar.e(a11, "Error building state: " + th2.getMessage(), th2);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Class<SNSVerificationStepViewModel> cls = SNSVerificationStepViewModel.class;
        f33909r = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "step", "getStep()Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$Step;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "currentError", "getCurrentError()Ljava/lang/CharSequence;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "countdown", "getCountdown()Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$CountdownData;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "codeResponse", "getCodeResponse()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/RequestCodeResponse;", 0))};
    }

    public SNSVerificationStepViewModel(ValidationIdentifierType validationIdentifierType, com.sumsub.sns.internal.core.domain.d dVar, com.sumsub.sns.internal.core.domain.n nVar, com.sumsub.sns.internal.core.domain.a aVar, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, SavedStateHandle savedStateHandle) {
        super(aVar2, bVar);
        this.R = validationIdentifierType;
        this.S = dVar;
        this.T = nVar;
        this.U = aVar;
        this.V = bVar;
        this.W = savedStateHandle;
        Step step = Step.INIT;
        this.Z = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, f33910s, step);
        this.f33918a0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, f33911t, null);
        this.f33919b0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, f33912u, null);
        this.f33920c0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, f33913v, null);
        this.f33922e0 = kotlinx.coroutines.flow.f.a0(kotlinx.coroutines.flow.f.f(kotlinx.coroutines.flow.f.l(savedStateHandle.g(f33910s, step), savedStateHandle.g(f33911t, null), savedStateHandle.g(f33912u, null), savedStateHandle.g(f33913v, null), new q(this, (kotlin.coroutines.c<? super q>) null)), new r(this, (kotlin.coroutines.c<? super r>) null)), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), e.a.f33937d);
    }

    public String f() {
        int i11 = f.f33963a[this.R.ordinal()];
        if (i11 == 1) {
            return DocumentType.f32352g;
        }
        if (i11 == 2) {
            return DocumentType.f32353h;
        }
        if (i11 == 3) {
            return DocumentType.f32355j;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void p() {
        a((CharSequence) null);
    }

    public final b0 q() {
        return (b0) this.f33920c0.a(this, f33909r[3]);
    }

    public final b r() {
        return (b) this.f33919b0.a(this, f33909r[2]);
    }

    public final CharSequence s() {
        return (CharSequence) this.f33918a0.a(this, f33909r[1]);
    }

    public final String t() {
        int i11 = f.f33963a[this.R.ordinal()];
        if (i11 == 1) {
            return DocumentType.f32352g;
        }
        if (i11 == 2) {
            return DocumentType.f32353h;
        }
        if (i11 == 3) {
            return DocumentType.f32355j;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Step u() {
        return (Step) this.Z.a(this, f33909r[0]);
    }

    /* renamed from: v */
    public j1<e> j() {
        return this.f33922e0;
    }

    public final void w() {
        a(Step.INIT);
        n1 n1Var = this.X;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.X = null;
        a((b0) null);
        a((b) null);
        a((CharSequence) null);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        b r11 = r();
        if (r11 != null) {
            b(r11);
        }
        b0 q11 = q();
        if (q11 != null) {
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new l(this, q11, (kotlin.coroutines.c<? super l>) null), 3, (Object) null);
        }
        return Unit.f56620a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b} */
    /* JADX WARNING: type inference failed for: r9v2, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0142 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0156 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r23, kotlin.coroutines.c<? super kotlin.Unit> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.o
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$o r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.o) r3
            int r4 = r3.f34021f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f34021f = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$o r3 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$o
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f34019d
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f34021f
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x006d
            if (r5 == r8) goto L_0x0056
            if (r5 == r7) goto L_0x0047
            if (r5 != r6) goto L_0x003f
            java.lang.Object r1 = r3.f34017b
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r1
            java.lang.Object r3 = r3.f34016a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r3
            kotlin.k.b(r2)
            goto L_0x0158
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            java.lang.Object r1 = r3.f34017b
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r1 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r1
            java.lang.Object r5 = r3.f34016a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r5 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r5
            kotlin.k.b(r2)
            r2 = r1
            r1 = r5
            goto L_0x0145
        L_0x0056:
            java.lang.Object r1 = r3.f34018c
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r1
            java.lang.Object r5 = r3.f34017b
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r5 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r5
            java.lang.Object r8 = r3.f34016a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r8 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r8
            kotlin.k.b(r2)
            r21 = r2
            r2 = r1
            r1 = r5
            r5 = r21
            goto L_0x012d
        L_0x006d:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r11 = com.sumsub.sns.internal.log.c.a(r22)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "checkCodeResponse "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r12 = r2.toString()
            r13 = 0
            r14 = 4
            r15 = 0
            com.sumsub.log.logger.a.d(r10, r11, r12, r13, r14, r15)
            java.lang.String r2 = r23.r()
            com.sumsub.sns.internal.core.data.source.applicant.remote.Status r5 = com.sumsub.sns.internal.core.data.source.applicant.remote.Status.VERIFIED
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.x.b(r2, r5)
            if (r5 == 0) goto L_0x00dc
            kotlinx.coroutines.n1 r2 = r0.X
            if (r2 == 0) goto L_0x00a4
            kotlinx.coroutines.n1.a.a(r2, r9, r8, r9)
        L_0x00a4:
            r0.X = r9
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r10 = r22.r()
            if (r10 == 0) goto L_0x00be
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 95
            r20 = 0
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.a(r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)
            goto L_0x00bf
        L_0x00be:
            r2 = r9
        L_0x00bf:
            r0.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r2)
            r22.a((com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r23)
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$Step r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step.STATUS
            r0.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step) r1)
            kotlinx.coroutines.h0 r2 = androidx.lifecycle.m0.a(r22)
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$p r5 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$p
            r5.<init>(r0, r9)
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            goto L_0x0179
        L_0x00dc:
            com.sumsub.sns.internal.core.data.source.applicant.remote.Status r5 = com.sumsub.sns.internal.core.data.source.applicant.remote.Status.REJECTED
            java.lang.String r5 = r5.getValue()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r5)
            if (r2 == 0) goto L_0x0119
            kotlinx.coroutines.n1 r2 = r0.X
            if (r2 == 0) goto L_0x00ef
            kotlinx.coroutines.n1.a.a(r2, r9, r8, r9)
        L_0x00ef:
            r0.X = r9
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r10 = r22.r()
            if (r10 == 0) goto L_0x0108
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 95
            r20 = 0
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r9 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.a(r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)
        L_0x0108:
            r0.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r9)
            r22.a((com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r23)
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$Step r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step.STATUS
            r0.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.Step) r1)
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$c$b r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.c.b.f33931a
            r0.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            goto L_0x0179
        L_0x0119:
            r3.f34016a = r0
            r3.f34017b = r1
            r3.f34018c = r0
            r3.f34021f = r8
            java.lang.String r2 = "sns_confirmation_code_isNotValid"
            java.lang.Object r2 = r0.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x012a
            return r4
        L_0x012a:
            r8 = r0
            r5 = r2
            r2 = r8
        L_0x012d:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.a((java.lang.CharSequence) r5)
            r3.f34016a = r8
            r3.f34017b = r1
            r3.f34018c = r9
            r3.f34021f = r7
            r10 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r10, r3)
            if (r2 != r4) goto L_0x0143
            return r4
        L_0x0143:
            r2 = r1
            r1 = r8
        L_0x0145:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$c$b r5 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.c.b.f33931a
            r1.a((com.sumsub.sns.core.presentation.base.a.j) r5)
            r3.f34016a = r1
            r3.f34017b = r1
            r3.f34021f = r6
            java.lang.Object r2 = r1.a((com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r2, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b>) r3)
            if (r2 != r4) goto L_0x0157
            return r4
        L_0x0157:
            r3 = r1
        L_0x0158:
            r10 = r2
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r10 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r10
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = r3.r()
            if (r2 == 0) goto L_0x016a
            java.lang.Long r9 = r2.h()
        L_0x016a:
            r16 = r9
            r17 = 0
            r19 = 95
            r20 = 0
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r2 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b.a(r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)
            r1.a((com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r2)
        L_0x0179:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.c(com.sumsub.sns.internal.core.data.source.applicant.remote.b0, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r18, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.i
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$i r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.i) r3
            int r4 = r3.f33981e
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f33981e = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$i r3 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$i
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f33979c
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f33981e
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            if (r5 == 0) goto L_0x0068
            if (r5 == r10) goto L_0x0064
            if (r5 == r9) goto L_0x0060
            if (r5 == r8) goto L_0x0057
            if (r5 == r7) goto L_0x004e
            if (r5 != r6) goto L_0x0046
            java.lang.Object r1 = r3.f33978b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r3.f33977a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            kotlin.k.b(r2)
            r9 = r1
            r7 = r3
            goto L_0x0110
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            java.lang.Object r1 = r3.f33977a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r1
            kotlin.k.b(r2)
            goto L_0x00f6
        L_0x0057:
            java.lang.Object r1 = r3.f33977a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r1 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r1
            kotlin.k.b(r2)
            goto L_0x00e5
        L_0x0060:
            kotlin.k.b(r2)
            goto L_0x00be
        L_0x0064:
            kotlin.k.b(r2)
            goto L_0x00af
        L_0x0068:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r12 = com.sumsub.sns.internal.log.c.a(r17)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "buildStatusState "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r13 = r2.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            com.sumsub.log.logger.a.d(r11, r12, r13, r14, r15, r16)
            if (r1 != 0) goto L_0x008e
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$a r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.a.f33937d
            return r1
        L_0x008e:
            java.lang.String r1 = r18.r()
            com.sumsub.sns.internal.core.data.source.applicant.remote.Status r2 = com.sumsub.sns.internal.core.data.source.applicant.remote.Status.VERIFIED
            java.lang.String r2 = r2.getValue()
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            if (r1 == 0) goto L_0x00d1
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r1 = r0.R
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r2 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.EMAIL
            if (r1 != r2) goto L_0x00b3
            r3.f33981e = r10
            java.lang.String r1 = "sns_confirmation_result_email_success_title"
            java.lang.Object r2 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x00af
            return r4
        L_0x00af:
            java.lang.String r2 = (java.lang.String) r2
        L_0x00b1:
            r4 = r2
            goto L_0x00c1
        L_0x00b3:
            r3.f33981e = r9
            java.lang.String r1 = "sns_confirmation_result_phone_success_title"
            java.lang.Object r2 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x00be
            return r4
        L_0x00be:
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00b1
        L_0x00c1:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r1 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.SUCCESS
            java.lang.String r6 = r1.getImageName()
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b
            r5 = 0
            r7 = 0
            r8 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x011b
        L_0x00d1:
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r1 = r0.R
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r2 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.EMAIL
            if (r1 != r2) goto L_0x00e8
            r3.f33977a = r0
            r3.f33981e = r8
            java.lang.String r1 = "sns_confirmation_result_email_failure_title"
            java.lang.Object r2 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x00e4
            return r4
        L_0x00e4:
            r1 = r0
        L_0x00e5:
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00f8
        L_0x00e8:
            r3.f33977a = r0
            r3.f33981e = r7
            java.lang.String r1 = "sns_confirmation_result_phone_failure_title"
            java.lang.Object r2 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x00f5
            return r4
        L_0x00f5:
            r1 = r0
        L_0x00f6:
            java.lang.String r2 = (java.lang.String) r2
        L_0x00f8:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r5 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r5 = r5.getImageName()
            r3.f33977a = r2
            r3.f33978b = r5
            r3.f33981e = r6
            java.lang.String r6 = "sns_confirmation_result_action_tryAgain"
            java.lang.Object r1 = r1.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r1 != r4) goto L_0x010d
            return r4
        L_0x010d:
            r7 = r2
            r9 = r5
            r2 = r1
        L_0x0110:
            r10 = r2
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b
            r8 = 0
            r11 = 1
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x011b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b(com.sumsub.sns.internal.core.data.source.applicant.remote.b0, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(Step step) {
        this.Z.a(this, f33909r[0], step);
    }

    public final void a(CharSequence charSequence) {
        this.f33918a0.a(this, f33909r[1], charSequence);
    }

    public final void a(b bVar) {
        this.f33919b0.a(this, f33909r[2], bVar);
    }

    public final void a(b0 b0Var) {
        this.f33920c0.a(this, f33909r[3], b0Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0152, code lost:
        r1 = (com.sumsub.sns.internal.core.data.model.g) r1;
        r10 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.f.f33963a[r9.R.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x015f, code lost:
        if (r10 == 1) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0161, code lost:
        if (r10 != 2) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0163, code lost:
        r7 = r9.S;
        r2.f33969a = r9;
        r2.f33970b = r4;
        r2.f33971c = r1;
        r2.f33976h = 6;
        r6 = r7.a(false, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0172, code lost:
        if (r6 != r3) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0174, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0175, code lost:
        r7 = r9;
        r16 = r6;
        r6 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x017f, code lost:
        if (kotlin.Result.m3079isSuccessimpl(r1) == false) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0181, code lost:
        r2.f33969a = r7;
        r2.f33970b = r4;
        r2.f33971c = r6;
        r2.f33972d = r1;
        r2.f33976h = 7;
        r9 = r7.a(f33917z, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0192, code lost:
        if (r9 != r3) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0194, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0195, code lost:
        r10 = r7;
        r7 = r4;
        r4 = r1;
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0199, code lost:
        r1 = (java.lang.String) r1;
        r2.f33969a = r10;
        r2.f33970b = r7;
        r2.f33971c = r6;
        r2.f33972d = r4;
        r2.f33973e = r1;
        r2.f33976h = 8;
        r9 = r10.a(A, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01af, code lost:
        if (r9 != r3) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01b1, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01b2, code lost:
        r16 = r4;
        r4 = r1;
        r1 = r9;
        r9 = r6;
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b9, code lost:
        r1 = (java.lang.String) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01bd, code lost:
        if (r10.f33921d0 == false) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01c0, code lost:
        r9 = r9.G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c4, code lost:
        if (r9 == null) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c6, code lost:
        r8 = kotlin.text.StringsKt__StringsKt.A0(r9, "+");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01cc, code lost:
        r2.f33969a = r7;
        r2.f33970b = r6;
        r2.f33971c = r4;
        r2.f33972d = r1;
        r2.f33973e = r8;
        r2.f33976h = 9;
        r2 = r10.a(B, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01de, code lost:
        if (r2 != r3) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01e0, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e1, code lost:
        r3 = r4;
        r5 = r8;
        r4 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e5, code lost:
        kotlin.k.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01f5, code lost:
        if (r4 == null) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f7, code lost:
        r1 = kotlin.Result.m3075exceptionOrNullimpl(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01fd, code lost:
        if ((r1 instanceof java.lang.Exception) == false) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ff, code lost:
        r1 = (java.lang.Exception) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0202, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0203, code lost:
        if (r1 == null) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0205, code lost:
        r8 = r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0209, code lost:
        r1 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE.getImageName();
        r2.f33969a = r4;
        r2.f33970b = r8;
        r2.f33971c = r1;
        r2.f33976h = 10;
        r2 = r7.a(com.sumsub.sns.internal.core.common.n0.j.f32202b, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x021f, code lost:
        if (r2 != r3) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0221, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0222, code lost:
        r5 = r1;
        r1 = r2;
        r3 = r4;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0232, code lost:
        r2.f33969a = r7;
        r2.f33970b = null;
        r2.f33971c = null;
        r2.f33976h = 11;
        r1 = r7.a(L, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0242, code lost:
        if (r1 != r3) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0244, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0245, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0246, code lost:
        r2.a((java.lang.CharSequence) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x025a, code lost:
        throw new java.lang.IllegalStateException("Invalid type".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x025b, code lost:
        r9.b(false);
        r2.f33969a = r9;
        r2.f33970b = r4;
        r2.f33971c = r1;
        r2.f33976h = 2;
        r6 = r9.a(f33914w, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x026c, code lost:
        if (r6 != r3) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x026e, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x026f, code lost:
        r7 = r9;
        r16 = r6;
        r6 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0275, code lost:
        r1 = (java.lang.CharSequence) r1;
        r2.f33969a = r7;
        r2.f33970b = r4;
        r2.f33971c = r6;
        r2.f33972d = r1;
        r2.f33976h = 3;
        r9 = r7.a(f33915x, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0288, code lost:
        if (r9 != r3) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x028a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x028b, code lost:
        r16 = r4;
        r4 = r1;
        r1 = r9;
        r9 = r7;
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0292, code lost:
        r1 = (java.lang.CharSequence) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0296, code lost:
        if (r9.f33921d0 == false) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0299, code lost:
        r8 = r6.x();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x029d, code lost:
        r2.f33969a = r9;
        r2.f33970b = r7;
        r2.f33971c = r4;
        r2.f33972d = r1;
        r2.f33973e = r8;
        r2.f33976h = 4;
        r6 = r9.a(f33916y, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02b0, code lost:
        if (r6 != r3) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b2, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02b3, code lost:
        r16 = r6;
        r6 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b8, code lost:
        r1 = (java.lang.CharSequence) r1;
        r2.f33969a = r4;
        r2.f33970b = r6;
        r2.f33971c = r8;
        r2.f33972d = r1;
        r2.f33973e = r7;
        r2.f33976h = 5;
        r2 = r9.a(B, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02cb, code lost:
        if (r2 != r3) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02cd, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02ce, code lost:
        r3 = r4;
        r4 = r6;
        r5 = r8;
        r6 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.d(r3, r4, r5, r6, r7, (java.lang.CharSequence) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        return new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.C0383e(r3, r4, r5, (com.sumsub.sns.internal.core.domain.e) r6, r7, (java.lang.String) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.b(r3, r4, r5, (java.lang.CharSequence) r1, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.a.f33937d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.CharSequence r18, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.h
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$h r2 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.h) r2
            int r3 = r2.f33976h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33976h = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$h r2 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$h
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f33974f
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f33976h
            java.lang.String r5 = "sns_confirmation_contact_action_send"
            r6 = 0
            r7 = 1
            r8 = 0
            switch(r4) {
                case 0: goto L_0x012f;
                case 1: goto L_0x0123;
                case 2: goto L_0x010d;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00d9;
                case 5: goto L_0x00b9;
                case 6: goto L_0x009d;
                case 7: goto L_0x0089;
                case 8: goto L_0x006d;
                case 9: goto L_0x0050;
                case 10: goto L_0x003d;
                case 11: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0034:
            java.lang.Object r2 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r2 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r2
            kotlin.k.b(r1)
            goto L_0x0246
        L_0x003d:
            java.lang.Object r3 = r2.f33971c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f33970b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r2 = r2.f33969a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.k.b(r1)
            r5 = r3
            r3 = r2
            goto L_0x0226
        L_0x0050:
            java.lang.Object r3 = r2.f33973e
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f33972d
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.f33971c
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.f33970b
            java.lang.Object r2 = r2.f33969a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.k.b(r1)
            r7 = r2
            r16 = r5
            r5 = r3
            r3 = r16
            goto L_0x01e5
        L_0x006d:
            java.lang.Object r4 = r2.f33973e
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.f33972d
            java.lang.Object r7 = r2.f33971c
            com.sumsub.sns.internal.core.data.model.g r7 = (com.sumsub.sns.internal.core.data.model.g) r7
            java.lang.Object r9 = r2.f33970b
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.Object r10 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r10 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r10
            kotlin.k.b(r1)
            r16 = r9
            r9 = r7
            r7 = r16
            goto L_0x01b9
        L_0x0089:
            java.lang.Object r4 = r2.f33972d
            java.lang.Object r6 = r2.f33971c
            com.sumsub.sns.internal.core.data.model.g r6 = (com.sumsub.sns.internal.core.data.model.g) r6
            java.lang.Object r7 = r2.f33970b
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.Object r9 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r9 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r9
            kotlin.k.b(r1)
            r10 = r9
            goto L_0x0199
        L_0x009d:
            java.lang.Object r4 = r2.f33971c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r6 = r2.f33970b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.Object r7 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r7
            kotlin.k.b(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.m3081unboximpl()
            r16 = r6
            r6 = r4
            r4 = r16
            goto L_0x017b
        L_0x00b9:
            java.lang.Object r3 = r2.f33973e
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r4 = r2.f33972d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r2.f33971c
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r2.f33970b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.Object r2 = r2.f33969a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.k.b(r1)
            r7 = r3
            r3 = r2
            r16 = r6
            r6 = r4
            r4 = r16
            goto L_0x02d3
        L_0x00d9:
            java.lang.Object r4 = r2.f33973e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r6 = r2.f33972d
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.Object r7 = r2.f33971c
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.Object r8 = r2.f33970b
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.Object r9 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r9 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r9
            kotlin.k.b(r1)
            r16 = r8
            r8 = r4
            r4 = r7
            r7 = r16
            goto L_0x02b8
        L_0x00f8:
            java.lang.Object r4 = r2.f33972d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r6 = r2.f33971c
            com.sumsub.sns.internal.core.data.model.g r6 = (com.sumsub.sns.internal.core.data.model.g) r6
            java.lang.Object r7 = r2.f33970b
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.Object r9 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r9 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r9
            kotlin.k.b(r1)
            goto L_0x0292
        L_0x010d:
            java.lang.Object r4 = r2.f33971c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r6 = r2.f33970b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.Object r7 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r7 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r7
            kotlin.k.b(r1)
            r16 = r6
            r6 = r4
            r4 = r16
            goto L_0x0275
        L_0x0123:
            java.lang.Object r4 = r2.f33970b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r9 = r2.f33969a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r9 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r9
            kotlin.k.b(r1)
            goto L_0x0152
        L_0x012f:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r11 = com.sumsub.sns.internal.log.c.a(r17)
            r13 = 0
            r14 = 4
            r15 = 0
            java.lang.String r12 = "buildInitState"
            com.sumsub.log.logger.a.d(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r0.V
            r2.f33969a = r0
            r4 = r18
            r2.f33970b = r4
            r2.f33976h = r7
            java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.d(r1, r6, r2, r7, r8)
            if (r1 != r3) goto L_0x0151
            return r3
        L_0x0151:
            r9 = r0
        L_0x0152:
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r10 = r9.R
            int[] r11 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.f.f33963a
            int r10 = r10.ordinal()
            r10 = r11[r10]
            r11 = 2
            if (r10 == r7) goto L_0x025b
            if (r10 != r11) goto L_0x024f
            com.sumsub.sns.internal.core.domain.d r7 = r9.S
            r2.f33969a = r9
            r2.f33970b = r4
            r2.f33971c = r1
            r10 = 6
            r2.f33976h = r10
            java.lang.Object r6 = r7.a(r6, r2)
            if (r6 != r3) goto L_0x0175
            return r3
        L_0x0175:
            r7 = r9
            r16 = r6
            r6 = r1
            r1 = r16
        L_0x017b:
            boolean r9 = kotlin.Result.m3079isSuccessimpl(r1)
            if (r9 == 0) goto L_0x01f5
            r2.f33969a = r7
            r2.f33970b = r4
            r2.f33971c = r6
            r2.f33972d = r1
            r9 = 7
            r2.f33976h = r9
            java.lang.String r9 = "sns_confirmation_contact_phone_title"
            java.lang.Object r9 = r7.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r9 != r3) goto L_0x0195
            return r3
        L_0x0195:
            r10 = r7
            r7 = r4
            r4 = r1
            r1 = r9
        L_0x0199:
            java.lang.String r1 = (java.lang.String) r1
            r2.f33969a = r10
            r2.f33970b = r7
            r2.f33971c = r6
            r2.f33972d = r4
            r2.f33973e = r1
            r9 = 8
            r2.f33976h = r9
            java.lang.String r9 = "sns_confirmation_contact_phone_subtitle"
            java.lang.Object r9 = r10.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r9 != r3) goto L_0x01b2
            return r3
        L_0x01b2:
            r16 = r4
            r4 = r1
            r1 = r9
            r9 = r6
            r6 = r16
        L_0x01b9:
            java.lang.String r1 = (java.lang.String) r1
            boolean r11 = r10.f33921d0
            if (r11 == 0) goto L_0x01c0
            goto L_0x01cc
        L_0x01c0:
            java.lang.String r9 = r9.G()
            if (r9 == 0) goto L_0x01cc
            java.lang.String r8 = "+"
            java.lang.String r8 = kotlin.text.StringsKt__StringsKt.A0(r9, r8)
        L_0x01cc:
            r2.f33969a = r7
            r2.f33970b = r6
            r2.f33971c = r4
            r2.f33972d = r1
            r2.f33973e = r8
            r9 = 9
            r2.f33976h = r9
            java.lang.Object r2 = r10.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x01e1
            return r3
        L_0x01e1:
            r3 = r4
            r5 = r8
            r4 = r1
            r1 = r2
        L_0x01e5:
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.domain.e r6 = (com.sumsub.sns.internal.core.domain.e) r6
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$e r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$e
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x02dc
        L_0x01f5:
            if (r4 == 0) goto L_0x0232
            java.lang.Throwable r1 = kotlin.Result.m3075exceptionOrNullimpl(r1)
            boolean r5 = r1 instanceof java.lang.Exception
            if (r5 == 0) goto L_0x0202
            java.lang.Exception r1 = (java.lang.Exception) r1
            goto L_0x0203
        L_0x0202:
            r1 = r8
        L_0x0203:
            if (r1 == 0) goto L_0x0209
            java.lang.String r8 = r1.getMessage()
        L_0x0209:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r1 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r1 = r1.getImageName()
            r2.f33969a = r4
            r2.f33970b = r8
            r2.f33971c = r1
            r5 = 10
            r2.f33976h = r5
            java.lang.String r5 = "sns_confirmation_result_action_tryAgain"
            java.lang.Object r2 = r7.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x0222
            return r3
        L_0x0222:
            r5 = r1
            r1 = r2
            r3 = r4
            r4 = r8
        L_0x0226:
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$b
            r7 = 1
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x02dc
        L_0x0232:
            r2.f33969a = r7
            r2.f33970b = r8
            r2.f33971c = r8
            r1 = 11
            r2.f33976h = r1
            java.lang.String r1 = "sns_confirmation_result_phone_failure_title"
            java.lang.Object r1 = r7.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r1 != r3) goto L_0x0245
            return r3
        L_0x0245:
            r2 = r7
        L_0x0246:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.a((java.lang.CharSequence) r1)
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$a r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.a.f33937d
            goto L_0x02dc
        L_0x024f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Invalid type"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x025b:
            r9.b((boolean) r6)
            r2.f33969a = r9
            r2.f33970b = r4
            r2.f33971c = r1
            r2.f33976h = r11
            java.lang.String r6 = "sns_confirmation_contact_email_title"
            java.lang.Object r6 = r9.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r6 != r3) goto L_0x026f
            return r3
        L_0x026f:
            r7 = r9
            r16 = r6
            r6 = r1
            r1 = r16
        L_0x0275:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.f33969a = r7
            r2.f33970b = r4
            r2.f33971c = r6
            r2.f33972d = r1
            r9 = 3
            r2.f33976h = r9
            java.lang.String r9 = "sns_confirmation_contact_email_subtitle"
            java.lang.Object r9 = r7.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r9 != r3) goto L_0x028b
            return r3
        L_0x028b:
            r16 = r4
            r4 = r1
            r1 = r9
            r9 = r7
            r7 = r16
        L_0x0292:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r10 = r9.f33921d0
            if (r10 == 0) goto L_0x0299
            goto L_0x029d
        L_0x0299:
            java.lang.String r8 = r6.x()
        L_0x029d:
            r2.f33969a = r9
            r2.f33970b = r7
            r2.f33971c = r4
            r2.f33972d = r1
            r2.f33973e = r8
            r6 = 4
            r2.f33976h = r6
            java.lang.String r6 = "sns_confirmation_contact_email_placeholder"
            java.lang.Object r6 = r9.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r6 != r3) goto L_0x02b3
            return r3
        L_0x02b3:
            r16 = r6
            r6 = r1
            r1 = r16
        L_0x02b8:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.f33969a = r4
            r2.f33970b = r6
            r2.f33971c = r8
            r2.f33972d = r1
            r2.f33973e = r7
            r10 = 5
            r2.f33976h = r10
            java.lang.Object r2 = r9.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x02ce
            return r3
        L_0x02ce:
            r3 = r4
            r4 = r6
            r5 = r8
            r6 = r1
            r1 = r2
        L_0x02d3:
            r8 = r1
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$d r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$d
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x02dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.a(java.lang.CharSequence, kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(String str) {
        String t11 = t();
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new m(this, t11, (kotlin.coroutines.c) null, this, str), 3, (Object) null);
    }

    public final void b(b bVar) {
        n1 n1Var = this.X;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.X = kotlinx.coroutines.i.d(this.Y, (CoroutineContext) null, (CoroutineStart) null, new n(this, bVar, (kotlin.coroutines.c<? super n>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b r19, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.j
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$j r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.j) r3
            int r4 = r3.f33990i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f33990i = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$j r3 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$j
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f33988g
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f33990i
            r6 = 0
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x0068
            if (r5 == r8) goto L_0x0050
            if (r5 != r7) goto L_0x0048
            java.lang.Object r1 = r3.f33986e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r4 = r3.f33985d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r3.f33984c
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r3.f33983b
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r6 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r6
            java.lang.Object r3 = r3.f33982a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r3
            kotlin.k.b(r2)
            goto L_0x0122
        L_0x0048:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0050:
            long r8 = r3.f33987f
            java.lang.Object r1 = r3.f33984c
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.f33983b
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r5 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b) r5
            java.lang.Object r10 = r3.f33982a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r10 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r10
            kotlin.k.b(r2)
            r17 = r2
            r2 = r1
            r1 = r5
            r5 = r17
            goto L_0x00cd
        L_0x0068:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r12 = com.sumsub.sns.internal.log.c.a(r18)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "buildVerifyCodeState "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r13 = r2.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            com.sumsub.log.logger.a.d(r11, r12, r13, r14, r15, r16)
            if (r1 != 0) goto L_0x008e
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$a r1 = com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.e.a.f33937d
            return r1
        L_0x008e:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            long r9 = r19.k()
            long r9 = r2.toMinutes(r9)
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r2 = new java.lang.Object[r8]
            long r11 = r19.k()
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MINUTES
            long r13 = r5.toSeconds(r9)
            long r11 = r11 - r13
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.a.d(r11)
            r11 = 0
            r2[r11] = r5
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r8)
            java.lang.String r5 = "%02d"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r3.f33982a = r0
            r3.f33983b = r1
            r3.f33984c = r2
            r3.f33987f = r9
            r3.f33990i = r8
            java.lang.String r5 = "sns_confirmation_code_resendCountdown"
            java.lang.Object r5 = r0.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r5 != r4) goto L_0x00cb
            return r4
        L_0x00cb:
            r8 = r9
            r10 = r0
        L_0x00cd:
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r8)
            r8 = 58
            r5.append(r8)
            r5.append(r2)
            java.lang.String r13 = r5.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "{time}"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r11, r12, r13, r14, r15, r16)
            java.lang.CharSequence r5 = r1.m()
            java.lang.CharSequence r8 = r1.l()
            java.lang.Long r9 = r1.h()
            if (r9 == 0) goto L_0x0101
            r9.longValue()
            goto L_0x0102
        L_0x0101:
            r2 = r6
        L_0x0102:
            java.lang.Long r9 = r1.h()
            if (r9 != 0) goto L_0x012a
            r3.f33982a = r10
            r3.f33983b = r1
            r3.f33984c = r5
            r3.f33985d = r8
            r3.f33986e = r2
            r3.f33990i = r7
            java.lang.String r6 = "sns_confirmation_code_action_resend"
            java.lang.Object r3 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x011d
            return r4
        L_0x011d:
            r6 = r1
            r1 = r2
            r2 = r3
            r4 = r8
            r3 = r10
        L_0x0122:
            java.lang.String r2 = (java.lang.String) r2
            r10 = r3
            r3 = r5
            r5 = r1
            r1 = r6
            r6 = r2
            goto L_0x012d
        L_0x012a:
            r3 = r5
            r4 = r8
            r5 = r2
        L_0x012d:
            java.lang.Integer r7 = r1.n()
            java.lang.CharSequence r8 = r10.s()
            java.lang.String r9 = r1.j()
            java.lang.String r10 = r1.i()
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$c r1 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$e$c
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.a(com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r24, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.b> r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.g
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$g r3 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.g) r3
            int r4 = r3.f33968e
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f33968e = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$g r3 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$g
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f33966c
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f33968e
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            java.lang.String r10 = ""
            if (r5 == 0) goto L_0x0070
            if (r5 == r9) goto L_0x0064
            if (r5 == r8) goto L_0x0058
            if (r5 == r7) goto L_0x004b
            if (r5 != r6) goto L_0x0043
            java.lang.Object r1 = r3.f33965b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r3.f33964a
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r3
            kotlin.k.b(r2)
            goto L_0x00ff
        L_0x0043:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004b:
            java.lang.Object r1 = r3.f33965b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r3.f33964a
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r3
            kotlin.k.b(r2)
            goto L_0x00d2
        L_0x0058:
            java.lang.Object r1 = r3.f33965b
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r1 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r1
            java.lang.Object r5 = r3.f33964a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r5 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r5
            kotlin.k.b(r2)
            goto L_0x00ab
        L_0x0064:
            java.lang.Object r1 = r3.f33965b
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r1 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r1
            java.lang.Object r5 = r3.f33964a
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r5 = (com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel) r5
            kotlin.k.b(r2)
            goto L_0x0093
        L_0x0070:
            kotlin.k.b(r2)
            java.lang.String r2 = r24.p()
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r5 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.EMAIL
            java.lang.String r5 = r5.getType()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r5)
            if (r2 == 0) goto L_0x009b
            r3.f33964a = r0
            r3.f33965b = r1
            r3.f33968e = r9
            java.lang.String r2 = "sns_confirmation_code_email_title"
            java.lang.Object r2 = r0.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x0092
            return r4
        L_0x0092:
            r5 = r0
        L_0x0093:
            java.lang.String r2 = (java.lang.String) r2
        L_0x0095:
            r22 = r2
            r2 = r1
            r1 = r22
            goto L_0x00ae
        L_0x009b:
            r3.f33964a = r0
            r3.f33965b = r1
            r3.f33968e = r8
            java.lang.String r2 = "sns_confirmation_code_phone_title"
            java.lang.Object r2 = r0.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x00aa
            return r4
        L_0x00aa:
            r5 = r0
        L_0x00ab:
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0095
        L_0x00ae:
            java.lang.String r8 = r2.p()
            com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r9 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.EMAIL
            java.lang.String r9 = r9.getType()
            boolean r8 = kotlin.jvm.internal.x.b(r8, r9)
            if (r8 == 0) goto L_0x00eb
            r3.f33964a = r2
            r3.f33965b = r1
            r3.f33968e = r7
            java.lang.String r6 = "sns_confirmation_code_email_subtitle"
            java.lang.Object r3 = r5.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x00cd
            return r4
        L_0x00cd:
            r22 = r3
            r3 = r2
            r2 = r22
        L_0x00d2:
            java.lang.String r4 = java.lang.String.valueOf(r2)
            java.lang.String r2 = r3.n()
            if (r2 != 0) goto L_0x00de
            r6 = r10
            goto L_0x00df
        L_0x00de:
            r6 = r2
        L_0x00df:
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "{email}"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r4, r5, r6, r7, r8, r9)
        L_0x00e8:
            r12 = r1
            r13 = r2
            goto L_0x0116
        L_0x00eb:
            r3.f33964a = r2
            r3.f33965b = r1
            r3.f33968e = r6
            java.lang.String r6 = "sns_confirmation_code_phone_subtitle"
            java.lang.Object r3 = r5.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x00fa
            return r4
        L_0x00fa:
            r22 = r3
            r3 = r2
            r2 = r22
        L_0x00ff:
            java.lang.String r4 = java.lang.String.valueOf(r2)
            java.lang.String r2 = r3.n()
            if (r2 != 0) goto L_0x010b
            r6 = r10
            goto L_0x010c
        L_0x010b:
            r6 = r2
        L_0x010c:
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "{phone}"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r4, r5, r6, r7, r8, r9)
            goto L_0x00e8
        L_0x0116:
            long r1 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            java.lang.Long r5 = r3.x()
            if (r5 == 0) goto L_0x0127
            long r5 = r5.longValue()
            goto L_0x0129
        L_0x0127:
            r5 = 60
        L_0x0129:
            long r4 = r4.toMillis(r5)
            long r1 = r1 + r4
            java.lang.Integer r4 = r3.z()
            if (r4 == 0) goto L_0x0139
            int r4 = r4.intValue()
            goto L_0x013a
        L_0x0139:
            r4 = 6
        L_0x013a:
            java.lang.String r5 = r3.n()
            if (r5 != 0) goto L_0x0142
            r15 = r10
            goto L_0x0143
        L_0x0142:
            r15 = r5
        L_0x0143:
            java.lang.String r3 = r3.l()
            if (r3 != 0) goto L_0x014c
            r16 = r10
            goto L_0x014e
        L_0x014c:
            r16 = r3
        L_0x014e:
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b r3 = new com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel$b
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.a.c(r4)
            java.lang.Long r17 = kotlin.coroutines.jvm.internal.a.d(r1)
            r18 = 0
            r20 = 64
            r21 = 0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r21)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel.a(com.sumsub.sns.internal.core.data.source.applicant.remote.b0, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(String str, String str2) {
        String t11 = t();
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k(this, t11, (kotlin.coroutines.c) null, this, str, str2), 3, (Object) null);
    }
}

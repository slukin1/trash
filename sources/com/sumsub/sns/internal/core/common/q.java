package com.sumsub.sns.internal.core.common;

import com.facebook.internal.AnalyticsEvents;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f32248a;

    public static final class a extends q {

        /* renamed from: b  reason: collision with root package name */
        public static final a f32249b = new a();

        public a() {
            super(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, (r) null);
        }
    }

    public static final class b extends q {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32250b;

        public b() {
            this(false, 1, (r) null);
        }

        public final boolean a() {
            return this.f32250b;
        }

        public final boolean b() {
            return this.f32250b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f32250b == ((b) obj).f32250b;
        }

        public int hashCode() {
            boolean z11 = this.f32250b;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "Completed(goToNextDocument=" + this.f32250b + ')';
        }

        public b(boolean z11) {
            super(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, (r) null);
            this.f32250b = z11;
        }

        public final b a(boolean z11) {
            return new b(z11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(boolean z11, int i11, r rVar) {
            this((i11 & 1) != 0 ? true : z11);
        }

        public static /* synthetic */ b a(b bVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = bVar.f32250b;
            }
            return bVar.a(z11);
        }
    }

    public static final class c extends q {

        /* renamed from: b  reason: collision with root package name */
        public static final c f32251b = new c();

        public c() {
            super("GoBack", (r) null);
        }
    }

    public static final class d extends q {

        /* renamed from: b  reason: collision with root package name */
        public final SNSCompletionResult f32252b;

        public d() {
            this((SNSCompletionResult) null, 1, (r) null);
        }

        public final SNSCompletionResult a() {
            return this.f32252b;
        }

        public final SNSCompletionResult b() {
            return this.f32252b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && x.b(this.f32252b, ((d) obj).f32252b);
        }

        public int hashCode() {
            SNSCompletionResult sNSCompletionResult = this.f32252b;
            if (sNSCompletionResult == null) {
                return 0;
            }
            return sNSCompletionResult.hashCode();
        }

        public String toString() {
            return "Terminated(result=" + this.f32252b + ')';
        }

        public d(SNSCompletionResult sNSCompletionResult) {
            super("Terminated", (r) null);
            this.f32252b = sNSCompletionResult;
        }

        public final d a(SNSCompletionResult sNSCompletionResult) {
            return new d(sNSCompletionResult);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(SNSCompletionResult sNSCompletionResult, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : sNSCompletionResult);
        }

        public static /* synthetic */ d a(d dVar, SNSCompletionResult sNSCompletionResult, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sNSCompletionResult = dVar.f32252b;
            }
            return dVar.a(sNSCompletionResult);
        }
    }

    public /* synthetic */ q(String str, r rVar) {
        this(str);
    }

    public String toString() {
        return "FinishReason: " + this.f32248a;
    }

    public q(String str) {
        this.f32248a = str;
    }
}

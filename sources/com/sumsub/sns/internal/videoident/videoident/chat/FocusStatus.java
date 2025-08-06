package com.sumsub.sns.internal.videoident.videoident.chat;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/internal/videoident/videoident/chat/FocusStatus;", "", "<init>", "()V", "a", "b", "c", "Lcom/sumsub/sns/internal/videoident/videoident/chat/FocusStatus$a;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/FocusStatus$b;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/FocusStatus$c;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@Keep
public abstract class FocusStatus {

    public static final class a extends FocusStatus {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f36981a;

        public a(boolean z11) {
            super((r) null);
            this.f36981a = z11;
        }

        public final boolean a() {
            return this.f36981a;
        }

        public final boolean b() {
            return this.f36981a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f36981a == ((a) obj).f36981a;
        }

        public int hashCode() {
            boolean z11 = this.f36981a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "Gained(transient=" + this.f36981a + ')';
        }

        public final a a(boolean z11) {
            return new a(z11);
        }

        public static /* synthetic */ a a(a aVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = aVar.f36981a;
            }
            return aVar.a(z11);
        }
    }

    public static final class b extends FocusStatus {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f36982a;

        public b(boolean z11) {
            super((r) null);
            this.f36982a = z11;
        }

        public final boolean a() {
            return this.f36982a;
        }

        public final boolean b() {
            return this.f36982a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f36982a == ((b) obj).f36982a;
        }

        public int hashCode() {
            boolean z11 = this.f36982a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "Lost(transient=" + this.f36982a + ')';
        }

        public final b a(boolean z11) {
            return new b(z11);
        }

        public static /* synthetic */ b a(b bVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = bVar.f36982a;
            }
            return bVar.a(z11);
        }
    }

    public static final class c extends FocusStatus {

        /* renamed from: a  reason: collision with root package name */
        public static final c f36983a = new c();

        public c() {
            super((r) null);
        }
    }

    public /* synthetic */ FocusStatus(r rVar) {
        this();
    }

    private FocusStatus() {
    }
}

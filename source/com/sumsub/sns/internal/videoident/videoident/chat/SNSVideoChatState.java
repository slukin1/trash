package com.sumsub.sns.internal.videoident.videoident.chat;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\r\u000e\u000f\u0010\u0011\u0012B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0006\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState;", "", "", "toString", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "isConnected", "()Z", "<init>", "(Ljava/lang/String;)V", "a", "b", "c", "d", "e", "f", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$a;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$b;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$c;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$d;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$e;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState$f;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@Keep
public abstract class SNSVideoChatState {
    private final String name;

    public static final class a extends SNSVideoChatState {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f37033a;

        public a() {
            this(false, 1, (r) null);
        }

        public final boolean a() {
            return this.f37033a;
        }

        public final boolean b() {
            return this.f37033a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f37033a == ((a) obj).f37033a;
        }

        public int hashCode() {
            boolean z11 = this.f37033a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "SNSConnected(isReconnected=" + this.f37033a + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(boolean z11, int i11, r rVar) {
            this((i11 & 1) != 0 ? false : z11);
        }

        public final a a(boolean z11) {
            return new a(z11);
        }

        public a(boolean z11) {
            super("Connected", (r) null);
            this.f37033a = z11;
        }

        public static /* synthetic */ a a(a aVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = aVar.f37033a;
            }
            return aVar.a(z11);
        }
    }

    public static final class b extends SNSVideoChatState {

        /* renamed from: a  reason: collision with root package name */
        public static final b f37034a = new b();

        public b() {
            super("Connecting", (r) null);
        }
    }

    public static final class c extends SNSVideoChatState {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f37035a;

        public c() {
            this((Throwable) null, 1, (r) null);
        }

        public final Throwable a() {
            return this.f37035a;
        }

        public final Throwable b() {
            return this.f37035a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f37035a, ((c) obj).f37035a);
        }

        public int hashCode() {
            Throwable th2 = this.f37035a;
            if (th2 == null) {
                return 0;
            }
            return th2.hashCode();
        }

        public String toString() {
            return "SNSDisconnected(error=" + this.f37035a + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(Throwable th2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2);
        }

        public final c a(Throwable th2) {
            return new c(th2);
        }

        public c(Throwable th2) {
            super("Disconnected", (r) null);
            this.f37035a = th2;
        }

        public static /* synthetic */ c a(c cVar, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = cVar.f37035a;
            }
            return cVar.a(th2);
        }
    }

    public static final class d extends SNSVideoChatState {

        /* renamed from: e  reason: collision with root package name */
        public static final a f37036e = new a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f37037a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37038b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f37039c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f37040d;

        public static final class a {
            public /* synthetic */ a(r rVar) {
                this();
            }

            public final d a() {
                return new d(true, true, true, false);
            }

            public a() {
            }
        }

        public d() {
            this(false, false, false, false, 15, (r) null);
        }

        public final boolean a() {
            return this.f37037a;
        }

        public final boolean b() {
            return this.f37038b;
        }

        public final boolean c() {
            return this.f37039c;
        }

        public final boolean d() {
            return this.f37040d;
        }

        public final boolean e() {
            return this.f37037a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f37037a == dVar.f37037a && this.f37038b == dVar.f37038b && this.f37039c == dVar.f37039c && this.f37040d == dVar.f37040d;
        }

        public final boolean f() {
            return this.f37039c;
        }

        public final boolean g() {
            return this.f37038b;
        }

        public final boolean h() {
            return this.f37040d;
        }

        public int hashCode() {
            boolean z11 = this.f37037a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            boolean z13 = this.f37038b;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f37039c;
            if (z14) {
                z14 = true;
            }
            int i13 = (i12 + (z14 ? 1 : 0)) * 31;
            boolean z15 = this.f37040d;
            if (!z15) {
                z12 = z15;
            }
            return i13 + (z12 ? 1 : 0);
        }

        public String toString() {
            return "SNSParticipantConnected(hasAudioTrack=" + this.f37037a + ", hasVideoTrack=" + this.f37038b + ", hasDataTrack=" + this.f37039c + ", isReconnected=" + this.f37040d + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(boolean z11, boolean z12, boolean z13, boolean z14, int i11, r rVar) {
            this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? true : z13, (i11 & 8) != 0 ? false : z14);
        }

        public final d a(boolean z11, boolean z12, boolean z13, boolean z14) {
            return new d(z11, z12, z13, z14);
        }

        public d(boolean z11, boolean z12, boolean z13, boolean z14) {
            super("ParticipantConnected", (r) null);
            this.f37037a = z11;
            this.f37038b = z12;
            this.f37039c = z13;
            this.f37040d = z14;
        }

        public static /* synthetic */ d a(d dVar, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = dVar.f37037a;
            }
            if ((i11 & 2) != 0) {
                z12 = dVar.f37038b;
            }
            if ((i11 & 4) != 0) {
                z13 = dVar.f37039c;
            }
            if ((i11 & 8) != 0) {
                z14 = dVar.f37040d;
            }
            return dVar.a(z11, z12, z13, z14);
        }
    }

    public static final class e extends SNSVideoChatState {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37041a = new e();

        public e() {
            super("ParticipantDisconnected", (r) null);
        }
    }

    public static final class f extends SNSVideoChatState {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f37042a;

        public f(Throwable th2) {
            super("Reconnecting", (r) null);
            this.f37042a = th2;
        }

        public final Throwable a() {
            return this.f37042a;
        }
    }

    public /* synthetic */ SNSVideoChatState(String str, r rVar) {
        this(str);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isConnected() {
        return !(this instanceof c) && !(this instanceof b);
    }

    public String toString() {
        return "SNSVideoChatState->" + this.name;
    }

    private SNSVideoChatState(String str) {
        this.name = str;
    }
}

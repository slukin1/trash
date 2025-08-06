package com.sumsub.sentry;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.v1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b@\u0018\u0000 \u00102\u00020\u0001:\u0002\n\u000fB\u0014\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\n\u0010\r\u0001\u000e\u0001\u00020\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sentry/d0;", "", "", "d", "(Ljava/lang/String;)Ljava/lang/String;", "", "c", "(Ljava/lang/String;)I", "other", "", "a", "(Ljava/lang/String;Ljava/lang/Object;)Z", "Ljava/lang/String;", "()Ljava/lang/String;", "uuid", "b", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class d0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30316a;

    public static final class a implements kotlinx.serialization.internal.d0<d0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30317a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30318b;

        static {
            a aVar = new a();
            f30317a = aVar;
            i0 i0Var = new i0("com.sumsub.sentry.SentryId", aVar);
            i0Var.k(ZendeskIdentityStorage.UUID_KEY, true);
            f30318b = i0Var;
        }

        public String a(c cVar) {
            return d0.b(cVar.x(getDescriptor()).q());
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
            return d0.a(a(cVar));
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30318b;
        }

        public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
            a(dVar, ((d0) obj).b());
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        public void a(d dVar, String str) {
            d h11 = dVar.h(getDescriptor());
            if (h11 != null) {
                h11.v(str);
            }
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final String a(UUID uuid) {
            return StringsKt__StringsJVMKt.G(uuid.toString(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null);
        }

        public final kotlinx.serialization.b<d0> serializer() {
            return a.f30317a;
        }

        public b() {
        }
    }

    public /* synthetic */ d0(String str) {
        this.f30316a = str;
    }

    public static final /* synthetic */ d0 a(String str) {
        return new d0(str);
    }

    public static String b(String str) {
        return str;
    }

    public static int c(String str) {
        return str.hashCode();
    }

    public static String d(String str) {
        return str;
    }

    public final /* synthetic */ String b() {
        return this.f30316a;
    }

    public boolean equals(Object obj) {
        return a(this.f30316a, obj);
    }

    public int hashCode() {
        return c(this.f30316a);
    }

    public String toString() {
        return d(this.f30316a);
    }

    public static boolean a(String str, Object obj) {
        return (obj instanceof d0) && x.b(str, ((d0) obj).b());
    }

    public static final boolean a(String str, String str2) {
        return x.b(str, str2);
    }

    public static /* synthetic */ String a(String str, int i11, r rVar) {
        if ((i11 & 1) != 0) {
            str = Companion.a(UUID.randomUUID());
        }
        return b(str);
    }

    public final String a() {
        return this.f30316a;
    }
}

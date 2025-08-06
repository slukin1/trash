package com.sumsub.sns.internal.core.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.v1;

@f
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "Front", "Back", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum IdentitySide {
    Front("FRONT_SIDE"),
    Back("BACK_SIDE");
    
    public static final b Companion = null;
    private final String value;

    public static final class a implements d0<IdentitySide> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32363a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32364b = null;

        static {
            f32363a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.IdentitySide", 2);
            enumDescriptor.k("FRONT_SIDE", false);
            enumDescriptor.k("BACK_SIDE", false);
            f32364b = enumDescriptor;
        }

        /* renamed from: a */
        public IdentitySide deserialize(c cVar) {
            return IdentitySide.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32364b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, IdentitySide identitySide) {
            dVar.g(getDescriptor(), identitySide.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final IdentitySide a(String str) {
            for (IdentitySide identitySide : IdentitySide.values()) {
                if (x.b(identitySide.getValue(), str)) {
                    return identitySide;
                }
            }
            return null;
        }

        public final kotlinx.serialization.b<IdentitySide> serializer() {
            return a.f32363a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private IdentitySide(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

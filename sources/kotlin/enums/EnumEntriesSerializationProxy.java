package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.r;

public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final a Companion = new a((r) null);
    @Deprecated
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Class<E> f56689c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public EnumEntriesSerializationProxy(E[] eArr) {
        this.f56689c = eArr.getClass().getComponentType();
    }

    private final Object readResolve() {
        return EnumEntriesKt.a((Enum[]) this.f56689c.getEnumConstants());
    }
}

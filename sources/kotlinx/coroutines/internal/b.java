package kotlinx.coroutines.internal;

import d10.l;

public final class b extends CtorCache {

    /* renamed from: a  reason: collision with root package name */
    public static final b f57296a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a f57297b = new a();

    public static final class a extends ClassValue<l<? super Throwable, ? extends Throwable>> {
        /* renamed from: a */
        public l<Throwable, Throwable> computeValue(Class<?> cls) {
            return ExceptionsConstructorKt.b(cls);
        }
    }

    public l<Throwable, Throwable> a(Class<? extends Throwable> cls) {
        return (l) f57297b.get(cls);
    }
}

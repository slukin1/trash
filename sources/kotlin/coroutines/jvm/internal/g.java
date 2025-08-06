package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f56679a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final a f56680b = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    public static a f56681c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f56682a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f56683b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f56684c;

        public a(Method method, Method method2, Method method3) {
            this.f56682a = method;
            this.f56683b = method2;
            this.f56684c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f56681c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f56680b;
            f56681c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        a aVar = f56681c;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar == f56680b) {
            return null;
        }
        Method method = aVar.f56682a;
        Object invoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f56683b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f56684c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}

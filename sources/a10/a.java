package a10;

import kotlin.internal.PlatformImplementations;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final PlatformImplementations f53446a;

    static {
        PlatformImplementations platformImplementations;
        JDK8PlatformImplementations newInstance;
        Class<PlatformImplementations> cls = PlatformImplementations.class;
        try {
            newInstance = JDK8PlatformImplementations.class.newInstance();
            if (newInstance != null) {
                platformImplementations = newInstance;
                f53446a = platformImplementations;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        } catch (ClassCastException e11) {
            ClassLoader classLoader = newInstance.getClass().getClassLoader();
            ClassLoader classLoader2 = cls.getClassLoader();
            if (!x.b(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e11);
            }
            throw e11;
        } catch (ClassNotFoundException unused) {
            try {
                Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                if (newInstance2 != null) {
                    try {
                        platformImplementations = (PlatformImplementations) newInstance2;
                    } catch (ClassCastException e12) {
                        ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader4 = cls.getClassLoader();
                        if (!x.b(classLoader3, classLoader4)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e12);
                        }
                        throw e12;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused2) {
                try {
                    JDK7PlatformImplementations newInstance3 = JDK7PlatformImplementations.class.newInstance();
                    if (newInstance3 != null) {
                        try {
                            platformImplementations = newInstance3;
                        } catch (ClassCastException e13) {
                            ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader6 = cls.getClassLoader();
                            if (!x.b(classLoader5, classLoader6)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e13);
                            }
                            throw e13;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused3) {
                    try {
                        Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        if (newInstance4 != null) {
                            try {
                                platformImplementations = (PlatformImplementations) newInstance4;
                            } catch (ClassCastException e14) {
                                ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                                ClassLoader classLoader8 = cls.getClassLoader();
                                if (!x.b(classLoader7, classLoader8)) {
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e14);
                                }
                                throw e14;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                    } catch (ClassNotFoundException unused4) {
                        platformImplementations = new PlatformImplementations();
                    }
                }
            }
        }
    }
}

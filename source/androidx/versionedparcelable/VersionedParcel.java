package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import w1.b;

public abstract class VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap<String, Method> f12009a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<String, Method> f12010b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayMap<String, Class> f12011c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f12009a = arrayMap;
        this.f12010b = arrayMap2;
        this.f12011c = arrayMap3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i11) {
        w(i11);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i11) {
        w(i11);
        C(charSequence);
    }

    public abstract void E(int i11);

    public void F(int i11, int i12) {
        w(i12);
        E(i11);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i11) {
        w(i11);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i11) {
        w(i11);
        I(str);
    }

    public <T extends b> void K(T t11, VersionedParcel versionedParcel) {
        try {
            e(t11.getClass()).invoke((Object) null, new Object[]{t11, versionedParcel});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (ClassNotFoundException e14) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e14);
        }
    }

    public void L(b bVar) {
        if (bVar == null) {
            I((String) null);
            return;
        }
        N(bVar);
        VersionedParcel b11 = b();
        K(bVar, b11);
        b11.a();
    }

    public void M(b bVar, int i11) {
        w(i11);
        L(bVar);
    }

    public final void N(b bVar) {
        try {
            I(c(bVar.getClass()).getName());
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e11);
        }
    }

    public abstract void a();

    public abstract VersionedParcel b();

    public final Class c(Class<? extends b> cls) throws ClassNotFoundException {
        Class cls2 = this.f12011c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f12011c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method method = this.f12009a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f12009a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f12010b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c11 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c11.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f12010b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z11, int i11) {
        if (!m(i11)) {
            return z11;
        }
        return g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i11) {
        if (!m(i11)) {
            return bArr;
        }
        return i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i11) {
        if (!m(i11)) {
            return charSequence;
        }
        return k();
    }

    public abstract boolean m(int i11);

    public <T extends b> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (b) d(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (ClassNotFoundException e14) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e14);
        }
    }

    public abstract int o();

    public int p(int i11, int i12) {
        if (!m(i12)) {
            return i11;
        }
        return o();
    }

    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t11, int i11) {
        if (!m(i11)) {
            return t11;
        }
        return q();
    }

    public abstract String s();

    public String t(String str, int i11) {
        if (!m(i11)) {
            return str;
        }
        return s();
    }

    public <T extends b> T u() {
        String s11 = s();
        if (s11 == null) {
            return null;
        }
        return n(s11, b());
    }

    public <T extends b> T v(T t11, int i11) {
        if (!m(i11)) {
            return t11;
        }
        return u();
    }

    public abstract void w(int i11);

    public void x(boolean z11, boolean z12) {
    }

    public abstract void y(boolean z11);

    public void z(boolean z11, int i11) {
        w(i11);
        y(z11);
    }
}

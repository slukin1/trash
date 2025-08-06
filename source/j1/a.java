package j1;

import android.util.FloatProperty;

public abstract class a<T> {
    public final String mPropertyName;

    /* renamed from: j1.a$a  reason: collision with other inner class name */
    public static class C0087a extends a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FloatProperty f16007a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0087a(String str, FloatProperty floatProperty) {
            super(str);
            this.f16007a = floatProperty;
        }

        public float getValue(T t11) {
            return ((Float) this.f16007a.get(t11)).floatValue();
        }

        public void setValue(T t11, float f11) {
            this.f16007a.setValue(t11, f11);
        }
    }

    public a(String str) {
        this.mPropertyName = str;
    }

    public static <T> a<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new C0087a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t11);

    public abstract void setValue(T t11, float f11);
}

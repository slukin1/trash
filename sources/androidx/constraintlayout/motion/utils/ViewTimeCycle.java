package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    public static class PathRotate extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            return this.f6941h;
        }

        public boolean j(View view, KeyCache keyCache, float f11, long j11, double d11, double d12) {
            view.setRotation(f(f11, j11, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
            return this.f6941h;
        }
    }

    public static class a extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setAlpha(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class b extends ViewTimeCycle {

        /* renamed from: l  reason: collision with root package name */
        public String f7384l;

        /* renamed from: m  reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f7385m;

        /* renamed from: n  reason: collision with root package name */
        public SparseArray<float[]> f7386n = new SparseArray<>();

        /* renamed from: o  reason: collision with root package name */
        public float[] f7387o;

        /* renamed from: p  reason: collision with root package name */
        public float[] f7388p;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f7384l = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.f7385m = sparseArray;
        }

        public void b(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void e(int i11) {
            int size = this.f7385m.size();
            int h11 = this.f7385m.valueAt(0).h();
            double[] dArr = new double[size];
            int i12 = h11 + 2;
            this.f7387o = new float[i12];
            this.f7388p = new float[h11];
            int[] iArr = new int[2];
            iArr[1] = i12;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = this.f7385m.keyAt(i13);
                float[] valueAt = this.f7386n.valueAt(i13);
                dArr[i13] = ((double) keyAt) * 0.01d;
                this.f7385m.valueAt(i13).f(this.f7387o);
                int i14 = 0;
                while (true) {
                    float[] fArr = this.f7387o;
                    if (i14 >= fArr.length) {
                        break;
                    }
                    dArr2[i13][i14] = (double) fArr[i14];
                    i14++;
                }
                dArr2[i13][h11] = (double) valueAt[0];
                dArr2[i13][h11 + 1] = (double) valueAt[1];
            }
            this.f6934a = CurveFit.a(i11, dArr, dArr2);
        }

        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            View view2 = view;
            long j12 = j11;
            this.f6934a.e((double) f11, this.f7387o);
            float[] fArr = this.f7387o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j13 = j12 - this.f6942i;
            if (Float.isNaN(this.f6943j)) {
                float a11 = keyCache.a(view2, this.f7384l, 0);
                this.f6943j = a11;
                if (Float.isNaN(a11)) {
                    this.f6943j = 0.0f;
                }
            }
            float f14 = (float) ((((double) this.f6943j) + ((((double) j13) * 1.0E-9d) * ((double) f12))) % 1.0d);
            this.f6943j = f14;
            this.f6942i = j12;
            float a12 = a(f14);
            this.f6941h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f7388p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z11 = this.f6941h;
                float[] fArr3 = this.f7387o;
                this.f6941h = z11 | (((double) fArr3[i11]) != 0.0d);
                fArr2[i11] = (fArr3[i11] * a12) + f13;
                i11++;
            }
            this.f7385m.valueAt(0).k(view2, this.f7388p);
            if (f12 != 0.0f) {
                this.f6941h = true;
            }
            return this.f6941h;
        }

        public void j(int i11, ConstraintAttribute constraintAttribute, float f11, int i12, float f12) {
            this.f7385m.append(i11, constraintAttribute);
            this.f7386n.append(i11, new float[]{f11, f12});
            this.f6935b = Math.max(this.f6935b, i12);
        }
    }

    public static class c extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(f(f11, j11, view, keyCache));
            }
            return this.f6941h;
        }
    }

    public static class d extends ViewTimeCycle {

        /* renamed from: l  reason: collision with root package name */
        public boolean f7389l = false;

        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(f(f11, j11, view, keyCache));
            } else if (this.f7389l) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f7389l = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, new Object[]{Float.valueOf(f(f11, j11, view, keyCache))});
                    } catch (IllegalAccessException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e12);
                    }
                }
            }
            return this.f6941h;
        }
    }

    public static class e extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotation(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class f extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotationX(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class g extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotationY(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class h extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setScaleX(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class i extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setScaleY(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class j extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setTranslationX(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class k extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            view.setTranslationY(f(f11, j11, view, keyCache));
            return this.f6941h;
        }
    }

    public static class l extends ViewTimeCycle {
        public boolean i(View view, float f11, long j11, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(f(f11, j11, view, keyCache));
            }
            return this.f6941h;
        }
    }

    public static ViewTimeCycle g(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    public static ViewTimeCycle h(String str, long j11) {
        ViewTimeCycle viewTimeCycle;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c11 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                viewTimeCycle = new f();
                break;
            case 1:
                viewTimeCycle = new g();
                break;
            case 2:
                viewTimeCycle = new j();
                break;
            case 3:
                viewTimeCycle = new k();
                break;
            case 4:
                viewTimeCycle = new l();
                break;
            case 5:
                viewTimeCycle = new d();
                break;
            case 6:
                viewTimeCycle = new h();
                break;
            case 7:
                viewTimeCycle = new i();
                break;
            case 8:
                viewTimeCycle = new e();
                break;
            case 9:
                viewTimeCycle = new c();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new a();
                break;
            default:
                return null;
        }
        viewTimeCycle.c(j11);
        return viewTimeCycle;
    }

    public float f(float f11, long j11, View view, KeyCache keyCache) {
        long j12 = j11;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.f6934a.e((double) f11, this.f6940g);
        float[] fArr = this.f6940g;
        float f12 = fArr[1];
        int i11 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i11 == 0) {
            this.f6941h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f6943j)) {
            float a11 = keyCache2.a(view2, this.f6939f, 0);
            this.f6943j = a11;
            if (Float.isNaN(a11)) {
                this.f6943j = 0.0f;
            }
        }
        float f13 = (float) ((((double) this.f6943j) + ((((double) (j12 - this.f6942i)) * 1.0E-9d) * ((double) f12))) % 1.0d);
        this.f6943j = f13;
        keyCache2.b(view2, this.f6939f, 0, f13);
        this.f6942i = j12;
        float f14 = this.f6940g[0];
        float a12 = (a(this.f6943j) * f14) + this.f6940g[2];
        this.f6941h = (f14 == 0.0f && i11 == 0) ? false : true;
        return a12;
    }

    public abstract boolean i(View view, float f11, long j11, KeyCache keyCache);
}

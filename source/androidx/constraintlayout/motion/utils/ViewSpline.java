package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewSpline extends SplineSet {

    public static class PathRotate extends ViewSpline {
        public void h(View view, float f11) {
        }

        public void i(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    public static class a extends ViewSpline {
        public void h(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    public static class b extends ViewSpline {

        /* renamed from: f  reason: collision with root package name */
        public String f7375f;

        /* renamed from: g  reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f7376g;

        /* renamed from: h  reason: collision with root package name */
        public float[] f7377h;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f7375f = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.f7376g = sparseArray;
        }

        public void c(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void e(int i11) {
            int size = this.f7376g.size();
            int h11 = this.f7376g.valueAt(0).h();
            double[] dArr = new double[size];
            this.f7377h = new float[h11];
            int[] iArr = new int[2];
            iArr[1] = h11;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i12 = 0; i12 < size; i12++) {
                dArr[i12] = ((double) this.f7376g.keyAt(i12)) * 0.01d;
                this.f7376g.valueAt(i12).f(this.f7377h);
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f7377h;
                    if (i13 >= fArr.length) {
                        break;
                    }
                    dArr2[i12][i13] = (double) fArr[i13];
                    i13++;
                }
            }
            this.f6902a = CurveFit.a(i11, dArr, dArr2);
        }

        public void h(View view, float f11) {
            this.f6902a.e((double) f11, this.f7377h);
            this.f7376g.valueAt(0).k(view, this.f7377h);
        }

        public void i(int i11, ConstraintAttribute constraintAttribute) {
            this.f7376g.append(i11, constraintAttribute);
        }
    }

    public static class c extends ViewSpline {
        public void h(View view, float f11) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f11));
            }
        }
    }

    public static class d extends ViewSpline {
        public void h(View view, float f11) {
            view.setPivotX(a(f11));
        }
    }

    public static class e extends ViewSpline {
        public void h(View view, float f11) {
            view.setPivotY(a(f11));
        }
    }

    public static class f extends ViewSpline {

        /* renamed from: f  reason: collision with root package name */
        public boolean f7378f = false;

        public void h(View view, float f11) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
            } else if (!this.f7378f) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f7378f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f11))});
                    } catch (IllegalAccessException e11) {
                        Log.e("ViewSpline", "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e("ViewSpline", "unable to setProgress", e12);
                    }
                }
            }
        }
    }

    public static class g extends ViewSpline {
        public void h(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    public static class h extends ViewSpline {
        public void h(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    public static class i extends ViewSpline {
        public void h(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    public static class j extends ViewSpline {
        public void h(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    public static class k extends ViewSpline {
        public void h(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    public static class l extends ViewSpline {
        public void h(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    public static class m extends ViewSpline {
        public void h(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    public static class n extends ViewSpline {
        public void h(View view, float f11) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f11));
            }
        }
    }

    public static ViewSpline f(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    public static ViewSpline g(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c11 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c11 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c11 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = 15;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new h();
            case 1:
                return new i();
            case 2:
                return new l();
            case 3:
                return new m();
            case 4:
                return new n();
            case 5:
                return new f();
            case 6:
                return new j();
            case 7:
                return new k();
            case 8:
                return new a();
            case 9:
                return new d();
            case 10:
                return new e();
            case 11:
                return new g();
            case 12:
                return new c();
            case 13:
                return new PathRotate();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f11);
}

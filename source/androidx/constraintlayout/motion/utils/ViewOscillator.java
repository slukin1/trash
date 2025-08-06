package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewOscillator extends KeyCycleOscillator {

    public static class PathRotateSet extends ViewOscillator {
        public void j(View view, float f11) {
        }

        public void k(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    public static class a extends ViewOscillator {
        public void j(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    public static class b extends ViewOscillator {

        /* renamed from: h  reason: collision with root package name */
        public float[] f7372h = new float[1];

        /* renamed from: i  reason: collision with root package name */
        public ConstraintAttribute f7373i;

        public void c(Object obj) {
            this.f7373i = (ConstraintAttribute) obj;
        }

        public void j(View view, float f11) {
            this.f7372h[0] = a(f11);
            this.f7373i.k(view, this.f7372h);
        }
    }

    public static class c extends ViewOscillator {
        public void j(View view, float f11) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f11));
            }
        }
    }

    public static class d extends ViewOscillator {

        /* renamed from: h  reason: collision with root package name */
        public boolean f7374h = false;

        public void j(View view, float f11) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
            } else if (!this.f7374h) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f7374h = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f11))});
                    } catch (IllegalAccessException e11) {
                        Log.e("ViewOscillator", "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e("ViewOscillator", "unable to setProgress", e12);
                    }
                }
            }
        }
    }

    public static class e extends ViewOscillator {
        public void j(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    public static class f extends ViewOscillator {
        public void j(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    public static class g extends ViewOscillator {
        public void j(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    public static class h extends ViewOscillator {
        public void j(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    public static class i extends ViewOscillator {
        public void j(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    public static class j extends ViewOscillator {
        public void j(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    public static class k extends ViewOscillator {
        public void j(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    public static class l extends ViewOscillator {
        public void j(View view, float f11) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f11));
            }
        }
    }

    public static ViewOscillator i(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = 13;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new f();
            case 1:
                return new g();
            case 2:
                return new j();
            case 3:
                return new k();
            case 4:
                return new l();
            case 5:
                return new d();
            case 6:
                return new h();
            case 7:
                return new i();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new c();
            case 11:
                return new PathRotateSet();
            case 12:
                return new a();
            case 13:
                return new a();
            default:
                return null;
        }
    }

    public abstract void j(View view, float f11);
}

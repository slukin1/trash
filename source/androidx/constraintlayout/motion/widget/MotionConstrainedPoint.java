package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static String[] E = {"position", "x", "y", "width", "height", "pathRotate"};
    public LinkedHashMap<String, ConstraintAttribute> A = new LinkedHashMap<>();
    public int B = 0;
    public double[] C = new double[18];
    public double[] D = new double[18];

    /* renamed from: b  reason: collision with root package name */
    public float f7490b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public int f7491c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f7492d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7493e = false;

    /* renamed from: f  reason: collision with root package name */
    public float f7494f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f7495g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f7496h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f7497i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f7498j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f7499k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f7500l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7501m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f7502n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f7503o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public float f7504p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    public Easing f7505q;

    /* renamed from: r  reason: collision with root package name */
    public int f7506r = 0;

    /* renamed from: s  reason: collision with root package name */
    public float f7507s;

    /* renamed from: t  reason: collision with root package name */
    public float f7508t;

    /* renamed from: u  reason: collision with root package name */
    public float f7509u;

    /* renamed from: v  reason: collision with root package name */
    public float f7510v;

    /* renamed from: w  reason: collision with root package name */
    public float f7511w;

    /* renamed from: x  reason: collision with root package name */
    public float f7512x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    public float f7513y = Float.NaN;

    /* renamed from: z  reason: collision with root package name */
    public int f7514z = -1;

    public void a(HashMap<String, ViewSpline> hashMap, int i11) {
        for (String next : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(next);
            next.hashCode();
            char c11 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (next.equals("transformPivotX")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -760884509:
                    if (next.equals("transformPivotY")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c11 = 13;
                        break;
                    }
                    break;
            }
            float f11 = 1.0f;
            float f12 = 0.0f;
            switch (c11) {
                case 0:
                    if (!Float.isNaN(this.f7496h)) {
                        f12 = this.f7496h;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 1:
                    if (!Float.isNaN(this.f7497i)) {
                        f12 = this.f7497i;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 2:
                    if (!Float.isNaN(this.f7502n)) {
                        f12 = this.f7502n;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 3:
                    if (!Float.isNaN(this.f7503o)) {
                        f12 = this.f7503o;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 4:
                    if (!Float.isNaN(this.f7504p)) {
                        f12 = this.f7504p;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 5:
                    if (!Float.isNaN(this.f7513y)) {
                        f12 = this.f7513y;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 6:
                    if (!Float.isNaN(this.f7498j)) {
                        f11 = this.f7498j;
                    }
                    viewSpline.c(i11, f11);
                    break;
                case 7:
                    if (!Float.isNaN(this.f7499k)) {
                        f11 = this.f7499k;
                    }
                    viewSpline.c(i11, f11);
                    break;
                case 8:
                    if (!Float.isNaN(this.f7500l)) {
                        f12 = this.f7500l;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 9:
                    if (!Float.isNaN(this.f7501m)) {
                        f12 = this.f7501m;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 10:
                    if (!Float.isNaN(this.f7495g)) {
                        f12 = this.f7495g;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 11:
                    if (!Float.isNaN(this.f7494f)) {
                        f12 = this.f7494f;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 12:
                    if (!Float.isNaN(this.f7512x)) {
                        f12 = this.f7512x;
                    }
                    viewSpline.c(i11, f12);
                    break;
                case 13:
                    if (!Float.isNaN(this.f7490b)) {
                        f11 = this.f7490b;
                    }
                    viewSpline.c(i11, f11);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + next);
                        break;
                    } else {
                        String str = next.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
                        if (!this.A.containsKey(str)) {
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = this.A.get(str);
                            if (!(viewSpline instanceof ViewSpline.b)) {
                                Log.e("MotionPaths", next + " ViewSpline not a CustomSet frame = " + i11 + ", value" + constraintAttribute.e() + viewSpline);
                                break;
                            } else {
                                ((ViewSpline.b) viewSpline).i(i11, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void b(View view) {
        this.f7492d = view.getVisibility();
        this.f7490b = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f7493e = false;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            this.f7494f = view.getElevation();
        }
        this.f7495g = view.getRotation();
        this.f7496h = view.getRotationX();
        this.f7497i = view.getRotationY();
        this.f7498j = view.getScaleX();
        this.f7499k = view.getScaleY();
        this.f7500l = view.getPivotX();
        this.f7501m = view.getPivotY();
        this.f7502n = view.getTranslationX();
        this.f7503o = view.getTranslationY();
        if (i11 >= 21) {
            this.f7504p = view.getTranslationZ();
        }
    }

    public void c(ConstraintSet.Constraint constraint) {
        float f11;
        ConstraintSet.PropertySet propertySet = constraint.f7998c;
        int i11 = propertySet.f8076c;
        this.f7491c = i11;
        int i12 = propertySet.f8075b;
        this.f7492d = i12;
        if (i12 == 0 || i11 != 0) {
            f11 = propertySet.f8077d;
        } else {
            f11 = 0.0f;
        }
        this.f7490b = f11;
        ConstraintSet.Transform transform = constraint.f8001f;
        this.f7493e = transform.f8092m;
        this.f7494f = transform.f8093n;
        this.f7495g = transform.f8081b;
        this.f7496h = transform.f8082c;
        this.f7497i = transform.f8083d;
        this.f7498j = transform.f8084e;
        this.f7499k = transform.f8085f;
        this.f7500l = transform.f8086g;
        this.f7501m = transform.f8087h;
        this.f7502n = transform.f8089j;
        this.f7503o = transform.f8090k;
        this.f7504p = transform.f8091l;
        this.f7505q = Easing.c(constraint.f7999d.f8063d);
        ConstraintSet.Motion motion = constraint.f7999d;
        this.f7512x = motion.f8068i;
        this.f7506r = motion.f8065f;
        this.f7514z = motion.f8061b;
        this.f7513y = constraint.f7998c.f8078e;
        for (String next : constraint.f8002g.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.f8002g.get(next);
            if (constraintAttribute.g()) {
                this.A.put(next, constraintAttribute);
            }
        }
    }

    /* renamed from: e */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f7507s, motionConstrainedPoint.f7507s);
    }

    public final boolean f(float f11, float f12) {
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            if (Float.isNaN(f11) != Float.isNaN(f12)) {
                return true;
            }
            return false;
        } else if (Math.abs(f11 - f12) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void g(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (f(this.f7490b, motionConstrainedPoint.f7490b)) {
            hashSet.add("alpha");
        }
        if (f(this.f7494f, motionConstrainedPoint.f7494f)) {
            hashSet.add("elevation");
        }
        int i11 = this.f7492d;
        int i12 = motionConstrainedPoint.f7492d;
        if (i11 != i12 && this.f7491c == 0 && (i11 == 0 || i12 == 0)) {
            hashSet.add("alpha");
        }
        if (f(this.f7495g, motionConstrainedPoint.f7495g)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7512x) || !Float.isNaN(motionConstrainedPoint.f7512x)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7513y) || !Float.isNaN(motionConstrainedPoint.f7513y)) {
            hashSet.add("progress");
        }
        if (f(this.f7496h, motionConstrainedPoint.f7496h)) {
            hashSet.add("rotationX");
        }
        if (f(this.f7497i, motionConstrainedPoint.f7497i)) {
            hashSet.add("rotationY");
        }
        if (f(this.f7500l, motionConstrainedPoint.f7500l)) {
            hashSet.add("transformPivotX");
        }
        if (f(this.f7501m, motionConstrainedPoint.f7501m)) {
            hashSet.add("transformPivotY");
        }
        if (f(this.f7498j, motionConstrainedPoint.f7498j)) {
            hashSet.add("scaleX");
        }
        if (f(this.f7499k, motionConstrainedPoint.f7499k)) {
            hashSet.add("scaleY");
        }
        if (f(this.f7502n, motionConstrainedPoint.f7502n)) {
            hashSet.add("translationX");
        }
        if (f(this.f7503o, motionConstrainedPoint.f7503o)) {
            hashSet.add("translationY");
        }
        if (f(this.f7504p, motionConstrainedPoint.f7504p)) {
            hashSet.add("translationZ");
        }
    }

    public void h(float f11, float f12, float f13, float f14) {
        this.f7508t = f11;
        this.f7509u = f12;
        this.f7510v = f13;
        this.f7511w = f14;
    }

    public void i(Rect rect, View view, int i11, float f11) {
        h((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        b(view);
        this.f7500l = Float.NaN;
        this.f7501m = Float.NaN;
        if (i11 == 1) {
            this.f7495g = f11 - 90.0f;
        } else if (i11 == 2) {
            this.f7495g = f11 + 90.0f;
        }
    }

    public void j(Rect rect, ConstraintSet constraintSet, int i11, int i12) {
        h((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        c(constraintSet.z(i12));
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                }
            }
            float f11 = this.f7495g + 90.0f;
            this.f7495g = f11;
            if (f11 > 180.0f) {
                this.f7495g = f11 - 360.0f;
                return;
            }
            return;
        }
        this.f7495g -= 90.0f;
    }

    public void k(View view) {
        h(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        b(view);
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;

public class KeyCycle extends Key {

    /* renamed from: g  reason: collision with root package name */
    public String f7414g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f7415h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f7416i = -1;

    /* renamed from: j  reason: collision with root package name */
    public String f7417j = null;

    /* renamed from: k  reason: collision with root package name */
    public float f7418k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7419l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f7420m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f7421n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public int f7422o = -1;

    /* renamed from: p  reason: collision with root package name */
    public float f7423p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7424q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public float f7425r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f7426s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    public float f7427t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public float f7428u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    public float f7429v = Float.NaN;

    /* renamed from: w  reason: collision with root package name */
    public float f7430w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    public float f7431x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    public float f7432y = Float.NaN;

    /* renamed from: z  reason: collision with root package name */
    public float f7433z = Float.NaN;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f7434a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7434a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            f7434a.append(R$styleable.KeyCycle_framePosition, 2);
            f7434a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f7434a.append(R$styleable.KeyCycle_curveFit, 4);
            f7434a.append(R$styleable.KeyCycle_waveShape, 5);
            f7434a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f7434a.append(R$styleable.KeyCycle_waveOffset, 7);
            f7434a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f7434a.append(R$styleable.KeyCycle_android_alpha, 9);
            f7434a.append(R$styleable.KeyCycle_android_elevation, 10);
            f7434a.append(R$styleable.KeyCycle_android_rotation, 11);
            f7434a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f7434a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f7434a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f7434a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f7434a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f7434a.append(R$styleable.KeyCycle_android_translationX, 17);
            f7434a.append(R$styleable.KeyCycle_android_translationY, 18);
            f7434a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f7434a.append(R$styleable.KeyCycle_motionProgress, 20);
            f7434a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        public static void b(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7434a.get(index)) {
                    case 1:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.f7392b = typedArray.getResourceId(index, keyCycle.f7392b);
                                break;
                            } else {
                                keyCycle.f7393c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyCycle.f7392b);
                            keyCycle.f7392b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyCycle.f7393c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyCycle.f7391a = typedArray.getInt(index, keyCycle.f7391a);
                        break;
                    case 3:
                        String unused = keyCycle.f7414g = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = keyCycle.f7415h = typedArray.getInteger(index, keyCycle.f7415h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type != 3) {
                            int unused3 = keyCycle.f7416i = typedArray.getInt(index, keyCycle.f7416i);
                            break;
                        } else {
                            String unused4 = keyCycle.f7417j = typedArray.getString(index);
                            int unused5 = keyCycle.f7416i = 7;
                            break;
                        }
                    case 6:
                        float unused6 = keyCycle.f7418k = typedArray.getFloat(index, keyCycle.f7418k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused7 = keyCycle.f7419l = typedArray.getFloat(index, keyCycle.f7419l);
                            break;
                        } else {
                            float unused8 = keyCycle.f7419l = typedArray.getDimension(index, keyCycle.f7419l);
                            break;
                        }
                    case 8:
                        int unused9 = keyCycle.f7422o = typedArray.getInt(index, keyCycle.f7422o);
                        break;
                    case 9:
                        float unused10 = keyCycle.f7423p = typedArray.getFloat(index, keyCycle.f7423p);
                        break;
                    case 10:
                        float unused11 = keyCycle.f7424q = typedArray.getDimension(index, keyCycle.f7424q);
                        break;
                    case 11:
                        float unused12 = keyCycle.f7425r = typedArray.getFloat(index, keyCycle.f7425r);
                        break;
                    case 12:
                        float unused13 = keyCycle.f7427t = typedArray.getFloat(index, keyCycle.f7427t);
                        break;
                    case 13:
                        float unused14 = keyCycle.f7428u = typedArray.getFloat(index, keyCycle.f7428u);
                        break;
                    case 14:
                        float unused15 = keyCycle.f7426s = typedArray.getFloat(index, keyCycle.f7426s);
                        break;
                    case 15:
                        float unused16 = keyCycle.f7429v = typedArray.getFloat(index, keyCycle.f7429v);
                        break;
                    case 16:
                        float unused17 = keyCycle.f7430w = typedArray.getFloat(index, keyCycle.f7430w);
                        break;
                    case 17:
                        float unused18 = keyCycle.f7431x = typedArray.getDimension(index, keyCycle.f7431x);
                        break;
                    case 18:
                        float unused19 = keyCycle.f7432y = typedArray.getDimension(index, keyCycle.f7432y);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused20 = keyCycle.f7433z = typedArray.getDimension(index, keyCycle.f7433z);
                            break;
                        }
                    case 20:
                        float unused21 = keyCycle.f7421n = typedArray.getFloat(index, keyCycle.f7421n);
                        break;
                    case 21:
                        float unused22 = keyCycle.f7420m = typedArray.getFloat(index, keyCycle.f7420m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7434a.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.f7394d = 4;
        this.f7395e = new HashMap<>();
    }

    public void Y(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        HashMap<String, ViewOscillator> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f7395e.get(next.substring(7));
                if (!(constraintAttribute == null || constraintAttribute.d() != ConstraintAttribute.AttributeType.FLOAT_TYPE || (viewOscillator2 = hashMap2.get(next)) == null)) {
                    viewOscillator2.e(this.f7391a, this.f7416i, this.f7417j, this.f7422o, this.f7418k, this.f7419l, this.f7420m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float Z = Z(next);
                if (!Float.isNaN(Z) && (viewOscillator = hashMap2.get(next)) != null) {
                    viewOscillator.d(this.f7391a, this.f7416i, this.f7417j, this.f7422o, this.f7418k, this.f7419l, this.f7420m, Z);
                }
            }
        }
    }

    public float Z(String str) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = 12;
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c11 = 13;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return this.f7427t;
            case 1:
                return this.f7428u;
            case 2:
                return this.f7431x;
            case 3:
                return this.f7432y;
            case 4:
                return this.f7433z;
            case 5:
                return this.f7421n;
            case 6:
                return this.f7429v;
            case 7:
                return this.f7430w;
            case 8:
                return this.f7425r;
            case 9:
                return this.f7424q;
            case 10:
                return this.f7426s;
            case 11:
                return this.f7423p;
            case 12:
                return this.f7419l;
            case 13:
                return this.f7420m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
        Debug.g("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            if (splineSet != null) {
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
                    case -40300674:
                        if (next.equals("rotation")) {
                            c11 = 8;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c11 = 9;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c11 = 10;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c11 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c11 = 12;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c11 = 13;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        splineSet.c(this.f7391a, this.f7427t);
                        break;
                    case 1:
                        splineSet.c(this.f7391a, this.f7428u);
                        break;
                    case 2:
                        splineSet.c(this.f7391a, this.f7431x);
                        break;
                    case 3:
                        splineSet.c(this.f7391a, this.f7432y);
                        break;
                    case 4:
                        splineSet.c(this.f7391a, this.f7433z);
                        break;
                    case 5:
                        splineSet.c(this.f7391a, this.f7421n);
                        break;
                    case 6:
                        splineSet.c(this.f7391a, this.f7429v);
                        break;
                    case 7:
                        splineSet.c(this.f7391a, this.f7430w);
                        break;
                    case 8:
                        splineSet.c(this.f7391a, this.f7425r);
                        break;
                    case 9:
                        splineSet.c(this.f7391a, this.f7424q);
                        break;
                    case 10:
                        splineSet.c(this.f7391a, this.f7426s);
                        break;
                    case 11:
                        splineSet.c(this.f7391a, this.f7423p);
                        break;
                    case 12:
                        splineSet.c(this.f7391a, this.f7419l);
                        break;
                    case 13:
                        splineSet.c(this.f7391a, this.f7420m);
                        break;
                    default:
                        if (next.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + next);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyCycle().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.f7414g = keyCycle.f7414g;
        this.f7415h = keyCycle.f7415h;
        this.f7416i = keyCycle.f7416i;
        this.f7417j = keyCycle.f7417j;
        this.f7418k = keyCycle.f7418k;
        this.f7419l = keyCycle.f7419l;
        this.f7420m = keyCycle.f7420m;
        this.f7421n = keyCycle.f7421n;
        this.f7422o = keyCycle.f7422o;
        this.f7423p = keyCycle.f7423p;
        this.f7424q = keyCycle.f7424q;
        this.f7425r = keyCycle.f7425r;
        this.f7426s = keyCycle.f7426s;
        this.f7427t = keyCycle.f7427t;
        this.f7428u = keyCycle.f7428u;
        this.f7429v = keyCycle.f7429v;
        this.f7430w = keyCycle.f7430w;
        this.f7431x = keyCycle.f7431x;
        this.f7432y = keyCycle.f7432y;
        this.f7433z = keyCycle.f7433z;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f7423p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7424q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7425r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7427t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7428u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7429v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7430w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7426s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7431x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7432y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7433z)) {
            hashSet.add("translationZ");
        }
        if (this.f7395e.size() > 0) {
            for (String str : this.f7395e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }
}

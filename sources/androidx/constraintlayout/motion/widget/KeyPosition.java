package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class KeyPosition extends c {

    /* renamed from: h  reason: collision with root package name */
    public String f7437h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f7438i = Key.f7390f;

    /* renamed from: j  reason: collision with root package name */
    public int f7439j = 0;

    /* renamed from: k  reason: collision with root package name */
    public float f7440k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7441l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7442m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f7443n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7444o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7445p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public int f7446q = 0;

    /* renamed from: r  reason: collision with root package name */
    public float f7447r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f7448s = Float.NaN;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f7449a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7449a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            f7449a.append(R$styleable.KeyPosition_framePosition, 2);
            f7449a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f7449a.append(R$styleable.KeyPosition_curveFit, 4);
            f7449a.append(R$styleable.KeyPosition_drawPath, 5);
            f7449a.append(R$styleable.KeyPosition_percentX, 6);
            f7449a.append(R$styleable.KeyPosition_percentY, 7);
            f7449a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f7449a.append(R$styleable.KeyPosition_sizePercent, 8);
            f7449a.append(R$styleable.KeyPosition_percentWidth, 11);
            f7449a.append(R$styleable.KeyPosition_percentHeight, 12);
            f7449a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7449a.get(index)) {
                    case 1:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.f7392b = typedArray.getResourceId(index, keyPosition.f7392b);
                                break;
                            } else {
                                keyPosition.f7393c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.f7392b);
                            keyPosition.f7392b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.f7393c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.f7391a = typedArray.getInt(index, keyPosition.f7391a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.f7437h = Easing.f6847c[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.f7437h = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.f7659g = typedArray.getInteger(index, keyPosition.f7659g);
                        break;
                    case 5:
                        keyPosition.f7439j = typedArray.getInt(index, keyPosition.f7439j);
                        break;
                    case 6:
                        keyPosition.f7442m = typedArray.getFloat(index, keyPosition.f7442m);
                        break;
                    case 7:
                        keyPosition.f7443n = typedArray.getFloat(index, keyPosition.f7443n);
                        break;
                    case 8:
                        float f11 = typedArray.getFloat(index, keyPosition.f7441l);
                        keyPosition.f7440k = f11;
                        keyPosition.f7441l = f11;
                        break;
                    case 9:
                        keyPosition.f7446q = typedArray.getInt(index, keyPosition.f7446q);
                        break;
                    case 10:
                        keyPosition.f7438i = typedArray.getInt(index, keyPosition.f7438i);
                        break;
                    case 11:
                        keyPosition.f7440k = typedArray.getFloat(index, keyPosition.f7440k);
                        break;
                    case 12:
                        keyPosition.f7441l = typedArray.getFloat(index, keyPosition.f7441l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7449a.get(index));
                        break;
                }
            }
            if (keyPosition.f7391a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.f7394d = 2;
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyPosition().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.f7437h = keyPosition.f7437h;
        this.f7438i = keyPosition.f7438i;
        this.f7439j = keyPosition.f7439j;
        this.f7440k = keyPosition.f7440k;
        this.f7441l = Float.NaN;
        this.f7442m = keyPosition.f7442m;
        this.f7443n = keyPosition.f7443n;
        this.f7444o = keyPosition.f7444o;
        this.f7445p = keyPosition.f7445p;
        this.f7447r = keyPosition.f7447r;
        this.f7448s = keyPosition.f7448s;
        return this;
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }

    public void m(int i11) {
        this.f7446q = i11;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c11 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c11 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c11 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c11 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f7437h = obj.toString();
                return;
            case 1:
                this.f7440k = k(obj);
                return;
            case 2:
                this.f7441l = k(obj);
                return;
            case 3:
                this.f7439j = l(obj);
                return;
            case 4:
                float k11 = k(obj);
                this.f7440k = k11;
                this.f7441l = k11;
                return;
            case 5:
                this.f7442m = k(obj);
                return;
            case 6:
                this.f7443n = k(obj);
                return;
            default:
                return;
        }
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class KeyTrigger extends Key {
    public HashMap<String, Method> A;

    /* renamed from: g  reason: collision with root package name */
    public int f7469g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f7470h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f7471i;

    /* renamed from: j  reason: collision with root package name */
    public String f7472j;

    /* renamed from: k  reason: collision with root package name */
    public String f7473k;

    /* renamed from: l  reason: collision with root package name */
    public int f7474l;

    /* renamed from: m  reason: collision with root package name */
    public int f7475m;

    /* renamed from: n  reason: collision with root package name */
    public View f7476n;

    /* renamed from: o  reason: collision with root package name */
    public float f7477o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7478p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f7479q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7480r;

    /* renamed from: s  reason: collision with root package name */
    public float f7481s;

    /* renamed from: t  reason: collision with root package name */
    public float f7482t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7483u;

    /* renamed from: v  reason: collision with root package name */
    public int f7484v;

    /* renamed from: w  reason: collision with root package name */
    public int f7485w;

    /* renamed from: x  reason: collision with root package name */
    public int f7486x;

    /* renamed from: y  reason: collision with root package name */
    public RectF f7487y;

    /* renamed from: z  reason: collision with root package name */
    public RectF f7488z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f7489a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7489a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            f7489a.append(R$styleable.KeyTrigger_onCross, 4);
            f7489a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f7489a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f7489a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f7489a.append(R$styleable.KeyTrigger_triggerId, 6);
            f7489a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f7489a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f7489a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f7489a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f7489a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f7489a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f7489a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7489a.get(index)) {
                    case 1:
                        String unused = keyTrigger.f7472j = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = keyTrigger.f7473k = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = keyTrigger.f7470h = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.f7477o = typedArray.getFloat(index, keyTrigger.f7477o);
                        break;
                    case 6:
                        int unused4 = keyTrigger.f7474l = typedArray.getResourceId(index, keyTrigger.f7474l);
                        break;
                    case 7:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.f7392b = typedArray.getResourceId(index, keyTrigger.f7392b);
                                break;
                            } else {
                                keyTrigger.f7393c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.f7392b);
                            keyTrigger.f7392b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTrigger.f7393c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.f7391a);
                        keyTrigger.f7391a = integer;
                        float unused5 = keyTrigger.f7481s = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = keyTrigger.f7475m = typedArray.getResourceId(index, keyTrigger.f7475m);
                        break;
                    case 10:
                        boolean unused7 = keyTrigger.f7483u = typedArray.getBoolean(index, keyTrigger.f7483u);
                        break;
                    case 11:
                        int unused8 = keyTrigger.f7471i = typedArray.getResourceId(index, keyTrigger.f7471i);
                        break;
                    case 12:
                        keyTrigger.f7486x = typedArray.getResourceId(index, keyTrigger.f7486x);
                        break;
                    case 13:
                        keyTrigger.f7484v = typedArray.getResourceId(index, keyTrigger.f7484v);
                        break;
                    case 14:
                        keyTrigger.f7485w = typedArray.getResourceId(index, keyTrigger.f7485w);
                        break;
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7489a.get(index));
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        int i11 = Key.f7390f;
        this.f7471i = i11;
        this.f7472j = null;
        this.f7473k = null;
        this.f7474l = i11;
        this.f7475m = i11;
        this.f7476n = null;
        this.f7477o = 0.1f;
        this.f7478p = true;
        this.f7479q = true;
        this.f7480r = true;
        this.f7481s = Float.NaN;
        this.f7483u = false;
        this.f7484v = i11;
        this.f7485w = i11;
        this.f7486x = i11;
        this.f7487y = new RectF();
        this.f7488z = new RectF();
        this.A = new HashMap<>();
        this.f7394d = 5;
        this.f7395e = new HashMap<>();
    }

    public final void A(String str, View view) {
        ConstraintAttribute constraintAttribute;
        boolean z11 = str.length() == 1;
        if (!z11) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.f7395e.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z11 || lowerCase.matches(str)) && (constraintAttribute = this.f7395e.get(next)) != null) {
                constraintAttribute.a(view);
            }
        }
    }

    public final void B(RectF rectF, View view, boolean z11) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z11) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTrigger().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.f7469g = keyTrigger.f7469g;
        this.f7470h = keyTrigger.f7470h;
        this.f7471i = keyTrigger.f7471i;
        this.f7472j = keyTrigger.f7472j;
        this.f7473k = keyTrigger.f7473k;
        this.f7474l = keyTrigger.f7474l;
        this.f7475m = keyTrigger.f7475m;
        this.f7476n = keyTrigger.f7476n;
        this.f7477o = keyTrigger.f7477o;
        this.f7478p = keyTrigger.f7478p;
        this.f7479q = keyTrigger.f7479q;
        this.f7480r = keyTrigger.f7480r;
        this.f7481s = keyTrigger.f7481s;
        this.f7482t = keyTrigger.f7482t;
        this.f7483u = keyTrigger.f7483u;
        this.f7487y = keyTrigger.f7487y;
        this.f7488z = keyTrigger.f7488z;
        this.A = keyTrigger.A;
        return this;
    }

    public void d(HashSet<String> hashSet) {
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.f7475m
            int r1 = androidx.constraintlayout.motion.widget.Key.f7390f
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.f7476n
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.f7475m
            android.view.View r0 = r0.findViewById(r1)
            r9.f7476n = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.f7487y
            android.view.View r1 = r9.f7476n
            boolean r4 = r9.f7483u
            r9.B(r0, r1, r4)
            android.graphics.RectF r0 = r9.f7488z
            boolean r1 = r9.f7483u
            r9.B(r0, r11, r1)
            android.graphics.RectF r0 = r9.f7487y
            android.graphics.RectF r1 = r9.f7488z
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.f7478p
            if (r0 == 0) goto L_0x003c
            r9.f7478p = r2
            r0 = r3
            goto L_0x003d
        L_0x003c:
            r0 = r2
        L_0x003d:
            boolean r1 = r9.f7480r
            if (r1 == 0) goto L_0x0045
            r9.f7480r = r2
            r1 = r3
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            r9.f7479q = r3
            r4 = r1
            r1 = r2
            goto L_0x00e0
        L_0x004c:
            boolean r0 = r9.f7478p
            if (r0 != 0) goto L_0x0054
            r9.f7478p = r3
            r0 = r3
            goto L_0x0055
        L_0x0054:
            r0 = r2
        L_0x0055:
            boolean r1 = r9.f7479q
            if (r1 == 0) goto L_0x005d
            r9.f7479q = r2
            r1 = r3
            goto L_0x005e
        L_0x005d:
            r1 = r2
        L_0x005e:
            r9.f7480r = r3
            goto L_0x00df
        L_0x0062:
            boolean r0 = r9.f7478p
            r1 = 0
            if (r0 == 0) goto L_0x0077
            float r0 = r9.f7481s
            float r4 = r10 - r0
            float r5 = r9.f7482t
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0087
            r9.f7478p = r2
            r0 = r3
            goto L_0x0088
        L_0x0077:
            float r0 = r9.f7481s
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.f7477o
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r9.f7478p = r3
        L_0x0087:
            r0 = r2
        L_0x0088:
            boolean r4 = r9.f7479q
            if (r4 == 0) goto L_0x00a0
            float r4 = r9.f7481s
            float r5 = r10 - r4
            float r6 = r9.f7482t
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            r9.f7479q = r2
            r4 = r3
            goto L_0x00b1
        L_0x00a0:
            float r4 = r9.f7481s
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.f7477o
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b0
            r9.f7479q = r3
        L_0x00b0:
            r4 = r2
        L_0x00b1:
            boolean r5 = r9.f7480r
            if (r5 == 0) goto L_0x00ce
            float r5 = r9.f7481s
            float r6 = r10 - r5
            float r7 = r9.f7482t
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00c9
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c9
            r9.f7480r = r2
            r1 = r3
            goto L_0x00ca
        L_0x00c9:
            r1 = r2
        L_0x00ca:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x00e0
        L_0x00ce:
            float r1 = r9.f7481s
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.f7477o
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00de
            r9.f7480r = r3
        L_0x00de:
            r1 = r4
        L_0x00df:
            r4 = r2
        L_0x00e0:
            r9.f7482t = r10
            if (r1 != 0) goto L_0x00e8
            if (r0 != 0) goto L_0x00e8
            if (r4 == 0) goto L_0x00f3
        L_0x00e8:
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.f7474l
            r5.a0(r6, r4, r10)
        L_0x00f3:
            int r10 = r9.f7471i
            int r5 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r10 != r5) goto L_0x00fb
            r10 = r11
            goto L_0x0107
        L_0x00fb:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r5 = r9.f7471i
            android.view.View r10 = r10.findViewById(r5)
        L_0x0107:
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = r9.f7472j
            if (r1 == 0) goto L_0x0110
            r9.z(r1, r10)
        L_0x0110:
            int r1 = r9.f7484v
            int r5 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r1 == r5) goto L_0x0125
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r5 = r9.f7484v
            android.view.View[] r6 = new android.view.View[r3]
            r6[r2] = r10
            r1.B0(r5, r6)
        L_0x0125:
            if (r4 == 0) goto L_0x0143
            java.lang.String r1 = r9.f7473k
            if (r1 == 0) goto L_0x012e
            r9.z(r1, r10)
        L_0x012e:
            int r1 = r9.f7485w
            int r4 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r1 == r4) goto L_0x0143
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r4 = r9.f7485w
            android.view.View[] r5 = new android.view.View[r3]
            r5[r2] = r10
            r1.B0(r4, r5)
        L_0x0143:
            if (r0 == 0) goto L_0x0161
            java.lang.String r0 = r9.f7470h
            if (r0 == 0) goto L_0x014c
            r9.z(r0, r10)
        L_0x014c:
            int r0 = r9.f7486x
            int r1 = androidx.constraintlayout.motion.widget.Key.f7390f
            if (r0 == r1) goto L_0x0161
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.f7486x
            android.view.View[] r1 = new android.view.View[r3]
            r1[r2] = r10
            r11.B0(r0, r1)
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.y(float, android.view.View):void");
    }

    public final void z(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(InstructionFileId.DOT)) {
                A(str, view);
                return;
            }
            if (this.A.containsKey(str)) {
                method = this.A.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.A.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.A.put(str, (Object) null);
                    Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.f7470h + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
            }
        }
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;

public class KeyAttributes extends Key {

    /* renamed from: g  reason: collision with root package name */
    public String f7396g;

    /* renamed from: h  reason: collision with root package name */
    public int f7397h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7398i = false;

    /* renamed from: j  reason: collision with root package name */
    public float f7399j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f7400k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7401l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7402m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f7403n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7404o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7405p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7406q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public float f7407r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f7408s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    public float f7409t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public float f7410u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    public float f7411v = Float.NaN;

    /* renamed from: w  reason: collision with root package name */
    public float f7412w = Float.NaN;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f7413a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7413a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            f7413a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f7413a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f7413a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f7413a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f7413a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f7413a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f7413a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f7413a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f7413a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f7413a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f7413a.append(R$styleable.KeyAttribute_framePosition, 12);
            f7413a.append(R$styleable.KeyAttribute_curveFit, 13);
            f7413a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f7413a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f7413a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f7413a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f7413a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7413a.get(index)) {
                    case 1:
                        float unused = keyAttributes.f7399j = typedArray.getFloat(index, keyAttributes.f7399j);
                        break;
                    case 2:
                        float unused2 = keyAttributes.f7400k = typedArray.getDimension(index, keyAttributes.f7400k);
                        break;
                    case 4:
                        float unused3 = keyAttributes.f7401l = typedArray.getFloat(index, keyAttributes.f7401l);
                        break;
                    case 5:
                        float unused4 = keyAttributes.f7402m = typedArray.getFloat(index, keyAttributes.f7402m);
                        break;
                    case 6:
                        float unused5 = keyAttributes.f7403n = typedArray.getFloat(index, keyAttributes.f7403n);
                        break;
                    case 7:
                        float unused6 = keyAttributes.f7407r = typedArray.getFloat(index, keyAttributes.f7407r);
                        break;
                    case 8:
                        float unused7 = keyAttributes.f7406q = typedArray.getFloat(index, keyAttributes.f7406q);
                        break;
                    case 9:
                        String unused8 = keyAttributes.f7396g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.f7392b = typedArray.getResourceId(index, keyAttributes.f7392b);
                                break;
                            } else {
                                keyAttributes.f7393c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.f7392b);
                            keyAttributes.f7392b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyAttributes.f7393c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyAttributes.f7391a = typedArray.getInt(index, keyAttributes.f7391a);
                        break;
                    case 13:
                        int unused9 = keyAttributes.f7397h = typedArray.getInteger(index, keyAttributes.f7397h);
                        break;
                    case 14:
                        float unused10 = keyAttributes.f7408s = typedArray.getFloat(index, keyAttributes.f7408s);
                        break;
                    case 15:
                        float unused11 = keyAttributes.f7409t = typedArray.getDimension(index, keyAttributes.f7409t);
                        break;
                    case 16:
                        float unused12 = keyAttributes.f7410u = typedArray.getDimension(index, keyAttributes.f7410u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = keyAttributes.f7411v = typedArray.getDimension(index, keyAttributes.f7411v);
                            break;
                        }
                    case 18:
                        float unused14 = keyAttributes.f7412w = typedArray.getFloat(index, keyAttributes.f7412w);
                        break;
                    case 19:
                        float unused15 = keyAttributes.f7404o = typedArray.getDimension(index, keyAttributes.f7404o);
                        break;
                    case 20:
                        float unused16 = keyAttributes.f7405p = typedArray.getDimension(index, keyAttributes.f7405p);
                        break;
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7413a.get(index));
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.f7394d = 1;
        this.f7395e = new HashMap<>();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
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
            case 579057826:
                if (str.equals("curveFit")) {
                    c11 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c11 = 16;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f7412w = k(obj);
                return;
            case 1:
                this.f7396g = obj.toString();
                return;
            case 2:
                this.f7402m = k(obj);
                return;
            case 3:
                this.f7403n = k(obj);
                return;
            case 4:
                this.f7409t = k(obj);
                return;
            case 5:
                this.f7410u = k(obj);
                return;
            case 6:
                this.f7411v = k(obj);
                return;
            case 7:
                this.f7407r = k(obj);
                return;
            case 8:
                this.f7408s = k(obj);
                return;
            case 9:
                this.f7404o = k(obj);
                return;
            case 10:
                this.f7405p = k(obj);
                return;
            case 11:
                this.f7401l = k(obj);
                return;
            case 12:
                this.f7400k = k(obj);
                return;
            case 13:
                this.f7406q = k(obj);
                return;
            case 14:
                this.f7399j = k(obj);
                return;
            case 15:
                this.f7397h = l(obj);
                return;
            case 16:
                this.f7398i = j(obj);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r1.equals("scaleY") == false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01e0
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            androidx.constraintlayout.core.motion.utils.SplineSet r2 = (androidx.constraintlayout.core.motion.utils.SplineSet) r2
            if (r2 != 0) goto L_0x001d
            goto L_0x0008
        L_0x001d:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x003c
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r3 = r6.f7395e
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            if (r1 == 0) goto L_0x0008
            androidx.constraintlayout.motion.utils.ViewSpline$b r2 = (androidx.constraintlayout.motion.utils.ViewSpline.b) r2
            int r3 = r6.f7391a
            r2.i(r3, r1)
            goto L_0x0008
        L_0x003c:
            r3 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00e2;
                case -1249320805: goto L_0x00d6;
                case -1225497657: goto L_0x00ca;
                case -1225497656: goto L_0x00be;
                case -1225497655: goto L_0x00b3;
                case -1001078227: goto L_0x00a8;
                case -908189618: goto L_0x009d;
                case -908189617: goto L_0x0094;
                case -760884510: goto L_0x0088;
                case -760884509: goto L_0x007b;
                case -40300674: goto L_0x006e;
                case -4379043: goto L_0x0061;
                case 37232917: goto L_0x0054;
                case 92909918: goto L_0x0047;
                default: goto L_0x0044;
            }
        L_0x0044:
            r4 = r3
            goto L_0x00ed
        L_0x0047:
            java.lang.String r4 = "alpha"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0050
            goto L_0x0044
        L_0x0050:
            r4 = 13
            goto L_0x00ed
        L_0x0054:
            java.lang.String r4 = "transitionPathRotate"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x005d
            goto L_0x0044
        L_0x005d:
            r4 = 12
            goto L_0x00ed
        L_0x0061:
            java.lang.String r4 = "elevation"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x006a
            goto L_0x0044
        L_0x006a:
            r4 = 11
            goto L_0x00ed
        L_0x006e:
            java.lang.String r4 = "rotation"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0077
            goto L_0x0044
        L_0x0077:
            r4 = 10
            goto L_0x00ed
        L_0x007b:
            java.lang.String r4 = "transformPivotY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0084
            goto L_0x0044
        L_0x0084:
            r4 = 9
            goto L_0x00ed
        L_0x0088:
            java.lang.String r4 = "transformPivotX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0091
            goto L_0x0044
        L_0x0091:
            r4 = 8
            goto L_0x00ed
        L_0x0094:
            java.lang.String r5 = "scaleY"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x00ed
            goto L_0x0044
        L_0x009d:
            java.lang.String r4 = "scaleX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00a6
            goto L_0x0044
        L_0x00a6:
            r4 = 6
            goto L_0x00ed
        L_0x00a8:
            java.lang.String r4 = "progress"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00b1
            goto L_0x0044
        L_0x00b1:
            r4 = 5
            goto L_0x00ed
        L_0x00b3:
            java.lang.String r4 = "translationZ"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00bc
            goto L_0x0044
        L_0x00bc:
            r4 = 4
            goto L_0x00ed
        L_0x00be:
            java.lang.String r4 = "translationY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00c8
            goto L_0x0044
        L_0x00c8:
            r4 = 3
            goto L_0x00ed
        L_0x00ca:
            java.lang.String r4 = "translationX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00d4
            goto L_0x0044
        L_0x00d4:
            r4 = 2
            goto L_0x00ed
        L_0x00d6:
            java.lang.String r4 = "rotationY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00e0
            goto L_0x0044
        L_0x00e0:
            r4 = 1
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r4 = "rotationX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00ec
            goto L_0x0044
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            switch(r4) {
                case 0: goto L_0x01cf;
                case 1: goto L_0x01be;
                case 2: goto L_0x01ad;
                case 3: goto L_0x019c;
                case 4: goto L_0x018b;
                case 5: goto L_0x017a;
                case 6: goto L_0x0169;
                case 7: goto L_0x0158;
                case 8: goto L_0x0147;
                case 9: goto L_0x0136;
                case 10: goto L_0x0125;
                case 11: goto L_0x0114;
                case 12: goto L_0x0103;
                case 13: goto L_0x00f2;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x0008
        L_0x00f2:
            float r1 = r6.f7399j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7399j
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0103:
            float r1 = r6.f7406q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7406q
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0114:
            float r1 = r6.f7400k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7400k
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0125:
            float r1 = r6.f7401l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7401l
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0136:
            float r1 = r6.f7403n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7405p
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0147:
            float r1 = r6.f7402m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7404o
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0158:
            float r1 = r6.f7408s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7408s
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0169:
            float r1 = r6.f7407r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7407r
            r2.c(r1, r3)
            goto L_0x0008
        L_0x017a:
            float r1 = r6.f7412w
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7412w
            r2.c(r1, r3)
            goto L_0x0008
        L_0x018b:
            float r1 = r6.f7411v
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7411v
            r2.c(r1, r3)
            goto L_0x0008
        L_0x019c:
            float r1 = r6.f7410u
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7410u
            r2.c(r1, r3)
            goto L_0x0008
        L_0x01ad:
            float r1 = r6.f7409t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7409t
            r2.c(r1, r3)
            goto L_0x0008
        L_0x01be:
            float r1 = r6.f7403n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7403n
            r2.c(r1, r3)
            goto L_0x0008
        L_0x01cf:
            float r1 = r6.f7402m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f7391a
            float r3 = r6.f7402m
            r2.c(r1, r3)
            goto L_0x0008
        L_0x01e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.a(java.util.HashMap):void");
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyAttributes().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.f7397h = keyAttributes.f7397h;
        this.f7398i = keyAttributes.f7398i;
        this.f7399j = keyAttributes.f7399j;
        this.f7400k = keyAttributes.f7400k;
        this.f7401l = keyAttributes.f7401l;
        this.f7402m = keyAttributes.f7402m;
        this.f7403n = keyAttributes.f7403n;
        this.f7404o = keyAttributes.f7404o;
        this.f7405p = keyAttributes.f7405p;
        this.f7406q = keyAttributes.f7406q;
        this.f7407r = keyAttributes.f7407r;
        this.f7408s = keyAttributes.f7408s;
        this.f7409t = keyAttributes.f7409t;
        this.f7410u = keyAttributes.f7410u;
        this.f7411v = keyAttributes.f7411v;
        this.f7412w = keyAttributes.f7412w;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f7399j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7400k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7401l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7402m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7403n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7404o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f7405p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f7409t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7410u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7411v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f7406q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7407r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7408s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7412w)) {
            hashSet.add("progress");
        }
        if (this.f7395e.size() > 0) {
            for (String str : this.f7395e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    public void h(HashMap<String, Integer> hashMap) {
        if (this.f7397h != -1) {
            if (!Float.isNaN(this.f7399j)) {
                hashMap.put("alpha", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7400k)) {
                hashMap.put("elevation", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7401l)) {
                hashMap.put("rotation", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7402m)) {
                hashMap.put("rotationX", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7403n)) {
                hashMap.put("rotationY", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7404o)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7405p)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7409t)) {
                hashMap.put("translationX", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7410u)) {
                hashMap.put("translationY", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7411v)) {
                hashMap.put("translationZ", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7406q)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7407r)) {
                hashMap.put("scaleX", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7408s)) {
                hashMap.put("scaleY", Integer.valueOf(this.f7397h));
            }
            if (!Float.isNaN(this.f7412w)) {
                hashMap.put("progress", Integer.valueOf(this.f7397h));
            }
            if (this.f7395e.size() > 0) {
                for (String str : this.f7395e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f7397h));
                }
            }
        }
    }
}

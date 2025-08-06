package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTimeCycle extends Key {

    /* renamed from: g  reason: collision with root package name */
    public String f7450g;

    /* renamed from: h  reason: collision with root package name */
    public int f7451h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f7452i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public float f7453j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f7454k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7455l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7456m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f7457n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7458o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7459p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7460q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public float f7461r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f7462s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    public float f7463t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public int f7464u = 0;

    /* renamed from: v  reason: collision with root package name */
    public String f7465v = null;

    /* renamed from: w  reason: collision with root package name */
    public float f7466w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    public float f7467x = 0.0f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f7468a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7468a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f7468a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f7468a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f7468a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f7468a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f7468a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f7468a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f7468a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f7468a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f7468a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f7468a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f7468a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f7468a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f7468a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f7468a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f7468a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f7468a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f7468a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f7468a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7468a.get(index)) {
                    case 1:
                        float unused = keyTimeCycle.f7452i = typedArray.getFloat(index, keyTimeCycle.f7452i);
                        break;
                    case 2:
                        float unused2 = keyTimeCycle.f7453j = typedArray.getDimension(index, keyTimeCycle.f7453j);
                        break;
                    case 4:
                        float unused3 = keyTimeCycle.f7454k = typedArray.getFloat(index, keyTimeCycle.f7454k);
                        break;
                    case 5:
                        float unused4 = keyTimeCycle.f7455l = typedArray.getFloat(index, keyTimeCycle.f7455l);
                        break;
                    case 6:
                        float unused5 = keyTimeCycle.f7456m = typedArray.getFloat(index, keyTimeCycle.f7456m);
                        break;
                    case 7:
                        float unused6 = keyTimeCycle.f7458o = typedArray.getFloat(index, keyTimeCycle.f7458o);
                        break;
                    case 8:
                        float unused7 = keyTimeCycle.f7457n = typedArray.getFloat(index, keyTimeCycle.f7457n);
                        break;
                    case 9:
                        String unused8 = keyTimeCycle.f7450g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.f7392b = typedArray.getResourceId(index, keyTimeCycle.f7392b);
                                break;
                            } else {
                                keyTimeCycle.f7393c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.f7392b);
                            keyTimeCycle.f7392b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTimeCycle.f7393c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyTimeCycle.f7391a = typedArray.getInt(index, keyTimeCycle.f7391a);
                        break;
                    case 13:
                        int unused9 = keyTimeCycle.f7451h = typedArray.getInteger(index, keyTimeCycle.f7451h);
                        break;
                    case 14:
                        float unused10 = keyTimeCycle.f7459p = typedArray.getFloat(index, keyTimeCycle.f7459p);
                        break;
                    case 15:
                        float unused11 = keyTimeCycle.f7460q = typedArray.getDimension(index, keyTimeCycle.f7460q);
                        break;
                    case 16:
                        float unused12 = keyTimeCycle.f7461r = typedArray.getDimension(index, keyTimeCycle.f7461r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = keyTimeCycle.f7462s = typedArray.getDimension(index, keyTimeCycle.f7462s);
                            break;
                        }
                    case 18:
                        float unused14 = keyTimeCycle.f7463t = typedArray.getFloat(index, keyTimeCycle.f7463t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type != 3) {
                            int unused15 = keyTimeCycle.f7464u = typedArray.getInt(index, keyTimeCycle.f7464u);
                            break;
                        } else {
                            String unused16 = keyTimeCycle.f7465v = typedArray.getString(index);
                            int unused17 = keyTimeCycle.f7464u = 7;
                            break;
                        }
                    case 20:
                        float unused18 = keyTimeCycle.f7466w = typedArray.getFloat(index, keyTimeCycle.f7466w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused19 = keyTimeCycle.f7467x = typedArray.getFloat(index, keyTimeCycle.f7467x);
                            break;
                        } else {
                            float unused20 = keyTimeCycle.f7467x = typedArray.getDimension(index, keyTimeCycle.f7467x);
                            break;
                        }
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7468a.get(index));
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.f7394d = 3;
        this.f7395e = new HashMap<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        if (r1.equals("scaleY") == false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r11) {
        /*
            r10 = this;
            java.util.Set r0 = r11.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x020d
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r11.get(r1)
            r3 = r2
            androidx.constraintlayout.motion.utils.ViewTimeCycle r3 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r3
            if (r3 != 0) goto L_0x001e
            goto L_0x0008
        L_0x001e:
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r4 = 7
            if (r2 == 0) goto L_0x0045
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r10.f7395e
            java.lang.Object r1 = r2.get(r1)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x0008
            r4 = r3
            androidx.constraintlayout.motion.utils.ViewTimeCycle$b r4 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.b) r4
            int r5 = r10.f7391a
            float r7 = r10.f7466w
            int r8 = r10.f7464u
            float r9 = r10.f7467x
            r4.j(r5, r6, r7, r8, r9)
            goto L_0x0008
        L_0x0045:
            r2 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00ce;
                case -1249320805: goto L_0x00c3;
                case -1225497657: goto L_0x00b8;
                case -1225497656: goto L_0x00ad;
                case -1225497655: goto L_0x00a2;
                case -1001078227: goto L_0x0097;
                case -908189618: goto L_0x008c;
                case -908189617: goto L_0x0083;
                case -40300674: goto L_0x0077;
                case -4379043: goto L_0x006a;
                case 37232917: goto L_0x005d;
                case 92909918: goto L_0x0050;
                default: goto L_0x004d;
            }
        L_0x004d:
            r4 = r2
            goto L_0x00d9
        L_0x0050:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0059
            goto L_0x004d
        L_0x0059:
            r4 = 11
            goto L_0x00d9
        L_0x005d:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0066
            goto L_0x004d
        L_0x0066:
            r4 = 10
            goto L_0x00d9
        L_0x006a:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0073
            goto L_0x004d
        L_0x0073:
            r4 = 9
            goto L_0x00d9
        L_0x0077:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0080
            goto L_0x004d
        L_0x0080:
            r4 = 8
            goto L_0x00d9
        L_0x0083:
            java.lang.String r5 = "scaleY"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x00d9
            goto L_0x004d
        L_0x008c:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0095
            goto L_0x004d
        L_0x0095:
            r4 = 6
            goto L_0x00d9
        L_0x0097:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a0
            goto L_0x004d
        L_0x00a0:
            r4 = 5
            goto L_0x00d9
        L_0x00a2:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00ab
            goto L_0x004d
        L_0x00ab:
            r4 = 4
            goto L_0x00d9
        L_0x00ad:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b6
            goto L_0x004d
        L_0x00b6:
            r4 = 3
            goto L_0x00d9
        L_0x00b8:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c1
            goto L_0x004d
        L_0x00c1:
            r4 = 2
            goto L_0x00d9
        L_0x00c3:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00cc
            goto L_0x004d
        L_0x00cc:
            r4 = 1
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d8
            goto L_0x004d
        L_0x00d8:
            r4 = 0
        L_0x00d9:
            switch(r4) {
                case 0: goto L_0x01f6;
                case 1: goto L_0x01df;
                case 2: goto L_0x01c8;
                case 3: goto L_0x01b1;
                case 4: goto L_0x019a;
                case 5: goto L_0x0183;
                case 6: goto L_0x016c;
                case 7: goto L_0x0155;
                case 8: goto L_0x013e;
                case 9: goto L_0x0127;
                case 10: goto L_0x0110;
                case 11: goto L_0x00f9;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KeyTimeCycles"
            android.util.Log.e(r2, r1)
            goto L_0x0008
        L_0x00f9:
            float r1 = r10.f7452i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7452i
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0110:
            float r1 = r10.f7457n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7457n
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0127:
            float r1 = r10.f7453j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7453j
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x013e:
            float r1 = r10.f7454k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7454k
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0155:
            float r1 = r10.f7459p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7459p
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x016c:
            float r1 = r10.f7458o
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7458o
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0183:
            float r1 = r10.f7463t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7463t
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x019a:
            float r1 = r10.f7462s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7462s
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01b1:
            float r1 = r10.f7461r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7461r
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01c8:
            float r1 = r10.f7460q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7460q
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01df:
            float r1 = r10.f7456m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7456m
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01f6:
            float r1 = r10.f7455l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f7391a
            float r5 = r10.f7455l
            float r6 = r10.f7466w
            int r7 = r10.f7464u
            float r8 = r10.f7467x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x020d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTimeCycle.U(java.util.HashMap):void");
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTimeCycle().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.f7450g = keyTimeCycle.f7450g;
        this.f7451h = keyTimeCycle.f7451h;
        this.f7464u = keyTimeCycle.f7464u;
        this.f7466w = keyTimeCycle.f7466w;
        this.f7467x = keyTimeCycle.f7467x;
        this.f7463t = keyTimeCycle.f7463t;
        this.f7452i = keyTimeCycle.f7452i;
        this.f7453j = keyTimeCycle.f7453j;
        this.f7454k = keyTimeCycle.f7454k;
        this.f7457n = keyTimeCycle.f7457n;
        this.f7455l = keyTimeCycle.f7455l;
        this.f7456m = keyTimeCycle.f7456m;
        this.f7458o = keyTimeCycle.f7458o;
        this.f7459p = keyTimeCycle.f7459p;
        this.f7460q = keyTimeCycle.f7460q;
        this.f7461r = keyTimeCycle.f7461r;
        this.f7462s = keyTimeCycle.f7462s;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f7452i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7453j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7454k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7455l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7456m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7460q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7461r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7462s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f7457n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7458o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7459p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7463t)) {
            hashSet.add("progress");
        }
        if (this.f7395e.size() > 0) {
            for (String str : this.f7395e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    public void h(HashMap<String, Integer> hashMap) {
        if (this.f7451h != -1) {
            if (!Float.isNaN(this.f7452i)) {
                hashMap.put("alpha", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7453j)) {
                hashMap.put("elevation", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7454k)) {
                hashMap.put("rotation", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7455l)) {
                hashMap.put("rotationX", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7456m)) {
                hashMap.put("rotationY", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7460q)) {
                hashMap.put("translationX", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7461r)) {
                hashMap.put("translationY", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7462s)) {
                hashMap.put("translationZ", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7457n)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7458o)) {
                hashMap.put("scaleX", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7458o)) {
                hashMap.put("scaleY", Integer.valueOf(this.f7451h));
            }
            if (!Float.isNaN(this.f7463t)) {
                hashMap.put("progress", Integer.valueOf(this.f7451h));
            }
            if (this.f7395e.size() > 0) {
                for (String str : this.f7395e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f7451h));
                }
            }
        }
    }
}

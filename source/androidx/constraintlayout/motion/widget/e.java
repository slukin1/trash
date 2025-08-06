package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f7687a;

    /* renamed from: b  reason: collision with root package name */
    public n0.b f7688b = null;

    /* renamed from: c  reason: collision with root package name */
    public b f7689c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7690d = false;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f7691e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public b f7692f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<b> f7693g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<ConstraintSet> f7694h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, Integer> f7695i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public SparseIntArray f7696j = new SparseIntArray();

    /* renamed from: k  reason: collision with root package name */
    public boolean f7697k = false;

    /* renamed from: l  reason: collision with root package name */
    public int f7698l = 400;

    /* renamed from: m  reason: collision with root package name */
    public int f7699m = 0;

    /* renamed from: n  reason: collision with root package name */
    public MotionEvent f7700n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7701o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7702p = false;

    /* renamed from: q  reason: collision with root package name */
    public MotionLayout.h f7703q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7704r;

    /* renamed from: s  reason: collision with root package name */
    public final i f7705s;

    /* renamed from: t  reason: collision with root package name */
    public float f7706t;

    /* renamed from: u  reason: collision with root package name */
    public float f7707u;

    public class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Easing f7708a;

        public a(Easing easing) {
            this.f7708a = easing;
        }

        public float getInterpolation(float f11) {
            return (float) this.f7708a.a((double) f11);
        }
    }

    public e(Context context, MotionLayout motionLayout, int i11) {
        this.f7687a = motionLayout;
        this.f7705s = new i(motionLayout);
        K(context, i11);
        SparseArray<ConstraintSet> sparseArray = this.f7694h;
        int i12 = R$id.motion_base;
        sparseArray.put(i12, new ConstraintSet());
        this.f7695i.put("motion_base", Integer.valueOf(i12));
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public float A() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.l();
    }

    public float B() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.m();
    }

    public float C() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.n();
    }

    public float D() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.o();
    }

    public float E() {
        b bVar = this.f7689c;
        if (bVar != null) {
            return bVar.f7718i;
        }
        return 0.0f;
    }

    public int F() {
        b bVar = this.f7689c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7713d;
    }

    public b G(int i11) {
        Iterator<b> it2 = this.f7691e.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f7710a == i11) {
                return next;
            }
        }
        return null;
    }

    public List<b> H(int i11) {
        int y11 = y(i11);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it2 = this.f7691e.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f7713d == y11 || next.f7712c == y11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final boolean I(int i11) {
        int i12 = this.f7696j.get(i11);
        int size = this.f7696j.size();
        while (i12 > 0) {
            if (i12 == i11) {
                return true;
            }
            int i13 = size - 1;
            if (size < 0) {
                return true;
            }
            i12 = this.f7696j.get(i12);
            size = i13;
        }
        return false;
    }

    public final boolean J() {
        return this.f7703q != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            r1 = 0
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x000d:
            r3 = 1
            if (r2 == r3) goto L_0x0174
            if (r2 == 0) goto L_0x0162
            r4 = 2
            if (r2 == r4) goto L_0x0017
            goto L_0x0165
        L_0x0017:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            boolean r5 = r8.f7697k     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r5 == 0) goto L_0x0035
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r6.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0035:
            int r5 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r6 = "MotionScene"
            r7 = -1
            switch(r5) {
                case -1349929691: goto L_0x009a;
                case -1239391468: goto L_0x008f;
                case -687739768: goto L_0x0085;
                case 61998586: goto L_0x007a;
                case 269306229: goto L_0x0071;
                case 312750793: goto L_0x0067;
                case 327855227: goto L_0x005d;
                case 793277014: goto L_0x0055;
                case 1382829617: goto L_0x004b;
                case 1942574248: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x00a4
        L_0x0041:
            java.lang.String r3 = "include"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 6
            goto L_0x00a5
        L_0x004b:
            java.lang.String r3 = "StateSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 4
            goto L_0x00a5
        L_0x0055:
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 0
            goto L_0x00a5
        L_0x005d:
            java.lang.String r3 = "OnSwipe"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = r4
            goto L_0x00a5
        L_0x0067:
            java.lang.String r3 = "OnClick"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 3
            goto L_0x00a5
        L_0x0071:
            java.lang.String r4 = "Transition"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x007a:
            java.lang.String r3 = "ViewTransition"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 9
            goto L_0x00a5
        L_0x0085:
            java.lang.String r3 = "Include"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 7
            goto L_0x00a5
        L_0x008f:
            java.lang.String r3 = "KeyFrameSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 8
            goto L_0x00a5
        L_0x009a:
            java.lang.String r3 = "ConstraintSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 5
            goto L_0x00a5
        L_0x00a4:
            r3 = r7
        L_0x00a5:
            switch(r3) {
                case 0: goto L_0x015e;
                case 1: goto L_0x011c;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00b6;
                case 9: goto L_0x00aa;
                default: goto L_0x00a8;
            }     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x00a8:
            goto L_0x0165
        L_0x00aa:
            androidx.constraintlayout.motion.widget.h r2 = new androidx.constraintlayout.motion.widget.h     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.i r3 = r8.f7705s     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r3.a(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00b6:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x0165
            java.util.ArrayList r3 = r1.f7720k     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00c6:
            r8.N(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00cb:
            r8.L(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00d0:
            n0.b r2 = new n0.b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r8.f7688b = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00d9:
            if (r1 == 0) goto L_0x0165
            r1.u(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00e0:
            if (r1 != 0) goto L_0x010f
            android.content.res.Resources r2 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = r2.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = ".xml:"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = ")"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            android.util.Log.v(r6, r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x010f:
            if (r1 == 0) goto L_0x0165
            androidx.constraintlayout.motion.widget.f r2 = new androidx.constraintlayout.motion.widget.f     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f7687a     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.f unused = r1.f7721l = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x011c:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r1 = r8.f7691e     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.e$b r2 = new androidx.constraintlayout.motion.widget.e$b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.e$b r1 = r8.f7689c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r2.f7711b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != 0) goto L_0x0143
            r8.f7689c = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.f r1 = r2.f7721l     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x0143
            androidx.constraintlayout.motion.widget.e$b r1 = r8.f7689c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.f r1 = r1.f7721l     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            boolean r3 = r8.f7704r     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.w(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0143:
            boolean r1 = r2.f7711b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x015c
            int r1 = r2.f7712c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != r7) goto L_0x0152
            r8.f7692f = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0157
        L_0x0152:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r1 = r8.f7693g     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0157:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r1 = r8.f7691e     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x015c:
            r1 = r2
            goto L_0x0165
        L_0x015e:
            r8.O(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x0162:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0165:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x000d
        L_0x016b:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0174
        L_0x0170:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.K(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r8.equals("deriveConstraintsFrom") == false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int L(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.S(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L_0x0011:
            r7 = 1
            if (r4 >= r2) goto L_0x008a
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.f7697k
            if (r10 == 0) goto L_0x0036
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "id string = "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L_0x0036:
            r8.hashCode()
            int r10 = r8.hashCode()
            switch(r10) {
                case -1995929160: goto L_0x0056;
                case -1496482599: goto L_0x004d;
                case 3355: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            r7 = r3
            goto L_0x0060
        L_0x0042:
            java.lang.String r7 = "id"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x004b
            goto L_0x0040
        L_0x004b:
            r7 = 2
            goto L_0x0060
        L_0x004d:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0060
            goto L_0x0040
        L_0x0056:
            java.lang.String r7 = "ConstraintRotate"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            r7 = r1
        L_0x0060:
            switch(r7) {
                case 0: goto L_0x0081;
                case 1: goto L_0x007c;
                case 2: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0087
        L_0x0064:
            int r5 = r13.r(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.f7695i
            java.lang.String r8 = a0(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.c(r14, r5)
            r0.f7990b = r7
            goto L_0x0087
        L_0x007c:
            int r6 = r13.r(r14, r9)
            goto L_0x0087
        L_0x0081:
            int r7 = java.lang.Integer.parseInt(r9)
            r0.f7992d = r7
        L_0x0087:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x008a:
            if (r5 == r3) goto L_0x00a4
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.f7687a
            int r1 = r1.f7561y
            if (r1 == 0) goto L_0x0095
            r0.T(r7)
        L_0x0095:
            r0.E(r14, r15)
            if (r6 == r3) goto L_0x009f
            android.util.SparseIntArray r14 = r13.f7696j
            r14.put(r5, r6)
        L_0x009f:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.f7694h
            r14.put(r5, r0)
        L_0x00a4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.L(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    public final int M(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
            return -1;
        } catch (IOException e12) {
            e12.printStackTrace();
            return -1;
        }
    }

    public final void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.include_constraintSet) {
                M(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i12 = obtainStyledAttributes.getInt(index, this.f7698l);
                this.f7698l = i12;
                if (i12 < 8) {
                    this.f7698l = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f7699m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void P(float f11, float f12) {
        b bVar = this.f7689c;
        if (bVar != null && bVar.f7721l != null) {
            this.f7689c.f7721l.t(f11, f12);
        }
    }

    public void Q(float f11, float f12) {
        b bVar = this.f7689c;
        if (bVar != null && bVar.f7721l != null) {
            this.f7689c.f7721l.u(f11, f12);
        }
    }

    public void R(MotionEvent motionEvent, int i11, MotionLayout motionLayout) {
        MotionLayout.h hVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f7703q == null) {
            this.f7703q = this.f7687a.j0();
        }
        this.f7703q.a(motionEvent);
        if (i11 != -1) {
            int action = motionEvent.getAction();
            boolean z11 = false;
            if (action == 0) {
                this.f7706t = motionEvent.getRawX();
                this.f7707u = motionEvent.getRawY();
                this.f7700n = motionEvent;
                this.f7701o = false;
                if (this.f7689c.f7721l != null) {
                    RectF f11 = this.f7689c.f7721l.f(this.f7687a, rectF);
                    if (f11 == null || f11.contains(this.f7700n.getX(), this.f7700n.getY())) {
                        RectF p11 = this.f7689c.f7721l.p(this.f7687a, rectF);
                        if (p11 == null || p11.contains(this.f7700n.getX(), this.f7700n.getY())) {
                            this.f7702p = false;
                        } else {
                            this.f7702p = true;
                        }
                        this.f7689c.f7721l.v(this.f7706t, this.f7707u);
                        return;
                    }
                    this.f7700n = null;
                    this.f7701o = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.f7701o) {
                float rawY = motionEvent.getRawY() - this.f7707u;
                float rawX = motionEvent.getRawX() - this.f7706t;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.f7700n) != null) {
                    b i12 = i(i11, rawX, rawY, motionEvent2);
                    if (i12 != null) {
                        motionLayout.setTransition(i12);
                        RectF p12 = this.f7689c.f7721l.p(this.f7687a, rectF);
                        if (p12 != null && !p12.contains(this.f7700n.getX(), this.f7700n.getY())) {
                            z11 = true;
                        }
                        this.f7702p = z11;
                        this.f7689c.f7721l.y(this.f7706t, this.f7707u);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.f7701o) {
            b bVar = this.f7689c;
            if (!(bVar == null || bVar.f7721l == null || this.f7702p)) {
                this.f7689c.f7721l.r(motionEvent, this.f7703q, i11, this);
            }
            this.f7706t = motionEvent.getRawX();
            this.f7707u = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (hVar = this.f7703q) != null) {
                hVar.recycle();
                this.f7703q = null;
                int i13 = motionLayout.f7530g;
                if (i13 != -1) {
                    h(motionLayout, i13);
                }
            }
        }
    }

    public final void S(int i11, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.f7694h.get(i11);
        constraintSet.f7991c = constraintSet.f7990b;
        int i12 = this.f7696j.get(i11);
        if (i12 > 0) {
            S(i12, motionLayout);
            ConstraintSet constraintSet2 = this.f7694h.get(i12);
            if (constraintSet2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.c(this.f7687a.getContext(), i12));
                return;
            }
            constraintSet.f7991c += "/" + constraintSet2.f7991c;
            constraintSet.M(constraintSet2);
        } else {
            constraintSet.f7991c += "  layout";
            constraintSet.L(motionLayout);
        }
        constraintSet.h(constraintSet);
    }

    public void T(MotionLayout motionLayout) {
        int i11 = 0;
        while (i11 < this.f7694h.size()) {
            int keyAt = this.f7694h.keyAt(i11);
            if (I(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            } else {
                S(keyAt, motionLayout);
                i11++;
            }
        }
    }

    public void U(int i11, ConstraintSet constraintSet) {
        this.f7694h.put(i11, constraintSet);
    }

    public void V(int i11) {
        b bVar = this.f7689c;
        if (bVar != null) {
            bVar.E(i11);
        } else {
            this.f7698l = i11;
        }
    }

    public void W(boolean z11) {
        this.f7704r = z11;
        b bVar = this.f7689c;
        if (bVar != null && bVar.f7721l != null) {
            this.f7689c.f7721l.w(this.f7704r);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X(int r7, int r8) {
        /*
            r6 = this;
            n0.b r0 = r6.f7688b
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            n0.b r2 = r6.f7688b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            androidx.constraintlayout.motion.widget.e$b r3 = r6.f7689c
            if (r3 == 0) goto L_0x002b
            int r3 = r3.f7712c
            if (r3 != r8) goto L_0x002b
            androidx.constraintlayout.motion.widget.e$b r3 = r6.f7689c
            int r3 = r3.f7713d
            if (r3 != r7) goto L_0x002b
            return
        L_0x002b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r3 = r6.f7691e
            java.util.Iterator r3 = r3.iterator()
        L_0x0031:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.e$b r4 = (androidx.constraintlayout.motion.widget.e.b) r4
            int r5 = r4.f7712c
            if (r5 != r2) goto L_0x0049
            int r5 = r4.f7713d
            if (r5 == r0) goto L_0x0055
        L_0x0049:
            int r5 = r4.f7712c
            if (r5 != r8) goto L_0x0031
            int r5 = r4.f7713d
            if (r5 != r7) goto L_0x0031
        L_0x0055:
            r6.f7689c = r4
            if (r4 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.f r7 = r4.f7721l
            if (r7 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.e$b r7 = r6.f7689c
            androidx.constraintlayout.motion.widget.f r7 = r7.f7721l
            boolean r8 = r6.f7704r
            r7.w(r8)
        L_0x006a:
            return
        L_0x006b:
            androidx.constraintlayout.motion.widget.e$b r7 = r6.f7692f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r3 = r6.f7693g
            java.util.Iterator r3 = r3.iterator()
        L_0x0073:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.e$b r4 = (androidx.constraintlayout.motion.widget.e.b) r4
            int r5 = r4.f7712c
            if (r5 != r8) goto L_0x0073
            r7 = r4
            goto L_0x0073
        L_0x0087:
            androidx.constraintlayout.motion.widget.e$b r8 = new androidx.constraintlayout.motion.widget.e$b
            r8.<init>(r6, r7)
            int unused = r8.f7713d = r0
            int unused = r8.f7712c = r2
            if (r0 == r1) goto L_0x0099
            java.util.ArrayList<androidx.constraintlayout.motion.widget.e$b> r7 = r6.f7691e
            r7.add(r8)
        L_0x0099:
            r6.f7689c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.X(int, int):void");
    }

    public void Y(b bVar) {
        this.f7689c = bVar;
        if (bVar != null && bVar.f7721l != null) {
            this.f7689c.f7721l.w(this.f7704r);
        }
    }

    public void Z() {
        b bVar = this.f7689c;
        if (bVar != null && bVar.f7721l != null) {
            this.f7689c.f7721l.z();
        }
    }

    public boolean b0() {
        Iterator<b> it2 = this.f7691e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f7721l != null) {
                return true;
            }
        }
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return false;
        }
        return true;
    }

    public void c0(int i11, View... viewArr) {
        this.f7705s.i(i11, viewArr);
    }

    public void f(MotionLayout motionLayout, int i11) {
        Iterator<b> it2 = this.f7691e.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f7722m.size() > 0) {
                Iterator it3 = next.f7722m.iterator();
                while (it3.hasNext()) {
                    ((b.a) it3.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it4 = this.f7693g.iterator();
        while (it4.hasNext()) {
            b next2 = it4.next();
            if (next2.f7722m.size() > 0) {
                Iterator it5 = next2.f7722m.iterator();
                while (it5.hasNext()) {
                    ((b.a) it5.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it6 = this.f7691e.iterator();
        while (it6.hasNext()) {
            b next3 = it6.next();
            if (next3.f7722m.size() > 0) {
                Iterator it7 = next3.f7722m.iterator();
                while (it7.hasNext()) {
                    ((b.a) it7.next()).a(motionLayout, i11, next3);
                }
            }
        }
        Iterator<b> it8 = this.f7693g.iterator();
        while (it8.hasNext()) {
            b next4 = it8.next();
            if (next4.f7722m.size() > 0) {
                Iterator it9 = next4.f7722m.iterator();
                while (it9.hasNext()) {
                    ((b.a) it9.next()).a(motionLayout, i11, next4);
                }
            }
        }
    }

    public boolean g(int i11, d dVar) {
        return this.f7705s.d(i11, dVar);
    }

    public boolean h(MotionLayout motionLayout, int i11) {
        b bVar;
        if (J() || this.f7690d) {
            return false;
        }
        Iterator<b> it2 = this.f7691e.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f7723n != 0 && ((bVar = this.f7689c) != next || !bVar.D(2))) {
                if (i11 == next.f7713d && (next.f7723n == 4 || next.f7723n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.f7723n == 4) {
                        motionLayout.s0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.W(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.k0();
                    }
                    return true;
                } else if (i11 == next.f7712c && (next.f7723n == 3 || next.f7723n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.f7723n == 3) {
                        motionLayout.u0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.W(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.k0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i11, float f11, float f12, MotionEvent motionEvent) {
        RectF f13;
        int i12 = i11;
        float f14 = f11;
        float f15 = f12;
        if (i12 == -1) {
            return this.f7689c;
        }
        List<b> H = H(i11);
        float f16 = 0.0f;
        b bVar = null;
        RectF rectF = new RectF();
        for (b next : H) {
            if (!next.f7724o && next.f7721l != null) {
                next.f7721l.w(this.f7704r);
                RectF p11 = next.f7721l.p(this.f7687a, rectF);
                if ((p11 == null || motionEvent == null || p11.contains(motionEvent.getX(), motionEvent.getY())) && ((f13 = next.f7721l.f(this.f7687a, rectF)) == null || motionEvent == null || f13.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a11 = next.f7721l.a(f14, f15);
                    if (next.f7721l.f7742l && motionEvent != null) {
                        float x11 = motionEvent.getX() - next.f7721l.f7739i;
                        float y11 = motionEvent.getY() - next.f7721l.f7740j;
                        a11 = ((float) (Math.atan2((double) (f15 + y11), (double) (f14 + x11)) - Math.atan2((double) x11, (double) y11))) * 10.0f;
                    }
                    float f17 = a11 * (next.f7712c == i12 ? -1.0f : 1.1f);
                    if (f17 > f16) {
                        bVar = next;
                        f16 = f17;
                    }
                }
            }
        }
        return bVar;
    }

    public int j() {
        b bVar = this.f7689c;
        if (bVar != null) {
            return bVar.f7725p;
        }
        return -1;
    }

    public int k() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0;
        }
        return this.f7689c.f7721l.d();
    }

    public ConstraintSet l(int i11) {
        return m(i11, -1, -1);
    }

    public ConstraintSet m(int i11, int i12, int i13) {
        int c11;
        if (this.f7697k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i11);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.f7694h.size());
        }
        n0.b bVar = this.f7688b;
        if (!(bVar == null || (c11 = bVar.c(i11, i12, i13)) == -1)) {
            i11 = c11;
        }
        if (this.f7694h.get(i11) != null) {
            return this.f7694h.get(i11);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.c(this.f7687a.getContext(), i11) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.f7694h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] n() {
        int size = this.f7694h.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = this.f7694h.keyAt(i11);
        }
        return iArr;
    }

    public ArrayList<b> o() {
        return this.f7691e;
    }

    public int p() {
        b bVar = this.f7689c;
        if (bVar != null) {
            return bVar.f7717h;
        }
        return this.f7698l;
    }

    public int q() {
        b bVar = this.f7689c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7712c;
    }

    public final int r(Context context, String str) {
        int i11;
        if (str.contains("/")) {
            i11 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f7697k) {
                System.out.println("id getMap res = " + i11);
            }
        } else {
            i11 = -1;
        }
        if (i11 != -1) {
            return i11;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i11;
    }

    public Interpolator s() {
        int g11 = this.f7689c.f7714e;
        if (g11 == -2) {
            return AnimationUtils.loadInterpolator(this.f7687a.getContext(), this.f7689c.f7716g);
        }
        if (g11 == -1) {
            return new a(Easing.c(this.f7689c.f7715f));
        }
        if (g11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (g11 == 1) {
            return new AccelerateInterpolator();
        }
        if (g11 == 2) {
            return new DecelerateInterpolator();
        }
        if (g11 == 4) {
            return new BounceInterpolator();
        }
        if (g11 == 5) {
            return new OvershootInterpolator();
        }
        if (g11 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public void t(d dVar) {
        b bVar = this.f7689c;
        if (bVar == null) {
            b bVar2 = this.f7692f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f7720k.iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).b(dVar);
                }
                return;
            }
            return;
        }
        Iterator it3 = bVar.f7720k.iterator();
        while (it3.hasNext()) {
            ((KeyFrames) it3.next()).b(dVar);
        }
    }

    public float u() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.g();
    }

    public float v() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.h();
    }

    public boolean w() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return false;
        }
        return this.f7689c.f7721l.i();
    }

    public float x(float f11, float f12) {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0.0f;
        }
        return this.f7689c.f7721l.j(f11, f12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.c(r3, -1, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int y(int r3) {
        /*
            r2 = this;
            n0.b r0 = r2.f7688b
            if (r0 == 0) goto L_0x000c
            r1 = -1
            int r0 = r0.c(r3, r1, r1)
            if (r0 == r1) goto L_0x000c
            return r0
        L_0x000c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.y(int):int");
    }

    public int z() {
        b bVar = this.f7689c;
        if (bVar == null || bVar.f7721l == null) {
            return 0;
        }
        return this.f7689c.f7721l.k();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7710a = -1;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7711b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f7712c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f7713d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f7714e = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f7715f = null;

        /* renamed from: g  reason: collision with root package name */
        public int f7716g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f7717h = 400;

        /* renamed from: i  reason: collision with root package name */
        public float f7718i = 0.0f;

        /* renamed from: j  reason: collision with root package name */
        public final e f7719j;

        /* renamed from: k  reason: collision with root package name */
        public ArrayList<KeyFrames> f7720k = new ArrayList<>();

        /* renamed from: l  reason: collision with root package name */
        public f f7721l = null;

        /* renamed from: m  reason: collision with root package name */
        public ArrayList<a> f7722m = new ArrayList<>();

        /* renamed from: n  reason: collision with root package name */
        public int f7723n = 0;

        /* renamed from: o  reason: collision with root package name */
        public boolean f7724o = false;

        /* renamed from: p  reason: collision with root package name */
        public int f7725p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f7726q = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f7727r = 0;

        public static class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final b f7728b;

            /* renamed from: c  reason: collision with root package name */
            public int f7729c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f7730d = 17;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f7728b = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i11 = 0; i11 < indexCount; i11++) {
                    int index = obtainStyledAttributes.getIndex(i11);
                    if (index == R$styleable.OnClick_targetId) {
                        this.f7729c = obtainStyledAttributes.getResourceId(index, this.f7729c);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.f7730d = obtainStyledAttributes.getInt(index, this.f7730d);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i11, b bVar) {
                int i12 = this.f7729c;
                View view = motionLayout;
                if (i12 != -1) {
                    view = motionLayout.findViewById(i12);
                }
                if (view == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f7729c);
                    return;
                }
                int c11 = bVar.f7713d;
                int a11 = bVar.f7712c;
                if (c11 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i13 = this.f7730d;
                boolean z11 = false;
                boolean z12 = ((i13 & 1) != 0 && i11 == c11) | ((i13 & 1) != 0 && i11 == c11) | ((i13 & 256) != 0 && i11 == c11) | ((i13 & 16) != 0 && i11 == a11);
                if ((i13 & 4096) != 0 && i11 == a11) {
                    z11 = true;
                }
                if (z12 || z11) {
                    view.setOnClickListener(this);
                }
            }

            public boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f7728b;
                if (bVar2 == bVar) {
                    return true;
                }
                int a11 = bVar2.f7712c;
                int c11 = this.f7728b.f7713d;
                if (c11 != -1) {
                    int i11 = motionLayout.f7530g;
                    if (i11 == c11 || i11 == a11) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.f7530g != a11) {
                    return true;
                } else {
                    return false;
                }
            }

            public void c(MotionLayout motionLayout) {
                int i11 = this.f7729c;
                if (i11 != -1) {
                    View findViewById = motionLayout.findViewById(i11);
                    if (findViewById == null) {
                        Log.e("MotionScene", " (*)  could not find id " + this.f7729c);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
            /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.e$b r8 = r7.f7728b
                    androidx.constraintlayout.motion.widget.e r8 = r8.f7719j
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.f7687a
                    boolean r0 = r8.i0()
                    if (r0 != 0) goto L_0x0011
                    return
                L_0x0011:
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    int r0 = r0.f7713d
                    r1 = -1
                    if (r0 != r1) goto L_0x004a
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002a
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    int r0 = r0.f7712c
                    r8.v0(r0)
                    return
                L_0x002a:
                    androidx.constraintlayout.motion.widget.e$b r1 = new androidx.constraintlayout.motion.widget.e$b
                    androidx.constraintlayout.motion.widget.e$b r2 = r7.f7728b
                    androidx.constraintlayout.motion.widget.e r2 = r2.f7719j
                    androidx.constraintlayout.motion.widget.e$b r3 = r7.f7728b
                    r1.<init>(r2, r3)
                    int unused = r1.f7713d = r0
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    int r0 = r0.f7712c
                    int unused = r1.f7712c = r0
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r1)
                    r8.s0()
                    return
                L_0x004a:
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    androidx.constraintlayout.motion.widget.e r0 = r0.f7719j
                    androidx.constraintlayout.motion.widget.e$b r0 = r0.f7689c
                    int r1 = r7.f7730d
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0061
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x005f
                    goto L_0x0061
                L_0x005f:
                    r2 = r3
                    goto L_0x0062
                L_0x0061:
                    r2 = r4
                L_0x0062:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006d
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006b
                    goto L_0x006d
                L_0x006b:
                    r1 = r3
                    goto L_0x006e
                L_0x006d:
                    r1 = r4
                L_0x006e:
                    if (r2 == 0) goto L_0x0074
                    if (r1 == 0) goto L_0x0074
                    r5 = r4
                    goto L_0x0075
                L_0x0074:
                    r5 = r3
                L_0x0075:
                    if (r5 == 0) goto L_0x009c
                    androidx.constraintlayout.motion.widget.e$b r5 = r7.f7728b
                    androidx.constraintlayout.motion.widget.e r5 = r5.f7719j
                    androidx.constraintlayout.motion.widget.e$b r5 = r5.f7689c
                    androidx.constraintlayout.motion.widget.e$b r6 = r7.f7728b
                    if (r5 == r6) goto L_0x0086
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r6)
                L_0x0086:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x009d
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x009b
                    goto L_0x009d
                L_0x009b:
                    r1 = r3
                L_0x009c:
                    r3 = r2
                L_0x009d:
                    boolean r0 = r7.b(r0, r8)
                    if (r0 == 0) goto L_0x00e8
                    if (r3 == 0) goto L_0x00b3
                    int r0 = r7.f7730d
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00b3
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r0)
                    r8.s0()
                    goto L_0x00e8
                L_0x00b3:
                    if (r1 == 0) goto L_0x00c4
                    int r0 = r7.f7730d
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00c4
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r0)
                    r8.u0()
                    goto L_0x00e8
                L_0x00c4:
                    if (r3 == 0) goto L_0x00d7
                    int r0 = r7.f7730d
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d7
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r0)
                    r0 = 1065353216(0x3f800000, float:1.0)
                    r8.setProgress(r0)
                    goto L_0x00e8
                L_0x00d7:
                    if (r1 == 0) goto L_0x00e8
                    int r0 = r7.f7730d
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e8
                    androidx.constraintlayout.motion.widget.e$b r0 = r7.f7728b
                    r8.setTransition((androidx.constraintlayout.motion.widget.e.b) r0)
                    r0 = 0
                    r8.setProgress(r0)
                L_0x00e8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.b.a.onClick(android.view.View):void");
            }
        }

        public b(e eVar, b bVar) {
            this.f7719j = eVar;
            this.f7717h = eVar.f7698l;
            if (bVar != null) {
                this.f7725p = bVar.f7725p;
                this.f7714e = bVar.f7714e;
                this.f7715f = bVar.f7715f;
                this.f7716g = bVar.f7716g;
                this.f7717h = bVar.f7717h;
                this.f7720k = bVar.f7720k;
                this.f7718i = bVar.f7718i;
                this.f7726q = bVar.f7726q;
            }
        }

        public int A() {
            return this.f7713d;
        }

        public f B() {
            return this.f7721l;
        }

        public boolean C() {
            return !this.f7724o;
        }

        public boolean D(int i11) {
            return (i11 & this.f7727r) != 0;
        }

        public void E(int i11) {
            this.f7717h = Math.max(i11, 8);
        }

        public void F(boolean z11) {
            this.f7724o = !z11;
        }

        public void G(int i11, String str, int i12) {
            this.f7714e = i11;
            this.f7715f = str;
            this.f7716g = i12;
        }

        public void H(int i11) {
            f B = B();
            if (B != null) {
                B.x(i11);
            }
        }

        public void I(int i11) {
            this.f7725p = i11;
        }

        public void t(KeyFrames keyFrames) {
            this.f7720k.add(keyFrames);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f7722m.add(new a(context, this, xmlPullParser));
        }

        public final void v(e eVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.f7712c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7712c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.D(context, this.f7712c);
                        eVar.f7694h.append(this.f7712c, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f7712c = eVar.M(context, this.f7712c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.f7713d = typedArray.getResourceId(index, this.f7713d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f7713d);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.D(context, this.f7713d);
                        eVar.f7694h.append(this.f7713d, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f7713d = eVar.M(context, this.f7713d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f7716g = resourceId;
                        if (resourceId != -1) {
                            this.f7714e = -2;
                        }
                    } else if (i12 == 3) {
                        String string = typedArray.getString(index);
                        this.f7715f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f7716g = typedArray.getResourceId(index, -1);
                                this.f7714e = -2;
                            } else {
                                this.f7714e = -1;
                            }
                        }
                    } else {
                        this.f7714e = typedArray.getInteger(index, this.f7714e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i13 = typedArray.getInt(index, this.f7717h);
                    this.f7717h = i13;
                    if (i13 < 8) {
                        this.f7717h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.f7718i = typedArray.getFloat(index, this.f7718i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.f7723n = typedArray.getInteger(index, this.f7723n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.f7710a = typedArray.getResourceId(index, this.f7710a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.f7724o = typedArray.getBoolean(index, this.f7724o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.f7725p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f7726q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.f7727r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f7713d == -1) {
                this.f7711b = true;
            }
        }

        public final void w(e eVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            v(eVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int x() {
            return this.f7723n;
        }

        public int y() {
            return this.f7712c;
        }

        public int z() {
            return this.f7726q;
        }

        public b(int i11, e eVar, int i12, int i13) {
            this.f7710a = i11;
            this.f7719j = eVar;
            this.f7713d = i12;
            this.f7712c = i13;
            this.f7717h = eVar.f7698l;
            this.f7726q = eVar.f7699m;
        }

        public b(e eVar, Context context, XmlPullParser xmlPullParser) {
            this.f7717h = eVar.f7698l;
            this.f7726q = eVar.f7699m;
            this.f7719j = eVar;
            w(eVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}

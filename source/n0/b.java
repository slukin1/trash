package n0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f16170a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f16171b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f16172c = -1;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<a> f16173d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<ConstraintSet> f16174e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public ConstraintsChangedListener f16175f = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f16176a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C0092b> f16177b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f16178c = -1;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16179d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f16179d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f16176a = obtainStyledAttributes.getResourceId(index, this.f16176a);
                } else if (index == R$styleable.State_constraints) {
                    this.f16178c = obtainStyledAttributes.getResourceId(index, this.f16178c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f16178c);
                    context.getResources().getResourceName(this.f16178c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f16179d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(C0092b bVar) {
            this.f16177b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f16177b.size(); i11++) {
                if (this.f16177b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    /* renamed from: n0.b$b  reason: collision with other inner class name */
    public static class C0092b {

        /* renamed from: a  reason: collision with root package name */
        public float f16180a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f16181b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public float f16182c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f16183d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f16184e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16185f;

        public C0092b(Context context, XmlPullParser xmlPullParser) {
            this.f16185f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f16184e = obtainStyledAttributes.getResourceId(index, this.f16184e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f16184e);
                    context.getResources().getResourceName(this.f16184e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f16185f = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f16183d = obtainStyledAttributes.getDimension(index, this.f16183d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f16181b = obtainStyledAttributes.getDimension(index, this.f16181b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f16182c = obtainStyledAttributes.getDimension(index, this.f16182c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f16180a = obtainStyledAttributes.getDimension(index, this.f16180a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f16180a) && f11 < this.f16180a) {
                return false;
            }
            if (!Float.isNaN(this.f16181b) && f12 < this.f16181b) {
                return false;
            }
            if (!Float.isNaN(this.f16182c) && f11 > this.f16182c) {
                return false;
            }
            if (Float.isNaN(this.f16183d) || f12 <= this.f16183d) {
                return true;
            }
            return false;
        }
    }

    public b(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    public int a(int i11, int i12, float f11, float f12) {
        a aVar = this.f16173d.get(i12);
        if (aVar == null) {
            return i12;
        }
        if (f11 != -1.0f && f12 != -1.0f) {
            C0092b bVar = null;
            Iterator<C0092b> it2 = aVar.f16177b.iterator();
            while (it2.hasNext()) {
                C0092b next = it2.next();
                if (next.a(f11, f12)) {
                    if (i11 == next.f16184e) {
                        return i11;
                    }
                    bVar = next;
                }
            }
            if (bVar != null) {
                return bVar.f16184e;
            }
            return aVar.f16178c;
        } else if (aVar.f16178c == i11) {
            return i11;
        } else {
            Iterator<C0092b> it3 = aVar.f16177b.iterator();
            while (it3.hasNext()) {
                if (i11 == it3.next().f16184e) {
                    return i11;
                }
            }
            return aVar.f16178c;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)
            int[] r1 = androidx.constraintlayout.widget.R$styleable.StateSet
            android.content.res.TypedArray r0 = r10.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R$styleable.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r9.f16170a
            int r4 = r0.getResourceId(r4, r5)
            r9.f16170a = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            r0.recycle()
            r0 = 0
            int r1 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x002d:
            r3 = 1
            if (r1 == r3) goto L_0x00a8
            if (r1 == 0) goto L_0x0097
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r1 == r6) goto L_0x0047
            if (r1 == r5) goto L_0x003c
            goto L_0x009a
        L_0x003c:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            boolean r1 = r4.equals(r1)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x009a
            return
        L_0x0047:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r7 = -1
            int r8 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            switch(r8) {
                case 80204913: goto L_0x006f;
                case 1301459538: goto L_0x0065;
                case 1382829617: goto L_0x005e;
                case 1901439077: goto L_0x0054;
                default: goto L_0x0053;
            }     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x0053:
            goto L_0x0079
        L_0x0054:
            java.lang.String r3 = "Variant"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r5
            goto L_0x007a
        L_0x005e:
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0065:
            java.lang.String r3 = "LayoutDescription"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r2
            goto L_0x007a
        L_0x006f:
            java.lang.String r3 = "State"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r6
            goto L_0x007a
        L_0x0079:
            r3 = r7
        L_0x007a:
            if (r3 == r6) goto L_0x008a
            if (r3 == r5) goto L_0x007f
            goto L_0x009a
        L_0x007f:
            n0.b$b r1 = new n0.b$b     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r0 == 0) goto L_0x009a
            r0.a(r1)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x008a:
            n0.b$a r0 = new n0.b$a     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r0.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            android.util.SparseArray<n0.b$a> r1 = r9.f16173d     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r3 = r0.f16176a     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.put(r3, r0)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x0097:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x009a:
            int r1 = r11.next()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x002d
        L_0x009f:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00a8
        L_0x00a4:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.b.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int c(int i11, int i12, int i13) {
        return d(-1, i11, (float) i12, (float) i13);
    }

    public int d(int i11, int i12, float f11, float f12) {
        a aVar;
        int b11;
        if (i11 == i12) {
            if (i12 == -1) {
                aVar = this.f16173d.valueAt(0);
            } else {
                aVar = this.f16173d.get(this.f16171b);
            }
            if (aVar == null) {
                return -1;
            }
            if ((this.f16172c == -1 || !aVar.f16177b.get(i11).a(f11, f12)) && i11 != (b11 = aVar.b(f11, f12))) {
                return b11 == -1 ? aVar.f16178c : aVar.f16177b.get(b11).f16184e;
            }
            return i11;
        }
        a aVar2 = this.f16173d.get(i12);
        if (aVar2 == null) {
            return -1;
        }
        int b12 = aVar2.b(f11, f12);
        return b12 == -1 ? aVar2.f16178c : aVar2.f16177b.get(b12).f16184e;
    }
}

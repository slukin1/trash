package n0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16153a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintSet f16154b;

    /* renamed from: c  reason: collision with root package name */
    public int f16155c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f16156d = -1;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<C0091a> f16157e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<ConstraintSet> f16158f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public ConstraintsChangedListener f16159g = null;

    /* renamed from: n0.a$a  reason: collision with other inner class name */
    public static class C0091a {

        /* renamed from: a  reason: collision with root package name */
        public int f16160a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<b> f16161b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f16162c = -1;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintSet f16163d;

        public C0091a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f16160a = obtainStyledAttributes.getResourceId(index, this.f16160a);
                } else if (index == R$styleable.State_constraints) {
                    this.f16162c = obtainStyledAttributes.getResourceId(index, this.f16162c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f16162c);
                    context.getResources().getResourceName(this.f16162c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f16163d = constraintSet;
                        constraintSet.o(context, this.f16162c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f16161b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f16161b.size(); i11++) {
                if (this.f16161b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f16164a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f16165b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public float f16166c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f16167d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f16168e = -1;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintSet f16169f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f16168e = obtainStyledAttributes.getResourceId(index, this.f16168e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f16168e);
                    context.getResources().getResourceName(this.f16168e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f16169f = constraintSet;
                        constraintSet.o(context, this.f16168e);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f16167d = obtainStyledAttributes.getDimension(index, this.f16167d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f16165b = obtainStyledAttributes.getDimension(index, this.f16165b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f16166c = obtainStyledAttributes.getDimension(index, this.f16166c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f16164a = obtainStyledAttributes.getDimension(index, this.f16164a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f16164a) && f11 < this.f16164a) {
                return false;
            }
            if (!Float.isNaN(this.f16165b) && f12 < this.f16165b) {
                return false;
            }
            if (!Float.isNaN(this.f16166c) && f11 > this.f16166c) {
                return false;
            }
            if (Float.isNaN(this.f16167d) || f12 <= this.f16167d) {
                return true;
            }
            return false;
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i11) {
        this.f16153a = constraintLayout;
        a(context, i11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)
            r0 = 0
            int r1 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x000d:
            r2 = 1
            if (r1 == r2) goto L_0x008c
            if (r1 == 0) goto L_0x007b
            r3 = 2
            if (r1 == r3) goto L_0x0017
            goto L_0x007e
        L_0x0017:
            java.lang.String r1 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r4 = -1
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r6 = 4
            r7 = 3
            switch(r5) {
                case -1349929691: goto L_0x004d;
                case 80204913: goto L_0x0043;
                case 1382829617: goto L_0x003a;
                case 1657696882: goto L_0x0030;
                case 1901439077: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x0025:
            goto L_0x0057
        L_0x0026:
            java.lang.String r2 = "Variant"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r7
            goto L_0x0058
        L_0x0030:
            java.lang.String r2 = "layoutDescription"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = 0
            goto L_0x0058
        L_0x003a:
            java.lang.String r5 = "StateSet"
            boolean r1 = r1.equals(r5)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0043:
            java.lang.String r2 = "State"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r3
            goto L_0x0058
        L_0x004d:
            java.lang.String r2 = "ConstraintSet"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r6
            goto L_0x0058
        L_0x0057:
            r2 = r4
        L_0x0058:
            if (r2 == r3) goto L_0x006e
            if (r2 == r7) goto L_0x0063
            if (r2 == r6) goto L_0x005f
            goto L_0x007e
        L_0x005f:
            r8.b(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x0063:
            n0.a$b r1 = new n0.a$b     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r0 == 0) goto L_0x007e
            r0.a(r1)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x006e:
            n0.a$a r0 = new n0.a$a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            android.util.SparseArray<n0.a$a> r1 = r8.f16157e     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            int r2 = r0.f16160a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.put(r2, r0)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x007b:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x007e:
            int r1 = r10.next()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x000d
        L_0x0083:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x008c
        L_0x0088:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.a.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        int i11;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i12 = 0;
        while (i12 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i12++;
            } else {
                if (attributeValue.contains("/")) {
                    i11 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i11 = -1;
                }
                if (i11 == -1) {
                    if (attributeValue.length() > 1) {
                        i11 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.E(context, xmlPullParser);
                this.f16158f.put(i11, constraintSet);
                return;
            }
        }
    }

    public void c(ConstraintsChangedListener constraintsChangedListener) {
        this.f16159g = constraintsChangedListener;
    }

    public void d(int i11, float f11, float f12) {
        ConstraintSet constraintSet;
        int i12;
        C0091a aVar;
        int b11;
        ConstraintSet constraintSet2;
        int i13;
        int i14 = this.f16155c;
        if (i14 == i11) {
            if (i11 == -1) {
                aVar = this.f16157e.valueAt(0);
            } else {
                aVar = this.f16157e.get(i14);
            }
            int i15 = this.f16156d;
            if ((i15 == -1 || !aVar.f16161b.get(i15).a(f11, f12)) && this.f16156d != (b11 = aVar.b(f11, f12))) {
                if (b11 == -1) {
                    constraintSet2 = this.f16154b;
                } else {
                    constraintSet2 = aVar.f16161b.get(b11).f16169f;
                }
                if (b11 == -1) {
                    i13 = aVar.f16162c;
                } else {
                    i13 = aVar.f16161b.get(b11).f16168e;
                }
                if (constraintSet2 != null) {
                    this.f16156d = b11;
                    ConstraintsChangedListener constraintsChangedListener = this.f16159g;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.b(-1, i13);
                    }
                    constraintSet2.i(this.f16153a);
                    ConstraintsChangedListener constraintsChangedListener2 = this.f16159g;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.a(-1, i13);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f16155c = i11;
        C0091a aVar2 = this.f16157e.get(i11);
        int b12 = aVar2.b(f11, f12);
        if (b12 == -1) {
            constraintSet = aVar2.f16163d;
        } else {
            constraintSet = aVar2.f16161b.get(b12).f16169f;
        }
        if (b12 == -1) {
            i12 = aVar2.f16162c;
        } else {
            i12 = aVar2.f16161b.get(b12).f16168e;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i11 + ", dim =" + f11 + ", " + f12);
            return;
        }
        this.f16156d = b12;
        ConstraintsChangedListener constraintsChangedListener3 = this.f16159g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.b(i11, i12);
        }
        constraintSet.i(this.f16153a);
        ConstraintsChangedListener constraintsChangedListener4 = this.f16159g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.a(i11, i12);
        }
    }
}

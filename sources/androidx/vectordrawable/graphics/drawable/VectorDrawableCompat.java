package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import com.tencent.imsdk.v2.V2TIMConversation;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.i;
import t0.f;

public class VectorDrawableCompat extends f {

    /* renamed from: l  reason: collision with root package name */
    public static final PorterDuff.Mode f11909l = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public VectorDrawableCompatState f11910c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f11911d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f11912e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11913f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11914g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable.ConstantState f11915h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f11916i;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f11917j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f11918k;

    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f11953a;

        /* renamed from: b  reason: collision with root package name */
        public VPathRenderer f11954b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f11955c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f11956d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11957e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f11958f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f11959g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f11960h;

        /* renamed from: i  reason: collision with root package name */
        public int f11961i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f11962j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f11963k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f11964l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f11955c = null;
            this.f11956d = VectorDrawableCompat.f11909l;
            if (vectorDrawableCompatState != null) {
                this.f11953a = vectorDrawableCompatState.f11953a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f11954b);
                this.f11954b = vPathRenderer;
                if (vectorDrawableCompatState.f11954b.f11941e != null) {
                    vPathRenderer.f11941e = new Paint(vectorDrawableCompatState.f11954b.f11941e);
                }
                if (vectorDrawableCompatState.f11954b.f11940d != null) {
                    this.f11954b.f11940d = new Paint(vectorDrawableCompatState.f11954b.f11940d);
                }
                this.f11955c = vectorDrawableCompatState.f11955c;
                this.f11956d = vectorDrawableCompatState.f11956d;
                this.f11957e = vectorDrawableCompatState.f11957e;
            }
        }

        public boolean a(int i11, int i12) {
            return i11 == this.f11958f.getWidth() && i12 == this.f11958f.getHeight();
        }

        public boolean b() {
            return !this.f11963k && this.f11959g == this.f11955c && this.f11960h == this.f11956d && this.f11962j == this.f11957e && this.f11961i == this.f11954b.getRootAlpha();
        }

        public void c(int i11, int i12) {
            if (this.f11958f == null || !a(i11, i12)) {
                this.f11958f = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
                this.f11963k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f11958f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f11964l == null) {
                Paint paint = new Paint();
                this.f11964l = paint;
                paint.setFilterBitmap(true);
            }
            this.f11964l.setAlpha(this.f11954b.getRootAlpha());
            this.f11964l.setColorFilter(colorFilter);
            return this.f11964l;
        }

        public boolean f() {
            return this.f11954b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f11954b.f();
        }

        public int getChangingConfigurations() {
            return this.f11953a;
        }

        public boolean h(int[] iArr) {
            boolean g11 = this.f11954b.g(iArr);
            this.f11963k |= g11;
            return g11;
        }

        public void i() {
            this.f11959g = this.f11955c;
            this.f11960h = this.f11956d;
            this.f11961i = this.f11954b.getRootAlpha();
            this.f11962j = this.f11957e;
            this.f11963k = false;
        }

        public void j(int i11, int i12) {
            this.f11958f.eraseColor(0);
            this.f11954b.b(new Canvas(this.f11958f), i11, i12, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f11955c = null;
            this.f11956d = VectorDrawableCompat.f11909l;
            this.f11954b = new VPathRenderer();
        }
    }

    public static class b extends VPath {
        public b() {
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (i.j(xmlPullParser, "pathData")) {
                TypedArray k11 = i.k(resources, theme, attributeSet, a.f11981d);
                f(k11, xmlPullParser);
                k11.recycle();
            }
        }

        public final void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11933b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f11932a = f.d(string2);
            }
            this.f11934c = i.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class d {
        public d() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public VectorDrawableCompat() {
        this.f11914g = true;
        this.f11916i = new float[9];
        this.f11917j = new Matrix();
        this.f11918k = new Rect();
        this.f11910c = new VectorDrawableCompatState();
    }

    public static int a(int i11, float f11) {
        return (i11 & FlexItem.MAX_SIZE) | (((int) (((float) Color.alpha(i11)) * f11)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.f(r6, r7, r8)
            r0.f12008b = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$e r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$e
            android.graphics.drawable.Drawable r7 = r0.f12008b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f11915h = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    public static PorterDuff.Mode g(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f12008b;
        if (drawable == null) {
            return false;
        }
        u0.a.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public Object d(String str) {
        return this.f11910c.f11954b.f11952p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f11918k);
        if (this.f11918k.width() > 0 && this.f11918k.height() > 0) {
            ColorFilter colorFilter = this.f11912e;
            if (colorFilter == null) {
                colorFilter = this.f11911d;
            }
            canvas.getMatrix(this.f11917j);
            this.f11917j.getValues(this.f11916i);
            float abs = Math.abs(this.f11916i[0]);
            float abs2 = Math.abs(this.f11916i[4]);
            float abs3 = Math.abs(this.f11916i[1]);
            float abs4 = Math.abs(this.f11916i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f11918k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f11918k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f11918k;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f11918k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f11918k.offsetTo(0, 0);
                this.f11910c.c(min, min2);
                if (!this.f11914g) {
                    this.f11910c.j(min, min2);
                } else if (!this.f11910c.b()) {
                    this.f11910c.j(min, min2);
                    this.f11910c.i();
                }
                this.f11910c.d(canvas, colorFilter, this.f11918k);
                canvas.restoreToCount(save);
            }
        }
    }

    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f11954b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f11944h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z11 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11920b.add(cVar);
                    if (cVar.getPathName() != null) {
                        vPathRenderer.f11952p.put(cVar.getPathName(), cVar);
                    }
                    z11 = false;
                    vectorDrawableCompatState.f11953a = cVar.f11935d | vectorDrawableCompatState.f11953a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11920b.add(bVar);
                    if (bVar.getPathName() != null) {
                        vPathRenderer.f11952p.put(bVar.getPathName(), bVar);
                    }
                    vectorDrawableCompatState.f11953a = bVar.f11935d | vectorDrawableCompatState.f11953a;
                } else if (V2TIMConversation.CONVERSATION_GROUP_TYPE.equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11920b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f11952p.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f11953a = vGroup2.f11929k | vectorDrawableCompatState.f11953a;
                }
            } else if (eventType == 3 && V2TIMConversation.CONVERSATION_GROUP_TYPE.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z11) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || u0.a.f(this) != 1) {
            return false;
        }
        return true;
    }

    public int getAlpha() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.d(drawable);
        }
        return this.f11910c.f11954b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11910c.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.e(drawable);
        }
        return this.f11912e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f12008b != null && Build.VERSION.SDK_INT >= 24) {
            return new e(this.f12008b.getConstantState());
        }
        this.f11910c.f11953a = getChangingConfigurations();
        return this.f11910c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f11910c.f11954b.f11946j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f11910c.f11954b.f11945i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void h(boolean z11) {
        this.f11914g = z11;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f11954b;
        vectorDrawableCompatState.f11956d = g(i.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c11 = i.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c11 != null) {
            vectorDrawableCompatState.f11955c = c11;
        }
        vectorDrawableCompatState.f11957e = i.a(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f11957e);
        vPathRenderer.f11947k = i.f(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f11947k);
        float f11 = i.f(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f11948l);
        vPathRenderer.f11948l = f11;
        if (vPathRenderer.f11947k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f11 > 0.0f) {
            vPathRenderer.f11945i = typedArray.getDimension(3, vPathRenderer.f11945i);
            float dimension = typedArray.getDimension(2, vPathRenderer.f11946j);
            vPathRenderer.f11946j = dimension;
            if (vPathRenderer.f11945i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(i.f(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.f11950n = string;
                    vPathRenderer.f11952p.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.h(drawable);
        }
        return this.f11910c.f11957e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f11910c.f11955c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f11910c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f12008b
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.f11910c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.f11910c
            android.content.res.ColorStateList r0 = r0.f11955c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f11913f && super.mutate() == this) {
            this.f11910c = new VectorDrawableCompatState(this.f11910c);
            this.f11913f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z11 = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        ColorStateList colorStateList = vectorDrawableCompatState.f11955c;
        if (!(colorStateList == null || (mode = vectorDrawableCompatState.f11956d) == null)) {
            this.f11911d = j(this.f11911d, colorStateList, mode);
            invalidateSelf();
            z11 = true;
        }
        if (!vectorDrawableCompatState.g() || !vectorDrawableCompatState.h(iArr)) {
            return z11;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j11);
        } else {
            super.scheduleSelf(runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else if (this.f11910c.f11954b.getRootAlpha() != i11) {
            this.f11910c.f11954b.setRootAlpha(i11);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.j(drawable, z11);
        } else {
            this.f11910c.f11957e = z11;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z11) {
        super.setFilterBitmap(z11);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.n(drawable, i11);
        } else {
            setTintList(ColorStateList.valueOf(i11));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        if (vectorDrawableCompatState.f11955c != colorStateList) {
            vectorDrawableCompatState.f11955c = colorStateList;
            this.f11911d = j(this.f11911d, colorStateList, vectorDrawableCompatState.f11956d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        if (vectorDrawableCompatState.f11956d != mode) {
            vectorDrawableCompatState.f11956d = mode;
            this.f11911d = j(this.f11911d, vectorDrawableCompatState.f11955c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.setVisible(z11, z12);
        }
        return super.setVisible(z11, z12);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public static class e extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f11977a;

        public e(Drawable.ConstantState constantState) {
            this.f11977a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f11977a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f11977a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12008b = (VectorDrawable) this.f11977a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12008b = (VectorDrawable) this.f11977a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12008b = (VectorDrawable) this.f11977a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f11912e = colorFilter;
        invalidateSelf();
    }

    public static abstract class VPath extends d {

        /* renamed from: a  reason: collision with root package name */
        public f.b[] f11932a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f11933b;

        /* renamed from: c  reason: collision with root package name */
        public int f11934c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f11935d;

        public VPath() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            f.b[] bVarArr = this.f11932a;
            if (bVarArr != null) {
                f.b.e(bVarArr, path);
            }
        }

        public f.b[] getPathData() {
            return this.f11932a;
        }

        public String getPathName() {
            return this.f11933b;
        }

        public void setPathData(f.b[] bVarArr) {
            if (!f.b(this.f11932a, bVarArr)) {
                this.f11932a = f.f(bVarArr);
            } else {
                f.j(this.f11932a, bVarArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f11933b = vPath.f11933b;
            this.f11935d = vPath.f11935d;
            this.f11932a = f.f(vPath.f11932a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11910c;
        vectorDrawableCompatState.f11954b = new VPathRenderer();
        TypedArray k11 = i.k(resources, theme, attributeSet, a.f11978a);
        i(k11, xmlPullParser, theme);
        k11.recycle();
        vectorDrawableCompatState.f11953a = getChangingConfigurations();
        vectorDrawableCompatState.f11963k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f11911d = j(this.f11911d, vectorDrawableCompatState.f11955c, vectorDrawableCompatState.f11956d);
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f11914g = true;
        this.f11916i = new float[9];
        this.f11917j = new Matrix();
        this.f11918k = new Rect();
        this.f11910c = vectorDrawableCompatState;
        this.f11911d = j(this.f11911d, vectorDrawableCompatState.f11955c, vectorDrawableCompatState.f11956d);
    }

    public static class c extends VPath {

        /* renamed from: e  reason: collision with root package name */
        public int[] f11965e;

        /* renamed from: f  reason: collision with root package name */
        public s0.d f11966f;

        /* renamed from: g  reason: collision with root package name */
        public float f11967g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public s0.d f11968h;

        /* renamed from: i  reason: collision with root package name */
        public float f11969i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f11970j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f11971k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f11972l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        public float f11973m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        public Paint.Cap f11974n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        public Paint.Join f11975o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        public float f11976p = 4.0f;

        public c() {
        }

        public boolean a() {
            return this.f11968h.i() || this.f11966f.i();
        }

        public boolean b(int[] iArr) {
            return this.f11966f.j(iArr) | this.f11968h.j(iArr);
        }

        public final Paint.Cap e(int i11, Paint.Cap cap) {
            if (i11 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i11 != 1) {
                return i11 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        public final Paint.Join f(int i11, Paint.Join join) {
            if (i11 == 0) {
                return Paint.Join.MITER;
            }
            if (i11 != 1) {
                return i11 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k11 = i.k(resources, theme, attributeSet, a.f11980c);
            h(k11, xmlPullParser, theme);
            k11.recycle();
        }

        public float getFillAlpha() {
            return this.f11970j;
        }

        public int getFillColor() {
            return this.f11968h.e();
        }

        public float getStrokeAlpha() {
            return this.f11969i;
        }

        public int getStrokeColor() {
            return this.f11966f.e();
        }

        public float getStrokeWidth() {
            return this.f11967g;
        }

        public float getTrimPathEnd() {
            return this.f11972l;
        }

        public float getTrimPathOffset() {
            return this.f11973m;
        }

        public float getTrimPathStart() {
            return this.f11971k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f11965e = null;
            if (i.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f11933b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f11932a = f.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f11968h = i.e(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f11970j = i.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f11970j);
                this.f11974n = e(i.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f11974n);
                this.f11975o = f(i.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f11975o);
                this.f11976p = i.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f11976p);
                this.f11966f = i.e(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f11969i = i.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f11969i);
                this.f11967g = i.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f11967g);
                this.f11972l = i.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f11972l);
                this.f11973m = i.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f11973m);
                this.f11971k = i.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f11971k);
                this.f11934c = i.g(typedArray, xmlPullParser, "fillType", 13, this.f11934c);
            }
        }

        public void setFillAlpha(float f11) {
            this.f11970j = f11;
        }

        public void setFillColor(int i11) {
            this.f11968h.k(i11);
        }

        public void setStrokeAlpha(float f11) {
            this.f11969i = f11;
        }

        public void setStrokeColor(int i11) {
            this.f11966f.k(i11);
        }

        public void setStrokeWidth(float f11) {
            this.f11967g = f11;
        }

        public void setTrimPathEnd(float f11) {
            this.f11972l = f11;
        }

        public void setTrimPathOffset(float f11) {
            this.f11973m = f11;
        }

        public void setTrimPathStart(float f11) {
            this.f11971k = f11;
        }

        public c(c cVar) {
            super(cVar);
            this.f11965e = cVar.f11965e;
            this.f11966f = cVar.f11966f;
            this.f11967g = cVar.f11967g;
            this.f11969i = cVar.f11969i;
            this.f11968h = cVar.f11968h;
            this.f11934c = cVar.f11934c;
            this.f11970j = cVar.f11970j;
            this.f11971k = cVar.f11971k;
            this.f11972l = cVar.f11972l;
            this.f11973m = cVar.f11973m;
            this.f11974n = cVar.f11974n;
            this.f11975o = cVar.f11975o;
            this.f11976p = cVar.f11976p;
        }
    }

    public static class VPathRenderer {

        /* renamed from: q  reason: collision with root package name */
        public static final Matrix f11936q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f11937a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f11938b;

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f11939c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f11940d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f11941e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f11942f;

        /* renamed from: g  reason: collision with root package name */
        public int f11943g;

        /* renamed from: h  reason: collision with root package name */
        public final VGroup f11944h;

        /* renamed from: i  reason: collision with root package name */
        public float f11945i;

        /* renamed from: j  reason: collision with root package name */
        public float f11946j;

        /* renamed from: k  reason: collision with root package name */
        public float f11947k;

        /* renamed from: l  reason: collision with root package name */
        public float f11948l;

        /* renamed from: m  reason: collision with root package name */
        public int f11949m;

        /* renamed from: n  reason: collision with root package name */
        public String f11950n;

        /* renamed from: o  reason: collision with root package name */
        public Boolean f11951o;

        /* renamed from: p  reason: collision with root package name */
        public final ArrayMap<String, Object> f11952p;

        public VPathRenderer() {
            this.f11939c = new Matrix();
            this.f11945i = 0.0f;
            this.f11946j = 0.0f;
            this.f11947k = 0.0f;
            this.f11948l = 0.0f;
            this.f11949m = 255;
            this.f11950n = null;
            this.f11951o = null;
            this.f11952p = new ArrayMap<>();
            this.f11944h = new VGroup();
            this.f11937a = new Path();
            this.f11938b = new Path();
        }

        public static float a(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        public void b(Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            c(this.f11944h, f11936q, canvas, i11, i12, colorFilter);
        }

        public final void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            vGroup.f11919a.set(matrix);
            vGroup.f11919a.preConcat(vGroup.f11928j);
            canvas.save();
            for (int i13 = 0; i13 < vGroup.f11920b.size(); i13++) {
                d dVar = vGroup.f11920b.get(i13);
                if (dVar instanceof VGroup) {
                    c((VGroup) dVar, vGroup.f11919a, canvas, i11, i12, colorFilter);
                } else if (dVar instanceof VPath) {
                    d(vGroup, (VPath) dVar, canvas, i11, i12, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(VGroup vGroup, VPath vPath, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            float f11 = ((float) i11) / this.f11947k;
            float f12 = ((float) i12) / this.f11948l;
            float min = Math.min(f11, f12);
            Matrix matrix = vGroup.f11919a;
            this.f11939c.set(matrix);
            this.f11939c.postScale(f11, f12);
            float e11 = e(matrix);
            if (e11 != 0.0f) {
                vPath.d(this.f11937a);
                Path path = this.f11937a;
                this.f11938b.reset();
                if (vPath.c()) {
                    this.f11938b.setFillType(vPath.f11934c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f11938b.addPath(path, this.f11939c);
                    canvas.clipPath(this.f11938b);
                    return;
                }
                c cVar = (c) vPath;
                float f13 = cVar.f11971k;
                if (!(f13 == 0.0f && cVar.f11972l == 1.0f)) {
                    float f14 = cVar.f11973m;
                    float f15 = (f13 + f14) % 1.0f;
                    float f16 = (cVar.f11972l + f14) % 1.0f;
                    if (this.f11942f == null) {
                        this.f11942f = new PathMeasure();
                    }
                    this.f11942f.setPath(this.f11937a, false);
                    float length = this.f11942f.getLength();
                    float f17 = f15 * length;
                    float f18 = f16 * length;
                    path.reset();
                    if (f17 > f18) {
                        this.f11942f.getSegment(f17, length, path, true);
                        this.f11942f.getSegment(0.0f, f18, path, true);
                    } else {
                        this.f11942f.getSegment(f17, f18, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f11938b.addPath(path, this.f11939c);
                if (cVar.f11968h.l()) {
                    s0.d dVar = cVar.f11968h;
                    if (this.f11941e == null) {
                        Paint paint = new Paint(1);
                        this.f11941e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f11941e;
                    if (dVar.h()) {
                        Shader f19 = dVar.f();
                        f19.setLocalMatrix(this.f11939c);
                        paint2.setShader(f19);
                        paint2.setAlpha(Math.round(cVar.f11970j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.a(dVar.e(), cVar.f11970j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f11938b.setFillType(cVar.f11934c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f11938b, paint2);
                }
                if (cVar.f11966f.l()) {
                    s0.d dVar2 = cVar.f11966f;
                    if (this.f11940d == null) {
                        Paint paint3 = new Paint(1);
                        this.f11940d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f11940d;
                    Paint.Join join = cVar.f11975o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f11974n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f11976p);
                    if (dVar2.h()) {
                        Shader f21 = dVar2.f();
                        f21.setLocalMatrix(this.f11939c);
                        paint4.setShader(f21);
                        paint4.setAlpha(Math.round(cVar.f11969i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.a(dVar2.e(), cVar.f11969i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f11967g * min * e11);
                    canvas.drawPath(this.f11938b, paint4);
                }
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a11 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a11) / max;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f11951o == null) {
                this.f11951o = Boolean.valueOf(this.f11944h.a());
            }
            return this.f11951o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f11944h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f11949m;
        }

        public void setAlpha(float f11) {
            setRootAlpha((int) (f11 * 255.0f));
        }

        public void setRootAlpha(int i11) {
            this.f11949m = i11;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f11939c = new Matrix();
            this.f11945i = 0.0f;
            this.f11946j = 0.0f;
            this.f11947k = 0.0f;
            this.f11948l = 0.0f;
            this.f11949m = 255;
            this.f11950n = null;
            this.f11951o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f11952p = arrayMap;
            this.f11944h = new VGroup(vPathRenderer.f11944h, arrayMap);
            this.f11937a = new Path(vPathRenderer.f11937a);
            this.f11938b = new Path(vPathRenderer.f11938b);
            this.f11945i = vPathRenderer.f11945i;
            this.f11946j = vPathRenderer.f11946j;
            this.f11947k = vPathRenderer.f11947k;
            this.f11948l = vPathRenderer.f11948l;
            this.f11943g = vPathRenderer.f11943g;
            this.f11949m = vPathRenderer.f11949m;
            this.f11950n = vPathRenderer.f11950n;
            String str = vPathRenderer.f11950n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f11951o = vPathRenderer.f11951o;
        }
    }

    public static class VGroup extends d {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f11919a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<d> f11920b;

        /* renamed from: c  reason: collision with root package name */
        public float f11921c;

        /* renamed from: d  reason: collision with root package name */
        public float f11922d;

        /* renamed from: e  reason: collision with root package name */
        public float f11923e;

        /* renamed from: f  reason: collision with root package name */
        public float f11924f;

        /* renamed from: g  reason: collision with root package name */
        public float f11925g;

        /* renamed from: h  reason: collision with root package name */
        public float f11926h;

        /* renamed from: i  reason: collision with root package name */
        public float f11927i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f11928j;

        /* renamed from: k  reason: collision with root package name */
        public int f11929k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f11930l;

        /* renamed from: m  reason: collision with root package name */
        public String f11931m;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vPath;
            this.f11919a = new Matrix();
            this.f11920b = new ArrayList<>();
            this.f11921c = 0.0f;
            this.f11922d = 0.0f;
            this.f11923e = 0.0f;
            this.f11924f = 1.0f;
            this.f11925g = 1.0f;
            this.f11926h = 0.0f;
            this.f11927i = 0.0f;
            Matrix matrix = new Matrix();
            this.f11928j = matrix;
            this.f11931m = null;
            this.f11921c = vGroup.f11921c;
            this.f11922d = vGroup.f11922d;
            this.f11923e = vGroup.f11923e;
            this.f11924f = vGroup.f11924f;
            this.f11925g = vGroup.f11925g;
            this.f11926h = vGroup.f11926h;
            this.f11927i = vGroup.f11927i;
            this.f11930l = vGroup.f11930l;
            String str = vGroup.f11931m;
            this.f11931m = str;
            this.f11929k = vGroup.f11929k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f11928j);
            ArrayList<d> arrayList = vGroup.f11920b;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                d dVar = arrayList.get(i11);
                if (dVar instanceof VGroup) {
                    this.f11920b.add(new VGroup((VGroup) dVar, arrayMap));
                } else {
                    if (dVar instanceof c) {
                        vPath = new c((c) dVar);
                    } else if (dVar instanceof b) {
                        vPath = new b((b) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f11920b.add(vPath);
                    String str2 = vPath.f11933b;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        public boolean a() {
            for (int i11 = 0; i11 < this.f11920b.size(); i11++) {
                if (this.f11920b.get(i11).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z11 = false;
            for (int i11 = 0; i11 < this.f11920b.size(); i11++) {
                z11 |= this.f11920b.get(i11).b(iArr);
            }
            return z11;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k11 = i.k(resources, theme, attributeSet, a.f11979b);
            e(k11, xmlPullParser);
            k11.recycle();
        }

        public final void d() {
            this.f11928j.reset();
            this.f11928j.postTranslate(-this.f11922d, -this.f11923e);
            this.f11928j.postScale(this.f11924f, this.f11925g);
            this.f11928j.postRotate(this.f11921c, 0.0f, 0.0f);
            this.f11928j.postTranslate(this.f11926h + this.f11922d, this.f11927i + this.f11923e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f11930l = null;
            this.f11921c = i.f(typedArray, xmlPullParser, "rotation", 5, this.f11921c);
            this.f11922d = typedArray.getFloat(1, this.f11922d);
            this.f11923e = typedArray.getFloat(2, this.f11923e);
            this.f11924f = i.f(typedArray, xmlPullParser, "scaleX", 3, this.f11924f);
            this.f11925g = i.f(typedArray, xmlPullParser, "scaleY", 4, this.f11925g);
            this.f11926h = i.f(typedArray, xmlPullParser, "translateX", 6, this.f11926h);
            this.f11927i = i.f(typedArray, xmlPullParser, "translateY", 7, this.f11927i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11931m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f11931m;
        }

        public Matrix getLocalMatrix() {
            return this.f11928j;
        }

        public float getPivotX() {
            return this.f11922d;
        }

        public float getPivotY() {
            return this.f11923e;
        }

        public float getRotation() {
            return this.f11921c;
        }

        public float getScaleX() {
            return this.f11924f;
        }

        public float getScaleY() {
            return this.f11925g;
        }

        public float getTranslateX() {
            return this.f11926h;
        }

        public float getTranslateY() {
            return this.f11927i;
        }

        public void setPivotX(float f11) {
            if (f11 != this.f11922d) {
                this.f11922d = f11;
                d();
            }
        }

        public void setPivotY(float f11) {
            if (f11 != this.f11923e) {
                this.f11923e = f11;
                d();
            }
        }

        public void setRotation(float f11) {
            if (f11 != this.f11921c) {
                this.f11921c = f11;
                d();
            }
        }

        public void setScaleX(float f11) {
            if (f11 != this.f11924f) {
                this.f11924f = f11;
                d();
            }
        }

        public void setScaleY(float f11) {
            if (f11 != this.f11925g) {
                this.f11925g = f11;
                d();
            }
        }

        public void setTranslateX(float f11) {
            if (f11 != this.f11926h) {
                this.f11926h = f11;
                d();
            }
        }

        public void setTranslateY(float f11) {
            if (f11 != this.f11927i) {
                this.f11927i = f11;
                d();
            }
        }

        public VGroup() {
            super();
            this.f11919a = new Matrix();
            this.f11920b = new ArrayList<>();
            this.f11921c = 0.0f;
            this.f11922d = 0.0f;
            this.f11923e = 0.0f;
            this.f11924f = 1.0f;
            this.f11925g = 1.0f;
            this.f11926h = 0.0f;
            this.f11927i = 0.0f;
            this.f11928j = new Matrix();
            this.f11931m = null;
        }
    }
}

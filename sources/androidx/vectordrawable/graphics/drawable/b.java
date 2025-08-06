package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.i;

public class b extends f implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    public c f11990c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11991d;

    /* renamed from: e  reason: collision with root package name */
    public ArgbEvaluator f11992e;

    /* renamed from: f  reason: collision with root package name */
    public d f11993f;

    /* renamed from: g  reason: collision with root package name */
    public Animator.AnimatorListener f11994g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Animatable2Compat$AnimationCallback> f11995h;

    /* renamed from: i  reason: collision with root package name */
    public final Drawable.Callback f11996i;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            b.this.scheduleSelf(runnable, j11);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.b$b  reason: collision with other inner class name */
    public class C0060b extends AnimatorListenerAdapter {
        public C0060b() {
        }

        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(b.this.f11995h);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animatable2Compat$AnimationCallback) arrayList.get(i11)).onAnimationEnd(b.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(b.this.f11995h);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animatable2Compat$AnimationCallback) arrayList.get(i11)).onAnimationStart(b.this);
            }
        }
    }

    public static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f11999a;

        /* renamed from: b  reason: collision with root package name */
        public VectorDrawableCompat f12000b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f12001c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Animator> f12002d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayMap<Animator, String> f12003e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f11999a = cVar.f11999a;
                VectorDrawableCompat vectorDrawableCompat = cVar.f12000b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f12000b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f12000b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f12000b.mutate();
                    this.f12000b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f12000b.setBounds(cVar.f12000b.getBounds());
                    this.f12000b.h(false);
                }
                ArrayList<Animator> arrayList = cVar.f12002d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f12002d = new ArrayList<>(size);
                    this.f12003e = new ArrayMap<>(size);
                    for (int i11 = 0; i11 < size; i11++) {
                        Animator animator = cVar.f12002d.get(i11);
                        Animator clone = animator.clone();
                        String str = cVar.f12003e.get(animator);
                        clone.setTarget(this.f12000b.d(str));
                        this.f12002d.add(clone);
                        this.f12003e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f12001c == null) {
                this.f12001c = new AnimatorSet();
            }
            this.f12001c.playTogether(this.f12002d);
        }

        public int getChangingConfigurations() {
            return this.f11999a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public b() {
        this((Context) null, (c) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.b b(android.content.Context r6, int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0030
            androidx.vectordrawable.graphics.drawable.b r0 = new androidx.vectordrawable.graphics.drawable.b
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.f(r1, r7, r6)
            r0.f12008b = r6
            android.graphics.drawable.Drawable$Callback r7 = r0.f11996i
            r6.setCallback(r7)
            androidx.vectordrawable.graphics.drawable.b$d r6 = new androidx.vectordrawable.graphics.drawable.b$d
            android.graphics.drawable.Drawable r7 = r0.f12008b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f11993f = r6
            return r0
        L_0x0030:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
        L_0x003c:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            r4 = 2
            if (r3 == r4) goto L_0x0047
            r5 = 1
            if (r3 == r5) goto L_0x0047
            goto L_0x003c
        L_0x0047:
            if (r3 != r4) goto L_0x0056
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            androidx.vectordrawable.graphics.drawable.b r6 = c(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            return r6
        L_0x0056:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            throw r6     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
        L_0x005e:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x0067
        L_0x0063:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x0067:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.b.b(android.content.Context, int):androidx.vectordrawable.graphics.drawable.b");
    }

    public static b c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public static void d(Drawable drawable, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (drawable != null && animatable2Compat$AnimationCallback != null && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                f((AnimatedVectorDrawable) drawable, animatable2Compat$AnimationCallback);
            } else {
                ((b) drawable).e(animatable2Compat$AnimationCallback);
            }
        }
    }

    public static void f(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animatable2Compat$AnimationCallback.getPlatformCallback());
    }

    public void a() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        g();
        ArrayList<Animatable2Compat$AnimationCallback> arrayList = this.f11995h;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f11990c.f12000b.draw(canvas);
        if (this.f11990c.f12001c.isStarted()) {
            invalidateSelf();
        }
    }

    public void e(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            f((AnimatedVectorDrawable) drawable, animatable2Compat$AnimationCallback);
        } else if (animatable2Compat$AnimationCallback != null) {
            if (this.f11995h == null) {
                this.f11995h = new ArrayList<>();
            }
            if (!this.f11995h.contains(animatable2Compat$AnimationCallback)) {
                this.f11995h.add(animatable2Compat$AnimationCallback);
                if (this.f11994g == null) {
                    this.f11994g = new C0060b();
                }
                this.f11990c.f12001c.addListener(this.f11994g);
            }
        }
    }

    public final void g() {
        Animator.AnimatorListener animatorListener = this.f11994g;
        if (animatorListener != null) {
            this.f11990c.f12001c.removeListener(animatorListener);
            this.f11994g = null;
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.d(drawable);
        }
        return this.f11990c.f12000b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11990c.f11999a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.e(drawable);
        }
        return this.f11990c.f12000b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f12008b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f12008b.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f11990c.f12000b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f11990c.f12000b.getIntrinsicWidth();
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
        return this.f11990c.f12000b.getOpacity();
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

    public final void h(String str, Animator animator) {
        animator.setTarget(this.f11990c.f12000b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            i(animator);
        }
        c cVar = this.f11990c;
        if (cVar.f12002d == null) {
            cVar.f12002d = new ArrayList<>();
            this.f11990c.f12003e = new ArrayMap<>();
        }
        this.f11990c.f12002d.add(animator);
        this.f11990c.f12003e.put(animator, str);
    }

    public final void i(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i11 = 0; i11 < childAnimations.size(); i11++) {
                i(childAnimations.get(i11));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f11992e == null) {
                    this.f11992e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f11992e);
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k11 = i.k(resources, theme, attributeSet, a.f11982e);
                    int resourceId = k11.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat b11 = VectorDrawableCompat.b(resources, resourceId, theme);
                        b11.h(false);
                        b11.setCallback(this.f11996i);
                        VectorDrawableCompat vectorDrawableCompat = this.f11990c.f12000b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.f11990c.f12000b = b11;
                    }
                    k11.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f11983f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f11991d;
                        if (context != null) {
                            h(string, d.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f11990c.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return u0.a.h(drawable);
        }
        return this.f11990c.f12000b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f11990c.f12001c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f11990c.f12000b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f11990c.f12000b.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        return this.f11990c.f12000b.setLevel(i11);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f11990c.f12000b.setState(iArr);
    }

    public void setAlpha(int i11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else {
            this.f11990c.f12000b.setAlpha(i11);
        }
    }

    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.j(drawable, z11);
        } else {
            this.f11990c.f12000b.setAutoMirrored(z11);
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
            this.f11990c.f12000b.setTint(i11);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.o(drawable, colorStateList);
        } else {
            this.f11990c.f12000b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            u0.a.p(drawable, mode);
        } else {
            this.f11990c.f12000b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            return drawable.setVisible(z11, z12);
        }
        this.f11990c.f12000b.setVisible(z11, z12);
        return super.setVisible(z11, z12);
    }

    public void start() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f11990c.f12001c.isStarted()) {
            this.f11990c.f12001c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f11990c.f12001c.end();
        }
    }

    public b(Context context) {
        this(context, (c) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f12008b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f11990c.f12000b.setColorFilter(colorFilter);
        }
    }

    public static class d extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f12004a;

        public d(Drawable.ConstantState constantState) {
            this.f12004a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f12004a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f12004a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f12004a.newDrawable();
            bVar.f12008b = newDrawable;
            newDrawable.setCallback(bVar.f11996i);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f12004a.newDrawable(resources);
            bVar.f12008b = newDrawable;
            newDrawable.setCallback(bVar.f11996i);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f12004a.newDrawable(resources, theme);
            bVar.f12008b = newDrawable;
            newDrawable.setCallback(bVar.f11996i);
            return bVar;
        }
    }

    public b(Context context, c cVar, Resources resources) {
        this.f11992e = null;
        this.f11994g = null;
        this.f11995h = null;
        a aVar = new a();
        this.f11996i = aVar;
        this.f11991d = context;
        if (cVar != null) {
            this.f11990c = cVar;
        } else {
            this.f11990c = new c(context, cVar, aVar, resources);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}

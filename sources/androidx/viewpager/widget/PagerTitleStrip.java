package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f12023p = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: q  reason: collision with root package name */
    public static final int[] f12024q = {16843660};

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f12025b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12026c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12027d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12028e;

    /* renamed from: f  reason: collision with root package name */
    public int f12029f = -1;

    /* renamed from: g  reason: collision with root package name */
    public float f12030g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    public int f12031h;

    /* renamed from: i  reason: collision with root package name */
    public int f12032i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12033j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12034k;

    /* renamed from: l  reason: collision with root package name */
    public final a f12035l = new a();

    /* renamed from: m  reason: collision with root package name */
    public WeakReference<PagerAdapter> f12036m;

    /* renamed from: n  reason: collision with root package name */
    public int f12037n;

    /* renamed from: o  reason: collision with root package name */
    public int f12038o;

    public class a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public int f12039b;

        public a() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.b(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f12025b.getCurrentItem(), PagerTitleStrip.this.f12025b.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f11 = pagerTitleStrip2.f12030g;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f12025b.getCurrentItem(), f11, true);
        }

        public void onPageScrollStateChanged(int i11) {
            this.f12039b = i11;
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            if (f11 > 0.5f) {
                i11++;
            }
            PagerTitleStrip.this.d(i11, f11, false);
        }

        public void onPageSelected(int i11) {
            if (this.f12039b == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f12025b.getCurrentItem(), PagerTitleStrip.this.f12025b.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f11 = pagerTitleStrip2.f12030g;
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f12025b.getCurrentItem(), f11, true);
            }
        }
    }

    public static class b extends SingleLineTransformationMethod {

        /* renamed from: b  reason: collision with root package name */
        public Locale f12041b;

        public b(Context context) {
            this.f12041b = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f12041b);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextView textView = new TextView(context);
        this.f12026c = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f12027d = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f12028e = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f12023p);
        boolean z11 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            l.s(this.f12026c, resourceId);
            l.s(this.f12027d, resourceId);
            l.s(this.f12028e, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f12026c.setTextColor(color);
            this.f12027d.setTextColor(color);
            this.f12028e.setTextColor(color);
        }
        this.f12032i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f12038o = this.f12027d.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f12026c.setEllipsize(TextUtils.TruncateAt.END);
        this.f12027d.setEllipsize(TextUtils.TruncateAt.END);
        this.f12028e.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f12024q);
            z11 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z11) {
            setSingleLineAllCaps(this.f12026c);
            setSingleLineAllCaps(this.f12027d);
            setSingleLineAllCaps(this.f12028e);
        } else {
            this.f12026c.setSingleLine();
            this.f12027d.setSingleLine();
            this.f12028e.setSingleLine();
        }
        this.f12031h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i11, float f11) {
        this.f12026c.setTextSize(i11, f11);
        this.f12027d.setTextSize(i11, f11);
        this.f12028e.setTextSize(i11, f11);
    }

    public void b(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f12035l);
            this.f12036m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f12035l);
            this.f12036m = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f12025b;
        if (viewPager != null) {
            this.f12029f = -1;
            this.f12030g = -1.0f;
            c(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public void c(int i11, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f12033j = true;
        CharSequence charSequence = null;
        this.f12026c.setText((i11 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i11 - 1));
        this.f12027d.setText((pagerAdapter == null || i11 >= count) ? null : pagerAdapter.getPageTitle(i11));
        int i12 = i11 + 1;
        if (i12 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i12);
        }
        this.f12028e.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f12026c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f12027d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f12028e.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f12029f = i11;
        if (!this.f12034k) {
            d(i11, this.f12030g, false);
        }
        this.f12033j = false;
    }

    public void d(int i11, float f11, boolean z11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i11;
        float f12 = f11;
        if (i16 != this.f12029f) {
            c(i16, this.f12025b.getAdapter());
        } else if (!z11 && f12 == this.f12030g) {
            return;
        }
        this.f12034k = true;
        int measuredWidth = this.f12026c.getMeasuredWidth();
        int measuredWidth2 = this.f12027d.getMeasuredWidth();
        int measuredWidth3 = this.f12028e.getMeasuredWidth();
        int i17 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i18 = paddingRight + i17;
        int i19 = (width - (paddingLeft + i17)) - i18;
        float f13 = 0.5f + f12;
        if (f13 > 1.0f) {
            f13 -= 1.0f;
        }
        int i21 = ((width - i18) - ((int) (((float) i19) * f13))) - i17;
        int i22 = measuredWidth2 + i21;
        int baseline = this.f12026c.getBaseline();
        int baseline2 = this.f12027d.getBaseline();
        int baseline3 = this.f12028e.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i23 = max - baseline;
        int i24 = max - baseline2;
        int i25 = max - baseline3;
        int i26 = measuredWidth3;
        int max2 = Math.max(Math.max(this.f12026c.getMeasuredHeight() + i23, this.f12027d.getMeasuredHeight() + i24), this.f12028e.getMeasuredHeight() + i25);
        int i27 = this.f12032i & 112;
        if (i27 == 16) {
            i15 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i27 != 80) {
            i14 = i23 + paddingTop;
            i12 = i24 + paddingTop;
            i13 = paddingTop + i25;
            TextView textView = this.f12027d;
            textView.layout(i21, i12, i22, textView.getMeasuredHeight() + i12);
            int min = Math.min(paddingLeft, (i21 - this.f12031h) - measuredWidth);
            TextView textView2 = this.f12026c;
            textView2.layout(min, i14, measuredWidth + min, textView2.getMeasuredHeight() + i14);
            int max3 = Math.max((width - paddingRight) - i26, i22 + this.f12031h);
            TextView textView3 = this.f12028e;
            textView3.layout(max3, i13, max3 + i26, textView3.getMeasuredHeight() + i13);
            this.f12030g = f11;
            this.f12034k = false;
        } else {
            i15 = (height - paddingBottom) - max2;
        }
        i14 = i23 + i15;
        i12 = i24 + i15;
        i13 = i15 + i25;
        TextView textView4 = this.f12027d;
        textView4.layout(i21, i12, i22, textView4.getMeasuredHeight() + i12);
        int min2 = Math.min(paddingLeft, (i21 - this.f12031h) - measuredWidth);
        TextView textView22 = this.f12026c;
        textView22.layout(min2, i14, measuredWidth + min2, textView22.getMeasuredHeight() + i14);
        int max32 = Math.max((width - paddingRight) - i26, i22 + this.f12031h);
        TextView textView32 = this.f12028e;
        textView32.layout(max32, i13, max32 + i26, textView32.getMeasuredHeight() + i13);
        this.f12030g = f11;
        this.f12034k = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f12031h;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f12035l);
            viewPager.addOnAdapterChangeListener(this.f12035l);
            this.f12025b = viewPager;
            WeakReference<PagerAdapter> weakReference = this.f12036m;
            b(weakReference != null ? (PagerAdapter) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f12025b;
        if (viewPager != null) {
            b(viewPager.getAdapter(), (PagerAdapter) null);
            this.f12025b.setInternalPageChangeListener((ViewPager.OnPageChangeListener) null);
            this.f12025b.removeOnAdapterChangeListener(this.f12035l);
            this.f12025b = null;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.f12025b != null) {
            float f11 = this.f12030g;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            d(this.f12029f, f11, true);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i11);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (((float) size) * 0.2f), -2);
            this.f12026c.measure(childMeasureSpec2, childMeasureSpec);
            this.f12027d.measure(childMeasureSpec2, childMeasureSpec);
            this.f12028e.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i12) == 1073741824) {
                i13 = View.MeasureSpec.getSize(i12);
            } else {
                i13 = Math.max(getMinHeight(), this.f12027d.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i13, i12, this.f12027d.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.f12033j) {
            super.requestLayout();
        }
    }

    public void setGravity(int i11) {
        this.f12032i = i11;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f11) {
        int i11 = ((int) (f11 * 255.0f)) & 255;
        this.f12037n = i11;
        int i12 = (i11 << 24) | (this.f12038o & FlexItem.MAX_SIZE);
        this.f12026c.setTextColor(i12);
        this.f12028e.setTextColor(i12);
    }

    public void setTextColor(int i11) {
        this.f12038o = i11;
        this.f12027d.setTextColor(i11);
        int i12 = (this.f12037n << 24) | (this.f12038o & FlexItem.MAX_SIZE);
        this.f12026c.setTextColor(i12);
        this.f12028e.setTextColor(i12);
    }

    public void setTextSpacing(int i11) {
        this.f12031h = i11;
        requestLayout();
    }
}

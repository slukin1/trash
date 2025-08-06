package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.huobi.view.roundimg.RoundedDrawable;

public class PagerTabStrip extends PagerTitleStrip {
    public boolean A = false;
    public boolean B = false;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public int G;

    /* renamed from: r  reason: collision with root package name */
    public int f12012r;

    /* renamed from: s  reason: collision with root package name */
    public int f12013s;

    /* renamed from: t  reason: collision with root package name */
    public int f12014t;

    /* renamed from: u  reason: collision with root package name */
    public int f12015u;

    /* renamed from: v  reason: collision with root package name */
    public int f12016v;

    /* renamed from: w  reason: collision with root package name */
    public int f12017w;

    /* renamed from: x  reason: collision with root package name */
    public final Paint f12018x;

    /* renamed from: y  reason: collision with root package name */
    public final Rect f12019y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    public int f12020z = 255;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f12025b;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f12025b;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f12018x = paint;
        int i11 = this.f12038o;
        this.f12012r = i11;
        paint.setColor(i11);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f12013s = (int) ((3.0f * f11) + 0.5f);
        this.f12014t = (int) ((6.0f * f11) + 0.5f);
        this.f12015u = (int) (64.0f * f11);
        this.f12017w = (int) ((16.0f * f11) + 0.5f);
        this.C = (int) ((1.0f * f11) + 0.5f);
        this.f12016v = (int) ((f11 * 32.0f) + 0.5f);
        this.G = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f12026c.setFocusable(true);
        this.f12026c.setOnClickListener(new a());
        this.f12028e.setFocusable(true);
        this.f12028e.setOnClickListener(new b());
        if (getBackground() == null) {
            this.A = true;
        }
    }

    public void d(int i11, float f11, boolean z11) {
        Rect rect = this.f12019y;
        int height = getHeight();
        int left = this.f12027d.getLeft() - this.f12017w;
        int right = this.f12027d.getRight() + this.f12017w;
        int i12 = height - this.f12013s;
        rect.set(left, i12, right, height);
        super.d(i11, f11, z11);
        this.f12020z = (int) (Math.abs(f11 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f12027d.getLeft() - this.f12017w, i12, this.f12027d.getRight() + this.f12017w, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.A;
    }

    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f12016v);
    }

    public int getTabIndicatorColor() {
        return this.f12012r;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f12027d.getLeft() - this.f12017w;
        int right = this.f12027d.getRight() + this.f12017w;
        this.f12018x.setColor((this.f12020z << 24) | (this.f12012r & FlexItem.MAX_SIZE));
        float f11 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.f12013s), (float) right, f11, this.f12018x);
        if (this.A) {
            this.f12018x.setColor(-16777216 | (this.f12012r & FlexItem.MAX_SIZE));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.C), (float) (getWidth() - getPaddingRight()), f11, this.f12018x);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.D) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (action == 0) {
            this.E = x11;
            this.F = y11;
            this.D = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x11 - this.E) > ((float) this.G) || Math.abs(y11 - this.F) > ((float) this.G))) {
                this.D = true;
            }
        } else if (x11 < ((float) (this.f12027d.getLeft() - this.f12017w))) {
            ViewPager viewPager = this.f12025b;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x11 > ((float) (this.f12027d.getRight() + this.f12017w))) {
            ViewPager viewPager2 = this.f12025b;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(int i11) {
        super.setBackgroundColor(i11);
        if (!this.B) {
            this.A = (i11 & RoundedDrawable.DEFAULT_BORDER_COLOR) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.B) {
            this.A = drawable == null;
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        if (!this.B) {
            this.A = i11 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z11) {
        this.A = z11;
        this.B = true;
        invalidate();
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        int i15 = this.f12014t;
        if (i14 < i15) {
            i14 = i15;
        }
        super.setPadding(i11, i12, i13, i14);
    }

    public void setTabIndicatorColor(int i11) {
        this.f12012r = i11;
        this.f12018x.setColor(i11);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i11) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setTextSpacing(int i11) {
        int i12 = this.f12015u;
        if (i11 < i12) {
            i11 = i12;
        }
        super.setTextSpacing(i11);
    }
}

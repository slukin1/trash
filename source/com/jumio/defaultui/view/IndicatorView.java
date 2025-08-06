package com.jumio.defaultui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.defaultui.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class IndicatorView extends View {
    private int defaultColor;
    private final Paint defaultPaint;
    /* access modifiers changed from: private */
    public int indicatorActive;
    private final b indicatorCallback;
    private int indicatorDistance;
    private final List<a> indicatorList;
    private int indicatorSize;
    private int itemCount;
    private int selectedColor;
    private final Paint selectedPaint;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f70831a;

        /* renamed from: b  reason: collision with root package name */
        public final int f70832b;

        /* renamed from: c  reason: collision with root package name */
        public final int f70833c;

        public a(int i11, int i12, int i13) {
            this.f70831a = i11;
            this.f70832b = i12;
            this.f70833c = i13;
        }
    }

    public final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public final void onPageSelected(int i11) {
            IndicatorView.this.indicatorActive = i11;
            IndicatorView.this.invalidate();
        }
    }

    public IndicatorView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndicatorView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final int dpToPx(int i11) {
        return ScreenUtil.dpToPx(getContext(), i11);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R.styleable.f70819jumio, 0, 0) : null;
            if (obtainStyledAttributes != null) {
                try {
                    setDefaultColor(obtainStyledAttributes.getColor(R.styleable.jumio_jumio_indicator_default, ContextCompat.getColor(context, R.color.jumio_gray_3)));
                    setSelectedColor(obtainStyledAttributes.getColor(R.styleable.jumio_jumio_indicator_active, ContextCompat.getColor(context, R.color.jumio_gray_7)));
                } catch (Throwable th2) {
                    obtainStyledAttributes.recycle();
                    throw th2;
                }
            }
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private final void setupIndicators() {
        if (this.itemCount != 0 && getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
            int i11 = this.itemCount;
            int i12 = ((i11 - 1) * this.indicatorDistance) + (this.indicatorSize * i11);
            int measuredWidth = (this.indicatorSize / 2) + ((getMeasuredWidth() - i12) / 2);
            this.indicatorList.clear();
            int i13 = this.itemCount;
            for (int i14 = 0; i14 < i13; i14++) {
                this.indicatorList.add(new a(((this.indicatorSize + this.indicatorDistance) * i14) + measuredWidth, getMeasuredHeight() / 2, this.indicatorSize / 2));
            }
        }
    }

    public final int getDefaultColor() {
        return this.defaultColor;
    }

    public final int getIndicatorDistance() {
        return this.indicatorDistance;
    }

    public final int getIndicatorSize() {
        return this.indicatorSize;
    }

    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i11 = 0;
        for (T next : this.indicatorList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            a aVar = (a) next;
            Paint paint = i11 == this.indicatorActive ? this.selectedPaint : this.defaultPaint;
            aVar.getClass();
            canvas.drawCircle((float) aVar.f70831a, (float) aVar.f70832b, (float) aVar.f70833c, paint);
            i11 = i12;
        }
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (size == 0 && (mode == Integer.MIN_VALUE || mode == 0)) {
            size = this.indicatorSize;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        setupIndicators();
    }

    public final void setDefaultColor(int i11) {
        this.defaultColor = i11;
        this.defaultPaint.setColor(i11);
    }

    public final void setIndicatorDistance(int i11) {
        this.indicatorDistance = i11;
    }

    public final void setIndicatorSize(int i11) {
        this.indicatorSize = i11;
    }

    public final void setSelectedColor(int i11) {
        this.selectedColor = i11;
        this.selectedPaint.setColor(i11);
    }

    public final void setupWithViewpager(ViewPager2 viewPager2) {
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            this.itemCount = adapter.getItemCount();
        }
        viewPager2.registerOnPageChangeCallback(this.indicatorCallback);
        setupIndicators();
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.defaultColor = ContextCompat.getColor(context, R.color.jumio_gray_3);
        this.selectedColor = ContextCompat.getColor(context, R.color.jumio_gray_7);
        this.indicatorDistance = dpToPx(10);
        this.indicatorSize = dpToPx(8);
        this.indicatorCallback = new b();
        this.indicatorList = new ArrayList();
        Paint paint = new Paint();
        this.defaultPaint = paint;
        Paint paint2 = new Paint();
        this.selectedPaint = paint2;
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(this.defaultColor);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(this.selectedColor);
        paint2.setDither(true);
        paint2.setAntiAlias(true);
        init(context, attributeSet);
    }
}

package com.hbg.module.content.custom.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.libkt.base.ext.b;
import java.util.HashMap;
import kotlin.jvm.internal.x;

public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public Context f18117a;

    /* renamed from: b  reason: collision with root package name */
    public int f18118b;

    /* renamed from: c  reason: collision with root package name */
    public int f18119c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f18120d;

    /* renamed from: e  reason: collision with root package name */
    public final float f18121e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Integer, String> f18122f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public float f18123g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f18124h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public Paint f18125i = new Paint();

    /* renamed from: j  reason: collision with root package name */
    public float f18126j;

    /* renamed from: k  reason: collision with root package name */
    public float f18127k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f18128l = true;

    public a(Context context, int i11, int i12, int i13, float f11) {
        this.f18117a = context;
        this.f18118b = i12;
        this.f18119c = i13;
        this.f18120d = new ColorDrawable(i11);
        this.f18121e = TypedValue.applyDimension(1, f11, this.f18117a.getResources().getDisplayMetrics());
        this.f18124h.setAntiAlias(true);
        this.f18124h.setTextSize(TypedValue.applyDimension(2, 16.0f, this.f18117a.getResources().getDisplayMetrics()));
        this.f18124h.setColor(this.f18118b);
        this.f18124h.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18124h.setStrokeWidth(0.5f);
        Paint.FontMetrics fontMetrics = this.f18124h.getFontMetrics();
        float f12 = fontMetrics.bottom;
        this.f18126j = f12 - fontMetrics.top;
        this.f18127k = f12;
        Paint paint = new Paint();
        this.f18125i = paint;
        paint.setAntiAlias(true);
        this.f18125i.setColor(this.f18119c);
    }

    public final String a(Integer num) {
        if (num == null) {
            return null;
        }
        while (num.intValue() >= 0) {
            if (this.f18122f.containsKey(num)) {
                return this.f18122f.get(num);
            }
            num = Integer.valueOf(num.intValue() - 1);
        }
        return null;
    }

    public final void b(HashMap<Integer, String> hashMap) {
        this.f18122f.clear();
        this.f18122f.putAll(hashMap);
    }

    public final void c(float f11) {
        this.f18123g = f11;
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        float paddingLeft = (float) recyclerView.getPaddingLeft();
        float width = ((float) recyclerView.getWidth()) - ((float) recyclerView.getPaddingRight());
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!this.f18122f.containsKey(Integer.valueOf(layoutParams.getViewLayoutPosition()))) {
                float f11 = this.f18121e;
                float top = ((float) (childAt.getTop() - layoutParams.topMargin)) - f11;
                this.f18120d.setBounds((int) paddingLeft, (int) top, (int) width, (int) (f11 + top));
                this.f18120d.draw(canvas);
            } else {
                float f12 = this.f18123g;
                float top2 = ((float) (childAt.getTop() - layoutParams.topMargin)) - f12;
                float f13 = top2 + f12;
                canvas.drawRect(paddingLeft, top2, width, f13, this.f18125i);
                float applyDimension = TypedValue.applyDimension(1, 14.0f, this.f18117a.getResources().getDisplayMetrics());
                float f14 = (f13 - ((this.f18123g - this.f18126j) / 2.0f)) - this.f18127k;
                float applyDimension2 = TypedValue.applyDimension(1, 3.0f, this.f18117a.getResources().getDisplayMetrics());
                float f15 = (float) 2;
                canvas.drawCircle(applyDimension + applyDimension2, top2 + (this.f18123g / f15), applyDimension2, this.f18124h);
                canvas.drawText(this.f18122f.get(Integer.valueOf(layoutParams.getViewLayoutPosition())), applyDimension + (applyDimension2 * f15) + TypedValue.applyDimension(1, 4.0f, this.f18117a.getResources().getDisplayMetrics()), f14, this.f18124h);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.f18122f.containsKey(Integer.valueOf(recyclerView.getChildViewHolder(view).getAdapterPosition()))) {
            rect.set(0, (int) this.f18123g, 0, 0);
        } else {
            rect.set(0, (int) this.f18121e, 0, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        drawVertical(canvas, recyclerView);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        if (this.f18128l) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            Integer valueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()) : null;
            if (valueOf == null || valueOf.intValue() != -1) {
                String a11 = a(valueOf);
                if (!TextUtils.isEmpty(a11)) {
                    boolean z11 = false;
                    if (!b.x(a11)) {
                        if (a(Integer.valueOf(valueOf.intValue() + 1)) != null && !x.b(a11, a(Integer.valueOf(valueOf.intValue() + 1)))) {
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(valueOf.intValue());
                            if (findViewHolderForAdapterPosition != null) {
                                View view = findViewHolderForAdapterPosition.itemView;
                                if (((float) (view.getTop() + view.getMeasuredHeight())) < this.f18123g) {
                                    canvas.save();
                                    canvas.translate(0.0f, ((float) (view.getTop() + view.getMeasuredHeight())) - this.f18123g);
                                    z11 = true;
                                }
                            } else {
                                return;
                            }
                        }
                        int paddingLeft = recyclerView.getPaddingLeft();
                        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                        float paddingTop = (float) recyclerView.getPaddingTop();
                        float f11 = paddingTop + this.f18123g;
                        canvas.drawRect((float) paddingLeft, paddingTop, (float) width, f11, this.f18125i);
                        float applyDimension = TypedValue.applyDimension(1, 14.0f, this.f18117a.getResources().getDisplayMetrics());
                        float f12 = (f11 - ((this.f18123g - this.f18126j) / 2.0f)) - this.f18127k;
                        float applyDimension2 = TypedValue.applyDimension(1, 3.0f, this.f18117a.getResources().getDisplayMetrics());
                        float f13 = (float) 2;
                        canvas.drawCircle(applyDimension + applyDimension2, paddingTop + (this.f18123g / f13), applyDimension2, this.f18124h);
                        float applyDimension3 = TypedValue.applyDimension(1, 4.0f, this.f18117a.getResources().getDisplayMetrics());
                        if (a11 == null) {
                            a11 = "";
                        }
                        canvas.drawText(a11, applyDimension + (applyDimension2 * f13) + applyDimension3, f12, this.f18124h);
                        if (z11) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }
}

package nd;

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
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.x;

public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public Context f22990a;

    /* renamed from: b  reason: collision with root package name */
    public int f22991b;

    /* renamed from: c  reason: collision with root package name */
    public int f22992c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f22993d;

    /* renamed from: e  reason: collision with root package name */
    public final float f22994e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Integer, String> f22995f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public int f22996g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f22997h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public Paint f22998i = new Paint();

    /* renamed from: j  reason: collision with root package name */
    public float f22999j;

    /* renamed from: k  reason: collision with root package name */
    public float f23000k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f23001l = true;

    public a(Context context, int i11, int i12, int i13, float f11) {
        this.f22990a = context;
        this.f22991b = i12;
        this.f22992c = i13;
        this.f22993d = new ColorDrawable(i11);
        this.f22994e = TypedValue.applyDimension(1, f11, this.f22990a.getResources().getDisplayMetrics());
        this.f22997h.setAntiAlias(true);
        this.f22997h.setTextSize(TypedValue.applyDimension(1, 14.0f, this.f22990a.getResources().getDisplayMetrics()));
        this.f22997h.setColor(this.f22991b);
        this.f22997h.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f22997h.setStrokeWidth(0.7f);
        Paint.FontMetrics fontMetrics = this.f22997h.getFontMetrics();
        float f12 = fontMetrics.bottom;
        this.f22999j = f12 - fontMetrics.top;
        this.f23000k = f12;
        Paint paint = new Paint();
        this.f22998i = paint;
        paint.setAntiAlias(true);
        this.f22998i.setColor(this.f22992c);
    }

    public final String a(Integer num) {
        if (num == null) {
            return null;
        }
        while (num.intValue() >= 0) {
            if (this.f22995f.containsKey(num)) {
                return this.f22995f.get(num);
            }
            num = Integer.valueOf(num.intValue() - 1);
        }
        return null;
    }

    public final boolean b(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                if (!(StringsKt__StringsKt.i1(str).toString().length() == 0) && !x.b(str.toLowerCase(Locale.ROOT), OptionsBridge.NULL_VALUE)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void c(HashMap<Integer, String> hashMap) {
        this.f22995f.clear();
        this.f22995f.putAll(hashMap);
    }

    public final void d(int i11) {
        this.f22996g = i11;
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!this.f22995f.containsKey(Integer.valueOf(layoutParams.getViewLayoutPosition()))) {
                float f11 = this.f22994e;
                int top = (int) (((float) (childAt.getTop() - layoutParams.topMargin)) - f11);
                this.f22993d.setBounds(paddingLeft, top, width, (int) (((float) top) + f11));
                this.f22993d.draw(canvas);
            } else {
                int top2 = childAt.getTop() - layoutParams.topMargin;
                int i12 = this.f22996g;
                int i13 = top2 - i12;
                float f12 = (float) (i12 + i13);
                canvas.drawRect((float) paddingLeft, (float) i13, (float) width, f12, this.f22998i);
                canvas.drawText(this.f22995f.get(Integer.valueOf(layoutParams.getViewLayoutPosition())), TypedValue.applyDimension(1, 10.0f, this.f22990a.getResources().getDisplayMetrics()), (f12 - ((((float) this.f22996g) - this.f22999j) / ((float) 2))) - this.f23000k, this.f22997h);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.f22995f.containsKey(Integer.valueOf(recyclerView.getChildViewHolder(view).getAdapterPosition()))) {
            rect.set(0, this.f22996g, 0, 0);
        } else {
            rect.set(0, (int) this.f22994e, 0, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        drawVertical(canvas, recyclerView);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        if (this.f23001l) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            Integer valueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()) : null;
            if (valueOf == null || valueOf.intValue() != -1) {
                String a11 = a(valueOf);
                if (!TextUtils.isEmpty(a11)) {
                    boolean z11 = false;
                    if (!b(a11)) {
                        if (a(Integer.valueOf(valueOf.intValue() + 1)) != null && !x.b(a11, a(Integer.valueOf(valueOf.intValue() + 1)))) {
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(valueOf.intValue());
                            if (findViewHolderForAdapterPosition != null) {
                                View view = findViewHolderForAdapterPosition.itemView;
                                if (view.getTop() + view.getMeasuredHeight() < this.f22996g) {
                                    canvas.save();
                                    canvas.translate(0.0f, (float) ((view.getTop() + view.getMeasuredHeight()) - this.f22996g));
                                    z11 = true;
                                }
                            } else {
                                return;
                            }
                        }
                        int paddingLeft = recyclerView.getPaddingLeft();
                        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                        int paddingTop = recyclerView.getPaddingTop();
                        float f11 = (float) (this.f22996g + paddingTop);
                        canvas.drawRect((float) paddingLeft, (float) paddingTop, (float) width, f11, this.f22998i);
                        canvas.drawText(a11, TypedValue.applyDimension(1, 12.0f, this.f22990a.getResources().getDisplayMetrics()), (f11 - ((((float) this.f22996g) - this.f22999j) / ((float) 2))) - this.f23000k, this.f22997h);
                        if (z11) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }
}

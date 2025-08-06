package ea;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$styleable;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f76164a;

    /* renamed from: b  reason: collision with root package name */
    public int f76165b;

    /* renamed from: c  reason: collision with root package name */
    public int f76166c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f76167d;

    /* renamed from: e  reason: collision with root package name */
    public int f76168e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f76169f = new int[4];

    /* renamed from: g  reason: collision with root package name */
    public boolean f76170g;

    public c(ViewGroup viewGroup, AttributeSet attributeSet) {
        this.f76164a = viewGroup;
        viewGroup.setWillNotDraw(false);
        if (viewGroup.isInEditMode()) {
            this.f76168e = 2;
        }
        if (attributeSet != null && !viewGroup.isInEditMode()) {
            TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(attributeSet, R$styleable.DividerRelativeLayout);
            this.f76166c = obtainStyledAttributes.getInteger(R$styleable.DividerRelativeLayout_divider_direction, 0);
            this.f76165b = obtainStyledAttributes.getColor(R$styleable.DividerRelativeLayout_divider_color, 0);
            this.f76168e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerRelativeLayout_divider_width, PixelUtils.a(0.5f));
            this.f76169f[0] = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerRelativeLayout_divider_paddingLeft, 0);
            this.f76169f[1] = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerRelativeLayout_divider_paddingTop, 0);
            this.f76169f[2] = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerRelativeLayout_divider_paddingRight, 0);
            this.f76169f[3] = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerRelativeLayout_divider_paddingBottom, 0);
        }
        b();
        Paint paint = new Paint();
        this.f76167d = paint;
        paint.setColor(this.f76165b);
    }

    public void a(Canvas canvas) {
        int measuredWidth = this.f76164a.getMeasuredWidth();
        int measuredHeight = this.f76164a.getMeasuredHeight();
        if ((this.f76166c & 1) > 0) {
            int[] iArr = this.f76169f;
            canvas.drawRect((float) iArr[0], (float) iArr[1], (float) (this.f76168e + iArr[0]), (float) (measuredHeight - iArr[3]), this.f76167d);
        }
        if ((this.f76166c & 2) > 0) {
            int[] iArr2 = this.f76169f;
            canvas.drawRect((float) ((measuredWidth - this.f76168e) - iArr2[2]), (float) iArr2[1], (float) (measuredWidth - iArr2[2]), (float) (measuredHeight - iArr2[3]), this.f76167d);
        }
        if ((this.f76166c & 4) > 0) {
            int[] iArr3 = this.f76169f;
            canvas.drawRect((float) iArr3[0], (float) iArr3[1], (float) (measuredWidth - iArr3[2]), (float) (this.f76168e + iArr3[1]), this.f76167d);
        }
        if ((this.f76166c & 8) > 0) {
            int[] iArr4 = this.f76169f;
            canvas.drawRect((float) iArr4[0], (float) ((measuredHeight - this.f76168e) - iArr4[3]), (float) (measuredWidth - iArr4[2]), (float) (measuredHeight - iArr4[3]), this.f76167d);
        }
    }

    public void b() {
        if (this.f76170g) {
            this.f76170g = false;
            try {
                int paddingLeft = this.f76164a.getPaddingLeft();
                int paddingRight = this.f76164a.getPaddingRight();
                int paddingTop = this.f76164a.getPaddingTop();
                int paddingBottom = this.f76164a.getPaddingBottom();
                int i11 = this.f76166c & 15;
                if (i11 == 1) {
                    paddingLeft += this.f76168e + this.f76169f[0];
                } else if (i11 == 2) {
                    paddingRight += this.f76168e + this.f76169f[2];
                } else if (i11 == 4) {
                    paddingTop += this.f76168e + this.f76169f[1];
                } else if (i11 == 8) {
                    paddingBottom += this.f76168e + this.f76169f[3];
                }
                this.f76164a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            } finally {
                this.f76170g = true;
            }
        }
    }
}

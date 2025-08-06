package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$color;

public class CustomDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private int endInset;
    private Drawable mDivider;
    private int mOrientation;
    private Paint paint;
    private int startInset;

    public CustomDecoration(Context context, int i11, int i12, int i13) {
        this.mDivider = context.getResources().getDrawable(i12);
        this.startInset = i13;
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(context.getResources().getColor(R$color.base_dialog_devide_line_color));
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        setOrientation(i11);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount - 1; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            this.mDivider.setBounds(right, paddingTop, this.mDivider.getIntrinsicHeight() + right, height);
            this.mDivider.draw(canvas);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount - 1; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int intrinsicHeight = this.mDivider.getIntrinsicHeight() + bottom;
            if (this.startInset > 0) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) width, (float) intrinsicHeight, this.paint);
                this.mDivider.setBounds(this.startInset + paddingLeft, bottom, width, intrinsicHeight);
            } else {
                this.mDivider.setBounds(paddingLeft, bottom, width, intrinsicHeight);
            }
            this.mDivider.draw(canvas);
        }
    }

    public void getItemOffsets(Rect rect, int i11, RecyclerView recyclerView) {
        if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            this.mOrientation = i11;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }
}

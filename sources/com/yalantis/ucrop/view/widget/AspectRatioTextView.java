package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView extends AppCompatTextView {
    private final float MARGIN_MULTIPLIER;
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds;
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyActiveColor(int i11) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i11);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i11, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget)}));
    }

    private void init(TypedArray typedArray) {
        setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f11 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.mAspectRatioY = f11;
        float f12 = this.mAspectRatioX;
        if (f12 == 0.0f || f11 == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f12 / f11;
        }
        this.mDotSize = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        setTitle();
        applyActiveColor(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void setTitle() {
        if (!TextUtils.isEmpty(this.mAspectRatioTitle)) {
            setText(this.mAspectRatioTitle);
            return;
        }
        setText(String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.mAspectRatioX), Integer.valueOf((int) this.mAspectRatioY)}));
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f11 = this.mAspectRatioX;
            float f12 = this.mAspectRatioY;
            this.mAspectRatioX = f12;
            this.mAspectRatioY = f11;
            this.mAspectRatio = f12 / f11;
        }
    }

    public float getAspectRatio(boolean z11) {
        if (z11) {
            toggleAspectRatio();
            setTitle();
        }
        return this.mAspectRatio;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            Rect rect = this.mCanvasClipBounds;
            float f11 = ((float) rect.bottom) - (((float) rect.top) / 2.0f);
            int i11 = this.mDotSize;
            canvas.drawCircle(((float) (rect.right - rect.left)) / 2.0f, f11 - (((float) i11) * 1.5f), ((float) i11) / 2.0f, this.mDotPaint);
        }
    }

    public void setActiveColor(int i11) {
        applyActiveColor(i11);
        invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        float aspectRatioY = aspectRatio.getAspectRatioY();
        this.mAspectRatioY = aspectRatioY;
        float f11 = this.mAspectRatioX;
        if (f11 == 0.0f || aspectRatioY == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f11 / aspectRatioY;
        }
        setTitle();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }
}

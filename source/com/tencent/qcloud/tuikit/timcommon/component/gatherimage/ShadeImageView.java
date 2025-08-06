package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;

@SuppressLint({"AppCompatCustomView"})
public class ShadeImageView extends ImageView {
    private static SparseArray<Bitmap> sRoundBitmapArray = new SparseArray<>();
    private Bitmap mRoundBitmap;
    private Paint mShadePaint = new Paint();
    private int radius;

    public ShadeImageView(Context context) {
        super(context);
    }

    private Bitmap getRoundBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int parseColor = Color.parseColor("#cfd3d8");
        RectF rectF = new RectF(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(parseColor);
        int i11 = this.radius;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
        return createBitmap;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.radius = (int) ScreenUtil.dp2px(4.0f, getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.core_round_rect_image_style);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.core_round_rect_image_style_round_radius, this.radius);
        obtainStyledAttributes.recycle();
        setLayerType(2, (Paint) null);
    }

    public int getRadius() {
        return this.radius;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mShadePaint.setColor(-65536);
        this.mShadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Bitmap bitmap = sRoundBitmapArray.get(getMeasuredWidth() + this.radius);
        this.mRoundBitmap = bitmap;
        if (bitmap == null) {
            this.mRoundBitmap = getRoundBitmap();
            sRoundBitmapArray.put(getMeasuredWidth() + this.radius, this.mRoundBitmap);
        }
        canvas.drawBitmap(this.mRoundBitmap, 0.0f, 0.0f, this.mShadePaint);
    }

    public void setRadius(int i11) {
        this.radius = i11;
    }

    public ShadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShadeImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}

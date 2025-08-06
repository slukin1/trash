package com.hbg.module.community.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.module.content.R$drawable;
import kotlin.jvm.internal.r;
import u0.b;

public final class VideoCoverImageView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f17612b;

    /* renamed from: c  reason: collision with root package name */
    public VectorDrawable f17613c;

    public VideoCoverImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCoverImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(ResourcesCompat.d(getContext().getResources(), 17170444, (Resources.Theme) null));
        super.onDraw(canvas);
        VectorDrawable vectorDrawable = this.f17613c;
        canvas.drawBitmap(b.a(vectorDrawable, vectorDrawable.getIntrinsicWidth(), this.f17613c.getIntrinsicHeight(), Bitmap.Config.ARGB_8888), (float) ((getWidth() / 2) - (this.f17613c.getIntrinsicWidth() / 2)), (float) ((getHeight() / 2) - (this.f17613c.getIntrinsicHeight() / 2)), this.f17612b);
    }

    public VideoCoverImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.f17612b = paint;
        this.f17613c = (VectorDrawable) ResourcesCompat.f(getResources(), R$drawable.icon_video_play, (Resources.Theme) null);
    }
}

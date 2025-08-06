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
import com.hbg.module.libkt.utils.m;
import kotlin.jvm.internal.r;
import u0.b;

public final class MultiMarkImageView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f17609b;

    /* renamed from: c  reason: collision with root package name */
    public VectorDrawable f17610c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17611d;

    public MultiMarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiMarkImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void onDraw(Canvas canvas) {
        VectorDrawable vectorDrawable;
        Bitmap a11;
        super.onDraw(canvas);
        if (this.f17611d && (vectorDrawable = this.f17610c) != null && (a11 = b.a(vectorDrawable, vectorDrawable.getIntrinsicWidth(), this.f17610c.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)) != null) {
            canvas.drawBitmap(a11, (float) ((getWidth() - this.f17610c.getIntrinsicWidth()) - m.a(8)), (float) m.a(8), this.f17609b);
        }
    }

    public MultiMarkImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.f17609b = paint;
        this.f17610c = (VectorDrawable) ResourcesCompat.f(getResources(), R$drawable.ic_multiple_pic_mark, (Resources.Theme) null);
    }
}

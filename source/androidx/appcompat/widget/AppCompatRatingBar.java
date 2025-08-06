package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class AppCompatRatingBar extends RatingBar {

    /* renamed from: b  reason: collision with root package name */
    public final j f4361b;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    public synchronized void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        Bitmap b11 = this.f4361b.b();
        if (b11 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b11.getWidth() * getNumStars(), i11, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        z.a(this, getContext());
        j jVar = new j(this);
        this.f4361b = jVar;
        jVar.c(attributeSet, i11);
    }
}

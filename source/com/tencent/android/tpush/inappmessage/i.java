package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.h0;

public class i {
    public static int a(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024 ? 16973841 : 16973840;
    }

    public static void a(View view, int i11, boolean z11) {
        SizeUtil.init(view.getContext());
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(a(z11 ? SizeUtil.dp20 : 0));
        shapeDrawable.getPaint().setColor(i11);
        h0.B0(view, shapeDrawable);
    }

    public static Shape a(int i11) {
        float f11 = (float) i11;
        return new RoundRectShape(new float[]{f11, f11, f11, f11, f11, f11, f11, f11}, (RectF) null, (float[]) null);
    }

    public static Animation a(long j11) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j11);
        return alphaAnimation;
    }
}

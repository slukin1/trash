package cn.sharesdk.framework.utils;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

public class m {
    public static ShapeDrawable a(float f11, int i11) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i12 = 0; i12 < 8; i12++) {
            fArr[i12] = 0.0f + f11;
            fArr2[i12] = f11;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr2));
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }
}

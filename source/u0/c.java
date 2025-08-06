package u0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

public class c extends d {
    public c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void c(int i11, int i12, int i13, Rect rect, Rect rect2) {
        Gravity.apply(i11, i12, i13, rect, rect2, 0);
    }

    public void getOutline(Outline outline) {
        h();
        outline.setRoundRect(this.f16583h, b());
    }
}

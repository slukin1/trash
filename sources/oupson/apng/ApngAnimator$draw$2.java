package oupson.apng;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$draw$2 extends Lambda implements a<Paint> {
    public static final ApngAnimator$draw$2 INSTANCE = new ApngAnimator$draw$2();

    public ApngAnimator$draw$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return paint;
    }
}

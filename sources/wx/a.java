package wx;

import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.l;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lwx/a;", "", "Landroid/graphics/BitmapFactory$Options;", "options", "", "reqWidth", "reqHeight", "a", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29376a = new a();

    public final int a(BitmapFactory.Options options, int i11, int i12) {
        Pair a11 = l.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) a11.component1()).intValue();
        int intValue2 = ((Number) a11.component2()).intValue();
        int i13 = 1;
        if (i12 > 0 && i11 > 0 && (intValue > i12 || intValue2 > i11)) {
            int i14 = intValue / 2;
            int i15 = intValue2 / 2;
            while (i14 / i13 >= i12 && i15 / i13 >= i11) {
                i13 *= 2;
            }
        }
        return i13;
    }
}

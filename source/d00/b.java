package d00;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final float f53487a;

    public b(float f11) {
        this.f53487a = f11;
    }

    public static b a(Context context) {
        return new b(context.getResources().getDisplayMetrics().density);
    }

    public int b(int i11) {
        return (int) ((((float) i11) * this.f53487a) + 0.5f);
    }
}

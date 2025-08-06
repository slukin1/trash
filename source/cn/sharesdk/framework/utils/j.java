package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.utils.ResHelper;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static float f13529a = 1.5f;

    /* renamed from: b  reason: collision with root package name */
    public static int f13530b = 540;

    /* renamed from: c  reason: collision with root package name */
    private static Context f13531c;

    public static void a(Context context) {
        Context context2 = f13531c;
        if (context2 == null || context2 != context.getApplicationContext()) {
            f13531c = context;
        }
    }

    public static int b(int i11) {
        return ResHelper.designToDevice(f13531c, f13530b, i11);
    }

    public static int a(int i11) {
        return ResHelper.designToDevice(f13531c, f13529a, i11);
    }
}

package vx;

import android.content.Context;
import android.os.Environment;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sumsub.sns.internal.core.common.n0;
import java.io.File;
import java.io.IOException;

public final class e {
    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z11) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File c11 = (!z11 || !"mounted".equals(str) || !f(context)) ? null : c(context);
        if (c11 == null) {
            c11 = context.getCacheDir();
        }
        if (c11 != null) {
            return c11;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        c.f("Can't define system cache directory! '%s' will be used.", str2);
        return new File(str2);
    }

    public static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), n0.f32119g), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                c.f("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                c.d("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File d(Context context) {
        return e(context, "uil-images");
    }

    public static File e(Context context, String str) {
        File a11 = a(context);
        File file = new File(a11, str);
        return (file.exists() || file.mkdir()) ? file : a11;
    }

    public static boolean f(Context context) {
        return context.checkCallingOrSelfPermission(PermissionConfig.WRITE_EXTERNAL_STORAGE) == 0;
    }
}

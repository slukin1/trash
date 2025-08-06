package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

public class a {

    /* renamed from: androidx.profileinstaller.a$a  reason: collision with other inner class name */
    public static class C0053a {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    public static class b {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z11 = true;
            for (int i11 = 0; i11 < length; i11++) {
                z11 = a(listFiles[i11]) && z11;
            }
            return z11;
        }
        file.delete();
        return true;
    }

    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        File file;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            file = b.a(context);
        } else if (i11 >= 23) {
            file = C0053a.a(context);
        } else {
            file = context.getCacheDir();
        }
        if (a(file)) {
            aVar.a(14, (Object) null);
        } else {
            aVar.a(15, (Object) null);
        }
    }
}

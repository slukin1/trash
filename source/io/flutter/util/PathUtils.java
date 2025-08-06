package io.flutter.util;

import android.content.Context;
import android.os.Build;
import java.io.File;

public final class PathUtils {
    public static String getCacheDirectory(Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 21) {
            file = context.getCodeCacheDir();
            if (file == null) {
                file = context.getCacheDir();
            }
        } else {
            file = context.getCacheDir();
        }
        if (file == null) {
            file = new File(getDataDirPath(context), "cache");
        }
        return file.getPath();
    }

    private static String getDataDirPath(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir().getPath();
        }
        return context.getApplicationInfo().dataDir;
    }

    public static String getDataDirectory(Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(getDataDirPath(context), "app_flutter");
        }
        return dir.getPath();
    }

    public static String getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(getDataDirPath(context), "files");
        }
        return filesDir.getPath();
    }
}

package com.blankj.utilcode.util;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63541a = System.getProperty("line.separator");

    public static class a implements FileFilter {
        public boolean accept(File file) {
            return true;
        }
    }

    public static class b implements FileFilter {
        public boolean accept(File file) {
            return true;
        }
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean c(File file) {
        return e(file, new a());
    }

    public static boolean d(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !d(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean e(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !d(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static File f(String str) {
        if (a0.C(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean g(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean h(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return i(file.getAbsolutePath());
    }

    public static boolean i(String str) {
        File f11 = f(str);
        if (f11 == null) {
            return false;
        }
        if (f11.exists()) {
            return true;
        }
        return j(str);
    }

    public static boolean j(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Utils.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static List<File> k(File file, boolean z11, Comparator<File> comparator) {
        return m(file, new b(), z11, comparator);
    }

    public static List<File> l(File file, FileFilter fileFilter) {
        return m(file, fileFilter, false, (Comparator<File>) null);
    }

    public static List<File> m(File file, FileFilter fileFilter, boolean z11, Comparator<File> comparator) {
        List<File> n11 = n(file, fileFilter, z11);
        if (comparator != null) {
            Collections.sort(n11, comparator);
        }
        return n11;
    }

    public static List<File> n(File file, FileFilter fileFilter, boolean z11) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (g(file) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z11 && file2.isDirectory()) {
                    arrayList.addAll(n(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }
}

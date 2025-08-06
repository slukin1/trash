package com.mob.tools.utils;

import android.os.Build;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils implements PublicMemberKeeper {
    private static boolean a(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    public static boolean copyFile(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                try {
                    MobLog.getInstance().d(th);
                    v.a(bufferedInputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th3) {
                    v.a(bufferedInputStream, bufferedOutputStream);
                    throw th3;
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read > 0) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        v.a(bufferedInputStream2, bufferedOutputStream);
                        return true;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = bufferedInputStream2;
                MobLog.getInstance().d(th);
                v.a(bufferedInputStream, bufferedOutputStream);
                return false;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            MobLog.getInstance().d(th);
            v.a(bufferedInputStream, bufferedOutputStream);
            return false;
        }
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    public static boolean deleteAllInDir(String str) {
        return deleteAllInDir(getFileByPath(str));
    }

    public static boolean deleteDir(File file) {
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
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        return deleteFile(getFileByPath(str));
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
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
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !deleteDir(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static File getFileByPath(String str) {
        if (a(str)) {
            return null;
        }
        return new File(str);
    }

    public static long getLATime(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                return Files.readAttributes(FileSystems.getDefault().getPath(file.getAbsolutePath(), new String[0]), BasicFileAttributes.class, new LinkOption[0]).lastAccessTime().toMillis();
            }
            return -1;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return -1;
        }
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static boolean deleteAllInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        });
    }

    public static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || a(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        if (file2.exists() || !file.renameTo(file2)) {
            return false;
        }
        return true;
    }
}

package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;

public class FileUtil {
    private static final String TAG = "FileUtil";

    private static String getAppName(Context context) {
        return String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
    }

    public static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String getMimeType(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(com.tencent.qcloud.tuikit.timcommon.util.FileUtil.getFileExtensionFromUrl(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0038 A[SYNTHETIC, Splitter:B:23:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[Catch:{ IOException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004b A[SYNTHETIC, Splitter:B:35:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0053 A[Catch:{ IOException -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveFileFromPath(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0034 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0034 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0048, all -> 0x0034 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0048, all -> 0x0034 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0049, all -> 0x0032 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0049, all -> 0x0032 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0030, all -> 0x002d }
        L_0x0015:
            int r1 = r4.read(r5)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r3 = -1
            if (r1 == r3) goto L_0x0020
            r2.write(r5, r0, r1)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            goto L_0x0015
        L_0x0020:
            r4.close()     // Catch:{ IOException -> 0x0027 }
            r2.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002b:
            r4 = 1
            return r4
        L_0x002d:
            r5 = move-exception
            r1 = r4
            goto L_0x0036
        L_0x0030:
            r1 = r4
            goto L_0x0049
        L_0x0032:
            r5 = move-exception
            goto L_0x0036
        L_0x0034:
            r5 = move-exception
            r2 = r1
        L_0x0036:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003e
        L_0x003c:
            r4 = move-exception
            goto L_0x0044
        L_0x003e:
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0047
        L_0x0044:
            r4.printStackTrace()
        L_0x0047:
            throw r5
        L_0x0048:
            r2 = r1
        L_0x0049:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0051
        L_0x004f:
            r4 = move-exception
            goto L_0x0057
        L_0x0051:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x005a
        L_0x0057:
            r4.printStackTrace()
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.util.FileUtil.saveFileFromPath(java.io.File, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC, Splitter:B:23:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003f A[Catch:{ IOException -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004a A[SYNTHETIC, Splitter:B:35:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0052 A[Catch:{ IOException -> 0x004e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveFileToUri(android.content.ContentResolver r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0047, all -> 0x0033 }
            java.io.OutputStream r3 = r3.openOutputStream(r4)     // Catch:{ IOException -> 0x0047, all -> 0x0033 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0047, all -> 0x0033 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0048, all -> 0x0031 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0031 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x002f, all -> 0x002c }
        L_0x0014:
            int r5 = r3.read(r4)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r1 = -1
            if (r5 == r1) goto L_0x001f
            r2.write(r4, r0, r5)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            goto L_0x0014
        L_0x001f:
            r3.close()     // Catch:{ IOException -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002a:
            r3 = 1
            return r3
        L_0x002c:
            r4 = move-exception
            r1 = r3
            goto L_0x0035
        L_0x002f:
            r1 = r3
            goto L_0x0048
        L_0x0031:
            r4 = move-exception
            goto L_0x0035
        L_0x0033:
            r4 = move-exception
            r2 = r1
        L_0x0035:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r3 = move-exception
            goto L_0x0043
        L_0x003d:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x0046
        L_0x0043:
            r3.printStackTrace()
        L_0x0046:
            throw r4
        L_0x0047:
            r2 = r1
        L_0x0048:
            if (r1 == 0) goto L_0x0050
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0050
        L_0x004e:
            r3 = move-exception
            goto L_0x0056
        L_0x0050:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0059
        L_0x0056:
            r3.printStackTrace()
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.util.FileUtil.saveFileToUri(android.content.ContentResolver, android.net.Uri, java.lang.String):boolean");
    }

    public static boolean saveImageToGallery(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return saveImageToGalleryByMediaStore(context, str);
        }
        return saveImageToGalleryByFile(context, str);
    }

    public static boolean saveImageToGalleryByFile(Context context, String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + getAppName(context) + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + getFileName(str);
        if (!str3.endsWith(PictureMimeType.JPG)) {
            str3 = str3 + PictureMimeType.JPG;
        }
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        if (!saveFileFromPath(file2, str)) {
            return false;
        }
        MediaScannerConnection.scanFile(context, new String[]{str3}, new String[]{getMimeType(str)}, (MediaScannerConnection.OnScanCompletedListener) null);
        return true;
    }

    public static boolean saveImageToGalleryByMediaStore(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            TUIChatLog.e(TAG, "param invalid");
            return false;
        }
        String fileName = getFileName(str);
        String mimeType = getMimeType(str);
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        long j11 = currentTimeMillis / 1000;
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("_display_name", fileName);
        contentValues.put("mime_type", mimeType);
        Uri contentUri = MediaStore.Images.Media.getContentUri("external_primary");
        contentValues.put("is_pending", 1);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/" + getAppName(context) + "/");
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri insert = contentResolver.insert(contentUri, contentValues);
            if (insert == null) {
                return false;
            }
            if (!saveFileToUri(contentResolver, insert, str)) {
                contentResolver.delete(insert, (String) null, (String[]) null);
                return false;
            }
            contentValues.clear();
            contentValues.put("is_pending", 0);
            contentResolver.update(insert, contentValues, (String) null, (String[]) null);
            MediaScannerConnection.scanFile(context, new String[]{insert.toString()}, new String[]{mimeType}, (MediaScannerConnection.OnScanCompletedListener) null);
            return true;
        } catch (IllegalArgumentException e11) {
            String str2 = TAG;
            TUIChatLog.e(str2, "saveImageToGalleryByMediaStore failed, " + e11.getMessage());
            return false;
        }
    }

    public static boolean saveVideoToGallery(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return saveVideoToGalleryByMediaStore(context, str);
        }
        return saveVideoToGalleryByFile(context, str);
    }

    public static boolean saveVideoToGalleryByFile(Context context, String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES) + "/" + getAppName(context) + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + getFileName(str);
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        if (!saveFileFromPath(file2, str)) {
            return false;
        }
        MediaScannerConnection.scanFile(context, new String[]{str3}, new String[]{getMimeType(str)}, (MediaScannerConnection.OnScanCompletedListener) null);
        return true;
    }

    public static boolean saveVideoToGalleryByMediaStore(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            TUIChatLog.e(TAG, "param invalid");
            return false;
        }
        String fileName = getFileName(str);
        String mimeType = getMimeType(str);
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        long j11 = currentTimeMillis / 1000;
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("_display_name", fileName);
        contentValues.put("mime_type", mimeType);
        Uri contentUri = MediaStore.Video.Media.getContentUri("external_primary");
        contentValues.put("is_pending", 1);
        contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + "/" + getAppName(context) + "/");
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri insert = contentResolver.insert(contentUri, contentValues);
            if (insert == null) {
                return false;
            }
            if (!saveFileToUri(contentResolver, insert, str)) {
                contentResolver.delete(insert, (String) null, (String[]) null);
                return false;
            }
            contentValues.clear();
            contentValues.put("is_pending", 0);
            contentResolver.update(insert, contentValues, (String) null, (String[]) null);
            MediaScannerConnection.scanFile(context, new String[]{insert.toString()}, new String[]{mimeType}, (MediaScannerConnection.OnScanCompletedListener) null);
            return true;
        } catch (IllegalArgumentException e11) {
            String str2 = TAG;
            TUIChatLog.e(str2, "saveVideoToGalleryByMediaStore failed, " + e11.getMessage());
            return false;
        }
    }
}

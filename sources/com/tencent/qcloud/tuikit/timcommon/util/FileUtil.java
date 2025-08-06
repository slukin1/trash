package com.tencent.qcloud.tuikit.timcommon.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtil {
    public static final String DOCUMENTS_DIR = "documents";
    public static final String FILE_PROVIDER_AUTH = ".timcommon.fileprovider";
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String formatFileSize(long j11) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j11 == 0) {
            return "0B";
        }
        if (j11 < 1024) {
            return decimalFormat.format((double) j11) + "B";
        } else if (j11 < 1048576) {
            return decimalFormat.format(((double) j11) / 1024.0d) + "KB";
        } else if (j11 < 1073741824) {
            return decimalFormat.format(((double) j11) / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(((double) j11) / 1.073741824E9d) + "GB";
        }
    }

    public static File generateFileName(String str, File file) {
        String str2;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int lastIndexOf = str.lastIndexOf(46);
            int i11 = 0;
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                str2 = str.substring(lastIndexOf);
                str = substring;
            } else {
                str2 = "";
            }
            while (file2.exists()) {
                i11++;
                file2 = new File(file, str + '(' + i11 + ')' + str2);
            }
        }
        try {
            if (!file2.createNewFile()) {
                return null;
            }
            return file2;
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r8 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r8 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r8 == 0) goto L_0x0029
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0027 }
            if (r9 == 0) goto L_0x0029
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            goto L_0x0030
        L_0x0029:
            if (r8 == 0) goto L_0x0038
            goto L_0x0035
        L_0x002c:
            r9 = move-exception
            goto L_0x003b
        L_0x002e:
            r9 = move-exception
            r8 = r7
        L_0x0030:
            r9.printStackTrace()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0038
        L_0x0035:
            r8.close()
        L_0x0038:
            return r7
        L_0x0039:
            r9 = move-exception
            r7 = r8
        L_0x003b:
            if (r7 == 0) goto L_0x0040
            r7.close()
        L_0x0040:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.FileUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static File getDocumentCacheDir(Context context) {
        File file = new File(context.getCacheDir(), DOCUMENTS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileExtensionFromUrl(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0046
            r0 = 35
            int r0 = r2.lastIndexOf(r0)
            r1 = 0
            if (r0 <= 0) goto L_0x0013
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x0013:
            r0 = 63
            int r0 = r2.lastIndexOf(r0)
            if (r0 <= 0) goto L_0x001f
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x001f:
            r0 = 47
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x002d
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x002d:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0046
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0046
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
            java.lang.String r2 = r2.toLowerCase()
            return r2
        L_0x0046:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.FileUtil.getFileExtensionFromUrl(java.lang.String):java.lang.String");
    }

    public static String getFileName(Context context, Uri uri) {
        if (context.getContentResolver().getType(uri) == null) {
            return getName(uri.toString());
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex("_display_name");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        query.close();
        return string;
    }

    public static long getFileSize(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    private static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public static String getPath(Context context, Uri uri) {
        int i11 = Build.VERSION.SDK_INT;
        Uri uri2 = null;
        if (!(i11 >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                String dataColumn = getDataColumn(context, uri, (String) null, (String[]) null);
                return (TextUtils.isEmpty(dataColumn) || i11 >= 29) ? getPathByCopyFile(context, uri) : dataColumn;
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if (!"primary".equalsIgnoreCase(split[0])) {
                return getPathByCopyFile(context, uri);
            }
            return Environment.getExternalStorageDirectory() + "/" + split[1];
        } else if (isDownloadsDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (documentId.startsWith("raw:")) {
                return documentId.replaceFirst("raw:", "");
            }
            String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
            for (int i12 = 0; i12 < 3; i12++) {
                try {
                    String dataColumn2 = getDataColumn(context, ContentUris.withAppendedId(Uri.parse(strArr[i12]), Long.parseLong(documentId)), (String) null, (String[]) null);
                    if (dataColumn2 != null && Build.VERSION.SDK_INT < 29) {
                        return dataColumn2;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            return getPathByCopyFile(context, uri);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            String dataColumn3 = getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            return (TextUtils.isEmpty(dataColumn3) || i11 >= 29) ? getPathByCopyFile(context, uri) : dataColumn3;
        }
        return null;
    }

    private static String getPathByCopyFile(Context context, Uri uri) {
        File generateFileName = generateFileName(getFileName(context, uri), getDocumentCacheDir(context));
        if (generateFileName == null) {
            return null;
        }
        String absolutePath = generateFileName.getAbsolutePath();
        if (saveFileFromUri(context, uri, absolutePath)) {
            return absolutePath;
        }
        generateFileName.delete();
        return null;
    }

    public static String getPathFromUri(Uri uri) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                str = getPathByCopyFile(TUILogin.getAppContext(), uri);
            } else {
                str = getRealFilePath(uri);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getRealFilePath(Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (query = TUILogin.getAppContext().getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static Uri getUriFromPath(String str) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return Uri.fromFile(new File(str));
            }
            Context appContext = TUIConfig.getAppContext();
            return FileProvider.getUriForFile(appContext, TUIConfig.getAppContext().getApplicationInfo().packageName + FILE_PROVIDER_AUTH, new File(str));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void openFile(String str, String str2) {
        String str3;
        Context appContext = TUIConfig.getAppContext();
        Uri uriForFile = FileProvider.getUriForFile(appContext, TUIConfig.getAppContext().getApplicationInfo().packageName + FILE_PROVIDER_AUTH, new File(str));
        if (uriForFile == null) {
            Log.e("FileUtil", "openFile failed , uri is null");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = getFileExtensionFromUrl(str);
        } else {
            str3 = getFileExtensionFromUrl(str2);
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str3);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, mimeTypeFromExtension);
        try {
            Intent createChooser = Intent.createChooser(intent, TUIConfig.getAppContext().getString(R.string.open_file_tips));
            createChooser.addFlags(268435456);
            TUIConfig.getAppContext().startActivity(createChooser);
        } catch (Exception e11) {
            Log.e("FileUtil", "openFile failed , " + e11.getMessage());
        }
    }

    public static String saveBitmap(String str, Bitmap bitmap) {
        String str2 = TUIConfig.getMediaDir() + "picture_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + PictureMimeType.JPG;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str2;
        } catch (IOException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0046 A[SYNTHETIC, Splitter:B:30:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004e A[Catch:{ IOException -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0059 A[SYNTHETIC, Splitter:B:40:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0061 A[Catch:{ IOException -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean saveFileFromUri(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            r2.<init>(r5, r1)     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0032, all -> 0x0030 }
        L_0x0018:
            int r0 = r3.read(r5)     // Catch:{ IOException -> 0x0032, all -> 0x0030 }
            r2 = -1
            if (r0 == r2) goto L_0x0023
            r4.write(r5, r1, r0)     // Catch:{ IOException -> 0x0032, all -> 0x0030 }
            goto L_0x0018
        L_0x0023:
            r3.close()     // Catch:{ IOException -> 0x002a }
            r4.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002e:
            r3 = 1
            return r3
        L_0x0030:
            r5 = move-exception
            goto L_0x0036
        L_0x0032:
            r5 = move-exception
            goto L_0x003a
        L_0x0034:
            r5 = move-exception
            r4 = r0
        L_0x0036:
            r0 = r3
            goto L_0x0057
        L_0x0038:
            r5 = move-exception
            r4 = r0
        L_0x003a:
            r0 = r3
            goto L_0x0041
        L_0x003c:
            r5 = move-exception
            r4 = r0
            goto L_0x0057
        L_0x003f:
            r5 = move-exception
            r4 = r0
        L_0x0041:
            r5.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x004c
            r0.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004c
        L_0x004a:
            r3 = move-exception
            goto L_0x0052
        L_0x004c:
            if (r4 == 0) goto L_0x0055
            r4.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x0055
        L_0x0052:
            r3.printStackTrace()
        L_0x0055:
            return r1
        L_0x0056:
            r5 = move-exception
        L_0x0057:
            if (r0 == 0) goto L_0x005f
            r0.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x005f
        L_0x005d:
            r3 = move-exception
            goto L_0x0065
        L_0x005f:
            if (r4 == 0) goto L_0x0068
            r4.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0068
        L_0x0065:
            r3.printStackTrace()
        L_0x0068:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.util.FileUtil.saveFileFromUri(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }
}

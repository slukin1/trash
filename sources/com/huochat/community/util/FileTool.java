package com.huochat.community.util;

import android.app.Application;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.MimeTypes;
import com.hbg.lib.common.BaseApplication;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huochat.community.network.domain.DomainTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.PictureMimeType;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FileTool {
    public static final String[] AUDIO_EXTS = {".flac", ".FLAC", ".ape", ".APE", ".wv", ".WV", ".mpc", ".MPC", "m4a", "M4A", PictureMimeType.WAV, ".WAV", PictureMimeType.MP3, ".MP3", ".wma", ".WMA", ".ogg", ".OGG", ".3gpp", ".3GPP", ".aac", ".AAC"};
    public static final String BOOKMARK_EXT = ".bmark";
    private static final int BUF_SIZE = 1024;
    public static final String CUE_EXT = ".cue";
    public static final String CUSTOM_PLAYLIST_EXT = ".playlist";
    private static final String DOWNLOAD_DIRECTORY = "HuoChat";
    public static final String HASH_TYPE_MD5 = "MD5";
    public static final String HASH_TYPE_SHA1 = "SHA1";
    public static final String HASH_TYPE_SHA1_256 = "SHA-256";
    public static final String HASH_TYPE_SHA1_384 = "SHA-384";
    public static final String HASH_TYPE_SHA1_512 = "SHA-512";
    public static final String[] LOSSLESS_EXTS = {".flac", ".FLAC", ".ape", ".APE", ".wv", ".WV", ".mpc", ".MPC", "m4a", "M4A", PictureMimeType.WAV, ".WAV"};
    public static final String[] LOSS_EXTS = {PictureMimeType.MP3, ".MP3", ".wma", ".WMA", ".ogg", ".OGG", ".3gpp", ".3GPP", ".aac", ".AAC"};
    public static final String[][] MIME_MapTable = {new String[]{".3gp", MimeTypes.VIDEO_H263}, new String[]{".apk", "application/vnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{PictureMimeType.AVI, "video/x-msvideo"}, new String[]{".bin", "application/octet-stream"}, new String[]{PictureMimeType.BMP, "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", "application/octet-stream"}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{".xls", "application/vnd.ms-excel"}, new String[]{".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{".exe", "application/octet-stream"}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{".gz", "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "text/html"}, new String[]{".html", "text/html"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{PictureMimeType.JPG, "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", MimeTypes.AUDIO_AAC}, new String[]{".m4b", MimeTypes.AUDIO_AAC}, new String[]{".m4p", MimeTypes.AUDIO_AAC}, new String[]{".m4u", "video/vnd.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{PictureMimeType.MP3, "audio/x-mpeg"}, new String[]{PictureMimeType.MP4, "video/mp4"}, new String[]{".mpc", "application/vnd.mpohun.certificate"}, new String[]{".mpe", MimeTypes.VIDEO_MPEG}, new String[]{".mpeg", MimeTypes.VIDEO_MPEG}, new String[]{".mpg", MimeTypes.VIDEO_MPEG}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "application/vnd.ms-outlook"}, new String[]{".ogg", MimeTypes.AUDIO_OGG}, new String[]{".pdf", "application/pdf"}, new String[]{PictureMimeType.PNG, PictureMimeType.PNG_Q}, new String[]{".pps", "application/vnd.ms-powerpoint"}, new String[]{".ppt", "application/vnd.ms-powerpoint"}, new String[]{".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{".prop", "text/plain"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{".txt", "text/plain"}, new String[]{PictureMimeType.WAV, PictureMimeType.WAV_Q}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "application/vnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/x-zip-compressed"}, new String[]{"", "*/*"}};
    public static final long ONE_GB = 1073741824;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;
    public static final String[] PLAYLIST_EXTS = {CUSTOM_PLAYLIST_EXT, ".m3u", ".M3U", ".pls", ".PLS"};
    public static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final ArrayList<String> mWildCardChars;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        mWildCardChars = arrayList;
        arrayList.add("\\");
        arrayList.add("/");
        arrayList.add(":");
        arrayList.add("*");
        arrayList.add("?");
        arrayList.add("\"");
        arrayList.add("<");
        arrayList.add(">");
        arrayList.add(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    }

    public static String byteCountToDisplaySize(long j11) {
        long j12 = j11 / 1073741824;
        if (j12 > 0) {
            return String.valueOf(j12) + " GB";
        }
        long j13 = j11 / 1048576;
        if (j13 > 0) {
            return String.valueOf(j13) + " MB";
        }
        long j14 = j11 / 1024;
        if (j14 > 0) {
            return String.valueOf(j14) + " KB";
        }
        return String.valueOf(j11) + " bytes";
    }

    public static void checkDir(String str) {
        createNewDirectory(new File(str));
    }

    public static String checkFile(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.isFile()) {
            try {
                return file.getCanonicalPath();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static boolean clearDir(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        for (File file2 : file.listFiles()) {
            if (file2.exists()) {
                if (file2.isFile()) {
                    file2.delete();
                }
                if (file2.isDirectory()) {
                    clearDir(file2.getAbsolutePath());
                }
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return true;
        }
        return false;
    }

    public static void clearFile(Context context, String str) {
        File file;
        if (context != null && !TextUtils.isEmpty(str) && (file = getFile(context, str)) != null) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void clearFiles(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getName().endsWith(str2)) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static String clearWildCardChars(String str) {
        try {
            Iterator<String> it2 = mWildCardChars.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (str.contains(next)) {
                    str = str.replace(next, "");
                }
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void copyFile(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (FileNotFoundException e11) {
                e11.printStackTrace();
            } catch (IOException e12) {
                e12.printStackTrace();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        }
    }

    public static boolean createNewDirectory(File file) {
        if (!file.exists() || !file.isDirectory()) {
            return file.mkdirs();
        }
        return false;
    }

    public static String createThumbnailForVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Application b11 = BaseApplication.b();
        File externalFile = getExternalFile(b11, "thumb", "img_" + EncryptTool.md5(str) + PictureMimeType.JPG);
        if (externalFile.exists()) {
            return externalFile.getAbsolutePath();
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (URLUtil.isNetworkUrl(str)) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            externalFile.createNewFile();
            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(externalFile));
            return externalFile.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean delAllFile(String str) {
        File file;
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            return false;
        }
        String[] list = file2.list();
        for (int i11 = 0; i11 < list.length; i11++) {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                file = new File(str + list[i11]);
            } else {
                file = new File(str + str2 + list[i11]);
            }
            if (file.isFile()) {
                file.delete();
            }
            if (file.isDirectory()) {
                delAllFile(str + "/" + list[i11]);
                delDirectory(str + "/" + list[i11]);
            }
        }
        return isEmpty(file2);
    }

    public static boolean delAllFileWithoutDir(String str) {
        File file;
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            return false;
        }
        String[] list = file2.list();
        for (int i11 = 0; i11 < list.length; i11++) {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                file = new File(str + list[i11]);
            } else {
                file = new File(str + str2 + list[i11]);
            }
            if (file.isFile()) {
                file.delete();
            }
            if (file.isDirectory()) {
                delAllFileWithoutDir(str + "/" + list[i11]);
            }
        }
        return isEmpty(file2);
    }

    public static void delDirectory(String str) {
        try {
            delAllFile(str);
            new File(str).delete();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static String filterFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace(' ', '_').replace('\"', '_').replace('\'', '_').replace('\\', '_').replace('/', '_').replace('<', '_').replace('>', '_').replace('|', '_').replace('?', '_').replace(':', '_').replace(',', '_').replace('*', '_');
    }

    public static String generateFileName(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return MD5Tool.getMD5Str(String.valueOf(System.currentTimeMillis()));
        }
        StringBuilder sb2 = new StringBuilder("HX");
        sb2.append(str);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(bitmap.getByteCount());
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(bitmap.getDensity());
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(bitmap.getWidth());
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(bitmap.getHeight());
        d.b("#######  fielname md5: " + MD5Tool.getMD5Str(sb2.toString()));
        return MD5Tool.getMD5Str(sb2.toString());
    }

    public static File getCacheDir(String str) {
        File file;
        if (sdCardIsAvailable()) {
            file = new File(BaseApplication.b().getExternalCacheDir(), str);
        } else {
            file = new File(BaseApplication.b().getCacheDir(), str);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getCacheFilePath(Context context, String str) {
        String str2;
        if ("mounted".equals(Environment.getExternalStorageState()) || sdCardIsAvailable()) {
            str2 = context.getExternalCacheDir().getAbsolutePath();
        } else {
            str2 = context.getCacheDir() + File.separator + str;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        d.b("filepath====>" + str2);
        return str2;
    }

    public static String getCameraDir() {
        File file;
        if (sdCardIsAvailable()) {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), OptionsBridge.CAMERA_KEY);
        } else {
            file = new File(BaseApplication.b().getFilesDir(), "image");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getContentType(String str) {
        String str2;
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (str == null) {
            return "application/octet-stream";
        }
        try {
            str2 = MimeTypeMap.getFileExtensionFromUrl(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            str2 = "";
        }
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str2);
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r8 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r8 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0051, all -> 0x004a }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0051, all -> 0x004a }
            if (r8 == 0) goto L_0x0047
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            if (r9 == 0) goto L_0x0047
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            java.lang.String r10 = "content://"
            boolean r10 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            if (r10 != 0) goto L_0x0040
            java.lang.String r10 = "/"
            boolean r10 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            if (r10 != 0) goto L_0x003c
            java.lang.String r10 = "file://"
            boolean r10 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0052, all -> 0x0044 }
            if (r10 != 0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            r8.close()
            return r9
        L_0x0040:
            r8.close()
            return r7
        L_0x0044:
            r9 = move-exception
            r7 = r8
            goto L_0x004b
        L_0x0047:
            if (r8 == 0) goto L_0x0057
            goto L_0x0054
        L_0x004a:
            r9 = move-exception
        L_0x004b:
            if (r7 == 0) goto L_0x0050
            r7.close()
        L_0x0050:
            throw r9
        L_0x0051:
            r8 = r7
        L_0x0052:
            if (r8 == 0) goto L_0x0057
        L_0x0054:
            r8.close()
        L_0x0057:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getDownloadDir(String str) {
        File file;
        if (sdCardIsAvailable()) {
            file = BaseApplication.b().getExternalFilesDir(DOWNLOAD_DIRECTORY);
        } else {
            file = new File(BaseApplication.b().getFilesDir(), DOWNLOAD_DIRECTORY);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str)) {
            return file.getAbsolutePath();
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getAbsolutePath();
    }

    public static String getExtension(String str) {
        try {
            return InstructionFileId.DOT + MimeTypeMap.getFileExtensionFromUrl(str);
        } catch (Exception e11) {
            d.b(e11.getMessage());
            return "";
        }
    }

    public static String getExternalDCIMPath(Context context, String str) {
        String str2 = "";
        try {
            if (sdCardIsAvailable()) {
                if (Build.BRAND.equals("Xiaomi")) {
                    str2 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
                } else {
                    str2 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/";
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (context != null && TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir() + "/DCIM/" + File.separator + str;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        d.b("filepath====>" + str2);
        return str2;
    }

    public static File getExternalFile(Context context, String str, String str2) {
        if (!ContextTool.checkContext(context) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        if (sdCardIsAvailable()) {
            try {
                return new File(context.getExternalFilesDir(str).getAbsolutePath() + File.separator + str2);
            } catch (Exception unused) {
            }
        }
        return new File(context.getCacheDir().getAbsolutePath() + File.separator + str2);
    }

    public static File getFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(getFilePath(context, "") + str);
    }

    public static File getFileByAbsolutePath(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A[Catch:{ Exception -> 0x0092 }, LOOP:0: B:27:0x0050->B:60:0x0050, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileCharset(java.lang.String r8) {
        /*
            java.lang.String r0 = "GBK"
            r1 = 3
            byte[] r2 = new byte[r1]
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0092 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0092 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0092 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0092 }
            r3.mark(r1)     // Catch:{ Exception -> 0x0092 }
            r8 = 0
            int r1 = r3.read(r2, r8, r1)     // Catch:{ Exception -> 0x0092 }
            r4 = -1
            if (r1 != r4) goto L_0x001b
            return r0
        L_0x001b:
            byte r1 = r2[r8]     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "UTF-8"
            r6 = -2
            r7 = 1
            if (r1 != r4) goto L_0x002b
            byte r1 = r2[r7]     // Catch:{ Exception -> 0x0092 }
            if (r1 != r6) goto L_0x002b
            java.lang.String r0 = "UTF-16LE"
        L_0x0029:
            r8 = r7
            goto L_0x004b
        L_0x002b:
            byte r1 = r2[r8]     // Catch:{ Exception -> 0x0092 }
            if (r1 != r6) goto L_0x0036
            byte r1 = r2[r7]     // Catch:{ Exception -> 0x0092 }
            if (r1 != r4) goto L_0x0036
            java.lang.String r0 = "UTF-16BE"
            goto L_0x0029
        L_0x0036:
            byte r1 = r2[r8]     // Catch:{ Exception -> 0x0092 }
            r6 = -17
            if (r1 != r6) goto L_0x004b
            byte r1 = r2[r7]     // Catch:{ Exception -> 0x0092 }
            r6 = -69
            if (r1 != r6) goto L_0x004b
            r1 = 2
            byte r1 = r2[r1]     // Catch:{ Exception -> 0x0092 }
            r2 = -65
            if (r1 != r2) goto L_0x004b
            r0 = r5
            goto L_0x0029
        L_0x004b:
            r3.reset()     // Catch:{ Exception -> 0x0092 }
            if (r8 != 0) goto L_0x008e
        L_0x0050:
            int r8 = r3.read()     // Catch:{ Exception -> 0x0092 }
            if (r8 == r4) goto L_0x008e
            r1 = 240(0xf0, float:3.36E-43)
            if (r8 < r1) goto L_0x005b
            goto L_0x008e
        L_0x005b:
            r1 = 191(0xbf, float:2.68E-43)
            r2 = 128(0x80, float:1.794E-43)
            if (r2 > r8) goto L_0x0064
            if (r8 > r1) goto L_0x0064
            goto L_0x008e
        L_0x0064:
            r6 = 192(0xc0, float:2.69E-43)
            if (r6 > r8) goto L_0x0075
            r6 = 223(0xdf, float:3.12E-43)
            if (r8 > r6) goto L_0x0075
            int r8 = r3.read()     // Catch:{ Exception -> 0x0092 }
            if (r2 > r8) goto L_0x008e
            if (r8 > r1) goto L_0x008e
            goto L_0x0050
        L_0x0075:
            r6 = 224(0xe0, float:3.14E-43)
            if (r6 > r8) goto L_0x0050
            r6 = 239(0xef, float:3.35E-43)
            if (r8 > r6) goto L_0x0050
            int r8 = r3.read()     // Catch:{ Exception -> 0x0092 }
            if (r2 > r8) goto L_0x008e
            if (r8 > r1) goto L_0x008e
            int r8 = r3.read()     // Catch:{ Exception -> 0x0092 }
            if (r2 > r8) goto L_0x008e
            if (r8 > r1) goto L_0x008e
            r0 = r5
        L_0x008e:
            r3.close()     // Catch:{ Exception -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0096:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "getFileCharset, charset="
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            i6.d.b(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.getFileCharset(java.lang.String):java.lang.String");
    }

    public static String getFileName(String str) {
        if (str == null) {
            return null;
        }
        String str2 = File.separator;
        return str.indexOf(str2) > 0 ? str.substring(str.lastIndexOf(str2) + 1) : str;
    }

    public static String getFileNameNoPostfix(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(File.separator) + 1);
    }

    public static String getFilePath(Context context, String str) {
        String str2;
        if ("mounted".equals(Environment.getExternalStorageState()) || sdCardIsAvailable()) {
            str2 = context.getExternalFilesDir(str).getAbsolutePath();
        } else {
            str2 = context.getFilesDir() + File.separator + str;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static long getFolderSize(File file) throws IllegalArgumentException {
        long length;
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException("Invalid   folder ");
        }
        String[] list = file.list();
        long j11 = 0;
        if (list != null && list.length >= 1) {
            for (String file2 : list) {
                File file3 = new File(file, file2);
                if (file3.isDirectory()) {
                    length = getFolderSize(file3);
                } else if (file3.isFile()) {
                    length = file3.length();
                }
                j11 += length;
            }
        }
        return j11;
    }

    public static String getHash(String str, String str2) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(str);
        byte[] bArr = new byte[1024];
        MessageDigest instance = MessageDigest.getInstance(str2);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                instance.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return toHexString(instance.digest());
            }
        }
    }

    public static String getMIMEType(File file) {
        if (file == null) {
            return "";
        }
        return getMimeType(file.getName());
    }

    public static String getMimeType(String str) {
        String lowerCase;
        int lastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        String str2 = "*/*";
        if (lastIndexOf < 0 || (lowerCase = str.substring(lastIndexOf, str.length()).toLowerCase()) == "") {
            return str2;
        }
        int i11 = 0;
        while (true) {
            String[][] strArr = MIME_MapTable;
            if (i11 >= strArr.length) {
                return str2;
            }
            if (lowerCase.equals(strArr[i11][0])) {
                str2 = strArr[i11][1];
            }
            i11++;
        }
    }

    public static String getOffsetDecimal(float f11, int i11) {
        float floatValue = new BigDecimal((double) f11).setScale(i11, 4).floatValue();
        return "" + floatValue;
    }

    public static String getUriFilePath(Uri uri) {
        Uri uri2;
        try {
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(BaseApplication.b(), uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    }
                } else if (isDownloadsDocument(uri)) {
                    return getDataColumn(BaseApplication.b(), ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
                } else if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    char c11 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 93166550) {
                        if (hashCode != 100313435) {
                            if (hashCode == 112202875) {
                                if (str.equals("video")) {
                                    c11 = 1;
                                }
                            }
                        } else if (str.equals("image")) {
                            c11 = 0;
                        }
                    } else if (str.equals("audio")) {
                        c11 = 2;
                    }
                    if (c11 == 0) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (c11 == 1) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (c11 != 2) {
                        uri2 = null;
                    } else {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(BaseApplication.b(), uri2, "_id=?", new String[]{split2[1]});
                }
                return null;
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(BaseApplication.b(), uri, (String) null, (String[]) null);
            } else {
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
                return null;
            }
        } catch (Exception e11) {
            d.g(e11);
        }
    }

    public static long getVideoDuration(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (URLUtil.isNetworkUrl(str)) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isAudio(String str) {
        String mimeType = getMimeType(str);
        return mimeType != null && mimeType.startsWith("audio/");
    }

    public static boolean isDirectory(File file) {
        return file.exists() && file.isDirectory();
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isEmpty(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFile(File file) {
        return file.exists() && file.isFile();
    }

    public static boolean isLocal(String str) {
        return str != null && !str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP);
    }

    public static boolean isLosslessSupported(File file) {
        String file2 = file.toString();
        if (file2.endsWith(".flac") || file2.endsWith(".FLAC") || file2.endsWith(".ape") || file2.endsWith(".APE") || file2.endsWith(PictureMimeType.WAV) || file2.endsWith(".WAV") || file2.endsWith(".wv") || file2.endsWith(".WV") || file2.endsWith(".mpc") || file2.endsWith(".MPC") || file2.endsWith(".m4a") || file2.endsWith(".M4A")) {
            return true;
        }
        return false;
    }

    public static boolean isLosslessSupported(String str) {
        return false;
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaUri(String str) {
        return str.startsWith(MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString()) || str.startsWith(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString()) || str.startsWith(MediaStore.Video.Media.INTERNAL_CONTENT_URI.toString()) || str.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString());
    }

    public static boolean isVideo(String str) {
        String mimeType = getMimeType(str);
        return mimeType != null && mimeType.startsWith("video/");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x004d A[SYNTHETIC, Splitter:B:34:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0057 A[SYNTHETIC, Splitter:B:40:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0061 A[SYNTHETIC, Splitter:B:46:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0070 A[SYNTHETIC, Splitter:B:53:0x0070] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0052=Splitter:B:37:0x0052, B:31:0x0048=Splitter:B:31:0x0048, B:43:0x005c=Splitter:B:43:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String loadString(java.io.File r6) {
        /*
            if (r6 == 0) goto L_0x0079
            boolean r0 = r6.exists()
            if (r0 != 0) goto L_0x000a
            goto L_0x0079
        L_0x000a:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005b, SecurityException -> 0x0051, IOException -> 0x0047 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x005b, SecurityException -> 0x0051, IOException -> 0x0047 }
            int r6 = r2.available()     // Catch:{ FileNotFoundException -> 0x0042, SecurityException -> 0x003f, IOException -> 0x003c, all -> 0x0039 }
            r0 = 1024(0x400, float:1.435E-42)
            if (r6 <= r0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r6
        L_0x001f:
            byte[] r3 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x0042, SecurityException -> 0x003f, IOException -> 0x003c, all -> 0x0039 }
        L_0x0021:
            int r4 = r2.read(r3)     // Catch:{ FileNotFoundException -> 0x0042, SecurityException -> 0x003f, IOException -> 0x003c, all -> 0x0039 }
            r5 = -1
            if (r4 == r5) goto L_0x0035
            r1.write(r3)     // Catch:{ FileNotFoundException -> 0x0042, SecurityException -> 0x003f, IOException -> 0x003c, all -> 0x0039 }
            int r6 = r6 - r0
            if (r6 > 0) goto L_0x002f
            goto L_0x0035
        L_0x002f:
            if (r6 >= r0) goto L_0x0032
            r0 = r6
        L_0x0032:
            byte[] r3 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x0042, SecurityException -> 0x003f, IOException -> 0x003c, all -> 0x0039 }
            goto L_0x0021
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0039:
            r6 = move-exception
            r0 = r2
            goto L_0x006e
        L_0x003c:
            r6 = move-exception
            r0 = r2
            goto L_0x0048
        L_0x003f:
            r6 = move-exception
            r0 = r2
            goto L_0x0052
        L_0x0042:
            r6 = move-exception
            r0 = r2
            goto L_0x005c
        L_0x0045:
            r6 = move-exception
            goto L_0x006e
        L_0x0047:
            r6 = move-exception
        L_0x0048:
            r6.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0069
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0051:
            r6 = move-exception
        L_0x0052:
            r6.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0069
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x005b:
            r6 = move-exception
        L_0x005c:
            r6.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0069
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            java.lang.String r6 = r1.toString()
            return r6
        L_0x006e:
            if (r0 == 0) goto L_0x0078
            r0.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0078:
            throw r6
        L_0x0079:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.loadString(java.io.File):java.lang.String");
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a A[SYNTHETIC, Splitter:B:31:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004f A[Catch:{ IOException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005b A[SYNTHETIC, Splitter:B:40:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0060 A[Catch:{ IOException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x006c A[SYNTHETIC, Splitter:B:49:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0071 A[Catch:{ IOException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0078 A[SYNTHETIC, Splitter:B:56:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0080 A[Catch:{ IOException -> 0x007c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0045=Splitter:B:28:0x0045, B:37:0x0056=Splitter:B:37:0x0056, B:46:0x0067=Splitter:B:46:0x0067} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object readFileOIS(java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            r1 = 0
            if (r4 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0053, ClassNotFoundException -> 0x0042, all -> 0x003d }
            r4.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0053, ClassNotFoundException -> 0x0042, all -> 0x003d }
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0037, ClassNotFoundException -> 0x0034, all -> 0x002f }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0037, ClassNotFoundException -> 0x0034, all -> 0x002f }
            java.lang.Object r1 = r0.readObject()     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b, ClassNotFoundException -> 0x0029 }
            r0.close()     // Catch:{ IOException -> 0x0023 }
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0074
        L_0x0023:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0074
        L_0x0029:
            r2 = move-exception
            goto L_0x0045
        L_0x002b:
            r2 = move-exception
            goto L_0x0056
        L_0x002d:
            r2 = move-exception
            goto L_0x0067
        L_0x002f:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0076
        L_0x0034:
            r2 = move-exception
            r0 = r1
            goto L_0x0045
        L_0x0037:
            r2 = move-exception
            r0 = r1
            goto L_0x0056
        L_0x003a:
            r2 = move-exception
            r0 = r1
            goto L_0x0067
        L_0x003d:
            r4 = move-exception
            r0 = r1
            r1 = r4
            r4 = r0
            goto L_0x0076
        L_0x0042:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x0045:
            r2.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004d
            r0.close()     // Catch:{ IOException -> 0x0023 }
        L_0x004d:
            if (r4 == 0) goto L_0x0074
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0074
        L_0x0053:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x0056:
            r2.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ IOException -> 0x0023 }
        L_0x005e:
            if (r4 == 0) goto L_0x0074
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0074
        L_0x0064:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x0067:
            r2.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ IOException -> 0x0023 }
        L_0x006f:
            if (r4 == 0) goto L_0x0074
            r4.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0074:
            return r1
        L_0x0075:
            r1 = move-exception
        L_0x0076:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x007e
        L_0x007c:
            r4 = move-exception
            goto L_0x0084
        L_0x007e:
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0087
        L_0x0084:
            r4.printStackTrace()
        L_0x0087:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.readFileOIS(java.lang.String):java.lang.Object");
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().canWrite();
        }
        return false;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(hexChar[(bArr[i11] & 240) >>> 4]);
            sb2.append(hexChar[bArr[i11] & 15]);
        }
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x004d A[SYNTHETIC, Splitter:B:36:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0052 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005f A[SYNTHETIC, Splitter:B:46:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0067 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0073 A[SYNTHETIC, Splitter:B:55:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x007b A[Catch:{ IOException -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0048=Splitter:B:33:0x0048, B:43:0x005a=Splitter:B:43:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeFileOOS(java.lang.String r2, java.lang.Object r3, boolean r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            r1 = 0
            if (r2 != 0) goto L_0x0017
            boolean r2 = r0.createNewFile()     // Catch:{ IOException -> 0x0013 }
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0013:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0017:
            if (r3 != 0) goto L_0x001a
            return r1
        L_0x001a:
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0044, all -> 0x003f }
            r1.<init>(r0, r4)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0044, all -> 0x003f }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
            r4.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
            r4.writeObject(r3)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r4.flush()     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r4.close()     // Catch:{ IOException -> 0x0063 }
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006e
        L_0x0032:
            r2 = move-exception
            goto L_0x0048
        L_0x0034:
            r2 = move-exception
            goto L_0x005a
        L_0x0036:
            r3 = move-exception
            r4 = r2
            goto L_0x0042
        L_0x0039:
            r3 = move-exception
            r4 = r2
            goto L_0x0047
        L_0x003c:
            r3 = move-exception
            r4 = r2
            goto L_0x0059
        L_0x003f:
            r3 = move-exception
            r4 = r2
            r1 = r4
        L_0x0042:
            r2 = r3
            goto L_0x0071
        L_0x0044:
            r3 = move-exception
            r4 = r2
            r1 = r4
        L_0x0047:
            r2 = r3
        L_0x0048:
            r2.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0050
            r4.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0050:
            if (r1 == 0) goto L_0x006e
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006e
        L_0x0056:
            r3 = move-exception
            r4 = r2
            r1 = r4
        L_0x0059:
            r2 = r3
        L_0x005a:
            r2.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0065
            r4.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            r2 = move-exception
            goto L_0x006b
        L_0x0065:
            if (r1 == 0) goto L_0x006e
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006e
        L_0x006b:
            r2.printStackTrace()
        L_0x006e:
            r2 = 1
            return r2
        L_0x0070:
            r2 = move-exception
        L_0x0071:
            if (r4 == 0) goto L_0x0079
            r4.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r3 = move-exception
            goto L_0x007f
        L_0x0079:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0082
        L_0x007f:
            r3.printStackTrace()
        L_0x0082:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeFileOOS(java.lang.String, java.lang.Object, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0035 A[SYNTHETIC, Splitter:B:26:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeStringToFile(java.io.File r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x003e
            if (r4 != 0) goto L_0x0006
            goto L_0x003e
        L_0x0006:
            r1 = 0
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ Exception -> 0x0024 }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x0024 }
            int r3 = r4.length()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r2.write(r4, r0, r3)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r2.flush()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r3 = 1
            r2.close()     // Catch:{ IOException -> 0x002e }
            r0 = r3
            goto L_0x0032
        L_0x001c:
            r3 = move-exception
            r1 = r2
            goto L_0x0033
        L_0x001f:
            r3 = move-exception
            r1 = r2
            goto L_0x0025
        L_0x0022:
            r3 = move-exception
            goto L_0x0033
        L_0x0024:
            r3 = move-exception
        L_0x0025:
            r3.printStackTrace()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0032:
            return r0
        L_0x0033:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003d:
            throw r3
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeStringToFile(java.io.File, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056 A[SYNTHETIC, Splitter:B:30:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005e A[Catch:{ IOException -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086 A[SYNTHETIC, Splitter:B:42:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ IOException -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeToFile(android.content.Context r6, java.io.InputStream r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x009a
            if (r6 == 0) goto L_0x009a
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x000d
            goto L_0x009a
        L_0x000d:
            clearFile(r6, r8)
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            r1.<init>(r7)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            java.io.File r4 = getFile((android.content.Context) r6, (java.lang.String) r8)     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0040 }
        L_0x0027:
            int r3 = r1.read(r0)     // Catch:{ IOException -> 0x0040 }
            r4 = -1
            if (r3 == r4) goto L_0x0033
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ IOException -> 0x0040 }
            goto L_0x0027
        L_0x0033:
            r1.close()     // Catch:{ IOException -> 0x0065 }
            r7.close()     // Catch:{ IOException -> 0x0065 }
            r2.flush()     // Catch:{ IOException -> 0x0065 }
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0040:
            r0 = move-exception
            goto L_0x0051
        L_0x0042:
            r6 = move-exception
            r2 = r0
            goto L_0x0083
        L_0x0045:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0051
        L_0x004a:
            r6 = move-exception
            r2 = r0
            goto L_0x0084
        L_0x004d:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0051:
            r0.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0059:
            r7.close()     // Catch:{ IOException -> 0x0065 }
            if (r2 == 0) goto L_0x0069
            r2.flush()     // Catch:{ IOException -> 0x0065 }
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0069:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r6 = r6.getFilesDir()
            r7.append(r6)
            java.lang.String r6 = java.io.File.separator
            r7.append(r6)
            r7.append(r8)
            java.lang.String r6 = r7.toString()
            return r6
        L_0x0082:
            r6 = move-exception
        L_0x0083:
            r0 = r1
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            r0.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0089:
            r7.close()     // Catch:{ IOException -> 0x0095 }
            if (r2 == 0) goto L_0x0099
            r2.flush()     // Catch:{ IOException -> 0x0095 }
            r2.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0099:
            throw r6
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeToFile(android.content.Context, java.io.InputStream, java.lang.String):java.lang.String");
    }

    public static synchronized String writeToFileSync(InputStream inputStream, String str) throws IOException {
        String writeToFile;
        synchronized (FileTool.class) {
            writeToFile = writeToFile(inputStream, str);
        }
        return writeToFile;
    }

    public static File getFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(str + File.separator + str2);
    }

    public static String byteCountToDisplaySize(long j11, int i11) {
        if (j11 / 1073741824 > 0) {
            return getOffsetDecimal(((float) j11) / 1.07374182E9f, i11) + " GB";
        } else if (j11 / 1048576 > 0) {
            return getOffsetDecimal(((float) j11) / 1048576.0f, i11) + " MB";
        } else if (j11 / 1024 > 0) {
            return getOffsetDecimal(((float) j11) / 1024.0f, i11) + " KB";
        } else {
            return String.valueOf(j11) + " bytes";
        }
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openOutputStream(file);
            if (str != null) {
                if (str2 == null) {
                    fileOutputStream.write(str.getBytes());
                } else {
                    fileOutputStream.write(str.getBytes(str2));
                }
            }
            if (fileOutputStream == null) {
                return;
            }
        } catch (IOException unused) {
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused3) {
        }
    }

    public static String writeToFile(Context context, byte[] bArr, String str) {
        return writeToFile(context, bArr, str, false);
    }

    public static String writeToFile(byte[] bArr, String str, String str2) {
        return writeToFile(bArr, str, str2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[SYNTHETIC, Splitter:B:20:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeToFile(android.content.Context r4, byte[] r5, java.lang.String r6, boolean r7) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0064
            if (r4 == 0) goto L_0x0064
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x000c
            goto L_0x0064
        L_0x000c:
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x002c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002c }
            java.io.File r3 = getFile((android.content.Context) r4, (java.lang.String) r6)     // Catch:{ IOException -> 0x002c }
            r2.<init>(r3, r7)     // Catch:{ IOException -> 0x002c }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002c }
            r1.write(r5)     // Catch:{ IOException -> 0x0027, all -> 0x0024 }
            r1.flush()     // Catch:{ IOException -> 0x0039 }
            r1.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0056
        L_0x0027:
            r5 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x002a:
            r4 = move-exception
            goto L_0x0056
        L_0x002c:
            r5 = move-exception
        L_0x002d:
            r5.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x003d
            r0.flush()     // Catch:{ IOException -> 0x0039 }
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.File r4 = r4.getFilesDir()
            r5.append(r4)
            java.lang.String r4 = java.io.File.separator
            r5.append(r4)
            r5.append(r6)
            java.lang.String r4 = r5.toString()
            return r4
        L_0x0056:
            if (r0 == 0) goto L_0x0063
            r0.flush()     // Catch:{ IOException -> 0x005f }
            r0.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0063:
            throw r4
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeToFile(android.content.Context, byte[], java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC, Splitter:B:22:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0043 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeToFile(byte[] r2, java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0059
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x0059
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            java.io.File r3 = getFile((java.lang.String) r3, (java.lang.String) r4)
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0030 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0030 }
            r1.<init>(r3, r5)     // Catch:{ IOException -> 0x0030 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0030 }
            r4.write(r2)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r4.flush()     // Catch:{ IOException -> 0x003d }
            r4.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x0028:
            r2 = move-exception
            r0 = r4
            goto L_0x004b
        L_0x002b:
            r2 = move-exception
            r0 = r4
            goto L_0x0031
        L_0x002e:
            r2 = move-exception
            goto L_0x004b
        L_0x0030:
            r2 = move-exception
        L_0x0031:
            r2.printStackTrace()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0041
            r0.flush()     // Catch:{ IOException -> 0x003d }
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0041:
            if (r3 != 0) goto L_0x0046
            java.lang.String r2 = ""
            goto L_0x004a
        L_0x0046:
            java.lang.String r2 = r3.getAbsolutePath()
        L_0x004a:
            return r2
        L_0x004b:
            if (r0 == 0) goto L_0x0058
            r0.flush()     // Catch:{ IOException -> 0x0054 }
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0058:
            throw r2
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeToFile(byte[], java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A[SYNTHETIC, Splitter:B:36:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0068 A[Catch:{ IOException -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeToFile(java.io.InputStream r5, java.lang.String r6) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0074
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x000b
            goto L_0x0074
        L_0x000b:
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.lang.String r1 = r1.getParent()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            checkDir(r1)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x004a, all -> 0x0048 }
        L_0x002a:
            int r3 = r1.read(r0)     // Catch:{ IOException -> 0x004a, all -> 0x0048 }
            r4 = -1
            if (r3 == r4) goto L_0x0036
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ IOException -> 0x004a, all -> 0x0048 }
            goto L_0x002a
        L_0x0036:
            r1.close()     // Catch:{ IOException -> 0x0043 }
            r5.close()     // Catch:{ IOException -> 0x0043 }
            r2.flush()     // Catch:{ IOException -> 0x0043 }
            r2.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0047:
            return r6
        L_0x0048:
            r6 = move-exception
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            goto L_0x0052
        L_0x004c:
            r6 = move-exception
            r2 = r0
        L_0x004e:
            r0 = r1
            goto L_0x005e
        L_0x0050:
            r6 = move-exception
            r2 = r0
        L_0x0052:
            r0 = r1
            goto L_0x0059
        L_0x0054:
            r6 = move-exception
            r2 = r0
            goto L_0x005e
        L_0x0057:
            r6 = move-exception
            r2 = r0
        L_0x0059:
            r6.printStackTrace()     // Catch:{ all -> 0x005d }
            throw r6     // Catch:{ all -> 0x005d }
        L_0x005d:
            r6 = move-exception
        L_0x005e:
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x006f }
        L_0x0063:
            r5.close()     // Catch:{ IOException -> 0x006f }
            if (r2 == 0) goto L_0x0073
            r2.flush()     // Catch:{ IOException -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0073:
            throw r6
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.FileTool.writeToFile(java.io.InputStream, java.lang.String):java.lang.String");
    }
}

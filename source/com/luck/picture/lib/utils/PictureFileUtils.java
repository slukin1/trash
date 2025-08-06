package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.Objects;

public class PictureFileUtils {
    private static final int BYTE_SIZE = 1024;
    private static final String POSTFIX_AMR = ".amr";
    private static final String POSTFIX_JPG = ".jpg";
    private static final String POSTFIX_MP4 = ".mp4";
    public static final String TAG = "PictureFileUtils";

    private PictureFileUtils() {
    }

    public static void close(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copyFile(String str, String str2) {
        FileChannel fileChannel;
        if (!str.equalsIgnoreCase(str2)) {
            FileChannel fileChannel2 = null;
            try {
                FileChannel channel = new FileInputStream(str).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(str2).getChannel();
                    channel.transferTo(0, channel.size(), fileChannel2);
                    close(channel);
                    close(fileChannel2);
                } catch (Exception e11) {
                    e = e11;
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel3;
                    try {
                        e.printStackTrace();
                        close(fileChannel2);
                        close(fileChannel);
                    } catch (Throwable th2) {
                        th = th2;
                        close(fileChannel2);
                        close(fileChannel);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    FileChannel fileChannel4 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel4;
                    close(fileChannel2);
                    close(fileChannel);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                fileChannel = null;
                e.printStackTrace();
                close(fileChannel2);
                close(fileChannel);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                close(fileChannel2);
                close(fileChannel);
                throw th;
            }
        }
    }

    public static File createCameraFile(Context context, int i11, String str, String str2, String str3) {
        return createMediaFile(context, i11, str, str2, str3);
    }

    public static String createFilePath(Context context, String str, String str2) {
        String str3;
        File file;
        String lastSourceSuffix = PictureMimeType.getLastSourceSuffix(str);
        if (PictureMimeType.isHasVideo(str)) {
            file = getRootDirFile(context, 2);
            str3 = "VID_";
        } else if (PictureMimeType.isHasAudio(str)) {
            file = getRootDirFile(context, 3);
            str3 = "AUD_";
        } else {
            file = getRootDirFile(context, 1);
            str3 = "IMG_";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        sb2.append(File.separator);
        if (TextUtils.isEmpty(str2)) {
            str2 = DateUtils.getCreateFileName(str3) + lastSourceSuffix;
        }
        sb2.append(str2);
        return sb2.toString();
    }

    private static File createMediaFile(Context context, int i11, String str, String str2, String str3) {
        return createOutFile(context, i11, str, str2, str3);
    }

    private static File createOutFile(Context context, int i11, String str, String str2, String str3) {
        File file;
        File file2;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file2.getAbsolutePath());
                String str4 = File.separator;
                sb2.append(str4);
                sb2.append(PictureMimeType.CAMERA);
                sb2.append(str4);
                file = new File(sb2.toString());
            } else {
                file2 = getRootDirFile(applicationContext, i11);
                file = new File(file2.getAbsolutePath() + File.separator);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } else {
            File file3 = new File(str3);
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            File file4 = parentFile;
            if (!parentFile.exists()) {
                file3.getParentFile().mkdirs();
            }
            file = file3;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (i11 == 2) {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("VID_") + ".mp4";
            }
            return new File(file, str);
        } else if (i11 != 3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = ".jpg";
            }
            if (isEmpty) {
                str = DateUtils.getCreateFileName("IMG_") + str2;
            }
            return new File(file, str);
        } else {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("AUD_") + ".amr";
            }
            return new File(file, str);
        }
    }

    @Deprecated
    public static void deleteAllCacheDirFile(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!(externalFilesDir == null || (listFiles3 = externalFilesDir.listFiles()) == null)) {
            for (File file : listFiles3) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (!(externalFilesDir2 == null || (listFiles2 = externalFilesDir2.listFiles()) == null)) {
            for (File file2 : listFiles2) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 != null && (listFiles = externalFilesDir3.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    file3.delete();
                }
            }
        }
    }

    @Deprecated
    public static void deleteCacheDirFile(Context context, int i11) {
        File[] listFiles;
        File externalFilesDir = context.getExternalFilesDir(i11 == SelectMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null && (listFiles = externalFilesDir.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String formatAccurateUnitFileSize(long j11) {
        double d11;
        String str;
        if (j11 >= 0) {
            if (j11 < 1000) {
                d11 = (double) j11;
                str = "";
            } else if (j11 < 1000000) {
                d11 = ((double) j11) / 1000.0d;
                str = "KB";
            } else if (j11 < 1000000000) {
                d11 = ((double) j11) / 1000000.0d;
                str = "MB";
            } else {
                d11 = ((double) j11) / 1.0E9d;
                str = "GB";
            }
            Object format = String.format(new Locale("zh"), "%.2f", new Object[]{Double.valueOf(d11)});
            StringBuilder sb2 = new StringBuilder();
            if (((double) Math.round(ValueOf.toDouble(format))) - ValueOf.toDouble(format) == 0.0d) {
                format = Long.valueOf(Math.round(ValueOf.toDouble(format)));
            }
            sb2.append(format);
            sb2.append(str);
            return sb2.toString();
        }
        throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
    }

    @SuppressLint({"DefaultLocale"})
    public static String formatFileSize(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        } else if (j11 < 1024) {
            Object format = String.format("%.2f", new Object[]{Double.valueOf((double) j11)});
            double d11 = ValueOf.toDouble(format);
            long round = Math.round(d11);
            StringBuilder sb2 = new StringBuilder();
            if (((double) round) - d11 == 0.0d) {
                format = Long.valueOf(round);
            }
            sb2.append(format);
            sb2.append("B");
            return sb2.toString();
        } else if (j11 < 1048576) {
            Object format2 = String.format("%.2f", new Object[]{Double.valueOf(((double) j11) / 1024.0d)});
            double d12 = ValueOf.toDouble(format2);
            long round2 = Math.round(d12);
            StringBuilder sb3 = new StringBuilder();
            if (((double) round2) - d12 == 0.0d) {
                format2 = Long.valueOf(round2);
            }
            sb3.append(format2);
            sb3.append("KB");
            return sb3.toString();
        } else if (j11 < 1073741824) {
            Object format3 = String.format("%.2f", new Object[]{Double.valueOf(((double) j11) / 1048576.0d)});
            double d13 = ValueOf.toDouble(format3);
            long round3 = Math.round(d13);
            StringBuilder sb4 = new StringBuilder();
            if (((double) round3) - d13 == 0.0d) {
                format3 = Long.valueOf(round3);
            }
            sb4.append(format3);
            sb4.append("MB");
            return sb4.toString();
        } else {
            Object format4 = String.format("%.2f", new Object[]{Double.valueOf(((double) j11) / 1.073741824E9d)});
            double d14 = ValueOf.toDouble(format4);
            long round4 = Math.round(d14);
            StringBuilder sb5 = new StringBuilder();
            if (((double) round4) - d14 == 0.0d) {
                format4 = Long.valueOf(round4);
            }
            sb5.append(format4);
            sb5.append("GB");
            return sb5.toString();
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            cursor.close();
            return string;
        } catch (IllegalArgumentException e11) {
            Log.i(TAG, String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", new Object[]{e11.getMessage()}));
            if (cursor == null) {
                return "";
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(applicationContext, uri)) {
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
                return "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : "";
            }
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(applicationContext, uri, (String) null, (String[]) null);
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if (!"primary".equalsIgnoreCase(split[0])) {
                return "";
            }
            if (SdkVersionUtils.isQ()) {
                return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
            }
            return Environment.getExternalStorageDirectory() + "/" + split[1];
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ValueOf.toLong(DocumentsContract.getDocumentId(uri))), (String) null, (String[]) null);
        } else if (!isMediaDocument(uri)) {
            return "";
        } else {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(applicationContext, uri2, "_id=?", new String[]{split2[1]});
        }
    }

    private static File getRootDirFile(Context context, int i11) {
        return new File(FileDirMap.getFileDirPath(context, i11));
    }

    public static String getVideoThumbnailDir(Context context) {
        File file = new File(context.getExternalFilesDir("").getAbsolutePath(), "VideoThumbnail");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFileExists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isImageFileExists(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 2;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri parUri(Context context, File file) {
        String str = context.getPackageName() + ".luckProvider";
        if (Build.VERSION.SDK_INT > 23) {
            return FileProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    public static boolean writeFileFromIS(InputStream inputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (Exception e11) {
                e = e11;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    close(bufferedInputStream);
                    close(bufferedOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    close(bufferedInputStream);
                    close(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                close(bufferedOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        close(bufferedInputStream2);
                        close(bufferedOutputStream);
                        return true;
                    }
                }
            } catch (Exception e12) {
                e = e12;
                bufferedInputStream = bufferedInputStream2;
                e.printStackTrace();
                close(bufferedInputStream);
                close(bufferedOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                close(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            bufferedOutputStream = null;
            e.printStackTrace();
            close(bufferedInputStream);
            close(bufferedOutputStream);
            return false;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            close(bufferedInputStream);
            close(bufferedOutputStream);
            throw th;
        }
    }
}

package com.luck.picture.lib.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class MediaUtils {
    public static final String QUERY_ARG_SQL_LIMIT = "android:query-arg-sql-limit";

    public static Bundle createQueryArgsBundle(String str, String[] strArr, int i11, int i12, String str2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", str2);
            if (SdkVersionUtils.isR()) {
                bundle.putString(QUERY_ARG_SQL_LIMIT, i11 + " offset " + i12);
            }
        }
        return bundle;
    }

    public static void deleteUri(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && PictureMimeType.isContent(str)) {
                context.getContentResolver().delete(Uri.parse(str), (String) null, (String[]) null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String generateCameraFolderName(String str) {
        File file = new File(str);
        return file.getParentFile() != null ? file.getParentFile().getName() : PictureMimeType.CAMERA;
    }

    public static void getAsyncVideoThumbnail(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() {
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getVideoThumbnail(context, str);
            }

            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.onCall(mediaExtraInfo);
                }
            }
        });
    }

    public static MediaExtraInfo getAudioSize(Context context, String str) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            e12.printStackTrace();
            mediaMetadataRetriever.release();
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            throw th2;
        }
        return mediaExtraInfo;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    public static int getDCIMLastImageId(Context context, String str) {
        Cursor cursor;
        int i11 = -1;
        ? r22 = 0;
        try {
            String[] strArr = {"%" + str + "%"};
            if (SdkVersionUtils.isR()) {
                cursor = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r22, createQueryArgsBundle("_data like ?", strArr, 1, 0, "_id DESC"), r22);
            } else {
                cursor = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
            }
            Cursor cursor2 = cursor;
            if (cursor2 == null || cursor2.getCount() <= 0 || !cursor2.moveToFirst()) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                return -1;
            }
            int i12 = cursor2.getInt(cursor2.getColumnIndex("_id"));
            if (DateUtils.dateDiffer(cursor2.getLong(cursor2.getColumnIndex("date_added"))) <= 1) {
                i11 = i12;
            }
            cursor2.close();
            return i11;
        } catch (Exception e11) {
            e11.printStackTrace();
            if (r22 != 0) {
                r22.close();
            }
            return -1;
        } catch (Throwable th2) {
            if (r22 != 0) {
                r22.close();
            }
            throw th2;
        }
    }

    @Deprecated
    public static MediaExtraInfo getImageSize(String str) {
        InputStream inputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream inputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.openInputStream(PictureAppMaster.getInstance().getAppContext(), Uri.parse(str));
            } else {
                inputStream = new FileInputStream(str);
            }
            try {
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                mediaExtraInfo.setWidth(options.outWidth);
                mediaExtraInfo.setHeight(options.outHeight);
                PictureFileUtils.close(inputStream);
            } catch (Exception e11) {
                Exception exc = e11;
                inputStream2 = inputStream;
                e = exc;
                try {
                    e.printStackTrace();
                    PictureFileUtils.close(inputStream2);
                    return mediaExtraInfo;
                } catch (Throwable th2) {
                    th = th2;
                    PictureFileUtils.close(inputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                inputStream2 = inputStream;
                th = th3;
                PictureFileUtils.close(inputStream2);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            PictureFileUtils.close(inputStream2);
            return mediaExtraInfo;
        }
        return mediaExtraInfo;
    }

    private static String getMimeType(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static String getMimeTypeFromMediaHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().endsWith(PictureMimeType.JPG) || str.toLowerCase().endsWith(".jpeg")) {
            return "image/jpeg";
        }
        if (str.toLowerCase().endsWith(PictureMimeType.PNG)) {
            return PictureMimeType.PNG_Q;
        }
        if (str.toLowerCase().endsWith(".gif")) {
            return "image/gif";
        }
        if (str.toLowerCase().endsWith(".webp")) {
            return "image/webp";
        }
        if (str.toLowerCase().endsWith(PictureMimeType.BMP)) {
            return "image/bmp";
        }
        if (str.toLowerCase().endsWith(PictureMimeType.MP4)) {
            return "video/mp4";
        }
        if (str.toLowerCase().endsWith(PictureMimeType.AVI)) {
            return PictureMimeType.AVI_Q;
        }
        if (str.toLowerCase().endsWith(PictureMimeType.MP3)) {
            return "audio/mpeg";
        }
        if (str.toLowerCase().endsWith(PictureMimeType.AMR)) {
            return "audio/amr";
        }
        if (str.toLowerCase().endsWith(".m4a")) {
            return "audio/mpeg";
        }
        return null;
    }

    public static String getMimeTypeFromMediaUrl(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase());
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            mimeTypeFromExtension = getMimeType(new File(str));
        }
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "image/jpeg" : mimeTypeFromExtension;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
        if (r2 != 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (r2 == 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Long[] getPathMediaBucketId(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "%"
            r1 = 2
            java.lang.Long[] r1 = new java.lang.Long[r1]
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            r4 = 1
            r1[r4] = r2
            r2 = 0
            java.lang.String r8 = "_data like ?"
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0088 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0088 }
            r5.<init>()     // Catch:{ Exception -> 0x0088 }
            r5.append(r0)     // Catch:{ Exception -> 0x0088 }
            r5.append(r12)     // Catch:{ Exception -> 0x0088 }
            r5.append(r0)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r12 = r5.toString()     // Catch:{ Exception -> 0x0088 }
            r9[r3] = r12     // Catch:{ Exception -> 0x0088 }
            boolean r12 = com.luck.picture.lib.utils.SdkVersionUtils.isR()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r0 = "external"
            if (r12 == 0) goto L_0x0045
            java.lang.String r12 = "_id DESC"
            android.os.Bundle r12 = createQueryArgsBundle(r8, r9, r4, r3, r12)     // Catch:{ Exception -> 0x0088 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ Exception -> 0x0088 }
            android.net.Uri r0 = android.provider.MediaStore.Files.getContentUri(r0)     // Catch:{ Exception -> 0x0088 }
            android.database.Cursor r11 = r11.query(r0, r2, r12, r2)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0054
        L_0x0045:
            java.lang.String r10 = "_id DESC limit 1 offset 0"
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0088 }
            android.net.Uri r6 = android.provider.MediaStore.Files.getContentUri(r0)     // Catch:{ Exception -> 0x0088 }
            r7 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0088 }
        L_0x0054:
            r2 = r11
            if (r2 == 0) goto L_0x0083
            int r11 = r2.getCount()     // Catch:{ Exception -> 0x0088 }
            if (r11 <= 0) goto L_0x0083
            boolean r11 = r2.moveToFirst()     // Catch:{ Exception -> 0x0088 }
            if (r11 == 0) goto L_0x0083
            java.lang.String r11 = "_id"
            int r11 = r2.getColumnIndex(r11)     // Catch:{ Exception -> 0x0088 }
            long r11 = r2.getLong(r11)     // Catch:{ Exception -> 0x0088 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0088 }
            r1[r3] = r11     // Catch:{ Exception -> 0x0088 }
            java.lang.String r11 = "bucket_id"
            int r11 = r2.getColumnIndex(r11)     // Catch:{ Exception -> 0x0088 }
            long r11 = r2.getLong(r11)     // Catch:{ Exception -> 0x0088 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0088 }
            r1[r4] = r11     // Catch:{ Exception -> 0x0088 }
        L_0x0083:
            if (r2 == 0) goto L_0x0091
            goto L_0x008e
        L_0x0086:
            r11 = move-exception
            goto L_0x0092
        L_0x0088:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0091
        L_0x008e:
            r2.close()
        L_0x0091:
            return r1
        L_0x0092:
            if (r2 == 0) goto L_0x0097
            r2.close()
        L_0x0097:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.utils.MediaUtils.getPathMediaBucketId(android.content.Context, java.lang.String):java.lang.Long[]");
    }

    public static String getRealPathUri(long j11, String str) {
        Uri uri;
        if (PictureMimeType.isHasImage(str)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (PictureMimeType.isHasVideo(str)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (PictureMimeType.isHasAudio(str)) {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(uri, j11).toString();
    }

    public static void getVideoSize(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() {
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getVideoSize(context, str);
            }

            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.onCall(mediaExtraInfo);
                }
            }
        });
    }

    public static MediaExtraInfo getVideoThumbnail(Context context, String str) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        FileOutputStream fileOutputStream2;
        File file;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            if (frameAtTime != null) {
                try {
                    if (!frameAtTime.isRecycled()) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream2);
                            file = new File(PictureFileUtils.getVideoThumbnailDir(context), DateUtils.getCreateFileName("vid_") + "_thumb.jpg");
                            fileOutputStream2 = new FileOutputStream(file);
                        } catch (IOException e11) {
                            e = e11;
                            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = null;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            try {
                                e.printStackTrace();
                                PictureFileUtils.close(byteArrayOutputStream);
                                PictureFileUtils.close(fileOutputStream);
                                bitmap.recycle();
                                return mediaExtraInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                PictureFileUtils.close(byteArrayOutputStream);
                                PictureFileUtils.close(fileOutputStream);
                                bitmap.recycle();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = null;
                            byteArrayOutputStream = byteArrayOutputStream4;
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream);
                            bitmap.recycle();
                            throw th;
                        }
                        try {
                            fileOutputStream2.write(byteArrayOutputStream2.toByteArray());
                            fileOutputStream2.flush();
                            mediaExtraInfo.setVideoThumbnail(file.getAbsolutePath());
                            mediaExtraInfo.setWidth(frameAtTime.getWidth());
                            mediaExtraInfo.setHeight(frameAtTime.getHeight());
                            byteArrayOutputStream = byteArrayOutputStream2;
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream2);
                            if (frameAtTime != null && !frameAtTime.isRecycled()) {
                                frameAtTime.recycle();
                            }
                        } catch (IOException e12) {
                            Bitmap bitmap2 = frameAtTime;
                            fileOutputStream = fileOutputStream2;
                            e = e12;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bitmap = bitmap2;
                            e.printStackTrace();
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return mediaExtraInfo;
                        } catch (Throwable th4) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = fileOutputStream2;
                            th = th4;
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            throw th;
                        }
                        return mediaExtraInfo;
                    }
                } catch (IOException e13) {
                    e = e13;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    e.printStackTrace();
                    PictureFileUtils.close(byteArrayOutputStream);
                    PictureFileUtils.close(fileOutputStream);
                    bitmap.recycle();
                    return mediaExtraInfo;
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    PictureFileUtils.close(byteArrayOutputStream);
                    PictureFileUtils.close(fileOutputStream);
                    bitmap.recycle();
                    throw th;
                }
            }
            fileOutputStream2 = null;
            PictureFileUtils.close(byteArrayOutputStream);
            PictureFileUtils.close(fileOutputStream2);
            frameAtTime.recycle();
        } catch (IOException e14) {
            e = e14;
            fileOutputStream = null;
            bitmap = null;
            e.printStackTrace();
            PictureFileUtils.close(byteArrayOutputStream);
            PictureFileUtils.close(fileOutputStream);
            bitmap.recycle();
            return mediaExtraInfo;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            bitmap = null;
            PictureFileUtils.close(byteArrayOutputStream);
            PictureFileUtils.close(fileOutputStream);
            bitmap.recycle();
            throw th;
        }
        return mediaExtraInfo;
    }

    public static boolean isLongImage(int i11, int i12) {
        return i11 > 0 && i12 > 0 && i12 > i11 * 3;
    }

    public static void removeMedia(Context context, int i11) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString((long) i11)});
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static MediaExtraInfo getVideoSize(Context context, String str) {
        int i11;
        int i12;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            if (!TextUtils.equals("90", extractMetadata)) {
                if (!TextUtils.equals("270", extractMetadata)) {
                    i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i12 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                    mediaExtraInfo.setWidth(i11);
                    mediaExtraInfo.setHeight(i12);
                    mediaExtraInfo.setOrientation(extractMetadata);
                    mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                }
            }
            int i13 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            i12 = i13;
            i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
            mediaExtraInfo.setWidth(i11);
            mediaExtraInfo.setHeight(i12);
            mediaExtraInfo.setOrientation(extractMetadata);
            mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Exception e12) {
            e12.printStackTrace();
            mediaMetadataRetriever.release();
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            throw th2;
        }
        return mediaExtraInfo;
    }

    public static MediaExtraInfo getImageSize(Context context, String str) {
        InputStream inputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        InputStream inputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
            } else {
                inputStream = new FileInputStream(str);
            }
            try {
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                mediaExtraInfo.setWidth(options.outWidth);
                mediaExtraInfo.setHeight(options.outHeight);
                PictureFileUtils.close(inputStream);
            } catch (Exception e11) {
                inputStream2 = inputStream;
                e = e11;
                try {
                    e.printStackTrace();
                    PictureFileUtils.close(inputStream2);
                    return mediaExtraInfo;
                } catch (Throwable th2) {
                    th = th2;
                    PictureFileUtils.close(inputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                inputStream2 = inputStream;
                th = th3;
                PictureFileUtils.close(inputStream2);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            PictureFileUtils.close(inputStream2);
            return mediaExtraInfo;
        }
        return mediaExtraInfo;
    }

    public static void getImageSize(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() {
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getImageSize(context, str);
            }

            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.onCall(mediaExtraInfo);
                }
            }
        });
    }
}

package com.luck.picture.lib.utils;

import android.content.Context;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;

public class DownloadFileUtils {
    public static void saveLocalFile(final Context context, final String str, final String str2, final OnCallbackListener<String> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<String>() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ Exception -> 0x021e }] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[Catch:{ Exception -> 0x021e }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed A[Catch:{ Exception -> 0x021e }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00f6 A[Catch:{ Exception -> 0x021e }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0173 A[Catch:{ Exception -> 0x021e }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x017c A[Catch:{ Exception -> 0x021e }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String doInBackground() {
                /*
                    r14 = this;
                    java.lang.String r0 = "VID_"
                    java.lang.String r1 = "IMG_"
                    java.lang.String r2 = "AUD_"
                    android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x021e }
                    r3.<init>()     // Catch:{ Exception -> 0x021e }
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x021e }
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r4 = com.luck.picture.lib.utils.ValueOf.toString(r4)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r5 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r5 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r5)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r6 = "image"
                    java.lang.String r7 = "video"
                    java.lang.String r8 = "_data"
                    java.lang.String r9 = "relative_path"
                    java.lang.String r10 = "mounted"
                    java.lang.String r11 = "datetaken"
                    java.lang.String r12 = "mime_type"
                    java.lang.String r13 = "_display_name"
                    if (r5 == 0) goto L_0x00b5
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r2)     // Catch:{ Exception -> 0x021e }
                    r3.put(r13, r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x021e }
                    if (r0 != 0) goto L_0x0052
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = r0.startsWith(r7)     // Catch:{ Exception -> 0x021e }
                    if (r0 != 0) goto L_0x0052
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = r0.startsWith(r6)     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x004f
                    goto L_0x0052
                L_0x004f:
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    goto L_0x0054
                L_0x0052:
                    java.lang.String r0 = "audio/mpeg"
                L_0x0054:
                    r3.put(r12, r0)     // Catch:{ Exception -> 0x021e }
                    boolean r0 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x0066
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MUSIC     // Catch:{ Exception -> 0x021e }
                    r3.put(r9, r0)     // Catch:{ Exception -> 0x021e }
                    goto L_0x00a7
                L_0x0066:
                    java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x021e }
                    boolean r0 = android.text.TextUtils.equals(r0, r10)     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x0077
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MUSIC     // Catch:{ Exception -> 0x021e }
                    java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ Exception -> 0x021e }
                    goto L_0x0083
                L_0x0077:
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x021e }
                    android.content.Context r1 = r1     // Catch:{ Exception -> 0x021e }
                    r4 = 3
                    java.lang.String r1 = com.luck.picture.lib.utils.FileDirMap.getFileDirPath(r1, r4)     // Catch:{ Exception -> 0x021e }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x021e }
                L_0x0083:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021e }
                    r1.<init>()     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x021e }
                    r1.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = java.io.File.separator     // Catch:{ Exception -> 0x021e }
                    r1.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r2)     // Catch:{ Exception -> 0x021e }
                    r1.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = ".amr"
                    r1.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x021e }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x021e }
                L_0x00a7:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x021e }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x021e }
                    goto L_0x01d9
                L_0x00b5:
                    java.lang.String r2 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r2 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r2)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r5 = "audio"
                    if (r2 == 0) goto L_0x0145
                    java.lang.String r1 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r0)     // Catch:{ Exception -> 0x021e }
                    r3.put(r13, r1)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x021e }
                    if (r1 != 0) goto L_0x00e2
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r1 = r1.startsWith(r5)     // Catch:{ Exception -> 0x021e }
                    if (r1 != 0) goto L_0x00e2
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r1 = r1.startsWith(r6)     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x00df
                    goto L_0x00e2
                L_0x00df:
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x021e }
                    goto L_0x00e4
                L_0x00e2:
                    java.lang.String r1 = "video/mp4"
                L_0x00e4:
                    r3.put(r12, r1)     // Catch:{ Exception -> 0x021e }
                    boolean r1 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x00f6
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x021e }
                    r3.put(r9, r0)     // Catch:{ Exception -> 0x021e }
                    goto L_0x0137
                L_0x00f6:
                    java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x021e }
                    boolean r1 = android.text.TextUtils.equals(r1, r10)     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x0107
                    java.lang.String r1 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x021e }
                    java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)     // Catch:{ Exception -> 0x021e }
                    goto L_0x0113
                L_0x0107:
                    java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x021e }
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x021e }
                    r4 = 2
                    java.lang.String r2 = com.luck.picture.lib.utils.FileDirMap.getFileDirPath(r2, r4)     // Catch:{ Exception -> 0x021e }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x021e }
                L_0x0113:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021e }
                    r2.<init>()     // Catch:{ Exception -> 0x021e }
                    java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x021e }
                    r2.append(r1)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x021e }
                    r2.append(r1)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r0)     // Catch:{ Exception -> 0x021e }
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = ".mp4"
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x021e }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x021e }
                L_0x0137:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x021e }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x021e }
                    goto L_0x01d9
                L_0x0145:
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r1)     // Catch:{ Exception -> 0x021e }
                    r3.put(r13, r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x021e }
                    if (r0 != 0) goto L_0x0168
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x021e }
                    if (r0 != 0) goto L_0x0168
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = r0.startsWith(r7)     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x0165
                    goto L_0x0168
                L_0x0165:
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    goto L_0x016a
                L_0x0168:
                    java.lang.String r0 = "image/jpeg"
                L_0x016a:
                    r3.put(r12, r0)     // Catch:{ Exception -> 0x021e }
                    boolean r0 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x017c
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = "DCIM/Camera"
                    r3.put(r9, r0)     // Catch:{ Exception -> 0x021e }
                    goto L_0x01cd
                L_0x017c:
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x021e }
                    boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasGif(r0)     // Catch:{ Exception -> 0x021e }
                    if (r0 != 0) goto L_0x018c
                    java.lang.String r0 = r2     // Catch:{ Exception -> 0x021e }
                    boolean r0 = com.luck.picture.lib.config.PictureMimeType.isUrlHasGif(r0)     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x01cd
                L_0x018c:
                    java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x021e }
                    boolean r0 = android.text.TextUtils.equals(r0, r10)     // Catch:{ Exception -> 0x021e }
                    if (r0 == 0) goto L_0x019d
                    java.lang.String r0 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ Exception -> 0x021e }
                    java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ Exception -> 0x021e }
                    goto L_0x01a9
                L_0x019d:
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x021e }
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x021e }
                    r4 = 1
                    java.lang.String r2 = com.luck.picture.lib.utils.FileDirMap.getFileDirPath(r2, r4)     // Catch:{ Exception -> 0x021e }
                    r0.<init>(r2)     // Catch:{ Exception -> 0x021e }
                L_0x01a9:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021e }
                    r2.<init>()     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x021e }
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = java.io.File.separator     // Catch:{ Exception -> 0x021e }
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.getCreateFileName(r1)     // Catch:{ Exception -> 0x021e }
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = ".gif"
                    r2.append(r0)     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x021e }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x021e }
                L_0x01cd:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x021e }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x021e }
                L_0x01d9:
                    if (r0 == 0) goto L_0x0222
                    java.lang.String r1 = r2     // Catch:{ Exception -> 0x021e }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.isHasHttp(r1)     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x01ef
                    java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x021e }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x021e }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x021e }
                    java.io.InputStream r1 = r1.openStream()     // Catch:{ Exception -> 0x021e }
                    goto L_0x020b
                L_0x01ef:
                    java.lang.String r1 = r2     // Catch:{ Exception -> 0x021e }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.isContent(r1)     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x0204
                    android.content.Context r1 = r1     // Catch:{ Exception -> 0x021e }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x021e }
                    android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x021e }
                    java.io.InputStream r1 = com.luck.picture.lib.basic.PictureContentResolver.openInputStream(r1, r2)     // Catch:{ Exception -> 0x021e }
                    goto L_0x020b
                L_0x0204:
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x021e }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x021e }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x021e }
                L_0x020b:
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x021e }
                    java.io.OutputStream r2 = com.luck.picture.lib.basic.PictureContentResolver.openOutputStream(r2, r0)     // Catch:{ Exception -> 0x021e }
                    boolean r1 = com.luck.picture.lib.utils.PictureFileUtils.writeFileFromIS(r1, r2)     // Catch:{ Exception -> 0x021e }
                    if (r1 == 0) goto L_0x0222
                    android.content.Context r1 = r1     // Catch:{ Exception -> 0x021e }
                    java.lang.String r0 = com.luck.picture.lib.utils.PictureFileUtils.getPath(r1, r0)     // Catch:{ Exception -> 0x021e }
                    return r0
                L_0x021e:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0222:
                    r0 = 0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.utils.DownloadFileUtils.AnonymousClass1.doInBackground():java.lang.String");
            }

            public void onSuccess(String str) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.onCall(str);
                }
            }
        });
    }
}

package cn.sharesdk.kakao.talk;

import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13579a = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/watermark");

    public static File a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " 拷贝文件的目标路径为空 ");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " 拷贝文件不存在 ");
            return null;
        }
        a();
        File file2 = new File(f13579a + "/" + file.getName());
        a(file, file2);
        MediaScannerConnection.scanFile(context, new String[]{file2.getPath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
        return file2;
    }

    private static void a() {
        File file = new File(f13579a);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private static void a(File file, File file2) {
        if (!file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        fileOutputStream.close();
                        SSDKLog b11 = SSDKLog.b();
                        b11.a(OnekeyShare.SHARESDK_TAG, "copyFile 执行完毕, src " + file.length() + " dest: " + file2.length());
                        return;
                    }
                }
            } catch (IOException e11) {
                SSDKLog b12 = SSDKLog.b();
                b12.d(OnekeyShare.SHARESDK_TAG, "拷贝文件到相册失败: " + e11);
            }
        }
    }

    public static ContentValues a(File file, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", file.getName());
        contentValues.put("description", "water mark video");
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", SelectMimeType.SYSTEM_VIDEO);
        contentValues.put("datetaken", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }
}

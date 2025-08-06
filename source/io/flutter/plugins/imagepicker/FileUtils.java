package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class FileUtils {
    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private static String getImageExtension(Context context, Uri uri) {
        String str;
        try {
            uri.getPath();
            str = uri.getScheme().equals("content") ? MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)) : MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
        } catch (Exception unused) {
            str = null;
        }
        if (str == null || str.isEmpty()) {
            str = "jpg";
        }
        return InstructionFileId.DOT + str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|7|(3:9|10|11)(1:13)|(2:15|16)|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0041 A[SYNTHETIC, Splitter:B:30:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0046 A[SYNTHETIC, Splitter:B:34:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x004f A[SYNTHETIC, Splitter:B:42:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0054 A[SYNTHETIC, Splitter:B:46:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPathFromUri(android.content.Context r5, android.net.Uri r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = getImageExtension(r5, r6)     // Catch:{ IOException -> 0x004a, all -> 0x003d }
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch:{ IOException -> 0x004a, all -> 0x003d }
            java.io.InputStream r6 = r3.openInputStream(r6)     // Catch:{ IOException -> 0x004a, all -> 0x003d }
            java.lang.String r3 = "image_picker"
            java.io.File r5 = r5.getCacheDir()     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            java.io.File r5 = java.io.File.createTempFile(r3, r2, r5)     // Catch:{ IOException -> 0x003a, all -> 0x0036 }
            r5.deleteOnExit()     // Catch:{ IOException -> 0x0034, all -> 0x0036 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x0036 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0034, all -> 0x0036 }
            if (r6 == 0) goto L_0x0029
            copy(r6, r2)     // Catch:{ IOException -> 0x004d, all -> 0x0027 }
            r3 = 1
            goto L_0x002a
        L_0x0027:
            r5 = move-exception
            goto L_0x0038
        L_0x0029:
            r3 = r0
        L_0x002a:
            if (r6 == 0) goto L_0x002f
            r6.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x0057 }
            r0 = r3
            goto L_0x0057
        L_0x0034:
            r2 = r1
            goto L_0x004d
        L_0x0036:
            r5 = move-exception
            r2 = r1
        L_0x0038:
            r1 = r6
            goto L_0x003f
        L_0x003a:
            r5 = r1
            r2 = r5
            goto L_0x004d
        L_0x003d:
            r5 = move-exception
            r2 = r1
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            throw r5
        L_0x004a:
            r5 = r1
            r6 = r5
            r2 = r6
        L_0x004d:
            if (r6 == 0) goto L_0x0052
            r6.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            if (r0 == 0) goto L_0x005d
            java.lang.String r1 = r5.getPath()
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.FileUtils.getPathFromUri(android.content.Context, android.net.Uri):java.lang.String");
    }
}

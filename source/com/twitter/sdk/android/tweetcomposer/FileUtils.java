package com.twitter.sdk.android.tweetcomposer;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;

class FileUtils {
    private static final String MEDIA_SCHEME = "com.android.providers.media.documents";

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (lastIndexOf < 0) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getMimeType(File file) {
        String extension = getExtension(file.getName());
        return !TextUtils.isEmpty(extension) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension) : "application/octet-stream";
    }

    @TargetApi(19)
    public static String getPath(Context context, Uri uri) {
        if ((Build.VERSION.SDK_INT >= 19) && isMediaDocumentAuthority(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if (!"image".equals(split[0])) {
                return null;
            }
            return resolveFilePath(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{split[1]});
        } else if (isContentScheme(uri)) {
            return resolveFilePath(context, uri, (String) null, (String[]) null);
        } else {
            if (isFileScheme(uri)) {
                return uri.getPath();
            }
            return null;
        }
    }

    public static boolean isContentScheme(Uri uri) {
        return "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isFileScheme(Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isMediaDocumentAuthority(Uri uri) {
        return MEDIA_SCHEME.equalsIgnoreCase(uri.getAuthority());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String resolveFilePath(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0030 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0030 }
            if (r8 == 0) goto L_0x002a
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0027 }
            if (r9 == 0) goto L_0x002a
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            r7 = r8
            goto L_0x0031
        L_0x002a:
            if (r8 == 0) goto L_0x002f
            r8.close()
        L_0x002f:
            return r7
        L_0x0030:
            r9 = move-exception
        L_0x0031:
            if (r7 == 0) goto L_0x0036
            r7.close()
        L_0x0036:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetcomposer.FileUtils.resolveFilePath(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }
}

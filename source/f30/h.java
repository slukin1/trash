package f30;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.R$string;

public class h {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        r4 = r5.getLastPathSegment();
        r5 = r4.lastIndexOf(com.amazonaws.services.s3.model.InstructionFileId.DOT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r4, android.net.Uri r5, boolean r6) {
        /*
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r1 = r5.getScheme()
            java.lang.String r2 = "content"
            boolean r2 = r2.equals(r1)
            r3 = 1
            if (r2 == 0) goto L_0x001e
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r4 = r4.getType(r5)
            java.lang.String r4 = r0.getExtensionFromMimeType(r4)
            goto L_0x003f
        L_0x001e:
            java.lang.String r4 = "file"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x003d
            java.lang.String r4 = r5.getLastPathSegment()
            java.lang.String r5 = "."
            int r5 = r4.lastIndexOf(r5)
            r0 = -1
            if (r5 == r0) goto L_0x003d
            int r5 = r5 + r3
            int r0 = r4.length()
            java.lang.String r4 = r4.substring(r5, r0)
            goto L_0x003f
        L_0x003d:
            java.lang.String r4 = "tmp"
        L_0x003f:
            if (r6 == 0) goto L_0x004e
            java.util.Locale r5 = java.util.Locale.US
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r0 = 0
            r6[r0] = r4
            java.lang.String r4 = ".%s"
            java.lang.String r4 = java.lang.String.format(r5, r4, r6)
        L_0x004e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: f30.h.c(android.content.Context, android.net.Uri, boolean):java.lang.String");
    }

    public static String g(Context context, Uri uri) {
        String scheme = uri.getScheme();
        String str = "";
        if (!"content".equals(scheme)) {
            return "file".equals(scheme) ? uri.getLastPathSegment() : str;
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return str;
        }
        try {
            if (query.moveToFirst()) {
                str = query.getString(0);
            }
            return str;
        } finally {
            query.close();
        }
    }

    public static MediaResult j(Context context, Uri uri) {
        long j11;
        String str;
        String str2;
        String str3 = "";
        long j12 = -1;
        if ("content".equals(uri.getScheme())) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri2 = uri;
            Cursor query = contentResolver.query(uri2, new String[]{"_size", "_display_name"}, (String) null, (String[]) null, (String) null);
            String type = contentResolver.getType(uri2);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        long j13 = query.getLong(query.getColumnIndex("_size"));
                        str3 = query.getString(query.getColumnIndex("_display_name"));
                        j12 = j13;
                    }
                } finally {
                    query.close();
                }
            }
            str2 = str3;
            j11 = j12;
            str = type;
        } else {
            Uri uri3 = uri;
            str2 = str3;
            str = str2;
            j11 = -1;
        }
        return new MediaResult((File) null, uri, uri, str2, str, j11, -1, -1);
    }

    public final File a(File file, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb2.append(str2);
        return new File(file, sb2.toString());
    }

    public final File b(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = str + File.separator;
        } else {
            str2 = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(k(context));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("belvedere-data-v2");
        sb2.append(str3);
        sb2.append(str2);
        File file = new File(sb2.toString());
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return file;
        }
        return null;
    }

    public File d(Context context, String str, String str2) {
        String str3 = "user";
        if (!TextUtils.isEmpty(str)) {
            str3 = str3 + File.separator + str;
        }
        File b11 = b(context, str3);
        if (b11 != null) {
            return a(b11, str2, (String) null);
        }
        zendesk.belvedere.h.e("Belvedere", "Error creating cache directory");
        return null;
    }

    public File e(Context context) {
        File b11 = b(context, "media");
        if (b11 == null) {
            zendesk.belvedere.h.e("Belvedere", "Error creating cache directory");
            return null;
        }
        Locale locale = Locale.US;
        return a(b11, String.format(locale, "camera_image_%s", new Object[]{new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date(System.currentTimeMillis()))}), PictureMimeType.JPG);
    }

    public File f(Context context, Uri uri, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = "user" + File.separator + str;
        } else {
            str2 = "media";
        }
        File b11 = b(context, str2);
        String str3 = null;
        if (b11 == null) {
            zendesk.belvedere.h.e("Belvedere", "Error creating cache directory");
            return null;
        }
        String g11 = g(context, uri);
        if (TextUtils.isEmpty(g11)) {
            Locale locale = Locale.US;
            g11 = String.format(locale, "attachment_%s", new Object[]{new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date(System.currentTimeMillis()))});
            str3 = c(context, uri, true);
        }
        return a(b11, g11, str3);
    }

    public String h(Context context) {
        String string = context.getString(R$string.belvedere_sdk_fpa_suffix_v2);
        return String.format(Locale.US, "%s%s", new Object[]{context.getPackageName(), string});
    }

    public Uri i(Context context, File file) {
        String h11 = h(context);
        try {
            return FileProvider.getUriForFile(context, h11, file);
        } catch (IllegalArgumentException unused) {
            zendesk.belvedere.h.b("Belvedere", String.format(Locale.US, "The selected file can't be shared %s", new Object[]{file.toString()}));
            return null;
        } catch (NullPointerException e11) {
            String format = String.format(Locale.US, "=====================\nFileProvider failed to retrieve file uri. There might be an issue with the FileProvider \nPlease make sure that manifest-merger is working, and that you have defined the applicationId (package name) in the build.gradle\nManifest merger: http://tools.android.com/tech-docs/new-build-system/user-guide/manifest-merger\nIf your are not able to use gradle or the manifest merger, please add the following to your AndroidManifest.xml:\n        <provider\n            android:name=\"com.zendesk.belvedere.BelvedereFileProvider\"\n            android:authorities=\"${applicationId}%s\"\n            android:exported=\"false\"\n            android:grantUriPermissions=\"true\">\n            <meta-data\n                android:name=\"android.support.FILE_PROVIDER_PATHS\"\n                android:resource=\"@xml/belvedere_attachment_storage_v2\" />\n        </provider>\n=====================", new Object[]{h11});
            Log.e("Belvedere", format, e11);
            zendesk.belvedere.h.c("Belvedere", format, e11);
            throw new RuntimeException("Please specify your application id");
        }
    }

    public final String k(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }

    public void l(Context context, Intent intent, Uri uri, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            intent.addFlags(i11);
            return;
        }
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, i11);
        }
    }

    public void m(Context context, Uri uri, int i11) {
        context.revokeUriPermission(uri, i11);
    }
}

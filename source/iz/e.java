package iz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.PictureMimeType;
import com.zendesk.belvedere.R$string;
import com.zendesk.belvedere.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public a f52897a;

    /* renamed from: b  reason: collision with root package name */
    public b f52898b;

    public e(a aVar) {
        this.f52897a = aVar;
        this.f52898b = aVar.b();
    }

    public final void a(File file) {
        if (file.isDirectory()) {
            for (File a11 : file.listFiles()) {
                a(a11);
            }
        }
        file.delete();
    }

    public void b(Context context) {
        File file = new File(j(context) + File.separator + this.f52897a.g());
        if (file.isDirectory()) {
            a(file);
        }
    }

    public final File c(String str, String str2, File file) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb2.append(str2);
        return new File(file, sb2.toString());
    }

    public final File d(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = str + File.separator;
        } else {
            str2 = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j(context));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(this.f52897a.g());
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

    public final String e(Context context, Uri uri) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        if (TextUtils.isEmpty(extensionFromMimeType)) {
            extensionFromMimeType = "tmp";
        }
        objArr[0] = extensionFromMimeType;
        return String.format(locale, ".%s", objArr);
    }

    public File f(Context context) {
        File d11 = d(context, OptionsBridge.CAMERA_KEY);
        if (d11 == null) {
            this.f52898b.w("BelvedereStorage", "Error creating cache directory");
            return null;
        }
        Locale locale = Locale.US;
        return c(String.format(locale, "camera_image_%s", new Object[]{new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date(System.currentTimeMillis()))}), PictureMimeType.JPG, d11);
    }

    public final String g(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        String str = "";
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
            } finally {
                query.close();
            }
        }
        return str;
    }

    public String h(Context context) {
        String string = context.getString(R$string.belvedere_sdk_fpa_suffix);
        return String.format(Locale.US, "%s%s", new Object[]{context.getPackageName(), string});
    }

    public Uri i(Context context, File file) {
        String h11 = h(context);
        try {
            return FileProvider.getUriForFile(context, h11, file);
        } catch (IllegalArgumentException unused) {
            this.f52898b.e("BelvedereStorage", String.format(Locale.US, "The selected file can't be shared %s", new Object[]{file.toString()}));
            return null;
        } catch (NullPointerException e11) {
            String format = String.format(Locale.US, "=====================\nFileProvider failed to retrieve file uri. There might be an issue with the FileProvider \nPlease make sure that manifest-merger is working, and that you have defined the applicationId (package name) in the build.gradle\nManifest merger: http://tools.android.com/tech-docs/new-build-system/user-guide/manifest-merger\nIf your are not able to use gradle or the manifest merger, please add the following to your AndroidManifest.xml:\n        <provider\n            android:name=\"com.zendesk.belvedere.BelvedereFileProvider\"\n            android:authorities=\"${applicationId}${belvedereFileProviderAuthoritySuffix}\"\n            android:exported=\"false\"\n            android:grantUriPermissions=\"true\">\n            <meta-data\n                android:name=\"android.support.FILE_PROVIDER_PATHS\"\n                android:resource=\"@xml/belvedere_attachment_storage\" />\n        </provider>\n=====================", new Object[]{h11});
            Log.e("BelvedereStorage", format, e11);
            this.f52898b.e("BelvedereStorage", format, e11);
            return null;
        }
    }

    public final String j(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }

    public File k(Context context, Uri uri) {
        File d11 = d(context, "gallery");
        String str = null;
        if (d11 == null) {
            this.f52898b.w("BelvedereStorage", "Error creating cache directory");
            return null;
        }
        String g11 = g(context, uri);
        if (TextUtils.isEmpty(g11)) {
            Locale locale = Locale.US;
            g11 = String.format(locale, "attachment_%s", new Object[]{new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date(System.currentTimeMillis()))});
            str = e(context, uri);
        }
        return c(g11, str, d11);
    }

    public File l(Context context, String str) {
        File d11 = d(context, "request");
        if (d11 != null) {
            return c(str, (String) null, d11);
        }
        this.f52898b.w("BelvedereStorage", "Error creating cache directory");
        return null;
    }

    public void m(Context context, Intent intent, Uri uri, int i11) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, i11);
        }
    }

    public void n(Context context, Uri uri, int i11) {
        context.revokeUriPermission(uri, i11);
    }
}

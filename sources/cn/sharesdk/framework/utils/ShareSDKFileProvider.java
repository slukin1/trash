package cn.sharesdk.framework.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShareSDKFileProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13497a = {"_display_name", "_size"};

    /* renamed from: b  reason: collision with root package name */
    private static final File f13498b = new File("/");

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, PathStrategy> f13499c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private PathStrategy f13500d;

    /* renamed from: e  reason: collision with root package name */
    private ProviderInfo f13501e;

    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public static class a implements PathStrategy {

        /* renamed from: a  reason: collision with root package name */
        private final String f13502a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, File> f13503b = new HashMap<>();

        public a(String str) {
            this.f13502a = str;
        }

        public void a(String str, File file) {
            File file2;
            if (!TextUtils.isEmpty(str)) {
                try {
                    file2 = file.getCanonicalFile();
                } catch (Throwable unused) {
                    file2 = file.getAbsoluteFile();
                }
                this.f13503b.put(str, file2);
                return;
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        public File getFileForUri(Uri uri) {
            File file;
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file2 = this.f13503b.get(decode);
            if (file2 != null) {
                File file3 = new File(file2, decode2);
                try {
                    file = file3.getCanonicalFile();
                } catch (Throwable unused) {
                    file = file3.getAbsoluteFile();
                }
                if (file.getPath().startsWith(file2.getPath())) {
                    return file;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }

        public Uri getUriForFile(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry next : this.f13503b.entrySet()) {
                    String path = ((File) next.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    if (path2.endsWith("/")) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f13502a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(str, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    public static Uri a(Context context, String str, File file) {
        try {
            return a(context, str).getUriForFile(file);
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("getUriForFile fail" + th2);
            return null;
        }
    }

    private static PathStrategy b(Context context, String str) {
        a aVar = new a(str);
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            aVar.a("imageNameFilesDir", a(filesDir, "Mob/cache/images"));
            aVar.a("videoNameFilesDir", a(filesDir, "Mob/cache/videos"));
        }
        String str2 = "Mob/" + context.getPackageName() + "/cache/images";
        if (context.getCacheDir() != null) {
            aVar.a("cachename", a(filesDir, InstructionFileId.DOT));
            aVar.a("imageNameExternal", a(filesDir, str2));
            aVar.a("imageNameExternal", a(filesDir, "Mob/cache/images"));
        }
        String str3 = "Mob/" + context.getPackageName() + "/cache/images";
        String str4 = "Mob/" + context.getPackageName() + "/cache/videos";
        File[] a11 = a(context);
        File file = a11.length > 0 ? a11[0] : null;
        if (file != null) {
            aVar.a("imageNameExternal", a(file, str3));
            aVar.a("videoNameExternal", a(file, str4));
            aVar.a("mihayou", a(file, InstructionFileId.DOT));
            aVar.a("more", a(file, "./."));
        }
        String str5 = "Mob/" + context.getPackageName() + "/cache/images";
        String str6 = "Mob/" + context.getPackageName() + "/cache/videos";
        File[] b11 = b(context);
        File file2 = b11.length > 0 ? b11[0] : null;
        if (file2 != null) {
            aVar.a("imageNameEtc", a(file2, str5));
            aVar.a("videoNameEtc", a(file2, str6));
        }
        if (f13498b != null) {
            aVar.a("imageNameRoot", a((File) null, "Mob/cache/images"));
            aVar.a("videoNameRoot", a((File) null, "Mob/cache/videos"));
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            aVar.a("externalStDir", a(externalStorageDirectory, InstructionFileId.DOT));
        }
        return aVar;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        this.f13501e = providerInfo;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a("del");
        PathStrategy pathStrategy = this.f13500d;
        if (pathStrategy == null) {
            return 0;
        }
        return pathStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r3) {
        /*
            r2 = this;
            java.lang.String r0 = "g-t"
            r2.a((java.lang.String) r0)
            cn.sharesdk.framework.utils.ShareSDKFileProvider$PathStrategy r0 = r2.f13500d
            if (r0 != 0) goto L_0x000c
            java.lang.String r3 = ""
            return r3
        L_0x000c:
            java.io.File r3 = r0.getFileForUri(r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0031
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0031
            return r3
        L_0x0031:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.ShareSDKFileProvider.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        a("o-f");
        PathStrategy pathStrategy = this.f13500d;
        if (pathStrategy == null) {
            return null;
        }
        return ParcelFileDescriptor.open(pathStrategy.getFileForUri(uri), b(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a("q");
        PathStrategy pathStrategy = this.f13500d;
        if (pathStrategy == null) {
            return null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        if (strArr == null) {
            strArr = f13497a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i11] = "_display_name";
                objArr[i11] = fileForUri.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i11] = "_size";
                objArr[i11] = Long.valueOf(fileForUri.length());
            }
            i11++;
        }
        String[] a11 = a(strArr3, i11);
        Object[] a12 = a(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(a11, 1);
        matrixCursor.addRow(a12);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static PathStrategy a(Context context, String str) {
        PathStrategy pathStrategy;
        synchronized (f13499c) {
            pathStrategy = f13499c.get(str);
            if (pathStrategy == null) {
                pathStrategy = b(context, str);
                f13499c.put(str, pathStrategy);
            }
        }
        return pathStrategy;
    }

    private void a(String str) {
        ProviderInfo providerInfo;
        if (this.f13500d != null || (providerInfo = this.f13501e) == null) {
            return;
        }
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            try {
                this.f13500d = a(getContext(), this.f13501e.authority);
            } catch (Throwable unused) {
            }
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public static File[] a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs((String) null);
        }
        return new File[]{context.getExternalFilesDir((String) null)};
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] a(String[] strArr, int i11) {
        String[] strArr2 = new String[i11];
        System.arraycopy(strArr, 0, strArr2, 0, i11);
        return strArr2;
    }

    private static Object[] a(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[i11];
        System.arraycopy(objArr, 0, objArr2, 0, i11);
        return objArr2;
    }

    public static File[] b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    private static int b(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }
}

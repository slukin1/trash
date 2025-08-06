package lg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.common.PackageConstants;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f40548a = Uri.parse("content://com.huawei.hwid");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f40549b = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", PackageConstants.SERVICES_SIGNATURE_V3};

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            e.f("BksUtil", "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            e.b("BksUtil", "create directory  success");
            return 0;
        } else {
            e.d("BksUtil", "create directory  failed");
            return -1;
        }
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
        }
        return context.getApplicationContext().getFilesDir() + File.separator + "aegis";
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static void d(InputStream inputStream, Context context) {
        if (inputStream != null && context != null) {
            String b11 = b(context);
            if (!new File(b11).exists()) {
                a(b11);
            }
            File file = new File(b11, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                e.e("BksUtil", "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            d.c(fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.d("BksUtil", " IOException");
                        d.c(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        d.c(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    d.c(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                e.d("BksUtil", " IOException");
                d.c(fileOutputStream);
            }
        }
    }

    public static byte[] e(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("BksUtil", "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("BksUtil", "PackageManager.NameNotFoundException : " + e11.getMessage());
        } catch (Exception e12) {
            Log.e("BksUtil", "get pm exception : " + e12.getMessage());
        }
        return new byte[0];
    }

    public static String f(Context context) {
        return b(context) + File.separator + "hmsrootcas.bks";
    }

    public static String g(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return c(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            e.d("BksUtil", "inputstraem exception");
            return "";
        }
    }

    public static boolean h(Context context, String str) {
        return PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(j(e(context, str)));
    }

    public static boolean i(String str) {
        int i11;
        int i12;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.e("BksUtil", "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = "4.0.2.300".split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i13 = 0; i13 < max; i13++) {
            if (i13 < length) {
                try {
                    i11 = Integer.parseInt(split[i13]);
                } catch (Exception e11) {
                    e.d("BksUtil", " exception : " + e11.getMessage());
                    if (i13 >= length2) {
                        return true;
                    }
                    return false;
                }
            } else {
                i11 = 0;
            }
            if (i13 < length2) {
                i12 = Integer.parseInt(split2[i13]);
            } else {
                i12 = 0;
            }
            if (i11 < i12) {
                return false;
            }
            if (i11 > i12) {
                return true;
            }
        }
        return true;
    }

    public static String j(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return c(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e11) {
            Log.e("BksUtil", "NoSuchAlgorithmException" + e11.getMessage());
            return "";
        }
    }

    public static boolean k(Context context) {
        return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static boolean l(Context context, String str) {
        byte[] e11 = e(context, str);
        for (String equalsIgnoreCase : f40549b) {
            if (equalsIgnoreCase.equalsIgnoreCase(j(e11))) {
                return true;
            }
        }
        return false;
    }

    public static synchronized InputStream m(Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        synchronized (a.class) {
            e.e("BksUtil", "get bks from tss begin");
            if (context != null) {
                ContextUtil.b(context);
            }
            Context a11 = ContextUtil.a();
            InputStream inputStream4 = null;
            if (a11 == null) {
                e.d("BksUtil", "context is null");
                return null;
            } else if (!i(f.a("com.huawei.hwid")) && !i(f.a(PackageConstants.SERVICES_PACKAGE_ALL_SCENE))) {
                e.d("BksUtil", "hms version code is too low : " + f.a("com.huawei.hwid"));
                return null;
            } else if (l(a11, "com.huawei.hwid") || h(a11, PackageConstants.SERVICES_PACKAGE_ALL_SCENE)) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream2 = a11.getContentResolver().openInputStream(Uri.withAppendedPath(f40548a, "files/hmsrootcas.bks"));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception e11) {
                        e = e11;
                        try {
                            e.d("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                            d.b(inputStream2);
                            d.c(byteArrayOutputStream);
                            d.b(inputStream4);
                            InputStream n11 = n(a11);
                            return n11;
                        } catch (Throwable th2) {
                            th = th2;
                            InputStream inputStream5 = inputStream2;
                            inputStream3 = inputStream4;
                            inputStream4 = inputStream5;
                            inputStream = inputStream3;
                            inputStream2 = inputStream4;
                            d.b(inputStream2);
                            d.c(byteArrayOutputStream);
                            d.b(inputStream);
                            throw th;
                        }
                    }
                    try {
                        String b11 = g.b("bks_hash", "", a11);
                        String g11 = g(byteArrayOutputStream.toByteArray());
                        if (k(a11)) {
                            if (b11.equals(g11)) {
                                e.e("BksUtil", "bks not update");
                                d.b(inputStream2);
                                d.c(byteArrayOutputStream);
                                d.b(inputStream);
                                InputStream n112 = n(a11);
                                return n112;
                            }
                        }
                        e.e("BksUtil", "update bks and sp");
                        d(inputStream, a11);
                        g.e("bks_hash", g11, a11);
                        d.b(inputStream2);
                        d.c(byteArrayOutputStream);
                        d.b(inputStream);
                    } catch (Exception e12) {
                        InputStream inputStream6 = inputStream;
                        e = e12;
                        inputStream4 = inputStream6;
                        e.d("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                        d.b(inputStream2);
                        d.c(byteArrayOutputStream);
                        d.b(inputStream4);
                        InputStream n1122 = n(a11);
                        return n1122;
                    } catch (Throwable th3) {
                        th = th3;
                        d.b(inputStream2);
                        d.c(byteArrayOutputStream);
                        d.b(inputStream);
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                    inputStream2 = null;
                    e.d("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                    d.b(inputStream2);
                    d.c(byteArrayOutputStream);
                    d.b(inputStream4);
                    InputStream n11222 = n(a11);
                    return n11222;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream3 = null;
                    inputStream = inputStream3;
                    inputStream2 = inputStream4;
                    d.b(inputStream2);
                    d.c(byteArrayOutputStream);
                    d.b(inputStream);
                    throw th;
                }
                InputStream n112222 = n(a11);
                return n112222;
            } else {
                e.d("BksUtil", "hms sign error");
                return null;
            }
        }
    }

    public static InputStream n(Context context) {
        if (!k(context)) {
            return null;
        }
        e.e("BksUtil", "getFilesBksIS ");
        try {
            return new FileInputStream(f(context));
        } catch (FileNotFoundException unused) {
            e.d("BksUtil", "FileNotFoundExceptio: ");
            return null;
        }
    }
}

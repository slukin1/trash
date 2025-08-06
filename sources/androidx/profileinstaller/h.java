package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final c f10501a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final c f10502b = new b();

    public class a implements c {
        public void a(int i11, Object obj) {
        }

        public void b(int i11, Object obj) {
        }
    }

    public class b implements c {
        public void a(int i11, Object obj) {
            String str;
            switch (i11) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                default:
                    str = "";
                    break;
            }
            if (i11 == 6 || i11 == 7 || i11 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        public void b(int i11, Object obj) {
            Log.d("ProfileInstaller", i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }
    }

    public interface c {
        void a(int i11, Object obj);

        void b(int i11, Object obj);
    }

    public static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context context, Executor executor, c cVar) {
        b(context.getFilesDir());
        g(executor, cVar, 11, (Object) null);
    }

    public static boolean d(PackageInfo packageInfo, File file, c cVar) {
        DataInputStream dataInputStream;
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean z11 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file2));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            if (readLong == packageInfo.lastUpdateTime) {
                z11 = true;
            }
            if (z11) {
                cVar.a(2, (Object) null);
            }
            return z11;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void f(PackageInfo packageInfo, File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void g(Executor executor, c cVar, int i11, Object obj) {
        executor.execute(new g(cVar, i11, obj));
    }

    public static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) {
        if (Build.VERSION.SDK_INT < 19) {
            g(executor, cVar, 3, (Object) null);
            return false;
        }
        String str3 = str;
        c cVar2 = new c(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!cVar2.e()) {
            return false;
        }
        boolean n11 = cVar2.i().m().n();
        if (n11) {
            f(packageInfo, file);
        }
        return n11;
    }

    public static void i(Context context) {
        j(context, f.f10497b, f10501a);
    }

    public static void j(Context context, Executor executor, c cVar) {
        k(context, executor, cVar, false);
    }

    public static void k(Context context, Executor executor, c cVar, boolean z11) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z12 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z11 || !d(packageInfo, filesDir, cVar)) {
                Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
                if (h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z11) {
                    z12 = true;
                }
                n.c(context, z12);
                return;
            }
            Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
            n.c(context, false);
        } catch (PackageManager.NameNotFoundException e11) {
            cVar.a(7, e11);
            n.c(context, false);
        }
    }

    public static void l(Context context, Executor executor, c cVar) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, cVar, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e11) {
            g(executor, cVar, 7, e11);
        }
    }
}

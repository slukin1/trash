package dy;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.scottyab.rootbeer.RootBeerNative;
import com.xiaomi.mipush.sdk.Constants;
import ey.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28897a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28898b = true;

    public b(Context context) {
        this.f28897a = context;
    }

    public boolean a() {
        return new RootBeerNative().a();
    }

    public boolean b(String str) {
        boolean z11 = false;
        for (String str2 : a.a()) {
            String str3 = str2 + str;
            if (new File(str2, str).exists()) {
                a.f(str3 + " binary detected!");
                z11 = true;
            }
        }
        return z11;
    }

    public boolean c() {
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        String[] p11 = p();
        if (p11 == null) {
            return false;
        }
        boolean z11 = false;
        for (String str : p11) {
            for (String str2 : hashMap.keySet()) {
                if (str.contains(str2)) {
                    String str3 = "[" + ((String) hashMap.get(str2)) + "]";
                    if (str.contains(str3)) {
                        a.f(str2 + " = " + str3 + " detected!");
                        z11 = true;
                    }
                }
            }
        }
        return z11;
    }

    public boolean d() {
        return b("magisk");
    }

    public boolean e() {
        String str;
        String str2;
        String[] strArr;
        String[] o11 = o();
        int i11 = 0;
        if (o11 == null) {
            return false;
        }
        int i12 = Build.VERSION.SDK_INT;
        int length = o11.length;
        int i13 = 0;
        boolean z11 = false;
        while (i13 < length) {
            String str3 = o11[i13];
            String[] split = str3.split(" ");
            int i14 = 23;
            if ((i12 > 23 || split.length >= 4) && (i12 <= 23 || split.length >= 6)) {
                if (i12 > 23) {
                    str = split[2];
                    str2 = split[5];
                } else {
                    str = split[1];
                    str2 = split[3];
                }
                String[] strArr2 = a.f28896e;
                int length2 = strArr2.length;
                int i15 = i11;
                while (i15 < length2) {
                    String str4 = strArr2[i15];
                    if (str.equalsIgnoreCase(str4)) {
                        if (Build.VERSION.SDK_INT > i14) {
                            str2 = str2.replace("(", "").replace(")", "");
                        }
                        String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        int length3 = split2.length;
                        int i16 = 0;
                        while (true) {
                            if (i16 >= length3) {
                                break;
                            }
                            strArr = o11;
                            if (split2[i16].equalsIgnoreCase("rw")) {
                                a.f(str4 + " path is mounted with rw permissions! " + str3);
                                z11 = true;
                                break;
                            }
                            i16++;
                            o11 = strArr;
                        }
                    }
                    strArr = o11;
                    i15++;
                    o11 = strArr;
                    i14 = 23;
                }
            } else {
                a.b("Error formatting mount line: " + str3);
            }
            i13++;
            o11 = o11;
            i11 = 0;
        }
        return z11;
    }

    public boolean f() {
        if (!a()) {
            a.b("We could not load the native library to test for root");
            return false;
        }
        String[] a11 = a.a();
        int length = a11.length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr[i11] = a11[i11] + "su";
        }
        RootBeerNative rootBeerNative = new RootBeerNative();
        try {
            rootBeerNative.setLogDebugMessages(this.f28898b);
            if (rootBeerNative.checkForRoot(strArr) > 0) {
                return true;
            }
            return false;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public boolean g() {
        boolean z11 = false;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                z11 = true;
            }
            exec.destroy();
            return z11;
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public boolean h() {
        return i((String[]) null);
    }

    public boolean i(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(a.f28893b));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return m(arrayList);
    }

    public boolean j() {
        return k((String[]) null);
    }

    public boolean k(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(a.f28892a));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return m(arrayList);
    }

    public boolean l() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public final boolean m(List<String> list) {
        PackageManager packageManager = this.f28897a.getPackageManager();
        boolean z11 = false;
        for (String next : list) {
            try {
                packageManager.getPackageInfo(next, 0);
                a.b(next + " ROOT management app detected!");
                z11 = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z11;
    }

    public boolean n() {
        return j() || h() || b("su") || c() || e() || l() || g() || f() || d();
    }

    public final String[] o() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e11) {
            a.a(e11);
            return null;
        }
    }

    public final String[] p() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e11) {
            a.a(e11);
            return null;
        }
    }
}

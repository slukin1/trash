package com.mob.tools;

import android.text.TextUtils;
import android.util.Base64;
import com.iproov.sdk.bridge.OptionsBridge;
import com.mob.MobSDK;
import com.mob.commons.v;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.HashSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f27674a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f27675b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private volatile HashSet<String> f27676c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private File f27677d;

    /* renamed from: e  reason: collision with root package name */
    private int f27678e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f27679f;

    /* renamed from: com.mob.tools.a$a  reason: collision with other inner class name */
    public interface C0242a {
        void a(String str);

        boolean a(DH.DHResponse dHResponse);
    }

    public a(String str, String str2, int i11) {
        this.f27678e = i11;
        if (str2 == null) {
            str2 = OptionsBridge.NULL_VALUE;
        } else if (TextUtils.isDigitsOnly(str2)) {
            str2 = str + str2;
        }
        this.f27679f = str2;
        File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContextSafely(), str);
        this.f27677d = dataCacheFile;
        if (!dataCacheFile.isDirectory()) {
            this.f27677d.mkdirs();
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.f27676c) {
            this.f27676c.remove(str);
        }
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        synchronized (this.f27676c) {
            if (this.f27676c.contains(str)) {
                return true;
            }
            this.f27676c.add(str);
            return false;
        }
    }

    public void a(String str) throws Throwable {
        a(str, false);
    }

    public void a(String str, boolean z11) throws Throwable {
        FileWriter fileWriter;
        String name;
        if (!TextUtils.isEmpty(str)) {
            String encodeToString = Base64.encodeToString(str.getBytes("utf-8"), 2);
            if (!TextUtils.isEmpty(encodeToString)) {
                synchronized (f27674a) {
                    File a11 = a(z11);
                    BufferedWriter bufferedWriter = null;
                    try {
                        fileWriter = new FileWriter(a11, true);
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                            try {
                                bufferedWriter2.newLine();
                                bufferedWriter2.write(encodeToString);
                                v.a(bufferedWriter2, fileWriter);
                                name = a11.getName();
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    MobLog.getInstance().d(th);
                                    v.a(bufferedWriter, fileWriter);
                                    name = a11.getName();
                                    c(name);
                                } catch (Throwable th3) {
                                    v.a(bufferedWriter, fileWriter);
                                    c(a11.getName());
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            MobLog.getInstance().d(th);
                            v.a(bufferedWriter, fileWriter);
                            name = a11.getName();
                            c(name);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = null;
                        MobLog.getInstance().d(th);
                        v.a(bufferedWriter, fileWriter);
                        name = a11.getName();
                        c(name);
                    }
                    c(name);
                }
            }
        }
    }

    private File a(boolean z11) {
        File file;
        File[] listFiles = this.f27677d.listFiles();
        int i11 = 5;
        int i12 = 3;
        char c11 = 2;
        if (listFiles == null || listFiles.length <= 0) {
            file = new File(this.f27677d, a(this.f27679f, "_", 1, "_", 0));
        } else {
            int length = listFiles.length;
            int i13 = 0;
            int i14 = 1;
            while (i13 < length) {
                File file2 = listFiles[i13];
                String name = file2.getName();
                if (name.startsWith(this.f27679f)) {
                    String[] split = name.split("_");
                    if (!z11 && split.length == i12) {
                        try {
                            int parseInt = Integer.parseInt(split[c11]);
                            if (parseInt < this.f27678e && !b(name)) {
                                File file3 = this.f27677d;
                                Object[] objArr = new Object[i11];
                                objArr[0] = this.f27679f;
                                objArr[1] = "_";
                                objArr[2] = Integer.valueOf(i14);
                                objArr[3] = "_";
                                objArr[4] = Integer.valueOf(parseInt + 1);
                                File file4 = new File(file3, a(objArr));
                                return file2.renameTo(file4) ? file4 : file2;
                            }
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                        }
                    }
                    if (split.length > 1) {
                        try {
                            if (Integer.parseInt(split[1]) == i14) {
                                i14++;
                            }
                        } catch (Throwable th3) {
                            MobLog.getInstance().d(th3);
                        }
                    }
                }
                i13++;
                i11 = 5;
                i12 = 3;
                c11 = 2;
            }
            file = new File(this.f27677d, a(this.f27679f, "_", Integer.valueOf(i14), "_", 0));
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
        return file;
    }

    public void a(final C0242a aVar) {
        if (aVar != null) {
            synchronized (f27675b) {
                final File[] listFiles = this.f27677d.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return !TextUtils.isEmpty(str) && str.startsWith(a.this.f27679f);
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().getAppName().getDeviceKey().getODH().request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) {
                            BufferedReader bufferedReader;
                            for (File file : listFiles) {
                                String name = file.getName();
                                if (!a.this.b(name)) {
                                    FileReader fileReader = null;
                                    try {
                                        FileReader fileReader2 = new FileReader(file);
                                        try {
                                            bufferedReader = new BufferedReader(fileReader2);
                                            while (true) {
                                                try {
                                                    String readLine = bufferedReader.readLine();
                                                    if (readLine == null) {
                                                        break;
                                                    }
                                                    aVar.a(new String(Base64.decode(readLine, 2), "utf-8"));
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    fileReader = fileReader2;
                                                    try {
                                                        MobLog.getInstance().d(th);
                                                        v.a(bufferedReader, fileReader);
                                                        a.this.c(name);
                                                    } catch (Throwable th3) {
                                                        v.a(bufferedReader, fileReader);
                                                        a.this.c(name);
                                                        throw th3;
                                                    }
                                                }
                                            }
                                            if (aVar.a(dHResponse)) {
                                                MobLog.getInstance().d("[LGSM] D l", new Object[0]);
                                                file.delete();
                                            }
                                            v.a(bufferedReader, fileReader2);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bufferedReader = null;
                                            fileReader = fileReader2;
                                            MobLog.getInstance().d(th);
                                            v.a(bufferedReader, fileReader);
                                            a.this.c(name);
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bufferedReader = null;
                                        MobLog.getInstance().d(th);
                                        v.a(bufferedReader, fileReader);
                                        a.this.c(name);
                                    }
                                    a.this.c(name);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public void a(long j11) {
        synchronized (f27675b) {
            File[] listFiles = this.f27677d.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return !TextUtils.isEmpty(str) && str.startsWith(a.this.f27679f);
                }
            });
            if (listFiles != null && listFiles.length > 0) {
                long j12 = 0;
                for (File length : listFiles) {
                    j12 += length.length();
                }
                if (j12 >= j11) {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            }
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object append : objArr) {
            sb2.append(append);
        }
        return sb2.toString();
    }
}

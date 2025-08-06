package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final androidx.concurrent.futures.b<c> f10510a = androidx.concurrent.futures.b.a();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f10511b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static c f10512c = null;

    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f10513a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10514b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10515c;

        /* renamed from: d  reason: collision with root package name */
        public final long f10516d;

        public b(int i11, int i12, long j11, long j12) {
            this.f10513a = i11;
            this.f10514b = i12;
            this.f10515c = j11;
            this.f10516d = j12;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f10513a);
                dataOutputStream.writeInt(this.f10514b);
                dataOutputStream.writeLong(this.f10515c);
                dataOutputStream.writeLong(this.f10516d);
                dataOutputStream.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f10514b == bVar.f10514b && this.f10515c == bVar.f10515c && this.f10513a == bVar.f10513a && this.f10516d == bVar.f10516d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f10514b), Long.valueOf(this.f10515c), Integer.valueOf(this.f10513a), Long.valueOf(this.f10516d)});
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f10517a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10518b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f10519c;

        public c(int i11, boolean z11, boolean z12) {
            this.f10517a = i11;
            this.f10519c = z12;
            this.f10518b = z11;
        }
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return a.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i11, boolean z11, boolean z12) {
        c cVar = new c(i11, z11, z12);
        f10512c = cVar;
        f10510a.set(cVar);
        return f10512c;
    }

    public static c c(Context context, boolean z11) {
        b bVar;
        c cVar;
        if (!z11 && (cVar = f10512c) != null) {
            return cVar;
        }
        synchronized (f10511b) {
            if (!z11) {
                c cVar2 = f10512c;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            int i11 = Build.VERSION.SDK_INT;
            int i12 = 0;
            if (i11 >= 28) {
                if (i11 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    boolean z12 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z13 = file2.exists() && length2 > 0;
                    try {
                        long a11 = a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        b bVar2 = null;
                        if (file3.exists()) {
                            try {
                                bVar2 = b.a(file3);
                            } catch (IOException unused) {
                                return b(131072, z12, z13);
                            }
                        }
                        if (bVar2 != null && bVar2.f10515c == a11) {
                            int i13 = bVar2.f10514b;
                            if (i13 != 2) {
                                i12 = i13;
                                if (z11 && z13 && i12 != 1) {
                                    i12 = 2;
                                }
                                if (bVar2 != null && bVar2.f10514b == 2 && i12 == 1 && length < bVar2.f10516d) {
                                    i12 = 3;
                                }
                                bVar = new b(1, i12, a11, length2);
                                if (bVar2 == null || !bVar2.equals(bVar)) {
                                    bVar.b(file3);
                                }
                                c b11 = b(i12, z12, z13);
                                return b11;
                            }
                        }
                        if (z12) {
                            i12 = 1;
                        } else if (z13) {
                            i12 = 2;
                        }
                        i12 = 2;
                        i12 = 3;
                        bVar = new b(1, i12, a11, length2);
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i12 = 196608;
                        }
                        c b112 = b(i12, z12, z13);
                        return b112;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        return b(65536, z12, z13);
                    }
                }
            }
            c b12 = b(262144, false, false);
            return b12;
        }
    }
}

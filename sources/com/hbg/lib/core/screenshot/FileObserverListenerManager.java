package com.hbg.lib.core.screenshot;

import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileObserverListenerManager implements t6.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f68517a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f68518b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f68519c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<FileObserver> f68520d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public t6.b f68521e;

    /* renamed from: f  reason: collision with root package name */
    public String f68522f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f68523g = new b();

    public class a extends FileObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68524a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, int i11, String str2) {
            super(str, i11);
            this.f68524a = str2;
        }

        public void onEvent(int i11, String str) {
            String unused = FileObserverListenerManager.this.l(i11);
            String str2 = this.f68524a + File.separator + str;
            if (FileObserverListenerManager.this.f68518b.contains(Integer.valueOf(i11))) {
                String unused2 = FileObserverListenerManager.this.f68522f = str2;
                FileObserverListenerManager.this.f68517a.removeCallbacks(FileObserverListenerManager.this.f68523g);
                FileObserverListenerManager.this.f68517a.postDelayed(FileObserverListenerManager.this.f68523g, 500);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (FileObserverListenerManager.this.f68521e != null) {
                FileObserverListenerManager.this.f68521e.a("FileObserver", FileObserverListenerManager.this.f68522f);
            }
        }
    }

    public FileObserverListenerManager() {
        n();
        m();
    }

    public void a() {
        for (FileObserver startWatching : this.f68520d) {
            startWatching.startWatching();
        }
    }

    public void b(t6.b bVar) {
        this.f68521e = bVar;
    }

    public void c() {
        for (FileObserver stopWatching : this.f68520d) {
            stopWatching.stopWatching();
        }
    }

    public void k(String str) {
        this.f68519c.add(str);
        this.f68520d.add(new a(str, 4095, str));
    }

    public final String l(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? i11 != 16 ? i11 != 32 ? i11 != 64 ? i11 != 128 ? i11 != 256 ? i11 != 512 ? i11 != 1024 ? i11 != 2048 ? "No match event" : "MOVE_SELF: The monitored file or directory was moved; monitoring continues" : "DELETE_SELF: The monitored file or directory was deleted; monitoring effectively stops" : "DELETE: A file was deleted from the monitored directory" : "CREATE: A new file or subdirectory was created under the monitored directory" : "MOVED_TO: A file or subdirectory was moved to the monitored directory" : "MOVED_FROM: A file or subdirectory was moved from the monitored directory" : "OPEN: A file or directory was opened" : "CLOSE_NOWRITE: Someone had a file or directory open read-only, and closed it" : "CLOSE_WRITE: Someone had a file or directory open for writing, and closed it" : "ATTRIB: Metadata (permissions, owner, timestamp) was changed explicitly" : "MODIFY: Data was written to a file" : "ACCESS: Data was read from a file";
    }

    public final void m() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        k(new File(externalStoragePublicDirectory, "Screenshots").getPath());
        k(new File(externalStorageDirectory, "ScreenCapture").getPath());
        k(new File(externalStoragePublicDirectory2, "Screenshots").getPath());
    }

    public final void n() {
        this.f68518b.add(8);
        this.f68518b.add(16);
    }
}

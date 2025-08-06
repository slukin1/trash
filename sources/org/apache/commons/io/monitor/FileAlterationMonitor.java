package org.apache.commons.io.monitor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FileAlterationMonitor implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final long f58950b;

    /* renamed from: c  reason: collision with root package name */
    public final List<FileAlterationObserver> f58951c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f58952d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f58953e;

    public FileAlterationMonitor() {
        this(10000);
    }

    public void run() {
        while (this.f58953e) {
            for (FileAlterationObserver checkAndNotify : this.f58951c) {
                checkAndNotify.checkAndNotify();
            }
            if (this.f58953e) {
                try {
                    Thread.sleep(this.f58950b);
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }

    public FileAlterationMonitor(long j11) {
        this.f58951c = new CopyOnWriteArrayList();
        this.f58952d = null;
        this.f58953e = false;
        this.f58950b = j11;
    }
}

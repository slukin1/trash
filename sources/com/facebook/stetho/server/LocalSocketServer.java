package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalSocketServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
    private final String mAddress;
    private final String mFriendlyName;
    private Thread mListenerThread;
    private LocalServerSocket mServerSocket;
    private final SocketHandler mSocketHandler;
    private boolean mStopped;
    private final AtomicInteger mThreadId = new AtomicInteger();

    public static class WorkerThread extends Thread {
        private final LocalSocket mSocket;
        private final SocketHandler mSocketHandler;

        public WorkerThread(LocalSocket localSocket, SocketHandler socketHandler) {
            this.mSocket = localSocket;
            this.mSocketHandler = socketHandler;
        }

        public void run() {
            try {
                this.mSocketHandler.onAccepted(this.mSocket);
            } catch (IOException e11) {
                LogUtil.w("I/O error: %s", e11);
            } catch (Throwable th2) {
                try {
                    this.mSocket.close();
                } catch (IOException unused) {
                }
                throw th2;
            }
            try {
                this.mSocket.close();
            } catch (IOException unused2) {
            }
        }
    }

    public LocalSocketServer(String str, String str2, SocketHandler socketHandler) {
        this.mFriendlyName = (String) Util.throwIfNull(str);
        this.mAddress = (String) Util.throwIfNull(str2);
        this.mSocketHandler = socketHandler;
    }

    private static LocalServerSocket bindToSocket(String str) throws IOException {
        int i11 = 2;
        BindException bindException = null;
        while (true) {
            try {
                if (LogUtil.isLoggable(3)) {
                    LogUtil.d("Trying to bind to @" + str);
                }
                return new LocalServerSocket(str);
            } catch (BindException e11) {
                LogUtil.w((Throwable) e11, "Binding error, sleep 1000 ms...");
                if (bindException == null) {
                    bindException = e11;
                }
                Util.sleepUninterruptibly(1000);
                int i12 = i11 - 1;
                if (i11 > 0) {
                    i11 = i12;
                } else {
                    throw bindException;
                }
            }
        }
    }

    private void listenOnAddress(String str) throws IOException {
        this.mServerSocket = bindToSocket(str);
        LogUtil.i("Listening on @" + str);
        while (!Thread.interrupted()) {
            try {
                WorkerThread workerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
                workerThread.setName("StethoWorker-" + this.mFriendlyName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mThreadId.incrementAndGet());
                workerThread.setDaemon(true);
                workerThread.start();
            } catch (SocketException e11) {
                if (Thread.interrupted()) {
                    break;
                }
                LogUtil.w((Throwable) e11, "I/O error");
            } catch (InterruptedIOException unused) {
            } catch (IOException e12) {
                LogUtil.w((Throwable) e12, "I/O error initialising connection thread");
            }
        }
        LogUtil.i("Server shutdown on @" + str);
    }

    public String getName() {
        return this.mFriendlyName;
    }

    public void run() throws IOException {
        synchronized (this) {
            if (!this.mStopped) {
                this.mListenerThread = Thread.currentThread();
                listenOnAddress(this.mAddress);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = r1.mServerSocket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
        r0.interrupt();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 1
            r1.mStopped = r0     // Catch:{ all -> 0x0016 }
            java.lang.Thread r0 = r1.mListenerThread     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x000a:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            r0.interrupt()
            android.net.LocalServerSocket r0 = r1.mServerSocket     // Catch:{ IOException -> 0x0015 }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.stop():void");
    }
}

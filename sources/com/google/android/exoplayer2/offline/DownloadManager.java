package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.profileinstaller.f;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1);
    private static final int MSG_ADD_DOWNLOAD = 6;
    private static final int MSG_CONTENT_LENGTH_CHANGED = 10;
    private static final int MSG_DOWNLOAD_UPDATE = 2;
    private static final int MSG_INITIALIZE = 0;
    private static final int MSG_INITIALIZED = 0;
    private static final int MSG_PROCESSED = 1;
    private static final int MSG_RELEASE = 12;
    private static final int MSG_REMOVE_ALL_DOWNLOADS = 8;
    private static final int MSG_REMOVE_DOWNLOAD = 7;
    private static final int MSG_SET_DOWNLOADS_PAUSED = 1;
    private static final int MSG_SET_MAX_PARALLEL_DOWNLOADS = 4;
    private static final int MSG_SET_MIN_RETRY_COUNT = 5;
    private static final int MSG_SET_NOT_MET_REQUIREMENTS = 2;
    private static final int MSG_SET_STOP_REASON = 3;
    private static final int MSG_TASK_STOPPED = 9;
    private static final int MSG_UPDATE_PROGRESS = 11;
    private static final String TAG = "DownloadManager";
    private int activeTaskCount;
    private final Handler applicationHandler;
    private final Context context;
    private final WritableDownloadIndex downloadIndex;
    private List<Download> downloads;
    private boolean downloadsPaused;
    private boolean initialized;
    private final InternalHandler internalHandler;
    private final CopyOnWriteArraySet<Listener> listeners;
    private int maxParallelDownloads;
    private int minRetryCount;
    private int notMetRequirements;
    private int pendingMessages;
    private final RequirementsWatcher.Listener requirementsListener;
    private RequirementsWatcher requirementsWatcher;
    private boolean waitingForRequirements;

    public static final class DownloadUpdate {
        public final Download download;
        public final List<Download> downloads;
        public final Exception finalException;
        public final boolean isRemove;

        public DownloadUpdate(Download download2, boolean z11, List<Download> list, Exception exc) {
            this.download = download2;
            this.isRemove = z11;
            this.downloads = list;
            this.finalException = exc;
        }
    }

    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc);

        void onDownloadRemoved(DownloadManager downloadManager, Download download);

        void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z11);

        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i11);

        void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z11);
    }

    public static class Task extends Thread implements Downloader.ProgressListener {
        private long contentLength;
        private final DownloadProgress downloadProgress;
        private final Downloader downloader;
        /* access modifiers changed from: private */
        public Exception finalException;
        private volatile InternalHandler internalHandler;
        /* access modifiers changed from: private */
        public volatile boolean isCanceled;
        /* access modifiers changed from: private */
        public final boolean isRemove;
        private final int minRetryCount;
        /* access modifiers changed from: private */
        public final DownloadRequest request;

        private static int getRetryDelayMillis(int i11) {
            return Math.min((i11 - 1) * 1000, 5000);
        }

        public void cancel(boolean z11) {
            if (z11) {
                this.internalHandler = null;
            }
            if (!this.isCanceled) {
                this.isCanceled = true;
                this.downloader.cancel();
                interrupt();
            }
        }

        public void onProgress(long j11, long j12, float f11) {
            this.downloadProgress.bytesDownloaded = j12;
            this.downloadProgress.percentDownloaded = f11;
            if (j11 != this.contentLength) {
                this.contentLength = j11;
                InternalHandler internalHandler2 = this.internalHandler;
                if (internalHandler2 != null) {
                    internalHandler2.obtainMessage(10, (int) (j11 >> 32), (int) j11, this).sendToTarget();
                }
            }
        }

        public void run() {
            long j11;
            int i11;
            try {
                if (this.isRemove) {
                    this.downloader.remove();
                } else {
                    j11 = -1;
                    i11 = 0;
                    while (!this.isCanceled) {
                        this.downloader.download(this);
                    }
                }
            } catch (IOException e11) {
                if (!this.isCanceled) {
                    long j12 = this.downloadProgress.bytesDownloaded;
                    if (j12 != j11) {
                        i11 = 0;
                        j11 = j12;
                    }
                    i11++;
                    if (i11 <= this.minRetryCount) {
                        Thread.sleep((long) getRetryDelayMillis(i11));
                    } else {
                        throw e11;
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e12) {
                this.finalException = e12;
            }
            InternalHandler internalHandler2 = this.internalHandler;
            if (internalHandler2 != null) {
                internalHandler2.obtainMessage(9, this).sendToTarget();
            }
        }

        private Task(DownloadRequest downloadRequest, Downloader downloader2, DownloadProgress downloadProgress2, boolean z11, int i11, InternalHandler internalHandler2) {
            this.request = downloadRequest;
            this.downloader = downloader2;
            this.downloadProgress = downloadProgress2;
            this.isRemove = z11;
            this.minRetryCount = i11;
            this.internalHandler = internalHandler2;
            this.contentLength = -1;
        }
    }

    @Deprecated
    public DownloadManager(Context context2, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory) {
        this(context2, databaseProvider, cache, factory, f.f10497b);
    }

    /* access modifiers changed from: private */
    public boolean handleMainMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            onInitialized((List) message.obj);
        } else if (i11 == 1) {
            onMessageProcessed(message.arg1, message.arg2);
        } else if (i11 == 2) {
            onDownloadUpdate((DownloadUpdate) message.obj);
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    public static Download mergeRequest(Download download, DownloadRequest downloadRequest, int i11, long j11) {
        int i12;
        Download download2 = download;
        int i13 = download2.state;
        long j12 = (i13 == 5 || download.isTerminalState()) ? j11 : download2.startTimeMs;
        if (i13 == 5 || i13 == 7) {
            i12 = 7;
        } else {
            i12 = i11 != 0 ? 1 : 0;
        }
        return new Download(download2.request.copyWithMergedRequest(downloadRequest), i12, j12, j11, -1, i11, 0);
    }

    private void notifyWaitingForRequirementsChanged() {
        Iterator<Listener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onWaitingForRequirementsChanged(this, this.waitingForRequirements);
        }
    }

    private void onDownloadUpdate(DownloadUpdate downloadUpdate) {
        this.downloads = Collections.unmodifiableList(downloadUpdate.downloads);
        Download download = downloadUpdate.download;
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        if (downloadUpdate.isRemove) {
            Iterator<Listener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadRemoved(this, download);
            }
        } else {
            Iterator<Listener> it3 = this.listeners.iterator();
            while (it3.hasNext()) {
                it3.next().onDownloadChanged(this, download, downloadUpdate.finalException);
            }
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    private void onInitialized(List<Download> list) {
        this.initialized = true;
        this.downloads = Collections.unmodifiableList(list);
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        Iterator<Listener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onInitialized(this);
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    private void onMessageProcessed(int i11, int i12) {
        this.pendingMessages -= i11;
        this.activeTaskCount = i12;
        if (isIdle()) {
            Iterator<Listener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onIdle(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher2, int i11) {
        Requirements requirements = requirementsWatcher2.getRequirements();
        if (this.notMetRequirements != i11) {
            this.notMetRequirements = i11;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(2, i11, 0).sendToTarget();
        }
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        Iterator<Listener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onRequirementsStateChanged(this, requirements, i11);
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    private void setDownloadsPaused(boolean z11) {
        if (this.downloadsPaused != z11) {
            this.downloadsPaused = z11;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(1, z11 ? 1 : 0, 0).sendToTarget();
            boolean updateWaitingForRequirements = updateWaitingForRequirements();
            Iterator<Listener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadsPausedChanged(this, z11);
            }
            if (updateWaitingForRequirements) {
                notifyWaitingForRequirementsChanged();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateWaitingForRequirements() {
        /*
            r4 = this;
            boolean r0 = r4.downloadsPaused
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0024
            int r0 = r4.notMetRequirements
            if (r0 == 0) goto L_0x0024
            r0 = r2
        L_0x000b:
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.downloads
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0024
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.downloads
            java.lang.Object r3 = r3.get(r0)
            com.google.android.exoplayer2.offline.Download r3 = (com.google.android.exoplayer2.offline.Download) r3
            int r3 = r3.state
            if (r3 != 0) goto L_0x0021
            r0 = r1
            goto L_0x0025
        L_0x0021:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0024:
            r0 = r2
        L_0x0025:
            boolean r3 = r4.waitingForRequirements
            if (r3 == r0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            r4.waitingForRequirements = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadManager.updateWaitingForRequirements():boolean");
    }

    public void addDownload(DownloadRequest downloadRequest) {
        addDownload(downloadRequest, 0);
    }

    public void addListener(Listener listener) {
        Assertions.checkNotNull(listener);
        this.listeners.add(listener);
    }

    public Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    public List<Download> getCurrentDownloads() {
        return this.downloads;
    }

    public DownloadIndex getDownloadIndex() {
        return this.downloadIndex;
    }

    public boolean getDownloadsPaused() {
        return this.downloadsPaused;
    }

    public int getMaxParallelDownloads() {
        return this.maxParallelDownloads;
    }

    public int getMinRetryCount() {
        return this.minRetryCount;
    }

    public int getNotMetRequirements() {
        return this.notMetRequirements;
    }

    public Requirements getRequirements() {
        return this.requirementsWatcher.getRequirements();
    }

    public boolean isIdle() {
        return this.activeTaskCount == 0 && this.pendingMessages == 0;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public boolean isWaitingForRequirements() {
        return this.waitingForRequirements;
    }

    public void pauseDownloads() {
        setDownloadsPaused(true);
    }

    public void release() {
        synchronized (this.internalHandler) {
            InternalHandler internalHandler2 = this.internalHandler;
            if (!internalHandler2.released) {
                internalHandler2.sendEmptyMessage(12);
                boolean z11 = false;
                while (true) {
                    InternalHandler internalHandler3 = this.internalHandler;
                    if (internalHandler3.released) {
                        break;
                    }
                    try {
                        internalHandler3.wait();
                    } catch (InterruptedException unused) {
                        z11 = true;
                    }
                }
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                this.applicationHandler.removeCallbacksAndMessages((Object) null);
                this.downloads = Collections.emptyList();
                this.pendingMessages = 0;
                this.activeTaskCount = 0;
                this.initialized = false;
                this.notMetRequirements = 0;
                this.waitingForRequirements = false;
            }
        }
    }

    public void removeAllDownloads() {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(String str) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(7, str).sendToTarget();
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public void resumeDownloads() {
        setDownloadsPaused(false);
    }

    public void setMaxParallelDownloads(int i11) {
        Assertions.checkArgument(i11 > 0);
        if (this.maxParallelDownloads != i11) {
            this.maxParallelDownloads = i11;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(4, i11, 0).sendToTarget();
        }
    }

    public void setMinRetryCount(int i11) {
        Assertions.checkArgument(i11 >= 0);
        if (this.minRetryCount != i11) {
            this.minRetryCount = i11;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(5, i11, 0).sendToTarget();
        }
    }

    public void setRequirements(Requirements requirements) {
        if (!requirements.equals(this.requirementsWatcher.getRequirements())) {
            this.requirementsWatcher.stop();
            RequirementsWatcher requirementsWatcher2 = new RequirementsWatcher(this.context, this.requirementsListener, requirements);
            this.requirementsWatcher = requirementsWatcher2;
            onRequirementsStateChanged(this.requirementsWatcher, requirementsWatcher2.start());
        }
    }

    public void setStopReason(String str, int i11) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(3, i11, 0, str).sendToTarget();
    }

    public DownloadManager(Context context2, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context2, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory), executor));
    }

    public void addDownload(DownloadRequest downloadRequest, int i11) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(6, i11, 0, downloadRequest).sendToTarget();
    }

    public DownloadManager(Context context2, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.context = context2.getApplicationContext();
        this.downloadIndex = writableDownloadIndex;
        this.maxParallelDownloads = 3;
        this.minRetryCount = 5;
        this.downloadsPaused = true;
        this.downloads = Collections.emptyList();
        this.listeners = new CopyOnWriteArraySet<>();
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(new i(this));
        this.applicationHandler = createHandlerForCurrentOrMainLooper;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        InternalHandler internalHandler2 = new InternalHandler(handlerThread, writableDownloadIndex, downloaderFactory, createHandlerForCurrentOrMainLooper, this.maxParallelDownloads, this.minRetryCount, this.downloadsPaused);
        this.internalHandler = internalHandler2;
        j jVar = new j(this);
        this.requirementsListener = jVar;
        RequirementsWatcher requirementsWatcher2 = new RequirementsWatcher(context2, jVar, DEFAULT_REQUIREMENTS);
        this.requirementsWatcher = requirementsWatcher2;
        int start = requirementsWatcher2.start();
        this.notMetRequirements = start;
        this.pendingMessages = 1;
        internalHandler2.obtainMessage(0, start, 0).sendToTarget();
    }

    public static final class InternalHandler extends Handler {
        private static final int UPDATE_PROGRESS_INTERVAL_MS = 5000;
        private int activeDownloadTaskCount;
        private final HashMap<String, Task> activeTasks = new HashMap<>();
        private final WritableDownloadIndex downloadIndex;
        private final DownloaderFactory downloaderFactory;
        private final ArrayList<Download> downloads = new ArrayList<>();
        private boolean downloadsPaused;
        private final Handler mainHandler;
        private int maxParallelDownloads;
        private int minRetryCount;
        private int notMetRequirements;
        public boolean released;
        private final HandlerThread thread;

        public InternalHandler(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory2, Handler handler, int i11, int i12, boolean z11) {
            super(handlerThread.getLooper());
            this.thread = handlerThread;
            this.downloadIndex = writableDownloadIndex;
            this.downloaderFactory = downloaderFactory2;
            this.mainHandler = handler;
            this.maxParallelDownloads = i11;
            this.minRetryCount = i12;
            this.downloadsPaused = z11;
        }

        private void addDownload(DownloadRequest downloadRequest, int i11) {
            int i12 = 1;
            Download download = getDownload(downloadRequest.f65951id, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (download != null) {
                putDownload(DownloadManager.mergeRequest(download, downloadRequest, i11, currentTimeMillis));
            } else {
                if (i11 == 0) {
                    i12 = 0;
                }
                putDownload(new Download(downloadRequest, i12, currentTimeMillis, currentTimeMillis, -1, i11, 0));
            }
            syncTasks();
        }

        private boolean canDownloadsRun() {
            return !this.downloadsPaused && this.notMetRequirements == 0;
        }

        /* access modifiers changed from: private */
        public static int compareStartTimes(Download download, Download download2) {
            return Util.compareLong(download.startTimeMs, download2.startTimeMs);
        }

        private static Download copyDownloadWithState(Download download, int i11, int i12) {
            return new Download(download.request, i11, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i12, 0, download.progress);
        }

        private Download getDownload(String str, boolean z11) {
            int downloadIndex2 = getDownloadIndex(str);
            if (downloadIndex2 != -1) {
                return this.downloads.get(downloadIndex2);
            }
            if (!z11) {
                return null;
            }
            try {
                return this.downloadIndex.getDownload(str);
            } catch (IOException e11) {
                String valueOf = String.valueOf(str);
                Log.e(DownloadManager.TAG, valueOf.length() != 0 ? "Failed to load download: ".concat(valueOf) : new String("Failed to load download: "), e11);
                return null;
            }
        }

        private int getDownloadIndex(String str) {
            for (int i11 = 0; i11 < this.downloads.size(); i11++) {
                if (this.downloads.get(i11).request.f65951id.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        private void initialize(int i11) {
            this.notMetRequirements = i11;
            DownloadCursor downloadCursor = null;
            try {
                this.downloadIndex.setDownloadingStatesToQueued();
                downloadCursor = this.downloadIndex.getDownloads(0, 1, 2, 5, 7);
                while (downloadCursor.moveToNext()) {
                    this.downloads.add(downloadCursor.getDownload());
                }
            } catch (IOException e11) {
                Log.e(DownloadManager.TAG, "Failed to load index.", e11);
                this.downloads.clear();
            } catch (Throwable th2) {
                Util.closeQuietly((Closeable) null);
                throw th2;
            }
            Util.closeQuietly((Closeable) downloadCursor);
            this.mainHandler.obtainMessage(0, new ArrayList(this.downloads)).sendToTarget();
            syncTasks();
        }

        private void onContentLengthChanged(Task task, long j11) {
            Download download = (Download) Assertions.checkNotNull(getDownload(task.request.f65951id, false));
            if (j11 != download.contentLength && j11 != -1) {
                putDownload(new Download(download.request, download.state, download.startTimeMs, System.currentTimeMillis(), j11, download.stopReason, download.failureReason, download.progress));
            }
        }

        private void onDownloadTaskStopped(Download download, Exception exc) {
            Download download2 = download;
            Exception exc2 = exc;
            Download download3 = new Download(download2.request, exc2 == null ? 3 : 4, download2.startTimeMs, System.currentTimeMillis(), download2.contentLength, download2.stopReason, exc2 == null ? 0 : 1, download2.progress);
            this.downloads.remove(getDownloadIndex(download3.request.f65951id));
            try {
                this.downloadIndex.putDownload(download3);
            } catch (IOException e11) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e11);
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download3, false, new ArrayList(this.downloads), exc)).sendToTarget();
        }

        private void onRemoveTaskStopped(Download download) {
            int i11 = 1;
            if (download.state == 7) {
                int i12 = download.stopReason;
                if (i12 == 0) {
                    i11 = 0;
                }
                putDownloadWithState(download, i11, i12);
                syncTasks();
                return;
            }
            this.downloads.remove(getDownloadIndex(download.request.f65951id));
            try {
                this.downloadIndex.removeDownload(download.request.f65951id);
            } catch (IOException unused) {
                Log.e(DownloadManager.TAG, "Failed to remove from database");
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download, true, new ArrayList(this.downloads), (Exception) null)).sendToTarget();
        }

        private void onTaskStopped(Task task) {
            String str = task.request.f65951id;
            this.activeTasks.remove(str);
            boolean access$000 = task.isRemove;
            if (!access$000) {
                int i11 = this.activeDownloadTaskCount - 1;
                this.activeDownloadTaskCount = i11;
                if (i11 == 0) {
                    removeMessages(11);
                }
            }
            if (task.isCanceled) {
                syncTasks();
                return;
            }
            Exception access$400 = task.finalException;
            if (access$400 != null) {
                String valueOf = String.valueOf(task.request);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
                sb2.append("Task failed: ");
                sb2.append(valueOf);
                sb2.append(", ");
                sb2.append(access$000);
                Log.e(DownloadManager.TAG, sb2.toString(), access$400);
            }
            Download download = (Download) Assertions.checkNotNull(getDownload(str, false));
            int i12 = download.state;
            if (i12 == 2) {
                Assertions.checkState(!access$000);
                onDownloadTaskStopped(download, access$400);
            } else if (i12 == 5 || i12 == 7) {
                Assertions.checkState(access$000);
                onRemoveTaskStopped(download);
            } else {
                throw new IllegalStateException();
            }
            syncTasks();
        }

        private Download putDownload(Download download) {
            int i11 = download.state;
            boolean z11 = true;
            Assertions.checkState((i11 == 3 || i11 == 4) ? false : true);
            int downloadIndex2 = getDownloadIndex(download.request.f65951id);
            if (downloadIndex2 == -1) {
                this.downloads.add(download);
                Collections.sort(this.downloads, k.f65964b);
            } else {
                if (download.startTimeMs == this.downloads.get(downloadIndex2).startTimeMs) {
                    z11 = false;
                }
                this.downloads.set(downloadIndex2, download);
                if (z11) {
                    Collections.sort(this.downloads, k.f65964b);
                }
            }
            try {
                this.downloadIndex.putDownload(download);
            } catch (IOException e11) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e11);
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download, false, new ArrayList(this.downloads), (Exception) null)).sendToTarget();
            return download;
        }

        private Download putDownloadWithState(Download download, int i11, int i12) {
            Assertions.checkState((i11 == 3 || i11 == 4) ? false : true);
            return putDownload(copyDownloadWithState(download, i11, i12));
        }

        private void release() {
            for (Task cancel : this.activeTasks.values()) {
                cancel.cancel(true);
            }
            try {
                this.downloadIndex.setDownloadingStatesToQueued();
            } catch (IOException e11) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e11);
            }
            this.downloads.clear();
            this.thread.quit();
            synchronized (this) {
                this.released = true;
                notifyAll();
            }
        }

        private void removeAllDownloads() {
            DownloadCursor downloads2;
            ArrayList arrayList = new ArrayList();
            try {
                downloads2 = this.downloadIndex.getDownloads(3, 4);
                while (downloads2.moveToNext()) {
                    arrayList.add(downloads2.getDownload());
                }
                downloads2.close();
            } catch (IOException unused) {
                Log.e(DownloadManager.TAG, "Failed to load downloads.");
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            for (int i11 = 0; i11 < this.downloads.size(); i11++) {
                ArrayList<Download> arrayList2 = this.downloads;
                arrayList2.set(i11, copyDownloadWithState(arrayList2.get(i11), 5, 0));
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                this.downloads.add(copyDownloadWithState((Download) arrayList.get(i12), 5, 0));
            }
            Collections.sort(this.downloads, k.f65964b);
            try {
                this.downloadIndex.setStatesToRemoving();
            } catch (IOException e11) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e11);
            }
            ArrayList arrayList3 = new ArrayList(this.downloads);
            for (int i13 = 0; i13 < this.downloads.size(); i13++) {
                this.mainHandler.obtainMessage(2, new DownloadUpdate(this.downloads.get(i13), false, arrayList3, (Exception) null)).sendToTarget();
            }
            syncTasks();
            return;
            throw th;
        }

        private void removeDownload(String str) {
            Download download = getDownload(str, true);
            if (download == null) {
                String valueOf = String.valueOf(str);
                Log.e(DownloadManager.TAG, valueOf.length() != 0 ? "Failed to remove nonexistent download: ".concat(valueOf) : new String("Failed to remove nonexistent download: "));
                return;
            }
            putDownloadWithState(download, 5, 0);
            syncTasks();
        }

        private void setDownloadsPaused(boolean z11) {
            this.downloadsPaused = z11;
            syncTasks();
        }

        private void setMaxParallelDownloads(int i11) {
            this.maxParallelDownloads = i11;
            syncTasks();
        }

        private void setMinRetryCount(int i11) {
            this.minRetryCount = i11;
        }

        private void setNotMetRequirements(int i11) {
            this.notMetRequirements = i11;
            syncTasks();
        }

        private void setStopReason(String str, int i11) {
            if (str == null) {
                for (int i12 = 0; i12 < this.downloads.size(); i12++) {
                    setStopReason(this.downloads.get(i12), i11);
                }
                try {
                    this.downloadIndex.setStopReason(i11);
                } catch (IOException e11) {
                    Log.e(DownloadManager.TAG, "Failed to set manual stop reason", e11);
                }
            } else {
                Download download = getDownload(str, false);
                if (download != null) {
                    setStopReason(download, i11);
                } else {
                    try {
                        this.downloadIndex.setStopReason(str, i11);
                    } catch (IOException e12) {
                        Log.e(DownloadManager.TAG, str.length() != 0 ? "Failed to set manual stop reason: ".concat(str) : new String("Failed to set manual stop reason: "), e12);
                    }
                }
            }
            syncTasks();
        }

        private void syncDownloadingDownload(Task task, Download download, int i11) {
            Assertions.checkState(!task.isRemove);
            if (!canDownloadsRun() || i11 >= this.maxParallelDownloads) {
                putDownloadWithState(download, 0, 0);
                task.cancel(false);
            }
        }

        private Task syncQueuedDownload(Task task, Download download) {
            if (task != null) {
                Assertions.checkState(!task.isRemove);
                task.cancel(false);
                return task;
            } else if (!canDownloadsRun() || this.activeDownloadTaskCount >= this.maxParallelDownloads) {
                return null;
            } else {
                Download putDownloadWithState = putDownloadWithState(download, 2, 0);
                Task task2 = new Task(putDownloadWithState.request, this.downloaderFactory.createDownloader(putDownloadWithState.request), putDownloadWithState.progress, false, this.minRetryCount, this);
                this.activeTasks.put(putDownloadWithState.request.f65951id, task2);
                int i11 = this.activeDownloadTaskCount;
                this.activeDownloadTaskCount = i11 + 1;
                if (i11 == 0) {
                    sendEmptyMessageDelayed(11, 5000);
                }
                task2.start();
                return task2;
            }
        }

        private void syncRemovingDownload(Task task, Download download) {
            if (task == null) {
                Task task2 = new Task(download.request, this.downloaderFactory.createDownloader(download.request), download.progress, true, this.minRetryCount, this);
                this.activeTasks.put(download.request.f65951id, task2);
                task2.start();
            } else if (!task.isRemove) {
                task.cancel(false);
            }
        }

        private void syncStoppedDownload(Task task) {
            if (task != null) {
                Assertions.checkState(!task.isRemove);
                task.cancel(false);
            }
        }

        private void syncTasks() {
            int i11 = 0;
            for (int i12 = 0; i12 < this.downloads.size(); i12++) {
                Download download = this.downloads.get(i12);
                Task task = this.activeTasks.get(download.request.f65951id);
                int i13 = download.state;
                if (i13 == 0) {
                    task = syncQueuedDownload(task, download);
                } else if (i13 == 1) {
                    syncStoppedDownload(task);
                } else if (i13 == 2) {
                    Assertions.checkNotNull(task);
                    syncDownloadingDownload(task, download, i11);
                } else if (i13 == 5 || i13 == 7) {
                    syncRemovingDownload(task, download);
                } else {
                    throw new IllegalStateException();
                }
                if (task != null && !task.isRemove) {
                    i11++;
                }
            }
        }

        private void updateProgress() {
            for (int i11 = 0; i11 < this.downloads.size(); i11++) {
                Download download = this.downloads.get(i11);
                if (download.state == 2) {
                    try {
                        this.downloadIndex.putDownload(download);
                    } catch (IOException e11) {
                        Log.e(DownloadManager.TAG, "Failed to update index.", e11);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000);
        }

        public void handleMessage(Message message) {
            boolean z11 = false;
            switch (message.what) {
                case 0:
                    initialize(message.arg1);
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z11 = true;
                    }
                    setDownloadsPaused(z11);
                    break;
                case 2:
                    setNotMetRequirements(message.arg1);
                    break;
                case 3:
                    setStopReason((String) message.obj, message.arg1);
                    break;
                case 4:
                    setMaxParallelDownloads(message.arg1);
                    break;
                case 5:
                    setMinRetryCount(message.arg1);
                    break;
                case 6:
                    addDownload((DownloadRequest) message.obj, message.arg1);
                    break;
                case 7:
                    removeDownload((String) message.obj);
                    break;
                case 8:
                    removeAllDownloads();
                    break;
                case 9:
                    onTaskStopped((Task) message.obj);
                    break;
                case 10:
                    onContentLengthChanged((Task) message.obj, Util.toLong(message.arg1, message.arg2));
                    return;
                case 11:
                    updateProgress();
                    return;
                case 12:
                    release();
                    return;
                default:
                    throw new IllegalStateException();
            }
            z11 = true;
            this.mainHandler.obtainMessage(1, z11 ? 1 : 0, this.activeTasks.size()).sendToTarget();
        }

        private void setStopReason(Download download, int i11) {
            Download download2 = download;
            int i12 = i11;
            if (i12 == 0) {
                if (download2.state == 1) {
                    putDownloadWithState(download, 0, 0);
                }
            } else if (i12 != download2.stopReason) {
                int i13 = download2.state;
                if (i13 == 0 || i13 == 2) {
                    i13 = 1;
                }
                putDownload(new Download(download2.request, i13, download2.startTimeMs, System.currentTimeMillis(), download2.contentLength, i11, 0, download2.progress));
            }
        }
    }
}

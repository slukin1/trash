package com.sensorsdata.analytics.android.sdk;

import java.util.concurrent.LinkedBlockingQueue;

public class TrackTaskManager {
    private static TrackTaskManager trackTaskManager;
    private boolean mDataCollectEnable = true;
    private final LinkedBlockingQueue<Runnable> mTrackEventTasks = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Runnable> mTrackEventTasksCache = new LinkedBlockingQueue<>();

    private TrackTaskManager() {
    }

    public static synchronized TrackTaskManager getInstance() {
        TrackTaskManager trackTaskManager2;
        synchronized (TrackTaskManager.class) {
            try {
                if (trackTaskManager == null) {
                    trackTaskManager = new TrackTaskManager();
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
            trackTaskManager2 = trackTaskManager;
        }
        return trackTaskManager2;
    }

    public void addTrackEventTask(Runnable runnable) {
        try {
            if (this.mDataCollectEnable) {
                this.mTrackEventTasks.put(runnable);
            } else {
                this.mTrackEventTasksCache.put(runnable);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public boolean isEmpty() {
        return this.mTrackEventTasks.isEmpty();
    }

    public Runnable pollTrackEventTask() {
        try {
            if (this.mDataCollectEnable) {
                return this.mTrackEventTasks.poll();
            }
            return this.mTrackEventTasksCache.poll();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public void setDataCollectEnable(boolean z11) {
        this.mDataCollectEnable = z11;
        if (z11) {
            try {
                this.mTrackEventTasksCache.put(new Runnable() {
                    public void run() {
                    }
                });
            } catch (InterruptedException e11) {
                SALog.printStackTrace(e11);
            }
        } else {
            this.mTrackEventTasks.put(new Runnable() {
                public void run() {
                }
            });
        }
    }

    public Runnable takeTrackEventTask() {
        try {
            if (this.mDataCollectEnable) {
                return this.mTrackEventTasks.take();
            }
            return this.mTrackEventTasksCache.take();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public void transformTaskQueue(Runnable runnable) {
        try {
            if (this.mTrackEventTasks.size() < 50) {
                this.mTrackEventTasks.put(runnable);
            }
        } catch (InterruptedException e11) {
            SALog.printStackTrace(e11);
        }
    }
}

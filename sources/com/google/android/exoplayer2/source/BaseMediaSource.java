package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseMediaSource implements MediaSource {
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher = new DrmSessionEventListener.EventDispatcher();
    private final HashSet<MediaSource.MediaSourceCaller> enabledMediaSourceCallers = new HashSet<>(1);
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private Looper looper;
    private final ArrayList<MediaSource.MediaSourceCaller> mediaSourceCallers = new ArrayList<>(1);
    private Timeline timeline;

    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        this.drmEventDispatcher.addEventListener(handler, drmSessionEventListener);
    }

    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.drmEventDispatcher.withParameters(0, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0);
    }

    public final void disable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z11 = !this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.remove(mediaSourceCaller);
        if (z11 && this.enabledMediaSourceCallers.isEmpty()) {
            disableInternal();
        }
    }

    public void disableInternal() {
    }

    public final void enable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.checkNotNull(this.looper);
        boolean isEmpty = this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.add(mediaSourceCaller);
        if (isEmpty) {
            enableInternal();
        }
    }

    public void enableInternal() {
    }

    public /* synthetic */ Timeline getInitialTimeline() {
        return e.a(this);
    }

    public /* synthetic */ Object getTag() {
        return e.b(this);
    }

    public final boolean isEnabled() {
        return !this.enabledMediaSourceCallers.isEmpty();
    }

    public /* synthetic */ boolean isSingleWindow() {
        return e.c(this);
    }

    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        Looper myLooper = Looper.myLooper();
        Looper looper2 = this.looper;
        Assertions.checkArgument(looper2 == null || looper2 == myLooper);
        Timeline timeline2 = this.timeline;
        this.mediaSourceCallers.add(mediaSourceCaller);
        if (this.looper == null) {
            this.looper = myLooper;
            this.enabledMediaSourceCallers.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline2 != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline2);
        }
    }

    public abstract void prepareSourceInternal(TransferListener transferListener);

    public final void refreshSourceInfo(Timeline timeline2) {
        this.timeline = timeline2;
        Iterator<MediaSource.MediaSourceCaller> it2 = this.mediaSourceCallers.iterator();
        while (it2.hasNext()) {
            it2.next().onSourceInfoRefreshed(this, timeline2);
        }
    }

    public final void releaseSource(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.mediaSourceCallers.remove(mediaSourceCaller);
        if (this.mediaSourceCallers.isEmpty()) {
            this.looper = null;
            this.timeline = null;
            this.enabledMediaSourceCallers.clear();
            releaseSourceInternal();
            return;
        }
        disable(mediaSourceCaller);
    }

    public abstract void releaseSourceInternal();

    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.drmEventDispatcher.removeEventListener(drmSessionEventListener);
    }

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.drmEventDispatcher.withParameters(i11, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j11) {
        Assertions.checkNotNull(mediaPeriodId);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j11);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i11, MediaSource.MediaPeriodId mediaPeriodId, long j11) {
        return this.eventDispatcher.withParameters(i11, mediaPeriodId, j11);
    }
}

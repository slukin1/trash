package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {

    public static class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        public static final class ListenerAndHandler {
            public Handler handler;
            public MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler2;
                this.listener = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null, 0);
        }

        private long adjustMediaTime(long j11) {
            long usToMs = C.usToMs(j11);
            if (usToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$downstreamFormatChanged$5(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$loadCanceled$2(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$loadCompleted$1(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$loadError$3(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$loadStarted$0(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$upstreamDiscarded$4(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId2, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId2, mediaLoadData);
        }

        public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(mediaSourceEventListener);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void downstreamFormatChanged(int i11, Format format, int i12, Object obj, long j11) {
            downstreamFormatChanged(new MediaLoadData(1, i11, format, i12, obj, adjustMediaTime(j11), -9223372036854775807L));
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i11) {
            loadCanceled(loadEventInfo, i11, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i11) {
            loadCompleted(loadEventInfo, i11, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i11, IOException iOException, boolean z11) {
            loadError(loadEventInfo, i11, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, iOException, z11);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i11) {
            loadStarted(loadEventInfo, i11, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public void upstreamDiscarded(int i11, long j11, long j12) {
            long j13 = j11;
            upstreamDiscarded(new MediaLoadData(1, i11, (Format) null, 3, (Object) null, adjustMediaTime(j11), adjustMediaTime(j12)));
        }

        public EventDispatcher withParameters(int i11, MediaSource.MediaPeriodId mediaPeriodId2, long j11) {
            return new EventDispatcher(this.listenerAndHandlers, i11, mediaPeriodId2, j11);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i11, MediaSource.MediaPeriodId mediaPeriodId2, long j11) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i11;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaTimeOffsetMs = j11;
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i11, int i12, Format format, int i13, Object obj, long j11, long j12) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadCanceled(loadEventInfo, new MediaLoadData(i11, i12, format, i13, obj, adjustMediaTime(j11), adjustMediaTime(j12)));
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i11, int i12, Format format, int i13, Object obj, long j11, long j12) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadCompleted(loadEventInfo, new MediaLoadData(i11, i12, format, i13, obj, adjustMediaTime(j11), adjustMediaTime(j12)));
        }

        public void loadError(LoadEventInfo loadEventInfo, int i11, int i12, Format format, int i13, Object obj, long j11, long j12, IOException iOException, boolean z11) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadError(loadEventInfo, new MediaLoadData(i11, i12, format, i13, obj, adjustMediaTime(j11), adjustMediaTime(j12)), iOException, z11);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i11, int i12, Format format, int i13, Object obj, long j11, long j12) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadStarted(loadEventInfo, new MediaLoadData(i11, i12, format, i13, obj, adjustMediaTime(j11), adjustMediaTime(j12)));
        }

        public void downstreamFormatChanged(MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new k(this, next.listener, mediaLoadData));
            }
        }

        public void upstreamDiscarded(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new l(this, next.listener, mediaPeriodId2, mediaLoadData));
            }
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new i(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new g(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }

        public void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new j(this, next.listener, loadEventInfo, mediaLoadData, iOException, z11));
            }
        }

        public void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.listenerAndHandlers.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.postOrRun(next.handler, new h(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }
    }

    void onDownstreamFormatChanged(int i11, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11);

    void onLoadStarted(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onUpstreamDiscarded(int i11, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);
}

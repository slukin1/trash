package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {
            private final CopyOnWriteArrayList<HandlerAndListener> listeners = new CopyOnWriteArrayList<>();

            public static final class HandlerAndListener {
                /* access modifiers changed from: private */
                public final Handler handler;
                /* access modifiers changed from: private */
                public final EventListener listener;
                /* access modifiers changed from: private */
                public boolean released;

                public HandlerAndListener(Handler handler2, EventListener eventListener) {
                    this.handler = handler2;
                    this.listener = eventListener;
                }

                public void release() {
                    this.released = true;
                }
            }

            public void addListener(Handler handler, EventListener eventListener) {
                Assertions.checkNotNull(handler);
                Assertions.checkNotNull(eventListener);
                removeListener(eventListener);
                this.listeners.add(new HandlerAndListener(handler, eventListener));
            }

            public void bandwidthSample(int i11, long j11, long j12) {
                Iterator<HandlerAndListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (!next.released) {
                        next.handler.post(new b(next, i11, j11, j12));
                    }
                }
            }

            public void removeListener(EventListener eventListener) {
                Iterator<HandlerAndListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (next.listener == eventListener) {
                        next.release();
                        this.listeners.remove(next);
                    }
                }
            }
        }

        void onBandwidthSample(int i11, long j11, long j12);
    }

    void addEventListener(Handler handler, EventListener eventListener);

    long getBitrateEstimate();

    long getTimeToFirstByteEstimateUs();

    TransferListener getTransferListener();

    void removeEventListener(EventListener eventListener);
}

package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.ExoFlags;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet<T> {
    private static final int MSG_ITERATION_FINISHED = 0;
    private static final int MSG_LAZY_RELEASE = 1;
    private final Clock clock;
    private final ArrayDeque<Runnable> flushingEvents;
    private final HandlerWrapper handler;
    private final IterationFinishedEvent<T> iterationFinishedEvent;
    private final CopyOnWriteArraySet<ListenerHolder<T>> listeners;
    private final ArrayDeque<Runnable> queuedEvents;
    private boolean released;

    public interface Event<T> {
        void invoke(T t11);
    }

    public interface IterationFinishedEvent<T> {
        void invoke(T t11, ExoFlags exoFlags);
    }

    public static final class ListenerHolder<T> {
        private ExoFlags.Builder flagsBuilder = new ExoFlags.Builder();
        public final T listener;
        private boolean needsIterationFinishedEvent;
        private boolean released;

        public ListenerHolder(T t11) {
            this.listener = t11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invoke(int i11, Event<T> event) {
            if (!this.released) {
                if (i11 != -1) {
                    this.flagsBuilder.add(i11);
                }
                this.needsIterationFinishedEvent = true;
                event.invoke(this.listener);
            }
        }

        public void iterationFinished(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.released && this.needsIterationFinishedEvent) {
                ExoFlags build = this.flagsBuilder.build();
                this.flagsBuilder = new ExoFlags.Builder();
                this.needsIterationFinishedEvent = false;
                iterationFinishedEvent.invoke(this.listener, build);
            }
        }

        public void release(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.released = true;
            if (this.needsIterationFinishedEvent) {
                iterationFinishedEvent.invoke(this.listener, this.flagsBuilder.build());
            }
        }
    }

    public ListenerSet(Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this(new CopyOnWriteArraySet(), looper, clock2, iterationFinishedEvent2);
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            Iterator<ListenerHolder<T>> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().iterationFinished(this.iterationFinishedEvent);
                if (this.handler.hasMessages(0)) {
                    break;
                }
            }
        } else if (i11 == 1) {
            sendEvent(message.arg1, (Event) message.obj);
            release();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$queueEvent$0(CopyOnWriteArraySet copyOnWriteArraySet, int i11, Event event) {
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((ListenerHolder) it2.next()).invoke(i11, event);
        }
    }

    public void add(T t11) {
        if (!this.released) {
            Assertions.checkNotNull(t11);
            this.listeners.add(new ListenerHolder(t11));
        }
    }

    public ListenerSet<T> copy(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent2) {
        return new ListenerSet<>(this.listeners, looper, this.clock, iterationFinishedEvent2);
    }

    public void flushEvents() {
        if (!this.queuedEvents.isEmpty()) {
            if (!this.handler.hasMessages(0)) {
                this.handler.obtainMessage(0).sendToTarget();
            }
            boolean z11 = !this.flushingEvents.isEmpty();
            this.flushingEvents.addAll(this.queuedEvents);
            this.queuedEvents.clear();
            if (!z11) {
                while (!this.flushingEvents.isEmpty()) {
                    this.flushingEvents.peekFirst().run();
                    this.flushingEvents.removeFirst();
                }
            }
        }
    }

    public void lazyRelease(int i11, Event<T> event) {
        this.handler.obtainMessage(1, i11, 0, event).sendToTarget();
    }

    public void queueEvent(int i11, Event<T> event) {
        this.queuedEvents.add(new b(new CopyOnWriteArraySet(this.listeners), i11, event));
    }

    public void release() {
        Iterator<ListenerHolder<T>> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().release(this.iterationFinishedEvent);
        }
        this.listeners.clear();
        this.released = true;
    }

    public void remove(T t11) {
        Iterator<ListenerHolder<T>> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            ListenerHolder next = it2.next();
            if (next.listener.equals(t11)) {
                next.release(this.iterationFinishedEvent);
                this.listeners.remove(next);
            }
        }
    }

    public void sendEvent(int i11, Event<T> event) {
        queueEvent(i11, event);
        flushEvents();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this.clock = clock2;
        this.listeners = copyOnWriteArraySet;
        this.iterationFinishedEvent = iterationFinishedEvent2;
        this.flushingEvents = new ArrayDeque<>();
        this.queuedEvents = new ArrayDeque<>();
        this.handler = clock2.createHandler(looper, new a(this));
    }
}

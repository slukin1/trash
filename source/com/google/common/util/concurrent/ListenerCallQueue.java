package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    public interface Event<L> {
        void call(L l11);
    }

    public static final class PerListenerQueue<L> implements Runnable {
        public final Executor executor;
        @GuardedBy("this")
        public boolean isThreadScheduled;
        @GuardedBy("this")
        public final Queue<Object> labelQueue = Queues.newArrayDeque();
        public final L listener;
        @GuardedBy("this")
        public final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        public PerListenerQueue(L l11, Executor executor2) {
            this.listener = Preconditions.checkNotNull(l11);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        public void dispatch() {
            boolean z11;
            synchronized (this) {
                z11 = true;
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                } else {
                    z11 = false;
                }
            }
            if (z11) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e11) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, e11);
                        throw e11;
                    }
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r9 = this;
            L_0x0000:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch:{ all -> 0x0059 }
                boolean r2 = r9.isThreadScheduled     // Catch:{ all -> 0x004c }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x004c }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.waitQueue     // Catch:{ all -> 0x004c }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x004c }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x004c }
                java.util.Queue<java.lang.Object> r3 = r9.labelQueue     // Catch:{ all -> 0x004c }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x004c }
                if (r2 != 0) goto L_0x001f
                r9.isThreadScheduled = r0     // Catch:{ all -> 0x004c }
                monitor-exit(r9)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r1 = move-exception
                r2 = r0
                goto L_0x0050
            L_0x001f:
                monitor-exit(r9)     // Catch:{ all -> 0x004c }
                L r4 = r9.listener     // Catch:{ RuntimeException -> 0x0026 }
                r2.call(r4)     // Catch:{ RuntimeException -> 0x0026 }
                goto L_0x0000
            L_0x0026:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.logger     // Catch:{ all -> 0x0059 }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0059 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
                r6.<init>()     // Catch:{ all -> 0x0059 }
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch:{ all -> 0x0059 }
                L r7 = r9.listener     // Catch:{ all -> 0x0059 }
                r6.append(r7)     // Catch:{ all -> 0x0059 }
                java.lang.String r7 = " "
                r6.append(r7)     // Catch:{ all -> 0x0059 }
                r6.append(r3)     // Catch:{ all -> 0x0059 }
                java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0059 }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x0059 }
                goto L_0x0000
            L_0x004c:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
            L_0x0050:
                monitor-exit(r9)     // Catch:{ all -> 0x0057 }
                throw r1     // Catch:{ all -> 0x0052 }
            L_0x0052:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L_0x005a
            L_0x0057:
                r1 = move-exception
                goto L_0x0050
            L_0x0059:
                r2 = move-exception
            L_0x005a:
                if (r1 == 0) goto L_0x0064
                monitor-enter(r9)
                r9.isThreadScheduled = r0     // Catch:{ all -> 0x0061 }
                monitor-exit(r9)     // Catch:{ all -> 0x0061 }
                goto L_0x0064
            L_0x0061:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0061 }
                throw r0
            L_0x0064:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> add : this.listeners) {
                add.add(event, obj);
            }
        }
    }

    public void addListener(L l11, Executor executor) {
        Preconditions.checkNotNull(l11, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(l11, executor));
    }

    public void dispatch() {
        for (int i11 = 0; i11 < this.listeners.size(); i11++) {
            this.listeners.get(i11).dispatch();
        }
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }
}

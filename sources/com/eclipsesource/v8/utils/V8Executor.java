package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.util.LinkedList;

public class V8Executor extends Thread {
    private Exception exception;
    /* access modifiers changed from: private */
    public volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    public class ExecutorTermination implements JavaVoidCallback {
        public ExecutorTermination() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (V8Executor.this.forceTerminating) {
                throw new RuntimeException("V8Thread Termination");
            }
        }
    }

    public V8Executor(String str, boolean z11, String str2) {
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList<>();
        this.script = str;
        this.longRunning = z11;
        this.messageHandler = str2;
    }

    public void forceTermination() {
        synchronized (this) {
            this.forceTerminating = true;
            this.shuttingDown = true;
            V8 v82 = this.runtime;
            if (v82 != null) {
                v82.terminateExecution();
            }
            notify();
        }
    }

    public Exception getException() {
        return this.exception;
    }

    public String getResult() {
        return this.result;
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }

    public void postMessage(String... strArr) {
        synchronized (this) {
            this.messageQueue.add(strArr);
            notify();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        if (r8.runtime.getLocker().hasLock() == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        r8.runtime.close();
        r8.runtime = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        r8.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0097, code lost:
        if (r8.messageQueue.isEmpty() != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0099, code lost:
        r3 = 0;
        r2 = r8.messageQueue.remove(0);
        r4 = new com.eclipsesource.v8.V8Array(r8.runtime);
        r5 = new com.eclipsesource.v8.V8Array(r8.runtime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r6 = r2.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b1, code lost:
        if (r3 >= r6) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b3, code lost:
        r5.push(r2[r3]);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bb, code lost:
        r4.push((com.eclipsesource.v8.V8Value) r5);
        r8.runtime.executeVoidFunction(r8.messageHandler, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.close();
        r4.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.eclipsesource.v8.V8 r0 = com.eclipsesource.v8.V8.createV8Runtime()     // Catch:{ all -> 0x012d }
            r8.runtime = r0     // Catch:{ all -> 0x012d }
            com.eclipsesource.v8.utils.V8Executor$ExecutorTermination r1 = new com.eclipsesource.v8.utils.V8Executor$ExecutorTermination     // Catch:{ all -> 0x012d }
            r1.<init>()     // Catch:{ all -> 0x012d }
            java.lang.String r2 = "__j2v8__checkThreadTerminate"
            r0.registerJavaMethod((com.eclipsesource.v8.JavaVoidCallback) r1, (java.lang.String) r2)     // Catch:{ all -> 0x012d }
            com.eclipsesource.v8.V8 r0 = r8.runtime     // Catch:{ all -> 0x012d }
            r8.setup(r0)     // Catch:{ all -> 0x012d }
            monitor-exit(r8)     // Catch:{ all -> 0x012d }
            r0 = 0
            r1 = 1
            boolean r2 = r8.forceTerminating     // Catch:{ Exception -> 0x00f4 }
            if (r2 != 0) goto L_0x004c
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ Exception -> 0x00f4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f4 }
            r3.<init>()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r4 = "__j2v8__checkThreadTerminate();\n"
            r3.append(r4)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r4 = r8.script     // Catch:{ Exception -> 0x00f4 }
            r3.append(r4)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r4 = r8.getName()     // Catch:{ Exception -> 0x00f4 }
            r5 = -1
            java.lang.Object r2 = r2.executeScript(r3, r4, r5)     // Catch:{ Exception -> 0x00f4 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x00f4 }
            r8.result = r3     // Catch:{ Exception -> 0x00f4 }
        L_0x0043:
            boolean r3 = r2 instanceof com.eclipsesource.v8.Releasable     // Catch:{ Exception -> 0x00f4 }
            if (r3 == 0) goto L_0x004c
            com.eclipsesource.v8.Releasable r2 = (com.eclipsesource.v8.Releasable) r2     // Catch:{ Exception -> 0x00f4 }
            r2.release()     // Catch:{ Exception -> 0x00f4 }
        L_0x004c:
            boolean r2 = r8.forceTerminating     // Catch:{ Exception -> 0x00f4 }
            if (r2 != 0) goto L_0x00d7
            boolean r2 = r8.longRunning     // Catch:{ Exception -> 0x00f4 }
            if (r2 == 0) goto L_0x00d7
            monitor-enter(r8)     // Catch:{ Exception -> 0x00f4 }
            java.util.LinkedList<java.lang.String[]> r2 = r8.messageQueue     // Catch:{ all -> 0x00d4 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x0064
            boolean r2 = r8.shuttingDown     // Catch:{ all -> 0x00d4 }
            if (r2 != 0) goto L_0x0064
            r8.wait()     // Catch:{ all -> 0x00d4 }
        L_0x0064:
            java.util.LinkedList<java.lang.String[]> r2 = r8.messageQueue     // Catch:{ all -> 0x00d4 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x0070
            boolean r2 = r8.shuttingDown     // Catch:{ all -> 0x00d4 }
            if (r2 != 0) goto L_0x0074
        L_0x0070:
            boolean r2 = r8.forceTerminating     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x0090
        L_0x0074:
            monitor-exit(r8)     // Catch:{ all -> 0x00d4 }
            monitor-enter(r8)
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x008d }
            com.eclipsesource.v8.V8Locker r2 = r2.getLocker()     // Catch:{ all -> 0x008d }
            boolean r2 = r2.hasLock()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0089
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x008d }
            r2.close()     // Catch:{ all -> 0x008d }
            r8.runtime = r0     // Catch:{ all -> 0x008d }
        L_0x0089:
            r8.terminated = r1     // Catch:{ all -> 0x008d }
            monitor-exit(r8)     // Catch:{ all -> 0x008d }
            return
        L_0x008d:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x008d }
            throw r0
        L_0x0090:
            monitor-exit(r8)     // Catch:{ all -> 0x00d4 }
            java.util.LinkedList<java.lang.String[]> r2 = r8.messageQueue     // Catch:{ Exception -> 0x00f4 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x00f4 }
            if (r2 != 0) goto L_0x004c
            java.util.LinkedList<java.lang.String[]> r2 = r8.messageQueue     // Catch:{ Exception -> 0x00f4 }
            r3 = 0
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String[] r2 = (java.lang.String[]) r2     // Catch:{ Exception -> 0x00f4 }
            com.eclipsesource.v8.V8Array r4 = new com.eclipsesource.v8.V8Array     // Catch:{ Exception -> 0x00f4 }
            com.eclipsesource.v8.V8 r5 = r8.runtime     // Catch:{ Exception -> 0x00f4 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00f4 }
            com.eclipsesource.v8.V8Array r5 = new com.eclipsesource.v8.V8Array     // Catch:{ Exception -> 0x00f4 }
            com.eclipsesource.v8.V8 r6 = r8.runtime     // Catch:{ Exception -> 0x00f4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00f4 }
            int r6 = r2.length     // Catch:{ all -> 0x00cc }
        L_0x00b1:
            if (r3 >= r6) goto L_0x00bb
            r7 = r2[r3]     // Catch:{ all -> 0x00cc }
            r5.push((java.lang.String) r7)     // Catch:{ all -> 0x00cc }
            int r3 = r3 + 1
            goto L_0x00b1
        L_0x00bb:
            r4.push((com.eclipsesource.v8.V8Value) r5)     // Catch:{ all -> 0x00cc }
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r8.messageHandler     // Catch:{ all -> 0x00cc }
            r2.executeVoidFunction(r3, r4)     // Catch:{ all -> 0x00cc }
            r5.close()     // Catch:{ Exception -> 0x00f4 }
            r4.close()     // Catch:{ Exception -> 0x00f4 }
            goto L_0x004c
        L_0x00cc:
            r2 = move-exception
            r5.close()     // Catch:{ Exception -> 0x00f4 }
            r4.close()     // Catch:{ Exception -> 0x00f4 }
            throw r2     // Catch:{ Exception -> 0x00f4 }
        L_0x00d4:
            r2 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00d4 }
            throw r2     // Catch:{ Exception -> 0x00f4 }
        L_0x00d7:
            monitor-enter(r8)
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x00ef }
            com.eclipsesource.v8.V8Locker r2 = r2.getLocker()     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.hasLock()     // Catch:{ all -> 0x00ef }
            if (r2 == 0) goto L_0x00eb
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x00ef }
            r2.close()     // Catch:{ all -> 0x00ef }
            r8.runtime = r0     // Catch:{ all -> 0x00ef }
        L_0x00eb:
            r8.terminated = r1     // Catch:{ all -> 0x00ef }
            monitor-exit(r8)     // Catch:{ all -> 0x00ef }
            goto L_0x010e
        L_0x00ef:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00ef }
            throw r0
        L_0x00f2:
            r2 = move-exception
            goto L_0x0112
        L_0x00f4:
            r2 = move-exception
            r8.exception = r2     // Catch:{ all -> 0x00f2 }
            monitor-enter(r8)
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x010f }
            com.eclipsesource.v8.V8Locker r2 = r2.getLocker()     // Catch:{ all -> 0x010f }
            boolean r2 = r2.hasLock()     // Catch:{ all -> 0x010f }
            if (r2 == 0) goto L_0x010b
            com.eclipsesource.v8.V8 r2 = r8.runtime     // Catch:{ all -> 0x010f }
            r2.close()     // Catch:{ all -> 0x010f }
            r8.runtime = r0     // Catch:{ all -> 0x010f }
        L_0x010b:
            r8.terminated = r1     // Catch:{ all -> 0x010f }
            monitor-exit(r8)     // Catch:{ all -> 0x010f }
        L_0x010e:
            return
        L_0x010f:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x010f }
            throw r0
        L_0x0112:
            monitor-enter(r8)
            com.eclipsesource.v8.V8 r3 = r8.runtime     // Catch:{ all -> 0x012a }
            com.eclipsesource.v8.V8Locker r3 = r3.getLocker()     // Catch:{ all -> 0x012a }
            boolean r3 = r3.hasLock()     // Catch:{ all -> 0x012a }
            if (r3 == 0) goto L_0x0126
            com.eclipsesource.v8.V8 r3 = r8.runtime     // Catch:{ all -> 0x012a }
            r3.close()     // Catch:{ all -> 0x012a }
            r8.runtime = r0     // Catch:{ all -> 0x012a }
        L_0x0126:
            r8.terminated = r1     // Catch:{ all -> 0x012a }
            monitor-exit(r8)     // Catch:{ all -> 0x012a }
            throw r2
        L_0x012a:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x012a }
            throw r0
        L_0x012d:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x012d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8Executor.run():void");
    }

    public void setup(V8 v82) {
    }

    public void shutdown() {
        synchronized (this) {
            this.shuttingDown = true;
            notify();
        }
    }

    public V8Executor(String str) {
        this(str, false, (String) null);
    }
}

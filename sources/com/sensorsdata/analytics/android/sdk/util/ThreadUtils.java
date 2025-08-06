package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadUtils {
    private static final String TAG = "SA.ThreadUtils";
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final byte TYPE_SINGLE = -1;

    public static final class LinkedBlockingQueueUtil extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = Integer.MAX_VALUE;
        /* access modifiers changed from: private */
        public volatile ThreadPoolExecutorUtil mPool;

        public LinkedBlockingQueueUtil() {
        }

        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueueUtil(boolean z11) {
            if (z11) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueueUtil(int i11) {
            this.mCapacity = i11;
        }
    }

    public static final class ThreadPoolExecutorUtil extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount = new AtomicInteger();
        private LinkedBlockingQueueUtil mWorkQueue;

        public ThreadPoolExecutorUtil(int i11, int i12, long j11, TimeUnit timeUnit, LinkedBlockingQueueUtil linkedBlockingQueueUtil, ThreadFactory threadFactory) {
            super(i11, i12, j11, timeUnit, linkedBlockingQueueUtil, threadFactory);
            ThreadPoolExecutorUtil unused = linkedBlockingQueueUtil.mPool = this;
            this.mWorkQueue = linkedBlockingQueueUtil;
        }

        /* access modifiers changed from: private */
        public static ExecutorService createPool(int i11, int i12) {
            int i13 = i11;
            int i14 = i12;
            if (i13 == -1) {
                return new ThreadPoolExecutorUtil(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueueUtil(), new UtilsThreadFactory("single", i14));
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LinkedBlockingQueueUtil linkedBlockingQueueUtil = new LinkedBlockingQueueUtil();
            return new ThreadPoolExecutorUtil(i11, i11, 0, timeUnit, linkedBlockingQueueUtil, new UtilsThreadFactory("fixed(" + i13 + ")", i14));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        public void afterExecute(Runnable runnable, Throwable th2) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th2);
        }

        public void execute(Runnable runnable) {
            if (!isShutdown()) {
                this.mSubmittedCount.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    SALog.i(ThreadUtils.TAG, "This will not happen!");
                    this.mWorkQueue.offer(runnable);
                } catch (Throwable unused2) {
                    this.mSubmittedCount.decrementAndGet();
                }
            }
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public UtilsThreadFactory(String str, int i11) {
            this(str, i11, false);
        }

        public Thread newThread(Runnable runnable) {
            AnonymousClass1 r02 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                        SALog.i("ThreadUtils", "Request threw uncaught throwable");
                    }
                }
            };
            r02.setDaemon(this.isDaemon);
            r02.setPriority(this.priority);
            return r02;
        }

        public UtilsThreadFactory(String str, int i11, boolean z11) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i11;
            this.isDaemon = z11;
        }
    }

    private static ExecutorService getPoolByTypeAndPriority(int i11) {
        return getPoolByTypeAndPriority(i11, 5);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i11, int i12) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            Map map2 = map.get(Integer.valueOf(i11));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = ThreadPoolExecutorUtil.createPool(i11, i12);
                concurrentHashMap.put(Integer.valueOf(i12), executorService);
                map.put(Integer.valueOf(i11), concurrentHashMap);
            } else {
                executorService = (ExecutorService) map2.get(Integer.valueOf(i12));
                if (executorService == null) {
                    executorService = ThreadPoolExecutorUtil.createPool(i11, i12);
                    map2.put(Integer.valueOf(i12), executorService);
                }
            }
        }
        return executorService;
    }

    public static ExecutorService getSinglePool(int i11) {
        return getPoolByTypeAndPriority(-1, i11);
    }
}

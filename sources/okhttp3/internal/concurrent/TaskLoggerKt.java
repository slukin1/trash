package okhttp3.internal.concurrent;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import d10.a;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.d0;

public final class TaskLoggerKt {
    public static final String formatDuration(long j11) {
        String str;
        if (j11 <= -999500000) {
            str = ((j11 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j11 <= -999500) {
            str = ((j11 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j11 <= 0) {
            str = ((j11 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j11 < 999500) {
            str = ((j11 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j11 < 999500000) {
            str = ((j11 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j11 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        d0 d0Var = d0.f56774a;
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(taskQueue.getName$okhttp());
        sb2.append(' ');
        d0 d0Var = d0.f56774a;
        sb2.append(String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)));
        sb2.append(l.f34627b);
        sb2.append(task.getName());
        logger.fine(sb2.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, a<? extends T> aVar) {
        long j11;
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j11 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j11 = -1;
        }
        try {
            T invoke = aVar.invoke();
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j11));
            }
            InlineMarker.a(1);
            return invoke;
        } catch (Throwable th2) {
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j11));
            }
            InlineMarker.a(1);
            throw th2;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, a<String> aVar) {
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, aVar.invoke());
        }
    }
}

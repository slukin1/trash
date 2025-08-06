package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static void decrementAll(List<DeferrableSurface> list) {
        for (DeferrableSurface decrementUseCount : list) {
            decrementUseCount.decrementUseCount();
        }
    }

    public static void incrementAll(List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i11 = 0;
            do {
                try {
                    list.get(i11).incrementUseCount();
                    i11++;
                } catch (DeferrableSurface.SurfaceClosedException e11) {
                    for (int i12 = i11 - 1; i12 >= 0; i12--) {
                        list.get(i12).decrementUseCount();
                    }
                    throw e11;
                }
            } while (i11 < list.size());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.a aVar, long j11) {
        if (!listenableFuture.isDone()) {
            aVar.f(new TimeoutException("Cannot complete surfaceList within " + j11));
            listenableFuture.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$surfaceListWithTimeout$3(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j11, final boolean z11, final CallbackToFutureAdapter.a aVar) throws Exception {
        ListenableFuture successfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new w(executor, successfulAsList, aVar, j11), j11, TimeUnit.MILLISECONDS);
        aVar.a(new u(successfulAsList), executor);
        Futures.addCallback(successfulAsList, new FutureCallback<List<Surface>>() {
            public void onFailure(Throwable th2) {
                aVar.c(Collections.unmodifiableList(Collections.emptyList()));
                schedule.cancel(true);
            }

            public void onSuccess(List<Surface> list) {
                ArrayList arrayList = new ArrayList(list);
                if (z11) {
                    arrayList.removeAll(Collections.singleton((Object) null));
                }
                aVar.c(arrayList);
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(Collection<DeferrableSurface> collection, boolean z11, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface surface : collection) {
            arrayList.add(Futures.nonCancellationPropagating(surface.getSurface()));
        }
        return CallbackToFutureAdapter.a(new t(arrayList, scheduledExecutorService, executor, j11, z11));
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }
}

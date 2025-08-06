package okhttp3.internal.cache;

import e10.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;

public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, a {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    public final /* synthetic */ DiskLruCache this$0;

    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        this.delegate = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
    }

    public boolean hasNext() {
        if (this.nextSnapshot != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (diskLruCache.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                if (next != null) {
                    DiskLruCache.Snapshot snapshot$okhttp = next.snapshot$okhttp();
                    if (snapshot$okhttp != null) {
                        this.nextSnapshot = snapshot$okhttp;
                        return true;
                    }
                }
            }
            Unit unit = Unit.f56620a;
            return false;
        }
    }

    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot != null) {
            try {
                this.this$0.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.removeSnapshot = null;
                throw th2;
            }
            this.removeSnapshot = null;
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }

    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            return snapshot;
        }
        throw new NoSuchElementException();
    }
}

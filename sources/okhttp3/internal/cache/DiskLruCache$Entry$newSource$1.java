package okhttp3.internal.cache;

import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;

public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    private boolean closed;
    public final /* synthetic */ DiskLruCache this$0;
    public final /* synthetic */ DiskLruCache.Entry this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Entry$newSource$1(Source source, DiskLruCache diskLruCache, DiskLruCache.Entry entry) {
        super(source);
        this.this$0 = diskLruCache;
        this.this$1 = entry;
    }

    public void close() {
        super.close();
        if (!this.closed) {
            this.closed = true;
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache.Entry entry = this.this$1;
            synchronized (diskLruCache) {
                entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                    diskLruCache.removeEntry$okhttp(entry);
                }
                Unit unit = Unit.f56620a;
            }
        }
    }
}

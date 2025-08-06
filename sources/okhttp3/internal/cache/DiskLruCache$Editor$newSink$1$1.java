package okhttp3.internal.cache;

import d10.l;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;

public final class DiskLruCache$Editor$newSink$1$1 extends Lambda implements l<IOException, Unit> {
    public final /* synthetic */ DiskLruCache this$0;
    public final /* synthetic */ DiskLruCache.Editor this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$1$1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.this$0 = diskLruCache;
        this.this$1 = editor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.f56620a;
    }

    public final void invoke(IOException iOException) {
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
            Unit unit = Unit.f56620a;
        }
    }
}

package okio.internal;

import d10.p;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSource;

public final class ZipFilesKt$readOrSkipLocalHeader$1 extends Lambda implements p<Integer, Long, Unit> {
    public final /* synthetic */ Ref$ObjectRef<Long> $createdAtMillis;
    public final /* synthetic */ Ref$ObjectRef<Long> $lastAccessedAtMillis;
    public final /* synthetic */ Ref$ObjectRef<Long> $lastModifiedAtMillis;
    public final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZipFilesKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref$ObjectRef<Long> ref$ObjectRef, Ref$ObjectRef<Long> ref$ObjectRef2, Ref$ObjectRef<Long> ref$ObjectRef3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = ref$ObjectRef;
        this.$lastAccessedAtMillis = ref$ObjectRef2;
        this.$createdAtMillis = ref$ObjectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, long j11) {
        if (i11 == 21589) {
            long j12 = 1;
            if (j11 >= 1) {
                byte readByte = this.$this_readOrSkipLocalHeader.readByte() & 255;
                boolean z11 = false;
                boolean z12 = (readByte & 1) == 1;
                boolean z13 = (readByte & 2) == 2;
                if ((readByte & 4) == 4) {
                    z11 = true;
                }
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                if (z12) {
                    j12 = 5;
                }
                if (z13) {
                    j12 += 4;
                }
                if (z11) {
                    j12 += 4;
                }
                if (j11 >= j12) {
                    if (z12) {
                        this.$lastModifiedAtMillis.element = Long.valueOf(((long) bufferedSource.readIntLe()) * 1000);
                    }
                    if (z13) {
                        this.$lastAccessedAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                    }
                    if (z11) {
                        this.$createdAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                        return;
                    }
                    return;
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            throw new IOException("bad zip: extended timestamp extra too short");
        }
    }
}

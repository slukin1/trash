package okio.internal;

import d10.p;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import okio.BufferedSource;

public final class ZipFilesKt$readEntry$1 extends Lambda implements p<Integer, Long, Unit> {
    public final /* synthetic */ Ref$LongRef $compressedSize;
    public final /* synthetic */ Ref$BooleanRef $hasZip64Extra;
    public final /* synthetic */ Ref$LongRef $offset;
    public final /* synthetic */ long $requiredZip64ExtraSize;
    public final /* synthetic */ Ref$LongRef $size;
    public final /* synthetic */ BufferedSource $this_readEntry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZipFilesKt$readEntry$1(Ref$BooleanRef ref$BooleanRef, long j11, Ref$LongRef ref$LongRef, BufferedSource bufferedSource, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3) {
        super(2);
        this.$hasZip64Extra = ref$BooleanRef;
        this.$requiredZip64ExtraSize = j11;
        this.$size = ref$LongRef;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = ref$LongRef2;
        this.$offset = ref$LongRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, long j11) {
        if (i11 == 1) {
            Ref$BooleanRef ref$BooleanRef = this.$hasZip64Extra;
            if (!ref$BooleanRef.element) {
                ref$BooleanRef.element = true;
                if (j11 >= this.$requiredZip64ExtraSize) {
                    Ref$LongRef ref$LongRef = this.$size;
                    long j12 = ref$LongRef.element;
                    if (j12 == 4294967295L) {
                        j12 = this.$this_readEntry.readLongLe();
                    }
                    ref$LongRef.element = j12;
                    Ref$LongRef ref$LongRef2 = this.$compressedSize;
                    long j13 = 0;
                    ref$LongRef2.element = ref$LongRef2.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0;
                    Ref$LongRef ref$LongRef3 = this.$offset;
                    if (ref$LongRef3.element == 4294967295L) {
                        j13 = this.$this_readEntry.readLongLe();
                    }
                    ref$LongRef3.element = j13;
                    return;
                }
                throw new IOException("bad zip: zip64 extra too short");
            }
            throw new IOException("bad zip: zip64 extra repeated");
        }
    }
}

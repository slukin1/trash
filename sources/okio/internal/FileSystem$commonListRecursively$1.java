package okio.internal;

import d10.p;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

@d(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {96}, m = "invokeSuspend")
/* renamed from: okio.internal.-FileSystem$commonListRecursively$1  reason: invalid class name */
public final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super Path>, c<? super Unit>, Object> {
    public final /* synthetic */ Path $dir;
    public final /* synthetic */ boolean $followSymlinks;
    public final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystem$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z11, c<? super FileSystem$commonListRecursively$1> cVar) {
        super(2, cVar);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z11;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FileSystem$commonListRecursively$1 r02 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, cVar);
        r02.L$0 = obj;
        return r02;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, c<? super Unit> cVar) {
        return ((FileSystem$commonListRecursively$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        ArrayDeque arrayDeque;
        FileSystem$commonListRecursively$1 r11;
        SequenceScope sequenceScope;
        Iterator<Path> it2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.addLast(this.$dir);
            r11 = this;
            sequenceScope = (SequenceScope) this.L$0;
            arrayDeque = arrayDeque2;
            it2 = this.$this_commonListRecursively.list(this.$dir).iterator();
        } else if (i11 == 1) {
            it2 = (Iterator) this.L$2;
            k.b(obj);
            r11 = this;
            arrayDeque = (ArrayDeque) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it2.hasNext()) {
            FileSystem fileSystem = r11.$this_commonListRecursively;
            boolean z11 = r11.$followSymlinks;
            r11.L$0 = sequenceScope;
            r11.L$1 = arrayDeque;
            r11.L$2 = it2;
            r11.label = 1;
            if (FileSystem.collectRecursively(sequenceScope, fileSystem, arrayDeque, it2.next(), z11, false, r11) == d11) {
                return d11;
            }
        }
        return Unit.f56620a;
    }
}

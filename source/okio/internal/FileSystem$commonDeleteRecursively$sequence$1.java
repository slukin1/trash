package okio.internal;

import d10.p;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

@d(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", l = {75}, m = "invokeSuspend")
/* renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1  reason: invalid class name */
public final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super Path>, c<? super Unit>, Object> {
    public final /* synthetic */ Path $fileOrDirectory;
    public final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, c<? super FileSystem$commonDeleteRecursively$sequence$1> cVar) {
        super(2, cVar);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FileSystem$commonDeleteRecursively$sequence$1 r02 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, cVar);
        r02.L$0 = obj;
        return r02;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, c<? super Unit> cVar) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            ArrayDeque arrayDeque = new ArrayDeque();
            Path path = this.$fileOrDirectory;
            this.label = 1;
            if (FileSystem.collectRecursively((SequenceScope) this.L$0, fileSystem, arrayDeque, path, false, true, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}

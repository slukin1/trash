package okio.internal;

import kotlin.collections.ArrayDeque;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

@d(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {116, 135, 145}, m = "collectRecursively")
/* renamed from: okio.internal.-FileSystem$collectRecursively$1  reason: invalid class name */
public final class FileSystem$collectRecursively$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public boolean Z$0;
    public boolean Z$1;
    public int label;
    public /* synthetic */ Object result;

    public FileSystem$collectRecursively$1(c<? super FileSystem$collectRecursively$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileSystem.collectRecursively((SequenceScope<? super Path>) null, (FileSystem) null, (ArrayDeque<Path>) null, (Path) null, false, false, this);
    }
}

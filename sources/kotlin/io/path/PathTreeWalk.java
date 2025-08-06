package kotlin.io.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.sequences.g;

public final class PathTreeWalk implements g<Path> {

    /* renamed from: a  reason: collision with root package name */
    public final Path f56734a;

    /* renamed from: b  reason: collision with root package name */
    public final PathWalkOption[] f56735b;

    public final Iterator<Path> f() {
        return SequencesKt__SequenceBuilderKt.a(new PathTreeWalk$bfsIterator$1(this, (c<? super PathTreeWalk$bfsIterator$1>) null));
    }

    public final Iterator<Path> g() {
        return SequencesKt__SequenceBuilderKt.a(new PathTreeWalk$dfsIterator$1(this, (c<? super PathTreeWalk$dfsIterator$1>) null));
    }

    public final boolean h() {
        return ArraysKt___ArraysKt.C(this.f56735b, PathWalkOption.FOLLOW_LINKS);
    }

    public final boolean i() {
        return ArraysKt___ArraysKt.C(this.f56735b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    public Iterator<Path> iterator() {
        return k() ? f() : g();
    }

    public final LinkOption[] j() {
        return e.f56742a.a(h());
    }

    public final boolean k() {
        return ArraysKt___ArraysKt.C(this.f56735b, PathWalkOption.BREADTH_FIRST);
    }
}

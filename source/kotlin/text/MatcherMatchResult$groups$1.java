package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.ranges.h;

public final class MatcherMatchResult$groups$1 extends AbstractCollection<e> implements f {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f56904b;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f56904b = matcherMatchResult;
    }

    public /* bridge */ boolean a(e eVar) {
        return super.contains(eVar);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof e)) {
            return false;
        }
        return a((e) obj);
    }

    public e get(int i11) {
        h d11 = h.i(this.f56904b.e(), i11);
        if (d11.j().intValue() >= 0) {
            return new e(this.f56904b.e().group(i11), d11);
        }
        return null;
    }

    public int getSize() {
        return this.f56904b.e().groupCount() + 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<e> iterator() {
        return SequencesKt___SequencesKt.s(CollectionsKt___CollectionsKt.P(CollectionsKt__CollectionsKt.l(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}

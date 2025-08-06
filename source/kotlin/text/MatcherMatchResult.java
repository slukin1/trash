package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.ranges.h;

public final class MatcherMatchResult implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Matcher f56899a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f56900b;

    /* renamed from: c  reason: collision with root package name */
    public final f f56901c = new MatcherMatchResult$groups$1(this);

    /* renamed from: d  reason: collision with root package name */
    public List<String> f56902d;

    public static final class a extends kotlin.collections.a<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MatcherMatchResult f56903b;

        public a(MatcherMatchResult matcherMatchResult) {
            this.f56903b = matcherMatchResult;
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ int b(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int c(String str) {
            return super.lastIndexOf(str);
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return a((String) obj);
        }

        public int getSize() {
            return this.f56903b.e().groupCount() + 1;
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return b((String) obj);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return c((String) obj);
        }

        public String get(int i11) {
            String group = this.f56903b.e().group(i11);
            return group == null ? "" : group;
        }
    }

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        this.f56899a = matcher;
        this.f56900b = charSequence;
    }

    public f a() {
        return this.f56901c;
    }

    public List<String> b() {
        if (this.f56902d == null) {
            this.f56902d = new a(this);
        }
        return this.f56902d;
    }

    public h c() {
        return h.h(e());
    }

    public final MatchResult e() {
        return this.f56899a;
    }

    public g next() {
        int end = e().end() + (e().end() == e().start() ? 1 : 0);
        if (end <= this.f56900b.length()) {
            return h.f(this.f56899a.pattern().matcher(this.f56900b), end, this.f56900b);
        }
        return null;
    }
}

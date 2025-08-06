package kotlin.text;

import d10.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.sequences.g;

public final class Regex implements Serializable {
    public static final a Companion = new a((r) null);
    private Set<? extends RegexOption> _options;
    /* access modifiers changed from: private */
    public final Pattern nativePattern;

    public static final class Serialized implements Serializable {
        public static final a Companion = new a((r) null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public Serialized(String str, int i11) {
            this.pattern = str;
            this.flags = i11;
        }

        private final Object readResolve() {
            return new Regex(Pattern.compile(this.pattern, this.flags));
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final int b(int i11) {
            return (i11 & 2) != 0 ? i11 | 64 : i11;
        }
    }

    public Regex(Pattern pattern) {
        this.nativePattern = pattern;
    }

    public static /* synthetic */ g find$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.find(charSequence, i11);
    }

    public static /* synthetic */ g findAll$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.findAll(charSequence, i11);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.split(charSequence, i11);
    }

    public static /* synthetic */ g splitToSequence$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.splitToSequence(charSequence, i11);
    }

    private final Object writeReplace() {
        return new Serialized(this.nativePattern.pattern(), this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).find();
    }

    public final g find(CharSequence charSequence, int i11) {
        return h.f(this.nativePattern.matcher(charSequence), i11, charSequence);
    }

    public final g<g> findAll(CharSequence charSequence, int i11) {
        if (i11 >= 0 && i11 <= charSequence.length()) {
            return SequencesKt__SequencesKt.f(new Regex$findAll$1(this, charSequence, i11), Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i11 + ", input length: " + charSequence.length());
    }

    public final Set<RegexOption> getOptions() {
        Set<? extends RegexOption> set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet<E> allOf = EnumSet.allOf(RegexOption.class);
        boolean unused = CollectionsKt__MutableCollectionsKt.J(allOf, new Regex$special$$inlined$fromInt$1(flags));
        Set<? extends RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        return this.nativePattern.pattern();
    }

    public final g matchAt(CharSequence charSequence, int i11) {
        Matcher region = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i11, charSequence.length());
        if (region.lookingAt()) {
            return new MatcherMatchResult(region, charSequence);
        }
        return null;
    }

    public final g matchEntire(CharSequence charSequence) {
        return h.g(this.nativePattern.matcher(charSequence), charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean matchesAt(CharSequence charSequence, int i11) {
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i11, charSequence.length()).lookingAt();
    }

    public final String replace(CharSequence charSequence, String str) {
        return this.nativePattern.matcher(charSequence).replaceAll(str);
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        return this.nativePattern.matcher(charSequence).replaceFirst(str);
    }

    public final List<String> split(CharSequence charSequence, int i11) {
        StringsKt__StringsKt.G0(i11);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i11 == 1 || !matcher.find()) {
            return CollectionsKt__CollectionsJVMKt.e(charSequence.toString());
        }
        int i12 = 10;
        if (i11 > 0) {
            i12 = RangesKt___RangesKt.g(i11, 10);
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int i14 = i11 - 1;
        do {
            arrayList.add(charSequence.subSequence(i13, matcher.start()).toString());
            i13 = matcher.end();
            if ((i14 >= 0 && arrayList.size() == i14) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i13, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i13, matcher.start()).toString());
            i13 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i13, charSequence.length()).toString());
        return arrayList;
    }

    public final g<String> splitToSequence(CharSequence charSequence, int i11) {
        StringsKt__StringsKt.G0(i11);
        return SequencesKt__SequenceBuilderKt.b(new Regex$splitToSequence$1(this, charSequence, i11, (c<? super Regex$splitToSequence$1>) null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        return this.nativePattern.toString();
    }

    public final String replace(CharSequence charSequence, l<? super g, ? extends CharSequence> lVar) {
        int i11 = 0;
        g find$default = find$default(this, charSequence, 0, 2, (Object) null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(charSequence, i11, find$default.c().j().intValue());
            sb2.append((CharSequence) lVar.invoke(find$default));
            i11 = find$default.c().i().intValue() + 1;
            find$default = find$default.next();
            if (i11 >= length) {
                break;
            }
        } while (find$default != null);
        if (i11 < length) {
            sb2.append(charSequence, i11, length);
        }
        return sb2.toString();
    }

    public Regex(String str) {
        this(Pattern.compile(str));
    }

    public Regex(String str, RegexOption regexOption) {
        this(Pattern.compile(str, Companion.b(regexOption.getValue())));
    }

    public Regex(String str, Set<? extends RegexOption> set) {
        this(Pattern.compile(str, Companion.b(h.j(set))));
    }
}

package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public final class h {
    public static final g f(Matcher matcher, int i11, CharSequence charSequence) {
        if (!matcher.find(i11)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final g g(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final kotlin.ranges.h h(MatchResult matchResult) {
        return RangesKt___RangesKt.o(matchResult.start(), matchResult.end());
    }

    public static final kotlin.ranges.h i(MatchResult matchResult, int i11) {
        return RangesKt___RangesKt.o(matchResult.start(i11), matchResult.end(i11));
    }

    public static final int j(Iterable<? extends d> iterable) {
        int i11 = 0;
        for (d value : iterable) {
            i11 |= value.getValue();
        }
        return i11;
    }
}

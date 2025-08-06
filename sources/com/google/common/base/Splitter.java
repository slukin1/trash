package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Splitter {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final boolean omitEmptyStrings;
    private final Strategy strategy;
    /* access modifiers changed from: private */
    public final CharMatcher trimmer;

    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next : this.outerSplitter.split(charSequence)) {
                Iterator access$000 = this.entrySplitter.splittingIterator(next);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
                String str = (String) access$000.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str), "Duplicate key [%s] found.", (Object) str);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
                linkedHashMap.put(str, (String) access$000.next());
                Preconditions.checkArgument(!access$000.hasNext(), INVALID_ENTRY_MESSAGE, (Object) next);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }
    }

    public static abstract class SplittingIterator extends AbstractIterator<String> {
        public int limit;
        public int offset = 0;
        public final boolean omitEmptyStrings;
        public final CharSequence toSplit;
        public final CharMatcher trimmer;

        public SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        public abstract int separatorEnd(int i11);

        public abstract int separatorStart(int i11);

        public String computeNext() {
            int i11;
            int i12 = this.offset;
            while (true) {
                int i13 = this.offset;
                if (i13 == -1) {
                    return (String) endOfData();
                }
                int separatorStart = separatorStart(i13);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                int i14 = this.offset;
                if (i14 == i12) {
                    int i15 = i14 + 1;
                    this.offset = i15;
                    if (i15 > this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i12 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i12))) {
                        i12++;
                    }
                    while (i11 > i12 && this.trimmer.matches(this.toSplit.charAt(i11 - 1))) {
                        separatorStart = i11 - 1;
                    }
                    if (!this.omitEmptyStrings || i12 != i11) {
                        int i16 = this.limit;
                    } else {
                        i12 = this.offset;
                    }
                }
            }
            int i162 = this.limit;
            if (i162 == 1) {
                i11 = this.toSplit.length();
                this.offset = -1;
                while (i11 > i12 && this.trimmer.matches(this.toSplit.charAt(i11 - 1))) {
                    i11--;
                }
            } else {
                this.limit = i162 - 1;
            }
            return this.toSplit.subSequence(i12, i11).toString();
        }
    }

    public interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy2) {
        this(strategy2, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    public static Splitter fixedLength(final int i11) {
        Preconditions.checkArgument(i11 > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i11) {
                        return i11;
                    }

                    public int separatorStart(int i11) {
                        int i12 = i11 + i11;
                        if (i12 < this.toSplit.length()) {
                            return i12;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public static Splitter on(char c11) {
        return on(CharMatcher.is(c11));
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    /* access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    public Splitter limit(int i11) {
        Preconditions.checkArgument(i11 > 0, "must be greater than zero: %s", i11);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i11);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                Joiner on2 = Joiner.on(", ");
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                StringBuilder appendTo = on2.appendTo(sb2, (Iterable<?>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    private Splitter(Strategy strategy2, boolean z11, CharMatcher charMatcher, int i11) {
        this.strategy = strategy2;
        this.omitEmptyStrings = z11;
        this.trimmer = charMatcher;
        this.limit = i11;
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i11) {
                        return i11 + 1;
                    }

                    public int separatorStart(int i11) {
                        return charMatcher.indexIn(this.toSplit, i11);
                    }
                };
            }
        });
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c11) {
        return withKeyValueSeparator(on(c11));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i11) {
                        return i11 + str.length();
                    }

                    public int separatorStart(int i11) {
                        int length = str.length();
                        int length2 = this.toSplit.length() - length;
                        while (i11 <= length2) {
                            int i12 = 0;
                            while (i12 < length) {
                                if (this.toSplit.charAt(i12 + i11) != str.charAt(i12)) {
                                    i11++;
                                } else {
                                    i12++;
                                }
                            }
                            return i11;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return on((CommonPattern) new JdkPattern(pattern));
    }

    private static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", (Object) commonPattern);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = commonPattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(int i11) {
                        return matcher.end();
                    }

                    public int separatorStart(int i11) {
                        if (matcher.find(i11)) {
                            return matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }
}

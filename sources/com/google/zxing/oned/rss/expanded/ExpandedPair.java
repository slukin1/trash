package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.iproov.sdk.bridge.OptionsBridge;

final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;

    public ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern2, boolean z11) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern2;
        this.mayBeLast = z11;
    }

    private static boolean equalsOrNull(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int hashNotNull(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        if (!equalsOrNull(this.leftChar, expandedPair.leftChar) || !equalsOrNull(this.rightChar, expandedPair.rightChar) || !equalsOrNull(this.finderPattern, expandedPair.finderPattern)) {
            return false;
        }
        return true;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public DataCharacter getLeftChar() {
        return this.leftChar;
    }

    public DataCharacter getRightChar() {
        return this.rightChar;
    }

    public int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    public boolean mayBeLast() {
        return this.mayBeLast;
    }

    public boolean mustBeLast() {
        return this.rightChar == null;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("[ ");
        sb2.append(this.leftChar);
        sb2.append(" , ");
        sb2.append(this.rightChar);
        sb2.append(" : ");
        FinderPattern finderPattern2 = this.finderPattern;
        if (finderPattern2 == null) {
            obj = OptionsBridge.NULL_VALUE;
        } else {
            obj = Integer.valueOf(finderPattern2.getValue());
        }
        sb2.append(obj);
        sb2.append(" ]");
        return sb2.toString();
    }
}

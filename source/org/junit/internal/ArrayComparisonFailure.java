package org.junit.internal;

import java.util.ArrayList;
import java.util.List;

public class ArrayComparisonFailure extends AssertionError {
    private static final long serialVersionUID = 1;
    private final List<Integer> fIndices = new ArrayList();
    private final String fMessage;

    public ArrayComparisonFailure(String str, AssertionError assertionError, int i11) {
        this.fMessage = str;
        initCause(assertionError);
        addDimension(i11);
    }

    public void addDimension(int i11) {
        this.fIndices.add(0, Integer.valueOf(i11));
    }

    public String getMessage() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.fMessage;
        if (str != null) {
            sb2.append(str);
        }
        sb2.append("arrays first differed at element ");
        for (Integer intValue : this.fIndices) {
            int intValue2 = intValue.intValue();
            sb2.append("[");
            sb2.append(intValue2);
            sb2.append("]");
        }
        sb2.append("; ");
        sb2.append(getCause().getMessage());
        return sb2.toString();
    }

    public String toString() {
        return getMessage();
    }
}

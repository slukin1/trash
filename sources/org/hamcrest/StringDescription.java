package org.hamcrest;

import java.io.IOException;

public class StringDescription extends BaseDescription {
    private final Appendable out;

    public StringDescription() {
        this(new StringBuilder());
    }

    public static String asString(SelfDescribing selfDescribing) {
        return toString(selfDescribing);
    }

    public static String toString(SelfDescribing selfDescribing) {
        return new StringDescription().appendDescriptionOf(selfDescribing).toString();
    }

    public void append(String str) {
        try {
            this.out.append(str);
        } catch (IOException e11) {
            throw new RuntimeException("Could not write description", e11);
        }
    }

    public StringDescription(Appendable appendable) {
        this.out = appendable;
    }

    public String toString() {
        return this.out.toString();
    }

    public void append(char c11) {
        try {
            this.out.append(c11);
        } catch (IOException e11) {
            throw new RuntimeException("Could not write description", e11);
        }
    }
}

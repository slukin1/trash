package org.hamcrest.text;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualIgnoringWhiteSpace extends TypeSafeMatcher<String> {
    private final String string;

    public IsEqualIgnoringWhiteSpace(String str) {
        if (str != null) {
            this.string = str;
            return;
        }
        throw new IllegalArgumentException("Non-null value required by IsEqualIgnoringCase()");
    }

    @Factory
    public static Matcher<String> equalToIgnoringWhiteSpace(String str) {
        return new IsEqualIgnoringWhiteSpace(str);
    }

    public void describeTo(Description description) {
        description.appendText("equalToIgnoringWhiteSpace(").appendValue(this.string).appendText(")");
    }

    public String stripSpace(String str) {
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isWhitespace(charAt)) {
                if (!z11) {
                    sb2.append(' ');
                }
                z11 = true;
            } else {
                sb2.append(charAt);
                z11 = false;
            }
        }
        return sb2.toString().trim();
    }

    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was  ").appendText(stripSpace(str));
    }

    public boolean matchesSafely(String str) {
        return stripSpace(this.string).equalsIgnoreCase(stripSpace(str));
    }
}

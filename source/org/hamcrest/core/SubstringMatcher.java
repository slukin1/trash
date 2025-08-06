package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public abstract class SubstringMatcher extends TypeSafeMatcher<String> {
    public final String substring;

    public SubstringMatcher(String str) {
        this.substring = str;
    }

    public void describeTo(Description description) {
        description.appendText("a string ").appendText(relationship()).appendText(" ").appendValue(this.substring);
    }

    public abstract boolean evalSubstringOf(String str);

    public abstract String relationship();

    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was \"").appendText(str).appendText("\"");
    }

    public boolean matchesSafely(String str) {
        return evalSubstringOf(str);
    }
}

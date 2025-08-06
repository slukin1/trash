package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringEndsWith extends SubstringMatcher {
    public StringEndsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> endsWith(String str) {
        return new StringEndsWith(str);
    }

    public boolean evalSubstringOf(String str) {
        return str.endsWith(this.substring);
    }

    public String relationship() {
        return "ending with";
    }
}

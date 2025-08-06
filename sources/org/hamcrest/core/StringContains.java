package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringContains extends SubstringMatcher {
    public StringContains(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> containsString(String str) {
        return new StringContains(str);
    }

    public boolean evalSubstringOf(String str) {
        return str.indexOf(this.substring) >= 0;
    }

    public String relationship() {
        return "containing";
    }
}

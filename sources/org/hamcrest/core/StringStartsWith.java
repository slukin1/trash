package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringStartsWith extends SubstringMatcher {
    public StringStartsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> startsWith(String str) {
        return new StringStartsWith(str);
    }

    public boolean evalSubstringOf(String str) {
        return str.startsWith(this.substring);
    }

    public String relationship() {
        return "starting with";
    }
}

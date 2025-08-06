package org.hamcrest;

public class JavaLangMatcherAssert {
    private JavaLangMatcherAssert() {
    }

    public static <T> boolean that(T t11, Matcher<? super T> matcher) {
        return matcher.matches(t11);
    }
}

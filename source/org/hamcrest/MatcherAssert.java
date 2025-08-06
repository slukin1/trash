package org.hamcrest;

public class MatcherAssert {
    public static <T> void assertThat(T t11, Matcher<? super T> matcher) {
        assertThat("", t11, matcher);
    }

    public static <T> void assertThat(String str, T t11, Matcher<? super T> matcher) {
        if (!matcher.matches(t11)) {
            StringDescription stringDescription = new StringDescription();
            stringDescription.appendText(str).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     but: ");
            matcher.describeMismatch(t11, stringDescription);
            throw new AssertionError(stringDescription.toString());
        }
    }

    public static void assertThat(String str, boolean z11) {
        if (!z11) {
            throw new AssertionError(str);
        }
    }
}

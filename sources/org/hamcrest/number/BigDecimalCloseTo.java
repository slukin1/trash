package org.hamcrest.number;

import java.math.BigDecimal;
import java.math.MathContext;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BigDecimalCloseTo extends TypeSafeMatcher<BigDecimal> {
    private final BigDecimal delta;
    private final BigDecimal value;

    public BigDecimalCloseTo(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        this.delta = bigDecimal2;
        this.value = bigDecimal;
    }

    private BigDecimal actualDelta(BigDecimal bigDecimal) {
        return bigDecimal.subtract(this.value, MathContext.DECIMAL128).abs().subtract(this.delta, MathContext.DECIMAL128).stripTrailingZeros();
    }

    @Factory
    public static Matcher<BigDecimal> closeTo(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return new BigDecimalCloseTo(bigDecimal, bigDecimal2);
    }

    public void describeTo(Description description) {
        description.appendText("a numeric value within ").appendValue(this.delta).appendText(" of ").appendValue(this.value);
    }

    public void describeMismatchSafely(BigDecimal bigDecimal, Description description) {
        description.appendValue(bigDecimal).appendText(" differed by ").appendValue(actualDelta(bigDecimal));
    }

    public boolean matchesSafely(BigDecimal bigDecimal) {
        return actualDelta(bigDecimal).compareTo(BigDecimal.ZERO) <= 0;
    }
}

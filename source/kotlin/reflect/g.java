package kotlin.reflect;

import kotlin.f;

public interface g<R> extends b<R>, f<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}

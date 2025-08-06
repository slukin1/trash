package com.sumsub.sns.core.data.listener;

import d10.a;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.c;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.b;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSEvent$Companion$$cachedSerializer$delegate$1 extends Lambda implements a<b<Object>> {
    public static final SNSEvent$Companion$$cachedSerializer$delegate$1 INSTANCE = new SNSEvent$Companion$$cachedSerializer$delegate$1();

    public SNSEvent$Companion$$cachedSerializer$delegate$1() {
        super(0);
    }

    public final b<Object> invoke() {
        return new SealedClassSerializer("com.sumsub.sns.core.data.listener.SNSEvent", Reflection.b(SNSEvent.class), new c[0], new b[0], new Annotation[0]);
    }
}

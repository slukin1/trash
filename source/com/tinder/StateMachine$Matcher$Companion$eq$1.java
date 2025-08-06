package com.tinder;

import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0003\"\n\b\u0003\u0010\u0004 \u0001*\u0002H\u0002\"\b\b\u0004\u0010\u0005*\u00020\u0003\"\b\b\u0005\u0010\u0006*\u00020\u0003\"\b\b\u0006\u0010\u0007*\u00020\u0003*\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "", "R", "STATE", "EVENT", "SIDE_EFFECT", "invoke", "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 1, 13})
public final class StateMachine$Matcher$Companion$eq$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateMachine$Matcher$Companion$eq$1(Object obj) {
        super(1);
        this.$value = obj;
    }

    public final boolean invoke(Object obj) {
        return x.b(obj, this.$value);
    }
}

package com.sumsub.sns.internal.core.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/internal/core/common/State;", "", "(Ljava/lang/String;I)V", "isDisconnected", "", "()Z", "DEFAULT", "CONNECTED", "DISCONNECTING", "DISCONNECTED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
enum State {
    DEFAULT,
    CONNECTED,
    DISCONNECTING,
    DISCONNECTED;

    public final boolean isDisconnected() {
        return this == DISCONNECTED;
    }
}

package com.sumsub.sns.internal.core.data.model;

import kotlin.jvm.internal.x;

public final class i {
    public static final boolean a(String str) {
        return x.b(str, FieldName.email.getValue()) || x.b(str, FieldName.phone.getValue());
    }
}

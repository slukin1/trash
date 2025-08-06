package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

public final /* synthetic */ class x implements Transformer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ x f67152a = new x();

    public final Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}

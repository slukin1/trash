package io.flutter.plugins.firebase.core;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class o implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi f55201a;

    public /* synthetic */ o(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi firebaseCoreHostApi) {
        this.f55201a = firebaseCoreHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.g(this.f55201a, obj, reply);
    }
}

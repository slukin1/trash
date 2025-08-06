package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.profileinstaller.f;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.Executor;

class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    public interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    public WithinAppServiceBinder(IntentHandler intentHandler2) {
        this.intentHandler = intentHandler2;
    }

    public void send(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.intentHandler.handle(bindRequest.intent).addOnCompleteListener((Executor) f.f10497b, new d0(bindRequest));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}

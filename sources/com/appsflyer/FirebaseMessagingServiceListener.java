package com.appsflyer;

import com.appsflyer.internal.bb;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        new bb(getApplicationContext()).valueOf(str);
    }
}

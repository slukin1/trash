package io.flutter.plugins.firebase.crashlytics;

import androidx.annotation.Keep;

@Keep
public class FlutterError extends Exception {
    public FlutterError(String str) {
        super(str);
    }
}

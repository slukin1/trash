package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

@Deprecated
public interface SplashScreen {
    View createSplashView(Context context, Bundle bundle);

    @SuppressLint({"NewApi"})
    boolean doesSplashViewRememberItsTransition();

    @SuppressLint({"NewApi"})
    Bundle saveSplashScreenState();

    void transitionToFlutter(Runnable runnable);
}

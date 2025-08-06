package io.flutter.plugins.firebase.crashlytics;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Collections;
import java.util.List;

@Keep
public class FlutterFirebaseAppRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Collections.singletonList(LibraryVersionComponent.create(BuildConfig.LIBRARY_NAME, BuildConfig.LIBRARY_VERSION));
    }
}

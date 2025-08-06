package androidx.camera.extensions;

import androidx.camera.core.CameraProvider;

public final class ExtensionsManager {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f5751c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static ExtensionsManager f5752d;

    /* renamed from: a  reason: collision with root package name */
    public final ExtensionsAvailability f5753a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5754b;

    public enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    public ExtensionsManager(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider) {
        this.f5753a = extensionsAvailability;
        this.f5754b = new b(cameraProvider);
    }

    public static ExtensionsManager a(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider) {
        synchronized (f5751c) {
            ExtensionsManager extensionsManager = f5752d;
            if (extensionsManager != null) {
                return extensionsManager;
            }
            ExtensionsManager extensionsManager2 = new ExtensionsManager(extensionsAvailability, cameraProvider);
            f5752d = extensionsManager2;
            return extensionsManager2;
        }
    }
}

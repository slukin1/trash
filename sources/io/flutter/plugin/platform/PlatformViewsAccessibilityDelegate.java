package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.view.AccessibilityBridge;

public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge);

    void detachAccessibilityBridge();

    View getPlatformViewById(int i11);

    boolean usesVirtualDisplay(int i11);
}

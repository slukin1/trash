package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessibilityBridge.SemanticsNode f55254a;

    public /* synthetic */ a(AccessibilityBridge.SemanticsNode semanticsNode) {
        this.f55254a = semanticsNode;
    }

    public final boolean test(Object obj) {
        return AccessibilityBridge.lambda$shouldSetCollectionInfo$0(this.f55254a, (AccessibilityBridge.SemanticsNode) obj);
    }
}

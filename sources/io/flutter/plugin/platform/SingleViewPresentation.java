package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.tencent.rtmp.TXVodConstants;
import io.flutter.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@TargetApi(17)
@Keep
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private AccessibilityDelegatingFrameLayout rootView;
    private boolean startFocused = false;
    private final PresentationState state;
    private int viewId;

    public static class AccessibilityDelegatingFrameLayout extends FrameLayout {
        private final AccessibilityEventsDelegate accessibilityEventsDelegate;
        private final View embeddedView;

        public AccessibilityDelegatingFrameLayout(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate2, View view) {
            super(context);
            this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
            this.embeddedView = view;
        }

        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, view, accessibilityEvent);
        }
    }

    public static class FakeWindowViewGroup extends ViewGroup {
        private final Rect childRect = new Rect();
        private final Rect viewBounds = new Rect();

        public FakeWindowViewGroup(Context context) {
            super(context);
        }

        private static int atMost(int i11) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE);
        }

        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
            for (int i15 = 0; i15 < getChildCount(); i15++) {
                View childAt = getChildAt(i15);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.viewBounds.set(i11, i12, i13, i14);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams.x, layoutParams.y, this.childRect);
                Rect rect = this.childRect;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        public void onMeasure(int i11, int i12) {
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                getChildAt(i13).measure(atMost(i11), atMost(i12));
            }
            super.onMeasure(i11, i12);
        }
    }

    public static class ImmContext extends ContextWrapper {
        private final InputMethodManager inputMethodManager;

        public ImmContext(Context context) {
            this(context, (InputMethodManager) null);
        }

        public Context createDisplayContext(Display display) {
            return new ImmContext(super.createDisplayContext(display), this.inputMethodManager);
        }

        public Object getSystemService(String str) {
            if ("input_method".equals(str)) {
                return this.inputMethodManager;
            }
            return super.getSystemService(str);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.inputmethod.InputMethodManager} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ImmContext(android.content.Context r1, android.view.inputmethod.InputMethodManager r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                if (r2 == 0) goto L_0x0006
                goto L_0x000f
            L_0x0006:
                java.lang.String r2 = "input_method"
                java.lang.Object r1 = r1.getSystemService(r2)
                r2 = r1
                android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
            L_0x000f:
                r0.inputMethodManager = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.SingleViewPresentation.ImmContext.<init>(android.content.Context, android.view.inputmethod.InputMethodManager):void");
        }
    }

    public static class PresentationContext extends ContextWrapper {
        private final Context flutterAppWindowContext;
        private WindowManager windowManager;
        private final WindowManagerHandler windowManagerHandler;

        public PresentationContext(Context context, WindowManagerHandler windowManagerHandler2, Context context2) {
            super(context);
            this.windowManagerHandler = windowManagerHandler2;
            this.flutterAppWindowContext = context2;
        }

        private WindowManager getWindowManager() {
            if (this.windowManager == null) {
                this.windowManager = this.windowManagerHandler.getWindowManager();
            }
            return this.windowManager;
        }

        private boolean isCalledFromAlertDialog() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i11 = 0;
            while (i11 < stackTrace.length && i11 < 11) {
                if (stackTrace[i11].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i11].getMethodName().equals("<init>")) {
                    return true;
                }
                i11++;
            }
            return false;
        }

        public Object getSystemService(String str) {
            if (!"window".equals(str)) {
                return super.getSystemService(str);
            }
            if (isCalledFromAlertDialog()) {
                return this.flutterAppWindowContext.getSystemService(str);
            }
            return getWindowManager();
        }
    }

    public static class PresentationState {
        /* access modifiers changed from: private */
        public FakeWindowViewGroup fakeWindowViewGroup;
        /* access modifiers changed from: private */
        public PlatformView platformView;
        /* access modifiers changed from: private */
        public WindowManagerHandler windowManagerHandler;
    }

    public static class WindowManagerHandler implements InvocationHandler {
        private static final String TAG = "PlatformViewsController";
        private final WindowManager delegate;
        public FakeWindowViewGroup fakeWindowRootView;

        public WindowManagerHandler(WindowManager windowManager, FakeWindowViewGroup fakeWindowViewGroup) {
            this.delegate = windowManager;
            this.fakeWindowRootView = fakeWindowViewGroup;
        }

        private void addView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called addView while detached from presentation");
            } else {
                fakeWindowViewGroup.addView(objArr[0], objArr[1]);
            }
        }

        private void removeView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called removeView while detached from presentation");
            } else {
                fakeWindowViewGroup.removeView(objArr[0]);
            }
        }

        private void removeViewImmediate(Object[] objArr) {
            if (this.fakeWindowRootView == null) {
                Log.w(TAG, "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = objArr[0];
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }

        private void updateViewLayout(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called updateViewLayout while detached from presentation");
            } else {
                fakeWindowViewGroup.updateViewLayout(objArr[0], objArr[1]);
            }
        }

        public WindowManager getWindowManager() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            name.hashCode();
            char c11 = 65535;
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    addView(objArr);
                    return null;
                case 1:
                    removeViewImmediate(objArr);
                    return null;
                case 2:
                    updateViewLayout(objArr);
                    return null;
                case 3:
                    removeView(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.delegate, objArr);
                    } catch (InvocationTargetException e11) {
                        throw e11.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, PlatformView platformView, AccessibilityEventsDelegate accessibilityEventsDelegate2, int i11, View.OnFocusChangeListener onFocusChangeListener) {
        super(new ImmContext(context), display);
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.viewId = i11;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        PresentationState presentationState = new PresentationState();
        this.state = presentationState;
        PlatformView unused = presentationState.platformView = platformView;
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(TXVodConstants.VOD_PLAY_EVT_VIDEO_SEI);
        }
    }

    public PresentationState detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public PlatformView getView() {
        if (this.state.platformView == null) {
            return null;
        }
        return this.state.platformView;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.fakeWindowViewGroup == null) {
            FakeWindowViewGroup unused = this.state.fakeWindowViewGroup = new FakeWindowViewGroup(getContext());
        }
        if (this.state.windowManagerHandler == null) {
            PresentationState presentationState = this.state;
            WindowManagerHandler unused2 = presentationState.windowManagerHandler = new WindowManagerHandler((WindowManager) getContext().getSystemService("window"), presentationState.fakeWindowViewGroup);
        }
        this.container = new FrameLayout(getContext());
        PresentationContext presentationContext = new PresentationContext(getContext(), this.state.windowManagerHandler, this.outerContext);
        View view = this.state.platformView.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(presentationContext);
        } else {
            Log.w(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        AccessibilityDelegatingFrameLayout accessibilityDelegatingFrameLayout = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = accessibilityDelegatingFrameLayout;
        accessibilityDelegatingFrameLayout.addView(this.container);
        this.rootView.addView(this.state.fakeWindowViewGroup);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, AccessibilityEventsDelegate accessibilityEventsDelegate2, PresentationState presentationState, View.OnFocusChangeListener onFocusChangeListener, boolean z11) {
        super(new ImmContext(context), display);
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.state = presentationState;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z11;
    }
}

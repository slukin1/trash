package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import androidx.core.view.v;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomSheetDialog extends e {
    /* access modifiers changed from: private */
    public BottomSheetBehavior<FrameLayout> behavior;
    /* access modifiers changed from: private */
    public FrameLayout bottomSheet;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    public boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    public boolean dismissWithAnimation;
    /* access modifiers changed from: private */
    public BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final boolean lightBottomSheet;
        private final boolean lightStatusBar;

        private void setPaddingForPosition(View view) {
            if (view.getTop() < this.insetsCompat.m()) {
                BottomSheetDialog.setLightStatusBar(view, this.lightBottomSheet);
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.lightStatusBar);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void onSlide(View view, float f11) {
            setPaddingForPosition(view);
        }

        public void onStateChanged(View view, int i11) {
            setPaddingForPosition(view);
        }

        private EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat) {
            ColorStateList colorStateList;
            this.insetsCompat = windowInsetsCompat;
            boolean z11 = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.lightStatusBar = z11;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                colorStateList = materialShapeDrawable.getFillColor();
            } else {
                colorStateList = h0.v(view);
            }
            if (colorStateList != null) {
                this.lightBottomSheet = MaterialColors.isColorLight(colorStateList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.lightBottomSheet = MaterialColors.isColorLight(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.lightBottomSheet = z11;
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }

    public static void setLightStatusBar(View view, boolean z11) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z11 ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    private View wrapInBottomSheet(int i11, View view, ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (i11 != 0 && view == null) {
            view = getLayoutInflater().inflate(i11, coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            h0.O0(this.bottomSheet, new v() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.edgeToEdgeCallback != null) {
                        BottomSheetDialog.this.behavior.removeBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        BottomSheetBehavior.BottomSheetCallback unused = bottomSheetDialog.edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, windowInsetsCompat);
                        BottomSheetDialog.this.behavior.addBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        h0.x0(this.bottomSheet, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.t0(true);
                    return;
                }
                accessibilityNodeInfoCompat.t0(false);
            }

            public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
                if (i11 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i11, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior2 = getBehavior();
        if (!this.dismissWithAnimation || behavior2.getState() == 5) {
            super.cancel();
        } else {
            behavior2.setState(5);
        }
    }

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT >= 21) {
            boolean z11 = this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z11);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z11);
            }
            if (z11) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (i11 < 23) {
                    window.addFlags(67108864);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setCancelable(boolean z11) {
        super.setCancelable(z11);
        if (this.cancelable != z11) {
            this.cancelable = z11;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z11);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z11) {
        super.setCanceledOnTouchOutside(z11);
        if (z11 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z11;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(int i11) {
        super.setContentView(wrapInBottomSheet(i11, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setDismissWithAnimation(boolean z11) {
        this.dismissWithAnimation = z11;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public BottomSheetDialog(Context context, int i11) {
        super(context, getThemeResId(context, i11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(View view, float f11) {
            }

            public void onStateChanged(View view, int i11) {
                if (i11 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context context, boolean z11, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z11, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(View view, float f11) {
            }

            public void onStateChanged(View view, int i11) {
                if (i11 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z11;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}

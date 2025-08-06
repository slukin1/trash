package com.huobi.edgeengine.template.widget.pop;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.huobi.edgeengine.R$color;
import com.huobi.edgeengine.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/huobi/edgeengine/template/widget/pop/EngineAndroidXDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "args", "", "setArguments", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "dismiss", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "getManager", "()Landroidx/fragment/app/FragmentManager;", "rh", "(Landroidx/fragment/app/FragmentManager;)V", "manager", "Landroid/view/View;", "c", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "qh", "(Landroid/view/View;)V", "contentView", "", "d", "I", "location", "", "e", "Z", "popCancelOnTouchOutside", "f", "isFullScreen", "Landroid/widget/PopupWindow$OnDismissListener;", "g", "Landroid/widget/PopupWindow$OnDismissListener;", "onDismissListener", "<init>", "()V", "h", "a", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class EngineAndroidXDialogFragment extends DialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public static final a f44298h = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public FragmentManager f44299b;

    /* renamed from: c  reason: collision with root package name */
    public View f44300c;

    /* renamed from: d  reason: collision with root package name */
    public int f44301d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44302e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44303f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow.OnDismissListener f44304g;

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JD\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/huobi/edgeengine/template/widget/pop/EngineAndroidXDialogFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "Landroid/view/View;", "content", "", "location", "", "isFullScreen", "Landroid/widget/PopupWindow$OnDismissListener;", "onDismissListener", "popCancelOnTouchOutside", "Lcom/huobi/edgeengine/template/widget/pop/EngineAndroidXDialogFragment;", "a", "", "FLAG", "Ljava/lang/String;", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final EngineAndroidXDialogFragment a(FragmentManager fragmentManager, View view, int i11, boolean z11, PopupWindow.OnDismissListener onDismissListener, boolean z12) {
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                EngineAndroidXDialogFragment engineAndroidXDialogFragment = new EngineAndroidXDialogFragment();
                engineAndroidXDialogFragment.rh(fragmentManager);
                engineAndroidXDialogFragment.qh(view);
                engineAndroidXDialogFragment.f44304g = onDismissListener;
                Bundle bundle = new Bundle();
                bundle.putInt("location", i11);
                bundle.putBoolean("isFullScreen", z11);
                bundle.putBoolean("popCancelOnTouchOutside", z12);
                engineAndroidXDialogFragment.setArguments(bundle);
                q11.e(engineAndroidXDialogFragment, "EngineAndroidXDialogFragment");
                q11.k();
                return engineAndroidXDialogFragment;
            } catch (Exception e11) {
                e11.printStackTrace();
                if (onDismissListener == null) {
                    return null;
                }
                onDismissListener.onDismiss();
                return null;
            }
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (IllegalStateException unused) {
            System.err.println("dialog already closed!");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        View decorView;
        Dialog dialog = new Dialog(requireActivity());
        View view = this.f44300c;
        if (view != null) {
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(this.f44302e);
            dialog.requestWindowFeature(1);
            dialog.setContentView(view);
            Window window = dialog.getWindow();
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                decorView.setPadding(0, 0, 0, 0);
            }
            if (window == null) {
                layoutParams = null;
            } else {
                layoutParams = window.getAttributes();
            }
            int i11 = this.f44301d;
            if (i11 == 0) {
                if (layoutParams != null) {
                    layoutParams.gravity = 80;
                }
                if (layoutParams != null) {
                    layoutParams.width = -1;
                }
                if (this.f44303f && layoutParams != null) {
                    layoutParams.height = -1;
                }
                if (layoutParams != null) {
                    layoutParams.windowAnimations = R$style.bottom_animation;
                }
            } else if (i11 == 1) {
                if (this.f44303f) {
                    if (layoutParams != null) {
                        layoutParams.width = -1;
                    }
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                    }
                }
                if (layoutParams != null) {
                    layoutParams.gravity = 17;
                }
            } else if (i11 == 2) {
                if (layoutParams != null) {
                    layoutParams.gravity = 3;
                }
                if (layoutParams != null) {
                    layoutParams.height = -1;
                }
                if (this.f44303f && layoutParams != null) {
                    layoutParams.width = -1;
                }
                if (layoutParams != null) {
                    layoutParams.windowAnimations = R$style.left_animation;
                }
            } else if (i11 == 3) {
                if (layoutParams != null) {
                    layoutParams.gravity = 5;
                }
                if (layoutParams != null) {
                    layoutParams.height = -1;
                }
                if (this.f44303f && layoutParams != null) {
                    layoutParams.width = -1;
                }
                if (layoutParams != null) {
                    layoutParams.windowAnimations = R$style.right_animation;
                }
            }
            if (window != null) {
                window.setAttributes(layoutParams);
            }
            if (window != null) {
                window.setBackgroundDrawableResource(R$color.transparent);
            }
        }
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        PopupWindow.OnDismissListener onDismissListener = this.f44304g;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final void qh(View view) {
        this.f44300c = view;
    }

    public final void rh(FragmentManager fragmentManager) {
        this.f44299b = fragmentManager;
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        if (bundle != null) {
            this.f44301d = bundle.getInt("location");
        }
        if (bundle != null) {
            this.f44302e = bundle.getBoolean("popCancelOnTouchOutside");
        }
        if (bundle != null) {
            this.f44303f = bundle.getBoolean("isFullScreen");
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}

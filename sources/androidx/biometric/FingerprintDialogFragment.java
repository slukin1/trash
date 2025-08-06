package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;

public class FingerprintDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final Handler f4826b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f4827c = new a();

    /* renamed from: d  reason: collision with root package name */
    public BiometricViewModel f4828d;

    /* renamed from: e  reason: collision with root package name */
    public int f4829e;

    /* renamed from: f  reason: collision with root package name */
    public int f4830f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f4831g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4832h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            FingerprintDialogFragment.this.th();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            FingerprintDialogFragment.this.f4828d.b1(true);
        }
    }

    public class c implements z<Integer> {
        public c() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            FingerprintDialogFragment fingerprintDialogFragment = FingerprintDialogFragment.this;
            fingerprintDialogFragment.f4826b.removeCallbacks(fingerprintDialogFragment.f4827c);
            FingerprintDialogFragment.this.vh(num.intValue());
            FingerprintDialogFragment.this.wh(num.intValue());
            FingerprintDialogFragment fingerprintDialogFragment2 = FingerprintDialogFragment.this;
            fingerprintDialogFragment2.f4826b.postDelayed(fingerprintDialogFragment2.f4827c, 2000);
        }
    }

    public class d implements z<CharSequence> {
        public d() {
        }

        /* renamed from: a */
        public void onChanged(CharSequence charSequence) {
            FingerprintDialogFragment fingerprintDialogFragment = FingerprintDialogFragment.this;
            fingerprintDialogFragment.f4826b.removeCallbacks(fingerprintDialogFragment.f4827c);
            FingerprintDialogFragment.this.xh(charSequence);
            FingerprintDialogFragment fingerprintDialogFragment2 = FingerprintDialogFragment.this;
            fingerprintDialogFragment2.f4826b.postDelayed(fingerprintDialogFragment2.f4827c, 2000);
        }
    }

    public static class e {
        public static void a(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    public static class f {
        public static int a() {
            return R$attr.colorError;
        }
    }

    public static FingerprintDialogFragment sh() {
        return new FingerprintDialogFragment();
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.f4828d.V0(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ph();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4829e = rh(f.a());
        } else {
            Context context = getContext();
            this.f4829e = context != null ? ContextCompat.getColor(context, R$color.biometric_error_color) : 0;
        }
        this.f4830f = rh(16842808);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        AlertDialog.a aVar = new AlertDialog.a(requireContext());
        aVar.setTitle(this.f4828d.z0());
        View inflate = LayoutInflater.from(aVar.getContext()).inflate(R$layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.fingerprint_subtitle);
        if (textView != null) {
            CharSequence y02 = this.f4828d.y0();
            if (TextUtils.isEmpty(y02)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(y02);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.fingerprint_description);
        if (textView2 != null) {
            CharSequence r02 = this.f4828d.r0();
            if (TextUtils.isEmpty(r02)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(r02);
            }
        }
        this.f4831g = (ImageView) inflate.findViewById(R$id.fingerprint_icon);
        this.f4832h = (TextView) inflate.findViewById(R$id.fingerprint_error);
        if (b.c(this.f4828d.h0())) {
            charSequence = getString(R$string.confirm_device_credential_password);
        } else {
            charSequence = this.f4828d.x0();
        }
        aVar.setNegativeButton(charSequence, (DialogInterface.OnClickListener) new b());
        aVar.setView(inflate);
        AlertDialog create = aVar.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public void onPause() {
        super.onPause();
        this.f4826b.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        this.f4828d.Y0(0);
        this.f4828d.Z0(1);
        this.f4828d.X0(getString(R$string.fingerprint_dialog_touch_sensor));
    }

    public final void ph() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            BiometricViewModel biometricViewModel = (BiometricViewModel) new ViewModelProvider(activity).a(BiometricViewModel.class);
            this.f4828d = biometricViewModel;
            biometricViewModel.u0().observe(this, new c());
            this.f4828d.s0().observe(this, new d());
        }
    }

    public final Drawable qh(int i11, int i12) {
        int i13;
        Context context = getContext();
        if (context == null) {
            Log.w("FingerprintFragment", "Unable to get asset. Context is null.");
            return null;
        }
        if (i11 == 0 && i12 == 1) {
            i13 = R$drawable.fingerprint_dialog_fp_icon;
        } else if (i11 == 1 && i12 == 2) {
            i13 = R$drawable.fingerprint_dialog_error;
        } else if (i11 == 2 && i12 == 1) {
            i13 = R$drawable.fingerprint_dialog_fp_icon;
        } else if (i11 != 1 || i12 != 3) {
            return null;
        } else {
            i13 = R$drawable.fingerprint_dialog_fp_icon;
        }
        return ContextCompat.getDrawable(context, i13);
    }

    public final int rh(int i11) {
        Context context = getContext();
        FragmentActivity activity = getActivity();
        if (context == null || activity == null) {
            Log.w("FingerprintFragment", "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(typedValue.data, new int[]{i11});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public void th() {
        Context context = getContext();
        if (context == null) {
            Log.w("FingerprintFragment", "Not resetting the dialog. Context is null.");
            return;
        }
        this.f4828d.Z0(1);
        this.f4828d.X0(context.getString(R$string.fingerprint_dialog_touch_sensor));
    }

    public final boolean uh(int i11, int i12) {
        if (i11 == 0 && i12 == 1) {
            return false;
        }
        if (i11 == 1 && i12 == 2) {
            return true;
        }
        return i11 == 2 && i12 == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r0 = r3.f4828d.t0();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void vh(int r4) {
        /*
            r3 = this;
            android.widget.ImageView r0 = r3.f4831g
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x002b
            androidx.biometric.BiometricViewModel r0 = r3.f4828d
            int r0 = r0.t0()
            android.graphics.drawable.Drawable r1 = r3.qh(r0, r4)
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            android.widget.ImageView r2 = r3.f4831g
            r2.setImageDrawable(r1)
            boolean r0 = r3.uh(r0, r4)
            if (r0 == 0) goto L_0x0026
            androidx.biometric.FingerprintDialogFragment.e.a(r1)
        L_0x0026:
            androidx.biometric.BiometricViewModel r0 = r3.f4828d
            r0.Y0(r4)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.FingerprintDialogFragment.vh(int):void");
    }

    public void wh(int i11) {
        TextView textView = this.f4832h;
        if (textView != null) {
            textView.setTextColor(i11 == 2 ? this.f4829e : this.f4830f);
        }
    }

    public void xh(CharSequence charSequence) {
        TextView textView = this.f4832h;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}

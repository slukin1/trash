package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class ErrorDialogFragments {

    /* renamed from: a  reason: collision with root package name */
    public static int f68286a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f68287b;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            ErrorDialogFragments.b(dialogInterface, i11, getActivity(), getArguments());
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
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

        @SensorsDataInstrumented
        public void setUserVisibleHint(boolean z11) {
            super.setUserVisibleHint(z11);
            FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            ErrorDialogFragments.b(dialogInterface, i11, getActivity(), getArguments());
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
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

        @SensorsDataInstrumented
        public void setUserVisibleHint(boolean z11) {
            super.setUserVisibleHint(z11);
            FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i11 = f68286a;
        if (i11 != 0) {
            builder.setIcon(i11);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void b(DialogInterface dialogInterface, int i11, Activity activity, Bundle bundle) {
        Class<?> cls = f68287b;
        if (cls != null) {
            try {
                cls.newInstance();
                throw null;
            } catch (Exception e11) {
                throw new RuntimeException("Event cannot be constructed", e11);
            }
        } else if (bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
            activity.finish();
        }
    }
}

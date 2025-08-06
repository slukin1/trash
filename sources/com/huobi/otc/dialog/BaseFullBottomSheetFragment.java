package com.huobi.otc.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hbg.module.otc.R$id;
import java.lang.reflect.Field;

public class BaseFullBottomSheetFragment extends BottomSheetDialogFragment {
    public BottomSheetBehavior<FrameLayout> mBehavior;

    public static BaseFullBottomSheetFragment getInstance() {
        return new BaseFullBottomSheetFragment();
    }

    public boolean getHideAble() {
        return false;
    }

    public int getPeekHeight() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext());
    }

    public void onStart() {
        super.onStart();
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
        Window window = bottomSheetDialog.getWindow();
        int i11 = R$id.design_bottom_sheet;
        window.findViewById(i11).setBackgroundDrawable(new ColorDrawable(0));
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.getDelegate().j(i11);
        if (frameLayout != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = getPeekHeight();
            frameLayout.setLayoutParams(layoutParams);
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
            this.mBehavior = from;
            from.setPeekHeight(getPeekHeight());
            this.mBehavior.setHideable(getHideAble());
            this.mBehavior.setState(3);
            this.mBehavior.setExpandedOffset(100);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.q().s(this).k();
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            FragmentTransaction q11 = fragmentManager.q();
            q11.e(this, str);
            q11.k();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}

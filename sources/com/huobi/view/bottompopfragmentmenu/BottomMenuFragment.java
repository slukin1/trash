package com.huobi.view.bottompopfragmentmenu;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.List;
import pro.huobi.R;

public class BottomMenuFragment extends DialogFragment {
    private BottomMenuDismissListener bottomMenuDismissListener;
    private BottomMenuShowListener bottomMenuShowListener;
    /* access modifiers changed from: private */
    public CopyTradingCancelListener cancelListener;
    private LinearLayout cancelLl;
    private CharSequence mCancelText;
    private BaseDialogFragment.c mListener;
    private List<MenuItem> menuItems;
    private TextView tvCancel;

    public interface BottomMenuDismissListener {
        void onBottomMenuDismissListener();
    }

    public interface BottomMenuShowListener {
        void onBottomMenuShowListener();
    }

    public interface CopyTradingCancelListener {
        void onCancel();
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.menu_animation);
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_menu, viewGroup, false);
        this.tvCancel = (TextView) inflate.findViewById(R.id.tv_cancel);
        if (!TextUtils.isEmpty(this.mCancelText)) {
            this.tvCancel.setText(this.mCancelText);
        }
        this.tvCancel.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (BottomMenuFragment.this.cancelListener != null) {
                    BottomMenuFragment.this.cancelListener.onCancel();
                }
                BottomMenuFragment.this.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.cancelLl = (LinearLayout) inflate.findViewById(R.id.cancel_ll);
        ((ListView) inflate.findViewById(R.id.lv_menu)).setAdapter(new MenuItemAdapter(getActivity(), this.menuItems));
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        BottomMenuDismissListener bottomMenuDismissListener2 = this.bottomMenuDismissListener;
        if (bottomMenuDismissListener2 != null) {
            bottomMenuDismissListener2.onBottomMenuDismissListener();
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
        BaseDialogFragment.c cVar = this.mListener;
        if (cVar != null) {
            cVar.onDialogFragmentPause();
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        BaseDialogFragment.c cVar = this.mListener;
        if (cVar != null) {
            cVar.onDialogFragmentResume();
        }
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getDialog().getWindow().setLayout(displayMetrics.widthPixels, getDialog().getWindow().getAttributes().height);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.gravity = 80;
        getDialog().getWindow().setAttributes(attributes);
    }

    public void onStop() {
        getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.menu_disappear));
        super.onStop();
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setBottomMenuDismissListener(BottomMenuDismissListener bottomMenuDismissListener2) {
        this.bottomMenuDismissListener = bottomMenuDismissListener2;
    }

    public void setBottomMenuShowListener(BottomMenuShowListener bottomMenuShowListener2) {
        this.bottomMenuShowListener = bottomMenuShowListener2;
    }

    public void setCancelText(String str) {
        this.mCancelText = str;
        TextView textView = this.tvCancel;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCancelVisiablity(int i11) {
        this.cancelLl.setVisibility(i11);
    }

    public void setCopyTradingCancel(CopyTradingCancelListener copyTradingCancelListener) {
        this.cancelListener = copyTradingCancelListener;
    }

    public void setDialogFragmentListener(BaseDialogFragment.c cVar) {
        this.mListener = cVar;
    }

    public void setMenuItems(List<MenuItem> list) {
        this.menuItems = list;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.beginTransaction().remove(this).commit();
            super.show(fragmentManager, str);
            BottomMenuShowListener bottomMenuShowListener2 = this.bottomMenuShowListener;
            if (bottomMenuShowListener2 != null) {
                bottomMenuShowListener2.onBottomMenuShowListener();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void setCancelText(int i11) {
        this.tvCancel.setText(i11);
    }
}

package com.jumio.defaultui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.jumio.core.util.DataDogHelper;
import com.jumio.defaultui.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.a;
import java.util.Map;
import jumio.dui.b;
import jumio.dui.g;
import kotlin.i;
import kotlin.jvm.internal.Reflection;

public class JumioBottomSheet<T> extends BottomSheetDialogFragment implements View.OnClickListener {
    private T descriptions;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new JumioBottomSheet$special$$inlined$activityViewModels$default$1(this), new JumioBottomSheet$special$$inlined$activityViewModels$default$2((a) null, this), new JumioBottomSheet$special$$inlined$activityViewModels$default$3(this));
    private String primaryActionButtonText = "";
    private FrameLayout rootView;
    private String secondaryActionButtonText = "";
    private String title = "";

    private final View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        boolean z11 = false;
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_bottom_sheet, viewGroup, false);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tv_title);
        if (appCompatTextView != null) {
            if (this.title.length() == 0) {
                appCompatTextView.setVisibility(8);
            } else {
                appCompatTextView.setVisibility(0);
                appCompatTextView.setText(this.title);
            }
        }
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.tv_description_container);
        if (recyclerView != null) {
            initDescription(recyclerView, getDescriptions());
        }
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.btn_action_primary);
        if (materialButton != null) {
            initButton(materialButton, this.primaryActionButtonText);
        }
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.btn_action_secondary);
        if (materialButton2 != null) {
            initButton(materialButton2, this.secondaryActionButtonText);
            if (this.secondaryActionButtonText.length() == 0) {
                z11 = true;
            }
            if (z11) {
                materialButton2.setVisibility(8);
                if (recyclerView != null) {
                    ((ConstraintLayout.LayoutParams) recyclerView.getLayoutParams()).V = 0.6f;
                    recyclerView.requestLayout();
                }
            }
        }
        return inflate;
    }

    private final void initButton(MaterialButton materialButton, String str) {
        materialButton.setOnClickListener(this);
        materialButton.setSingleLine(false);
        materialButton.setMinLines(0);
        materialButton.setText(str);
    }

    private final void initDescription(RecyclerView recyclerView, T t11) {
        if (t11 == null) {
            recyclerView.setVisibility(8);
            return;
        }
        recyclerView.setVisibility(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.addOnChildAttachStateChangeListener(new g(layoutManager, recyclerView));
        }
    }

    public void dismiss() {
        Dialog dialog = getDialog();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog != null) {
            bottomSheetBehavior = bottomSheetDialog.getBehavior();
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setDraggable(false);
        }
        super.dismiss();
    }

    public T getDescriptions() {
        return this.descriptions;
    }

    public final b getJumioViewModel$jumio_defaultui_release() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    public final String getPrimaryActionButtonText() {
        return this.primaryActionButtonText;
    }

    public final String getSecondaryActionButtonText() {
        return this.secondaryActionButtonText;
    }

    public final String getTitle() {
        return this.title;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.btn_action_primary) {
            onPrimaryAction();
            dismiss();
        } else if (view.getId() == R.id.btn_action_secondary) {
            onSecondaryAction();
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.rootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.rootView;
        if (frameLayout2 != null) {
            frameLayout2.addView(createLayout(getLayoutInflater(), this.rootView));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        if (bundle != null) {
            this.title = bundle.getString("JUMIO_BOTTOM_SHEET_TITLE", "");
            this.primaryActionButtonText = bundle.getString("JUMIO_BOTTOM_SHEET_PRIMARY_ACTION", "");
            this.secondaryActionButtonText = bundle.getString("JUMIO_BOTTOM_SHEET_SECONDARY_ACTION", "");
        }
        Context context = getContext();
        if (context != null) {
            frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(createLayout(layoutInflater, frameLayout));
        } else {
            frameLayout = null;
        }
        this.rootView = frameLayout;
        return frameLayout;
    }

    public void onDismiss() {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        onDismiss();
    }

    public void onPause() {
        super.onPause();
        DataDogHelper.reportViewStop$default(DataDogHelper.INSTANCE, this, (Map) null, 2, (Object) null);
    }

    public void onPrimaryAction() {
    }

    public void onResume() {
        super.onResume();
        DataDogHelper.INSTANCE.reportViewStart(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("JUMIO_BOTTOM_SHEET_TITLE", this.title);
        bundle.putString("JUMIO_BOTTOM_SHEET_PRIMARY_ACTION", this.primaryActionButtonText);
        bundle.putString("JUMIO_BOTTOM_SHEET_SECONDARY_ACTION", this.secondaryActionButtonText);
    }

    public void onSecondaryAction() {
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.getBehavior().setState(3);
            bottomSheetDialog.getBehavior().setFitToContents(true);
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setDismissWithAnimation(true);
            View view = getView();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void setDescriptions(T t11) {
        this.descriptions = t11;
    }

    public final void setPrimaryActionButtonText(String str) {
        this.primaryActionButtonText = str;
    }

    public final void setSecondaryActionButtonText(String str) {
        this.secondaryActionButtonText = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}

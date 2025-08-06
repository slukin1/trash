package com.hbg.lib.widgets.dialog.dialogfragment;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ca.b;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.List;

public class BottomMenuTitleDialogFragment extends BaseListDialogFragment<TitleDialogMenuItemBean> {

    /* renamed from: b  reason: collision with root package name */
    public List<TitleDialogMenuItemBean> f71947b;

    /* renamed from: c  reason: collision with root package name */
    public a f71948c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71949d;

    public interface a {
        void onBack();

        void onDismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        a aVar = this.f71948c;
        if (aVar != null) {
            aVar.onBack();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        rVar.b(R$id.back).setOnClickListener(new b(this));
    }

    public void afterInit() {
        if (getContext() != null) {
            FrameLayout rootLayout = getRootLayout();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) rootLayout.getLayoutParams();
            marginLayoutParams.width = PixelUtils.g();
            rootLayout.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mRecyclerView.getLayoutParams();
            marginLayoutParams2.width = PixelUtils.g();
            this.mRecyclerView.setLayoutParams(marginLayoutParams2);
        }
        this.f71949d = (TextView) this.viewFinder.b(R$id.title);
        super.afterInit();
    }

    public int getContentViewResId() {
        return R$layout.dialog_fragment_title_bottom_menu_layout;
    }

    public List<TitleDialogMenuItemBean> getDataList() {
        return this.f71947b;
    }

    public int getGravity() {
        return 80;
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.f71948c;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public boolean useWindowBg() {
        return false;
    }
}

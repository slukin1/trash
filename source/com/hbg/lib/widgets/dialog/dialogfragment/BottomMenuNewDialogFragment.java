package com.hbg.lib.widgets.dialog.dialogfragment;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ea.b;
import i6.r;
import java.util.List;

public class BottomMenuNewDialogFragment extends BaseListDialogFragment<MenuItemBean> {

    /* renamed from: b  reason: collision with root package name */
    public List<MenuItemBean> f71945b;

    /* renamed from: c  reason: collision with root package name */
    public a f71946c;

    public interface a {
        void onCancel();

        void onDismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        a aVar = this.f71946c;
        if (aVar != null) {
            aVar.onCancel();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        rVar.b(R$id.cancel_ll).setOnClickListener(new ca.a(this));
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
            this.mRecyclerView.addItemDecoration(new b(getContext(), R$color.base_dialog_devide_line_color, 1, false, PixelUtils.a(10.0f), PixelUtils.a(10.0f)));
        }
        this.mRecyclerView.setBackground((Drawable) null);
        super.afterInit();
    }

    public int getContentViewResId() {
        return R$layout.dialog_fragment_bottom_menu_layout;
    }

    public List<MenuItemBean> getDataList() {
        return this.f71945b;
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
        a aVar = this.f71946c;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public List<MenuItemBean> th() {
        return this.f71945b;
    }

    public void uh(a aVar) {
        this.f71946c = aVar;
    }

    public boolean useWindowBg() {
        return false;
    }

    public void vh(List<MenuItemBean> list) {
        this.f71945b = list;
    }
}

package com.hbg.lib.widgets.dialog.bean;

import android.view.View;
import ba.c;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuTitleDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.List;

public class LoginVerifyChangeDialogHelper {

    /* renamed from: a  reason: collision with root package name */
    public EasyRecyclerView<TitleDialogMenuItemBean> f71942a;

    /* renamed from: b  reason: collision with root package name */
    public List<TitleDialogMenuItemBean> f71943b;

    /* renamed from: c  reason: collision with root package name */
    public BottomMenuTitleDialogFragment.a f71944c;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        BottomMenuTitleDialogFragment.a aVar = this.f71944c;
        if (aVar != null) {
            aVar.onBack();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(r rVar) {
        rVar.b(R$id.back).setOnClickListener(new c(this));
    }

    public void c() {
        g();
    }

    public List<TitleDialogMenuItemBean> d() {
        return this.f71943b;
    }

    public void e(r rVar) {
        this.f71942a = (EasyRecyclerView) rVar.b(R$id.id_base_list_dialog_recyclerView);
        b(rVar);
        c();
    }

    public void g() {
        i(d());
    }

    public void h(BottomMenuTitleDialogFragment.a aVar) {
        this.f71944c = aVar;
    }

    public void i(List<TitleDialogMenuItemBean> list) {
        EasyRecyclerView<TitleDialogMenuItemBean> easyRecyclerView = this.f71942a;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public void j(List<TitleDialogMenuItemBean> list) {
        this.f71943b = list;
        g();
    }
}

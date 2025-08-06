package com.huobi.asset.feature.account.future.maintenance;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.ui.AbstractMaintenanceView;
import s9.a;
import s9.c;
import u6.g;

public class MaintenanceData implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f42242b;

    /* renamed from: c  reason: collision with root package name */
    public g f42243c;

    /* renamed from: d  reason: collision with root package name */
    public AbstractMaintenanceView.a f42244d;

    public static class MaintenanceViewHandler implements c {
        /* renamed from: b */
        public void handleView(v9.c cVar, int i11, MaintenanceData maintenanceData, ViewGroup viewGroup) {
            AbstractMaintenanceView o11 = AbstractMaintenanceView.o(cVar.itemView.getContext(), maintenanceData.f42242b);
            o11.f(false);
            o11.setUI(maintenanceData.f42243c);
            o11.setRetryText(R$string.common_reloading_2);
            o11.setOnMaintenanceEndListener(maintenanceData.f42244d);
            o11.setCountDownTime(AssetModuleConfig.a().L(maintenanceData.f42242b));
            FrameLayout frameLayout = (FrameLayout) cVar.e().b(R$id.root);
            frameLayout.removeAllViews();
            frameLayout.addView(o11);
        }

        public int getResId() {
            return R$layout.item_future_maintenance;
        }
    }

    public MaintenanceData(int i11, g gVar, AbstractMaintenanceView.a aVar) {
        this.f42242b = i11;
        this.f42243c = gVar;
        this.f42244d = aVar;
    }

    public String getViewHandlerName() {
        return MaintenanceViewHandler.class.getName();
    }
}

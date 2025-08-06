package com.huobi.otc.persenter;

import android.content.Context;
import android.os.Bundle;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.mvp.BaseMVPFragment;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.huobi.otc.bean.OtcFAQDataType;
import com.huobi.otc.ui.OtcFAQActivity;
import java.util.ArrayList;
import java.util.List;
import u6.g;

public class OtcFAQFragmentPresenter extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public OtcFAQBean f79045c;

    /* renamed from: d  reason: collision with root package name */
    public OtcFAQActivity f79046d;

    public interface a extends g, OtcFAQDataType.OnItemClickListener {
        void Gg();

        void U3(ArrayList<s9.a> arrayList);
    }

    public void T(Context context, BaseMVPFragment baseMVPFragment) {
        super.T(context, baseMVPFragment);
        Bundle arguments = baseMVPFragment.getArguments();
        if (context instanceof OtcFAQActivity) {
            this.f79046d = (OtcFAQActivity) context;
        }
        this.f79045c = (OtcFAQBean) arguments.getSerializable("key_faq_data_bean");
    }

    public void b0(String str, int i11) {
        this.f79046d.sh(str, i11);
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        OtcFAQBean otcFAQBean = this.f79045c;
        if (otcFAQBean != null) {
            d0(otcFAQBean);
        }
    }

    public void d0(OtcFAQBean otcFAQBean) {
        if (otcFAQBean.hasSubset()) {
            List<OtcFAQBean> subset = otcFAQBean.getSubset();
            ArrayList arrayList = new ArrayList();
            for (OtcFAQBean dataBean : subset) {
                OtcFAQDataType otcFAQDataType = new OtcFAQDataType();
                otcFAQDataType.setDataBean(dataBean);
                otcFAQDataType.setOnItemClickListener((OtcFAQDataType.OnItemClickListener) getUI());
                arrayList.add(otcFAQDataType);
            }
            ((a) getUI()).U3(arrayList);
            return;
        }
        ((a) getUI()).Gg();
    }
}

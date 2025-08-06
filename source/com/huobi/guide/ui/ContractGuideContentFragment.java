package com.huobi.guide.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.guide.bean.ContractGuideInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import pro.huobi.R;
import tg.r;

public class ContractGuideContentFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public a f72458l;

    public interface a {
        void callback();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(ContractGuideInfo contractGuideInfo, View view) {
        if (contractGuideInfo.getLinkType() == 1) {
            a aVar = this.f72458l;
            if (aVar != null) {
                aVar.callback();
            }
            if (r.x().X()) {
                HuobiToastUtil.j(R.string.sub_account_not_support_otc);
            } else {
                k0.k(getActivity());
            }
        } else if (contractGuideInfo.getLinkType() == 2) {
            String link = contractGuideInfo.getLink();
            if (TextUtils.isEmpty(link)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            a aVar2 = this.f72458l;
            if (aVar2 != null) {
                aVar2.callback();
            }
            HBBaseWebActivity.showWebView(requireContext(), link, (String) null, (String) null, false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void initViews() {
        Bundle arguments = getArguments();
        ContractGuideInfo contractGuideInfo = arguments != null ? (ContractGuideInfo) arguments.getParcelable("ContractGuideInfoKey") : null;
        if (contractGuideInfo != null) {
            this.f67460i.e(R.id.guide_step_number).setText(String.valueOf(contractGuideInfo.getIndex()));
            this.f67460i.e(R.id.guide_step_all_number).append(String.valueOf(arguments.getInt("ContractGuideInfoCountKey", 1)));
            this.f67460i.e(R.id.guide_step_name).setText(contractGuideInfo.getName());
            this.f67460i.e(R.id.guide_step_detail1).setText(Html.fromHtml(contractGuideInfo.getDetail1()));
            TextView e11 = this.f67460i.e(R.id.guide_step_guide_link);
            if (TextUtils.isEmpty(contractGuideInfo.getLinkDisplayName())) {
                ViewUtil.m(e11, false);
                return;
            }
            ViewUtil.m(e11, true);
            e11.setText(contractGuideInfo.getLinkDisplayName());
            e11.setOnClickListener(new kl.a(this, contractGuideInfo));
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_contract_guide_content, viewGroup, false);
    }
}

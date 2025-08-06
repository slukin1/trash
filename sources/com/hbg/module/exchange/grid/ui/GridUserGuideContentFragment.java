package com.hbg.module.exchange.grid.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cd.p0;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.grid.bean.GridUserGuideInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Map;
import vc.b;

public class GridUserGuideContentFragment extends EmptyMVPFragment {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(GridUserGuideInfo gridUserGuideInfo, View view) {
        String link = gridUserGuideInfo.getLink();
        if (TextUtils.isEmpty(link)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        HBBaseWebActivity.showWebView(requireContext(), link, (String) null, (String) null, false);
        b.a().d("5916", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static GridUserGuideContentFragment Gh(GridUserGuideInfo gridUserGuideInfo, int i11) {
        GridUserGuideContentFragment gridUserGuideContentFragment = new GridUserGuideContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("GridUserGuideInfoKey", gridUserGuideInfo);
        bundle.putInt("GridUserGuideInfoCountKey", i11);
        gridUserGuideContentFragment.setArguments(bundle);
        return gridUserGuideContentFragment;
    }

    public void initViews() {
        Bundle arguments = getArguments();
        GridUserGuideInfo gridUserGuideInfo = arguments != null ? (GridUserGuideInfo) arguments.getParcelable("GridUserGuideInfoKey") : null;
        if (gridUserGuideInfo != null) {
            this.f67460i.e(R$id.guide_step_number).setText(String.valueOf(gridUserGuideInfo.getIndex()));
            this.f67460i.e(R$id.guide_step_all_number).append(String.valueOf(arguments.getInt("GridUserGuideInfoCountKey", 1)));
            this.f67460i.e(R$id.guide_step_name).setText(gridUserGuideInfo.getName());
            this.f67460i.e(R$id.guide_step_detail1).setText(Html.fromHtml(gridUserGuideInfo.getDetail1()));
            this.f67460i.e(R$id.guide_step_detail2).setText(Html.fromHtml(gridUserGuideInfo.getDetail2()));
            this.f67460i.e(R$id.guide_step_guide_link).setOnClickListener(new p0(this, gridUserGuideInfo));
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.dialog_grid_user_guide_content, viewGroup, false);
    }
}

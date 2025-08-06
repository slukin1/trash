package ef;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.LiveTitleData;
import com.hbg.module.content.R$id;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ef.b;

public class l extends b {

    /* renamed from: b  reason: collision with root package name */
    public View f28972b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28973c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28974d;

    public l(View view) {
        super(view);
        this.f28972b = view.findViewById(R$id.v_line);
        this.f28973c = (TextView) view.findViewById(R$id.tv_title);
        this.f28974d = (TextView) view.findViewById(R$id.tv_more);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, View view) {
        if (aVar != null) {
            aVar.a(liveSquareBaseData, 106, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        super.a(liveSquareBaseData);
        if (liveSquareBaseData instanceof LiveTitleData) {
            LiveTitleData liveTitleData = (LiveTitleData) liveSquareBaseData;
            this.f28973c.setText(liveTitleData.getTitleName());
            this.f28974d.setClickable(liveTitleData.isShowMore());
            this.f28974d.setOnClickListener(new k(aVar, liveSquareBaseData, i11));
        }
    }
}

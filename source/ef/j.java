package ef;

import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.R$id;
import com.hbg.module.livesquare.adapter.RecommendSpeakerAdapter;
import com.hbg.module.livesquare.ui.RecommendSpeakerActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ef.b;
import java.util.List;
import rd.s;

public final class j extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f28966b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f28967c;

    /* renamed from: d  reason: collision with root package name */
    public RecommendSpeakerAdapter f28968d;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f28969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f28970c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j f28971d;

        public a(View view, long j11, j jVar) {
            this.f28969b = view;
            this.f28970c = j11;
            this.f28971d = jVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f28969b) > this.f28970c || (this.f28969b instanceof Checkable)) {
                sVar.e(this.f28969b, currentTimeMillis);
                TextView textView = (TextView) this.f28969b;
                this.f28971d.f28903a.startActivity(new Intent(this.f28971d.f28903a, RecommendSpeakerActivity.class));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public j(View view) {
        super(view);
        this.f28966b = (RecyclerView) view.findViewById(R$id.rvContent);
        this.f28967c = (TextView) view.findViewById(R$id.tvMore);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        super.b(liveSquareBaseData, i11, aVar);
        if (liveSquareBaseData instanceof RecommendSpeakerList) {
            List<RecommendSpeakerList.RecommendSpeakerBean> listData = ((RecommendSpeakerList) liveSquareBaseData).getListData();
            if (!com.hbg.module.libkt.base.ext.b.w(listData)) {
                if (this.f28968d == null) {
                    this.f28968d = new RecommendSpeakerAdapter((FragmentActivity) this.f28903a);
                    this.f28966b.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(this.f28903a));
                    this.f28966b.setAdapter(this.f28968d);
                }
                RecommendSpeakerAdapter recommendSpeakerAdapter = this.f28968d;
                if (recommendSpeakerAdapter != null) {
                    recommendSpeakerAdapter.a(0, listData);
                }
                s sVar = s.f23381a;
                TextView textView = this.f28967c;
                textView.setOnClickListener(new a(textView, 800, this));
            }
        }
    }
}

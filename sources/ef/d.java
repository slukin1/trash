package ef;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryArr;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.livesquare.adapter.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ef.b;
import java.util.ArrayList;

public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f28904b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28905c;

    /* renamed from: d  reason: collision with root package name */
    public a f28906d;

    public d(View view) {
        super(view);
        this.f28904b = (RecyclerView) view.findViewById(R$id.rvCategory);
        this.f28905c = (ImageView) view.findViewById(R$id.ivMore);
    }

    @SensorsDataInstrumented
    public static final void i(d dVar, View view) {
        int i11;
        a aVar = dVar.f28906d;
        if (aVar != null) {
            aVar.n(!(aVar != null ? Boolean.valueOf(aVar.k()) : null).booleanValue());
        }
        ImageView imageView = dVar.f28905c;
        if (dVar.f28906d.k()) {
            i11 = R$drawable.icon_category_up;
        } else {
            i11 = R$drawable.icon_category_down;
        }
        imageView.setImageResource(i11);
        a aVar2 = dVar.f28906d;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        super.b(liveSquareBaseData, i11, aVar);
        if (liveSquareBaseData instanceof LiveCategoryArr) {
            ArrayList<LiveCategoryData> categories = ((LiveCategoryArr) liveSquareBaseData).getCategories();
            if (!com.hbg.module.libkt.base.ext.b.w(categories)) {
                if (this.f28906d == null) {
                    this.f28906d = new a((FragmentActivity) this.f28903a);
                    this.f28904b.setLayoutManager(com.hbg.module.libkt.base.ext.b.k(this.f28903a, 4));
                    this.f28904b.addItemDecoration(com.hbg.module.libkt.base.ext.b.l(4, 4.0f));
                    this.f28904b.setAdapter(this.f28906d);
                }
                a aVar2 = this.f28906d;
                if (aVar2 != null) {
                    aVar2.a(0, categories);
                }
                a aVar3 = this.f28906d;
                if (aVar3 != null) {
                    aVar3.n(true);
                }
                this.f28905c.setImageResource(R$drawable.icon_category_up);
                this.f28905c.setOnClickListener(new c(this));
            }
        }
    }
}

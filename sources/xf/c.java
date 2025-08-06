package xf;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.share.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import he.c;
import java.util.ArrayList;
import kotlin.Unit;
import yf.e;

public final class c extends he.c<ShareGroupList.ShareGroup, c.a<e>> {

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f40655f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public p<? super Boolean, ? super Integer, Unit> f40656g;

    public c(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @SensorsDataInstrumented
    public static final void p(c cVar, ShareGroupList.ShareGroup shareGroup, int i11, View view) {
        cVar.n(shareGroup.groupId, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void q(c cVar, ShareGroupList.ShareGroup shareGroup, int i11, View view) {
        cVar.n(shareGroup.groupId, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String m() {
        int size = this.f40655f.size();
        String str = "";
        for (int i11 = 0; i11 < size; i11++) {
            str = str + this.f40655f.get(i11);
            if (i11 < this.f40655f.size() - 1) {
                str = str + ',';
            }
        }
        return str;
    }

    public final void n(String str, int i11) {
        if (this.f40655f.contains(str)) {
            this.f40655f.remove(str);
        } else if (this.f40655f.size() >= 9) {
            HuobiToastUtil.g(R$string.n_content_share_max_selection);
            return;
        } else {
            this.f40655f.add(str);
        }
        notifyItemChanged(i11);
        p<? super Boolean, ? super Integer, Unit> pVar = this.f40656g;
        if (pVar != null) {
            pVar.invoke(Boolean.valueOf(!b.w(this.f40655f)), Integer.valueOf(i11));
        }
    }

    /* renamed from: o */
    public void onBindViewHolder(c.a<e> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        ShareGroupList.ShareGroup shareGroup = (ShareGroupList.ShareGroup) g().get(i11);
        aVar.e().M(shareGroup);
        aVar.e().B.setChecked(this.f40655f.contains(shareGroup.groupId));
        aVar.e().B.setOnClickListener(new a(this, shareGroup, i11));
        aVar.e().getRoot().setOnClickListener(new b(this, shareGroup, i11));
    }

    /* renamed from: r */
    public c.a<e> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(e.K(h(), viewGroup, false));
    }

    public final void s(p<? super Boolean, ? super Integer, Unit> pVar) {
        this.f40656g = pVar;
    }
}

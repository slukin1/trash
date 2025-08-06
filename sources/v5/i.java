package v5;

import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.lib.common.utils.UtilCollections;

public final /* synthetic */ class i implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLayerKline f60962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f60963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60964c;

    public /* synthetic */ i(BaseLayerKline baseLayerKline, int i11, int i12) {
        this.f60962a = baseLayerKline;
        this.f60963b = i11;
        this.f60964c = i12;
    }

    public final void a(int i11, Object obj) {
        this.f60962a.j1(this.f60963b, this.f60964c, i11, (DataSetIndex) obj);
    }
}

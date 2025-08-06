package v5;

import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.lib.common.utils.UtilCollections;

public final /* synthetic */ class g implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLayerKline f60956a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f60957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60958c;

    public /* synthetic */ g(BaseLayerKline baseLayerKline, int i11, int i12) {
        this.f60956a = baseLayerKline;
        this.f60957b = i11;
        this.f60958c = i12;
    }

    public final void a(int i11, Object obj) {
        this.f60956a.i1(this.f60957b, this.f60958c, i11, (DataSetIndex) obj);
    }
}

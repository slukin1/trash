package v5;

import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.lib.common.utils.UtilCollections;

public final /* synthetic */ class h implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLayerKline f60959a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f60960b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60961c;

    public /* synthetic */ h(BaseLayerKline baseLayerKline, int i11, int i12) {
        this.f60959a = baseLayerKline;
        this.f60960b = i11;
        this.f60961c = i12;
    }

    public final void a(int i11, Object obj) {
        this.f60959a.k1(this.f60960b, this.f60961c, i11, (DataSetIndex) obj);
    }
}

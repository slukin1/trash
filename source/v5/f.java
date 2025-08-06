package v5;

import com.hbg.component.kline.render.layer.BaseLayerKline;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public final /* synthetic */ class f implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLayerKline f60955a;

    public /* synthetic */ f(BaseLayerKline baseLayerKline) {
        this.f60955a = baseLayerKline;
    }

    public final void a(int i11, Object obj) {
        this.f60955a.m1(i11, (KlineInfo) obj);
    }
}

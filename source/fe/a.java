package fe;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.module.kline.view.DrawDepthChart;

public final /* synthetic */ class a implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawDepthChart f54482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Canvas f54483b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RectF f54484c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f54485d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f54486e;

    public /* synthetic */ a(DrawDepthChart drawDepthChart, Canvas canvas, RectF rectF, float f11, float f12) {
        this.f54482a = drawDepthChart;
        this.f54483b = canvas;
        this.f54484c = rectF;
        this.f54485d = f11;
        this.f54486e = f12;
    }

    public final void a(int i11, Object obj) {
        this.f54482a.r(this.f54483b, this.f54484c, this.f54485d, this.f54486e, i11, (DrawDepthChart.a) obj);
    }
}

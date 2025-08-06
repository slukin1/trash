package yb;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final C0889a f85065b;

    /* renamed from: c  reason: collision with root package name */
    public final int f85066c;

    /* renamed from: yb.a$a  reason: collision with other inner class name */
    public interface C0889a {
        void a(int i11, View view);
    }

    public a(C0889a aVar, int i11) {
        this.f85065b = aVar;
        this.f85066c = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.f85065b.a(this.f85066c, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

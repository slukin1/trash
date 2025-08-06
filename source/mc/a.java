package mc;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final C0130a f19343b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19344c;

    /* renamed from: mc.a$a  reason: collision with other inner class name */
    public interface C0130a {
        void a(int i11, View view);
    }

    public a(C0130a aVar, int i11) {
        this.f19343b = aVar;
        this.f19344c = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.f19343b.a(this.f19344c, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

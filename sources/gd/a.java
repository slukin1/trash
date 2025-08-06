package gd;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final C0187a f22795b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22796c;

    /* renamed from: gd.a$a  reason: collision with other inner class name */
    public interface C0187a {
        void a(int i11, View view);
    }

    public a(C0187a aVar, int i11) {
        this.f22795b = aVar;
        this.f22796c = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.f22795b.a(this.f22796c, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

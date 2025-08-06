package jl;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final C0808a f76226b;

    /* renamed from: c  reason: collision with root package name */
    public final int f76227c;

    /* renamed from: jl.a$a  reason: collision with other inner class name */
    public interface C0808a {
        void a(int i11, View view);
    }

    public a(C0808a aVar, int i11) {
        this.f76226b = aVar;
        this.f76227c = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.f76226b.a(this.f76227c, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

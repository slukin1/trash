package zf;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final C0554a f40681b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40682c;

    /* renamed from: zf.a$a  reason: collision with other inner class name */
    public interface C0554a {
        void a(int i11, View view);
    }

    public a(C0554a aVar, int i11) {
        this.f40681b = aVar;
        this.f40682c = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.f40681b.a(this.f40682c, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

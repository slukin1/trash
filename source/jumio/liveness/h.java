package jumio.liveness;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.liveness.DaClient;
import com.jumio.liveness.IEventHandler;
import d10.a;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class h extends Lambda implements a<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f56472a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56473b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56474c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f56475d = "face_finder";

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ IEventHandler f56476e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ByteBuffer byteBuffer, String str, String str2, IEventHandler iEventHandler) {
        super(0);
        this.f56472a = byteBuffer;
        this.f56473b = str;
        this.f56474c = str2;
        this.f56476e = iEventHandler;
    }

    public final Object invoke() {
        if (DaClient.initCompat(this.f56472a, this.f56473b, this.f56474c, this.f56475d, this.f56476e)) {
            DaClient.startCompat();
            DaClient.sendEvent(System.currentTimeMillis(), DaClient.EVENT_START_SESSION, (String) null, (String) null);
            DaClient.sendEvent(System.currentTimeMillis(), DaClient.EVENT_POSE_START, (String) null, (String) null);
        } else {
            Log.w("LivenessExtractionClient", "Failed to start liveness!");
            Analytics.Companion.add(MobileEvents.misc$default("livenessAssetsLoadingFailed", (MetaInfo) null, 2, (Object) null));
        }
        return Unit.f56620a;
    }
}

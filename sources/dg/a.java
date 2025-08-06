package dg;

import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.service.DetectorSession;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DetectTypeEnum f40473b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DetectorSession f40474c;

    public a(DetectorSession detectorSession, DetectTypeEnum detectTypeEnum) {
        this.f40474c = detectorSession;
        this.f40473b = detectTypeEnum;
    }

    public void run() {
        if (this.f40474c.f37592g != null) {
            this.f40474c.f37592g.onDetectChange(this.f40473b);
        }
    }
}

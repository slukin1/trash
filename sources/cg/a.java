package cg;

import com.huawei.face.antispoofing.jni.ErrorCodeEnum;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ErrorCodeEnum f37413b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FaceAntispoofingSdk f37414c;

    public a(FaceAntispoofingSdk faceAntispoofingSdk, ErrorCodeEnum errorCodeEnum) {
        this.f37414c = faceAntispoofingSdk;
        this.f37413b = errorCodeEnum;
    }

    public void run() {
        this.f37414c.f37575c.onDetecting(this.f37413b.getCode(), "");
    }
}

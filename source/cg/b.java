package cg;

import com.huawei.face.antispoofing.jni.ErrorCodeEnum;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;

public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ErrorCodeEnum f37415b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37416c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FaceAntispoofingSdk f37417d;

    public b(FaceAntispoofingSdk faceAntispoofingSdk, ErrorCodeEnum errorCodeEnum, String str) {
        this.f37417d = faceAntispoofingSdk;
        this.f37415b = errorCodeEnum;
        this.f37416c = str;
    }

    public void run() {
        this.f37417d.f37575c.onDetecting(this.f37415b.getCode(), this.f37416c);
    }
}

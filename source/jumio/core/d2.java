package jumio.core;

import java.util.Arrays;
import java.util.List;

public enum d2 {
    BARCODE_NATIVE("com.jumio.core.extraction.barcode.vision.BarcodeVisionPlugin", new c2[0]),
    DATADOG("com.jumio.datadog.DataDogPlugin", c2.DATADOG),
    DOCFINDER("com.jumio.core.extraction.docfinder.DocFinderPlugin", new c2[0]),
    EMULATOR("com.jumio.emulator.EmulatorPlugin", new c2[0]),
    FACE_IPROOV("com.jumio.iproov.IproovPlugin", c2.IPROOV),
    FACE_MANUAL("com.jumio.core.extraction.facemanual.FaceManualPlugin", new c2[0]),
    MANUAL("com.jumio.core.extraction.manual.ManualPicturePlugin", new c2[0]),
    NFC("com.jumio.core.extraction.nfc.NfcPlugin", c2.JMRTD, c2.BOUNCYCASTLE, c2.SCUBA),
    SARDINE("com.jumio.devicerisk.DeviceRiskPlugin", new c2[0]),
    DIGITAL_IDENTITY("com.jumio.digitalidentity.DigitalIdentityPlugin", new c2[0]),
    JUMIO_LIVENESS("com.jumio.liveness.LivenessPlugin", new c2[0]),
    CAMERA_X("com.jumio.camerax.CameraXManager", new c2[0]);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f56173a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c2> f56174b;

    /* access modifiers changed from: public */
    d2(String str, c2... c2VarArr) {
        this.f56173a = str;
        this.f56174b = CollectionsKt__CollectionsKt.n(Arrays.copyOf(c2VarArr, c2VarArr.length));
    }
}

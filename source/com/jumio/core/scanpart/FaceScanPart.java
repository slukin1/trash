package com.jumio.core.scanpart;

import android.view.LayoutInflater;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jumio.core.Controller;
import com.jumio.core.R;
import com.jumio.core.api.BackendManager;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.UploadType;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.face.FaceHelpAnimation;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.views.JumioAnimationView;
import kotlin.l;

public class FaceScanPart<T extends FaceScanPartModel> extends JVisionScanPart<T> {

    /* renamed from: q  reason: collision with root package name */
    public final JumioCameraFacing[] f39470q = {JumioCameraFacing.FRONT};

    public FaceScanPart(Controller controller, JumioFaceCredential jumioFaceCredential, T t11, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioFaceCredential, CollectionsKt__CollectionsJVMKt.e(t11), jumioScanPartInterface);
    }

    public void getHelpAnimation(JumioAnimationView jumioAnimationView) {
        jumioAnimationView.removeAllViews();
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(jumioAnimationView.getContext()).inflate(R.layout.jumio_face_custom_animation, jumioAnimationView, false);
        jumioAnimationView.addView(constraintLayout);
        FaceHelpAnimation faceHelpAnimation = new FaceHelpAnimation(getController().getContext());
        faceHelpAnimation.configure((MotionLayout) constraintLayout.findViewById(R.id.face_help_animation), false);
        faceHelpAnimation.applyCustomizations(jumioAnimationView.getContext());
        if (DeviceUtilKt.getDeviceUtil().areAnimationsEnabled(jumioAnimationView.getContext())) {
            faceHelpAnimation.start();
        }
        jumioAnimationView.setTag(faceHelpAnimation);
    }

    public int getPreferredBrandTextColor() {
        return R.color.jumio_gray_12;
    }

    public JumioCameraFacing[] getSupportedFacing() {
        return this.f39470q;
    }

    public void reset() {
        ((FaceScanPartModel) getScanPartModel()).setLivenessData((LivenessDataModel) null);
        super.reset();
    }

    public void onResult(StaticModel staticModel) {
        LivenessDataModel livenessDataModel = staticModel instanceof LivenessDataModel ? (LivenessDataModel) staticModel : null;
        if (livenessDataModel != null) {
            ((FaceScanPartModel) getScanPartModel()).setLivenessData(livenessDataModel);
            super.onResult(staticModel);
            if (((FaceScanPartModel) getScanPartModel()).getMode() == ScanMode.FACE_MANUAL) {
                BackendManager.uploadRawData$default(getController().getBackendManager(), getCredential(), MapsKt__MapsKt.j(l.a(UploadType.LIVENESS_SERIES, livenessDataModel)), (String) null, 4, (Object) null);
            }
        }
    }
}

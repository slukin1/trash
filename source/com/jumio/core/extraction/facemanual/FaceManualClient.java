package com.jumio.core.extraction.facemanual;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.MobileContext;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.liveness.extraction.FaceManualSequenceCache;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.util.QAKt;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FaceManualClient extends ExtractionClient {

    /* renamed from: u  reason: collision with root package name */
    public final AtomicBoolean f39189u = new AtomicBoolean(false);

    /* renamed from: v  reason: collision with root package name */
    public final AtomicBoolean f39190v = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    public FaceManualSequenceCache f39191w;

    public FaceManualClient(Context context) {
        super(context);
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        this.f39191w = new FaceManualSequenceCache(getContext(), ((MobileContext) getContext()).getSessionKey(), ((SettingsModel) dataManager.get(SettingsModel.class)).getMaxLivenessImages(), 60);
    }

    public Size getPreferredPreviewSize() {
        return new Size(1280, 720);
    }

    public void init() {
        super.init();
        this.f39189u.set(false);
        this.f39190v.set(false);
        FaceManualSequenceCache faceManualSequenceCache = this.f39191w;
        if (faceManualSequenceCache != null) {
            faceManualSequenceCache.setActive(true);
        }
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        boolean z11 = true;
        try {
            FaceManualSequenceCache faceManualSequenceCache = this.f39191w;
            if (faceManualSequenceCache != null) {
                faceManualSequenceCache.addSync(imageSource, previewProperties, metaData, rect);
            }
            if (!this.f39189u.get() || this.f39190v.get()) {
                this.f39189u.set(false);
                z11 = false;
                System.gc();
                setResult(z11);
            }
            this.f39190v.set(true);
            ExtractionUpdateInterface.Companion companion = ExtractionUpdateInterface.Companion;
            publishUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(companion, ExtractionUpdateState.shotTaken, (Object) null, (MetaInfo) null, 4, (Object) null));
            QAKt.getQA().getClass();
            publishUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(companion, ExtractionUpdateState.saveImage, CameraUtils.INSTANCE.yuv2bitmap(imageSource, previewProperties, metaData, rect, -1), (MetaInfo) null, 4, (Object) null));
            LivenessDataModel livenessDataModel = new LivenessDataModel();
            livenessDataModel.setType(ScanMode.FACE_MANUAL);
            FaceManualSequenceCache faceManualSequenceCache2 = this.f39191w;
            livenessDataModel.setFrames(faceManualSequenceCache2 != null ? faceManualSequenceCache2.finish() : null);
            livenessDataModel.setPassed((Boolean) null);
            publishResult((StaticModel) livenessDataModel);
            System.gc();
            setResult(z11);
        } catch (Exception e11) {
            Log.w("ImageCheck", "computeFocusConfidence failed!", (Throwable) e11);
        }
    }

    public boolean shouldFeed() {
        return !this.f39190v.get();
    }

    public void takePicture() {
        if (getDataExtraction()) {
            this.f39189u.set(true);
        }
    }

    public boolean takePictureManually() {
        return true;
    }
}

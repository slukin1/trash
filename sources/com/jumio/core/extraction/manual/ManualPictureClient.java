package com.jumio.core.extraction.manual;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.PhysicalIdScanPartModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.util.QAKt;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;

public final class ManualPictureClient extends ExtractionClient {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: u  reason: collision with root package name */
    public final AtomicBoolean f39212u = new AtomicBoolean(false);

    /* renamed from: v  reason: collision with root package name */
    public final AtomicBoolean f39213v = new AtomicBoolean(false);

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public ManualPictureClient(Context context) {
        super(context);
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        PhysicalIdScanPartModel physicalIdScanPartModel = staticModel instanceof PhysicalIdScanPartModel ? (PhysicalIdScanPartModel) staticModel : null;
        if (physicalIdScanPartModel != null) {
            setCenterCropExtractionArea(physicalIdScanPartModel.getFormat() != DocumentFormat.NONE);
        }
    }

    public void init() {
        super.init();
        this.f39212u.set(false);
        this.f39213v.set(false);
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        boolean z11 = true;
        try {
            if (!this.f39212u.get() || this.f39213v.get()) {
                this.f39212u.set(false);
                z11 = false;
                imageSource.delete();
                setResult(z11);
            }
            this.f39213v.set(true);
            ExtractionUpdateInterface.Companion companion = ExtractionUpdateInterface.Companion;
            publishUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(companion, ExtractionUpdateState.shotTaken, (Object) null, (MetaInfo) null, 4, (Object) null));
            QAKt.getQA().getClass();
            publishUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(companion, ExtractionUpdateState.saveImage, CameraUtils.INSTANCE.getBitmap(imageSource, previewProperties, metaData, rect), (MetaInfo) null, 4, (Object) null));
            publishResult((StaticModel) null);
            System.gc();
            imageSource.delete();
            setResult(z11);
        } catch (Exception e11) {
            Log.w("ManualPictureClient", "computeFocusConfidence failed!", (Throwable) e11);
        }
    }

    public boolean shouldFeed() {
        return !this.f39213v.get();
    }

    public void takePicture() {
        if (getDataExtraction()) {
            this.f39212u.set(true);
        }
    }

    public boolean takePictureManually() {
        return true;
    }
}

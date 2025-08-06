package com.jumio.core.extraction.manual;

import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.environment.Environment;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.JVisionOverlay;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.ExtractionPlugin;

public final class ManualPicturePlugin implements ExtractionPlugin {

    /* renamed from: a  reason: collision with root package name */
    public final String f39214a = Environment.BUILD_VERSION;

    public ExtractionClient getExtractionClient(MobileContext mobileContext) {
        return new ManualPictureClient(mobileContext);
    }

    public Overlay getOverlay(MobileContext mobileContext) {
        JVisionOverlay jVisionOverlay = new JVisionOverlay(mobileContext);
        jVisionOverlay.useCenterCrop = true;
        return jVisionOverlay;
    }

    public String getVersion() {
        return this.f39214a;
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        return ExtractionPlugin.DefaultImpls.isUsable(this, controller, scanPartModel);
    }

    public void preload(Controller controller) {
        ExtractionPlugin.DefaultImpls.preload(this, controller);
    }

    public void unload() {
        ExtractionPlugin.DefaultImpls.unload(this);
    }
}

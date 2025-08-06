package com.jumio.liveness;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.cdn.CDNEncryptedEntry;
import com.jumio.core.cdn.CDNFeatureModel;
import com.jumio.core.environment.Environment;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.LivenessScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.TimeoutModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import jumio.liveness.e;
import jumio.liveness.l;
import jumio.liveness.q;

public final class LivenessPlugin implements ExtractionPlugin, ScanPartPlugin {
    public static final a Companion = new a();
    public static final String LIVENESS_ASSETS = "livenessAssets";
    private final String version = Environment.BUILD_VERSION;

    public static final class a {
    }

    public ExtractionClient getExtractionClient(MobileContext mobileContext) {
        return new e(mobileContext);
    }

    public Overlay getOverlay(MobileContext mobileContext) {
        return new l(mobileContext);
    }

    public <T extends ScanPartModel> ScanPart<?> getScanPart(Controller controller, JumioCredential jumioCredential, T t11, JumioScanPartInterface jumioScanPartInterface) {
        if (!(jumioCredential instanceof JumioFaceCredential)) {
            String simpleName = JumioFaceCredential.class.getSimpleName();
            throw new IllegalArgumentException(("Credential needs to be instance of " + simpleName).toString());
        } else if (t11 instanceof LivenessScanPartModel) {
            return new q(controller, (JumioFaceCredential) jumioCredential, (LivenessScanPartModel) t11, jumioScanPartInterface);
        } else {
            String simpleName2 = LivenessScanPartModel.class.getSimpleName();
            throw new IllegalArgumentException(("ScanPartModel needs to be instance of " + simpleName2).toString());
        }
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        return ExtractionPlugin.DefaultImpls.isUsable(this, controller, scanPartModel);
    }

    public void preload(Controller controller) {
        ExtractionPlugin.DefaultImpls.preload(this, controller);
        Log.i("LivenessPlugin", "Preloading LivenessPlugin");
        CDNFeatureModel cDNFeatureModel = (CDNFeatureModel) controller.getDataManager().get(CDNFeatureModel.class);
        cDNFeatureModel.load(LIVENESS_ASSETS, ((TimeoutModel) controller.getDataManager().get(TimeoutModel.class)).getCdn());
        CDNEncryptedEntry cDNEncryptedEntry = cDNFeatureModel.get(LIVENESS_ASSETS);
        boolean z11 = true;
        if (cDNEncryptedEntry == null || !cDNEncryptedEntry.isAssetFile()) {
            z11 = false;
        }
        if (z11) {
            Analytics.Companion.add(MobileEvents.misc$default("livenessAssetsInBundle", (MetaInfo) null, 2, (Object) null));
        }
    }

    public void unload() {
        ExtractionPlugin.DefaultImpls.unload(this);
    }
}

package com.jumio.core.plugins;

import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;

public interface ExtractionPlugin extends Plugin {

    public static final class DefaultImpls {
        public static boolean isUsable(ExtractionPlugin extractionPlugin, Controller controller, ScanPartModel scanPartModel) {
            return Plugin.DefaultImpls.isUsable(extractionPlugin, controller, scanPartModel);
        }

        public static void preload(ExtractionPlugin extractionPlugin, Controller controller) {
            Plugin.DefaultImpls.preload(extractionPlugin, controller);
        }

        public static void unload(ExtractionPlugin extractionPlugin) {
            Plugin.DefaultImpls.unload(extractionPlugin);
        }
    }

    ExtractionClient getExtractionClient(MobileContext mobileContext);

    Overlay getOverlay(MobileContext mobileContext);
}

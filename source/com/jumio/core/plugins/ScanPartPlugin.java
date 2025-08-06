package com.jumio.core.plugins;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.Plugin;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;

public interface ScanPartPlugin extends Plugin {

    public static final class DefaultImpls {
        public static boolean isUsable(ScanPartPlugin scanPartPlugin, Controller controller, ScanPartModel scanPartModel) {
            return Plugin.DefaultImpls.isUsable(scanPartPlugin, controller, scanPartModel);
        }

        public static void preload(ScanPartPlugin scanPartPlugin, Controller controller) {
            Plugin.DefaultImpls.preload(scanPartPlugin, controller);
        }

        public static void unload(ScanPartPlugin scanPartPlugin) {
            Plugin.DefaultImpls.unload(scanPartPlugin);
        }
    }

    <T extends ScanPartModel> ScanPart<?> getScanPart(Controller controller, JumioCredential jumioCredential, T t11, JumioScanPartInterface jumioScanPartInterface);
}

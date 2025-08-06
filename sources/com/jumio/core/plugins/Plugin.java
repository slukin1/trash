package com.jumio.core.plugins;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;

public interface Plugin {

    public static final class DefaultImpls {
        public static boolean isUsable(Plugin plugin, Controller controller, ScanPartModel scanPartModel) {
            return true;
        }

        public static void preload(Plugin plugin, Controller controller) {
        }

        public static void unload(Plugin plugin) {
        }
    }

    String getVersion();

    boolean isUsable(Controller controller, ScanPartModel scanPartModel);

    void preload(Controller controller);

    void unload();
}

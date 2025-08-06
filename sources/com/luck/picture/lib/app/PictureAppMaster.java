package com.luck.picture.lib.app;

import android.content.Context;
import com.luck.picture.lib.engine.PictureSelectorEngine;

public class PictureAppMaster implements IApp {
    private static PictureAppMaster mInstance;
    private IApp app;

    private PictureAppMaster() {
    }

    public static PictureAppMaster getInstance() {
        if (mInstance == null) {
            synchronized (PictureAppMaster.class) {
                if (mInstance == null) {
                    mInstance = new PictureAppMaster();
                }
            }
        }
        return mInstance;
    }

    public IApp getApp() {
        return this.app;
    }

    public Context getAppContext() {
        IApp iApp = this.app;
        if (iApp == null) {
            return null;
        }
        return iApp.getAppContext();
    }

    public PictureSelectorEngine getPictureSelectorEngine() {
        IApp iApp = this.app;
        if (iApp == null) {
            return null;
        }
        return iApp.getPictureSelectorEngine();
    }

    public void setApp(IApp iApp) {
        this.app = iApp;
    }
}

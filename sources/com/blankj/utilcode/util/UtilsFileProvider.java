package com.blankj.utilcode.util;

import android.app.Application;
import androidx.core.content.FileProvider;

public class UtilsFileProvider extends FileProvider {
    public boolean onCreate() {
        Utils.b((Application) getContext().getApplicationContext());
        return true;
    }
}

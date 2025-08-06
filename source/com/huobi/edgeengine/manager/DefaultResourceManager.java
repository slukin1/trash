package com.huobi.edgeengine.manager;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import rj.b;
import uj.a;

public class DefaultResourceManager implements a {
    public InputStream a(b bVar, Context context, String str) {
        try {
            AssetManager assets = context.getAssets();
            return assets.open(bVar.f() + str);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}

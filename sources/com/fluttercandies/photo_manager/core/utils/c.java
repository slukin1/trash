package com.fluttercandies.photo_manager.core.utils;

import android.net.Uri;
import android.provider.MediaStore;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f65119a = new c();

    public final int a(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 2;
        }
        return 3;
    }

    public final Uri b(String str, int i11) {
        return Uri.withAppendedPath(c(i11), str);
    }

    public final Uri c(int i11) {
        if (i11 == 1) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (i11 == 2) {
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (i11 != 3) {
            return IDBUtils.f65111a.a();
        }
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }
}

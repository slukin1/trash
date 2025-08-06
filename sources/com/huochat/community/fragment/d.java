package com.huochat.community.fragment;

import android.media.MediaScannerConnection;
import android.net.Uri;

public final /* synthetic */ class d implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentPicturePreview f38691a;

    public /* synthetic */ d(FragmentPicturePreview fragmentPicturePreview) {
        this.f38691a = fragmentPicturePreview;
    }

    public final void onScanCompleted(String str, Uri uri) {
        FragmentPicturePreview.scanGalleryImg$lambda$3(this.f38691a, str, uri);
    }
}

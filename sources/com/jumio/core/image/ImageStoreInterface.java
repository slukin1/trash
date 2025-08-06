package com.jumio.core.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.ImageSource;

public interface ImageStoreInterface {
    void add(ImageData imageData, ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect);

    void configure(AuthorizationModel.SessionKey sessionKey, Bitmap.CompressFormat compressFormat, int i11, String str, String str2);

    void delete(ImageData imageData);

    void start();

    void stop(boolean z11);
}

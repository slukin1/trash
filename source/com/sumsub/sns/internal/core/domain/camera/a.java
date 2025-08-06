package com.sumsub.sns.internal.core.domain.camera;

import androidx.camera.core.ImageProxy;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.c;

public interface a {
    Object a(ImageProxy imageProxy, c cVar, c<? super Unit> cVar2);

    void a(CameraX.c cVar);

    void a(File file);

    void b(File file);

    void c();

    void onError(Exception exc);
}

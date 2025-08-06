package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.hardware.Camera;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class f implements e {

    public static final class a extends Lambda implements d10.a<List<? extends d>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f34602a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar) {
            super(0);
            this.f34602a = fVar;
        }

        /* renamed from: a */
        public final List<d> invoke() {
            return this.f34602a.a();
        }
    }

    public final String a(int i11) {
        return i11 != 0 ? i11 != 1 ? "" : "front" : "back";
    }

    public List<d> getCameraInfo() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }

    public final List<d> a() {
        int numberOfCameras = Camera.getNumberOfCameras();
        LinkedList linkedList = new LinkedList();
        for (int i11 = 0; i11 < numberOfCameras; i11++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i11, cameraInfo);
            linkedList.add(new d(String.valueOf(i11), a(cameraInfo.facing), String.valueOf(cameraInfo.orientation)));
        }
        return linkedList;
    }
}

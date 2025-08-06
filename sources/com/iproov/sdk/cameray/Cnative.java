package com.iproov.sdk.cameray;

import android.media.Image;
import com.iproov.sdk.cameray.Cimport;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.cameray.native  reason: invalid class name */
class Cnative implements Cimport {

    /* renamed from: do  reason: not valid java name */
    private final Image f129do;

    /* renamed from: for  reason: not valid java name */
    private final Map<Cimport.Cdo, ByteBuffer> f130for = new HashMap();

    /* renamed from: if  reason: not valid java name */
    private final Map<Cimport.Cdo, Image.Plane> f131if = new HashMap();

    public Cnative(Image image) {
        this.f129do = image;
        for (Cimport.Cdo doVar : Cimport.Cdo.values()) {
            this.f131if.put(doVar, image.getPlanes()[doVar.ordinal()]);
            this.f130for.put(doVar, image.getPlanes()[doVar.ordinal()].getBuffer());
        }
    }

    /* renamed from: do  reason: not valid java name */
    public int m185do() {
        return this.f129do.getWidth();
    }

    /* renamed from: if  reason: not valid java name */
    public int m188if() {
        return this.f129do.getHeight();
    }

    /* renamed from: do  reason: not valid java name */
    public void m187do(Cimport.Cdo doVar, int i11, byte[] bArr, int i12, int i13) {
        ByteBuffer byteBuffer = this.f130for.get(doVar);
        byteBuffer.position(i11);
        byteBuffer.get(bArr, i12, i13);
    }

    /* renamed from: if  reason: not valid java name */
    public int m189if(Cimport.Cdo doVar) {
        return this.f131if.get(doVar).getRowStride();
    }

    /* renamed from: do  reason: not valid java name */
    public byte m184do(Cimport.Cdo doVar, int i11) {
        return this.f130for.get(doVar).get(i11);
    }

    /* renamed from: do  reason: not valid java name */
    public int m186do(Cimport.Cdo doVar) {
        return this.f131if.get(doVar).getPixelStride();
    }
}

package com.jumio.core.extraction;

import android.graphics.Bitmap;
import com.jumio.core.model.StaticModel;
import com.jumio.core.model.SubscriberWithUpdate;
import d10.p;

final class SubExtractionSubscriber implements SubscriberWithUpdate<ExtractionUpdateInterface<?>, StaticModel> {

    /* renamed from: a  reason: collision with root package name */
    public final p<? super StaticModel, ? super StaticModel, ? extends StaticModel> f39185a;

    /* renamed from: b  reason: collision with root package name */
    public StaticModel f39186b;

    /* renamed from: c  reason: collision with root package name */
    public ExtractionUpdateInterface<?> f39187c;

    /* renamed from: d  reason: collision with root package name */
    public Throwable f39188d;

    public SubExtractionSubscriber(p<? super StaticModel, ? super StaticModel, ? extends StaticModel> pVar) {
        this.f39185a = pVar;
    }

    public void onError(Throwable th2) {
        this.f39188d = th2;
    }

    public void onResult(StaticModel staticModel) {
        this.f39186b = staticModel;
    }

    public void onUpdate(ExtractionUpdateInterface<?> extractionUpdateInterface) {
        this.f39187c = extractionUpdateInterface;
        Integer state = extractionUpdateInterface.getState();
        int i11 = ExtractionUpdateState.saveImage;
        if (state != null && state.intValue() == i11) {
            ((Bitmap) extractionUpdateInterface.getData()).recycle();
        }
    }
}

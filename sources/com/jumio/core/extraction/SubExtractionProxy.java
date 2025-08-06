package com.jumio.core.extraction;

import android.graphics.Rect;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.core.model.StaticModel;
import com.jumio.core.persistence.DataManager;
import d10.p;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SubExtractionProxy {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f39183a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f39184b;

    public final void add(ExtractionClient extractionClient, p<? super StaticModel, ? super StaticModel, ? extends StaticModel> pVar) {
        SubExtractionSubscriber subExtractionSubscriber = new SubExtractionSubscriber(pVar);
        extractionClient.setSubExtraction(true);
        this.f39183a.put(extractionClient, subExtractionSubscriber);
        extractionClient.subscribe(subExtractionSubscriber);
    }

    public final void cancel() {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).cancel();
        }
    }

    public final void configure(DataManager dataManager, StaticModel staticModel) {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).configure(dataManager, staticModel);
        }
    }

    public final void destroy() {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).destroy();
        }
    }

    public final void feed(Frame frame) {
        if (this.f39184b) {
            for (Map.Entry key : this.f39183a.entrySet()) {
                ((ExtractionClient) key.getKey()).feed(frame);
            }
        }
    }

    public final boolean getActive() {
        return this.f39184b;
    }

    public final boolean getAreConfigured() {
        LinkedHashMap linkedHashMap = this.f39183a;
        if (!linkedHashMap.isEmpty()) {
            for (Map.Entry key : linkedHashMap.entrySet()) {
                if (!((ExtractionClient) key.getKey()).isConfigured()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final StaticModel mergeResult(StaticModel staticModel) {
        for (Map.Entry value : this.f39183a.entrySet()) {
            SubExtractionSubscriber subExtractionSubscriber = (SubExtractionSubscriber) value.getValue();
            staticModel = (StaticModel) subExtractionSubscriber.f39185a.invoke(staticModel, subExtractionSubscriber.f39186b);
        }
        return staticModel;
    }

    public final void reinit() {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).reinit();
        }
    }

    public final void remove(ExtractionClient extractionClient) {
        this.f39183a.remove(extractionClient);
    }

    public final void setActive(boolean z11) {
        if (z11 != this.f39184b && !z11) {
            for (Map.Entry entry : this.f39183a.entrySet()) {
                ((SubExtractionSubscriber) entry.getValue()).f39186b = null;
                ((ExtractionClient) entry.getKey()).reinit();
            }
        }
        this.f39184b = z11;
    }

    public final void setDataExtraction(boolean z11) {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).setDataExtraction(z11);
        }
    }

    public final void setExtractionArea(Rect rect) {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).setExtractionArea(rect);
        }
    }

    public final void setPreviewProperties(PreviewProperties previewProperties) {
        for (Map.Entry key : this.f39183a.entrySet()) {
            ((ExtractionClient) key.getKey()).setPreviewProperties(previewProperties);
        }
    }
}

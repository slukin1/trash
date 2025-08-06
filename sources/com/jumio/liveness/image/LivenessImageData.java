package com.jumio.liveness.image;

import com.jumio.commons.camera.ImageData;
import com.jumio.core.extraction.JumioRect;
import com.jumio.liveness.DaClient;
import com.jumio.liveness.dto.Pitch;
import com.jumio.liveness.dto.Yaw;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import org.json.JSONObject;

public final class LivenessImageData extends ImageData {

    /* renamed from: a  reason: collision with root package name */
    public Integer f24949a;

    /* renamed from: b  reason: collision with root package name */
    public JumioRect f24950b;

    /* renamed from: c  reason: collision with root package name */
    public Pitch f24951c;

    /* renamed from: d  reason: collision with root package name */
    public Yaw f24952d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24953e;

    public void clear() {
        super.clear();
        this.f24949a = null;
        this.f24950b = null;
        this.f24951c = null;
        this.f24952d = null;
        this.f24953e = false;
    }

    public final boolean getBestSelfie() {
        return this.f24953e;
    }

    public final Integer getIod() {
        return this.f24949a;
    }

    public final Pitch getPseudoPitch() {
        return this.f24951c;
    }

    public final Yaw getPseudoYaw() {
        return this.f24952d;
    }

    public final JumioRect getRoi() {
        return this.f24950b;
    }

    public JSONObject getUploadMetadata(Integer num) {
        JSONObject jSONObject = new JSONObject();
        if (num != null) {
            jSONObject.put(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, num.intValue());
        }
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("bestSelfieShot", this.f24953e);
        Pitch pitch = this.f24951c;
        JSONObject jSONObject2 = null;
        jSONObject.put("pseudoPitch", pitch != null ? pitch.getValue() : null);
        Yaw yaw = this.f24952d;
        jSONObject.put("pseudoYaw", yaw != null ? yaw.getValue() : null);
        jSONObject.put(DaClient.ATTR_IOD, this.f24949a);
        JumioRect jumioRect = this.f24950b;
        if (jumioRect != null) {
            jSONObject2 = jumioRect.toJson();
        }
        jSONObject.put("roi", jSONObject2);
        return jSONObject;
    }

    public final void setBestSelfie(boolean z11) {
        this.f24953e = z11;
    }

    public final void setIod(Integer num) {
        this.f24949a = num;
    }

    public final void setPseudoPitch(Pitch pitch) {
        this.f24951c = pitch;
    }

    public final void setPseudoYaw(Yaw yaw) {
        this.f24952d = yaw;
    }

    public final void setRoi(JumioRect jumioRect) {
        this.f24950b = jumioRect;
    }
}

package com.kakao.sdk.share.model;

import com.fluttercandies.photo_manager.core.entity.a;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/kakao/sdk/share/model/ValidationResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "templateId", "J", "c", "()J", "Lcom/google/gson/JsonObject;", "templateArgs", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "templateMsg", "d", "warningMsg", "e", "argumentMsg", "a", "share_release"}, k = 1, mv = {1, 6, 0})
public final class ValidationResult {
    private final JsonObject argumentMsg;
    private final JsonObject templateArgs;
    private final long templateId;
    private final JsonObject templateMsg;
    private final JsonObject warningMsg;

    public final JsonObject a() {
        return this.argumentMsg;
    }

    public final JsonObject b() {
        return this.templateArgs;
    }

    public final long c() {
        return this.templateId;
    }

    public final JsonObject d() {
        return this.templateMsg;
    }

    public final JsonObject e() {
        return this.warningMsg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidationResult)) {
            return false;
        }
        ValidationResult validationResult = (ValidationResult) obj;
        return this.templateId == validationResult.templateId && x.b(this.templateArgs, validationResult.templateArgs) && x.b(this.templateMsg, validationResult.templateMsg) && x.b(this.warningMsg, validationResult.warningMsg) && x.b(this.argumentMsg, validationResult.argumentMsg);
    }

    public int hashCode() {
        int a11 = a.a(this.templateId) * 31;
        JsonObject jsonObject = this.templateArgs;
        int i11 = 0;
        int hashCode = (((a11 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31) + this.templateMsg.hashCode()) * 31;
        JsonObject jsonObject2 = this.warningMsg;
        int hashCode2 = (hashCode + (jsonObject2 == null ? 0 : jsonObject2.hashCode())) * 31;
        JsonObject jsonObject3 = this.argumentMsg;
        if (jsonObject3 != null) {
            i11 = jsonObject3.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "ValidationResult(templateId=" + this.templateId + ", templateArgs=" + this.templateArgs + ", templateMsg=" + this.templateMsg + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ')';
    }
}

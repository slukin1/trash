package com.kakao.sdk.template.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/kakao/sdk/template/model/IdType;", "", "(Ljava/lang/String;I)V", "value", "", "getValue", "()Ljava/lang/String;", "EVENT", "CALENDAR", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum IdType {
    EVENT,
    CALENDAR;

    public final String getValue() {
        return ((SerializedName) IdType.class.getField(name()).getAnnotation(SerializedName.class)).value();
    }
}

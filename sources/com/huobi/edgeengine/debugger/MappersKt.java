package com.huobi.edgeengine.debugger;

import d10.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import kotlin.text.g;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a$\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002\"\u0014\u0010\n\u001a\u00020\u00038\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lorg/json/JSONObject;", "from", "", "", "scriptMap", "c", "scriptId", "d", "a", "Ljava/lang/String;", "scriptsDomain", "b", "()Ljava/lang/String;", "scriptsUrlBase", "edgeengine_release"}, k = 2, mv = {1, 5, 1})
public final class MappersKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43976a = "http://app/";

    public static final String b() {
        return x.i(f43976a, r.f44050a.k());
    }

    public static final JSONObject c(JSONObject jSONObject, Map<String, String> map) {
        return new JSONObject(new Regex("\"scriptId\":\"(\\d+)\"").replace((CharSequence) jSONObject.toString(), (l<? super g, ? extends CharSequence>) new MappersKt$replaceScriptId$to$1(map)));
    }

    public static final String d(String str) {
        return x.i(b(), str);
    }
}

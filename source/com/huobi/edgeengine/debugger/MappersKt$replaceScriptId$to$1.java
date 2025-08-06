package com.huobi.edgeengine.debugger;

import d10.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.text.e;
import kotlin.text.g;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/text/g;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class MappersKt$replaceScriptId$to$1 extends Lambda implements l<g, CharSequence> {
    public final /* synthetic */ Map<String, String> $scriptMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MappersKt$replaceScriptId$to$1(Map<String, String> map) {
        super(1);
        this.$scriptMap = map;
    }

    public final CharSequence invoke(g gVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\"scriptId\":\"");
        Map<String, String> map = this.$scriptMap;
        e eVar = gVar.a().get(1);
        sb2.append(map.get(eVar == null ? null : eVar.a()));
        sb2.append('\"');
        return sb2.toString();
    }
}

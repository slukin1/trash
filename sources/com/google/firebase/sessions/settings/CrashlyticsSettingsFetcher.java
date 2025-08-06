package com.google.firebase.sessions.settings;

import d10.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001Jo\u0010\u000b\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "", "", "", "headerOptions", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lkotlin/coroutines/c;", "", "onSuccess", "onFailure", "doConfigFetch", "(Ljava/util/Map;Ld10/p;Ld10/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public interface CrashlyticsSettingsFetcher {
    Object doConfigFetch(Map<String, String> map, p<? super JSONObject, ? super c<? super Unit>, ? extends Object> pVar, p<? super String, ? super c<? super Unit>, ? extends Object> pVar2, c<? super Unit> cVar);
}

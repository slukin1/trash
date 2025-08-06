package com.huobi.edgeengine.debugger;

import com.eclipsesource.v8.V8;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import org.json.JSONObject;
import tj.b;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/huobi/edgeengine/debugger/t;", "", "Ljava/util/concurrent/ExecutorService;", "v8Executor", "", "globalAlias", "", "enableLogging", "Ljava/util/concurrent/Future;", "Lcom/eclipsesource/v8/V8;", "b", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f44059a = new t();

    public static final V8 c(String str, ExecutorService executorService) {
        V8 createV8Runtime = V8.createV8Runtime(str);
        V8Messenger v8Messenger = new V8Messenger(createV8Runtime);
        m mVar = m.f44039a;
        V8Messenger.i(v8Messenger, mVar.a(), (JSONObject) null, false, 6, (Object) null);
        k kVar = k.f44016a;
        V8Messenger.i(v8Messenger, kVar.b(), new JSONObject().put("maxScriptsCacheSize", ExceptionCode.CRASH_EXCEPTION), false, 4, (Object) null);
        V8Messenger v8Messenger2 = v8Messenger;
        V8Messenger.i(v8Messenger2, kVar.h(), new JSONObject().put("maxDepth", 32), false, 4, (Object) null);
        V8Messenger.i(v8Messenger2, mVar.b(), (JSONObject) null, false, 6, (Object) null);
        r.n(v8Messenger, executorService);
        return createV8Runtime;
    }

    public final Future<V8> b(ExecutorService executorService, String str, boolean z11) {
        b.f(z11);
        return executorService.submit(new s(str, executorService));
    }
}

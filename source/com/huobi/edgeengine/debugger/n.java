package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/huobi/edgeengine/debugger/n;", "Lcom/facebook/stetho/inspector/protocol/ChromeDevtoolsDomain;", "Lcom/huobi/edgeengine/debugger/V8Messenger;", "v8Messenger", "", "a", "Lcom/huobi/edgeengine/debugger/V8Messenger;", "Lcom/facebook/stetho/inspector/protocol/module/Runtime;", "b", "Lcom/facebook/stetho/inspector/protocol/module/Runtime;", "adaptee", "Lcom/facebook/stetho/inspector/console/RuntimeReplFactory;", "replFactory", "<init>", "(Lcom/facebook/stetho/inspector/console/RuntimeReplFactory;)V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class n implements ChromeDevtoolsDomain {

    /* renamed from: a  reason: collision with root package name */
    public V8Messenger f44044a;

    /* renamed from: b  reason: collision with root package name */
    public final Runtime f44045b;

    public n(RuntimeReplFactory runtimeReplFactory) {
        this.f44045b = new Runtime(runtimeReplFactory);
    }

    public final void a(V8Messenger v8Messenger) {
        this.f44044a = v8Messenger;
    }
}

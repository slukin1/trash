package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;
import tj.b;
import tj.c;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 12\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J%\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/huobi/edgeengine/debugger/Debugger;", "Lcom/facebook/stetho/inspector/protocol/module/Debugger;", "", "n", "k", "T", "Lkotlin/Function0;", "action", "m", "(Ld10/a;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutorService;", "v8Executor", "Lcom/huobi/edgeengine/debugger/V8Messenger;", "v8Messenger", "j", "l", "()V", "Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;", "peer", "Lorg/json/JSONObject;", "params", "enable", "disable", "Lcom/huobi/edgeengine/debugger/p;", "a", "Lcom/huobi/edgeengine/debugger/p;", "scriptSourceProvider", "Lcom/facebook/stetho/json/ObjectMapper;", "b", "Lcom/facebook/stetho/json/ObjectMapper;", "i", "()Lcom/facebook/stetho/json/ObjectMapper;", "setDtoMapper", "(Lcom/facebook/stetho/json/ObjectMapper;)V", "dtoMapper", "c", "Ljava/util/concurrent/ExecutorService;", "d", "Lcom/huobi/edgeengine/debugger/V8Messenger;", "e", "Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;", "connectedPeer", "", "", "f", "Ljava/util/List;", "breakpointsAdded", "<init>", "(Lcom/huobi/edgeengine/debugger/p;)V", "g", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class Debugger extends com.facebook.stetho.inspector.protocol.module.Debugger {

    /* renamed from: g  reason: collision with root package name */
    public static final a f43964g = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final p f43965a;

    /* renamed from: b  reason: collision with root package name */
    public ObjectMapper f43966b = new ObjectMapper();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f43967c;

    /* renamed from: d  reason: collision with root package name */
    public V8Messenger f43968d;

    /* renamed from: e  reason: collision with root package name */
    public JsonRpcPeer f43969e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f43970f = new ArrayList();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/huobi/edgeengine/debugger/Debugger$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public Debugger(p pVar) {
        this.f43965a = pVar;
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        V8Messenger v8Messenger = this.f43968d;
        if (v8Messenger != null) {
            v8Messenger.j(false);
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        m(new Debugger$enable$1(this, jsonRpcPeer));
        V8Messenger v8Messenger = this.f43968d;
        if (v8Messenger != null) {
            v8Messenger.j(true);
        }
    }

    public final ObjectMapper i() {
        return this.f43966b;
    }

    public final void j(ExecutorService executorService, V8Messenger v8Messenger) {
        this.f43967c = executorService;
        this.f43968d = v8Messenger;
    }

    public final void k() {
        c.a().a("Debugger", "Disconnecting from Chrome");
        m(new Debugger$onDisconnect$1(this));
    }

    public final void l() {
        Collection<String> b11 = this.f43965a.b();
        ArrayList<o> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.u(b11, 10));
        for (String oVar : b11) {
            arrayList.add(new o(oVar, (String) null, 2, (r) null));
        }
        for (o oVar2 : arrayList) {
            JsonRpcPeer jsonRpcPeer = this.f43969e;
            if (jsonRpcPeer != null) {
                jsonRpcPeer.invokeMethod(k.f44016a.g(), oVar2, (PendingRequestCallback) null);
            }
        }
    }

    public final <T> T m(d10.a<? extends T> aVar) {
        b.f47901a.e();
        try {
            return aVar.invoke();
        } catch (Throwable th2) {
            c.a().e("Debugger", x.i("Unable to perform ", b.f47901a.a()), th2);
            return null;
        }
    }

    public final void n() {
        if (this.f43967c == null) {
            throw new IllegalStateException("Unable to call method before v8 has been initialized");
        }
    }
}

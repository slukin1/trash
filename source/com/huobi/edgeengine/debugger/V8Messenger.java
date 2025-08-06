package com.huobi.edgeengine.debugger;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.inspector.V8Inspector;
import com.eclipsesource.v8.inspector.V8InspectorDelegate;
import com.facebook.stetho.inspector.network.NetworkPeerManager;
import com.facebook.stetho.json.ObjectMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;
import tj.c;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0003\u0018=\u001fB\u000f\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0016\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aRT\u0010!\u001aB\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\b0\b \u001d* \u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\b0\b\u0018\u00010\u001e0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040$j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010&RH\u0010(\u001a6\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00040\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b \u001d*\u001a\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00040\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u001e0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R8\u0010-\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010*0* \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010*0*\u0018\u00010+0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00102R#\u00108\u001a\n \u001d*\u0004\u0018\u000104048BX\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b\"\u00107¨\u0006>"}, d2 = {"Lcom/huobi/edgeengine/debugger/V8Messenger;", "Lcom/eclipsesource/v8/inspector/V8InspectorDelegate;", "", "waitFrontendMessageOnPause", "", "p0", "onResponse", "message", "Lorg/json/JSONObject;", "params", "", "runOnlyWhenPaused", "h", "k", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "isConnected", "j", "f", "responseParams", "responseMethod", "e", "g", "d", "method", "a", "Lcom/facebook/stetho/json/ObjectMapper;", "Lcom/facebook/stetho/json/ObjectMapper;", "dtoMapper", "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Map;", "chromeMessageQueue", "c", "v8ScriptMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "scriptUriToIdMap", "v8MessageQueue", "", "Lcom/huobi/edgeengine/debugger/V8Messenger$b;", "", "Ljava/util/List;", "pendingMessageQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextDispatchId", "Lcom/huobi/edgeengine/debugger/V8Messenger$DebuggerState;", "Lcom/huobi/edgeengine/debugger/V8Messenger$DebuggerState;", "debuggerState", "Lcom/eclipsesource/v8/inspector/V8Inspector;", "i", "Lkotlin/i;", "()Lcom/eclipsesource/v8/inspector/V8Inspector;", "v8Inspector", "Lcom/eclipsesource/v8/V8;", "v8", "<init>", "(Lcom/eclipsesource/v8/V8;)V", "DebuggerState", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class V8Messenger implements V8InspectorDelegate {

    /* renamed from: j  reason: collision with root package name */
    public static final a f43979j = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final ObjectMapper f43980a = new ObjectMapper();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, JSONObject> f43981b = Collections.synchronizedMap(new LinkedHashMap());

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f43982c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, String> f43983d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, JSONObject> f43984e = Collections.synchronizedMap(new LinkedHashMap());

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f43985f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f43986g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public DebuggerState f43987h = DebuggerState.Disconnected;

    /* renamed from: i  reason: collision with root package name */
    public final i f43988i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/huobi/edgeengine/debugger/V8Messenger$DebuggerState;", "", "(Ljava/lang/String;I)V", "Disconnected", "Paused", "Connected", "edgeengine_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum DebuggerState {
        Disconnected,
        Paused,
        Connected
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/huobi/edgeengine/debugger/V8Messenger$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u0018\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/huobi/edgeengine/debugger/V8Messenger$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "method", "I", "()I", "setMessageId", "(I)V", "messageId", "c", "getResponse", "e", "(Ljava/lang/String;)V", "response", "d", "Z", "()Z", "(Z)V", "pending", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f43989a;

        /* renamed from: b  reason: collision with root package name */
        public int f43990b;

        /* renamed from: c  reason: collision with root package name */
        public String f43991c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43992d;

        public final int a() {
            return this.f43990b;
        }

        public final String b() {
            return this.f43989a;
        }

        public final boolean c() {
            return this.f43992d;
        }

        public final void d(boolean z11) {
            this.f43992d = z11;
        }

        public final void e(String str) {
            this.f43991c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f43989a, bVar.f43989a) && this.f43990b == bVar.f43990b;
        }

        public int hashCode() {
            return (this.f43989a.hashCode() * 31) + this.f43990b;
        }

        public String toString() {
            return "PendingResponse(method=" + this.f43989a + ", messageId=" + this.f43990b + ')';
        }
    }

    public V8Messenger(V8 v82) {
        this.f43988i = LazyKt__LazyJVMKt.a(new V8Messenger$v8Inspector$2(v82, this));
    }

    public static /* synthetic */ void b(V8Messenger v8Messenger, String str, JSONObject jSONObject, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jSONObject = null;
        }
        v8Messenger.a(str, jSONObject);
    }

    public static /* synthetic */ void i(V8Messenger v8Messenger, String str, JSONObject jSONObject, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jSONObject = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        v8Messenger.h(str, jSONObject, z11);
    }

    public final void a(String str, JSONObject jSONObject) {
        T t11;
        int i11;
        boolean z11;
        Iterator<T> it2 = this.f43985f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            b bVar = (b) t11;
            if (!x.b(bVar.b(), str) || bVar.c()) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        b bVar2 = (b) t11;
        if (bVar2 != null) {
            bVar2.d(true);
            i11 = bVar2.a();
        } else {
            i11 = this.f43986g.incrementAndGet();
        }
        JSONObject put = new JSONObject().put("id", i11).put("method", str).put("params", jSONObject);
        c.a().a("V8Messenger", x.i("dispatching ", put));
        V8Inspector c11 = c();
        if (c11 != null) {
            c11.dispatchProtocolMessage(put.toString());
        }
    }

    public final V8Inspector c() {
        return (V8Inspector) this.f43988i.getValue();
    }

    public final void d(JSONObject jSONObject, String str) {
        Integer num;
        BreakpointResolvedEvent breakpointResolvedEvent = (BreakpointResolvedEvent) this.f43980a.convertValue(jSONObject, BreakpointResolvedEvent.class);
        LocationResponse locationResponse = breakpointResolvedEvent.f43963b;
        BreakpointResolvedEvent breakpointResolvedEvent2 = new BreakpointResolvedEvent();
        breakpointResolvedEvent2.f43962a = breakpointResolvedEvent.f43962a;
        LocationResponse locationResponse2 = new LocationResponse();
        Integer num2 = null;
        locationResponse2.f43973a = this.f43982c.get(locationResponse == null ? null : locationResponse.f43973a);
        if (locationResponse == null) {
            num = null;
        } else {
            num = locationResponse.f43974b;
        }
        locationResponse2.f43974b = num;
        if (locationResponse != null) {
            num2 = locationResponse.f43975c;
        }
        locationResponse2.f43975c = num2;
        Unit unit = Unit.f56620a;
        breakpointResolvedEvent2.f43963b = locationResponse2;
        this.f43981b.put(str, this.f43980a.convertValue(breakpointResolvedEvent2, JSONObject.class));
    }

    public final void e(JSONObject jSONObject, String str) {
        if (this.f43987h == DebuggerState.Disconnected) {
            b(this, k.f44016a.e(), (JSONObject) null, 2, (Object) null);
        } else if (jSONObject != null) {
            this.f43987h = DebuggerState.Paused;
            this.f43981b.put(str, MappersKt.c(jSONObject, this.f43982c));
        }
    }

    public final void f() {
        if (this.f43987h == DebuggerState.Paused) {
            this.f43987h = DebuggerState.Connected;
        }
    }

    public final void g(JSONObject jSONObject) {
        ScriptParsedEventRequest scriptParsedEventRequest = (ScriptParsedEventRequest) this.f43980a.convertValue(jSONObject, ScriptParsedEventRequest.class);
        if (scriptParsedEventRequest.f43978b.length() > 0) {
            this.f43982c.put(scriptParsedEventRequest.f43977a, scriptParsedEventRequest.f43978b);
            this.f43983d.put(scriptParsedEventRequest.f43978b, scriptParsedEventRequest.f43977a);
        }
    }

    public final void h(String str, JSONObject jSONObject, boolean z11) {
        if (this.f43987h == DebuggerState.Paused) {
            this.f43984e.put(str, jSONObject);
        } else if (!z11) {
            a(str, jSONObject);
        }
    }

    public final void j(boolean z11) {
        this.f43987h = z11 ? DebuggerState.Connected : DebuggerState.Disconnected;
    }

    public final void k(String str, JSONObject jSONObject) {
        i(this, str, jSONObject.put("scriptId", this.f43983d.get(jSONObject.getString("scriptId"))), false, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[EDGE_INSN: B:33:0x0054->B:15:0x0054 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(java.lang.String r6) {
        /*
            r5 = this;
            com.huobi.edgeengine.debugger.utils.Logger r0 = tj.c.a()
            java.lang.String r1 = "onResponse "
            java.lang.String r1 = kotlin.jvm.internal.x.i(r1, r6)
            java.lang.String r2 = "V8Messenger"
            r0.a(r2, r1)
            com.facebook.stetho.json.ObjectMapper r0 = r5.f43980a
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r6)
            java.lang.Class<com.huobi.edgeengine.debugger.V8Response> r6 = com.huobi.edgeengine.debugger.V8Response.class
            java.lang.Object r6 = r0.convertValue(r1, r6)
            com.huobi.edgeengine.debugger.V8Response r6 = (com.huobi.edgeengine.debugger.V8Response) r6
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x0067
            java.util.List<com.huobi.edgeengine.debugger.V8Messenger$b> r0 = r5.f43985f
            java.util.Iterator r0 = r0.iterator()
        L_0x002a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.huobi.edgeengine.debugger.V8Messenger$b r3 = (com.huobi.edgeengine.debugger.V8Messenger.b) r3
            boolean r4 = r3.c()
            if (r4 == 0) goto L_0x004f
            int r3 = r3.a()
            java.lang.Integer r4 = r6.f43994b
            if (r4 != 0) goto L_0x0047
            goto L_0x004f
        L_0x0047:
            int r4 = r4.intValue()
            if (r3 != r4) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x004f:
            r3 = 0
        L_0x0050:
            if (r3 == 0) goto L_0x002a
            goto L_0x0054
        L_0x0053:
            r1 = r2
        L_0x0054:
            com.huobi.edgeengine.debugger.V8Messenger$b r1 = (com.huobi.edgeengine.debugger.V8Messenger.b) r1
            if (r1 == 0) goto L_0x00a4
            org.json.JSONObject r6 = r6.f43996d
            if (r6 != 0) goto L_0x005d
            goto L_0x0063
        L_0x005d:
            java.lang.String r0 = "result"
            java.lang.String r2 = r6.optString(r0)
        L_0x0063:
            r1.e(r2)
            goto L_0x00a4
        L_0x0067:
            org.json.JSONObject r0 = r6.f43997e
            java.lang.String r6 = r6.f43995c
            com.huobi.edgeengine.debugger.k r1 = com.huobi.edgeengine.debugger.k.f44016a
            java.lang.String r2 = r1.g()
            boolean r2 = kotlin.jvm.internal.x.b(r6, r2)
            if (r2 == 0) goto L_0x007b
            r5.g(r0)
            goto L_0x00a4
        L_0x007b:
            java.lang.String r2 = r1.a()
            boolean r2 = kotlin.jvm.internal.x.b(r6, r2)
            if (r2 == 0) goto L_0x0089
            r5.d(r0, r6)
            goto L_0x00a4
        L_0x0089:
            java.lang.String r2 = r1.c()
            boolean r2 = kotlin.jvm.internal.x.b(r6, r2)
            if (r2 == 0) goto L_0x0097
            r5.e(r0, r6)
            goto L_0x00a4
        L_0x0097:
            java.lang.String r0 = r1.f()
            boolean r6 = kotlin.jvm.internal.x.b(r6, r0)
            if (r6 == 0) goto L_0x00a4
            r5.f()
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.debugger.V8Messenger.onResponse(java.lang.String):void");
    }

    public void waitFrontendMessageOnPause() {
        if (this.f43987h != DebuggerState.Paused) {
            c.a().a("V8Messenger", "Debugger paused without connection.  Resuming J2V8");
            b(this, k.f44016a.e(), (JSONObject) null, 2, (Object) null);
            return;
        }
        if (MapsKt___MapsKt.z(this.f43984e)) {
            for (Map.Entry next : this.f43984e.entrySet()) {
                String str = (String) next.getKey();
                JSONObject jSONObject = (JSONObject) next.getValue();
                c.a().a("V8Messenger", "Sending v8 " + str + " with " + jSONObject);
                a(str, jSONObject);
            }
            this.f43984e.clear();
        }
        if (MapsKt___MapsKt.z(this.f43981b)) {
            NetworkPeerManager instanceOrNull = NetworkPeerManager.getInstanceOrNull();
            boolean z11 = false;
            if (instanceOrNull != null && instanceOrNull.hasRegisteredPeers()) {
                z11 = true;
            }
            if (z11) {
                for (Map.Entry next2 : this.f43981b.entrySet()) {
                    String str2 = (String) next2.getKey();
                    JSONObject jSONObject2 = (JSONObject) next2.getValue();
                    c.a().a("V8Messenger", "Sending chrome " + str2 + " with " + jSONObject2);
                    instanceOrNull.sendNotificationToPeers(str2, jSONObject2);
                }
            } else {
                b(this, k.f44016a.e(), (JSONObject) null, 2, (Object) null);
            }
            this.f43981b.clear();
        }
    }
}

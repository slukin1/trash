package zendesk.classic.messaging.ui;

import java.util.List;
import zendesk.classic.messaging.AgentDetails;
import zendesk.classic.messaging.ConnectionState;
import zendesk.classic.messaging.MessagingItem;

public class MessagingState {

    /* renamed from: a  reason: collision with root package name */
    public final List<MessagingItem> f62709a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f62710b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f62711c;

    /* renamed from: d  reason: collision with root package name */
    public final b f62712d;

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionState f62713e;

    /* renamed from: f  reason: collision with root package name */
    public final String f62714f;

    /* renamed from: g  reason: collision with root package name */
    public final g30.b f62715g;

    /* renamed from: h  reason: collision with root package name */
    public final int f62716h;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f62725a;

        /* renamed from: b  reason: collision with root package name */
        public final AgentDetails f62726b;

        public b(boolean z11) {
            this(z11, (AgentDetails) null);
        }

        public AgentDetails a() {
            return this.f62726b;
        }

        public boolean b() {
            return this.f62725a;
        }

        public b(boolean z11, AgentDetails agentDetails) {
            this.f62725a = z11;
            this.f62726b = agentDetails;
        }
    }

    public Builder a() {
        return new Builder(this);
    }

    public MessagingState(List<MessagingItem> list, boolean z11, boolean z12, b bVar, ConnectionState connectionState, String str, g30.b bVar2, int i11) {
        this.f62709a = list;
        this.f62710b = z11;
        this.f62711c = z12;
        this.f62712d = bVar;
        this.f62713e = connectionState;
        this.f62714f = str;
        this.f62715g = bVar2;
        this.f62716h = i11;
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public List<MessagingItem> f62717a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f62718b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f62719c;

        /* renamed from: d  reason: collision with root package name */
        public b f62720d = new b(false);

        /* renamed from: e  reason: collision with root package name */
        public ConnectionState f62721e = ConnectionState.DISCONNECTED;

        /* renamed from: f  reason: collision with root package name */
        public String f62722f;

        /* renamed from: g  reason: collision with root package name */
        public g30.b f62723g;

        /* renamed from: h  reason: collision with root package name */
        public int f62724h = 131073;

        public Builder() {
        }

        public MessagingState a() {
            return new MessagingState(mz.a.e(this.f62717a), this.f62718b, this.f62719c, this.f62720d, this.f62721e, this.f62722f, this.f62723g, this.f62724h);
        }

        public Builder b(g30.b bVar) {
            this.f62723g = bVar;
            return this;
        }

        public Builder c(String str) {
            this.f62722f = str;
            return this;
        }

        public Builder d(ConnectionState connectionState) {
            this.f62721e = connectionState;
            return this;
        }

        public Builder e(boolean z11) {
            this.f62719c = z11;
            return this;
        }

        public Builder f(int i11) {
            this.f62724h = i11;
            return this;
        }

        public Builder g(List<MessagingItem> list) {
            this.f62717a = list;
            return this;
        }

        public Builder h(b bVar) {
            this.f62720d = bVar;
            return this;
        }

        public Builder(MessagingState messagingState) {
            this.f62717a = messagingState.f62709a;
            this.f62719c = messagingState.f62711c;
            this.f62720d = messagingState.f62712d;
            this.f62721e = messagingState.f62713e;
            this.f62722f = messagingState.f62714f;
            this.f62723g = messagingState.f62715g;
            this.f62724h = messagingState.f62716h;
        }
    }
}

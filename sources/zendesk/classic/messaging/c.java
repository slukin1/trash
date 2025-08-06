package zendesk.classic.messaging;

public interface c {

    public interface a {
        void a(c cVar, boolean z11);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f62459a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62460b;

        public String a() {
            return this.f62460b;
        }

        public String b() {
            return this.f62459a;
        }
    }

    /* renamed from: zendesk.classic.messaging.c$c  reason: collision with other inner class name */
    public interface C0690c {
    }

    void a(d dVar);

    void b(g gVar);

    String getId();

    void isConversationOngoing(a aVar);

    boolean registerObserver(C0690c cVar);

    void stop();

    boolean unregisterObserver(C0690c cVar);
}

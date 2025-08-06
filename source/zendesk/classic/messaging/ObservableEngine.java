package zendesk.classic.messaging;

import java.util.HashSet;
import java.util.Set;
import zendesk.classic.messaging.c;

public abstract class ObservableEngine implements c {
    private final Set<c.C0690c> updateObservers = new HashSet();

    public void isConversationOngoing(c.a aVar) {
        aVar.a(this, false);
    }

    public boolean registerObserver(c.C0690c cVar) {
        return this.updateObservers.add(cVar);
    }

    public boolean unregisterObserver(c.C0690c cVar) {
        return this.updateObservers.remove(cVar);
    }
}

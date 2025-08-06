package zendesk.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mz.a;

class ZendeskRequestSessionCache implements RequestSessionCache {
    private final Map<Long, TicketForm> cachedTicketForms = new HashMap();

    public boolean containsAllTicketForms(List<Long> list) {
        boolean z11;
        List<TypeT> e11 = a.e(list);
        synchronized (this.cachedTicketForms) {
            Iterator<TypeT> it2 = e11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z11 = true;
                    break;
                }
                if (!this.cachedTicketForms.containsKey((Long) it2.next())) {
                    z11 = false;
                    break;
                }
            }
        }
        return z11;
    }

    public synchronized List<TicketForm> getTicketFormsById(List<Long> list) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        List<TypeT> e11 = a.e(list);
        synchronized (this.cachedTicketForms) {
            for (TypeT typet : e11) {
                arrayList.add(this.cachedTicketForms.get(typet));
            }
        }
        return arrayList;
    }

    public void updateTicketFormCache(List<TicketForm> list) {
        List<TypeT> e11 = a.e(list);
        HashMap hashMap = new HashMap();
        for (TypeT typet : e11) {
            hashMap.put(Long.valueOf(typet.getId()), typet);
        }
        synchronized (this.cachedTicketForms) {
            this.cachedTicketForms.putAll(hashMap);
        }
    }
}

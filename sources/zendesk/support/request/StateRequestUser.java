package zendesk.support.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mz.f;
import zendesk.support.Attachment;
import zendesk.support.User;

class StateRequestUser implements Serializable {
    private final String avatar;

    /* renamed from: id  reason: collision with root package name */
    private final long f62986id;
    private final boolean isAgent;
    private final String name;

    public StateRequestUser(String str, String str2, boolean z11, long j11) {
        this.name = str;
        this.avatar = str2;
        this.isAgent = z11;
        this.f62986id = j11;
    }

    public static boolean containsAgent(List<StateRequestUser> list) {
        for (StateRequestUser isAgent2 : list) {
            if (isAgent2.isAgent()) {
                return true;
            }
        }
        return false;
    }

    public static List<StateRequestUser> convert(List<User> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (User next : list) {
            if (next.getId() != null) {
                Attachment photo = next.getPhoto();
                arrayList.add(new StateRequestUser(next.getName(), (photo == null || !f.c(photo.getContentUrl())) ? "" : photo.getContentUrl(), next.isAgent(), next.getId().longValue()));
            }
        }
        return arrayList;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getId() {
        return this.f62986id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAgent() {
        return this.isAgent;
    }
}

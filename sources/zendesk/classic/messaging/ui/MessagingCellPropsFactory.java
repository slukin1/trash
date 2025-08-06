package zendesk.classic.messaging.ui;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mz.a;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$dimen;

public class MessagingCellPropsFactory {

    /* renamed from: a  reason: collision with root package name */
    public final int f62707a;

    /* renamed from: b  reason: collision with root package name */
    public final int f62708b;

    public enum InteractionType {
        QUERY,
        RESPONSE,
        NONE
    }

    public MessagingCellPropsFactory(Resources resources) {
        this.f62708b = resources.getDimensionPixelSize(R$dimen.zui_cell_vertical_spacing_default);
        this.f62707a = resources.getDimensionPixelSize(R$dimen.zui_cell_vertical_spacing_group);
    }

    public static InteractionType c(MessagingItem messagingItem) {
        if (messagingItem instanceof MessagingItem.i) {
            return InteractionType.RESPONSE;
        }
        if ((messagingItem instanceof MessagingItem.Query) || (messagingItem instanceof MessagingItem.h)) {
            return InteractionType.QUERY;
        }
        return InteractionType.NONE;
    }

    public int a(MessagingItem messagingItem, MessagingItem messagingItem2) {
        InteractionType c11 = c(messagingItem);
        if (c11 == InteractionType.QUERY) {
            return 4;
        }
        if (messagingItem2 != null && c11 == c(messagingItem2)) {
            return (!(messagingItem instanceof MessagingItem.i) || !(messagingItem2 instanceof MessagingItem.i) || ((MessagingItem.i) messagingItem).b().getAgentId().equals(((MessagingItem.i) messagingItem2).b().getAgentId())) ? 4 : 0;
        }
        return 0;
    }

    public int b(MessagingItem messagingItem, MessagingItem messagingItem2) {
        if (messagingItem2 == null) {
            return this.f62708b;
        }
        if (messagingItem2 instanceof MessagingItem.j) {
            return this.f62707a;
        }
        if (c(messagingItem) == c(messagingItem2)) {
            return this.f62707a;
        }
        return this.f62708b;
    }

    public List<r> d(List<MessagingItem> list) {
        if (a.g(list)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i11 = 0;
        while (i11 < list.size()) {
            MessagingItem messagingItem = null;
            MessagingItem messagingItem2 = i11 > 0 ? list.get(i11 - 1) : null;
            MessagingItem messagingItem3 = list.get(i11);
            i11++;
            if (i11 < list.size()) {
                messagingItem = list.get(i11);
            }
            arrayList.add(e(messagingItem2, messagingItem3, messagingItem));
        }
        return arrayList;
    }

    public final r e(MessagingItem messagingItem, MessagingItem messagingItem2, MessagingItem messagingItem3) {
        return new r(f(messagingItem2, messagingItem), b(messagingItem2, messagingItem3), a(messagingItem2, messagingItem3));
    }

    public int f(MessagingItem messagingItem, MessagingItem messagingItem2) {
        InteractionType c11 = c(messagingItem);
        if (c11 == InteractionType.QUERY || messagingItem2 == null || c11 != c(messagingItem2)) {
            return 0;
        }
        if (!(messagingItem instanceof MessagingItem.i) || !(messagingItem2 instanceof MessagingItem.i) || ((MessagingItem.i) messagingItem).b().getAgentId().equals(((MessagingItem.i) messagingItem2).b().getAgentId())) {
            return 8;
        }
        return 0;
    }
}

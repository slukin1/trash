package zendesk.support.request;

import android.annotation.SuppressLint;
import androidx.core.util.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;
import mz.a;

class StateMessageMergeUtil {
    private StateMessageMergeUtil() {
    }

    public static List<StateMessage> mergeMessages(List<StateMessage> list, List<StateMessage> list2) {
        c<List<StateMessage>, List<StateMessage>> mergeRemoteMessagesById = mergeRemoteMessagesById(list, list2);
        if (a.g((Collection) mergeRemoteMessagesById.f8469b)) {
            return (List) mergeRemoteMessagesById.f8468a;
        }
        return mergeRemoteMessagesBySortOrder((List) mergeRemoteMessagesById.f8468a, (List) mergeRemoteMessagesById.f8469b);
    }

    @SuppressLint({"UseSparseArrays"})
    private static c<List<StateMessage>, List<StateMessage>> mergeRemoteMessagesById(List<StateMessage> list, List<StateMessage> list2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (StateMessage next : list2) {
            linkedHashMap.put(Long.valueOf(next.getId()), next);
        }
        ArrayList arrayList = new ArrayList();
        for (StateMessage next2 : list) {
            if (linkedHashMap.containsKey(Long.valueOf(next2.getId()))) {
                arrayList.add(synchronizeAttachmentOrder(next2, (StateMessage) linkedHashMap.remove(Long.valueOf(next2.getId()))));
            } else {
                arrayList.add(next2);
            }
        }
        return c.a(arrayList, new ArrayList(linkedHashMap.values()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<zendesk.support.request.StateMessage> mergeRemoteMessagesBySortOrder(java.util.List<zendesk.support.request.StateMessage> r11, java.util.List<zendesk.support.request.StateMessage> r12) {
        /*
            int r0 = r11.size()
            int r1 = r12.size()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r0 + r1
            r2.<init>(r3)
            r3 = 0
            r4 = r3
        L_0x0011:
            if (r3 < r0) goto L_0x0016
            if (r4 < r1) goto L_0x0016
            goto L_0x0068
        L_0x0016:
            if (r3 >= r0) goto L_0x0057
            if (r4 < r1) goto L_0x001b
            goto L_0x0057
        L_0x001b:
            java.lang.Object r5 = r11.get(r3)
            zendesk.support.request.StateMessage r5 = (zendesk.support.request.StateMessage) r5
            java.lang.Object r6 = r12.get(r4)
            zendesk.support.request.StateMessage r6 = (zendesk.support.request.StateMessage) r6
            long r7 = r5.getId()
            long r9 = r6.getId()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x003f
            zendesk.support.request.StateMessage r5 = synchronizeAttachmentOrder(r5, r6)
            r2.add(r5)
            int r3 = r3 + 1
        L_0x003c:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x003f:
            java.util.Date r7 = r5.getDate()
            java.util.Date r8 = r6.getDate()
            boolean r7 = r7.before(r8)
            if (r7 == 0) goto L_0x0053
            r2.add(r5)
            int r3 = r3 + 1
            goto L_0x0011
        L_0x0053:
            r2.add(r6)
            goto L_0x003c
        L_0x0057:
            if (r3 >= r0) goto L_0x0061
            java.util.List r11 = r11.subList(r3, r0)
            r2.addAll(r11)
            goto L_0x0068
        L_0x0061:
            java.util.List r11 = r12.subList(r4, r1)
            r2.addAll(r11)
        L_0x0068:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.StateMessageMergeUtil.mergeRemoteMessagesBySortOrder(java.util.List, java.util.List):java.util.List");
    }

    public static List<StateRequestUser> mergeUsers(List<StateRequestUser> list, List<StateRequestUser> list2) {
        TreeSet treeSet = new TreeSet(new Comparator<StateRequestUser>() {
            public int compare(StateRequestUser stateRequestUser, StateRequestUser stateRequestUser2) {
                return (int) (stateRequestUser.getId() - stateRequestUser2.getId());
            }
        });
        treeSet.addAll(list2);
        treeSet.addAll(list);
        return new ArrayList(treeSet);
    }

    public static List<StateMessage> removeMessageById(long j11, List<StateMessage> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (StateMessage next : list) {
            if (next.getId() != j11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @SuppressLint({"UseSparseArrays"})
    public static StateMessage synchronizeAttachmentOrder(StateMessage stateMessage, StateMessage stateMessage2) {
        if (a.g(stateMessage2.getAttachments())) {
            return stateMessage2;
        }
        final HashMap hashMap = new HashMap();
        int size = stateMessage.getAttachments().size();
        for (int i11 = 0; i11 < size; i11++) {
            hashMap.put(Long.valueOf(stateMessage.getAttachments().get(i11).getId()), Integer.valueOf(i11));
        }
        ArrayList arrayList = new ArrayList(stateMessage2.getAttachments());
        Collections.sort(arrayList, new Comparator<StateRequestAttachment>() {
            public int compare(StateRequestAttachment stateRequestAttachment, StateRequestAttachment stateRequestAttachment2) {
                Integer num = (Integer) hashMap.get(Long.valueOf(stateRequestAttachment.getId()));
                Integer num2 = (Integer) hashMap.get(Long.valueOf(stateRequestAttachment2.getId()));
                if (num == null && num2 == null) {
                    return 0;
                }
                if (num2 == null) {
                    return 1;
                }
                if (num == null) {
                    return -1;
                }
                return num.intValue() - num2.intValue();
            }
        });
        return stateMessage2.withAttachments(arrayList);
    }
}

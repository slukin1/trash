package zendesk.support.requestlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import mz.f;
import zendesk.support.requestlist.RequestInfo;

class RequestInfoMerger {
    private static final Comparator<RequestInfo> REQUEST_INFO_COMPARATOR = new RequestInfo.LastUpdatedComparator();

    public List<RequestInfo> merge(List<RequestInfo> list, List<RequestInfo> list2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (RequestInfo next : list) {
            String remoteId = next.getRemoteId();
            if (f.c(remoteId)) {
                hashMap.put(remoteId, next);
            } else {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (RequestInfo next2 : list2) {
            String remoteId2 = next2.getRemoteId();
            if (hashMap.containsKey(remoteId2)) {
                arrayList2.add(merge((RequestInfo) hashMap.get(remoteId2), next2));
                hashMap.remove(remoteId2);
            } else {
                arrayList2.add(next2);
            }
        }
        Collections.sort(arrayList2, REQUEST_INFO_COMPARATOR);
        return arrayList2;
    }

    private RequestInfo merge(RequestInfo requestInfo, RequestInfo requestInfo2) {
        Date date;
        Date lastUpdated = requestInfo.getLastUpdated();
        Date lastUpdated2 = requestInfo2.getLastUpdated();
        if (lastUpdated == null) {
            date = lastUpdated2;
        } else {
            if (lastUpdated2 != null && !lastUpdated.after(lastUpdated2)) {
                lastUpdated = lastUpdated2;
            }
            date = lastUpdated;
        }
        RequestInfo.MessageInfo lastMessageInfo = requestInfo.getLastMessageInfo();
        RequestInfo.MessageInfo lastMessageInfo2 = requestInfo2.getLastMessageInfo();
        return new RequestInfo(requestInfo.getLocalId(), requestInfo2.getRemoteId(), requestInfo2.getRequestStatus(), requestInfo2.isUnread(), date, requestInfo2.getAgentInfos(), requestInfo2.getFirstMessageInfo(), lastMessageInfo.getDate().after(lastMessageInfo2.getDate()) ? lastMessageInfo : lastMessageInfo2, requestInfo.getFailedMessageIds());
    }
}

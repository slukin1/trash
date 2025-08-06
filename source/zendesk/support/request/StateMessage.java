package zendesk.support.request;

import androidx.core.util.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lz.a;
import mz.f;
import zendesk.support.Attachment;
import zendesk.support.CommentResponse;
import zendesk.support.IdUtil;

class StateMessage implements Serializable {
    private final List<StateRequestAttachment> attachments;
    private final Date date;
    private final String htmlBody;

    /* renamed from: id  reason: collision with root package name */
    private final long f62982id;
    private final String plainBody;
    private final StateMessageStatus state;
    private final long userId;

    public StateMessage(String str, List<StateRequestAttachment> list) {
        this.htmlBody = null;
        this.plainBody = str;
        this.date = new Date();
        this.f62982id = IdUtil.newLongId();
        this.userId = -1;
        this.state = StateMessageStatus.pending();
        this.attachments = list;
    }

    public static c<List<StateMessage>, StateIdMapper> convert(List<CommentResponse> list, StateIdMapper stateIdMapper, Map<Long, StateRequestAttachment> map) {
        long j11;
        Map<Long, StateRequestAttachment> map2 = map;
        ArrayList arrayList = new ArrayList(list.size());
        StateIdMapper stateIdMapper2 = stateIdMapper;
        for (CommentResponse next : list) {
            Long id2 = next.getId();
            Long authorId = next.getAuthorId();
            if (!(id2 == null || authorId == null)) {
                ArrayList arrayList2 = new ArrayList();
                for (Attachment next2 : next.getAttachments()) {
                    if (map2.containsKey(next2.getId())) {
                        arrayList2.add(map2.get(next2.getId()));
                    }
                }
                if (stateIdMapper2.hasLocalId(id2)) {
                    j11 = stateIdMapper2.getLocalId(id2).longValue();
                } else {
                    j11 = IdUtil.newLongId();
                    stateIdMapper2 = stateIdMapper2.addIdMapping(id2, Long.valueOf(j11));
                }
                arrayList.add(new StateMessage(next.getHtmlBody(), next.getBody(), next.getCreatedAt(), j11, authorId.longValue(), StateMessageStatus.delivered(), arrayList2));
            }
        }
        return c.a(arrayList, stateIdMapper2.copy());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StateMessage stateMessage = (StateMessage) obj;
        if (this.f62982id != stateMessage.f62982id || this.userId != stateMessage.userId) {
            return false;
        }
        String str = this.htmlBody;
        if (str == null ? stateMessage.htmlBody != null : !str.equals(stateMessage.htmlBody)) {
            return false;
        }
        String str2 = this.plainBody;
        if (str2 == null ? stateMessage.plainBody != null : !str2.equals(stateMessage.plainBody)) {
            return false;
        }
        Date date2 = this.date;
        if (date2 == null ? stateMessage.date != null : !date2.equals(stateMessage.date)) {
            return false;
        }
        StateMessageStatus stateMessageStatus = this.state;
        if (stateMessageStatus == null ? stateMessage.state != null : !stateMessageStatus.equals(stateMessage.state)) {
            return false;
        }
        List<StateRequestAttachment> list = this.attachments;
        List<StateRequestAttachment> list2 = stateMessage.attachments;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public List<StateRequestAttachment> getAttachments() {
        return this.attachments;
    }

    public String getBody() {
        if (f.c(this.plainBody)) {
            return this.plainBody;
        }
        return UtilsAttachment.getMessageBodyForAttachments(getAttachments());
    }

    public Date getDate() {
        return this.date;
    }

    public String getHtmlBody() {
        return this.htmlBody;
    }

    public long getId() {
        return this.f62982id;
    }

    public String getPlainBody() {
        return this.plainBody;
    }

    public StateMessageStatus getState() {
        return this.state;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.htmlBody, this.plainBody, this.date, Long.valueOf(this.f62982id), Long.valueOf(this.userId), this.state, this.attachments});
    }

    public String toString() {
        return "Message{htmlBody='" + this.htmlBody + '\'' + ", plainBody='" + this.plainBody + '\'' + ", date=" + this.date + ", id=" + this.f62982id + ", userId=" + this.userId + ", state=" + this.state + '}';
    }

    public StateMessage withAttachments(List<StateRequestAttachment> list) {
        return new StateMessage(this.htmlBody, this.plainBody, this.date, this.f62982id, this.userId, this.state, list);
    }

    public StateMessage withDelivered() {
        return new StateMessage(this.htmlBody, this.plainBody, this.date, this.f62982id, this.userId, StateMessageStatus.delivered(), this.attachments);
    }

    public StateMessage withError(a aVar) {
        return new StateMessage(this.htmlBody, this.plainBody, this.date, this.f62982id, this.userId, StateMessageStatus.error(aVar.getReason()), this.attachments);
    }

    public StateMessage withPending() {
        return new StateMessage(this.htmlBody, this.plainBody, this.date, this.f62982id, this.userId, StateMessageStatus.pending(), this.attachments);
    }

    public StateMessage withUpdatedAttachment(StateRequestAttachment stateRequestAttachment) {
        ArrayList arrayList = new ArrayList(this.attachments.size());
        for (StateRequestAttachment next : this.attachments) {
            if (next.getId() == stateRequestAttachment.getId()) {
                next = stateRequestAttachment;
            }
            arrayList.add(next);
        }
        return new StateMessage(this.htmlBody, this.plainBody, this.date, this.f62982id, this.userId, this.state, arrayList);
    }

    public StateMessage(String str, String str2, Date date2, long j11, long j12, StateMessageStatus stateMessageStatus, List<StateRequestAttachment> list) {
        this.htmlBody = str;
        this.plainBody = str2;
        this.date = date2;
        this.f62982id = j11;
        this.userId = j12;
        this.state = stateMessageStatus;
        this.attachments = list;
    }
}

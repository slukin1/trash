package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import mz.a;
import mz.f;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.RequestStatus;
import zendesk.support.request.CellSystemMessages;
import zendesk.support.request.CellType;
import zendesk.support.request.DocumentRenderer;
import zendesk.support.suas.Dispatcher;

class CellFactory {
    private final DocumentRenderer documentRenderer;
    private final DocumentRenderer.HtmlParser htmlParser;
    private final CellBindHelper utils;

    public CellFactory(Context context, Picasso picasso, ActionFactory actionFactory, Dispatcher dispatcher, ActionHandlerRegistry actionHandlerRegistry, ConfigurationHelper configurationHelper, Configuration configuration) {
        this.utils = new CellBindHelper(context, picasso, actionFactory, dispatcher);
        this.htmlParser = new DocumentRenderer.HtmlParser();
        this.documentRenderer = new DocumentRenderer(context, actionHandlerRegistry, configurationHelper, configuration);
    }

    private CharSequence generateRichText(String str, String str2) {
        return this.documentRenderer.render(this.htmlParser.parse(str, str2));
    }

    private List<CellType.Base> markMessagesAsErrored(Collection<CellType.Stateful> collection, Collection<StateMessage> collection2) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<CellType.Stateful> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().markAsErrored(new ArrayList(collection2), !it2.hasNext()));
        }
        return arrayList;
    }

    public List<CellType.Base> calculatePositionTypes(List<CellType.Base> list) {
        if (a.g(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        long j11 = -1;
        for (int i11 = 0; i11 < list.size(); i11++) {
            CellType.Base base = list.get(i11);
            if (i11 == 0 || base.getGroupId() != j11) {
                base.setPositionType(2);
            }
            if (base instanceof CellType.Stateful) {
                CellType.Stateful stateful = (CellType.Stateful) base;
                if (stateful.isMarkedAsDelivered() || stateful.isLastErrorCellOfBlock()) {
                    base.setPositionType(8);
                }
            }
            j11 = base.getGroupId();
            arrayList.add(base);
        }
        ((CellType.Base) arrayList.get(arrayList.size() - 1)).setPositionType(16);
        return arrayList;
    }

    public StateMessage findFirstDelivered(List<StateMessage> list) {
        for (StateMessage next : list) {
            if (next.getState().getStatus() == 2) {
                return next;
            }
        }
        return null;
    }

    public StateRequestUser findUserForId(List<StateRequestUser> list, long j11) {
        for (StateRequestUser next : list) {
            if (next.getId() == j11) {
                return next;
            }
        }
        return null;
    }

    public List<CellType.Base> generateCells(List<StateMessage> list, List<StateRequestUser> list2, RequestStatus requestStatus, String str) {
        ArrayList arrayList = new ArrayList();
        StateMessage findFirstDelivered = findFirstDelivered(list);
        for (StateMessage next : list) {
            StateRequestUser findUserForId = findUserForId(list2, next.getUserId());
            boolean isUserAgent = isUserAgent(findUserForId);
            arrayList.addAll(insertSystemMessage(findFirstDelivered, next, getViewModelsForMessage(next, isUserAgent, findUserForId), str, !isUserAgent));
        }
        return calculatePositionTypes(markAgentCells(insertRequestStatus(insertDateCells(markLastDeliveredCell(markCellsErrored(arrayList))), requestStatus)));
    }

    public CellType.Base getAgentAttachment(StateRequestAttachment stateRequestAttachment, StateRequestUser stateRequestUser, Date date) {
        if (UtilsAttachment.isImageAttachment(stateRequestAttachment)) {
            return new CellAgentAttachmentImage(this.utils, stateRequestAttachment, stateRequestUser, date);
        }
        return new CellAgentAttachmentGeneric(this.utils, stateRequestAttachment, stateRequestUser, date);
    }

    public CellType.Base getAgentMessage(StateMessage stateMessage, StateRequestUser stateRequestUser) {
        return new CellAgentMessage(this.utils, stateMessage, generateRichText(stateMessage.getHtmlBody(), stateMessage.getPlainBody()), stateRequestUser);
    }

    public CellType.Base getUserAttachment(StateMessage stateMessage, StateRequestAttachment stateRequestAttachment, Date date) {
        if (!UtilsAttachment.isImageAttachment(stateRequestAttachment)) {
            return new CellUserAttachmentGeneric(this.utils, stateMessage, stateRequestAttachment, date, false, false, new ArrayList(0), false);
        }
        return new CellUserAttachmentImage(this.utils, stateMessage, stateRequestAttachment, date, false, false, new ArrayList(0), false);
    }

    public List<CellType.Base> getUserMessage(StateMessage stateMessage) {
        if (UtilsAttachment.hasAttachmentBody(stateMessage)) {
            return new ArrayList();
        }
        return Collections.singletonList(new CellUserMessage(this.utils, stateMessage, false, false, generateRichText(stateMessage.getHtmlBody(), stateMessage.getPlainBody()), new ArrayList(0), false));
    }

    public List<CellType.Base> getViewModelsForMessage(StateMessage stateMessage, boolean z11, StateRequestUser stateRequestUser) {
        List<StateRequestAttachment> attachments = stateMessage.getAttachments();
        ArrayList arrayList = new ArrayList();
        if (z11) {
            arrayList.add(getAgentMessage(stateMessage, stateRequestUser));
        } else {
            arrayList.addAll(getUserMessage(stateMessage));
        }
        int size = attachments.size();
        for (int i11 = 0; i11 < size; i11++) {
            StateRequestAttachment stateRequestAttachment = attachments.get(i11);
            if (z11) {
                arrayList.add(getAgentAttachment(stateRequestAttachment, stateRequestUser, stateMessage.getDate()));
            } else {
                arrayList.add(getUserAttachment(stateMessage, stateRequestAttachment, stateMessage.getDate()));
            }
        }
        return arrayList;
    }

    public List<CellType.Base> insertDateCells(List<CellType.Base> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Date date = new Date(0);
        for (CellType.Base next : list) {
            if (!UtilsDate.isSameDay(date, next.getTimeStamp())) {
                date = next.getTimeStamp();
                arrayList.add(new CellSystemMessages.CellDateMessage(this.utils, UtilsDate.getBeginOfDay(date).getTime(), date));
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public List<CellType.Base> insertRequestStatus(List<CellType.Base> list, RequestStatus requestStatus) {
        if (requestStatus == RequestStatus.Closed && list.size() > 0) {
            list.add(new CellSystemMessages.CellRequestStatus(this.utils, requestStatus));
        }
        return list;
    }

    public List<CellType.Base> insertSystemMessage(StateMessage stateMessage, StateMessage stateMessage2, List<CellType.Base> list, String str, boolean z11) {
        if (z11 && stateMessage2 == stateMessage && f.c(str)) {
            list.add(new CellSystemMessages.CellSystemMessage(stateMessage2.getDate(), str));
        }
        return list;
    }

    public boolean isUserAgent(StateRequestUser stateRequestUser) {
        return stateRequestUser != null && stateRequestUser.isAgent();
    }

    public List<CellType.Base> markAgentCells(List<CellType.Base> list) {
        long j11 = Long.MIN_VALUE;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size) instanceof CellType.Agent) {
                CellType.Agent agent = (CellType.Agent) list.get(size);
                if (j11 != agent.getAgent().getId()) {
                    agent.showAgentName(true);
                    j11 = agent.getAgent().getId();
                } else {
                    agent.showAgentName(false);
                }
            } else {
                j11 = Long.MIN_VALUE;
            }
        }
        return list;
    }

    public List<CellType.Base> markCellsErrored(List<CellType.Base> list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList2 = new ArrayList();
        for (CellType.Base next : list) {
            if (next instanceof CellType.Stateful) {
                CellType.Stateful stateful = (CellType.Stateful) next;
                if (stateful.getStateMessage().getState().getStatus() == 1) {
                    arrayList.add(stateful);
                    linkedHashSet.add(stateful.getStateMessage());
                } else {
                    arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
                    arrayList2.add(next);
                    arrayList.clear();
                    linkedHashSet.clear();
                }
            } else {
                arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
                arrayList2.add(next);
                arrayList.clear();
                linkedHashSet.clear();
            }
        }
        arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
        return arrayList2;
    }

    public List<CellType.Base> markLastDeliveredCell(List<CellType.Base> list) {
        boolean z11;
        boolean z12;
        Iterator<CellType.Base> it2 = list.iterator();
        while (true) {
            z11 = false;
            if (!it2.hasNext()) {
                z12 = false;
                break;
            }
            CellType.Base next = it2.next();
            if ((next instanceof CellType.Stateful) && ((CellType.Stateful) next).getStateMessage().getState().getStatus() == 3) {
                z12 = true;
                break;
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        if (!z12) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Object obj = list.get(size);
                if ((obj instanceof CellType.Stateful) && !z11) {
                    CellType.Stateful stateful = (CellType.Stateful) obj;
                    if (stateful.getStateMessage().getState().getStatus() == 2) {
                        obj = stateful.markAsDelivered();
                    }
                    z11 = true;
                }
                arrayList.add(obj);
            }
            Collections.reverse(arrayList);
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public CellFactory(CellBindHelper cellBindHelper, DocumentRenderer.HtmlParser htmlParser2, DocumentRenderer documentRenderer2) {
        this.utils = cellBindHelper;
        this.htmlParser = htmlParser2;
        this.documentRenderer = documentRenderer2;
    }
}

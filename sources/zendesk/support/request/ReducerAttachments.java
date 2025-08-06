package zendesk.support.request;

import com.zendesk.logger.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mz.a;
import zendesk.belvedere.MediaResult;
import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerAttachments extends Reducer<StateAttachments> {
    private static final String LOG_FORMAT_ATTACHMENT_DROPPED = "Cannot add attachment %s. Size is %d, max attachment size is %d.";
    private static final String LOG_MESSAGE_ATTACHMENTS_DISABLED = "Cannot add attachments, they are disabled in your Zendesk settings.";

    public StateAttachments getInitialState() {
        return new StateAttachments();
    }

    public StateAttachments reduce(StateAttachments stateAttachments, Action<?> action) {
        String actionType = action.getActionType();
        actionType.hashCode();
        char c11 = 65535;
        switch (actionType.hashCode()) {
            case -1326172566:
                if (actionType.equals(ActionFactory.ATTACHMENTS_SELECTED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -635275733:
                if (actionType.equals(ActionFactory.ATTACHMENTS_DESELECTED)) {
                    c11 = 1;
                    break;
                }
                break;
            case -91317760:
                if (actionType.equals(ActionFactory.LOAD_SETTINGS_SUCCESS)) {
                    c11 = 2;
                    break;
                }
                break;
            case 207206879:
                if (actionType.equals(ActionFactory.START_CONFIG)) {
                    c11 = 3;
                    break;
                }
                break;
            case 979542142:
                if (actionType.equals(ActionFactory.CLEAR_ATTACHMENTS)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                ArrayList arrayList = new ArrayList();
                for (MediaResult convert : (List) action.getData()) {
                    arrayList.add(StateRequestAttachment.convert(convert));
                }
                return stateAttachments.newBuilder().addAllSelectedAttachments(arrayList).setSelectedAttachments(a.b(arrayList, stateAttachments.getSelectedAttachments())).build();
            case 1:
                HashSet hashSet = new HashSet();
                for (MediaResult originalUri : (List) action.getData()) {
                    hashSet.add(originalUri.getOriginalUri());
                }
                ArrayList arrayList2 = new ArrayList();
                for (StateRequestAttachment next : stateAttachments.getSelectedAttachments()) {
                    if (!hashSet.contains(next.getParsedLocalUri())) {
                        arrayList2.add(next);
                    }
                }
                return stateAttachments.newBuilder().setSelectedAttachments(arrayList2).build();
            case 2:
                StateSettings stateSettings = (StateSettings) action.getData();
                ArrayList arrayList3 = new ArrayList();
                if (stateSettings.isAttachmentsEnabled()) {
                    long maxAttachmentSize = stateSettings.getMaxAttachmentSize();
                    for (StateRequestAttachment next2 : stateAttachments.getSelectedAttachments()) {
                        if (next2.getSize() > maxAttachmentSize) {
                            Logger.b(RequestActivity.LOG_TAG, LOG_FORMAT_ATTACHMENT_DROPPED, next2.getName(), Long.valueOf(next2.getSize()), Long.valueOf(maxAttachmentSize));
                        } else {
                            arrayList3.add(next2);
                        }
                    }
                    return stateAttachments.newBuilder().setSelectedAttachments(arrayList3).build();
                }
                Logger.l(RequestActivity.LOG_TAG, LOG_MESSAGE_ATTACHMENTS_DISABLED, new Object[0]);
                return new StateAttachments();
            case 3:
                List<StateRequestAttachment> files = ((RequestConfiguration) action.getData()).getFiles();
                return stateAttachments.newBuilder().addAllSelectedAttachments(files).setSelectedAttachments(files).build();
            case 4:
                return new StateAttachments();
            default:
                return null;
        }
    }
}

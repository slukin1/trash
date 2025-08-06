package zendesk.support.request;

import androidx.core.util.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mz.a;
import zendesk.belvedere.MediaResult;
import zendesk.support.CommentResponse;
import zendesk.support.CommentsResponse;
import zendesk.support.Request;
import zendesk.support.RequestStatus;
import zendesk.support.request.ActionCreateComment;
import zendesk.support.request.StateConversation;
import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerConversation extends Reducer<StateConversation> {
    public StateConversation getInitialState() {
        return new StateConversation();
    }

    public StateConversation reduce(StateConversation stateConversation, Action<?> action) {
        String actionType = action.getActionType();
        actionType.hashCode();
        char c11 = 65535;
        switch (actionType.hashCode()) {
            case -1720252100:
                if (actionType.equals(ActionFactory.REQUEST_CLOSED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1679314784:
                if (actionType.equals(ActionFactory.CREATE_COMMENT_SUCCESS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1319777819:
                if (actionType.equals(ActionFactory.CREATE_COMMENT_ERROR)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1193398337:
                if (actionType.equals(ActionFactory.LOAD_COMMENTS_UPDATE_SUCCESS)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1049833133:
                if (actionType.equals(ActionFactory.DELETE_MESSAGE)) {
                    c11 = 4;
                    break;
                }
                break;
            case -903772976:
                if (actionType.equals(ActionFactory.CREATE_REQUEST_SUCCESS)) {
                    c11 = 5;
                    break;
                }
                break;
            case -16010570:
                if (actionType.equals(ActionFactory.LOAD_COMMENTS_INITIAL_SUCCESS)) {
                    c11 = 6;
                    break;
                }
                break;
            case 207206879:
                if (actionType.equals(ActionFactory.START_CONFIG)) {
                    c11 = 7;
                    break;
                }
                break;
            case 397298627:
                if (actionType.equals(ActionFactory.ATTACHMENT_DOWNLOADED)) {
                    c11 = 8;
                    break;
                }
                break;
            case 619382558:
                if (actionType.equals(ActionFactory.CLEAR_MESSAGES)) {
                    c11 = 9;
                    break;
                }
                break;
            case 962828474:
                if (actionType.equals(ActionFactory.LOAD_REQUEST_SUCCESS)) {
                    c11 = 10;
                    break;
                }
                break;
            case 1532422677:
                if (actionType.equals(ActionFactory.CREATE_REQUEST_ERROR)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1712998531:
                if (actionType.equals(ActionFactory.LOAD_COMMENTS_FROM_CACHE_SUCCESS)) {
                    c11 = 12;
                    break;
                }
                break;
            case 1921186300:
                if (actionType.equals(ActionFactory.CREATE_COMMENT)) {
                    c11 = 13;
                    break;
                }
                break;
            case 2066480684:
                if (actionType.equals(ActionFactory.CREATE_REQUEST)) {
                    c11 = 14;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return stateConversation.newBuilder().setStatus(RequestStatus.Closed).build();
            case 1:
            case 5:
                ActionCreateComment.CreateCommentResult createCommentResult = (ActionCreateComment.CreateCommentResult) action.getData();
                StateIdMapper addIdMapping = stateConversation.getMessageIdMapper().addIdMapping(Long.valueOf(createCommentResult.getCommentRemoteId()), Long.valueOf(createCommentResult.getMessage().getId()));
                StateIdMapper attachmentIdMapper = stateConversation.getAttachmentIdMapper();
                for (Map.Entry next : createCommentResult.getLocalToRemoteAttachments().getLocalToRemoteIdMap().entrySet()) {
                    attachmentIdMapper = attachmentIdMapper.addIdMapping((Long) next.getValue(), (Long) next.getKey());
                }
                return stateConversation.newBuilder().setRemoteId(createCommentResult.getRequestId()).setMessageIdMapper(addIdMapping).setAttachmentIdMapper(attachmentIdMapper).setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), Collections.singletonList(createCommentResult.getMessage()))).build();
            case 2:
            case 11:
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), Collections.singletonList((StateMessage) action.getData()))).build();
            case 3:
            case 6:
                c cVar = (c) action.getData();
                List<CommentResponse> comments = ((CommentsResponse) cVar.f8468a).getComments();
                Collections.reverse(comments);
                c<Map<Long, StateRequestAttachment>, StateIdMapper> convert = StateRequestAttachment.convert(comments, (Map<Long, MediaResult>) (Map) cVar.f8469b, stateConversation.getAttachmentIdMapper());
                c<List<StateMessage>, StateIdMapper> convert2 = StateMessage.convert(comments, stateConversation.getMessageIdMapper(), (Map) convert.f8468a);
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), (List) convert2.f8468a)).setAttachmentIdMapper(((StateIdMapper) convert.f8469b).copy()).setMessageIdMapper(((StateIdMapper) convert2.f8469b).copy()).setUsers(StateMessageMergeUtil.mergeUsers(stateConversation.getUsers(), StateRequestUser.convert(((CommentsResponse) cVar.f8468a).getUsers()))).build();
            case 4:
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.removeMessageById(((StateMessage) action.getData()).getId(), stateConversation.getMessages())).build();
            case 7:
                RequestConfiguration requestConfiguration = (RequestConfiguration) action.getData();
                return stateConversation.newBuilder().setLocalId(requestConfiguration.getLocalRequestId()).setRemoteId(requestConfiguration.getRequestId()).setStatus(requestConfiguration.getRequestStatus()).setHasAgentReplies(requestConfiguration.hasAgentReplies()).build();
            case 8:
                c cVar2 = (c) action.getData();
                MediaResult mediaResult = (MediaResult) cVar2.f8469b;
                StateRequestAttachment build = ((StateRequestAttachment) cVar2.f8468a).newBuilder().setLocalFile(mediaResult.getFile()).setLocalUri(mediaResult.getUri().toString()).build();
                List<StateMessage> messages = stateConversation.getMessages();
                ArrayList arrayList = new ArrayList(messages.size());
                for (StateMessage withUpdatedAttachment : messages) {
                    arrayList.add(withUpdatedAttachment.withUpdatedAttachment(build));
                }
                return stateConversation.newBuilder().setMessages(arrayList).build();
            case 9:
                return stateConversation.newBuilder().setMessages(Collections.emptyList()).setMessageIdMapper(new StateIdMapper()).setAttachmentIdMapper(new StateIdMapper()).build();
            case 10:
                Request request = (Request) action.getData();
                return stateConversation.newBuilder().setStatus(request.getStatus()).setHasAgentReplies(a.i(request.getLastCommentingAgents())).build();
            case 12:
                StateConversation stateConversation2 = (StateConversation) action.getData();
                return stateConversation.newBuilder().setMessages(stateConversation2.getMessages()).setAttachmentIdMapper(stateConversation2.getAttachmentIdMapper()).setMessageIdMapper(stateConversation2.getMessageIdMapper()).setUsers(stateConversation2.getUsers()).build();
            case 13:
            case 14:
                StateConversation.Builder newBuilder = stateConversation.newBuilder();
                List<TypeT> c12 = a.c(stateConversation.getMessages());
                c12.add((StateMessage) action.getData());
                return newBuilder.setMessages(c12).build();
            default:
                return null;
        }
    }
}

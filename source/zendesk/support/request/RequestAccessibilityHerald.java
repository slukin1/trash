package zendesk.support.request;

import android.view.View;
import androidx.core.util.c;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$string;
import mz.a;
import zendesk.support.CommentsResponse;
import zendesk.support.request.ActionCreateComment;
import zendesk.support.suas.Action;
import zendesk.support.suas.Listener;

class RequestAccessibilityHerald implements Listener<Action<?>> {
    private final View view;

    public RequestAccessibilityHerald(View view2) {
        this.view = view2;
    }

    private void announce(int i11, Object... objArr) {
        this.view.announceForAccessibility(this.view.getContext().getString(i11, objArr));
    }

    public static RequestAccessibilityHerald create(RequestActivity requestActivity) {
        return new RequestAccessibilityHerald(requestActivity.findViewById(R$id.activity_request_root));
    }

    public void update(Action<?> action) {
        F f11;
        String actionType = action.getActionType();
        actionType.hashCode();
        char c11 = 65535;
        switch (actionType.hashCode()) {
            case -1679314784:
                if (actionType.equals(ActionFactory.CREATE_COMMENT_SUCCESS)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1319777819:
                if (actionType.equals(ActionFactory.CREATE_COMMENT_ERROR)) {
                    c11 = 1;
                    break;
                }
                break;
            case -292168757:
                if (actionType.equals(ActionFactory.LOAD_COMMENTS_INITIAL)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                announce(R$string.zs_request_announce_comment_created_accessibility, ((ActionCreateComment.CreateCommentResult) action.getData()).getMessage().getPlainBody());
                return;
            case 1:
                announce(R$string.zs_request_announce_comment_failed_accessibility, ((StateMessage) action.getData()).getPlainBody());
                return;
            case 2:
                c cVar = (c) action.getData();
                if (cVar != null && (f11 = cVar.f8468a) != null && a.i(((CommentsResponse) f11).getComments())) {
                    announce(R$string.zs_request_announce_comments_loaded_accessibility, new Object[0]);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

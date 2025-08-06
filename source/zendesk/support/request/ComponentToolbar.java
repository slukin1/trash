package zendesk.support.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.c;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$string;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import mz.a;
import mz.f;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentToolbar implements Listener<ToolbarModel> {
    private final ViewToolbarAvatar avatarContainer;
    private final View container;
    private final Context context;
    private final Fade fadeTransition = new Fade();
    private final Picasso picasso;
    private final ViewAlmostRealProgressBar progressBar;
    private final TextView subTitle;
    private final TextView title;
    private final Toolbar toolbar;
    private ToolbarModel toolbarModel;
    private final ToolbarSelector toolbarSelector;

    public static class ToolbarModel {
        public static int STATE_AGENT_INFO = 3;
        public static int STATE_LOADING = 1;
        public static int STATE_TITLE = 2;
        private final List<StateRequestUser> agent;
        private final boolean isProgressEnabled;
        private final Date lastReply;
        private final int toolbarContentState;

        public ToolbarModel(boolean z11, int i11, List<StateRequestUser> list, Date date) {
            this.isProgressEnabled = z11;
            this.toolbarContentState = i11;
            this.agent = list;
            this.lastReply = date;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ToolbarModel toolbarModel = (ToolbarModel) obj;
            if (this.isProgressEnabled != toolbarModel.isProgressEnabled || this.toolbarContentState != toolbarModel.toolbarContentState) {
                return false;
            }
            List<StateRequestUser> list = this.agent;
            if (list == null ? toolbarModel.agent != null : !list.equals(toolbarModel.agent)) {
                return false;
            }
            Date date = this.lastReply;
            Date date2 = toolbarModel.lastReply;
            if (date != null) {
                return date.equals(date2);
            }
            if (date2 == null) {
                return true;
            }
            return false;
        }

        public List<StateRequestUser> getAgents() {
            return this.agent;
        }

        public List<c<String, String>> getAvatarUrls() {
            ArrayList arrayList = new ArrayList();
            for (StateRequestUser next : this.agent) {
                arrayList.add(c.a(next.getAvatar(), next.getName()));
            }
            return arrayList;
        }

        public Date getLastReply() {
            return this.lastReply;
        }

        public String getNameOfFirstAgent() {
            return a.i(this.agent) ? this.agent.get(0).getName() : "";
        }

        public int getToolbarContentState() {
            return this.toolbarContentState;
        }

        public int hashCode() {
            int i11 = (((this.isProgressEnabled ? 1 : 0) * true) + this.toolbarContentState) * 31;
            List<StateRequestUser> list = this.agent;
            int i12 = 0;
            int hashCode = (i11 + (list != null ? list.hashCode() : 0)) * 31;
            Date date = this.lastReply;
            if (date != null) {
                i12 = date.hashCode();
            }
            return hashCode + i12;
        }

        public boolean isProgressEnabled() {
            return this.isProgressEnabled;
        }
    }

    public static class ToolbarSelector implements StateSelector<ToolbarModel> {
        private StateMessage findLastAgentReply(List<StateMessage> list, Map<Long, StateRequestUser> map) {
            for (int size = list.size() - 1; size >= 0; size--) {
                StateMessage stateMessage = list.get(size);
                if (map.containsKey(Long.valueOf(stateMessage.getUserId()))) {
                    return stateMessage;
                }
            }
            return null;
        }

        private List<StateRequestUser> getInvolvedAgents(List<StateMessage> list, Map<Long, StateRequestUser> map) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int size = list.size() - 1; size >= 0; size--) {
                StateMessage stateMessage = list.get(size);
                if (map.containsKey(Long.valueOf(stateMessage.getUserId()))) {
                    linkedHashSet.add(map.get(Long.valueOf(stateMessage.getUserId())));
                }
            }
            return new ArrayList(linkedHashSet);
        }

        private boolean isProgressEnabled(State state) {
            return StateProgress.fomState(state).getRunningRequests() > 0;
        }

        @SuppressLint({"UseSparseArrays"})
        private Map<Long, StateRequestUser> mapAgents(List<StateRequestUser> list) {
            HashMap hashMap = new HashMap();
            for (StateRequestUser next : list) {
                if (next.isAgent()) {
                    hashMap.put(Long.valueOf(next.getId()), next);
                }
            }
            return hashMap;
        }

        public ToolbarModel selectData(State state) {
            int i11;
            boolean isProgressEnabled = isProgressEnabled(state);
            StateConversation fromState = StateConversation.fromState(state);
            Map<Long, StateRequestUser> mapAgents = mapAgents(fromState.getUsers());
            ArrayList arrayList = new ArrayList();
            Date date = null;
            if (!f.c(fromState.getLocalId()) && !f.c(fromState.getRemoteId())) {
                i11 = ToolbarModel.STATE_LOADING;
            } else if (fromState.hasAgentReplies() && mapAgents.size() == 0) {
                i11 = ToolbarModel.STATE_LOADING;
            } else if (!fromState.hasAgentReplies() || mapAgents.size() <= 0) {
                i11 = ToolbarModel.STATE_TITLE;
            } else {
                int i12 = ToolbarModel.STATE_AGENT_INFO;
                StateMessage findLastAgentReply = findLastAgentReply(fromState.getMessages(), mapAgents);
                if (findLastAgentReply != null) {
                    date = findLastAgentReply.getDate();
                }
                arrayList.addAll(getInvolvedAgents(fromState.getMessages(), mapAgents));
                i11 = i12;
            }
            return new ToolbarModel(isProgressEnabled, i11, arrayList, date);
        }
    }

    public ComponentToolbar(Picasso picasso2, Toolbar toolbar2, ViewAlmostRealProgressBar viewAlmostRealProgressBar) {
        this.picasso = picasso2;
        this.progressBar = viewAlmostRealProgressBar;
        this.toolbar = toolbar2;
        this.context = toolbar2.getContext();
        this.toolbarSelector = new ToolbarSelector();
        this.container = toolbar2.findViewById(R$id.activity_request_toolbar_container);
        this.title = (TextView) toolbar2.findViewById(R$id.activity_request_toolbar_custom_title);
        this.subTitle = (TextView) toolbar2.findViewById(R$id.activity_request_toolbar_custom_sub_title);
        this.avatarContainer = (ViewToolbarAvatar) toolbar2.findViewById(R$id.activity_request_toolbar_avatar_holder);
    }

    private void updateProgressBar(boolean z11) {
        if (z11) {
            this.progressBar.start(ViewAlmostRealProgressBar.DONT_STOP_MOVING);
        } else {
            this.progressBar.stop(300);
        }
    }

    private void updateToolbar(ToolbarModel toolbarModel2) {
        if (toolbarModel2.getToolbarContentState() == ToolbarModel.STATE_LOADING) {
            this.container.setVisibility(8);
            this.toolbar.setTitle((CharSequence) "");
        } else if (toolbarModel2.getToolbarContentState() == ToolbarModel.STATE_AGENT_INFO) {
            this.title.setText(toolbarModel2.getNameOfFirstAgent());
            CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(this.context, toolbarModel2.getLastReply().getTime(), true);
            this.subTitle.setText(this.context.getString(R$string.request_toolbar_last_reply, new Object[]{relativeTimeSpanString}));
            this.toolbar.setTitle((CharSequence) "");
            this.avatarContainer.setImageUrls(this.picasso, toolbarModel2.getAvatarUrls());
            TransitionManager.b(this.toolbar, this.fadeTransition);
            this.container.setVisibility(0);
            this.container.setContentDescription(this.container.getContext().getString(R$string.zs_request_toolbar_accessibility, new Object[]{toolbarModel2.getNameOfFirstAgent(), relativeTimeSpanString}));
        } else if (toolbarModel2.getToolbarContentState() == ToolbarModel.STATE_TITLE) {
            this.container.setVisibility(8);
            this.toolbar.setTitle(R$string.request_activity_title);
        }
    }

    public ToolbarSelector getToolbarSelector() {
        return this.toolbarSelector;
    }

    public void update(ToolbarModel toolbarModel2) {
        if (!toolbarModel2.equals(this.toolbarModel)) {
            this.toolbarModel = toolbarModel2;
            updateProgressBar(toolbarModel2.isProgressEnabled());
            updateToolbar(toolbarModel2);
        }
    }
}

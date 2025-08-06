package com.zopim.android.sdk.chatlog;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.chatlog.ConnectionFragment;
import com.zopim.android.sdk.widget.ChatWidgetService;

public class ZopimCommentFragment extends Fragment implements ConnectionFragment.ConnectionListener {
    private static final String EXTRA_COMMENT = "COMMENT";
    private static final String STATE_MENU_ITEM_ENABLED = "MENU_ITEM_ENABLED";
    private static final String STATE_NO_CONNECTION = "NO_CONNECTION";
    private Chat chat;
    private TextInputLayout commentEditor;
    private Menu menu;
    private boolean noConnection;
    private boolean stateMenuItemEnabled = true;

    public static ZopimCommentFragment newInstance(String str) {
        ZopimCommentFragment zopimCommentFragment = new ZopimCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("COMMENT", str);
        zopimCommentFragment.setArguments(bundle);
        return zopimCommentFragment;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null && getArguments().containsKey("COMMENT")) {
            this.commentEditor.getEditText().setText((String) getArguments().getSerializable("COMMENT"));
        }
    }

    public void onConnected() {
        MenuItem findItem;
        this.noConnection = false;
        Menu menu2 = this.menu;
        if (menu2 != null && (findItem = menu2.findItem(R.id.send_comment)) != null && !findItem.isEnabled()) {
            findItem.setEnabled(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chat = ZopimChat.resume(getActivity());
        if (bundle == null) {
            ConnectionToastFragment connectionToastFragment = new ConnectionToastFragment();
            ConnectionFragment connectionFragment = new ConnectionFragment();
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.e(connectionToastFragment, ConnectionToastFragment.class.getName());
            q11.e(connectionFragment, ConnectionFragment.class.getName());
            q11.j();
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu2, menuInflater);
        menuInflater.inflate(R.menu.chat_comment_menu, menu2);
        menu2.findItem(R.id.send_comment).setEnabled(this.stateMenuItemEnabled);
        this.menu = menu2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.zopim_comment_fragment, viewGroup, false);
    }

    public void onDisconnected() {
        MenuItem findItem;
        this.noConnection = true;
        Menu menu2 = this.menu;
        if (menu2 != null && (findItem = menu2.findItem(R.id.send_comment)) != null && findItem.isEnabled()) {
            findItem.setEnabled(false);
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.send_comment == menuItem.getItemId()) {
            if (!this.chat.hasEnded()) {
                this.chat.sendChatComment(this.commentEditor.getEditText().getText().toString().trim());
            }
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    @TargetApi(11)
    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        boolean z11 = true;
        boolean z12 = !this.chat.hasEnded();
        if (Build.VERSION.SDK_INT < 11 ? !z12 || !getActivity().isFinishing() : !z12 || getActivity().isChangingConfigurations()) {
            z11 = false;
        }
        if (z11) {
            ChatWidgetService.startService(getActivity());
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        ChatWidgetService.stopService(getActivity());
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_NO_CONNECTION, this.noConnection);
        bundle.putBoolean("MENU_ITEM_ENABLED", this.menu.findItem(R.id.send_comment).isEnabled());
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        this.commentEditor = (TextInputLayout) view.findViewById(R.id.comment_editor);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.noConnection = bundle.getBoolean(STATE_NO_CONNECTION, false);
            this.stateMenuItemEnabled = bundle.getBoolean("MENU_ITEM_ENABLED", true);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}

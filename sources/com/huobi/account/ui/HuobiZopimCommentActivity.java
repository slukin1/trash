package com.huobi.account.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zopim.android.sdk.chatlog.ZopimCommentActivity;
import com.zopim.android.sdk.chatlog.ZopimCommentFragment;
import pro.huobi.R;

public class HuobiZopimCommentActivity extends ZopimCommentActivity {

    /* renamed from: b  reason: collision with root package name */
    public Menu f41201b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentManager.FragmentLifecycleCallbacks f41202c;

    public class a extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: com.huobi.account.ui.HuobiZopimCommentActivity$a$a  reason: collision with other inner class name */
        public class C0559a implements TextWatcher {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f41204b;

            public C0559a(View view) {
                this.f41204b = view;
            }

            public void afterTextChanged(Editable editable) {
                View view = this.f41204b;
                if (view != null) {
                    view.setEnabled(!TextUtils.isEmpty(editable));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        }

        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void b(View view) {
            HuobiZopimCommentActivity.this.f41201b.performIdentifierAction(R.id.send_comment, 0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
            super.onFragmentAttached(fragmentManager, fragment, context);
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
            if (fragment instanceof ZopimCommentFragment) {
                View findViewById = view.findViewById(R.id.btn_action);
                ((EditText) view.findViewById(R.id.comment_input)).addTextChangedListener(new C0559a(findViewById));
                if (findViewById != null) {
                    findViewById.setOnClickListener(new a0(this));
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((Toolbar) findViewById(R.id.toolbar)).setTitle((CharSequence) "");
        ((TextView) findViewById(R.id.toolbar_title)).setVisibility(8);
        this.f41202c = new a();
        getSupportFragmentManager().r1(this.f41202c, false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem findItem;
        this.f41201b = menu;
        if (!(menu == null || (findItem = menu.findItem(R.id.send_comment)) == null)) {
            findItem.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy() {
        super.onDestroy();
        getSupportFragmentManager().O1(this.f41202c);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }
}

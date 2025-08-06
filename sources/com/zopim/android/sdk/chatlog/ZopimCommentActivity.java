package com.zopim.android.sdk.chatlog;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;

public class ZopimCommentActivity extends AppCompatActivity {
    public static final String EXTRA_COMMENT = "COMMENT";
    private static final String LOG_TAG = "ZopimCommentActivity";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.zopim_comment_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.m0(ZopimCommentFragment.class.getName()) == null) {
            String stringExtra = getIntent() != null ? getIntent().getStringExtra(EXTRA_COMMENT) : null;
            ZopimCommentFragment newInstance = stringExtra != null ? ZopimCommentFragment.newInstance(stringExtra) : new ZopimCommentFragment();
            FragmentTransaction q11 = supportFragmentManager.q();
            q11.c(R.id.comment_fragment_container, newInstance, ZopimCommentFragment.class.getName());
            q11.j();
        }
    }

    public void onDestroy() {
        Logger.j(LOG_TAG, "Activity destroyed", new Object[0]);
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            finish();
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        } else if (R.id.send_comment == menuItem.getItemId()) {
            finish();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return false;
        } else {
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return false;
        }
    }

    @TargetApi(11)
    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= 11 ? !isChangingConfigurations() : isFinishing()) {
            finish();
        }
    }
}

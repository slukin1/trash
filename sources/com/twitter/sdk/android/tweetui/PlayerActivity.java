package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.io.Serializable;

public class PlayerActivity extends Activity {
    public static final String PLAYER_ITEM = "PLAYER_ITEM";
    public PlayerController playerController;

    public static class PlayerItem implements Serializable {
        public final String callToActionText;
        public final String callToActionUrl;
        public final boolean looping;
        public final boolean showVideoControls;
        public final String url;

        public PlayerItem(String str, boolean z11, boolean z12, String str2, String str3) {
            this.url = str;
            this.looping = z11;
            this.showVideoControls = z12;
            this.callToActionText = str2;
            this.callToActionUrl = str3;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__player_activity);
        PlayerController playerController2 = new PlayerController(findViewById(16908290), new SwipeToDismissTouchListener.Callback() {
            public void onDismiss() {
                PlayerActivity.this.finish();
                PlayerActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }

            public void onMove(float f11) {
            }
        });
        this.playerController = playerController2;
        playerController2.prepare((PlayerItem) getIntent().getSerializableExtra(PLAYER_ITEM));
    }

    public void onDestroy() {
        this.playerController.onDestroy();
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        this.playerController.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.playerController.onResume();
    }
}

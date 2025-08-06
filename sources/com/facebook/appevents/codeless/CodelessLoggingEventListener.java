package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;

public class CodelessLoggingEventListener {
    private static final String TAG = "com.facebook.appevents.codeless.CodelessLoggingEventListener";

    public static class AutoLoggingOnClickListener implements View.OnClickListener {
        private View.OnClickListener existingOnClickListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.existingOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (!(this.rootView.get() == null || this.hostView.get() == null)) {
                CodelessLoggingEventListener.logEvent(this.mapping, (View) this.rootView.get(), (View) this.hostView.get());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        private AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2) {
            this.supportCodelessLogging = false;
            if (eventBinding != null && view != null && view2 != null) {
                this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(view2);
                this.rootView = new WeakReference<>(view);
                this.supportCodelessLogging = true;
            }
        }
    }

    public static class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        private WeakReference<AdapterView> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @SensorsDataInstrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i11, j11);
            }
            if (!(this.rootView.get() == null || this.hostView.get() == null)) {
                CodelessLoggingEventListener.logEvent(this.mapping, (View) this.rootView.get(), (View) this.hostView.get());
            }
            SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
        }

        private AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
            this.supportCodelessLogging = false;
            if (eventBinding != null && view != null && adapterView != null) {
                this.existingOnItemClickListener = adapterView.getOnItemClickListener();
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(adapterView);
                this.rootView = new WeakReference<>(view);
                this.supportCodelessLogging = true;
            }
        }
    }

    public static AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingOnClickListener(eventBinding, view, view2);
    }

    public static AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
        return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView);
    }

    /* access modifiers changed from: private */
    public static void logEvent(EventBinding eventBinding, View view, View view2) {
        final String eventName = eventBinding.getEventName();
        final Bundle parameters = CodelessMatcher.getParameters(eventBinding, view, view2);
        if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
            parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
        }
        parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
            }
        });
    }
}

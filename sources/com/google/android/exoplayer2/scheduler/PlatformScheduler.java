package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class PlatformScheduler implements Scheduler {
    private static final String KEY_REQUIREMENTS = "requirements";
    private static final String KEY_SERVICE_ACTION = "service_action";
    private static final String KEY_SERVICE_PACKAGE = "service_package";
    private static final int SUPPORTED_REQUIREMENTS = ((Util.SDK_INT >= 26 ? 16 : 0) | 15);
    private static final String TAG = "PlatformScheduler";
    private final int jobId;
    private final JobScheduler jobScheduler;
    private final ComponentName jobServiceComponentName;

    public static final class PlatformSchedulerService extends JobService {
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int notMetRequirements = new Requirements(extras.getInt("requirements")).getNotMetRequirements(this);
            if (notMetRequirements == 0) {
                Util.startForegroundService(this, new Intent((String) Assertions.checkNotNull(extras.getString(PlatformScheduler.KEY_SERVICE_ACTION))).setPackage((String) Assertions.checkNotNull(extras.getString(PlatformScheduler.KEY_SERVICE_PACKAGE))));
                return false;
            }
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Requirements not met: ");
            sb2.append(notMetRequirements);
            Log.w(PlatformScheduler.TAG, sb2.toString());
            jobFinished(jobParameters, true);
            return false;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    public PlatformScheduler(Context context, int i11) {
        Context applicationContext = context.getApplicationContext();
        this.jobId = i11;
        this.jobServiceComponentName = new ComponentName(applicationContext, PlatformSchedulerService.class);
        this.jobScheduler = (JobScheduler) Assertions.checkNotNull((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    private static JobInfo buildJobInfo(int i11, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements filterRequirements = requirements.filterRequirements(SUPPORTED_REQUIREMENTS);
        if (!filterRequirements.equals(requirements)) {
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Ignoring unsupported requirements: ");
            sb2.append(filterRequirements.getRequirements() ^ requirements.getRequirements());
            Log.w(TAG, sb2.toString());
        }
        JobInfo.Builder builder = new JobInfo.Builder(i11, componentName);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        if (Util.SDK_INT >= 26 && requirements.isStorageNotLowRequired()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(KEY_SERVICE_ACTION, str);
        persistableBundle.putString(KEY_SERVICE_PACKAGE, str2);
        persistableBundle.putInt("requirements", requirements.getRequirements());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public boolean cancel() {
        this.jobScheduler.cancel(this.jobId);
        return true;
    }

    public Requirements getSupportedRequirements(Requirements requirements) {
        return requirements.filterRequirements(SUPPORTED_REQUIREMENTS);
    }

    public boolean schedule(Requirements requirements, String str, String str2) {
        return this.jobScheduler.schedule(buildJobInfo(this.jobId, this.jobServiceComponentName, requirements, str2, str)) == 1;
    }
}

package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzfz extends Thread {
    public final /* synthetic */ zzga zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzfz(zzga zzga, String str, BlockingQueue blockingQueue) {
        this.zza = zzga;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zza.zzh) {
            if (!this.zzd) {
                this.zza.zzi.release();
                this.zza.zzh.notifyAll();
                zzga zzga = this.zza;
                if (this == zzga.zzb) {
                    zzga.zzb = null;
                } else if (this == zzga.zzc) {
                    zzga.zzc = null;
                } else {
                    zzga.zzt.zzaA().zzd().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzt.zzaA().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void run() {
        boolean z11 = false;
        while (!z11) {
            try {
                this.zza.zzi.acquire();
                z11 = true;
            } catch (InterruptedException e11) {
                zzc(e11);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfy zzfy = (zzfy) this.zzc.poll();
                if (zzfy != null) {
                    Process.setThreadPriority(true != zzfy.zza ? 10 : threadPriority);
                    zzfy.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            boolean unused = this.zza.zzj;
                            try {
                                this.zzb.wait(30000);
                            } catch (InterruptedException e12) {
                                zzc(e12);
                            }
                        }
                    }
                    synchronized (this.zza.zzh) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            zzb();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            zzb();
            throw th2;
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}

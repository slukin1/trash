package com.google.android.gms.internal.auth;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzdc {
    private static final Object zza = new Object();
    public static final /* synthetic */ int zzd = 0;
    private static volatile zzda zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(zzcu.zza, (byte[]) null);
    private static final AtomicInteger zzi = new AtomicInteger();
    public final zzcz zzb;
    public final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;

    public /* synthetic */ zzdc(zzcz zzcz, String str, Object obj, boolean z11, zzdb zzdb) {
        if (zzcz.zzb != null) {
            this.zzb = zzcz;
            this.zzc = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void zze(android.content.Context r3) {
        /*
            com.google.android.gms.internal.auth.zzda r0 = zze
            if (r0 != 0) goto L_0x0045
            java.lang.Object r0 = zza
            monitor-enter(r0)
            com.google.android.gms.internal.auth.zzda r1 = zze     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0040
            monitor-enter(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.auth.zzda r1 = zze     // Catch:{ all -> 0x003d }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0015
            r3 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001d
            android.content.Context r1 = r1.zza()     // Catch:{ all -> 0x003d }
            if (r1 == r3) goto L_0x003b
        L_0x001d:
            com.google.android.gms.internal.auth.zzcg.zzd()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.auth.zzdd.zzc()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.auth.zzco.zze()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.auth.zzct r1 = new com.google.android.gms.internal.auth.zzct     // Catch:{ all -> 0x003d }
            r1.<init>(r3)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.auth.zzdj r1 = com.google.android.gms.internal.auth.zzdn.zza(r1)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.auth.zzcd r2 = new com.google.android.gms.internal.auth.zzcd     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            zze = r2     // Catch:{ all -> 0x003d }
            java.util.concurrent.atomic.AtomicInteger r3 = zzi     // Catch:{ all -> 0x003d }
            r3.incrementAndGet()     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r3     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r3
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzdc.zze(android.content.Context):void");
    }

    public abstract Object zza(Object obj);

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r2 = r2.zzb(zzc());
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = r6.zzc
            java.lang.String r1 = "flagName must not be null"
            java.util.Objects.requireNonNull(r0, r1)
        L_0x000b:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r6.zzk
            if (r1 >= r0) goto L_0x00d6
            monitor-enter(r6)
            int r1 = r6.zzk     // Catch:{ all -> 0x00d3 }
            if (r1 >= r0) goto L_0x00d1
            com.google.android.gms.internal.auth.zzda r1 = zze     // Catch:{ all -> 0x00d3 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x00cb
            com.google.android.gms.internal.auth.zzcz r2 = r6.zzb     // Catch:{ all -> 0x00d3 }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x00d3 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x00d3 }
            r3 = 0
            if (r2 == 0) goto L_0x0050
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcz r4 = r6.zzb     // Catch:{ all -> 0x00d3 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x00d3 }
            boolean r2 = com.google.android.gms.internal.auth.zzcq.zza(r2, r4)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x004e
            com.google.android.gms.internal.auth.zzcz r2 = r6.zzb     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x00d3 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00d3 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcz r4 = r6.zzb     // Catch:{ all -> 0x00d3 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcs r5 = com.google.android.gms.internal.auth.zzcs.zza     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcg r2 = com.google.android.gms.internal.auth.zzcg.zza(r2, r4, r5)     // Catch:{ all -> 0x00d3 }
            goto L_0x005e
        L_0x004e:
            r2 = r3
            goto L_0x005e
        L_0x0050:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcz r4 = r6.zzb     // Catch:{ all -> 0x00d3 }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcs r4 = com.google.android.gms.internal.auth.zzcs.zza     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzdd r2 = com.google.android.gms.internal.auth.zzdd.zza(r2, r3, r4)     // Catch:{ all -> 0x00d3 }
        L_0x005e:
            if (r2 == 0) goto L_0x006f
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x00d3 }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x00d3 }
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            if (r2 == 0) goto L_0x0073
            goto L_0x009b
        L_0x0073:
            com.google.android.gms.internal.auth.zzcz r2 = r6.zzb     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.zze     // Catch:{ all -> 0x00d3 }
            if (r2 != 0) goto L_0x0096
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzco r2 = com.google.android.gms.internal.auth.zzco.zza(r2)     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcz r4 = r6.zzb     // Catch:{ all -> 0x00d3 }
            boolean r4 = r4.zze     // Catch:{ all -> 0x00d3 }
            if (r4 == 0) goto L_0x0089
            r4 = r3
            goto L_0x008b
        L_0x0089:
            java.lang.String r4 = r6.zzc     // Catch:{ all -> 0x00d3 }
        L_0x008b:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x0096
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x00d3 }
            goto L_0x0097
        L_0x0096:
            r2 = r3
        L_0x0097:
            if (r2 != 0) goto L_0x009b
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x00d3 }
        L_0x009b:
            com.google.android.gms.internal.auth.zzdj r1 = r1.zzb()     // Catch:{ all -> 0x00d3 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzdh r1 = (com.google.android.gms.internal.auth.zzdh) r1     // Catch:{ all -> 0x00d3 }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x00d3 }
            if (r4 == 0) goto L_0x00c6
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzci r1 = (com.google.android.gms.internal.auth.zzci) r1     // Catch:{ all -> 0x00d3 }
            com.google.android.gms.internal.auth.zzcz r2 = r6.zzb     // Catch:{ all -> 0x00d3 }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x00d3 }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x00d3 }
            java.lang.String r5 = r6.zzc     // Catch:{ all -> 0x00d3 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x00d3 }
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x00d3 }
            goto L_0x00c6
        L_0x00c2:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x00d3 }
        L_0x00c6:
            r6.zzl = r2     // Catch:{ all -> 0x00d3 }
            r6.zzk = r0     // Catch:{ all -> 0x00d3 }
            goto L_0x00d1
        L_0x00cb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d3 }
            r0.<init>(r2)     // Catch:{ all -> 0x00d3 }
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00d1:
            monitor-exit(r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00d6
        L_0x00d3:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00d3 }
            throw r0
        L_0x00d6:
            java.lang.Object r0 = r6.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzdc.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}

package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_5G_SA = 5;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final ImmutableListMultimap<String, Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = createInitialBitrateCountryGroupAssignment();
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.of(248000L, 160000L, 142000L, 127000L, 113000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.of(2200000L, 1300000L, 950000L, 760000L, 520000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.of(4400000L, 2300000L, 1500000L, 1100000L, 640000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.of(10000000L, 7200000L, 5000000L, 2700000L, 1600000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = ImmutableList.of(2600000L, 2200000L, 2000000L, 1500000L, 470000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.of(6200000L, 3900000L, 2300000L, 1300000L, 620000L);
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private final boolean resetOnNetworkTypeChange;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v58, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v72, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v79, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v80, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v81, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v82, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v87, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v89, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v90, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v91, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v93, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v94, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v95, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v96, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v97, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v98, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v99, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v100, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v101, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v102, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v103, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v104, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v105, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v106, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v107, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v108, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v109, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v110, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v111, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v112, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v113, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v114, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v115, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v116, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v117, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v118, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v119, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v120, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v121, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v122, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v123, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v124, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v125, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v126, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v127, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v128, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v129, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v130, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v131, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v132, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v133, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v134, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v135, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v136, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v137, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v138, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v139, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v140, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v141, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v142, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v143, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v144, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v145, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v146, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v147, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v148, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v149, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v150, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v151, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v152, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v153, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v154, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v155, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v156, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v157, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v158, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v159, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v160, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v161, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v162, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v163, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v164, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v165, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v166, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v167, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v168, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v169, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v170, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v171, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v172, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v173, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v174, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v175, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v176, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v177, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v178, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v179, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v180, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v181, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v182, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v183, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v184, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v185, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v186, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v187, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v188, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v189, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v190, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v191, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v192, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v193, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v194, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v195, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v196, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v197, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v198, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v199, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v200, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v201, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v202, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v203, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v204, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v205, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v206, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v207, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v208, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v209, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v210, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v211, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v212, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v213, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v214, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v215, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v216, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v217, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v219, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v220, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v221, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v222, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v223, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v224, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v225, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v226, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v227, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v228, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v229, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v230, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v231, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v232, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v233, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v234, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v235, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v236, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v237, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Integer[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.Integer> createInitialBitrateCountryGroupAssignment() {
        /*
            com.google.common.collect.ImmutableListMultimap$Builder r0 = com.google.common.collect.ImmutableListMultimap.builder()
            r1 = 6
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r2[r5] = r4
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r2[r3] = r8
            r2[r7] = r6
            r9 = 3
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r2[r9] = r6
            r11 = 4
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r2[r11] = r8
            r13 = 5
            r2[r13] = r8
            java.lang.String r14 = "AD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "AT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "AU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "AX"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "AZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BB"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BJ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BQ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "BZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "CA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "CH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "CN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CV"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "CY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "CZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "DE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "DJ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "DK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "DM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "DO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r12
            java.lang.String r14 = "DZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "EC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "EE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "EG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "EH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ER"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ES"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ET"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "FI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "FJ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "FK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "FM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "FO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r6
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "FR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "GB"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GP"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GQ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "GY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r6
            java.lang.String r14 = "HK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "HN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "HR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "HT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "HU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ID"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "IE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "IL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IQ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r12
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "IT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "JE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "JM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "JO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r4
            java.lang.String r14 = "JP"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KP"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "KR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "KW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "KZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LB"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LV"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "LY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ME"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ML"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MP"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MQ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MV"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "MX"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "MZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "NL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "NO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NP"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "NU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "NZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "OM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "PH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "PL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r12
            r2[r13] = r10
            java.lang.String r14 = "PR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "PY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "QA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "RE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "RO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "RS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "RU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "RW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r4
            r2[r13] = r8
            java.lang.String r14 = "SA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SB"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r6
            r2[r13] = r8
            java.lang.String r14 = "SE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r10
            r2[r13] = r8
            java.lang.String r14 = "SG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SJ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "ST"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SV"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SX"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "SZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TD"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TH"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TJ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TL"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TO"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TR"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r12
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TV"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r4
            r2[r13] = r6
            java.lang.String r14 = "TW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "TZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "UA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "UG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r12
            r2[r13] = r8
            java.lang.String r14 = "US"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "UY"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "UZ"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VC"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VG"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VI"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VN"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "VU"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "WF"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r14 = "WS"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r14, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r6 = "XK"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r6, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r6 = "YE"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r6, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r6 = "YT"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r6, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r4 = "ZA"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r4, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            r2[r13] = r8
            java.lang.String r4 = "ZM"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r4, (V[]) r2)
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            r1[r5] = r10
            r1[r3] = r8
            r1[r7] = r12
            r1[r9] = r10
            r1[r11] = r8
            r1[r13] = r8
            java.lang.String r2 = "ZW"
            com.google.common.collect.ImmutableListMultimap$Builder r0 = r0.putAll(r2, (V[]) r1)
            com.google.common.collect.ImmutableListMultimap r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.createInitialBitrateCountryGroupAssignment():com.google.common.collect.ImmutableListMultimap");
    }

    private long getInitialBitrateEstimateForNetworkType(int i11) {
        Long l11 = this.initialBitrateEstimates.get(Integer.valueOf(i11));
        if (l11 == null) {
            l11 = this.initialBitrateEstimates.get(0);
        }
        if (l11 == null) {
            l11 = 1000000L;
        }
        return l11.longValue();
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (singletonInstance == null) {
                singletonInstance = new Builder(context).build();
            }
            defaultBandwidthMeter = singletonInstance;
        }
        return defaultBandwidthMeter;
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z11) {
        return z11 && !dataSpec.isFlagSet(8);
    }

    private void maybeNotifyBandwidthSample(int i11, long j11, long j12) {
        if (i11 != 0 || j11 != 0 || j12 != this.lastReportedBitrateEstimate) {
            this.lastReportedBitrateEstimate = j12;
            this.eventDispatcher.bandwidthSample(i11, j11, j12);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onNetworkTypeChanged(int r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.networkType     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x000b
            boolean r1 = r8.resetOnNetworkTypeChange     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r8)
            return
        L_0x000b:
            boolean r1 = r8.networkTypeOverrideSet     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0011
            int r9 = r8.networkTypeOverride     // Catch:{ all -> 0x0054 }
        L_0x0011:
            if (r0 != r9) goto L_0x0015
            monitor-exit(r8)
            return
        L_0x0015:
            r8.networkType = r9     // Catch:{ all -> 0x0054 }
            r0 = 1
            if (r9 == r0) goto L_0x0052
            if (r9 == 0) goto L_0x0052
            r0 = 8
            if (r9 != r0) goto L_0x0021
            goto L_0x0052
        L_0x0021:
            long r0 = r8.getInitialBitrateEstimateForNetworkType(r9)     // Catch:{ all -> 0x0054 }
            r8.bitrateEstimate = r0     // Catch:{ all -> 0x0054 }
            com.google.android.exoplayer2.util.Clock r9 = r8.clock     // Catch:{ all -> 0x0054 }
            long r0 = r9.elapsedRealtime()     // Catch:{ all -> 0x0054 }
            int r9 = r8.streamCount     // Catch:{ all -> 0x0054 }
            if (r9 <= 0) goto L_0x0037
            long r2 = r8.sampleStartTimeMs     // Catch:{ all -> 0x0054 }
            long r2 = r0 - r2
            int r9 = (int) r2     // Catch:{ all -> 0x0054 }
            goto L_0x0038
        L_0x0037:
            r9 = 0
        L_0x0038:
            r3 = r9
            long r4 = r8.sampleBytesTransferred     // Catch:{ all -> 0x0054 }
            long r6 = r8.bitrateEstimate     // Catch:{ all -> 0x0054 }
            r2 = r8
            r2.maybeNotifyBandwidthSample(r3, r4, r6)     // Catch:{ all -> 0x0054 }
            r8.sampleStartTimeMs = r0     // Catch:{ all -> 0x0054 }
            r0 = 0
            r8.sampleBytesTransferred = r0     // Catch:{ all -> 0x0054 }
            r8.totalBytesTransferred = r0     // Catch:{ all -> 0x0054 }
            r8.totalElapsedTimeMs = r0     // Catch:{ all -> 0x0054 }
            com.google.android.exoplayer2.util.SlidingPercentile r9 = r8.slidingPercentile     // Catch:{ all -> 0x0054 }
            r9.reset()     // Catch:{ all -> 0x0054 }
            monitor-exit(r8)
            return
        L_0x0052:
            monitor-exit(r8)
            return
        L_0x0054:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.onNetworkTypeChanged(int):void");
    }

    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    public /* synthetic */ long getTimeToFirstByteEstimateUs() {
        return a.a(this);
    }

    public TransferListener getTransferListener() {
        return this;
    }

    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z11, int i11) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z11)) {
            this.sampleBytesTransferred += (long) i11;
        }
    }

    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z11) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z11)) {
            Assertions.checkState(this.streamCount > 0);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i11 = (int) (elapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long) i11;
            long j11 = this.totalBytesTransferred;
            long j12 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j11 + j12;
            if (i11 > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt((double) j12), (((float) j12) * 8000.0f) / ((float) i11));
                if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i11, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0;
            }
            this.streamCount--;
        }
    }

    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z11) {
    }

    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z11) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z11)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i11) {
        this.networkTypeOverride = i11;
        this.networkTypeOverrideSet = true;
        onNetworkTypeChanged(i11);
    }

    public static final class Builder {
        private Clock clock;
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context2) {
            Context context3;
            if (context2 == null) {
                context3 = null;
            } else {
                context3 = context2.getApplicationContext();
            }
            this.context = context3;
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context2));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        private static ImmutableList<Integer> getCountryGroupIndices(String str) {
            ImmutableList<Integer> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get((Object) str);
            return immutableList.isEmpty() ? ImmutableList.of(2, 2, 2, 2, 2, 2) : immutableList;
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            ImmutableList<Integer> countryGroupIndices = getCountryGroupIndices(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            ImmutableList<Long> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            hashMap.put(2, immutableList.get(countryGroupIndices.get(0).intValue()));
            hashMap.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(countryGroupIndices.get(1).intValue()));
            hashMap.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(countryGroupIndices.get(2).intValue()));
            hashMap.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(countryGroupIndices.get(3).intValue()));
            hashMap.put(10, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(countryGroupIndices.get(4).intValue()));
            hashMap.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(countryGroupIndices.get(5).intValue()));
            hashMap.put(7, immutableList.get(countryGroupIndices.get(0).intValue()));
            return hashMap;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        public Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j11) {
            for (Integer intValue : this.initialBitrateEstimates.keySet()) {
                setInitialBitrateEstimate(intValue.intValue(), j11);
            }
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z11) {
            this.resetOnNetworkTypeChange = z11;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int i11) {
            this.slidingWindowMaxWeight = i11;
            return this;
        }

        public Builder setInitialBitrateEstimate(int i11, long j11) {
            this.initialBitrateEstimates.put(Integer.valueOf(i11), Long.valueOf(j11));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Ascii.toUpperCase(str));
            return this;
        }
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this((Context) null, ImmutableMap.of(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context, Map<Integer, Long> map, int i11, Clock clock2, boolean z11) {
        this.initialBitrateEstimates = ImmutableMap.copyOf(map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i11);
        this.clock = clock2;
        this.resetOnNetworkTypeChange = z11;
        if (context != null) {
            NetworkTypeObserver instance = NetworkTypeObserver.getInstance(context);
            int networkType2 = instance.getNetworkType();
            this.networkType = networkType2;
            this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType2);
            instance.register(new d(this));
            return;
        }
        this.networkType = 0;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(0);
    }
}

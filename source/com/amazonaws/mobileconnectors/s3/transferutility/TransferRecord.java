package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.concurrent.Future;

class TransferRecord {
    public static final Log M = LogFactory.b(TransferRecord.class);
    public String A;
    public String B;
    public Map<String, String> C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public TransferUtilityOptions J;
    public Future<?> K;
    public Gson L = new Gson();

    /* renamed from: a  reason: collision with root package name */
    public int f14977a;

    /* renamed from: b  reason: collision with root package name */
    public int f14978b;

    /* renamed from: c  reason: collision with root package name */
    public int f14979c;

    /* renamed from: d  reason: collision with root package name */
    public int f14980d;

    /* renamed from: e  reason: collision with root package name */
    public int f14981e;

    /* renamed from: f  reason: collision with root package name */
    public int f14982f;

    /* renamed from: g  reason: collision with root package name */
    public int f14983g;

    /* renamed from: h  reason: collision with root package name */
    public long f14984h;

    /* renamed from: i  reason: collision with root package name */
    public long f14985i;

    /* renamed from: j  reason: collision with root package name */
    public long f14986j;

    /* renamed from: k  reason: collision with root package name */
    public long f14987k;

    /* renamed from: l  reason: collision with root package name */
    public long f14988l;

    /* renamed from: m  reason: collision with root package name */
    public long f14989m;

    /* renamed from: n  reason: collision with root package name */
    public TransferType f14990n;

    /* renamed from: o  reason: collision with root package name */
    public TransferState f14991o;

    /* renamed from: p  reason: collision with root package name */
    public String f14992p;

    /* renamed from: q  reason: collision with root package name */
    public String f14993q;

    /* renamed from: r  reason: collision with root package name */
    public String f14994r;

    /* renamed from: s  reason: collision with root package name */
    public String f14995s;

    /* renamed from: t  reason: collision with root package name */
    public String f14996t;

    /* renamed from: u  reason: collision with root package name */
    public String f14997u;

    /* renamed from: v  reason: collision with root package name */
    public String f14998v;

    /* renamed from: w  reason: collision with root package name */
    public String f14999w;

    /* renamed from: x  reason: collision with root package name */
    public String f15000x;

    /* renamed from: y  reason: collision with root package name */
    public String f15001y;

    /* renamed from: z  reason: collision with root package name */
    public String f15002z;

    public TransferRecord(int i11) {
        this.f14977a = i11;
    }

    public final boolean a() {
        return this.f14983g == 0 && !TransferState.COMPLETED.equals(this.f14991o);
    }

    public boolean b(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions;
        if (connectivityManager == null || (transferUtilityOptions = this.J) == null || transferUtilityOptions.getTransferNetworkConnectionType() == null || this.J.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        Log log = M;
        log.j("Network Connection " + this.J.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.j(this.f14977a, TransferState.WAITING_FOR_NETWORK);
        return false;
    }

    public final boolean c(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    public boolean d() {
        Future<?> future = this.K;
        return future != null && !future.isDone();
    }

    public boolean e(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean b11 = b(transferStatusUpdater, connectivityManager);
        boolean z11 = false;
        if (!b11 && !c(this.f14991o)) {
            z11 = true;
            if (d()) {
                this.K.cancel(true);
            }
        }
        return z11;
    }

    public boolean f(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (d() || !a() || !b(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.f14990n.equals(TransferType.DOWNLOAD)) {
            this.K = TransferThreadPool.c(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.K = TransferThreadPool.c(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public void g(Cursor cursor) {
        this.f14977a = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        this.f14978b = cursor.getInt(cursor.getColumnIndexOrThrow("main_upload_id"));
        this.f14990n = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
        this.f14991o = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.f14992p = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.f14993q = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.f14994r = cursor.getString(cursor.getColumnIndexOrThrow("version_id"));
        this.f14984h = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.f14985i = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        this.f14986j = cursor.getLong(cursor.getColumnIndexOrThrow("speed"));
        this.f14979c = cursor.getInt(cursor.getColumnIndexOrThrow("is_requester_pays"));
        this.f14980d = cursor.getInt(cursor.getColumnIndexOrThrow("is_multipart"));
        this.f14981e = cursor.getInt(cursor.getColumnIndexOrThrow("is_last_part"));
        this.f14982f = cursor.getInt(cursor.getColumnIndexOrThrow("is_encrypted"));
        this.f14983g = cursor.getInt(cursor.getColumnIndexOrThrow("part_num"));
        this.f14997u = cursor.getString(cursor.getColumnIndexOrThrow("etag"));
        this.f14995s = cursor.getString(cursor.getColumnIndexOrThrow("file"));
        this.f14996t = cursor.getString(cursor.getColumnIndexOrThrow("multipart_id"));
        this.f14987k = cursor.getLong(cursor.getColumnIndexOrThrow("range_start"));
        this.f14988l = cursor.getLong(cursor.getColumnIndexOrThrow("range_last"));
        this.f14989m = cursor.getLong(cursor.getColumnIndexOrThrow("file_offset"));
        this.f14998v = cursor.getString(cursor.getColumnIndexOrThrow("header_content_type"));
        this.f14999w = cursor.getString(cursor.getColumnIndexOrThrow("header_content_language"));
        this.f15000x = cursor.getString(cursor.getColumnIndexOrThrow("header_content_disposition"));
        this.f15001y = cursor.getString(cursor.getColumnIndexOrThrow("header_content_encoding"));
        this.f15002z = cursor.getString(cursor.getColumnIndexOrThrow("header_cache_control"));
        this.A = cursor.getString(cursor.getColumnIndexOrThrow("header_expire"));
        this.C = JsonUtils.d(cursor.getString(cursor.getColumnIndexOrThrow("user_metadata")));
        this.D = cursor.getString(cursor.getColumnIndexOrThrow("expiration_time_rule_id"));
        this.E = cursor.getString(cursor.getColumnIndexOrThrow("http_expires_date"));
        this.F = cursor.getString(cursor.getColumnIndexOrThrow("sse_algorithm"));
        this.G = cursor.getString(cursor.getColumnIndexOrThrow("kms_key"));
        this.H = cursor.getString(cursor.getColumnIndexOrThrow("content_md5"));
        this.I = cursor.getString(cursor.getColumnIndexOrThrow("canned_acl"));
        this.B = cursor.getString(cursor.getColumnIndexOrThrow("header_storage_class"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("transfer_utility_options"));
        try {
            this.J = (TransferUtilityOptions) this.L.fromJson(string, TransferUtilityOptions.class);
        } catch (JsonSyntaxException e11) {
            M.b(String.format("Failed to deserialize: %s, setting to default", new Object[]{string}), e11);
            this.J = new TransferUtilityOptions();
        }
    }

    public String toString() {
        return "[" + "id:" + this.f14977a + Constants.ACCEPT_TIME_SEPARATOR_SP + "bucketName:" + this.f14992p + Constants.ACCEPT_TIME_SEPARATOR_SP + "key:" + this.f14993q + Constants.ACCEPT_TIME_SEPARATOR_SP + "file:" + this.f14995s + Constants.ACCEPT_TIME_SEPARATOR_SP + "type:" + this.f14990n + Constants.ACCEPT_TIME_SEPARATOR_SP + "bytesTotal:" + this.f14984h + Constants.ACCEPT_TIME_SEPARATOR_SP + "bytesCurrent:" + this.f14985i + Constants.ACCEPT_TIME_SEPARATOR_SP + "fileOffset:" + this.f14989m + Constants.ACCEPT_TIME_SEPARATOR_SP + "state:" + this.f14991o + Constants.ACCEPT_TIME_SEPARATOR_SP + "cannedAcl:" + this.I + Constants.ACCEPT_TIME_SEPARATOR_SP + "mainUploadId:" + this.f14978b + Constants.ACCEPT_TIME_SEPARATOR_SP + "isMultipart:" + this.f14980d + Constants.ACCEPT_TIME_SEPARATOR_SP + "isLastPart:" + this.f14981e + Constants.ACCEPT_TIME_SEPARATOR_SP + "partNumber:" + this.f14983g + Constants.ACCEPT_TIME_SEPARATOR_SP + "multipartId:" + this.f14996t + Constants.ACCEPT_TIME_SEPARATOR_SP + "eTag:" + this.f14997u + Constants.ACCEPT_TIME_SEPARATOR_SP + "storageClass:" + this.B + Constants.ACCEPT_TIME_SEPARATOR_SP + "userMetadata:" + this.C.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP + "transferUtilityOptions:" + this.L.toJson((Object) this.J) + "]";
    }
}

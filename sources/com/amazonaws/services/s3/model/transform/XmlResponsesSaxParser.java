package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.net.HttpHeaders;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlResponsesSaxParser {

    /* renamed from: c  reason: collision with root package name */
    public static final Log f15374c = LogFactory.b(XmlResponsesSaxParser.class);

    /* renamed from: a  reason: collision with root package name */
    public XMLReader f15375a = null;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15376b = true;

    public static class AccessControlListHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final AccessControlList f15377d = new AccessControlList();

        /* renamed from: e  reason: collision with root package name */
        public Grantee f15378e = null;

        /* renamed from: f  reason: collision with root package name */
        public Permission f15379f = null;

        public void b(String str, String str2, String str3) {
            if (e("AccessControlPolicy", "Owner")) {
                if (str2.equals("ID")) {
                    this.f15377d.getOwner().setId(d());
                } else if (str2.equals("DisplayName")) {
                    this.f15377d.getOwner().setDisplayName(d());
                }
            } else if (e("AccessControlPolicy", "AccessControlList")) {
                if (str2.equals("Grant")) {
                    this.f15377d.grantPermission(this.f15378e, this.f15379f);
                    this.f15378e = null;
                    this.f15379f = null;
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant")) {
                if (str2.equals("Permission")) {
                    this.f15379f = Permission.parsePermission(d());
                }
            } else if (!e("AccessControlPolicy", "AccessControlList", "Grant", "Grantee")) {
            } else {
                if (str2.equals("ID")) {
                    this.f15378e.setIdentifier(d());
                } else if (str2.equals("EmailAddress")) {
                    this.f15378e.setIdentifier(d());
                } else if (str2.equals("URI")) {
                    this.f15378e = GroupGrantee.parseGroupGrantee(d());
                } else if (str2.equals("DisplayName")) {
                    ((CanonicalGrantee) this.f15378e).setDisplayName(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AccessControlPolicy")) {
                if (str2.equals("Owner")) {
                    this.f15377d.setOwner(new Owner());
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant") && str2.equals("Grantee")) {
                String f11 = XmlResponsesSaxParser.i("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(f11)) {
                    this.f15378e = new EmailAddressGrantee((String) null);
                } else if ("CanonicalUser".equals(f11)) {
                    this.f15378e = new CanonicalGrantee((String) null);
                } else {
                    "Group".equals(f11);
                }
            }
        }

        public AccessControlList f() {
            return this.f15377d;
        }
    }

    public static class BucketAccelerateConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketAccelerateConfiguration f15380d = new BucketAccelerateConfiguration((String) null);

        public void b(String str, String str2, String str3) {
            if (e("AccelerateConfiguration") && str2.equals("Status")) {
                this.f15380d.a(d());
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketAccelerateConfiguration f() {
            return this.f15380d;
        }
    }

    public static class BucketCrossOriginConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketCrossOriginConfiguration f15381d = new BucketCrossOriginConfiguration(new ArrayList());

        /* renamed from: e  reason: collision with root package name */
        public CORSRule f15382e;

        /* renamed from: f  reason: collision with root package name */
        public List<CORSRule.AllowedMethods> f15383f = null;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f15384g = null;

        /* renamed from: h  reason: collision with root package name */
        public List<String> f15385h = null;

        /* renamed from: i  reason: collision with root package name */
        public List<String> f15386i = null;

        public void b(String str, String str2, String str3) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f15382e.a(this.f15386i);
                    this.f15382e.b(this.f15383f);
                    this.f15382e.c(this.f15384g);
                    this.f15382e.d(this.f15385h);
                    this.f15386i = null;
                    this.f15383f = null;
                    this.f15384g = null;
                    this.f15385h = null;
                    this.f15381d.getRules().add(this.f15382e);
                    this.f15382e = null;
                }
            } else if (!e("CORSConfiguration", "CORSRule")) {
            } else {
                if (str2.equals("ID")) {
                    this.f15382e.e(d());
                } else if (str2.equals("AllowedOrigin")) {
                    this.f15384g.add(d());
                } else if (str2.equals("AllowedMethod")) {
                    this.f15383f.add(CORSRule.AllowedMethods.fromValue(d()));
                } else if (str2.equals("MaxAgeSeconds")) {
                    this.f15382e.f(Integer.parseInt(d()));
                } else if (str2.equals("ExposeHeader")) {
                    this.f15385h.add(d());
                } else if (str2.equals("AllowedHeader")) {
                    this.f15386i.add(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f15382e = new CORSRule();
                }
            } else if (!e("CORSConfiguration", "CORSRule")) {
            } else {
                if (str2.equals("AllowedOrigin")) {
                    if (this.f15384g == null) {
                        this.f15384g = new ArrayList();
                    }
                } else if (str2.equals("AllowedMethod")) {
                    if (this.f15383f == null) {
                        this.f15383f = new ArrayList();
                    }
                } else if (str2.equals("ExposeHeader")) {
                    if (this.f15385h == null) {
                        this.f15385h = new ArrayList();
                    }
                } else if (str2.equals("AllowedHeader") && this.f15386i == null) {
                    this.f15386i = new LinkedList();
                }
            }
        }

        public BucketCrossOriginConfiguration f() {
            return this.f15381d;
        }
    }

    public static class BucketLifecycleConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketLifecycleConfiguration f15387d = new BucketLifecycleConfiguration(new ArrayList());

        /* renamed from: e  reason: collision with root package name */
        public BucketLifecycleConfiguration.Rule f15388e;

        /* renamed from: f  reason: collision with root package name */
        public BucketLifecycleConfiguration.Transition f15389f;

        /* renamed from: g  reason: collision with root package name */
        public BucketLifecycleConfiguration.NoncurrentVersionTransition f15390g;

        /* renamed from: h  reason: collision with root package name */
        public AbortIncompleteMultipartUpload f15391h;

        /* renamed from: i  reason: collision with root package name */
        public LifecycleFilter f15392i;

        /* renamed from: j  reason: collision with root package name */
        public List<LifecycleFilterPredicate> f15393j;

        /* renamed from: k  reason: collision with root package name */
        public String f15394k;

        /* renamed from: l  reason: collision with root package name */
        public String f15395l;

        public void b(String str, String str2, String str3) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f15387d.getRules().add(this.f15388e);
                    this.f15388e = null;
                }
            } else if (e("LifecycleConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.f15388e.setId(d());
                } else if (str2.equals("Prefix")) {
                    this.f15388e.setPrefix(d());
                } else if (str2.equals("Status")) {
                    this.f15388e.setStatus(d());
                } else if (str2.equals("Transition")) {
                    this.f15388e.addTransition(this.f15389f);
                    this.f15389f = null;
                } else if (str2.equals("NoncurrentVersionTransition")) {
                    this.f15388e.addNoncurrentVersionTransition(this.f15390g);
                    this.f15390g = null;
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.f15388e.setAbortIncompleteMultipartUpload(this.f15391h);
                    this.f15391h = null;
                } else if (str2.equals("Filter")) {
                    this.f15388e.setFilter(this.f15392i);
                    this.f15392i = null;
                }
            } else if (e("LifecycleConfiguration", "Rule", "Expiration")) {
                if (str2.equals(HttpHeaders.DATE)) {
                    this.f15388e.setExpirationDate(ServiceUtils.c(d()));
                } else if (str2.equals("Days")) {
                    this.f15388e.setExpirationInDays(Integer.parseInt(d()));
                } else if (str2.equals("ExpiredObjectDeleteMarker") && "true".equals(d())) {
                    this.f15388e.setExpiredObjectDeleteMarker(true);
                }
            } else if (e("LifecycleConfiguration", "Rule", "Transition")) {
                if (str2.equals("StorageClass")) {
                    this.f15389f.setStorageClass(d());
                } else if (str2.equals(HttpHeaders.DATE)) {
                    this.f15389f.setDate(ServiceUtils.c(d()));
                } else if (str2.equals("Days")) {
                    this.f15389f.setDays(Integer.parseInt(d()));
                }
            } else if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration")) {
                if (str2.equals("NoncurrentDays")) {
                    this.f15388e.setNoncurrentVersionExpirationInDays(Integer.parseInt(d()));
                }
            } else if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionTransition")) {
                if (str2.equals("StorageClass")) {
                    this.f15390g.setStorageClass(d());
                } else if (str2.equals("NoncurrentDays")) {
                    this.f15390g.setDays(Integer.parseInt(d()));
                }
            } else if (e("LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload")) {
                if (str2.equals("DaysAfterInitiation")) {
                    this.f15391h.setDaysAfterInitiation(Integer.parseInt(d()));
                }
            } else if (e("LifecycleConfiguration", "Rule", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15392i.setPredicate(new LifecyclePrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15392i.setPredicate(new LifecycleTagPredicate(new Tag(this.f15394k, this.f15395l)));
                    this.f15394k = null;
                    this.f15395l = null;
                } else if (str2.equals("And")) {
                    this.f15392i.setPredicate(new LifecycleAndOperator(this.f15393j));
                    this.f15393j = null;
                }
            } else if (e("LifecycleConfiguration", "Rule", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15394k = d();
                } else if (str2.equals("Value")) {
                    this.f15395l = d();
                }
            } else if (e("LifecycleConfiguration", "Rule", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f15393j.add(new LifecyclePrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15393j.add(new LifecycleTagPredicate(new Tag(this.f15394k, this.f15395l)));
                    this.f15394k = null;
                    this.f15395l = null;
                }
            } else if (!e("LifecycleConfiguration", "Rule", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15394k = d();
                } else if (str2.equals("Value")) {
                    this.f15395l = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f15388e = new BucketLifecycleConfiguration.Rule();
                }
            } else if (e("LifecycleConfiguration", "Rule")) {
                if (str2.equals("Transition")) {
                    this.f15389f = new BucketLifecycleConfiguration.Transition();
                } else if (str2.equals("NoncurrentVersionTransition")) {
                    this.f15390g = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.f15391h = new AbortIncompleteMultipartUpload();
                } else if (str2.equals("Filter")) {
                    this.f15392i = new LifecycleFilter();
                }
            } else if (e("LifecycleConfiguration", "Rule", "Filter") && str2.equals("And")) {
                this.f15393j = new ArrayList();
            }
        }

        public BucketLifecycleConfiguration f() {
            return this.f15387d;
        }
    }

    public static class BucketLocationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public String f15396d = null;

        public void b(String str, String str2, String str3) {
            if (a() && str2.equals("LocationConstraint")) {
                String d11 = d();
                if (d11.length() == 0) {
                    this.f15396d = null;
                } else {
                    this.f15396d = d11;
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public String f() {
            return this.f15396d;
        }
    }

    public static class BucketLoggingConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketLoggingConfiguration f15397d = new BucketLoggingConfiguration();

        public void b(String str, String str2, String str3) {
            if (!e("BucketLoggingStatus", "LoggingEnabled")) {
                return;
            }
            if (str2.equals("TargetBucket")) {
                this.f15397d.setDestinationBucketName(d());
            } else if (str2.equals("TargetPrefix")) {
                this.f15397d.setLogFilePrefix(d());
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketLoggingConfiguration f() {
            return this.f15397d;
        }
    }

    public static class BucketReplicationConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketReplicationConfiguration f15398d = new BucketReplicationConfiguration();

        /* renamed from: e  reason: collision with root package name */
        public String f15399e;

        /* renamed from: f  reason: collision with root package name */
        public ReplicationRule f15400f;

        /* renamed from: g  reason: collision with root package name */
        public ReplicationDestinationConfig f15401g;

        public void b(String str, String str2, String str3) {
            if (e("ReplicationConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f15398d.addRule(this.f15399e, this.f15400f);
                    this.f15400f = null;
                    this.f15399e = null;
                    this.f15401g = null;
                } else if (str2.equals("Role")) {
                    this.f15398d.setRoleARN(d());
                }
            } else if (e("ReplicationConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.f15399e = d();
                } else if (str2.equals("Prefix")) {
                    this.f15400f.b(d());
                } else if (str2.equals("Status")) {
                    this.f15400f.c(d());
                } else if (str2.equals("Destination")) {
                    this.f15400f.a(this.f15401g);
                }
            } else if (!e("ReplicationConfiguration", "Rule", "Destination")) {
            } else {
                if (str2.equals("Bucket")) {
                    this.f15401g.a(d());
                } else if (str2.equals("StorageClass")) {
                    this.f15401g.b(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ReplicationConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f15400f = new ReplicationRule();
                }
            } else if (e("ReplicationConfiguration", "Rule") && str2.equals("Destination")) {
                this.f15401g = new ReplicationDestinationConfig();
            }
        }

        public BucketReplicationConfiguration f() {
            return this.f15398d;
        }
    }

    public static class BucketTaggingConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketTaggingConfiguration f15402d = new BucketTaggingConfiguration();

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f15403e;

        /* renamed from: f  reason: collision with root package name */
        public String f15404f;

        /* renamed from: g  reason: collision with root package name */
        public String f15405g;

        public void b(String str, String str2, String str3) {
            String str4;
            if (e("Tagging")) {
                if (str2.equals("TagSet")) {
                    this.f15402d.getAllTagSets().add(new TagSet(this.f15403e));
                    this.f15403e = null;
                }
            } else if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    String str5 = this.f15404f;
                    if (!(str5 == null || (str4 = this.f15405g) == null)) {
                        this.f15403e.put(str5, str4);
                    }
                    this.f15404f = null;
                    this.f15405g = null;
                }
            } else if (!e("Tagging", "TagSet", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15404f = d();
                } else if (str2.equals("Value")) {
                    this.f15405g = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f15403e = new HashMap();
            }
        }

        public BucketTaggingConfiguration f() {
            return this.f15402d;
        }
    }

    public static class BucketVersioningConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketVersioningConfiguration f15406d = new BucketVersioningConfiguration();

        public void b(String str, String str2, String str3) {
            if (!e("VersioningConfiguration")) {
                return;
            }
            if (str2.equals("Status")) {
                this.f15406d.setStatus(d());
            } else if (str2.equals("MfaDelete")) {
                String d11 = d();
                if (d11.equals(BucketLifecycleConfiguration.DISABLED)) {
                    this.f15406d.setMfaDeleteEnabled(Boolean.FALSE);
                } else if (d11.equals("Enabled")) {
                    this.f15406d.setMfaDeleteEnabled(Boolean.TRUE);
                } else {
                    this.f15406d.setMfaDeleteEnabled((Boolean) null);
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public BucketVersioningConfiguration f() {
            return this.f15406d;
        }
    }

    public static class BucketWebsiteConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final BucketWebsiteConfiguration f15407d = new BucketWebsiteConfiguration((String) null);

        /* renamed from: e  reason: collision with root package name */
        public RoutingRuleCondition f15408e = null;

        /* renamed from: f  reason: collision with root package name */
        public RedirectRule f15409f = null;

        /* renamed from: g  reason: collision with root package name */
        public RoutingRule f15410g = null;

        public void b(String str, String str2, String str3) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f15407d.setRedirectAllRequestsTo(this.f15409f);
                    this.f15409f = null;
                }
            } else if (e("WebsiteConfiguration", "IndexDocument")) {
                if (str2.equals("Suffix")) {
                    this.f15407d.setIndexDocumentSuffix(d());
                }
            } else if (e("WebsiteConfiguration", "ErrorDocument")) {
                if (str2.equals("Key")) {
                    this.f15407d.setErrorDocument(d());
                }
            } else if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f15407d.getRoutingRules().add(this.f15410g);
                    this.f15410g = null;
                }
            } else if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f15410g.a(this.f15408e);
                    this.f15408e = null;
                } else if (str2.equals("Redirect")) {
                    this.f15410g.b(this.f15409f);
                    this.f15409f = null;
                }
            } else if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition")) {
                if (str2.equals("KeyPrefixEquals")) {
                    this.f15408e.b(d());
                } else if (str2.equals("HttpErrorCodeReturnedEquals")) {
                    this.f15408e.a(d());
                }
            } else if (!e("WebsiteConfiguration", "RedirectAllRequestsTo") && !e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect")) {
            } else {
                if (str2.equals("Protocol")) {
                    this.f15409f.c(d());
                } else if (str2.equals("HostName")) {
                    this.f15409f.a(d());
                } else if (str2.equals("ReplaceKeyPrefixWith")) {
                    this.f15409f.d(d());
                } else if (str2.equals("ReplaceKeyWith")) {
                    this.f15409f.e(d());
                } else if (str2.equals("HttpRedirectCode")) {
                    this.f15409f.b(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f15409f = new RedirectRule();
                }
            } else if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f15410g = new RoutingRule();
                }
            } else if (!e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
            } else {
                if (str2.equals("Condition")) {
                    this.f15408e = new RoutingRuleCondition();
                } else if (str2.equals("Redirect")) {
                    this.f15409f = new RedirectRule();
                }
            }
        }

        public BucketWebsiteConfiguration f() {
            return this.f15407d;
        }
    }

    public static class CompleteMultipartUploadHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult {

        /* renamed from: d  reason: collision with root package name */
        public CompleteMultipartUploadResult f15411d;

        /* renamed from: e  reason: collision with root package name */
        public AmazonS3Exception f15412e;

        /* renamed from: f  reason: collision with root package name */
        public String f15413f;

        /* renamed from: g  reason: collision with root package name */
        public String f15414g;

        /* renamed from: h  reason: collision with root package name */
        public String f15415h;

        public void b(String str, String str2, String str3) {
            AmazonS3Exception amazonS3Exception;
            if (a()) {
                if (str2.equals("Error") && (amazonS3Exception = this.f15412e) != null) {
                    amazonS3Exception.setErrorCode(this.f15415h);
                    this.f15412e.setRequestId(this.f15414g);
                    this.f15412e.setExtendedRequestId(this.f15413f);
                }
            } else if (e("CompleteMultipartUploadResult")) {
                if (str2.equals(HttpHeaders.LOCATION)) {
                    this.f15411d.setLocation(d());
                } else if (str2.equals("Bucket")) {
                    this.f15411d.setBucketName(d());
                } else if (str2.equals("Key")) {
                    this.f15411d.setKey(d());
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15411d.setETag(ServiceUtils.e(d()));
                }
            } else if (!e("Error")) {
            } else {
                if (str2.equals("Code")) {
                    this.f15415h = d();
                } else if (str2.equals("Message")) {
                    this.f15412e = new AmazonS3Exception(d());
                } else if (str2.equals("RequestId")) {
                    this.f15414g = d();
                } else if (str2.equals("HostId")) {
                    this.f15413f = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (a() && str2.equals("CompleteMultipartUploadResult")) {
                this.f15411d = new CompleteMultipartUploadResult();
            }
        }

        public ServerSideEncryptionResult f() {
            return this.f15411d;
        }

        public AmazonS3Exception g() {
            return this.f15412e;
        }

        public CompleteMultipartUploadResult h() {
            return this.f15411d;
        }

        public void setExpirationTime(Date date) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f15411d;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTime(date);
            }
        }

        public void setExpirationTimeRuleId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f15411d;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTimeRuleId(str);
            }
        }

        public void setRequesterCharged(boolean z11) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f15411d;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setRequesterCharged(z11);
            }
        }

        public void setVersionId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f15411d;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setVersionId(str);
            }
        }
    }

    public static class CopyObjectResultHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

        /* renamed from: d  reason: collision with root package name */
        public final CopyObjectResult f15416d = new CopyObjectResult();

        /* renamed from: e  reason: collision with root package name */
        public String f15417e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f15418f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f15419g = null;

        /* renamed from: h  reason: collision with root package name */
        public String f15420h = null;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15421i = false;

        public void b(String str, String str2, String str3) {
            if (e("CopyObjectResult") || e("CopyPartResult")) {
                if (str2.equals("LastModified")) {
                    this.f15416d.setLastModifiedDate(ServiceUtils.c(d()));
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15416d.setETag(ServiceUtils.e(d()));
                }
            } else if (!e("Error")) {
            } else {
                if (str2.equals("Code")) {
                    this.f15417e = d();
                } else if (str2.equals("Message")) {
                    this.f15418f = d();
                } else if (str2.equals("RequestId")) {
                    this.f15419g = d();
                } else if (str2.equals("HostId")) {
                    this.f15420h = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!a()) {
                return;
            }
            if (str2.equals("CopyObjectResult") || str2.equals("CopyPartResult")) {
                this.f15421i = false;
            } else if (str2.equals("Error")) {
                this.f15421i = true;
            }
        }

        public ServerSideEncryptionResult f() {
            return this.f15416d;
        }

        public void setExpirationTime(Date date) {
            this.f15416d.setExpirationTime(date);
        }

        public void setExpirationTimeRuleId(String str) {
            this.f15416d.setExpirationTimeRuleId(str);
        }

        public void setRequesterCharged(boolean z11) {
            this.f15416d.setRequesterCharged(z11);
        }

        public void setVersionId(String str) {
            this.f15416d.setVersionId(str);
        }
    }

    public static class DeleteObjectsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final DeleteObjectsResponse f15422d = new DeleteObjectsResponse();

        /* renamed from: e  reason: collision with root package name */
        public DeleteObjectsResult.DeletedObject f15423e = null;

        /* renamed from: f  reason: collision with root package name */
        public MultiObjectDeleteException.DeleteError f15424f = null;

        public void b(String str, String str2, String str3) {
            if (e("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.f15422d.a().add(this.f15423e);
                    this.f15423e = null;
                } else if (str2.equals("Error")) {
                    this.f15422d.b().add(this.f15424f);
                    this.f15424f = null;
                }
            } else if (e("DeleteResult", "Deleted")) {
                if (str2.equals("Key")) {
                    this.f15423e.setKey(d());
                } else if (str2.equals("VersionId")) {
                    this.f15423e.setVersionId(d());
                } else if (str2.equals("DeleteMarker")) {
                    this.f15423e.setDeleteMarker(d().equals("true"));
                } else if (str2.equals("DeleteMarkerVersionId")) {
                    this.f15423e.setDeleteMarkerVersionId(d());
                }
            } else if (!e("DeleteResult", "Error")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15424f.b(d());
                } else if (str2.equals("VersionId")) {
                    this.f15424f.d(d());
                } else if (str2.equals("Code")) {
                    this.f15424f.a(d());
                } else if (str2.equals("Message")) {
                    this.f15424f.c(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("DeleteResult")) {
                return;
            }
            if (str2.equals("Deleted")) {
                this.f15423e = new DeleteObjectsResult.DeletedObject();
            } else if (str2.equals("Error")) {
                this.f15424f = new MultiObjectDeleteException.DeleteError();
            }
        }

        public DeleteObjectsResponse f() {
            return this.f15422d;
        }
    }

    public static class GetBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final AnalyticsConfiguration f15425d = new AnalyticsConfiguration();

        /* renamed from: e  reason: collision with root package name */
        public AnalyticsFilter f15426e;

        /* renamed from: f  reason: collision with root package name */
        public List<AnalyticsFilterPredicate> f15427f;

        /* renamed from: g  reason: collision with root package name */
        public StorageClassAnalysis f15428g;

        /* renamed from: h  reason: collision with root package name */
        public StorageClassAnalysisDataExport f15429h;

        /* renamed from: i  reason: collision with root package name */
        public AnalyticsExportDestination f15430i;

        /* renamed from: j  reason: collision with root package name */
        public AnalyticsS3BucketDestination f15431j;

        /* renamed from: k  reason: collision with root package name */
        public String f15432k;

        /* renamed from: l  reason: collision with root package name */
        public String f15433l;

        public void b(String str, String str2, String str3) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15425d.setId(d());
                } else if (str2.equals("Filter")) {
                    this.f15425d.setFilter(this.f15426e);
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.f15425d.setStorageClassAnalysis(this.f15428g);
                }
            } else if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15426e.setPredicate(new AnalyticsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15426e.setPredicate(new AnalyticsTagPredicate(new Tag(this.f15432k, this.f15433l)));
                    this.f15432k = null;
                    this.f15433l = null;
                } else if (str2.equals("And")) {
                    this.f15426e.setPredicate(new AnalyticsAndOperator(this.f15427f));
                    this.f15427f = null;
                }
            } else if (e("AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15432k = d();
                } else if (str2.equals("Value")) {
                    this.f15433l = d();
                }
            } else if (e("AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f15427f.add(new AnalyticsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15427f.add(new AnalyticsTagPredicate(new Tag(this.f15432k, this.f15433l)));
                    this.f15432k = null;
                    this.f15433l = null;
                }
            } else if (e("AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15432k = d();
                } else if (str2.equals("Value")) {
                    this.f15433l = d();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f15428g.setDataExport(this.f15429h);
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f15429h.setOutputSchemaVersion(d());
                } else if (str2.equals("Destination")) {
                    this.f15429h.setDestination(this.f15430i);
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f15430i.setS3BucketDestination(this.f15431j);
                }
            } else if (!e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
            } else {
                if (str2.equals("Format")) {
                    this.f15431j.setFormat(d());
                } else if (str2.equals("BucketAccountId")) {
                    this.f15431j.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f15431j.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f15431j.setPrefix(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f15426e = new AnalyticsFilter();
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.f15428g = new StorageClassAnalysis();
                }
            } else if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f15427f = new ArrayList();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f15429h = new StorageClassAnalysisDataExport();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f15430i = new AnalyticsExportDestination();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f15431j = new AnalyticsS3BucketDestination();
            }
        }

        public GetBucketAnalyticsConfigurationResult f() {
            return new GetBucketAnalyticsConfigurationResult().withAnalyticsConfiguration(this.f15425d);
        }
    }

    public static class GetBucketInventoryConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final GetBucketInventoryConfigurationResult f15434d = new GetBucketInventoryConfigurationResult();

        /* renamed from: e  reason: collision with root package name */
        public final InventoryConfiguration f15435e = new InventoryConfiguration();

        /* renamed from: f  reason: collision with root package name */
        public List<String> f15436f;

        /* renamed from: g  reason: collision with root package name */
        public InventoryDestination f15437g;

        /* renamed from: h  reason: collision with root package name */
        public InventoryFilter f15438h;

        /* renamed from: i  reason: collision with root package name */
        public InventoryS3BucketDestination f15439i;

        /* renamed from: j  reason: collision with root package name */
        public InventorySchedule f15440j;

        public void b(String str, String str2, String str3) {
            if (e("InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15435e.setId(d());
                } else if (str2.equals("Destination")) {
                    this.f15435e.setDestination(this.f15437g);
                    this.f15437g = null;
                } else if (str2.equals("IsEnabled")) {
                    this.f15435e.setEnabled(Boolean.valueOf("true".equals(d())));
                } else if (str2.equals("Filter")) {
                    this.f15435e.setInventoryFilter(this.f15438h);
                    this.f15438h = null;
                } else if (str2.equals("IncludedObjectVersions")) {
                    this.f15435e.setIncludedObjectVersions(d());
                } else if (str2.equals(AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                    this.f15435e.setSchedule(this.f15440j);
                    this.f15440j = null;
                } else if (str2.equals("OptionalFields")) {
                    this.f15435e.setOptionalFields(this.f15436f);
                    this.f15436f = null;
                }
            } else if (e("InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f15437g.setS3BucketDestination(this.f15439i);
                    this.f15439i = null;
                }
            } else if (e("InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f15439i.setAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f15439i.setBucketArn(d());
                } else if (str2.equals("Format")) {
                    this.f15439i.setFormat(d());
                } else if (str2.equals("Prefix")) {
                    this.f15439i.setPrefix(d());
                }
            } else if (e("InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15438h.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("InventoryConfiguration", AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                if (str2.equals("Frequency")) {
                    this.f15440j.setFrequency(d());
                }
            } else if (e("InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f15436f.add(d());
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("InventoryConfiguration")) {
                if (str2.equals("Destination")) {
                    this.f15437g = new InventoryDestination();
                } else if (str2.equals("Filter")) {
                    this.f15438h = new InventoryFilter();
                } else if (str2.equals(AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                    this.f15440j = new InventorySchedule();
                } else if (str2.equals("OptionalFields")) {
                    this.f15436f = new ArrayList();
                }
            } else if (e("InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                this.f15439i = new InventoryS3BucketDestination();
            }
        }

        public GetBucketInventoryConfigurationResult f() {
            return this.f15434d.b(this.f15435e);
        }
    }

    public static class GetBucketMetricsConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final MetricsConfiguration f15441d = new MetricsConfiguration();

        /* renamed from: e  reason: collision with root package name */
        public MetricsFilter f15442e;

        /* renamed from: f  reason: collision with root package name */
        public List<MetricsFilterPredicate> f15443f;

        /* renamed from: g  reason: collision with root package name */
        public String f15444g;

        /* renamed from: h  reason: collision with root package name */
        public String f15445h;

        public void b(String str, String str2, String str3) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15441d.setId(d());
                } else if (str2.equals("Filter")) {
                    this.f15441d.setFilter(this.f15442e);
                    this.f15442e = null;
                }
            } else if (e("MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15442e.setPredicate(new MetricsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15442e.setPredicate(new MetricsTagPredicate(new Tag(this.f15444g, this.f15445h)));
                    this.f15444g = null;
                    this.f15445h = null;
                } else if (str2.equals("And")) {
                    this.f15442e.setPredicate(new MetricsAndOperator(this.f15443f));
                    this.f15443f = null;
                }
            } else if (e("MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15444g = d();
                } else if (str2.equals("Value")) {
                    this.f15445h = d();
                }
            } else if (e("MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f15443f.add(new MetricsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15443f.add(new MetricsTagPredicate(new Tag(this.f15444g, this.f15445h)));
                    this.f15444g = null;
                    this.f15445h = null;
                }
            } else if (!e("MetricsConfiguration", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15444g = d();
                } else if (str2.equals("Value")) {
                    this.f15445h = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f15442e = new MetricsFilter();
                }
            } else if (e("MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f15443f = new ArrayList();
            }
        }

        public GetBucketMetricsConfigurationResult f() {
            return new GetBucketMetricsConfigurationResult().withMetricsConfiguration(this.f15441d);
        }
    }

    public static class GetObjectTaggingHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public GetObjectTaggingResult f15446d;

        /* renamed from: e  reason: collision with root package name */
        public List<Tag> f15447e;

        /* renamed from: f  reason: collision with root package name */
        public String f15448f;

        /* renamed from: g  reason: collision with root package name */
        public String f15449g;

        public void b(String str, String str2, String str3) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f15446d = new GetObjectTaggingResult(this.f15447e);
                this.f15447e = null;
            }
            if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    this.f15447e.add(new Tag(this.f15449g, this.f15448f));
                    this.f15449g = null;
                    this.f15448f = null;
                }
            } else if (!e("Tagging", "TagSet", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15449g = d();
                } else if (str2.equals("Value")) {
                    this.f15448f = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f15447e = new ArrayList();
            }
        }

        public GetObjectTaggingResult f() {
            return this.f15446d;
        }
    }

    public static class InitiateMultipartUploadHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final InitiateMultipartUploadResult f15450d = new InitiateMultipartUploadResult();

        public void b(String str, String str2, String str3) {
            if (!e("InitiateMultipartUploadResult")) {
                return;
            }
            if (str2.equals("Bucket")) {
                this.f15450d.setBucketName(d());
            } else if (str2.equals("Key")) {
                this.f15450d.setKey(d());
            } else if (str2.equals("UploadId")) {
                this.f15450d.b(d());
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public InitiateMultipartUploadResult f() {
            return this.f15450d;
        }
    }

    public static class ListAllMyBucketsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final List<Bucket> f15451d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public Owner f15452e = null;

        /* renamed from: f  reason: collision with root package name */
        public Bucket f15453f = null;

        public void b(String str, String str2, String str3) {
            if (e("ListAllMyBucketsResult", "Owner")) {
                if (str2.equals("ID")) {
                    this.f15452e.setId(d());
                } else if (str2.equals("DisplayName")) {
                    this.f15452e.setDisplayName(d());
                }
            } else if (e("ListAllMyBucketsResult", "Buckets")) {
                if (str2.equals("Bucket")) {
                    this.f15451d.add(this.f15453f);
                    this.f15453f = null;
                }
            } else if (!e("ListAllMyBucketsResult", "Buckets", "Bucket")) {
            } else {
                if (str2.equals("Name")) {
                    this.f15453f.setName(d());
                } else if (str2.equals("CreationDate")) {
                    this.f15453f.setCreationDate(DateUtils.h(d()));
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListAllMyBucketsResult")) {
                if (str2.equals("Owner")) {
                    this.f15452e = new Owner();
                }
            } else if (e("ListAllMyBucketsResult", "Buckets") && str2.equals("Bucket")) {
                Bucket bucket = new Bucket();
                this.f15453f = bucket;
                bucket.setOwner(this.f15452e);
            }
        }

        public List<Bucket> f() {
            return this.f15451d;
        }

        public Owner g() {
            return this.f15452e;
        }
    }

    public static class ListBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final ListBucketAnalyticsConfigurationsResult f15454d = new ListBucketAnalyticsConfigurationsResult();

        /* renamed from: e  reason: collision with root package name */
        public AnalyticsConfiguration f15455e;

        /* renamed from: f  reason: collision with root package name */
        public AnalyticsFilter f15456f;

        /* renamed from: g  reason: collision with root package name */
        public List<AnalyticsFilterPredicate> f15457g;

        /* renamed from: h  reason: collision with root package name */
        public StorageClassAnalysis f15458h;

        /* renamed from: i  reason: collision with root package name */
        public StorageClassAnalysisDataExport f15459i;

        /* renamed from: j  reason: collision with root package name */
        public AnalyticsExportDestination f15460j;

        /* renamed from: k  reason: collision with root package name */
        public AnalyticsS3BucketDestination f15461k;

        /* renamed from: l  reason: collision with root package name */
        public String f15462l;

        /* renamed from: m  reason: collision with root package name */
        public String f15463m;

        public void b(String str, String str2, String str3) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    if (this.f15454d.getAnalyticsConfigurationList() == null) {
                        this.f15454d.setAnalyticsConfigurationList(new ArrayList());
                    }
                    this.f15454d.getAnalyticsConfigurationList().add(this.f15455e);
                    this.f15455e = null;
                } else if (str2.equals("IsTruncated")) {
                    this.f15454d.setTruncated("true".equals(d()));
                } else if (str2.equals("ContinuationToken")) {
                    this.f15454d.setContinuationToken(d());
                } else if (str2.equals("NextContinuationToken")) {
                    this.f15454d.setNextContinuationToken(d());
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15455e.setId(d());
                } else if (str2.equals("Filter")) {
                    this.f15455e.setFilter(this.f15456f);
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.f15455e.setStorageClassAnalysis(this.f15458h);
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15456f.setPredicate(new AnalyticsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15456f.setPredicate(new AnalyticsTagPredicate(new Tag(this.f15462l, this.f15463m)));
                    this.f15462l = null;
                    this.f15463m = null;
                } else if (str2.equals("And")) {
                    this.f15456f.setPredicate(new AnalyticsAndOperator(this.f15457g));
                    this.f15457g = null;
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15462l = d();
                } else if (str2.equals("Value")) {
                    this.f15463m = d();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f15457g.add(new AnalyticsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15457g.add(new AnalyticsTagPredicate(new Tag(this.f15462l, this.f15463m)));
                    this.f15462l = null;
                    this.f15463m = null;
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15462l = d();
                } else if (str2.equals("Value")) {
                    this.f15463m = d();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f15458h.setDataExport(this.f15459i);
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f15459i.setOutputSchemaVersion(d());
                } else if (str2.equals("Destination")) {
                    this.f15459i.setDestination(this.f15460j);
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f15460j.setS3BucketDestination(this.f15461k);
                }
            } else if (!e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
            } else {
                if (str2.equals("Format")) {
                    this.f15461k.setFormat(d());
                } else if (str2.equals("BucketAccountId")) {
                    this.f15461k.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f15461k.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f15461k.setPrefix(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    this.f15455e = new AnalyticsConfiguration();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f15456f = new AnalyticsFilter();
                } else if (str2.equals("StorageClassAnalysis")) {
                    this.f15458h = new StorageClassAnalysis();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f15457g = new ArrayList();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f15459i = new StorageClassAnalysisDataExport();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f15460j = new AnalyticsExportDestination();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f15461k = new AnalyticsS3BucketDestination();
            }
        }

        public ListBucketAnalyticsConfigurationsResult f() {
            return this.f15454d;
        }
    }

    public static class ListBucketHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final ObjectListing f15464d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15465e;

        /* renamed from: f  reason: collision with root package name */
        public S3ObjectSummary f15466f;

        /* renamed from: g  reason: collision with root package name */
        public Owner f15467g;

        /* renamed from: h  reason: collision with root package name */
        public String f15468h;

        public void b(String str, String str2, String str3) {
            String str4 = null;
            if (a()) {
                if (str2.equals("ListBucketResult") && this.f15464d.isTruncated() && this.f15464d.getNextMarker() == null) {
                    if (!this.f15464d.getObjectSummaries().isEmpty()) {
                        str4 = this.f15464d.getObjectSummaries().get(this.f15464d.getObjectSummaries().size() - 1).a();
                    } else if (!this.f15464d.getCommonPrefixes().isEmpty()) {
                        str4 = this.f15464d.getCommonPrefixes().get(this.f15464d.getCommonPrefixes().size() - 1);
                    } else {
                        XmlResponsesSaxParser.f15374c.c("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
                    }
                    this.f15464d.setNextMarker(str4);
                }
            } else if (e("ListBucketResult")) {
                if (str2.equals("Name")) {
                    this.f15464d.setBucketName(d());
                    if (XmlResponsesSaxParser.f15374c.i()) {
                        Log a11 = XmlResponsesSaxParser.f15374c;
                        a11.h("Examining listing for bucket: " + this.f15464d.getBucketName());
                    }
                } else if (str2.equals("Prefix")) {
                    this.f15464d.setPrefix(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15465e));
                } else if (str2.equals("Marker")) {
                    this.f15464d.setMarker(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15465e));
                } else if (str2.equals("NextMarker")) {
                    this.f15464d.setNextMarker(XmlResponsesSaxParser.h(d(), this.f15465e));
                } else if (str2.equals("MaxKeys")) {
                    this.f15464d.setMaxKeys(XmlResponsesSaxParser.w(d()));
                } else if (str2.equals("Delimiter")) {
                    this.f15464d.setDelimiter(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15465e));
                } else if (str2.equals("EncodingType")) {
                    this.f15464d.setEncodingType(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("IsTruncated")) {
                    String b11 = StringUtils.b(d());
                    if (b11.startsWith(d.f31895b)) {
                        this.f15464d.setTruncated(false);
                    } else if (b11.startsWith("true")) {
                        this.f15464d.setTruncated(true);
                    } else {
                        throw new IllegalStateException("Invalid value for IsTruncated field: " + b11);
                    }
                } else if (str2.equals("Contents")) {
                    this.f15464d.getObjectSummaries().add(this.f15466f);
                    this.f15466f = null;
                }
            } else if (e("ListBucketResult", "Contents")) {
                if (str2.equals("Key")) {
                    String d11 = d();
                    this.f15468h = d11;
                    this.f15466f.d(XmlResponsesSaxParser.h(d11, this.f15465e));
                } else if (str2.equals("LastModified")) {
                    this.f15466f.e(ServiceUtils.c(d()));
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15466f.c(ServiceUtils.e(d()));
                } else if (str2.equals("Size")) {
                    this.f15466f.g(XmlResponsesSaxParser.D(d()));
                } else if (str2.equals("StorageClass")) {
                    this.f15466f.h(d());
                } else if (str2.equals("Owner")) {
                    this.f15466f.f(this.f15467g);
                    this.f15467g = null;
                }
            } else if (e("ListBucketResult", "Contents", "Owner")) {
                if (str2.equals("ID")) {
                    this.f15467g.setId(d());
                } else if (str2.equals("DisplayName")) {
                    this.f15467g.setDisplayName(d());
                }
            } else if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                this.f15464d.getCommonPrefixes().add(XmlResponsesSaxParser.h(d(), this.f15465e));
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                    this.f15466f = s3ObjectSummary;
                    s3ObjectSummary.b(this.f15464d.getBucketName());
                }
            } else if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.f15467g = new Owner();
            }
        }
    }

    public static class ListBucketInventoryConfigurationsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final ListBucketInventoryConfigurationsResult f15469d = new ListBucketInventoryConfigurationsResult();

        /* renamed from: e  reason: collision with root package name */
        public InventoryConfiguration f15470e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f15471f;

        /* renamed from: g  reason: collision with root package name */
        public InventoryDestination f15472g;

        /* renamed from: h  reason: collision with root package name */
        public InventoryFilter f15473h;

        /* renamed from: i  reason: collision with root package name */
        public InventoryS3BucketDestination f15474i;

        /* renamed from: j  reason: collision with root package name */
        public InventorySchedule f15475j;

        public void b(String str, String str2, String str3) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    if (this.f15469d.getInventoryConfigurationList() == null) {
                        this.f15469d.setInventoryConfigurationList(new ArrayList());
                    }
                    this.f15469d.getInventoryConfigurationList().add(this.f15470e);
                    this.f15470e = null;
                } else if (str2.equals("IsTruncated")) {
                    this.f15469d.setTruncated("true".equals(d()));
                } else if (str2.equals("ContinuationToken")) {
                    this.f15469d.setContinuationToken(d());
                } else if (str2.equals("NextContinuationToken")) {
                    this.f15469d.setNextContinuationToken(d());
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15470e.setId(d());
                } else if (str2.equals("Destination")) {
                    this.f15470e.setDestination(this.f15472g);
                    this.f15472g = null;
                } else if (str2.equals("IsEnabled")) {
                    this.f15470e.setEnabled(Boolean.valueOf("true".equals(d())));
                } else if (str2.equals("Filter")) {
                    this.f15470e.setInventoryFilter(this.f15473h);
                    this.f15473h = null;
                } else if (str2.equals("IncludedObjectVersions")) {
                    this.f15470e.setIncludedObjectVersions(d());
                } else if (str2.equals(AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                    this.f15470e.setSchedule(this.f15475j);
                    this.f15475j = null;
                } else if (str2.equals("OptionalFields")) {
                    this.f15470e.setOptionalFields(this.f15471f);
                    this.f15471f = null;
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f15472g.setS3BucketDestination(this.f15474i);
                    this.f15474i = null;
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f15474i.setAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f15474i.setBucketArn(d());
                } else if (str2.equals("Format")) {
                    this.f15474i.setFormat(d());
                } else if (str2.equals("Prefix")) {
                    this.f15474i.setPrefix(d());
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15473h.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                if (str2.equals("Frequency")) {
                    this.f15475j.setFrequency(d());
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f15471f.add(d());
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    this.f15470e = new InventoryConfiguration();
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Destination")) {
                    this.f15472g = new InventoryDestination();
                } else if (str2.equals("Filter")) {
                    this.f15473h = new InventoryFilter();
                } else if (str2.equals(AppEventsConstants.EVENT_NAME_SCHEDULE)) {
                    this.f15475j = new InventorySchedule();
                } else if (str2.equals("OptionalFields")) {
                    this.f15471f = new ArrayList();
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                this.f15474i = new InventoryS3BucketDestination();
            }
        }

        public ListBucketInventoryConfigurationsResult f() {
            return this.f15469d;
        }
    }

    public static class ListBucketMetricsConfigurationsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final ListBucketMetricsConfigurationsResult f15476d = new ListBucketMetricsConfigurationsResult();

        /* renamed from: e  reason: collision with root package name */
        public MetricsConfiguration f15477e;

        /* renamed from: f  reason: collision with root package name */
        public MetricsFilter f15478f;

        /* renamed from: g  reason: collision with root package name */
        public List<MetricsFilterPredicate> f15479g;

        /* renamed from: h  reason: collision with root package name */
        public String f15480h;

        /* renamed from: i  reason: collision with root package name */
        public String f15481i;

        public void b(String str, String str2, String str3) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    if (this.f15476d.getMetricsConfigurationList() == null) {
                        this.f15476d.setMetricsConfigurationList(new ArrayList());
                    }
                    this.f15476d.getMetricsConfigurationList().add(this.f15477e);
                    this.f15477e = null;
                } else if (str2.equals("IsTruncated")) {
                    this.f15476d.setTruncated("true".equals(d()));
                } else if (str2.equals("ContinuationToken")) {
                    this.f15476d.setContinuationToken(d());
                } else if (str2.equals("NextContinuationToken")) {
                    this.f15476d.setNextContinuationToken(d());
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f15477e.setId(d());
                } else if (str2.equals("Filter")) {
                    this.f15477e.setFilter(this.f15478f);
                    this.f15478f = null;
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f15478f.setPredicate(new MetricsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15478f.setPredicate(new MetricsTagPredicate(new Tag(this.f15480h, this.f15481i)));
                    this.f15480h = null;
                    this.f15481i = null;
                } else if (str2.equals("And")) {
                    this.f15478f.setPredicate(new MetricsAndOperator(this.f15479g));
                    this.f15479g = null;
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f15480h = d();
                } else if (str2.equals("Value")) {
                    this.f15481i = d();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f15479g.add(new MetricsPrefixPredicate(d()));
                } else if (str2.equals("Tag")) {
                    this.f15479g.add(new MetricsTagPredicate(new Tag(this.f15480h, this.f15481i)));
                    this.f15480h = null;
                    this.f15481i = null;
                }
            } else if (!e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag")) {
            } else {
                if (str2.equals("Key")) {
                    this.f15480h = d();
                } else if (str2.equals("Value")) {
                    this.f15481i = d();
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    this.f15477e = new MetricsConfiguration();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f15478f = new MetricsFilter();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f15479g = new ArrayList();
            }
        }

        public ListBucketMetricsConfigurationsResult f() {
            return this.f15476d;
        }
    }

    public static class ListMultipartUploadsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final MultipartUploadListing f15482d = new MultipartUploadListing();

        /* renamed from: e  reason: collision with root package name */
        public MultipartUpload f15483e;

        /* renamed from: f  reason: collision with root package name */
        public Owner f15484f;

        public void b(String str, String str2, String str3) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.f15482d.c(d());
                } else if (str2.equals("KeyMarker")) {
                    this.f15482d.f(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("Delimiter")) {
                    this.f15482d.d(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("Prefix")) {
                    this.f15482d.j(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("UploadIdMarker")) {
                    this.f15482d.l(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("NextKeyMarker")) {
                    this.f15482d.h(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("NextUploadIdMarker")) {
                    this.f15482d.i(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("MaxUploads")) {
                    this.f15482d.g(Integer.parseInt(d()));
                } else if (str2.equals("EncodingType")) {
                    this.f15482d.e(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("IsTruncated")) {
                    this.f15482d.k(Boolean.parseBoolean(d()));
                } else if (str2.equals("Upload")) {
                    this.f15482d.b().add(this.f15483e);
                    this.f15483e = null;
                }
            } else if (e("ListMultipartUploadsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    this.f15482d.a().add(d());
                }
            } else if (e("ListMultipartUploadsResult", "Upload")) {
                if (str2.equals("Key")) {
                    this.f15483e.c(d());
                } else if (str2.equals("UploadId")) {
                    this.f15483e.f(d());
                } else if (str2.equals("Owner")) {
                    this.f15483e.d(this.f15484f);
                    this.f15484f = null;
                } else if (str2.equals("Initiator")) {
                    this.f15483e.b(this.f15484f);
                    this.f15484f = null;
                } else if (str2.equals("StorageClass")) {
                    this.f15483e.e(d());
                } else if (str2.equals("Initiated")) {
                    this.f15483e.a(ServiceUtils.c(d()));
                }
            } else if (!e("ListMultipartUploadsResult", "Upload", "Owner") && !e("ListMultipartUploadsResult", "Upload", "Initiator")) {
            } else {
                if (str2.equals("ID")) {
                    this.f15484f.setId(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("DisplayName")) {
                    this.f15484f.setDisplayName(XmlResponsesSaxParser.g(d()));
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Upload")) {
                    this.f15483e = new MultipartUpload();
                }
            } else if (!e("ListMultipartUploadsResult", "Upload")) {
            } else {
                if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.f15484f = new Owner();
                }
            }
        }

        public MultipartUploadListing f() {
            return this.f15482d;
        }
    }

    public static class ListObjectsV2Handler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final ListObjectsV2Result f15485d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15486e;

        /* renamed from: f  reason: collision with root package name */
        public S3ObjectSummary f15487f;

        /* renamed from: g  reason: collision with root package name */
        public Owner f15488g;

        /* renamed from: h  reason: collision with root package name */
        public String f15489h;

        public void b(String str, String str2, String str3) {
            String str4 = null;
            if (a()) {
                if (str2.equals("ListBucketResult") && this.f15485d.e() && this.f15485d.c() == null) {
                    if (!this.f15485d.d().isEmpty()) {
                        str4 = this.f15485d.d().get(this.f15485d.d().size() - 1).a();
                    } else {
                        XmlResponsesSaxParser.f15374c.c("S3 response indicates truncated results, but contains no object summaries.");
                    }
                    this.f15485d.l(str4);
                }
            } else if (e("ListBucketResult")) {
                if (str2.equals("Name")) {
                    this.f15485d.f(d());
                    if (XmlResponsesSaxParser.f15374c.i()) {
                        Log a11 = XmlResponsesSaxParser.f15374c;
                        a11.h("Examining listing for bucket: " + this.f15485d.a());
                    }
                } else if (str2.equals("Prefix")) {
                    this.f15485d.m(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15486e));
                } else if (str2.equals("MaxKeys")) {
                    this.f15485d.k(XmlResponsesSaxParser.w(d()));
                } else if (str2.equals("NextContinuationToken")) {
                    this.f15485d.l(d());
                } else if (str2.equals("ContinuationToken")) {
                    this.f15485d.g(d());
                } else if (str2.equals("StartAfter")) {
                    this.f15485d.n(XmlResponsesSaxParser.h(d(), this.f15486e));
                } else if (str2.equals("KeyCount")) {
                    this.f15485d.j(XmlResponsesSaxParser.w(d()));
                } else if (str2.equals("Delimiter")) {
                    this.f15485d.h(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15486e));
                } else if (str2.equals("EncodingType")) {
                    this.f15485d.i(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("IsTruncated")) {
                    String b11 = StringUtils.b(d());
                    if (b11.startsWith(d.f31895b)) {
                        this.f15485d.o(false);
                    } else if (b11.startsWith("true")) {
                        this.f15485d.o(true);
                    } else {
                        throw new IllegalStateException("Invalid value for IsTruncated field: " + b11);
                    }
                } else if (str2.equals("Contents")) {
                    this.f15485d.d().add(this.f15487f);
                    this.f15487f = null;
                }
            } else if (e("ListBucketResult", "Contents")) {
                if (str2.equals("Key")) {
                    String d11 = d();
                    this.f15489h = d11;
                    this.f15487f.d(XmlResponsesSaxParser.h(d11, this.f15486e));
                } else if (str2.equals("LastModified")) {
                    this.f15487f.e(ServiceUtils.c(d()));
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15487f.c(ServiceUtils.e(d()));
                } else if (str2.equals("Size")) {
                    this.f15487f.g(XmlResponsesSaxParser.D(d()));
                } else if (str2.equals("StorageClass")) {
                    this.f15487f.h(d());
                } else if (str2.equals("Owner")) {
                    this.f15487f.f(this.f15488g);
                    this.f15488g = null;
                }
            } else if (e("ListBucketResult", "Contents", "Owner")) {
                if (str2.equals("ID")) {
                    this.f15488g.setId(d());
                } else if (str2.equals("DisplayName")) {
                    this.f15488g.setDisplayName(d());
                }
            } else if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                this.f15485d.b().add(XmlResponsesSaxParser.h(d(), this.f15486e));
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                    this.f15487f = s3ObjectSummary;
                    s3ObjectSummary.b(this.f15485d.a());
                }
            } else if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.f15488g = new Owner();
            }
        }
    }

    public static class ListPartsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final PartListing f15490d = new PartListing();

        /* renamed from: e  reason: collision with root package name */
        public PartSummary f15491e;

        /* renamed from: f  reason: collision with root package name */
        public Owner f15492f;

        public void b(String str, String str2, String str3) {
            if (e("ListPartsResult")) {
                if (str2.equals("Bucket")) {
                    this.f15490d.b(d());
                } else if (str2.equals("Key")) {
                    this.f15490d.e(d());
                } else if (str2.equals("UploadId")) {
                    this.f15490d.l(d());
                } else if (str2.equals("Owner")) {
                    this.f15490d.h(this.f15492f);
                    this.f15492f = null;
                } else if (str2.equals("Initiator")) {
                    this.f15490d.d(this.f15492f);
                    this.f15492f = null;
                } else if (str2.equals("StorageClass")) {
                    this.f15490d.j(d());
                } else if (str2.equals("PartNumberMarker")) {
                    this.f15490d.i(g(d()).intValue());
                } else if (str2.equals("NextPartNumberMarker")) {
                    this.f15490d.g(g(d()).intValue());
                } else if (str2.equals("MaxParts")) {
                    this.f15490d.f(g(d()).intValue());
                } else if (str2.equals("EncodingType")) {
                    this.f15490d.c(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("IsTruncated")) {
                    this.f15490d.k(Boolean.parseBoolean(d()));
                } else if (str2.equals("Part")) {
                    this.f15490d.a().add(this.f15491e);
                    this.f15491e = null;
                }
            } else if (e("ListPartsResult", "Part")) {
                if (str2.equals("PartNumber")) {
                    this.f15491e.c(Integer.parseInt(d()));
                } else if (str2.equals("LastModified")) {
                    this.f15491e.b(ServiceUtils.c(d()));
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15491e.a(ServiceUtils.e(d()));
                } else if (str2.equals("Size")) {
                    this.f15491e.d(Long.parseLong(d()));
                }
            } else if (!e("ListPartsResult", "Owner") && !e("ListPartsResult", "Initiator")) {
            } else {
                if (str2.equals("ID")) {
                    this.f15492f.setId(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("DisplayName")) {
                    this.f15492f.setDisplayName(XmlResponsesSaxParser.g(d()));
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListPartsResult")) {
                return;
            }
            if (str2.equals("Part")) {
                this.f15491e = new PartSummary();
            } else if (str2.equals("Owner") || str2.equals("Initiator")) {
                this.f15492f = new Owner();
            }
        }

        public PartListing f() {
            return this.f15490d;
        }

        public final Integer g(String str) {
            String b11 = XmlResponsesSaxParser.g(d());
            if (b11 == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(b11));
        }
    }

    public static class ListVersionsHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public final VersionListing f15493d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15494e;

        /* renamed from: f  reason: collision with root package name */
        public S3VersionSummary f15495f;

        /* renamed from: g  reason: collision with root package name */
        public Owner f15496g;

        public void b(String str, String str2, String str3) {
            if (e("ListVersionsResult")) {
                if (str2.equals("Name")) {
                    this.f15493d.j(d());
                } else if (str2.equals("Prefix")) {
                    this.f15493d.q(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15494e));
                } else if (str2.equals("KeyMarker")) {
                    this.f15493d.m(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15494e));
                } else if (str2.equals("VersionIdMarker")) {
                    this.f15493d.s(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("MaxKeys")) {
                    this.f15493d.n(Integer.parseInt(d()));
                } else if (str2.equals("Delimiter")) {
                    this.f15493d.k(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15494e));
                } else if (str2.equals("EncodingType")) {
                    this.f15493d.l(XmlResponsesSaxParser.g(d()));
                } else if (str2.equals("NextKeyMarker")) {
                    this.f15493d.o(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f15494e));
                } else if (str2.equals("NextVersionIdMarker")) {
                    this.f15493d.p(d());
                } else if (str2.equals("IsTruncated")) {
                    this.f15493d.r("true".equals(d()));
                } else if (str2.equals("Version") || str2.equals("DeleteMarker")) {
                    this.f15493d.i().add(this.f15495f);
                    this.f15495f = null;
                }
            } else if (e("ListVersionsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    String b11 = XmlResponsesSaxParser.g(d());
                    List<String> b12 = this.f15493d.b();
                    if (this.f15494e) {
                        b11 = S3HttpUtils.a(b11);
                    }
                    b12.add(b11);
                }
            } else if (e("ListVersionsResult", "Version") || e("ListVersionsResult", "DeleteMarker")) {
                if (str2.equals("Key")) {
                    this.f15495f.e(XmlResponsesSaxParser.h(d(), this.f15494e));
                } else if (str2.equals("VersionId")) {
                    this.f15495f.j(d());
                } else if (str2.equals("IsLatest")) {
                    this.f15495f.d("true".equals(d()));
                } else if (str2.equals("LastModified")) {
                    this.f15495f.f(ServiceUtils.c(d()));
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.f15495f.b(ServiceUtils.e(d()));
                } else if (str2.equals("Size")) {
                    this.f15495f.h(Long.parseLong(d()));
                } else if (str2.equals("Owner")) {
                    this.f15495f.g(this.f15496g);
                    this.f15496g = null;
                } else if (str2.equals("StorageClass")) {
                    this.f15495f.i(d());
                }
            } else if (!e("ListVersionsResult", "Version", "Owner") && !e("ListVersionsResult", "DeleteMarker", "Owner")) {
            } else {
                if (str2.equals("ID")) {
                    this.f15496g.setId(d());
                } else if (str2.equals("DisplayName")) {
                    this.f15496g.setDisplayName(d());
                }
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListVersionsResult")) {
                if (str2.equals("Version")) {
                    S3VersionSummary s3VersionSummary = new S3VersionSummary();
                    this.f15495f = s3VersionSummary;
                    s3VersionSummary.a(this.f15493d.a());
                } else if (str2.equals("DeleteMarker")) {
                    S3VersionSummary s3VersionSummary2 = new S3VersionSummary();
                    this.f15495f = s3VersionSummary2;
                    s3VersionSummary2.a(this.f15493d.a());
                    this.f15495f.c(true);
                }
            } else if ((e("ListVersionsResult", "Version") || e("ListVersionsResult", "DeleteMarker")) && str2.equals("Owner")) {
                this.f15496g = new Owner();
            }
        }
    }

    public static class RequestPaymentConfigurationHandler extends AbstractHandler {

        /* renamed from: d  reason: collision with root package name */
        public String f15497d = null;

        public void b(String str, String str2, String str3) {
            if (e("RequestPaymentConfiguration") && str2.equals("Payer")) {
                this.f15497d = d();
            }
        }

        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public RequestPaymentConfiguration f() {
            return new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.valueOf(this.f15497d));
        }
    }

    public XmlResponsesSaxParser() throws AmazonClientException {
        try {
            this.f15375a = XMLReaderFactory.createXMLReader();
        } catch (SAXException e11) {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            try {
                this.f15375a = XMLReaderFactory.createXMLReader();
            } catch (SAXException unused) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader", e11);
            }
        }
    }

    public static long D(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e11) {
            Log log = f15374c;
            log.b("Unable to parse long value '" + str + "'", e11);
            return -1;
        }
    }

    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public static String h(String str, boolean z11) {
        return z11 ? S3HttpUtils.a(str) : str;
    }

    public static String i(String str, Attributes attributes) {
        if (!StringUtils.a(str) && attributes != null) {
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                if (attributes.getQName(i11).trim().equalsIgnoreCase(str.trim())) {
                    return attributes.getValue(i11);
                }
            }
        }
        return null;
    }

    public static int w(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            Log log = f15374c;
            log.b("Unable to parse integer value '" + str + "'", e11);
            return -1;
        }
    }

    public ListAllMyBucketsHandler A(InputStream inputStream) throws IOException {
        ListAllMyBucketsHandler listAllMyBucketsHandler = new ListAllMyBucketsHandler();
        K(listAllMyBucketsHandler, L(listAllMyBucketsHandler, inputStream));
        return listAllMyBucketsHandler;
    }

    public ListPartsHandler B(InputStream inputStream) throws IOException {
        ListPartsHandler listPartsHandler = new ListPartsHandler();
        K(listPartsHandler, inputStream);
        return listPartsHandler;
    }

    public BucketLoggingConfigurationHandler C(InputStream inputStream) throws IOException {
        BucketLoggingConfigurationHandler bucketLoggingConfigurationHandler = new BucketLoggingConfigurationHandler();
        K(bucketLoggingConfigurationHandler, inputStream);
        return bucketLoggingConfigurationHandler;
    }

    public GetObjectTaggingHandler E(InputStream inputStream) throws IOException {
        GetObjectTaggingHandler getObjectTaggingHandler = new GetObjectTaggingHandler();
        K(getObjectTaggingHandler, inputStream);
        return getObjectTaggingHandler;
    }

    public BucketReplicationConfigurationHandler F(InputStream inputStream) throws IOException {
        BucketReplicationConfigurationHandler bucketReplicationConfigurationHandler = new BucketReplicationConfigurationHandler();
        K(bucketReplicationConfigurationHandler, inputStream);
        return bucketReplicationConfigurationHandler;
    }

    public RequestPaymentConfigurationHandler G(InputStream inputStream) throws IOException {
        RequestPaymentConfigurationHandler requestPaymentConfigurationHandler = new RequestPaymentConfigurationHandler();
        K(requestPaymentConfigurationHandler, inputStream);
        return requestPaymentConfigurationHandler;
    }

    public BucketTaggingConfigurationHandler H(InputStream inputStream) throws IOException {
        BucketTaggingConfigurationHandler bucketTaggingConfigurationHandler = new BucketTaggingConfigurationHandler();
        K(bucketTaggingConfigurationHandler, inputStream);
        return bucketTaggingConfigurationHandler;
    }

    public BucketVersioningConfigurationHandler I(InputStream inputStream) throws IOException {
        BucketVersioningConfigurationHandler bucketVersioningConfigurationHandler = new BucketVersioningConfigurationHandler();
        K(bucketVersioningConfigurationHandler, inputStream);
        return bucketVersioningConfigurationHandler;
    }

    public BucketWebsiteConfigurationHandler J(InputStream inputStream) throws IOException {
        BucketWebsiteConfigurationHandler bucketWebsiteConfigurationHandler = new BucketWebsiteConfigurationHandler();
        K(bucketWebsiteConfigurationHandler, inputStream);
        return bucketWebsiteConfigurationHandler;
    }

    public void K(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        try {
            Log log = f15374c;
            if (log.i()) {
                log.h("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            this.f15375a.setContentHandler(defaultHandler);
            this.f15375a.setErrorHandler(defaultHandler);
            this.f15375a.parse(new InputSource(bufferedReader));
        } catch (IOException e11) {
            throw e11;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                if (f15374c.e()) {
                    f15374c.b("Unable to close response InputStream up after XML parse failure", e12);
                }
            }
            throw new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th2);
        }
    }

    public InputStream L(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        Log log = f15374c;
        if (log.i()) {
            log.h("Sanitizing XML document destined for handler " + defaultHandler.getClass());
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            char[] cArr = new char[8192];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb2.append(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    return new ByteArrayInputStream(sb2.toString().replaceAll("\r", "&#013;").getBytes(StringUtils.f15560a));
                }
            }
        } catch (IOException e11) {
            throw e11;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                if (f15374c.e()) {
                    f15374c.b("Unable to close response InputStream after failure sanitizing XML document", e12);
                }
            }
            throw new AmazonClientException("Failed to sanitize XML document destined for handler " + defaultHandler.getClass(), th2);
        }
    }

    public BucketAccelerateConfigurationHandler j(InputStream inputStream) throws IOException {
        BucketAccelerateConfigurationHandler bucketAccelerateConfigurationHandler = new BucketAccelerateConfigurationHandler();
        K(bucketAccelerateConfigurationHandler, inputStream);
        return bucketAccelerateConfigurationHandler;
    }

    public AccessControlListHandler k(InputStream inputStream) throws IOException {
        AccessControlListHandler accessControlListHandler = new AccessControlListHandler();
        K(accessControlListHandler, inputStream);
        return accessControlListHandler;
    }

    public BucketCrossOriginConfigurationHandler l(InputStream inputStream) throws IOException {
        BucketCrossOriginConfigurationHandler bucketCrossOriginConfigurationHandler = new BucketCrossOriginConfigurationHandler();
        K(bucketCrossOriginConfigurationHandler, inputStream);
        return bucketCrossOriginConfigurationHandler;
    }

    public BucketLifecycleConfigurationHandler m(InputStream inputStream) throws IOException {
        BucketLifecycleConfigurationHandler bucketLifecycleConfigurationHandler = new BucketLifecycleConfigurationHandler();
        K(bucketLifecycleConfigurationHandler, inputStream);
        return bucketLifecycleConfigurationHandler;
    }

    public ListBucketInventoryConfigurationsHandler n(InputStream inputStream) throws IOException {
        ListBucketInventoryConfigurationsHandler listBucketInventoryConfigurationsHandler = new ListBucketInventoryConfigurationsHandler();
        K(listBucketInventoryConfigurationsHandler, inputStream);
        return listBucketInventoryConfigurationsHandler;
    }

    public String o(InputStream inputStream) throws IOException {
        BucketLocationHandler bucketLocationHandler = new BucketLocationHandler();
        K(bucketLocationHandler, inputStream);
        return bucketLocationHandler.f();
    }

    public CompleteMultipartUploadHandler p(InputStream inputStream) throws IOException {
        CompleteMultipartUploadHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        K(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public CopyObjectResultHandler q(InputStream inputStream) throws IOException {
        CopyObjectResultHandler copyObjectResultHandler = new CopyObjectResultHandler();
        K(copyObjectResultHandler, inputStream);
        return copyObjectResultHandler;
    }

    public DeleteObjectsHandler r(InputStream inputStream) throws IOException {
        DeleteObjectsHandler deleteObjectsHandler = new DeleteObjectsHandler();
        K(deleteObjectsHandler, inputStream);
        return deleteObjectsHandler;
    }

    public GetBucketAnalyticsConfigurationHandler s(InputStream inputStream) throws IOException {
        GetBucketAnalyticsConfigurationHandler getBucketAnalyticsConfigurationHandler = new GetBucketAnalyticsConfigurationHandler();
        K(getBucketAnalyticsConfigurationHandler, inputStream);
        return getBucketAnalyticsConfigurationHandler;
    }

    public GetBucketInventoryConfigurationHandler t(InputStream inputStream) throws IOException {
        GetBucketInventoryConfigurationHandler getBucketInventoryConfigurationHandler = new GetBucketInventoryConfigurationHandler();
        K(getBucketInventoryConfigurationHandler, inputStream);
        return getBucketInventoryConfigurationHandler;
    }

    public GetBucketMetricsConfigurationHandler u(InputStream inputStream) throws IOException {
        GetBucketMetricsConfigurationHandler getBucketMetricsConfigurationHandler = new GetBucketMetricsConfigurationHandler();
        K(getBucketMetricsConfigurationHandler, inputStream);
        return getBucketMetricsConfigurationHandler;
    }

    public InitiateMultipartUploadHandler v(InputStream inputStream) throws IOException {
        InitiateMultipartUploadHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        K(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    public ListBucketAnalyticsConfigurationHandler x(InputStream inputStream) throws IOException {
        ListBucketAnalyticsConfigurationHandler listBucketAnalyticsConfigurationHandler = new ListBucketAnalyticsConfigurationHandler();
        K(listBucketAnalyticsConfigurationHandler, inputStream);
        return listBucketAnalyticsConfigurationHandler;
    }

    public ListBucketMetricsConfigurationsHandler y(InputStream inputStream) throws IOException {
        ListBucketMetricsConfigurationsHandler listBucketMetricsConfigurationsHandler = new ListBucketMetricsConfigurationsHandler();
        K(listBucketMetricsConfigurationsHandler, inputStream);
        return listBucketMetricsConfigurationsHandler;
    }

    public ListMultipartUploadsHandler z(InputStream inputStream) throws IOException {
        ListMultipartUploadsHandler listMultipartUploadsHandler = new ListMultipartUploadsHandler();
        K(listMultipartUploadsHandler, inputStream);
        return listMultipartUploadsHandler;
    }
}

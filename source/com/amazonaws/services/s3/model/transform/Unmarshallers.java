package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.List;

public class Unmarshallers {

    public static final class AccessControlListUnmarshaller implements Unmarshaller<AccessControlList, InputStream> {
        /* renamed from: b */
        public AccessControlList a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().k(inputStream).f();
        }
    }

    public static final class BucketAccelerateConfigurationUnmarshaller implements Unmarshaller<BucketAccelerateConfiguration, InputStream> {
        /* renamed from: b */
        public BucketAccelerateConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().j(inputStream).f();
        }
    }

    public static final class BucketCrossOriginConfigurationUnmarshaller implements Unmarshaller<BucketCrossOriginConfiguration, InputStream> {
        /* renamed from: b */
        public BucketCrossOriginConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().l(inputStream).f();
        }
    }

    public static final class BucketLifecycleConfigurationUnmarshaller implements Unmarshaller<BucketLifecycleConfiguration, InputStream> {
        /* renamed from: b */
        public BucketLifecycleConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().m(inputStream).f();
        }
    }

    public static final class BucketLocationUnmarshaller implements Unmarshaller<String, InputStream> {
        /* renamed from: b */
        public String a(InputStream inputStream) throws Exception {
            String o11 = new XmlResponsesSaxParser().o(inputStream);
            return o11 == null ? "US" : o11;
        }
    }

    public static final class BucketLoggingConfigurationnmarshaller implements Unmarshaller<BucketLoggingConfiguration, InputStream> {
        /* renamed from: b */
        public BucketLoggingConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().C(inputStream).f();
        }
    }

    public static final class BucketReplicationConfigurationUnmarshaller implements Unmarshaller<BucketReplicationConfiguration, InputStream> {
        /* renamed from: b */
        public BucketReplicationConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().F(inputStream).f();
        }
    }

    public static final class BucketTaggingConfigurationUnmarshaller implements Unmarshaller<BucketTaggingConfiguration, InputStream> {
        /* renamed from: b */
        public BucketTaggingConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().H(inputStream).f();
        }
    }

    public static final class BucketVersioningConfigurationUnmarshaller implements Unmarshaller<BucketVersioningConfiguration, InputStream> {
        /* renamed from: b */
        public BucketVersioningConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().I(inputStream).f();
        }
    }

    public static final class BucketWebsiteConfigurationUnmarshaller implements Unmarshaller<BucketWebsiteConfiguration, InputStream> {
        /* renamed from: b */
        public BucketWebsiteConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().J(inputStream).f();
        }
    }

    public static final class CompleteMultipartUploadResultUnmarshaller implements Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream> {
        /* renamed from: b */
        public XmlResponsesSaxParser.CompleteMultipartUploadHandler a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().p(inputStream);
        }
    }

    public static final class CopyObjectUnmarshaller implements Unmarshaller<XmlResponsesSaxParser.CopyObjectResultHandler, InputStream> {
        /* renamed from: b */
        public XmlResponsesSaxParser.CopyObjectResultHandler a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().q(inputStream);
        }
    }

    public static final class DeleteBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<DeleteBucketAnalyticsConfigurationResult, InputStream> {
        /* renamed from: b */
        public DeleteBucketAnalyticsConfigurationResult a(InputStream inputStream) throws Exception {
            return new DeleteBucketAnalyticsConfigurationResult();
        }
    }

    public static final class DeleteBucketInventoryConfigurationUnmarshaller implements Unmarshaller<DeleteBucketInventoryConfigurationResult, InputStream> {
        /* renamed from: b */
        public DeleteBucketInventoryConfigurationResult a(InputStream inputStream) throws Exception {
            return new DeleteBucketInventoryConfigurationResult();
        }
    }

    public static final class DeleteBucketMetricsConfigurationUnmarshaller implements Unmarshaller<DeleteBucketMetricsConfigurationResult, InputStream> {
        /* renamed from: b */
        public DeleteBucketMetricsConfigurationResult a(InputStream inputStream) throws Exception {
            return new DeleteBucketMetricsConfigurationResult();
        }
    }

    public static final class DeleteObjectTaggingResponseUnmarshaller implements Unmarshaller<DeleteObjectTaggingResult, InputStream> {
        /* renamed from: b */
        public DeleteObjectTaggingResult a(InputStream inputStream) throws Exception {
            return new DeleteObjectTaggingResult();
        }
    }

    public static final class DeleteObjectsResultUnmarshaller implements Unmarshaller<DeleteObjectsResponse, InputStream> {
        /* renamed from: b */
        public DeleteObjectsResponse a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().r(inputStream).f();
        }
    }

    public static final class GetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<GetBucketAnalyticsConfigurationResult, InputStream> {
        /* renamed from: b */
        public GetBucketAnalyticsConfigurationResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().s(inputStream).f();
        }
    }

    public static final class GetBucketInventoryConfigurationUnmarshaller implements Unmarshaller<GetBucketInventoryConfigurationResult, InputStream> {
        /* renamed from: b */
        public GetBucketInventoryConfigurationResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().t(inputStream).f();
        }
    }

    public static final class GetBucketMetricsConfigurationUnmarshaller implements Unmarshaller<GetBucketMetricsConfigurationResult, InputStream> {
        /* renamed from: b */
        public GetBucketMetricsConfigurationResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().u(inputStream).f();
        }
    }

    public static final class GetObjectTaggingResponseUnmarshaller implements Unmarshaller<GetObjectTaggingResult, InputStream> {
        /* renamed from: b */
        public GetObjectTaggingResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().E(inputStream).f();
        }
    }

    public static final class InitiateMultipartUploadResultUnmarshaller implements Unmarshaller<InitiateMultipartUploadResult, InputStream> {
        /* renamed from: b */
        public InitiateMultipartUploadResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().v(inputStream).f();
        }
    }

    public static final class InputStreamUnmarshaller implements Unmarshaller<InputStream, InputStream> {
        /* renamed from: b */
        public InputStream a(InputStream inputStream) throws Exception {
            return inputStream;
        }
    }

    public static final class ListBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<ListBucketAnalyticsConfigurationsResult, InputStream> {
        /* renamed from: b */
        public ListBucketAnalyticsConfigurationsResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().x(inputStream).f();
        }
    }

    public static final class ListBucketInventoryConfigurationsUnmarshaller implements Unmarshaller<ListBucketInventoryConfigurationsResult, InputStream> {
        /* renamed from: b */
        public ListBucketInventoryConfigurationsResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().n(inputStream).f();
        }
    }

    public static final class ListBucketMetricsConfigurationsUnmarshaller implements Unmarshaller<ListBucketMetricsConfigurationsResult, InputStream> {
        /* renamed from: b */
        public ListBucketMetricsConfigurationsResult a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().y(inputStream).f();
        }
    }

    public static final class ListBucketsOwnerUnmarshaller implements Unmarshaller<Owner, InputStream> {
        /* renamed from: b */
        public Owner a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().A(inputStream).g();
        }
    }

    public static final class ListBucketsUnmarshaller implements Unmarshaller<List<Bucket>, InputStream> {
        /* renamed from: b */
        public List<Bucket> a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().A(inputStream).f();
        }
    }

    public static final class ListMultipartUploadsResultUnmarshaller implements Unmarshaller<MultipartUploadListing, InputStream> {
        /* renamed from: b */
        public MultipartUploadListing a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().z(inputStream).f();
        }
    }

    public static final class ListPartsResultUnmarshaller implements Unmarshaller<PartListing, InputStream> {
        /* renamed from: b */
        public PartListing a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().B(inputStream).f();
        }
    }

    public static final class RequestPaymentConfigurationUnmarshaller implements Unmarshaller<RequestPaymentConfiguration, InputStream> {
        /* renamed from: b */
        public RequestPaymentConfiguration a(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().G(inputStream).f();
        }
    }

    public static final class SetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller<SetBucketAnalyticsConfigurationResult, InputStream> {
        /* renamed from: b */
        public SetBucketAnalyticsConfigurationResult a(InputStream inputStream) throws Exception {
            return new SetBucketAnalyticsConfigurationResult();
        }
    }

    public static final class SetBucketInventoryConfigurationUnmarshaller implements Unmarshaller<SetBucketInventoryConfigurationResult, InputStream> {
        /* renamed from: b */
        public SetBucketInventoryConfigurationResult a(InputStream inputStream) throws Exception {
            return new SetBucketInventoryConfigurationResult();
        }
    }

    public static final class SetBucketMetricsConfigurationUnmarshaller implements Unmarshaller<SetBucketMetricsConfigurationResult, InputStream> {
        /* renamed from: b */
        public SetBucketMetricsConfigurationResult a(InputStream inputStream) throws Exception {
            return new SetBucketMetricsConfigurationResult();
        }
    }

    public static final class SetObjectTaggingResponseUnmarshaller implements Unmarshaller<SetObjectTaggingResult, InputStream> {
        /* renamed from: b */
        public SetObjectTaggingResult a(InputStream inputStream) throws Exception {
            return new SetObjectTaggingResult();
        }
    }
}

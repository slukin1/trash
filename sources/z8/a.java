package z8;

import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.DepthsInfoSymbol;
import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.db.ChainInfoDao;
import com.hbg.lib.network.pro.db.DepthsInfoSymbolDao;
import com.hbg.lib.network.pro.db.SuperMarginSymbolDao;
import com.hbg.lib.network.pro.db.SymbolBeanDao;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class a extends AbstractDaoSession {

    /* renamed from: a  reason: collision with root package name */
    public final DaoConfig f70946a;

    /* renamed from: b  reason: collision with root package name */
    public final DaoConfig f70947b;

    /* renamed from: c  reason: collision with root package name */
    public final DaoConfig f70948c;

    /* renamed from: d  reason: collision with root package name */
    public final DaoConfig f70949d;

    /* renamed from: e  reason: collision with root package name */
    public final ChainInfoDao f70950e;

    /* renamed from: f  reason: collision with root package name */
    public final DepthsInfoSymbolDao f70951f;

    /* renamed from: g  reason: collision with root package name */
    public final SuperMarginSymbolDao f70952g;

    /* renamed from: h  reason: collision with root package name */
    public final SymbolBeanDao f70953h;

    public a(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(ChainInfoDao.class).clone();
        this.f70946a = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(DepthsInfoSymbolDao.class).clone();
        this.f70947b = clone2;
        clone2.initIdentityScope(identityScopeType);
        DaoConfig clone3 = map.get(SuperMarginSymbolDao.class).clone();
        this.f70948c = clone3;
        clone3.initIdentityScope(identityScopeType);
        DaoConfig clone4 = map.get(SymbolBeanDao.class).clone();
        this.f70949d = clone4;
        clone4.initIdentityScope(identityScopeType);
        ChainInfoDao chainInfoDao = new ChainInfoDao(clone, this);
        this.f70950e = chainInfoDao;
        DepthsInfoSymbolDao depthsInfoSymbolDao = new DepthsInfoSymbolDao(clone2, this);
        this.f70951f = depthsInfoSymbolDao;
        SuperMarginSymbolDao superMarginSymbolDao = new SuperMarginSymbolDao(clone3, this);
        this.f70952g = superMarginSymbolDao;
        SymbolBeanDao symbolBeanDao = new SymbolBeanDao(clone4, this);
        this.f70953h = symbolBeanDao;
        registerDao(ChainInfo.class, chainInfoDao);
        registerDao(DepthsInfoSymbol.class, depthsInfoSymbolDao);
        registerDao(SuperMarginSymbol.class, superMarginSymbolDao);
        registerDao(SymbolBean.class, symbolBeanDao);
    }

    public ChainInfoDao a() {
        return this.f70950e;
    }

    public DepthsInfoSymbolDao b() {
        return this.f70951f;
    }

    public SuperMarginSymbolDao c() {
        return this.f70952g;
    }

    public SymbolBeanDao d() {
        return this.f70953h;
    }
}

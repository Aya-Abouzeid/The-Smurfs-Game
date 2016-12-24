package layouts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class classLoading {

    public ArrayList<Class> loadedShapes = new ArrayList<Class>();

    public classLoading() throws MalformedURLException, ClassNotFoundException {
        final File folder = new File("jars");
        listFilesForFolder(folder);
    }

    public void listFilesForFolder(final File folder) throws MalformedURLException, ClassNotFoundException {
        for (final File jarEntry : folder.listFiles()) {
            String name = jarEntry.getName().substring(0, jarEntry.getName().lastIndexOf("."));
            ClassLoader cl;
            URL JarFile = jarEntry.toURI().toURL();
            //System.out.println(name);
            URL[] urls = new URL[] { JarFile };
            cl = new URLClassLoader(urls);
            Class tmp = cl.loadClass("supportedShapes." + name);
            Class[] interfaces = tmp.getInterfaces();
            String inter = interfaces[0].getSimpleName();
            if((interfaces[0].getSimpleName()).equals("shape"))
                loadedShapes.add(tmp);
        }
    }

}

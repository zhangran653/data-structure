package cl;

import sun.misc.Launcher;

/**
 * @author zhangran
 * @since 2018-12-05
 **/
public class Cl {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        System.out.println(String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(Cl.class.getClassLoader());

    }
}

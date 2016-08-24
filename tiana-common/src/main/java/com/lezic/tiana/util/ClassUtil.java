/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:05:32</p>
 */
package com.lezic.tiana.util;

import java.net.URLDecoder;

/**
 * @author cielo
 * 
 */
public class ClassUtil {

    private static String classPath = getRootPath();

    /**
     * 获取类环境的根路径
     * 
     * @return
     */
    public static String getRootPath() {
        if (classPath != null && !"".equals(classPath)) {
            return classPath;
        }
        String path = ClassUtil.class.getResource("/").getPath();
        if (path.indexOf("%") >= 0) {
            try {
                path = URLDecoder.decode(path, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    /**
     * 获取类的包路径
     * 
     * @param cl
     * @return
     * @author cielo
     */
    public static String getPackagePath(Class<?> cl) {
        String rootPath = ClassUtil.getRootPath();
        String clPath = cl.getResource("").getPath();
        return clPath.substring(rootPath.length());
    }

    public static void main(String[] args) {
        String str = ClassUtil.getPackagePath(ClassUtil.class);
        System.out.println(str);
    }

}

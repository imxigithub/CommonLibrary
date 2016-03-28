package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by kelly on 2016/3/28.
 * 反射类
 */
public class ReflectUtil {

    /**
     * 返回该类的所有公共方法
     * @return
     */
    public static Method[] getMethod(String className){

        Method[]methods = null;
        try {
                    Class<?>clz = Class.forName(className);
                    methods = clz.getMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return methods;
    }

    /**
     * 获取所有未声明的方法
     * @param className
     * @return
     */
     public static Method[] getDeclaredMethod(String className){

         Method[] methods = null;
         try {
                    Class<?>clz = Class.forName(className);
                    methods = clz.getDeclaredMethods();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
        return methods;
     }

    public static Object invoke(String className,String methodName,Object receiver,Class[]parameteType,Object[] parameter){

        Object result  = null;
        try {
                     Class<?>clz = Class.forName(className);
                    Method method = clz.getMethod(methodName, parameteType);
                    method.setAccessible(true);
                    result =  method.invoke(receiver, parameter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取所有的变量
     * @param className
     * @return
     */
    public static Field[] getFileds(String className){
        Field[]fields = null;
        try {
                    Class<?>clz = Class.forName(className);
                    fields = clz.getFields();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return fields;
    }

    /**
     * 指定变量名获取变量
     * @param className
     * @param fieldName
     * @return
     */
    public static Field getField(String className,String fieldName){
        Field field = null;
        try{
            Class<?>clz = Class.forName("");
            field =  clz.getField("fieldName");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }


}

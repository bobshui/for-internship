package basis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class RefConstructor {
 
    public static void main(String args[]) throws Exception {
        RefConstructor ref = new RefConstructor();
        ref.getConstructor();
 
    }
 
    public void getConstructor() throws Exception {
        Class c = null;
        c = Class.forName("java.lang.Long");
        Class cs[] = {java.lang.String.class};
 
        System.out.println("\n-------------------------------\n");
 
        Constructor cst1 = c.getConstructor(cs);
        System.out.println("1��ͨ��������ȡָ��Class����Ĺ��췽����");
        System.out.println(cst1.toString());
 
        Constructor cst2 = c.getDeclaredConstructor(cs);
        System.out.println("2��ͨ��������ȡָ��Class��������ʾ�����ӿڵĹ��췽����");
        System.out.println(cst2.toString());
 
        Constructor cst3 = c.getEnclosingConstructor();
        System.out.println("3����ȡ���ػ�������Constructor ��������ʾ�������������չ��췽����");
        if (cst3 != null) System.out.println(cst3.toString());
        else System.out.println("-- û�л�ȡ���κι��췽����");
 
        Constructor[] csts = c.getConstructors();
        System.out.println("4����ȡָ��Class��������й��췽����");
        for (int i = 0; i < csts.length; i++) {
            System.out.println(csts[i].toString());
        }
 
        System.out.println("\n-------------------------------\n");
 
        Type types1[] = c.getGenericInterfaces();
        System.out.println("1������ֱ��ʵ�ֵĽӿڣ�");
        for (int i = 0; i < types1.length; i++) {
            System.out.println(types1[i].toString());
        }
 
        Type type1 = c.getGenericSuperclass();
        System.out.println("2������ֱ�ӳ��ࣺ");
        System.out.println(type1.toString());
 
        Class[] cis = c.getClasses();
        System.out.println("3�����س��������ʵ�ֵĽӿڣ�");
        for (int i = 0; i < cis.length; i++) {
            System.out.println(cis[i].toString());
        }
 
        Class cs1[] = c.getInterfaces();
        System.out.println("4��ʵ�ֵĽӿ�");
        for (int i = 0; i < cs1.length; i++) {
            System.out.println(cs1[i].toString());
        }
 
        System.out.println("\n-------------------------------\n");
 
        Field fs1[] = c.getFields();
        System.out.println("1�����ӿڵ����пɷ��ʹ����ֶΣ�");
        for (int i = 0; i < fs1.length; i++) {
            System.out.println(fs1[i].toString());
        }
 
        Field f1 = c.getField("MIN_VALUE");
        System.out.println("2�����ӿڵ�ָ��������ָ��������Ա�ֶΣ�");
        System.out.println(f1.toString());
 
        Field fs2[] = c.getDeclaredFields();
        System.out.println("3�����ӿ��������������ֶΣ�");
        for (int i = 0; i < fs2.length; i++) {
            System.out.println(fs2[i].toString());
        }
 
        Field f2 = c.getDeclaredField("serialVersionUID");
        System.out.println("4�����ӿڵ�ָ��������ָ���ֶΣ�");
        System.out.println(f2.toString());
 
        System.out.println("\n-------------------------------\n");
 
        Method m1[] = c.getMethods();
        System.out.println("1�����������еĹ�����Ա������");
        for (int i = 0; i < m1.length; i++) {
            System.out.println(m1[i].toString());
        }
 
        Method m2 = c.getMethod("longValue", new Class[]{});
        System.out.println("2������ָ��������Ա������");
        System.out.println(m2.toString());
 
    }
}
package baseLearning;

import java.lang.annotation.Annotation;

/**
 * 注解：增强 对象，方法，属性的功能
 * 内置注解:
 * @Override:
 * @Deprecated:该方法由于一些安全或者安全问题等，已经不推荐使用。
 * 在版本升级时，要计划删除一些方法，通常会在一些方法中加上。是一个过渡方法
 * @SuppressWarnings：压制警告，或略对泛型等的检查操作，一般不用
 * value值:unchecked ,deprecation不给你提示过期，unused有一些属性是否被使用。
 *@failthrough(switch是否有break检查)
 */
class Father{
    public void eat(){
        System.out.println("Father eat");
    }
}
class Son extends Father{
    @Override
    public void eat(){
        System.out.println("Son eat");
    }
}
public class AnnotationDemo {

    @SuppressWarnings("checked")
    @MyAnnotation(value = "李四",age = 14)
    public static  void test() throws Exception{
        Annotation[] annotations = Class.forName("baseLearning.AnnotationDemo").getMethod("test").getAnnotations();
        for(Annotation a:annotations){
            if(a instanceof MyAnnotation){
                System.out.println(((MyAnnotation) a).age());
                System.out.println(((MyAnnotation) a).value());
            }else if (a instanceof SuppressWarnings) {
               // System.out.println(((Deprecated) a).value());
//                System.out.println(((SuppressWarnings) a).value());
                System.out.println("Deprecated");
            }
        }
    }

    public static void main(String[] args) throws Exception{
      //  Father f=new Son();
      //  f.eat();
        test();
    }
}


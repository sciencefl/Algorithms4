package baseLearning;


import java.io.FileDescriptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 属性在注解中是以方法的形式存在的；
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /*用定义方法的形式定义一个属性value，方法的名字就是属性值
    方法的返回类型就是属性的类型

     */
    String value() default "张三";
    int age() default 22;
}

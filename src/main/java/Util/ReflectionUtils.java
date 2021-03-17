/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 * Author:yangjin
 * Date:2021/3/1714:07
 * History:
 * <author> <time> <version> <desc>
 */
package Util;

import java.lang.reflect.Field;

/**
 * Description:反射工具类 <br>
 *
 * @author yangjin
 * @create 2021/3/17
 * @since 1.0.0
 */
public class ReflectionUtils {
    public static void setProperty(Object obj, String propertyName, Object value)
        throws NoSuchFieldException, SecurityException,
        IllegalArgumentException, IllegalAccessException {
        Class c = obj.getClass();
        Field field = c.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
        field.setAccessible(false);
    }
}
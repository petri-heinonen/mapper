package fi.pmh.sandbox;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CustomMapper {
    public static Money mapBigDecimalToMoney(BigDecimal value) {
        return new Money("EUR", value.toPlainString(), value.toPlainString());
    }
 
    public static <S,T> T map(S source, T target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();
 
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);
            try {
                Object value = sourceField.get(source);
                if (value instanceof BigDecimal) {
                    
                    for (Field targetField : targetFields) {
                        targetField.setAccessible(true);
                        if (targetField.getName().equals(sourceField.getName()) && targetField.getType().equals(Money.class)) {
                            targetField.set(target, mapBigDecimalToMoney((BigDecimal) value));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }
}
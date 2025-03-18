package fi.pmh.sandbox;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

public class CustomMapper {
    public static <S,T> T map(S source, T target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        Arrays.stream(sourceFields).forEach(field -> field.setAccessible(true));
        Arrays.stream(targetFields).forEach(field -> field.setAccessible(true));

        try {
            Field valueField = Arrays.stream(sourceFields).filter(field -> field.getName().equals("value") && field.getType().equals(BigDecimal.class)).findFirst().orElse(null);
            Field currencyField = Arrays.stream(sourceFields).filter(field -> field.getName().equals("currency") && field.getType().equals(String.class)).findFirst().orElse(null);

            if (valueField != null && currencyField != null)
            {
                BigDecimal value = (BigDecimal) valueField.get(source);
                String currency = (String) currencyField.get(source);

                for (Field targetField : targetFields) {
                    if (targetField.getName().equals("currencyCode") && targetField.getType().equals(String.class)) {
                        targetField.set(target, currency);
                    }
                    else if (targetField.getName().equals("value") && targetField.getType().equals(String.class)) {
                        targetField.set(target, value.toPlainString());
                    }
                    else if (targetField.getName().equals("eurValue") && targetField.getType().equals(String.class)) {
                        targetField.set(target, value.toPlainString());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return target;
    }
}
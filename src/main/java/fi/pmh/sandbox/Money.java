package fi.pmh.sandbox;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
    String currencyCode;
    String value;
    String eurValue;
}

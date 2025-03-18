package fi.pmh.sandbox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money {
    String currencyCode;
    String value;
    String eurValue;
}

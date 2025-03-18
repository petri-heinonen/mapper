package fi.pmh.sandbox;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SourceObject
{
    private String currency;
    private BigDecimal value;
}

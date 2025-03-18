package fi.pmh.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyMapperTest
{
    @Before
    public void init()
    {
        System.out.println("INIT TEST.");
    }

    @Test
    public void testMap()
    {
        // Test cases with different source objects
        SourceObject[] sources = {
            createSourceObject("USD", new BigDecimal("100.00")),
            createSourceObject("EUR", new BigDecimal("200.50")),
            createSourceObject("JPY", new BigDecimal("3000")),
            createSourceObject("GBP", new BigDecimal("50.75")),
            createSourceObject("AUD", new BigDecimal("150.25"))
        };

        for (SourceObject source : sources) {
            // Create target object
            Money target = new Money();

            // Perform mapping
            MyMapper.INSTANCE.map(source, target);

            // Print source and target for debugging
            System.out.println("Source: " + source);
            System.out.println("Target: " + target);

            // Verify the mapping
            assertNotNull("Target value should not be null", target.getValue());
            assertNotNull("Target currencyCode should not be null", target.getCurrencyCode());
            assertEquals("Currency should match", source.getCurrency(), target.getCurrencyCode());
            assertEquals("Value should match", source.getValue(), new BigDecimal(target.getValue()));
        }
    }

    private SourceObject createSourceObject(String currency, BigDecimal value) {
        SourceObject source = new SourceObject();
        source.setCurrency(currency);
        source.setValue(value);
        return source;
    }
}
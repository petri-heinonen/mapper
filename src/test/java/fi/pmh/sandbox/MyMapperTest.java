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
    @Test
    public void testMap()
    {
        SourceObject source = new SourceObject();
        BigDecimal a = new BigDecimal("123.45");
        BigDecimal b = new BigDecimal("678.90");
        source.setAttribute1(a);
        source.setAttribute2(b);

        // Create target object
        TargetObject target = new TargetObject();

        // Perform mapping
        MyMapper.INSTANCE.map(source, target);

        System.out.println(source);
        System.out.println(target);

        // Verify the mapping
        assertNotNull(target.getAttribute1());
        assertEquals(a, new BigDecimal(target.getAttribute1().getEurValue()));

        assertNotNull(target.getAttribute2());
        assertEquals(b, new BigDecimal(target.getAttribute2().getEurValue()));
    }

    @Before
    public void init()
    {
        System.out.println("INIT TEST.");
    }
}
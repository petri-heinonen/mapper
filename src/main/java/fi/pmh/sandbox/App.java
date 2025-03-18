package fi.pmh.sandbox;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // Create source object and set values
        SourceObject source = new SourceObject();
        source.setAttribute1(new BigDecimal("123.45"));
        source.setAttribute2(new BigDecimal("678.90"));
        // Add more attributes as needed

        // Create target object
        TargetObject target = new TargetObject();

        // Perform mapping
        MyMapper.INSTANCE.map(source, target);

        System.out.println(target);
    }
}

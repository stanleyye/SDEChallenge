import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMovingAverageTest {
    @Test
    public void testSimpleMovingAverage() {
        SimpleMovingAverage sma = new SimpleMovingAverage();

        sma.add(-3.0); // test negative
        sma.add(1.0);
        sma.add(2.0);
        sma.add(5.0);

        assertEquals(5.0, sma.getMovingAverage(1), 0.001);
        assertEquals(3.5, sma.getMovingAverage(2), 0.001);
        assertEquals(2.6666666666666665, sma.getMovingAverage(3), 0.001);
        assertEquals(1.25, sma.getMovingAverage(4), 0.001);
    }
}
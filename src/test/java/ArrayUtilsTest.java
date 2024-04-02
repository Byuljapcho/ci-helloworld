import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    @Test
    public void testCountOfArrayDoesNotContainTarget() {
        assertEquals(0, ArrayUtils.countOf(new int[]{5, 7, 8, 10, -3}, -100));
    }

    @Test
    public void testCountOfArrayContainsTarget() {
        assertEquals(2, ArrayUtils.countOf(new int[]{5, 7, 5, 10, -3}, 5));
    }

    @Test
    public void testArrayUtilsInstantiation() {
        ArrayUtils arrayUtils = new ArrayUtils();
        assertNotNull(arrayUtils);
    }

    @Test
    public void testMainInstantiation() {
        Main m = new Main();
        assertNotNull(m);
    }

    @Test
    public void testMainMethodOutput() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        Main.main(new String[]{});

        // Reset System.out
        System.setOut(originalOut);

        // Assert the output
        assertEquals("Main Executed!\n", outputStream.toString());
    }
}
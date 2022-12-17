import org.junit.Test;
import static org.junit.Assert.*;

public class TranscriptUnitTesting {

     Transcript letterGradeToNumber = new Transcript();

    @Test
    public void testAA() {
        assertEquals(4.0, letterGradeToNumber.gradeChangeToDouble("AA"), 0.0);
    }

    @Test
    public void testBA() {
        assertEquals(3.5, letterGradeToNumber.gradeChangeToDouble("BA"), 0.0);
    }

    @Test
    public void testBB() {
        assertEquals(3.0, letterGradeToNumber.gradeChangeToDouble("BB"), 0.0);
    }

    @Test
    public void testCB() {
        assertEquals(2.5, letterGradeToNumber.gradeChangeToDouble("CB"), 0.0);
    }

    @Test
    public void testCC() {
        assertEquals(2.0, letterGradeToNumber.gradeChangeToDouble("CC"), 0.0);
    }

    @Test
    public void testDC() {
        assertEquals(1.5, letterGradeToNumber.gradeChangeToDouble("DC"), 0.0);
    }

    @Test
    public void testDD() {
        assertEquals(1.0, letterGradeToNumber.gradeChangeToDouble("DD"), 0.0);
    }

    @Test
    public void testFD() {
        assertEquals(0.5, letterGradeToNumber.gradeChangeToDouble("FD"), 0.0);
    }

    @Test
    public void testFF() {
        assertEquals(0.0, letterGradeToNumber.gradeChangeToDouble("FF"), 0.0);
    }
}

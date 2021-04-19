package pachet2;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import pachet1.*;

import static org.junit.Assert.assertEquals;

public class MyClassTest {

    MyClass tester = new MyClass();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "4", "5", "12"});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void equivalencePartitioning1() {
        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"25", null, null, null, null});
        tester.main(new String[]{"4", "0", null, null, null, null});
        tester.main(new String[]{"4", "5", null, null, null, null});
        tester.main(new String[]{"4", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"4", "1", "1", "20", null, null, null});
        tester.main(new String[]{"4", "1", "1", "10", "0", null, null});
        tester.main(new String[]{"4", "1", "1", "10", "5", null, null});
        tester.main(new String[]{"4", "1", "1", "10", "1", "-1", "4"});
        tester.main(new String[]{"4", "1", "1", "10", "1", "2", "20"});
    }

    @Test
    public void equivalencePartitioning2() {
        tester.main(new String[]{"4", "1", "1", "10", "1", "2", "4"});
        tester.main(new String[]{"4", "1", "1", "10", "1", "5", "10"});

        assertEquals("Nu exista solutie\nInterval: 5 9\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void boundaryValueAnalysis1() {
        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"20", null, null, null, null});

        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "5", null, null, null, null});

        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "5", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});

        tester.main(new String[]{"1", "4", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "4", "1", "20", null, null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "0", null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "5", null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "1", "4"});

        tester.main(new String[]{"19", "0", null, null, null, null});
        tester.main(new String[]{"19", "5", null, null, null, null});
        //consider ca am atins un numar semnificativ de teste de frontiera, iar continuarea lor ar fi pe langa scopul proiectului
    }

    @Test
    public void boundaryValueAnalysis2() {
        tester.main(new String[]{"1", "1", "0", "19", "1", "1", "4"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "1", "4"});

        assertEquals("Interval: 1 2\nInterval: 2 3\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void categoryPartitioning1() {
        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"20", null, null, null, null});

        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "5", null, null, null, null});

        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "5", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "1", "4"});

        tester.main(new String[]{"1", "2", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "2", "1", "20", null, null, null});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "0", null, null});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "5", null, null});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "1", "1", "4"});

        tester.main(new String[]{"1", "4", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "4", "1", "20", null, null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "0", null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "5", null, null});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "1", "4"});

        tester.main(new String[]{"8", "0", null, null, null, null});
        tester.main(new String[]{"8", "5", null, null, null, null});
        tester.main(new String[]{"15", "0", null, null, null, null});
        tester.main(new String[]{"15", "5", null, null, null, null});
        tester.main(new String[]{"19", "0", null, null, null, null});
        tester.main(new String[]{"19", "5", null, null, null, null});
        //consider ca am atins un numar semnificativ de categorii, iar continuarea lor ar fi pe langa scopul proiectului
    }

    @Test
    public void categoryPartitioning2() {
        tester.main(new String[]{"1", "1", "0", "19", "1", "1", "4"});
        tester.main(new String[]{"1", "2", "0", "8", "10", "19", "1", "1", "4"});
        tester.main(new String[]{"1", "4", "0", "1", "2", "5", "5", "8", "8", "19", "1", "1", "4"});

        assertEquals("Interval: 1 2\nInterval: 1 2\nInterval: 2 3\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void statementCoverage(){
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "4", "5", "12"});
        tester.main(new String[]{"4", "2", "2", "4", "5", "12", "2", "1", "10", "11", "13"});
        tester.main(new String[]{"4", "2", "1", "4", "11", "13", "2", "2", "4", "5", "12"});

        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "6", "4", null, null, null});

        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "5", "3"});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void branchCoverage() {
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "4", "5", "12"});
        tester.main(new String[]{"4", "2", "2", "4", "5", "12", "2", "1", "10", "11", "13"});
        tester.main(new String[]{"4", "2", "1", "4", "11", "13", "2", "2", "4", "5", "12"});

        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "6", "4", null, null, null});

        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "5", "3"});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void conditionCoverage() {
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "4", "5", "12"});
        tester.main(new String[]{"4", "2", "2", "4", "5", "12", "2", "1", "10", "11", "13"});
        tester.main(new String[]{"4", "2", "1", "4", "11", "13", "2", "2", "4", "5", "12"});

        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"20", null, null, null, null});

        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "5", null, null, null, null});

        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "20", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "-1", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "5", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "20", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "5", "3"});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void circuitsCoverage() {
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "4", "5", "12"});
        tester.main(new String[]{"4", "2", "2", "4", "5", "12", "2", "1", "10", "11", "13"});
        tester.main(new String[]{"4", "2", "1", "4", "11", "13", "2", "2", "4", "5", "12"});

        tester.main(new String[]{"0", null, null, null, null});
        tester.main(new String[]{"1", "0", null, null, null, null});
        tester.main(new String[]{"1", "1", "-1", "10", null, null, null});
        tester.main(new String[]{"1", "1", "1", "20", null, null, null});
        tester.main(new String[]{"1", "1", "6", "4", null, null, null});

        tester.main(new String[]{"1", "1", "0", "19", "0", null, null});
        tester.main(new String[]{"1", "1", "0", "19", "1", "-1", "4"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "2", "20"});
        tester.main(new String[]{"1", "1", "0", "19", "1", "5", "3"});
    }

    @Test
    public void killSort() {
        tester.main(new String[]{"4", "2", "11", "15", "1", "10", "2", "5", "15", "2", "4"}); //PIT returneaza % fara si % cu acest test
    }

    @Test
    public void killMin() {
        tester.main(new String[]{"4", "2", "11", "15", "1", "10", "2", "5", "15", "2", "10"}); //PIT returneaza % fara si % cu acest test
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void kill3() {
        tester.main(new String[]{"4", "2", "11", "15", "1", "10", "2", "5", "15", "10", "2"}); //PIT returneaza % fara si % cu acest test
    }

    @Test
    public void kill4() {
        tester.main(new String[]{"4", "2", "1", "10", "11", "13", "2", "2", "5", "5", "12"}); //PIT returneaza % fara si % cu acest test
    }

    @Test
    public void kill5() {
        tester.main(new String[]{"4", "1", "1", "10", "4", "1", "3", "5", "6", "8", "9", "10", "11"}); //PIT returneaza 71% fara si 74% cu acest test
    }
}


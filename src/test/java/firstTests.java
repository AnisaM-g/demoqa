import org.junit.jupiter.api.*;

public class firstTests {
    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        result = getResult();
        System.out.println("### beforeEach()  ");
    }

    @AfterEach
    void afterEach() {
        result = 0;
        System.out.println("### afterEach()\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterAll()\n");
    }
    @Test
    void firstTest() {
        System.out.println("###   firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###   secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###   thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult(){
        return 3;
    }
}

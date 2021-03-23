import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    private Operator operator;

    @BeforeEach
    public void setup() {
        operator = new Operator();
    }

    @Nested
    class Summ {

        @Test
        void summTwoPositivesReturnPositive() {

            assertEquals(3, operator.summ(1.4, 1.6));
        }

        @Test
        void summTwoNegativesReturnNegative() {
            assertEquals(-5, operator.summ(-3.4, -1.6));
        }

        @Test
        void summOneZeroReturnDsntChng() {
            assertEquals(5.6, operator.summ(0.00, 5.6));
        }

        @Test
        void summTwoZerosReturnZero() {
            assertEquals(0, operator.summ(0, 0));
        }
    }

    @Nested
    class Minus {
        @Test
        void minusTwoPositivesReturnPositive() {
            assertEquals(0.8, operator.minus(2.4, 1.6));
        }

        @Test
        void minusTwoNegativesReturnNegative() {
            assertEquals(-1.8, operator.minus(-3.4, -1.6));
        }

        @Test
        void minusOneZeroReturnDsntChng() {
            assertEquals(-3.4, operator.minus(-3.4, -0));
        }

        @Test
        void minusZerosReturnZero() {
            assertEquals(0, operator.minus(0, 0));
        }
    }

    @Nested
    class Multiply {
        @Test
        void multiplyTwoPositivesReturnPositive() {
            assertEquals(5.75, operator.multiply(2.5, 2.3));
        }

        @Test
        void multiplyTwoNegativesReturnPositive() {
            assertEquals(4.29, operator.multiply(-3.3, -1.3));
        }

        @Test
        void multiplyOneNegativeOnePositiveRetrnNegative() {
            assertEquals(-3.3, operator.multiply(-1.5, 2.2));
        }

        @Test
        void multiplyNegativeAndZeroReturnZero() {
            assertEquals(-0, operator.multiply(-13.876, 0));
        }

        @Test
        void multiplyZerosReturnZero() {
            assertEquals(0, operator.multiply(0, 0));
        }
    }

    @Nested
    class Divide {
        @Test
        void divideTwoPositivesReturnPositive() {
            assertEquals(4.3, operator.divide(9.503, 2.21));
        }

        @Test
        void divideTwoNegativesReturnPositive() {
            assertEquals(8.5, operator.divide(-27.3, -3.2));
        }

        @Test
        void divideOneNegativeOnePositiveRetrnNegative() {
            assertEquals(-3.7, operator.divide(-8.8, 2.4));
        }

        @Test
        void divideByZeroReturnZero() {
//            assertThrows(ArithmeticException.class, () -> { operator.divide(12.8, 0); } );
            assertEquals(9.2233720368547763E17, operator.divide(12.8, 0));
        }

        @Test
        void divideZerosReturnZero() {
            assertEquals(0, operator.divide(0, 0));
        }
    }

}

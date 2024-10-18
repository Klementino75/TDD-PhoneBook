import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Тесты работы PhoneBook: ")
public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @BeforeEach
    void beforeEach() {
        System.out.println("Начало теста.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершён.\n");
    }

    @DisplayName("Тест метода add()")
    @ParameterizedTest
    @MethodSource
    void addTest(String name, String numberPhone, int expected) {
        int countNumber = phoneBook.add(name, numberPhone);

        Assertions.assertEquals(expected, countNumber);
        System.out.println(expected + " = " + countNumber + " - Ok!");
    }

    public static Stream<Arguments> addTest() {
        return Stream.of(Arguments.of("Name1", "+7 (900) 111-1111", 0));
    }
}

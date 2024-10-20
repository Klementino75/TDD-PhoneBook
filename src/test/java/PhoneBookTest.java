import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@DisplayName("Тесты работы PhoneBook: ")
public class PhoneBookTest {
    private static PhoneBook phoneBook = new PhoneBook();

    @BeforeAll
    static void beforeAll() {
        phoneBook = PhoneBook.getINSTANCE();
    }

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
        phoneBook.add("Name1", "+7 (900) 100-1111");
        int countNumber = phoneBook.add(name, numberPhone);

        Assertions.assertEquals(expected, countNumber);
        System.out.println(expected + " = " + countNumber + " - Ok!");
    }

    public static Stream<Arguments> addTest() {
        return Stream.of(Arguments.of("Name1", "+7 (900) 100-1111", 1),
                Arguments.of("Name2", "+7 (900) 100-2222", 2),
                Arguments.of("Name3", "+7 (900) 100-3333", 3),
                Arguments.of("Name1", "+7 (900) 100-1111", 3),
                Arguments.of("Name4", "+7 (900) 100-4444", 4));
    }

}

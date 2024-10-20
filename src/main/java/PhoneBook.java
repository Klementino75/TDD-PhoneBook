import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private static PhoneBook INSTANCE = null;
    private final TreeMap<String, String> phoneBook = new TreeMap<>();

    PhoneBook() {
    }

    public static PhoneBook getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (PhoneBook.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PhoneBook();
                }
            }
        }
        return INSTANCE;
    }
//    Или так...
//    private static final class InstanceHolder {
//        private static final PhoneBook INSTANCE = new PhoneBook();
//    }
//
//    public static PhoneBook getINSTANCE() {
//        return InstanceHolder.INSTANCE;
//    }

    public int add(String name, String numberPhone) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Имя НЕ может быть пустым!");
        }
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, numberPhone);
        }
        return phoneBook.size();
    }

    public String findByNumber(String numberPhone) {
        return phoneBook.entrySet().stream()
                .filter(b -> b.getValue().equals(numberPhone))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public List<String> printAll() {
        return new ArrayList<>(phoneBook.keySet());
    }
}

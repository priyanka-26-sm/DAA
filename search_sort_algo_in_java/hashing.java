import java.util.LinkedList;

class HashTable {
    private static final int SIZE = 10;
    private LinkedList<Entry>[] table;

    // Entry class for key-value pairs
    static class Entry {
        String key;
        int value;
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            table[i] = new LinkedList<>();
    }

    // Hash function
    private int getHash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert key-value pair
    public void put(String key, int value) {
        int index = getHash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    // Get value by key
    public Integer get(String key) {
        int index = getHash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    // Remove key-value pair
    public void remove(String key) {
        int index = getHash(key);
        table[index].removeIf(entry -> entry.key.equals(key));
    }

    // Display hash table
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put("Alice", 25);
        ht.put("Bob", 30);
        ht.put("Charlie", 35);

        System.out.println("Alice's Age: " + ht.get("Alice"));

        ht.remove("Charlie");
        ht.display();
    }
}

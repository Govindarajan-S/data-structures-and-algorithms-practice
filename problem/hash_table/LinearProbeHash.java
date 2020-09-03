package problem.hash_table;

public class LinearProbeHash {

    private class HashTable {
        private String key;
        private String value;

        public HashTable(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
    private int capacity = 20;

    private HashTable[] table;

    public LinearProbeHash() {
        table = new HashTable[capacity];
    }

    private HashTable defunct = new HashTable(null, null);

    public int hash(String key, int capacity) {
        int hash = 0;
        for (int i = 1; i < key.length(); i++) {
            hash = hash * 13 + i;
        }
        return hash % capacity;
    }

    public String add(String key, String value) {
        int addIndex = findSlot(hash(key, this.capacity), key);
        if (addIndex >= 0) {
            return table[addIndex].getValue();
        }
        table[-(addIndex + 1)] = new HashTable(key, value);
        return null;
    }

    public boolean exists(String key) {
        int searchIndex = findSlot(hash(key, this.capacity), key);
        if (searchIndex < 0) {
            return false;
        } else {
            return true;
        }
    }

    public String get(String key) {
        int getIndex = findSlot(hash(key, this.capacity), key);
        if (getIndex < 0) {
            return null;
        }
        return table[getIndex].getValue();
    }

    public String remove(String key) {
        int removeIndex = findSlot(hash(key, this.capacity), key);
        if (removeIndex < 0) {
            return null;
        }
        String value = table[removeIndex].getValue();
        table[removeIndex] = defunct;
        return value;
    }

    private boolean isAvailable(int index) {
        return table[index] == null || table[index] == defunct;
    }

    private int findSlot(int hash, String key) {
        int avail = -1;
        int index = hash;
        do {
            if (isAvailable(index)) {
                if (avail == -1) {
                    avail = index;
                }
                if (table[index] == null) {
                    break;
                }
            } else if (table[index].getKey().equals(key)) {
                return index;
            }
            index = (index + 1) % capacity;
        } while (index != hash);
        return -(avail + 1);
    }

    public static void main(String[] args) {
        LinearProbeHash probeHash = new LinearProbeHash();
        probeHash.add("name", "Naruto");
        probeHash.add("age", "16");
        probeHash.add("enemy", "Madara");
        probeHash.add("bestfriend", "Sasuke");
        System.out.println("Is Naruto is having best friend? " + probeHash.exists("bestfriend"));
        System.out.println("His Name is " + probeHash.get("bestfriend"));
        System.out.println("His enemy is known as " + probeHash.get("enemy"));
        probeHash.remove("enemy");
    }
}
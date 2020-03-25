import java.util.*;

public class SortMountains {
    LinkedList<Mountain> mnt = new LinkedList<>();
    HashSet<Mountain> hmnt = new HashSet<>();
    HashMap<String, Integer> mmap = new HashMap<>();

    static class NameCompare implements Comparator<Mountain> {

        @Override
        public int compare(Mountain mountain, Mountain t1) {
            return mountain.getName().compareTo(t1.getName());
        }
    }

    static class HeightCompare implements Comparator<Mountain> {

        @Override
        public int compare(Mountain mountain, Mountain t1) {
            return mountain.getHeight() - t1.getHeight();
        }
    }

    void go() {
        ArrayList<Object> objects = new ArrayList<Object>();
        generateMountains();
        mnt.sort(new NameCompare());
        System.out.println(mnt);
        mnt.sort(new HeightCompare());
        System.out.println(mnt);
        hmnt.addAll(mnt);
        System.out.println("new ");
        System.out.println(hmnt);
        TreeSet<Mountain> tmnt = new TreeSet<>(mnt);
        System.out.println(tmnt);

        generateMap();
        System.out.println(mmap);
        System.out.println(mmap.get("D"));
    }

    private void generateMountains() {
        mnt.add(new Mountain("Everest", 8484));
        mnt.add(new Mountain("K2", 898));
        mnt.add(new Mountain("Koila", 787));
        mnt.add(new Mountain("RiverDale", 90));
        mnt.add(new Mountain("Everest", 8484));
    }

    private void generateMap() {
        mmap.put("Rash", 21);
        mmap.put("Madhu", 20);
        mmap.put("Utpak", 24);
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }
}

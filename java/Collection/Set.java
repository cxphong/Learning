1. Khi nào dùng Set?
2. Các interface của Set? 

1. Dùng Set khi muốn lưu data không bị trùng lặp.
2. 
	- HashSet: Cơ bản của Set
	- TreeSet: Đảm bảo sorted theo ascending
	- ConcurrentSkipListSet: Đảm bảo thread safe
	- LinkedHashSet: Đảm bảo giữ nguyên order của input

String[] sA = {"Hi", "By", "Some", "Where", "Some", "By"};
HashSet<String> s = new HashSet<>(Arrays.asList(sA));

// Print
printSet(s);

// Remove
s.remove("Some");
printSet(s);

// Contain
System.out.println(s.contains("Hi") + ", " + s.contains("Some"));

// Size
System.out.println(s.size());

// isEmpty
System.out.println(s.isEmpty());

// Clear
s.clear();
System.out.println(s.isEmpty());

// Add
s.add("Kong");
printSet(s);

private static void printSet(HashSet<String> s) {
    for (Iterator<String> iterator = s.iterator(); iterator.hasNext();) {
        System.out.println(iterator.next());
    }
}
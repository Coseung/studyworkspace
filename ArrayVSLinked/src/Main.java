public class Main {
    public static void main(String[] args) {

        // ===== ArrayList 와 LinkedList 성능 비교 테스트 =====

        int TEST_SIZE = 200000; // 테스트 데이터 개수 (20만)
        int MID_INDEX = TEST_SIZE / 2;

        java.util.List<Integer> arrayList = new java.util.ArrayList<>();
        java.util.List<Integer> linkedList = new java.util.LinkedList<>();

        System.out.println("==== ArrayList vs LinkedList 성능 테스트 시작 ====");

        // ----------------------------------------------------
        // 1. 리스트 끝에 요소 추가 (add)
        // ----------------------------------------------------
        long start = System.currentTimeMillis();
        for (int i = 0; i < TEST_SIZE; i++) arrayList.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 끝에 추가(add): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_SIZE; i++) linkedList.add(i);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 끝에 추가(add): " + (end - start) + " ms");

        // ----------------------------------------------------
        // 2. 리스트 중간에 요소 삽입
        // ----------------------------------------------------
        start = System.currentTimeMillis();
        arrayList.add(MID_INDEX, -1);
        end = System.currentTimeMillis();
        System.out.println("ArrayList 중간 삽입(add): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        linkedList.add(MID_INDEX, -1);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 중간 삽입(add): " + (end - start) + " ms");

        // ----------------------------------------------------
        // 3. 임의 접근(get)
        // ----------------------------------------------------
        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_SIZE; i++) arrayList.get(i);
        end = System.currentTimeMillis();
        System.out.println("ArrayList 임의 접근(get): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_SIZE; i++) linkedList.get(i);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 임의 접근(get): " + (end - start) + " ms");

        // ----------------------------------------------------
        // 4. 중간 요소 삭제(remove)
        // ----------------------------------------------------
        start = System.currentTimeMillis();
        arrayList.remove(MID_INDEX);
        end = System.currentTimeMillis();
        System.out.println("ArrayList 중간 삭제(remove): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        linkedList.remove(MID_INDEX);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 중간 삭제(remove): " + (end - start) + " ms");

        System.out.println("==== 테스트 종료 ====");
    }
}

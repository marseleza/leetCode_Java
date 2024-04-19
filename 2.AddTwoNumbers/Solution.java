class Solution {
    static ListNode makeList(int num) {
        if(num <= 0)
            return new ListNode();
        return new ListNode(num % 10, makeList(num / 10));
    }
    static int pow(int n1, int n2) {
        if(n2 - 1 < 0)
            return 1;
        return n1 * pow(n1, n2 - 1);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Save = l1;
        ListNode l2Save = l2;

        int l1Length = 0, l2Length = 0, l1Num = 0, l2Num = 0;
        while(l1.next != null) {
            l1Length++;
            l1 = l1.next;
        }

        while(l2.next != null) {
            l2Length++;
            l2 = l2.next;
        }

        l1 = l1Save;
        l2 = l2Save;

        int[] mas1 = new int[l1Length];
        int[] mas2 = new int[l2Length];

        for (int i = 0; i < l1Length; i++) {
            mas1[i] = l1.val;
            l1 = l1.next;
        }

        for (int i = 0; i < l2Length; i++) {
            mas2[i] = l2.val;
            l2 = l2.next;
        }

        for (int i = l1Length, k = 0; k < l1Length; i--, k++) {
            l1Num = l1Num + pow(10, i - 1) * mas1[i - 1];
         }

        for (int i = l2Length, k = 0; k < l2Length; i--, k++) {
            l2Num = l2Num + pow(10, i - 1) * mas2[i - 1];
        }
        int lSum = l1Num + l2Num;
        return makeList(lSum);
    }

    public static void main(String[] args) {
        ListNode num1 = makeList(243);
        ListNode num2 = makeList(564);

        Solution test = new Solution();

        ListNode testMakeList;
        testMakeList = test.addTwoNumbers(num1, num2);

        while (testMakeList.next != null) {
            System.out.print(testMakeList.val);
            testMakeList = testMakeList.next;
        }
    }
}
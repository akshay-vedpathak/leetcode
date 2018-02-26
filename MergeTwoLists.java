class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){this.val = val;}
}
public class MergeTwoLists {

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode merge = null;
        if(l1==null && l2==null){
            return null;
        }else if(l1!=null && l2==null){
            return l1;
        }else if(l1==null && l2!=null){
            return l2;
        }else{
            ListNode lptr1 = l1;
            ListNode lptr2 = l2;
            ListNode mptr = null;
            if(lptr1.val <= lptr2.val){
                merge = new ListNode(lptr1.val);
                lptr1 = lptr1.next;
            }else {
                merge = new ListNode(lptr2.val);
                lptr2 = lptr2.next;
            }
            mptr = merge;
            while(lptr1!=null && lptr2!=null){
                if(lptr1.val<=lptr2.val){
                    merge.next = new ListNode(lptr1.val);
                    merge = merge.next;
                    merge.next = new ListNode(lptr2.val);
                    lptr1 = lptr1.next;
                }else{
                    merge.next = new ListNode(lptr2.val);
                    merge = merge.next;
                    merge.next = new ListNode(lptr1.val);
                    lptr2 = lptr2.next;
                }
            }
            if(lptr1!=null){
                merge.next = lptr1;
            }
            if(lptr2!=null){
                merge.next = lptr2;
            }

            return mptr;
        }

    }

    public static void print(ListNode l1){
        while(l1!=null){
            System.out.print(l1.val+" ");
            l1 = l1.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        l2.next = l3;
        l1.next = l2;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l5.next = l6;
        l4.next = l5;

        ListNode merge = merge(l1, l4);

        System.out.println("inputs:");
        print(l1);
        print(l4);
        System.out.println("output:");
        print(merge);

    }

    /**
     * Expected output:
     * inputs:
     * 1 2 4
     * 1 3 4
     * output:
     * 1 1 2 3 4 4
     *
     */
}

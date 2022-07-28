public class Main {
    public static void main(String[] args) {

        int[] list = null;

        list = addElement(list, 5);
        list = addElement(list, 10);
        list = addElement(list, 4);
        list = addElement(list, 6);
        list = addElement(list, 7);
        printList(list);

        int[] popList = null;

        popList = addElement(popList, 6);
        popList = addElement(popList, 9);
        popList = addElement(popList, 3);
        popList = addElement(popList, 32);
        popList = addElement(popList, 27);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);
        popList = deleteElement(popList);
        printList(popList);

        int[] insertList = null;

        insertList = insertElement(insertList, 3, 0);
        printList(insertList);
        insertList = insertElement(insertList, 5, 0);
        printList(insertList);
        insertList = insertElement(insertList, 9, 1);
        printList(insertList);
        insertList = insertElement(insertList, 34, 3);
        printList(insertList);
        insertList = insertElement(insertList, 456, -1);
        printList(insertList);
        insertList = insertElement(insertList, 49, 325);
        printList(insertList);
        insertList = insertElement(insertList, 6, 2);
        printList(insertList);

    }
    public static void printList( int [] list ){
        System.out.println("---------------------------");
        if (list ==null){
            return;
        }
        for(int i =0; i< list.length; i++){
            System.out.println(list[i]);
        }
    }
    public static int[] addElement(int[] list, int value) {
    if (list == null) {
        list = new int [1];
        list[0] = value;
        return list;

    }
    else {
        int [] list2 = new int[(list.length) + 1];

        for(int i = 0; i < list.length; i ++) {
            list2[i] = list[i];
        }
        list2[list2.length -1] = value;
        return list2;
    }


    }
    public static int[] deleteElement(int[] popList) {

        if (popList == null || popList.length == 1) {
            return null;
        }
        else {
            int [] popList2 = new int [(popList.length) -1];

            for(int i = 0; i < popList.length -1; i ++) {
                popList2[i] = popList[i];
            }
            return popList2;
        }

    }

    public static int[] insertElement (int[] list, int value, int index){
        if (list == null) {
            int [] list2 = new int [1];
            list2[0] = value;
            return list2;
        }
        else if ( index < 0 || index > list.length ) {
            return list;
        }

        else {
            int [] list2 = new int[list.length +1];

            for(int i = 0; i < index; i ++){
                list2[i] = list[i];
            }
            list2[index] = value;
            for(int i = index; i < list.length; i ++) {
                list2[i + 1] = list[i];
            }
            return list2;


        }

    }


}
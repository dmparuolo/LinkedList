/*  Student information for assignment:
 *
 *  On my honor, Dominic Paruolo, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Dominic Paruolo
 *  email address: dominicparuolo78@gmail.com
 *  UTEID:dmp3588
 *  Section 5 digit ID: 52615
 *  Grader name: Nidhi
 *  Number of slip days used on this assignment: 0
 */

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *  
 *  For adding at the end, LinkedLists are faster. 
 *  ArrayList O(1) LinkedList O(1) - Both times were about 2 times slower each time N doubled,
 *  which makes sense as both only call a set number of lines of code each time.
 *  
 *  For adding at the front, LinkedLists are faster. 
 *  ArrayList O(N) - Time was about 4 times slower each time N doubled, which makes sense
 *  as an ArrayList has to shift every other value down to add at front.
 *  LinkedList O(1) - Time was about 2 times slower each time N doubled, which makes sense
 *  as a LinkedList only calls a set few lines of code to add at front.
 *  
 *  For removing from the front, LinkedLists are faster.
 *  ArrayList O(N) - Time was about 4 times slower each time N doubled, which makes sense
 *  as an ArrayList has to shift all other values down.
 *  LinkedList O(1) - Time was about 2 times slower each time N doubled, which makes sense
 *  as a LinkedList only has to call a set number of lines of code.
 *  
 *  For getting random values, ArrayLists are much faster.
 *  ArrayList O(1) - Time was about 2 times slower each time N doubled, which makes sense
 *  as ArrayLists get values through their hash codes and not traversing entire lists.
 *  LinkedList O(N) - Time was about 4 times slower each time N doubled, which makes sense
 *  as LinkedLists have to traverse entire list to find values.
 *  
 *  For getting all using iterator, ArrayLists are faster.
 *  ArrayList O(N) LinkedList O(N) - To get one value it would be O(1). However to get every
 *  value from a list of N elements, it would be order N.
 *  
 *  For getting all using get method, ArrayLists are faster.
 *  ArrayList O(N) - To get one value it would be about O(1). However to get every value 
 *  it would be about O(N) as there are N elements in the list.
 *  LinkedList O(N^2) - To get One value it would be about O(N). However to get every
 *  value it would be about O(N^2) if there are N elements in the list.
 */


import java.util.Iterator;

public class LinkedListTester {

    public static void main(String[] args) {

        //CS314 students. Add your tests here:
        
        LinkedList<Integer> list = new LinkedList<>();
        //constructor is tested implicitly with every test
        // add tests
        // test 1
        System.out.println("\nTest 1: add to end");
        list.add(9);
        if (list.get(0).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 2
        System.out.println("\nTest 2: add to end");
        list.add(10);
        if (list.get(1).equals(10)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 3
        System.out.println("\nTest 3: add to end");
        list.add(11);
        if (list.get(2).equals(11)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // insert tests
        // test 4
        System.out.println("\nTest 4: insert");
        list.insert(0, 2);
        if (list.get(0).equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 5
        System.out.println("\nTest 5: insert");
        if (list.get(1).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 6
        System.out.println("\nTest 6: insert");
        list.insert(4, 3);
        if (list.get(4).equals(3)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // set tests
        // test 7
        System.out.println("\nTest 7: set");
        list.set(2, 2);
        if (list.get(2).equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 8
        System.out.println("\nTest 8: set");
        list.set(1, 1);
        if (list.get(1).equals(1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 9
        System.out.println("\nTest 9: set");
        list.set(0, 0);
        if (list.get(0).equals(0)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // get tests
        // test 10
        System.out.println("\nTest 10: get");
        if (list.get(3).equals(11)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 11
        System.out.println("\nTest 11: get");
        if (list.get(4).equals(3)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 12
        System.out.println("\nTest 12: get");
        if (list.get(0).equals(0)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // remove position tests
        // test 13
        System.out.println("\nTest 13: remove position");
        if (list.remove(3).equals(11)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 14
        System.out.println("\nTest 14: remove position");
        if (list.get(3).equals(3)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 15
        System.out.println("\nTest 15: remove position");
        list.remove(0);
        if (list.get(0).equals(1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        //remove object tests
        // test 16
        System.out.println("\nTest 16: remove object");
        if (!list.remove((Integer) 4)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 17
        System.out.println("\nTest 17: remove object");
        if (list.remove((Integer) 1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 18
        System.out.println("\nTest 18: remove object");
        if (list.get(0).equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        // getSubList tests
        // test 19
        System.out.println("\nTest 19: sublist");
        IList<Integer> subList = list.getSubList(1, 4);
        if (subList.get(0).equals(1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 20
        System.out.println("\nTest 20: sublist");
        if (subList.get(2).equals(3)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 21
        System.out.println("\nTest 21: sublist");
        subList = list.getSubList(0, 0);
        if (subList.size() == 0) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // size tests
        // test 22
        System.out.println("\nTest 22: size");
        if (list.size() == 6) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 23
        System.out.println("\nTest 23: size");
        list.remove(5);
        if (list.size() == 5) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 24
        System.out.println("\nTest 24: size");
        list.add(5);
        if (list.size() == 6) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // indexOf item tests
        // test 25
        System.out.println("\nTest 25: indexOf item");
        if (list.indexOf(2) == 2) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 26
        System.out.println("\nTest 26: indexOf item");
        if (list.indexOf(6) == -1) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 27
        System.out.println("\nTest 27: indexOf item");
        if (list.indexOf(0) == 0) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // indexOf item from position
        // test 28
        System.out.println("\nTest 28: indexOf item from position");
        if (list.indexOf(0, 1) == -1) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 29
        System.out.println("\nTest 29: indexOf item from position");
        if (list.indexOf(2, 2) == 2) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 30
        System.out.println("\nTest 30: indexOf item from position");
        if (list.indexOf(5, 5) == 5) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // makeEmpty tests
        // test 31
        System.out.println("\nTest 31: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 32
        System.out.println("\nTest 32: makeEmpty");
        list.add(555);
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 33
        System.out.println("\nTest 33: makeEmpty");
        list.add(777);
        list.add(234);
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // iterator tests
        list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        Iterator<Integer> listIterator = list.iterator();
        
        // test 34 hasNext
        System.out.println("\nTest 34: hasNext");
        if (listIterator.hasNext()) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 35 next
        System.out.println("\nTest 35: next");
        if (listIterator.next().equals(0)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 36 remove
        System.out.println("\nTest 36: remove");
        listIterator.remove();
        if (list.get(0).equals(1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 37
        System.out.println("\nTest 37: hasNext");
        if (listIterator.hasNext()) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 38
        System.out.println("\nTest 38: next");
        if (listIterator.next().equals(1)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 39
        System.out.println("\nTest 39: remove");
        listIterator.remove();
        if (list.get(0).equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 40
        System.out.println("\nTest 40: hasNext");
        if (listIterator.hasNext()) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 41
        System.out.println("\nTest 41: next");
        if (listIterator.next().equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 42
        System.out.println("\nTest 42: remove");
        listIterator.remove();
        if (list.get(0).equals(3)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        list.insert(0, 2);
        list.insert(0, 1);
        list.insert(0, 0);
        
        // removeRange
        // test 43
        System.out.println("\nTest 43: removeRange");
        list.removeRange(5, 5);
        if (list.get(5).equals(5)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 44
        System.out.println("\nTest 44: removeRange");
        list.removeRange(0, 2);
        if (list.get(0).equals(2)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 45
        System.out.println("\nTest 45: removeRange");
        list.removeRange(1, 3);
        if (list.get(1).equals(5)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // toString tests
        // test 46
        System.out.println("\nTest 46: toString");
        if (list.toString().equals("[2, 5]")) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        list.insert(0, 1);
        list.insert(0, 0);
        // test 47
        System.out.println("\nTest 47: toString");
        if (list.toString().equals("[0, 1, 2, 5]")) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        list.insert(3, 3);
        list.insert(4, 4);
        // test 48
        System.out.println("\nTest 48: toString");
        if (list.toString().equals("[0, 1, 2, 3, 4, 5]")) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // equals tests
        LinkedList<Object> testList = new LinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        // test 49
        System.out.println("\nTest 49: equals");
        if (list.equals(testList)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 50
        System.out.println("\nTest 50: equals");
        testList.add(6);
        if (!list.equals(testList)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 51
        System.out.println("\nTest 51: equals");
        list.add(6);
        if (list.equals(testList)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // addFirst tests
        // test 52
        System.out.println("\nTest 52: addFirst");
        list.addFirst(9);
        if (list.get(0).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 53
        System.out.println("\nTest 53: addFirst");
        list.addFirst(8);
        if (list.get(0).equals(8)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 54
        System.out.println("\nTest 54: addFirst");
        list.addFirst(7);
        if (list.get(0).equals(7)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // addLast tests
        // test 55
        System.out.println("\nTest 55: addLast");
        list.addLast(9);
        if (list.get(10).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 56
        System.out.println("\nTest 56: addLast");
        list.addLast(8);
        if (list.get(11).equals(8)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 57
        System.out.println("\nTest 57: addLast");
        list.addLast(7);
        if (list.get(12).equals(7)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // removeFirst tests
        // test 58
        System.out.println("\nTest 58: removeFirst");
        list.removeFirst();
        if (list.get(0).equals(8)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 59
        System.out.println("\nTest 59: removeFirst");
        list.removeFirst();
        if (list.get(0).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 60
        System.out.println("\nTest 60: removeFirst");
        list.removeFirst();
        if (list.get(0).equals(0)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        
        // removeLast tests
        // test 61
        System.out.println("\nTest 61: removeLast");
        list.removeLast();
        if (list.get(8).equals(8)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 62
        System.out.println("\nTest 62: removeLast");
        list.removeLast();
        if (list.get(7).equals(9)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
        // test 63
        System.out.println("\nTest 63: removeLast");
        list.removeLast();
        if (list.get(6).equals(6)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test"); 
        }
    }
}
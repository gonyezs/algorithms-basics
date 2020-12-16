package oopdesign;

import java.util.Map;
import java.util.HashMap;

class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        updateList(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);

        if (node == null) {
            newNode(key, value);
        } else {
            node.value = value;
            updateList(node);
        }
        
        if (map.keySet().size() == 1) {
            tail = head;
        }

        if (map.keySet().size() > capacity) {
            removeLast();
        }
    }

    void newNode(int key, int value) {
        ListNode node = new ListNode();
        node.key = key;
        node.value = value;
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        map.put(key, node);
    }

    void removeLast() {
        if(tail != null) {
            map.remove(tail.key);
            if(tail.prev != null) tail.prev.next = null;
            tail = tail.prev;
        }
    }

    void updateList(ListNode node) {
        if(head.key == node.key) return;
        
        if (tail != null && tail.key == node.key ) {
            if (tail.prev != null) tail.prev.next = null;
            tail = tail.prev;
        }
        
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;
}
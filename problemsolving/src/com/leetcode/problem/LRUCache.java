package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
	

    Map<Integer,Node> map;
	int capacity;
	Node head = null;
	Node tail = null;
	
	public class Node {
		Node next;
		Node prev;
		int key;
		int value;
		
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public void removeNode(Node node) {
		Node nextNode = node.next;
		Node prevNode = node.prev;
		
		if (prevNode!=null) {
			prevNode.next = node.next;
		} else {
			head = nextNode;
		}
		
		if (nextNode!=null) {
			nextNode.prev = prevNode;
		} else {
			tail = prevNode;
		}
		
	}
	
	public void putOnTop(Node node) {
        node.next = head;
        node.prev = null;
        
		if (head!=null) {
            head.prev = node;
		}
		    head = node;
    
        
		if (tail==null) {
            tail = node;
        }
	}
	
   public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			removeNode(node);
			putOnTop(node);
			return node.value;
		} 
			return -1;
		
	}
    
    public void put(int key, int value) {
    if (map.containsKey(key)) {
    		Node t = map.get(key);
    		t.value = value;
    		
    		removeNode(t);
    		putOnTop(t);
	} else {
		
		if (map.size()>=capacity) {
			map.remove(tail.key);
			removeNode(tail);
		}
		
		Node node = new Node(key, value);
        map.put(key, node);
        putOnTop(node);
    		}
    }
    
    public static void main(String[] args) {
    	
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);
    	cache.put(3 , 3);
    	System.out.println(cache.get(2));
    }

}

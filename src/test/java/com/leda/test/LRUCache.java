package com.leda.test;

import org.checkerframework.checker.units.qual.C;

import javax.xml.ws.soap.Addressing;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    private int capacity = 10;
    private int size;
    private Map<Integer, Node> map;

    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(){
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>();
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value){
        //  判断key是否存在
        if(map.containsKey(key)){
            Node node = map.get(key);
            //删除原节点，讲节点移动到链表头部，

            deleteNode(node);

            AddToHeadNode(node);

        }else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            // 判断是否超过容量，超过则删除尾节点，添加当前节点到最前面
            if(size >= capacity){
                //删除尾节点
                Node last = tail.pre;
                deleteNode(last);

                //添加当前节点到头节点
                AddToHeadNode(node);
            }
        }
    }


    private void AddToHeadNode(Node node) {

    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key){

        return -1;
    }
}


class Node {
    Node pre;
    Node next;
    int key;
    int value;

}
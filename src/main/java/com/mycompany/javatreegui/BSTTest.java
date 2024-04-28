// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */

// package com.mycompany.javatreegui;

// /**
//  *
//  * @author gunterherd
//  */
// import static org.junit.Assert.*;

// import org.junit.Before;
// import org.junit.Test;

// public class BSTTest {

//     private BST<Integer> bst;

//     @Before
//     public void setUp() {
//         bst = new BST<>();
//     }

//     @Test
//     public void testInsert() {
//         bst.insert(10);
//         bst.insert(20);
//         bst.insert(30);
//         assertEquals(3, bst.getSize());
//     }

//     @Test
//     public void testDelete() {
//         bst.insert(10);
//         bst.insert(20);
//         bst.insert(30);
//         assertEquals(3, bst.getSize());
//         bst.delete(20);
//         assertEquals(2, bst.getSize());
//     }

//     @Test
//     public void testEmptyTree() {
//         assertEquals(0, bst.getSize());
//         assertNull(bst.getRoot());
//     }

//     @Test
//     public void testInsertAndDelete() {
//         bst.insert(10);
//         bst.insert(20);
//         bst.insert(30);
//         assertEquals(3, bst.getSize());
//         bst.delete(20);
//         bst.delete(30);
//         assertEquals(1, bst.getSize());
//         assertNull(bst.search(30));
//     }

//     @Test
//     public void testSearch() {
//         bst.insert(10);
//         bst.insert(20);
//         bst.insert(30);
//         assertEquals(Integer.valueOf(30), bst.search(30).element);
//     }
// }

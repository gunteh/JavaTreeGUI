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

// public class AVLTest {

//     private AVL<Integer> avl;

//     @Before
//     public void setUp() {
//         avl = new AVL<>();
//     }

//     @Test
//     public void testInsert() {
//         avl.insert(10);
//         avl.insert(20);
//         avl.insert(30);
//         avl.insert(40);
//         assertEquals(4, avl.getSize());
//     }

//     @Test
//     public void testDelete() {
//         avl.insert(10);
//         avl.insert(20);
//         avl.insert(30);
//         avl.insert(40);
//         assertEquals(4, avl.getSize());
//         avl.delete(20);
//         assertEquals(3, avl.getSize());
//     }

//     @Test
//     public void testEmptyTree() {
//         assertEquals(0, avl.getSize());
//         assertNull(avl.getRoot());
//     }

//     @Test
//     public void testInsertAndDelete() {
//         avl.insert(10);
//         avl.insert(20);
//         avl.insert(30);
//         avl.insert(40);
//         assertEquals(4, avl.getSize());
//         avl.delete(20);
//         avl.delete(40);
//         assertEquals(2, avl.getSize());
//         assertNull(avl.search(40));
//     }

//     @Test
//     public void testSearch() {
//         avl.insert(10);
//         avl.insert(20);
//         avl.insert(30);
//         avl.insert(40);
//         assertEquals(Integer.valueOf(30), avl.search(30).element);
//     }
// }

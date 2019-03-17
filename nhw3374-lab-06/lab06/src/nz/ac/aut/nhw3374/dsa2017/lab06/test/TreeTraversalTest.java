package nz.ac.aut.nhw3374.dsa2017.lab06.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import org.junit.Test;

import nz.ac.aut.nhw3374.dsa2017.lab06.BinTreeNode;
import nz.ac.aut.nhw3374.dsa2017.lab06.TreeTraversal;

public class TreeTraversalTest {
	
	@Test
	public void preorderTest(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		BinTreeNode<String> a3=BinTreeNode.single("3");
		BinTreeNode<String> a4=BinTreeNode.single("4");
		BinTreeNode<String> a5=BinTreeNode.single("5");
		
		a1.connectLeft(a2);
		a1.connectRight(a3);
		a3.connectLeft(a4);
		a3.connectRight(a5);
		
		Object[] a=TreeTraversal.preorder(a1);
		String[] test=new String[]{"1","2","3","4","5"};
		for(int i=0;i<a.length;++i){
			assertEquals(test[i],(String)a[i]);
		}
	}
	
	@Test
	public void inorderTest(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		BinTreeNode<String> a3=BinTreeNode.single("3");
		BinTreeNode<String> a4=BinTreeNode.single("4");
		BinTreeNode<String> a5=BinTreeNode.single("5");
		
		a1.connectLeft(a2);
		a1.connectRight(a3);
		a3.connectLeft(a4);
		a3.connectRight(a5);
		
		Object[] a=TreeTraversal.inorder(a1);
		String[] test=new String[]{"2","1","4","3","5"};
		for(int i=0;i<a.length;++i){
			assertEquals(test[i],(String)a[i]);
		}
	}
	
	@Test
	public void postorderTest(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		BinTreeNode<String> a3=BinTreeNode.single("3");
		BinTreeNode<String> a4=BinTreeNode.single("4");
		BinTreeNode<String> a5=BinTreeNode.single("5");
		
		a1.connectLeft(a2);
		a1.connectRight(a3);
		a3.connectLeft(a4);
		a3.connectRight(a5);
		
		
		Object[] a=TreeTraversal.postorder(a1);
		String[] test=new String[]{"2","4","5","3","1"};
		for(int i=0;i<a.length;++i){
			assertEquals(test[i],(String)a[i]);
		}
	}
}

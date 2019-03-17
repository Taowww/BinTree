package nz.ac.aut.nhw3374.dsa2017.lab06.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import org.junit.Test;

import nz.ac.aut.nhw3374.dsa2017.lab06.BinTreeNode;
import nz.ac.aut.nhw3374.dsa2017.lab06.TreeTraversal;

public class BinTreeNodeTest {
	
	@Test
	public void testFactoryNull(){
		
		try {
			BinTreeNode a=BinTreeNode.single(null);
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testConnectNullLeft(){
		BinTreeNode a=BinTreeNode.single("Test");
		try {
			a.connectLeft(null);
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testConnectNullRight(){
		BinTreeNode a=BinTreeNode.single("Test");
		try {
			a.connectRight(null);
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testConnectLeft(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		BinTreeNode<String> a3=BinTreeNode.single("3");
		assertEquals(a1.safeLeft(),Optional.empty());
		
		a1.connectLeft(a2);
		assertEquals(a1.safeLeft().get().data(),"2");
		
		a1.connectLeft(a3);
		assertEquals(a1.safeLeft().get().data(),"3");
		
	}
	
	@Test
	public void testConnectRight(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		BinTreeNode<String> a3=BinTreeNode.single("3");
		
		assertEquals(a1.safeRight(),Optional.empty());
		
		a1.connectRight(a2);
		assertEquals(a1.safeRight().get().data(),"2");
		
		a1.connectRight(a3);
		assertEquals(a1.safeRight().get().data(),"3");
	}
	
	@Test
	public void testDisConnectLeft(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		a1.connectLeft(a2);
		a1.disconnectLeft();
		assertEquals(a1.safeLeft(),Optional.empty());
		
	}
	
	@Test
	public void testDisConnectRight(){
		BinTreeNode<String> a1=BinTreeNode.single("1");
		BinTreeNode<String> a2=BinTreeNode.single("2");
		a1.connectRight(a2);
		a1.disconnectRight();
		assertEquals(a1.safeLeft(),Optional.empty());
	}
	
	@Test
	public void testData(){
		BinTreeNode a=BinTreeNode.single("Test");
		assertEquals(a.data(),"Test");
	}
	
	@Test
	public void testHeight(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("1");
		BinTreeNode a3=BinTreeNode.single("1");
		BinTreeNode a4=BinTreeNode.single("1");
		BinTreeNode a5=BinTreeNode.single("1");
		BinTreeNode a6=BinTreeNode.single("1");
		
		a1.connectLeft(a2);
		a2.connectLeft(a3);
		a3.connectLeft(a4);
		a4.connectLeft(a5);
		a5.connectLeft(a6);
		
		assertTrue(5==a1.height());
	}
	
	@Test
	public void testBooleanRoot(){
		BinTreeNode a1=BinTreeNode.single("1");
		assertTrue(a1.isRoot());
	}
	
	@Test
	public void testBooleanLeaf(){
		BinTreeNode a1=BinTreeNode.single("1");
		assertTrue(a1.isLeaf());
	}
	
	@Test
	public void testHasLeft(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("2");
		assertFalse(a1.hasLeft());
		a1.connectLeft(a2);
		assertTrue(a1.hasLeft());
	}
	
	@Test
	public void testHasRight(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("2");
		assertFalse(a1.hasRight());
		a1.connectRight(a2);
		assertTrue(a1.hasRight());
	}
	
	@Test
	public void testSize(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("1");
		BinTreeNode a3=BinTreeNode.single("1");
		BinTreeNode a4=BinTreeNode.single("1");
		BinTreeNode a5=BinTreeNode.single("1");
		BinTreeNode a6=BinTreeNode.single("1");
		
		a1.connectLeft(a2);
		a2.connectLeft(a3);
		a3.connectLeft(a4);
		a4.connectLeft(a5);
		a5.connectLeft(a6);
		
		assertTrue(6==a1.size());
	}
	
	@Test
	public void testEqualItself(){
		BinTreeNode a1=BinTreeNode.single("1");
		assertTrue(a1.equals(a1));
	}
	
	@Test
	public void testEqual(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("2");
		BinTreeNode a3=BinTreeNode.single("3");
		a1.connectLeft(a2);
		a1.connectRight(a3);
		
		BinTreeNode a4=BinTreeNode.single("1");
		BinTreeNode a5=BinTreeNode.single("2");
		BinTreeNode a6=BinTreeNode.single("3");
		a4.connectLeft(a5);
		a4.connectRight(a6);
		
		assertTrue(a1.equals(a4));
		assertFalse(a1.equals(a6));
	}
	
	@Test
	public void testHashCode(){
		BinTreeNode a1=BinTreeNode.single("1");
		BinTreeNode a2=BinTreeNode.single("2");
		BinTreeNode a3=BinTreeNode.single("3");
		a1.connectLeft(a2);
		a1.connectRight(a3);
		
		BinTreeNode a4=BinTreeNode.single("1");
		BinTreeNode a5=BinTreeNode.single("2");
		BinTreeNode a6=BinTreeNode.single("3");
		a4.connectLeft(a5);
		a4.connectRight(a6);
		
		assertEquals(a1.hashCode(),a4.hashCode());
	}
	
}

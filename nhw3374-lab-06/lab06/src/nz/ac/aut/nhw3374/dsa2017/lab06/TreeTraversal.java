package nz.ac.aut.nhw3374.dsa2017.lab06;

import java.util.Objects;
import java.util.Stack;

/**
 * Traversal a Binary node and return all element in the tree.
 * @author Tao Wei
 * @version 1.0
 */
public class TreeTraversal{
	
	public static<T> T[] preorder(BinTreeNode<T> tree){
		Objects.requireNonNull(tree);
		T[] result=(T[])(new Object[tree.size()]);
		Stack<BinTreeNode<T>> todo=new Stack<BinTreeNode<T>>();
		BinTreeNode<T> old;
		if(!tree.isEmpty()) {
			todo.push(tree);
		}
		
		for(int i=0;i<tree.size();++i){
			old= todo.pop();
			result[i]=old.data();
			if (!old.right.get().isEmpty()) todo.push(old.right.get());
			if (!old.left.get().isEmpty()) todo.push(old.left.get());

		}
		return result;
	}
	
	public static<T> T[] inorder(BinTreeNode<T> tree){
		Objects.requireNonNull(tree);
		T[] result=(T[])(new Object[tree.size()]);
		Stack<BinTreeNode<T>> todo=new Stack<BinTreeNode<T>>();
		BinTreeNode<T> old,current;
		current=tree;
		
		while(!current.isEmpty()){
			todo.push(current);
			current=current.left.get();
		}
		
		for(int i=0;i<tree.size();++i){
			old= todo.pop();
			result[i]=old.data();
			if(!old.right.get().isEmpty()){
				current=old.right.get();
				do{
					todo.push(current);
					current=current.left.get();
				}while(!current.isEmpty());
			}
		}
		return result;
	}
	
	
	public static<T> T[] postorder(BinTreeNode<T> tree){
		Objects.requireNonNull(tree);
		T[] result=(T[])(new Object[tree.size()]);
		Stack<BinTreeNode<T>> todo=new Stack<BinTreeNode<T>>();
		BinTreeNode<T> current;
		current=tree;
		
		while(!current.isEmpty()){
			todo.push(current);
			if(!current.left.get().isEmpty()){
				current=current.left.get();
			}
			else{
				current=current.right.get();
			}
		}
		
		for(int i=0;i<tree.size();++i){
			current=todo.pop();
			result[i]=current.data();
			
			if(!todo.isEmpty()){
				BinTreeNode<T> parent=todo.peek();
				if(current==parent.left.get()){
					current=parent.right.get();
					while(!current.isEmpty()){
						todo.push(current);
						if(!current.left.get().isEmpty()){
							current=current.left.get();
						}
						else current=current.right.get();
					}
				}
			}
		}
		return result;
	}
	
	
}

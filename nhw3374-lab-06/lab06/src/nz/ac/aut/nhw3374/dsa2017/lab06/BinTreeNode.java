package nz.ac.aut.nhw3374.dsa2017.lab06;

import java.util.Objects;
import java.util.Optional;


/**
 * A Binary Tree Node.
 * @author Tao Wei
 * @version 1.0
 */
public class BinTreeNode<T> {
	
	//Factory
	/**
	 * Makes a new node.
	 * @param can not be null.
	 * @return a binary tree node.
	 */
	public static <T> BinTreeNode<T> single (T data){
		Objects.requireNonNull(data);
		return new BinTreeNode<T>(data);
	}
	
	//Queries
	public Optional<BinTreeNode<T>> safeLeft(){
		if(left.get().isEmpty()) return Optional.empty();
		return left;
	}
	
	public Optional<BinTreeNode<T>> safeRight(){
		if(right.get().isEmpty()) return Optional.empty();
		return right;
	}
	
	public Optional<BinTreeNode<T>> safeParent(){
		if(parent==null) return Optional.empty();
		else return parent;
	}
	
	public Optional<BinTreeNode<T>> unSafeLeft(){
		if(left==null) {
			throw new IllegalArgumentException("Left is null");
		}
		else return left;
	}
	
	public Optional<BinTreeNode<T>> unSafeRight(){
		if(right==null) {
			throw new IllegalArgumentException("Right is null");
		}
		else return right;
	}
	
	public Optional<BinTreeNode<T>> unSafeParent(){
		if(parent==null) {
			throw new IllegalArgumentException("Parent is null");
		}
		else return parent;
	}
	
	public T data(){
		return value;
	}
	
	public boolean isLeaf(){
		if(right.get().isEmpty()&&left.get().isEmpty())return true;
		else return false;
	}
	
	public boolean isRoot(){
		if(parent==null)return true;
		else return false;
	}
	
	public boolean hasLeft(){
		if(left.get().isEmpty())return false;
		else return true;
	}
	
	public boolean hasRight(){
		if(right.get().isEmpty())return false;
		else return true;
	}
	
	public int height(){
		if(isEmpty())return -1;
		return 1+Math.max(left.get().height(),left.get().height());
		
	}
	
	public int size(){
		if(value==null)return 0;
		return 1+left.get().size()+right.get().size();
	}
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	
	@Override
	public boolean equals (Object o) {
		boolean equal=false;
		if (o instanceof BinTreeNode<?>) {
			BinTreeNode<?> bt = (BinTreeNode<?>)o;
			if(bt.isEmpty())return false;
			if(this.value.equals(bt.data())){
				if(this.left.get().isEmpty()&&this.right.get().isEmpty()&&parent==null&&bt.right.get().isEmpty()&&bt.left.get().isEmpty()&&bt.parent==null)return true;
				if(!left.get().isEmpty()&&!bt.left.get().isEmpty()){
					if(!left.equals(bt.left))return false;
					equal=true;
				}
				if(!right.get().isEmpty()&&!bt.right.get().isEmpty()){
					if(!right.equals(bt.right))return false;
					equal=true;
				}
				if(parent!=null&&bt.parent!=null){
					if(!parent.equals(bt.parent))return false;
					equal=true;
				}
				if(equal)return true;
				return false;
			}
			return false;
		}
		return false;
	}
	
	@Override
	public int hashCode () {
		int hash = 0;
		if(isEmpty())return hash;
		else{
			hash = Objects.hash(hash, value);
			
			if(parent!=null){
				hash = Objects.hash(hash, parent.get().value);
			}
			if(!right.get().isEmpty()){
				hash = Objects.hash(hash, right.get().value);
			}
			if(!left.get().isEmpty()){
				hash = Objects.hash(hash, left.get().value);
			}
		}
		return hash;
	}
	
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		if(!this.isEmpty()){
			sb.append("Binary Tree Node");
			sb.append("Value: ");
			sb.append(value);
			
			if(parent!=null){
				sb.append(",parent: ");
				sb.append(parent);
			}
			if(!right.get().isEmpty()){
				sb.append(",right: ");
				sb.append(right);
			}
			if(!left.get().isEmpty()){
				sb.append(",left: ");
				sb.append(left);
			}
			return sb.toString();
		}
		return "The node is empty";
	}
	
	//Commands
	public void disconnectLeft(){
		left.get().parent=null;
		left=Optional.of(new BinTreeNode<T>());
	}
	
	public void disconnectRight(){
		right.get().parent=null;
		right=Optional.of(new BinTreeNode<T>());
	}
	
	public void connectLeft(BinTreeNode<T> newLeft){
		Objects.requireNonNull(newLeft);
		if(isEmpty())return;
		if(!left.get().isEmpty()){
			left.get().parent=null;
		}
		newLeft.parent.of(this);
		left=Optional.of(newLeft);
	}
	
	public void connectRight(BinTreeNode<T> newRight){
		Objects.requireNonNull(newRight);
		if(isEmpty())return;
		if(!right.get().isEmpty()){
			right.get().parent=null;
		}
		newRight.parent.of(this);
		right=Optional.of(newRight);
	}

	//Private
	private T value;
	protected Optional<BinTreeNode<T>> right, left, parent;
	
	private BinTreeNode(){
		this.value=null;
		right=left=Optional.of(this);
		parent=null;
	}
	
	private BinTreeNode(T data){
		this.value=data;
		right=left=Optional.of(new BinTreeNode<T>());
		parent=null;
	}
}

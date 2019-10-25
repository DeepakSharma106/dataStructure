package tree;

/**
 * create the Node
 * @author deepak.sharma
 *
 */
class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	// lets check if the tree is empty
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		// check if inserted node is less than the root, append it to left
		// and if inserted node is greater than the root, append it to the right
		if(node == null) {
			node = new Node(data);
		} else {
			if(data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		
		return node;
	}
	
	public boolean containsNode(int data) {
		return containsRecursively(root, data);
	}
	
	private boolean containsRecursively(Node current, int data) {
		// if root is null then return false
		if(current == null)
			return false;
		// if starting element is the root
		if(current.data == data)
			return true;
	    
		// else check recursively , whether to go left or right of the root
		return data < current.data ? containsRecursively(current.left, data)
				 : containsRecursively(current.right, data);
		
	}
	
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.data : findSmallestValue(root.right);
	}
	
	public void deleteNode(int data) {
		deleteRecursively(root, data);
	}
	
	private Node deleteRecursively(Node current, int data) {
		if(current == null)
			return null;
		
		if(data == current.data) {
			// data found, here goes the deletion logic
			
			// 1. Node is a leaf
			// 2. Node has a single child
			// 3. Node has two children
			
			// when node is a leaf node
			if(current.left == null && current.right == null)
				return null;
			
			// case when node has one child:
			// we would return the non null child so it can be assigned to the parent node
			if(current.left == null)
				return current.right;
			if(current.right == null)
				return current.left;
			
			// case when node has two children::
			// find the node that will replace the deleted node. we will use smallest node of the node to be deleted's right sub tree
	        int smallest = findSmallestValue(current.right);
	        current.data = smallest;
	        current.right = deleteRecursively(current.right, smallest);
	        
	        return current;
		}
		
		if(data < current.data) {
			//look for left subtree
			current.left = deleteRecursively(current.left, data);
		}
		current.right = deleteRecursively(current.right, data);
		
		return current;
	}
	
	
	// method for traversing the tree
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
}




public class BinarySearchTreeTest {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8);
		bst.insert(2);
		bst.insert(7);
		bst.insert(11);
		bst.insert(3);
		bst.insert(6);
		bst.insert(23);
		bst.insert(87);
		bst.insert(12);
		
		bst.preOrder();
		System.out.println();
		System.out.println(bst.containsNode(121));
		bst.deleteNode(8);
		
	    bst.preOrder();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

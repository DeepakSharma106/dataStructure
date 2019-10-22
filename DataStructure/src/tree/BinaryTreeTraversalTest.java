package tree;

class BinaryTree {
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
		}
		
        boolean isLeaf() {
        	return left == null ? right == null : false; 
        }
	}
	
	TreeNode root;
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}


public class BinaryTreeTraversalTest {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		BinaryTree.TreeNode root = new BinaryTree.TreeNode(11);
		bt.root = root;
		
		bt.root.left = new BinaryTree.TreeNode(12);
		bt.root.left.left = new BinaryTree.TreeNode(13);
		bt.root.left.right = new BinaryTree.TreeNode(14);
		
		bt.root.right = new BinaryTree.TreeNode(15);
		bt.root.right.right = new BinaryTree.TreeNode(111);
		bt.root.right.left = new BinaryTree.TreeNode(17);
	
		
		bt.preOrder();

	}

}

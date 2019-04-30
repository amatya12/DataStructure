import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public int numberOfOccurence;

	TreeNode(int data) {
		this.data = data;
		left = right = null;
		int numberOfOccurence=0;
	}
}

public class BasicTree {
	static TreeNode root;
	static int count = 0;

	public TreeNode makeNode(int data) {
		TreeNode new_node = new TreeNode(data);
		new_node.left = null;
		new_node.right = null;
		new_node.numberOfOccurence = 1;
		return new_node;
	}
	
	public void findLowest(TreeNode n) {
		
		if(n.left!=null) {
			findLowest(n.left);
		}
		else {
			System.out.println("asdasdasd"+n.data);
		}
		/*while (n.left!=null) {
			 findLowest(n.left);
		}
		return n.data;*/
	}
	
	public int findSpecifiedNumber(TreeNode n , int number) {
		boolean searching= true;
		TreeNode current = n;
		while(searching) {
			if(number<current.data) {
				findSpecifiedNumber(current=current.left , number);
			}
			if(number>current.data) {
				findSpecifiedNumber( current = current.right  ,number);
			}
			if(number==current.data) {
				searching=false;
			}
				
				
			}
		return current.data;
		}
	//Iterative
	public int findSpecifiedNumberIterative(TreeNode n , int number) {
		boolean searching= true;
		TreeNode current = n;
		while(searching) {
			if(number<current.data) {
				current = current.left;
			}
			if(number>current.data) {
				current = current.right;
			}
			if(number==current.data) {
				searching=false;
			}
				
				
			}
		return current.data;
		}

	public void setLeft(TreeNode n, int data) {
		if (n.left != null) {
			System.out.println("leftnode already exists");

		}

		else {
			n.left = makeNode(data);

		}
	}

	public void setRight(TreeNode n, int data) {
		if (n.right != null) {
			System.out.println("right node already exists");
		} else {

			n.right = makeNode(data);

			}
		}

	public int BuildBinaryTree(int s) {
		int count = 0;
		boolean searching = true;
		if (root == null) {
			root = makeNode(s);
		} else {
			TreeNode current = root;
			while (searching == true) {
				if (s < current.data) {
					count=count+2;
					if (current.left != null) {
						current = current.left;
					} else {
						searching = false;

					}
				}

				else if (s > current.data) {
					count=count+2;
					if (current.right != null) {

						current = current.right;
					} else {
						searching = false;
					}

				}

				else {
						current.numberOfOccurence=current.numberOfOccurence+1;
						count=count+1;
						searching=false;
					

				}
			}
			if (s < current.data) {
				count=count+1;
				setLeft(current, s);

			} if(s>current.data){
				setRight(current, s);

			}
			

		}
		return count;
	}

	public void InOrder(TreeNode t) {
		if (t.left != null)
			InOrder(t.left);
		
		for(int i = 0 ; i <t.numberOfOccurence; i++)
		System.out.println(t.data+" "+t.numberOfOccurence);
	
		
		
		if (t.right != null) {
			InOrder(t.right);
		}
	}

	public void Iterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;

		while (current != null || s.isEmpty() == false) {
			while (current != null) {

				s.push(current);

				current = current.left;
			}
			current = s.pop();
			System.out.println(current.data);
			current = current.right;

		}
	}
	

	public void count(int a) {
		
		TreeNode n = root;
		while (n != null) {

			if (a == n.data) {
				// System.out.println("aa"); stuck in here
			int count =  n.numberOfOccurence;
			System.out.println(count);
			return;
			
			} else if (a > n.data)
				n = n.right;
			else
				n = n.left;
		}
		
		

	}
	

	void writeMessage2File(String fileName, String message) {
		try {
			PrintWriter outFile = null;

			outFile = new PrintWriter(fileName, "utf-8");

			outFile.write(message);

			outFile.close();
		} catch (IOException e) {
			System.out.println("Error opening the output file - " + fileName);
			System.out.println("Error " + e);
		}
	}

	public static void main(String[] args) {
		String s="";
		BasicTree bt = new BasicTree();
		int count12=0;
		try {
			File file = new File("numbers.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
			
				count12+=bt.BuildBinaryTree(Integer.parseInt(line));
			}
			s+="The number of comparisons in Tree sort is "+ count12;
		

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		/*bt.BuildBinaryTree(1);
		bt.BuildBinaryTree(3);
		bt.BuildBinaryTree(2);
		bt.BuildBinaryTree(10);
		bt.BuildBinaryTree(5);
		bt.BuildBinaryTree(9);
		bt.BuildBinaryTree(8);
		bt.BuildBinaryTree(8);*/
		
		
		
		//bt.InOrder(root);
		
		bt.writeMessage2File("Tree.txt",s );
		 bt.findLowest(root);
		System.out.println(bt.findSpecifiedNumber(root, 10));
		
		System.out.println(bt.findSpecifiedNumberIterative(root, 2));
		
	}

}

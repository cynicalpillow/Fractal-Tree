import java.util.*;
public class Tree {
	private Node root;
	private int depth;
	private int deviationLeft;
	private int deviationRight;
	private double decrease;
	ArrayList<Node> tree = new ArrayList<>();
	public Tree(int l, int depth, int deviationLeft, int deviationRight, int startingAngle, double decrease, int x, int y){
		root = new Node(startingAngle, l, x, y);
		root.setEndX(calcEndX(x, l, startingAngle));
		root.setEndY(calcEndY(y, l, startingAngle));
		this.depth = depth;
		this.deviationLeft = deviationLeft;
		this.deviationRight = deviationRight;
		this.decrease = decrease;
		tree.add(root);
		//Generate the tree bruh
		generateTree(root, 0);
	}
	public void generateTree(Node focus, int depth){
		if(depth < this.depth){
			//Create 2 children
			double currLength = focus.getLength()-(focus.getLength()/decrease);
			int angleLeft = focus.getAngle()+deviationLeft;
			int angleRight = focus.getAngle()-deviationRight;
			Node left = new Node(angleLeft, currLength, focus.getEndX(), focus.getEndY());
			Node right = new Node(angleRight, currLength, focus.getEndX(), focus.getEndY());
			//Calculate the end x and y for drawing the line
			left.setEndX(calcEndX(focus.getEndX(), currLength, angleLeft));
			left.setEndY(calcEndY(focus.getEndY(), currLength, angleLeft));
			right.setEndX(calcEndX(focus.getEndX(), currLength, angleRight));
			right.setEndY(calcEndY(focus.getEndY(), currLength, angleRight));
			//Set the focus neighbours (not necessary, but makes it easier to debug and add new shit later)
			focus.setLeft(left);
			focus.setRight(right);
			//add these children to the tree and recurse
			tree.add(left);
			tree.add(right);
			generateTree(left, depth+1);
			generateTree(right, depth+1);
		}
	}
	private int calcEndX(int startx, double hyp, int angle){
		return startx - (int)Math.round(Math.sin(Math.toRadians(angle))*hyp);
	}
	private int calcEndY(int starty, double hyp, int angle){
		return starty - (int)Math.round(Math.cos(Math.toRadians(angle))*hyp);
	}
	public Node getRoot(){
		return root;
	}
	public int getDepth(){
		return depth;
	}
}
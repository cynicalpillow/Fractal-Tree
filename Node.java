//By Rui Li
public class Node {
	private int a;
	private double l;
	private Node left = null;
	private Node right = null;
	private int endx;
	private int endy;
	private int startx;
	private int starty;
	public Node(int a, double l, int startx, int starty){
		this.a = a;
		this.l = l;
		this.startx = startx;
		this.starty = starty;
	}

	//Getters and setters
	public int getAngle(){
		return a;
	}
	public double getLength(){
		return l;
	}
	public Node getLeft(){
		return left;
	}
	public Node getRight(){
		return right;
	}
	public int getStartX(){
		return startx;
	}
	public int getStartY(){
		return starty;
	}
	public int getEndX(){
		return endx;
	}
	public int getEndY(){
		return endy;
	}
	public void setAngle(int a){
		this.a = a;
	}
	public void setLength(double l){
		this.l = l;
	}
	public void setLeft(Node left){
		this.left = left;
	}
	public void setRight(Node right){
		this.right = right;
	}
	public void setStartX(int startx){
		this.startx = startx;
	}
	public void setStartY(int starty){
		this.starty = starty;
	}
	public void setEndX(int endx){
		this.endx = endx;
	}
	public void setEndY(int endy){
		this.endy = endy;
	}
}
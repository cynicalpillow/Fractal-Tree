import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
//By Rui Li
//Driver class for Fractal Tree Generator
public class Driver{
	static JFrame f;
	static DrawPanel p;
	static int width = 1400;
	static int height = 800;
	static Tree t;
	static int length = 150;
	static int depth = 8;
	static int angleLeft = 20;
	static int angleRight = 20;
	static int angleTrunk = 0;
	static double decrease = 3.0;
	static int x = width/2;
	static int y = height-height/4;

	public static void init(){
		f = new JFrame();
		p = new DrawPanel();

		JSlider lengthSlider = new JSlider(JSlider.HORIZONTAL, 1, 500, 150);
		JSlider depthSlider = new JSlider(JSlider.HORIZONTAL, 1, 15, 8);
		JSlider angleLeftSlider = new JSlider(JSlider.HORIZONTAL, -360, 360, 20);
		JSlider angleRightSlider = new JSlider(JSlider.HORIZONTAL, -360, 360, 20);
		JSlider angleTrunkSlider = new JSlider(JSlider.HORIZONTAL, -360, 360, 0);
		JSlider decreaseSlider = new JSlider(JSlider.HORIZONTAL, 10, 150, 30);
		JSlider xSlider = new JSlider(JSlider.HORIZONTAL, 0, width, width/2);
		JSlider ySlider = new JSlider(JSlider.HORIZONTAL, 0, height, height-height/4);
		lengthSlider.addChangeListener(new LengthSliderListener());
		depthSlider.addChangeListener(new DepthSliderListener());
		angleLeftSlider.addChangeListener(new AngleLeftSliderListener());
		angleRightSlider.addChangeListener(new AngleRightSliderListener());
		angleTrunkSlider.addChangeListener(new AngleTrunkSliderListener());
		decreaseSlider.addChangeListener(new DecreaseSliderListener());
		xSlider.addChangeListener(new XSliderListener());
		ySlider.addChangeListener(new YSliderListener());

		//Starting length, depth, angle deviation left, angle deviation right, angle of trunk, decrease
		t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y); 

		p.addKeyListener(p);
		f.setSize(width, height);
		p.setFocusable(true);
		p.add(lengthSlider);
		p.add(depthSlider);
		p.add(angleLeftSlider);
		p.add(angleRightSlider);
		p.add(angleTrunkSlider);
		p.add(decreaseSlider);
		p.add(xSlider);
		p.add(ySlider);
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	static class DrawPanel extends JPanel implements KeyListener{
		public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.white);
            for(Node n : t.tree){
            	g.drawLine(n.getStartX(), n.getStartY(), n.getEndX(), n.getEndY());
            }
        }
      	public void keyPressed(KeyEvent e){}
	    public void keyReleased(KeyEvent e){}
	    public void keyTyped(KeyEvent e){}
	}
	static class LengthSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    length = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class DepthSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    depth = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class AngleLeftSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    angleLeft = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class AngleRightSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    angleRight = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class AngleTrunkSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    angleTrunk = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class DecreaseSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    decrease = source.getValue()/10.0;
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class XSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    x = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	static class YSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		    JSlider source = (JSlider)e.getSource();
		    y = source.getValue();
		    t = new Tree(length, depth, angleLeft, angleRight, angleTrunk, decrease, x, y);
		    f.getToolkit().sync();
		    p.repaint();
		}
	}
	public static void main(String args[]){
		init();
	}
}
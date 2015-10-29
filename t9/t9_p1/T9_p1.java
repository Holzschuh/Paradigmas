/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9_p1;

/**
 *
 * @author Inutiu
 */
public class T9_p1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle c1;
        Circle c2;
        
        c1 = new Circle(new Point(20, 0), 7);
        c2 = new Circle();
        
        System.out.printf("(%.1f, %.1f), %.1f\n", c1.getCenter().getX(), c1.getCenter().getY(), c1.getRadius() );
        System.out.printf("c1 area: %.2f\nc2 area: %.2f\n", c1.getArea(), c2.getArea());
        System.out.printf("distance from center to center: %.2f\ndistance from circle to circle: %.2f\n", c1.getCenter().distPointPoint(c2.getCenter()), c1.distCircleCircle(c2));
        System.out.println(c1.isColliding(c2));
    }
    
}

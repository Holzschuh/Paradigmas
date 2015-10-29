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
public class Circle {
    private Point center;
    private float radius;
    
    Circle(){
        center = new Point();
        radius = 1;
    }
    
    Circle(Point p, float r){
        center = new Point(p.getX(),p.getY());
        radius = r;
    }
    
    public float distCircleCircle(Circle c){
        float distance;
        distance = this.center.distPointPoint(c.center) - this.radius - c.radius;
        if(distance < 0)
            distance = 0;
        return distance;
    }
    
    public boolean isColliding(Circle c){
        if( this.distCircleCircle(c) == 0)
            return true;
        else
            return false;
    }
    
    public float getArea(){
        return (float) 3.14159 * squaredRadius();
    }
    
    public float getDiameter(){
        return 2 * radius;
    }
    
    private float squaredRadius(){
        return radius * radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
    
}



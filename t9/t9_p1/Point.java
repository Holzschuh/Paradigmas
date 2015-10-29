/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9_p1;

import static java.lang.Math.sqrt;

/**
 *
 * @author Inutiu
 */
public class Point {

    private float x;
    private float y;
    
    Point(){
        x = 0;
        y = 0;
    }
    
    Point(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public float distPointPoint(Point p){
        float dx = p.x - x;
        float dy = p.y - y;
        return (float) sqrt(dx*dx + dy*dy);
    }
    
    public void translate(float tx, float ty){
        x += tx;
        y += ty;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}

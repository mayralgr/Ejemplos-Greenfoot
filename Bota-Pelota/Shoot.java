import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoot extends Actor
{
    /**
     * Act - do whatever the Shoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.setLocation(this.getX(),this.getY()-1);
        if(this.getY()==0)
        {
            World mundo = this.getWorld();
            mundo.removeObject(this);
        }
        else if(this.isTouching(Pelota.class))
        {
            removeTouching(Pelota.class);
        }
    }    
}

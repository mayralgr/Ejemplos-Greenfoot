import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    
    private long time;
    private boolean balloon;
    
    public Paddle()
    {

        time=System.currentTimeMillis();
        balloon=true;
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") && this.getY()>350)
        {
            this.setLocation(this.getX()-10, this.getY());
        }
        if(Greenfoot.isKeyDown("left") && this.getY()<350)
        {
            this.setLocation(this.getX()-10, this.getY());
        }
        if(Greenfoot.isKeyDown("s") && this.getY()>350)
        {
            this.setLocation(this.getX()+10, this.getY());
        }
        if(Greenfoot.isKeyDown("right") && this.getY()<350)
        {
            this.setLocation(this.getX()+10, this.getY());
        }
        int e;
        long t=System.currentTimeMillis();
        World mundo=this.getWorld();
        List lista = mundo.getObjects(Balloon.class);
        if(lista.isEmpty())
        {
            balloon=false;
        }
        else
        {
            balloon=true;
        }
        System.out.println(t-time);
        if(t-time>18000 && !balloon)
        {
            int px=Greenfoot.getRandomNumber(mundo.getWidth());
            int py=Greenfoot.getRandomNumber(mundo.getHeight());
            mundo.addObject(new Balloon(),px,py);
            balloon=true;
        }
        
    }    
}

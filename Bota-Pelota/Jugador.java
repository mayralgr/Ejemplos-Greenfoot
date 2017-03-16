import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean disparando;
    
    public Jugador()
    {
        disparando=false;
    }
    
    public void actualizadis()
    {
        
    }
    
    @Override
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            this.setLocation(this.getX()+1,this.getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            this.setLocation(this.getX()-1,this.getY());
        }
        /*if(Greenfoot.isKeyDown("up"))
        {
            this.setLocation(this.getX(),this.getY()-1);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            this.setLocation(this.getX(),this.getY()+1);
        }*/
        if(Greenfoot.isKeyDown("space")&&!disparando)
        {
            World mundo = this.getWorld();
            Shoot s = new Shoot();
            mundo.addObject(s,this.getX(),this.getY());
            disparando=true;
        }
        World mundo = this.getWorld();
        List lista = mundo.getObjects(Shoot.class);
        if(lista.isEmpty())
        {
            disparando=false;
        }
        
        
    }    
}

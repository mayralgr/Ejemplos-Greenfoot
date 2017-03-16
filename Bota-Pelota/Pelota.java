import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pelota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pelota extends Actor
{
    private int incx;
    private int incy;
    
    public Pelota()
    {
        incx=10;
        incy=10;
        int dx,dy;
        dx=Greenfoot.getRandomNumber(10);//random para cambio de dirección x
        if(dx<=5)
            dx=1;
        else 
            dx=-1;
        dy=Greenfoot.getRandomNumber(10);//random para cambio de dirección y
        if(dy<=5)
            dy=1;
        else 
            dy=-1;
            
        incx*=dx;
        incy*=dy;
    }
    /**
     * Act - do whatever the Pelota wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        int posx=this.getX();
        int posy = this.getY();// Add your action code here.
        int nuevox=posx+incx;
        int nuevoy=posy+incy;
        //cambiamos de posicion a la pelota
        
        World mundo=this.getWorld();
        if(nuevox>mundo.getWidth()) //rebota en el lado derecho
        {
            incx=-incx;
        }
        if(nuevoy>mundo.getHeight())//rebota en la parte de abajo
        {
            incy=-incy;
        }
        if(nuevoy<0)
        {
            incy=-incy;
        }
         if(nuevox<0)
        {
            incx=-incx;
        }
        this.setLocation(nuevox,nuevoy);
    }    
    
}

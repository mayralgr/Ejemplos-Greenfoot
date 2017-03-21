import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor
{
    private long time;
    private int incx;
    private int incy;
    
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Balloon()
    {
        time=System.currentTimeMillis();
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
        if(nuevox<0)
        {
            incx=-incx;
        }
        this.setLocation(nuevox,nuevoy);
        if(this.getY()==0||this.getY()>=mundo.getHeight()-incy||this.isTouching(Paddle.class))
        {
            mundo.removeObject(this);
        }
    }    
}

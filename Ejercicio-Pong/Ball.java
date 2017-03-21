import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
import java.lang.String;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball  extends Actor

{
    private int incx;
    private int incy;
    private int jugador1;
    private int jugador2;
    private int speed;
    public Ball()
    {
        incx=5;
        incy=5;
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
        jugador1=0;
        jugador2=0;
        Greenfoot.delay(10);
    }
     @Override
     public void act() 
     {
        int posx=this.getX();
        int posy = this.getY();// Add your action code here.
        if(jugador1==2||jugador2==2)
        {
           incx=10;
           incy=10;
        }
        int nuevox=posx+incx;
        int nuevoy=posy+incy;
        
        //cambiamos de posicion a la pelota
        World mundo=this.getWorld();
        if(nuevox>mundo.getWidth()) //rebota en el lado derecho
        {
            incx=-incx;
        }
        if(nuevoy>mundo.getHeight())
        {
            jugador1++;
            nuevox=mundo.getWidth()/2;
            nuevoy=mundo.getHeight()/2;
        }
        if(nuevoy<0)
        {
            jugador2++;
            nuevox=mundo.getWidth()/2;
            nuevoy=mundo.getHeight()/2;
        }
         if(nuevox<0)
        {
            incx=-incx;
        }
        if(this.isTouching(Paddle.class))
        {
            incy=-incy;
            nuevoy=this.getY()+incy;   
        }
        
        if(nuevox==mundo.getWidth()/2 && nuevoy==mundo.getHeight()/2)
        {
            this.setLocation(nuevox,nuevoy);
            Greenfoot.delay(10);
        }
        else
        {
            this.setLocation(nuevox,nuevoy);
        }
       mundo.showText("Jugador 1: "+jugador1, 60, 10);
       mundo.showText("Jugador 2: "+jugador2, 60, mundo.getHeight()-15);
       if(jugador1==5||jugador2==5)
       {
           mundo.showText("Game Over",mundo.getWidth()/2, mundo.getHeight()/2);
           if(jugador1==5)
           {
               mundo.showText("El jugador 1 es el ganador",mundo.getWidth()/2 , mundo.getHeight()/2+20);
            }
           else
           {
               mundo.showText("El jugador 2 es el ganador",  mundo.getWidth()/2,mundo.getHeight()/2+20); 
            }
           Greenfoot.stop();
        }

    }
    

}

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
        jugador1=0;
        jugador2=0;
        speed=38;
        Greenfoot.setSpeed(speed);
    }
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
        if(nuevoy>mundo.getHeight())
        {
            jugador1++;
            nuevox=mundo.getWidth()/2;
            nuevoy=mundo.getHeight()/2;
            Greenfoot.delay(10);
        }
        if(nuevoy<0)
        {
            jugador2++;
            nuevox=mundo.getWidth()/2;
            nuevoy=mundo.getHeight()/2;
            Greenfoot.delay(10);
        }
         if(nuevox<0)
        {
            incx=-incx;
        }
        if(this.isTouching(Paddle.class))
        {
            incy=-incy;
        }
       this.setLocation(nuevox,nuevoy);
       
       if(jugador1>2||jugador2>2)
       {
           if(speed<55)
           {
               int t=Greenfoot.getRandomNumber(5);
               speed+=t;
               Greenfoot.setSpeed(speed);
            }
           
        }
       String str = jugador1 +"";
       mundo.showText("Jugador 1", 60, 10);
       mundo.showText(str, 150, 10);
       mundo.showText("Jugador 2", 60, mundo.getHeight()-15);
       str = jugador2 + "";
       mundo.showText(str, 150, mundo.getHeight()-15);
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

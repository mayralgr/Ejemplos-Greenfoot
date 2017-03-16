import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escenario extends World
{
    public Escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,true); 
        prepare();
    }

    @Override
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //System.out.println("Click en el mundo");
            MouseInfo raton = Greenfoot.getMouseInfo();
            /*System.out.println("Coordenadas x= "+
            raton.getX()+" Coordenadas y= "+
            raton.getY());*/
            Pelota p=new Pelota();
            super.addObject(p,raton.getX(),raton.getY());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Jugador jugador = new Jugador();
        addObject(jugador,290,327);
        Pelota pelota = new Pelota();
        addObject(pelota,466,78);
        Pelota pelota2 = new Pelota();
        addObject(pelota2,136,92);
        Pelota pelota3 = new Pelota();
        addObject(pelota3,336,193);
        Shoot shoot = new Shoot();
        addObject(shoot,329,235);
        removeObject(shoot);
    }
}

package Ejercicios.Ejercicio5;

import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;

public class Pantalla extends Frame implements MouseListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Pantalla() {
        initComponents();

    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        obj_pintable = new Contenedor();
        obj_pintable.addMouseListener(this);
        this.add(obj_pintable);

        this.setSize(500, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Pantalla p = new Pantalla();
    }

    private Contenedor obj_pintable;

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("clicked");
        if (obj_pintable.isClicked()) {
            obj_pintable.setX(e.getX());
            obj_pintable.setY(e.getY());
            obj_pintable.repaint();
        } else {
            obj_pintable.setX(e.getX());
            obj_pintable.setY(e.getY());
        }
        obj_pintable.setClicked();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Entrando");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Saliendo");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Presionado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Liberado");
    }
}

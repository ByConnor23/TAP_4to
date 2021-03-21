package Ejercicios.Bloc_N;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JComboBox;

public class Nota extends Frame implements ActionListener{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Nota(){
        init();    
    }

    public void init(){
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //Paneles
        p_superior = new Panel();
        p_central = new Panel();
        p_inferior = new Panel();
        p_superior.setLayout(new FlowLayout());
        p_central.setLayout(new BorderLayout());
        p_inferior.setLayout(new BorderLayout());

        //Zonas de texto
        txt_in = new TextArea();
        txt_in.setBackground(Color.white);
        txt_out = new TextArea();
        txt_out.setBackground(Color.white);
        //txt_out.setBounds(20, 645, 40, 180);
        txt_out.setEditable(false);
        
        
        //Botones
        //color = new Button("Color");
        comillas = new Button("Comillas");
        //tamanio = new Button("Tamanio");
        open = new Button("Abrir");
        save = new Button("Guardar");
        exit = new Button("Salir");
        
        //ComboBox
        String colores[]={
            "Color","Black", "White", "Cyan","Green","Yellow","Pink","Orange",
            "Dark Gray", "Gray", "Light Gray", "Red","Blue","Magenta"
        };
        color = new JComboBox(colores);
        
        String opciones[] = {"Tamanio","Agrandar","Disminuir"};
        tamanio = new JComboBox(opciones);

        this.setLayout(new BorderLayout());
        

        //Agregando botones al FLowlayout
        p_superior.add(color, FlowLayout.LEFT);
        p_superior.add(save, FlowLayout.CENTER);
        p_superior.add(exit, FlowLayout.RIGHT);
        p_superior.add(open, FlowLayout.CENTER);
        p_superior.add(comillas, FlowLayout.CENTER);
        p_superior.add(tamanio, FlowLayout.CENTER);
        this.add(p_superior, BorderLayout.NORTH);

        //Agregando los paneles al BorderLayout
        p_central.add(txt_in, BorderLayout.CENTER);
        this.add(p_central, BorderLayout.CENTER);
        p_inferior.add(txt_out, BorderLayout.NORTH);
        this.add(p_inferior, BorderLayout.SOUTH);

        

        //Propiedades de la ventana
        this.setSize(600,650);
        this.setTitle("Bloc de Notas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
        //Asignando Fuenetes
        txt_in.setFont(new Font("Tahoma",0, 14));

        color.addActionListener(this);
        tamanio.addActionListener(this);
        comillas.addActionListener(this);
        exit.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == color){
            if(color.getSelectedIndex() == 1){
                txt_in.setForeground(Color.black);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 2){
                txt_in.setForeground(Color.white);
                txt_in.setBackground(Color.black);
            }
            
            if(color.getSelectedIndex() == 3){
                txt_in.setForeground(Color.cyan);
                txt_in.setBackground(Color.black);
            }
            
            if(color.getSelectedIndex() == 4){
                txt_in.setForeground(Color.green);
                txt_in.setBackground(Color.black);
            }
            
            if(color.getSelectedIndex() == 5){
                txt_in.setForeground(Color.yellow);
                txt_in.setBackground(Color.black);
            }
            
            if(color.getSelectedIndex() == 6){
                txt_in.setForeground(Color.pink);
                txt_in.setBackground(Color.darkGray);
            }
            
            if(color.getSelectedIndex() == 7){
                txt_in.setForeground(Color.orange);
                txt_in.setBackground(Color.darkGray);
            }
            
            if(color.getSelectedIndex() == 8){
                txt_in.setForeground(Color.darkGray);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 9){
                txt_in.setForeground(Color.gray);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 10){
                txt_in.setForeground(Color.lightGray);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 11){
                txt_in.setForeground(Color.red);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 12){
                txt_in.setForeground(Color.blue);
                txt_in.setBackground(Color.white);
            }
            
            if(color.getSelectedIndex() == 13){
                txt_in.setForeground(Color.magenta);
                txt_in.setBackground(Color.darkGray);
            }
            
            if(color.getSelectedIndex() != 0){
                txt_out.append("Se cambio el color de la fuente a " + color.getSelectedItem()+"\n");
            }
            color.setSelectedIndex(0);
        }
        
        if(arg0.getSource() == comillas){
            if(txt_in.isCursorSet() == true){
                String seleccionado = txt_in.getSelectedText();
                String full = txt_in.getText();
                
                txt_in.setText(full.replace(seleccionado, "''"+seleccionado+"''"));
            }else{
                txt_out.append("No hay texto seleccionado");
            }
        }
        
        if(arg0.getSource() == tamanio){
            if(tamanio.getSelectedIndex() == 1){
                if(cont <= 12){
                    cont+=1;
                }else if(cont >= 12){
                    cont+=2;
                }
                
                txt_in.setFont(new Font("Tahoma",0,cont));
            }
            
            if(tamanio.getSelectedIndex() == 2){
                if(cont <= 12){
                    cont-=1;
                }else if(cont >= 12){
                    cont-=2;
                }
                txt_in.setFont(new Font("Tahoma",0,cont));
            }
            
            if(tamanio.getSelectedIndex() != 0){
                if(tamanio.getSelectedIndex() == 1){
                    txt_out.append("Se agrando la fuente" );
                }else{
                    txt_out.append("Se disminuyo la fuente");
                }
            }
            tamanio.setSelectedIndex(0);
        }

        if(arg0.getSource() == exit){
            dispose();
        }
    }

    public static void main(String []args){
        Nota n = new Nota();
    }

    TextArea txt_in;
    TextArea txt_out;
    Label espacio;
    Button comillas;
    //Button tamanio;
    Button save;
    Button open;
    Button exit;
    Panel p_superior;
    Panel p_central;
    Panel p_inferior;
    String cambiar_c;
    //Nota colores;
    JComboBox color;
    JComboBox tamanio;
    int cont = 14;
    //Window abrir; 
    //Color co;   
}
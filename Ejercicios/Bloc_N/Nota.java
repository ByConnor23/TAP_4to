package Ejercicios.Bloc_N;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        p_superior.setLayout(new FlowLayout());//Uso un flowlayout para agregar todos los botones de forma horizontal
        p_central.setLayout(new BorderLayout());//Para el panel inferior y central, usare un Borderlayout
        p_inferior.setLayout(new BorderLayout());

        //Zonas de texto
        txt_in = new TextArea();//Usare un textArea para que el usuario puede escribir lo que quiera
        txt_in.setBackground(Color.white);
        txt_out = new TextField();//En este caso el textField sera mi indicador de cambios
        txt_out.setBackground(Color.white);
        txt_out.setEditable(false);//Desactivo la edición porque no quiero que se pueda escribir ahi, ya que solo me servira
        //para indicar los cambios que sucedan.
                
        //Botones
        comillas = new Button("Comillas"); //Voy a usar solo cuatro botones, ya que los otros usare un ComboBox
        open = new Button("Abrir");
        save = new Button("Guardar");
        exit = new Button("Salir");
        
        //ComboBox
        String colores[]={ //Este arreglo es el que enviare al primer comboBox 
            "Color","Black", "White", "Cyan","Green","Yellow","Pink","Orange",
            "Dark Gray", "Gray", "Light Gray", "Red","Blue","Magenta"
        };// Este comboBox me servira para los colores de las letras, solo usare los colores basicos 
        color = new JComboBox(colores);
        
        //Este es el arreglo que enviare al segundo comboBox
        String opciones[] = {"Tamanio","Agrandar","Disminuir"};
        tamanio = new JComboBox(opciones);// Solo tendra dos opciones o disminuye la letra o la aumenta

        this.setLayout(new BorderLayout());//Le asigno el Layout a la ventana
        

        //Agregando botones al FLowlayout
        p_superior.add(color, FlowLayout.LEFT);//Le asigno a todos los botones una ubicacion en el FlowLayout del panel superior
        p_superior.add(save, FlowLayout.CENTER);
        p_superior.add(exit, FlowLayout.RIGHT);
        p_superior.add(open, FlowLayout.CENTER);
        p_superior.add(comillas, FlowLayout.CENTER);
        p_superior.add(tamanio, FlowLayout.CENTER);
        this.add(p_superior, BorderLayout.NORTH);//Añado el panel superior al BorderLayout de la ventana

        //Agregando los paneles al BorderLayout
        p_central.add(txt_in, BorderLayout.CENTER);//Pongo mi textArea en el centro del Layout del panel centrel
        this.add(p_central, BorderLayout.CENTER);//Añado el panel central al Layout de la ventana
        p_inferior.add(txt_out, BorderLayout.CENTER);//Pongo el textField en centro del layout del panel inferior
        this.add(p_inferior, BorderLayout.SOUTH);//Ahora añado el panel a al layout de la ventana

        

        //Propiedades de la ventana
        this.setSize(600,650);
        this.setTitle("Bloc de Notas");
        this.setLocationRelativeTo(null);//Asigno la posicion inicial de la ventana en el centro
        this.setResizable(false);//Con esto eviyo que se puede redimencionar el tamaño de la ventana
        this.setVisible(true);//Hago visible la ventana
        
        //Asignando Fuenetes
        txt_in.setFont(new Font("Tahoma",0, 14));//Con esto asigno tanto el nombre la fuente que quiero que tenga mi textArea
        //al igual que asigno que quiero que el tipo sea normal y un tamaño de 14

        color.addActionListener(this);//Le añado tanto a los botones y como al comboBox un oyente de accion.
        tamanio.addActionListener(this);
        comillas.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Si se selcciona el boton de color 
        if(arg0.getSource() == color){
            //Aqui hice un if por cada color, si se selecciona un color, entonconces obtengo la opcionn seleccionada 
            if(color.getSelectedIndex() == 1){//mediante el index, entonces con eso voy asignando el color de la letra
                txt_in.setForeground(Color.black);//tambien puse un setBackground para establecer el fondo del textArea
                txt_in.setBackground(Color.white);//ya que algunos colores son colores claros y con un fondo blanco no se aprecian
                                                //bien.
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
            
            if(color.getSelectedIndex() != 0){//Aqui condicione el la primera opcion ya que ese solo lo quiero como titulo del comboBox
                txt_out.setText("Se cambio el color de la fuente a " + color.getSelectedItem()+"\n");//Envio el mensaje en el textField como actualización
            }
            color.setSelectedIndex(0);//Aqui asigno que cuando seleccione una opción, en el comboBox, aparesca como primera opcion la palabra "Color"
        }
        
        //Si se selecciona el boton de comillas    
        if(arg0.getSource() == comillas){//Puse un condicional en el cual si al obtener el texto del textArea sea diferente de nulo y si
            if((txt_in.getText() != null) && (txt_in.getSelectedText() != "")){//hay algo seleccionado y es diferente de vacio, entonces entra al if
                String seleccionado = txt_in.getSelectedText();//Aqui lo que hago es obtener el texto seleccionado y guardarlo en una variable
                String full = txt_in.getText();//Aqui lo que hago es obtener todo el texto que esta en el TextArea
                
                txt_in.setText(full.replace(seleccionado, "''"+seleccionado+"''"));//Aqui con ayuda del replace sustituyo en el texto completo
                //Lo seleccionado y lo cambio por el mismo pero con las comillas y asigno el texto otra vez en el textArea 
                txt_out.setText("Se añadio comillas");//Aqui mando un mensaje a la barra de estado, que se añadieron comillas
            }else{
                //Ahora en dado caso que esto no se cumpla, envio un mensaje a la barra de estado, para decir que no hay un texto seleccionado. para poder asignar las comillas
                txt_out.setText("No hay texto seleccionado\n");
            }
        }
        
        //Asi se selecciona el boton de tamaño
        if(arg0.getSource() == tamanio){//uso lo mismo que en de color, ya que quiero usar 2 de las 3 opciones del ComboBox
            if(tamanio.getSelectedIndex() == 1){//si se selecciona el 1 es decir agrandar entonces uso otro if
                if(cont <= 12){//Use la misma logica que un documento word, como el tamaño esta en inicializado en 14, entonces 
                    cont+=1;    //use un contador, este contador, me iba ayudar, ya que si este es menor a 12, entonces si se quiere
                }else if(cont >= 12){//agrandar o disminuir, entonces lo hara en 1, pero si el contador es mayor o igual 12 entonces lo hara en
                    cont+=2;//dos
                }
                
                txt_in.setFont(new Font("Tahoma",0,cont));//Aqui es donde asignaba el lo que tenia el contador, como tercer parametro, ya que ese 
                //es el del tamaño
            }
            
            //Aqui es el otro condicional que decia, es el de disminuir
            if(tamanio.getSelectedIndex() == 2){
                if(cont <= 12){
                    cont-=1;
                }else if(cont >= 12){
                    cont-=2;
                }
                txt_in.setFont(new Font("Tahoma",0,cont));
            }

            //Con estos if condiciono la primera opción, ya que sudece lo mismo con el color
            if(tamanio.getSelectedIndex() != 0){//Si se selcciono la opcion de agrandar entonces asigno el texto al textField, entonces
                if(tamanio.getSelectedIndex() == 1){//envio el msj de que se agrando la fuente, en caso contrario, envio que se agrando
                    txt_out.setText("Se agrando la fuente\n" );//la fuente
                }else{
                    txt_out.setText("Se disminuyo la fuente\n");
                }
            }
            //Aqui pongo por default que se muestre en el comboBox la palabra "tamaño"
            tamanio.setSelectedIndex(0);
        }

        //Si se lecciona el boton de abrir
        if(arg0.getSource() == open){//Creo un FileChooser
            select_open = new JFileChooser(System.getProperty("user.dir"));
                select_open.showOpenDialog(this);//Entonces le asigno el FileChosser que me muestre una ventana de dialogo
                file = select_open.getSelectedFile();//Aqui guardo en un tipo de dato File, el archivo que quiero abrir
            try {//Uso un try catch
                read = new BufferedReader(new FileReader(file));//Creo un bufferedreader y un file reader
                line = read.readLine();//Con el line guardo en un string una linea del texto que selecione
                while(line != null){//Entro al while si lo que esta en line es diferente de nulo
                    txt_in.append(line + "\n");//Entonces agrego lo que tiene line en el TextArea
                    line = read.readLine();//Ahora hago lo mismo, vuelvo a guardar una linea en el String y lo agrego al textArea
                }                          //hasta que termine de leer el archivo que queria
            } catch (Exception ex) {
                Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
            }
            name = file.getName();//Obtengo el nombre del archivo que seleccione
            txt_out.setText("Se abrio el archivo " +name+ "\n");//y lo mando a la barra de estado, con el nombre del archivo
        }
        
        //Si se selecciona guardar
        if(arg0.getSource() == save){
            select_save = new JFileChooser();//Creo el FileChooser
            select_save.showSaveDialog(null);
            select_save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//Le asigno que me seleccione los archivos y directorios
            file_save = select_save.getSelectedFile();//Obtengo el archivo que quiero guardar
            
            try{//Uso otro tryCatch
                file_writer = new FileWriter(file_save+ ".txt", true);//Le asigno que el archivo que va a escribir va a ser un txt
                buf_writer = new BufferedWriter(file_writer);//le envio al bufffered el writer
                print_w = new PrintWriter(buf_writer);//y asu vez el al print el writer
                print_w.print(txt_in.getText());//Con esto obtengo todo el texto del textArea
                print_w.close();//y que cuando termine se cierre
            }catch(Exception e){
            //    
            }//Obtengo el nombre del nombre del archivo
            name = file.getName();
            txt_out.setText("Se guardo el archivo " +name+ "\n");//y envio a la barra de estado, que se guardo un archivo
        }

        //y que si se selecciona cerrar
        if(arg0.getSource() == exit){
            dispose();//con el dispose, le asigno que la ventana se cierre
        }
    }

    public static void main(String []args){
        Nota n = new Nota();
    }
    //estas son todos los atributos que use
    TextArea txt_in;
    TextField txt_out;
    Button comillas;
    Button save;
    Button open;
    Button exit;
    Panel p_superior;
    Panel p_central;
    Panel p_inferior;
    String cambiar_c;
    JComboBox color;
    JComboBox tamanio;
    int cont = 14;
    JFileChooser select_open;
    JFileChooser select_save;
    File file;
    File file_save;
    BufferedReader read;
    String line;
    String name;
    FileWriter file_writer;
    BufferedWriter buf_writer;
    PrintWriter print_w;
}

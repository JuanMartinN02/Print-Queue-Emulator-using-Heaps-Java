/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;



import Estructuras.HashTable1;
import Estructuras.ListUsuario;
import Estructuras.Monticulo;
import Estructuras.NodeUsuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author reina
 */
public class App {
    
    private long inicioSimulacion;
    private Monticulo bMonticulo;
    private ListUsuario lista;
    private HashTable1 hashTable; 
    private static App app;
    
    

    /**
     * @Descripcion: metodo que verifica si el archivo dado es un txt con el
     * path que se pase por parametro
     * @param nombreArchivo
     * @author: Reinaldo Reyes
     * @return boolean
     * @version: 09/11/2023
     */
    private App() {
        inicioSimulacion = System.currentTimeMillis();
        this.bMonticulo = new Monticulo();
        this.lista = new ListUsuario();
        this.hashTable = new HashTable1(); 
    }
    
    /**
 * @Descripcion: Contador del tiempo transcurrido en la build
 * @author Juan Martin
 * @version: 13/11/2023
 */
    public int tiempoTranscurrido(){
        long tiempoActual = System.currentTimeMillis();
        
        long tiempoTranscurrido = tiempoActual - getInicioSimulacion();
         
        int segundosTranscurridos = (int) (tiempoTranscurrido / 1000);
        
        return segundosTranscurridos;
    }
    
    /**
     * @Nombre: getInstance
     * @Descripcion: retorna la unica instancia de app que hay y si no existe la
     * crea
     * @author: Catalina Matheus
     * @version 14/10/2023
     * @return: app
     */
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }
    
    /**
     * @Descripcion: metodo que verifica si el txt dado cumple con la estructura
     * @param nombreArchivo
     * @return boolean
     * @author: Reinaldo Reyes
     * @version: 11/11/2023
     */
    public boolean validTxt(String nombreArchivo) {
        if (nombreArchivo.toLowerCase().endsWith(".csv")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Descripcion: metodo que verifica si el txt dado cumple con la estructura
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @author: Catalina Matheus, Reinaldo Reyes
     * @version: 09/11/2023
     */
    public boolean VerifyArchive(String path) throws FileNotFoundException, IOException {
        String line;
        boolean valid = validTxt(path);
        if (valid) {
            boolean contieneEstruc = false;
            boolean contieneUsuarios = false;
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                line = br.readLine();
                line = line.toLowerCase();
                String[] temp = line.split(",");
                if (temp[0].equals("usuario") && temp[1].equals("tipo")) {
                    contieneEstruc = true;

                    while ((line = br.readLine()) != null && contieneEstruc == true) {

                        line = line.toLowerCase();
                        temp = line.split(",");

                        if (temp.length == 2) {

                            if (!temp[0].replace(" ", "").equals("") && (temp[1].replace(" ", "").equals("prioridad_alta") || temp[1].replace(" ", "").equals("prioridad_media") || temp[1].replace(" ", "").equals("prioridad_baja"))) {
                                contieneUsuarios = true;
                            } else {
                                contieneUsuarios = false;
                            }

                        } else {
                            contieneUsuarios = false;
                            JOptionPane.showMessageDialog(null, "Error! El Csv que montó no tiene el formato permitido.");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error! El Csv que montó no tiene el formato permitido.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error! El Csv que montó no tiene el formato permitido.");
            }
            return contieneEstruc && contieneUsuarios;

        } else {
            JOptionPane.showMessageDialog(null, "Error! El archivo que montó no es Csv");
            return false;
        }
    }

    /**
     * @Descripcion: metodo que crea una lista con la informacion del txt que se
     * pase por el parametro
     * @param path
     * @author: Reinaldo Reyes
     * @version: 09/11/2023
     */
    public void leerUsuarios(String path) throws IOException {

        if (!this.lista.isEmpty()) {
            this.setLista(new ListUsuario());
        }
        if (this.VerifyArchive(path)) {
            try {
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line;
                line = br.readLine();
                String[] temp = line.split(", ");
                while ((line = br.readLine()) != null) {
                    line = line.toLowerCase();
                    temp = line.split(",");
                    NodeUsuario nuevo = new NodeUsuario(temp[0], temp[1]);
                    getLista().appendLast(nuevo);

                }

                JOptionPane.showMessageDialog(null, "Se logró leer el Csv con éxito!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error! No se logró leer el Csv.");
            }

        }

    }
    

    public Monticulo getbMonticulo() {
        return bMonticulo;
    }

    public void setbMonticulo(Monticulo bMonticulo) {
        this.bMonticulo = bMonticulo;
    }

    public ListUsuario getLista() {
        return lista;
    }

    public void setLista(ListUsuario lista) {
        this.lista = lista;
    }

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        App.app = app;
    }

    /**
     * @return the inicioSimulacion
     */
    public long getInicioSimulacion() {
        return inicioSimulacion;
    }

    /**
     * @param inicioSimulacion the inicioSimulacion to set
     */
    public void setInicioSimulacion(long inicioSimulacion) {
        this.inicioSimulacion = inicioSimulacion;
    }

    /**
     * @return the hashTable
     */
    public HashTable1 getHashTable() {
        return hashTable;
    }

    /**
     * @param hashTable the hashTable to set
     */
    public void setHashTable(HashTable1 hashTable) {
        this.hashTable = hashTable;
    }

   
    
    
    
    
}

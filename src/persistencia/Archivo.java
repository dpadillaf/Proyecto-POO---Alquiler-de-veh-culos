/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;


import java.io.IOException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import logica.AgenciaAlquilaVehiculos;

//Clase tomada de Yasmín Moya
public class Archivo implements Serializable {
	 public static Object loading(String a) throws ClassNotFoundException,IOException{
		File archivo=new File(a);
		ObjectInputStream entrada = null;
		AgenciaAlquilaVehiculos cargar=new AgenciaAlquilaVehiculos();
		try{
		  if(archivo.exists()){
		  	entrada=new ObjectInputStream(new FileInputStream(archivo));
			cargar=(AgenciaAlquilaVehiculos) entrada.readObject();
		  }

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "EL ARCHIVO NO EXISTE", "ERROR EN EL FICHERO", JOptionPane.WARNING_MESSAGE);
		}finally{
			if(entrada!=null){
				entrada.close();
			}
		}
		return cargar;
	}

   	public static void saving(Object cargar, String a)throws ClassNotFoundException,IOException{
		File archivo =new File(a);
		ObjectOutputStream salida =null;

		try{
			salida=new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(cargar);
		}catch(Exception e){
            System.out.println(e);
		    JOptionPane.showMessageDialog(null, "EL ARCHIVO NO SE PUEDE ESCRIBIR", "ERROR DEL FICHERO", JOptionPane.WARNING_MESSAGE);
		}finally{
			salida.close();
		}
	}
}
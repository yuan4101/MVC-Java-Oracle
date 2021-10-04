
package controlador;
import modelo.BD;
import vista.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Control {

    
    public static void main(String[] args) throws IOException, SQLException {
                
      int x, op; 
      BD b= new BD();
      ResultSet datos;
      String sql,sql1;
      Usuario us= new Usuario(); 
      BufferedReader in= new BufferedReader (new InputStreamReader (System.in));
      
      do{
          System.out.println("1. Insertar un usuario");
          System.out.println("2. Mostrar todos los usarios");
          System.out.println("digite la opcion");
          op=Integer.parseInt(in.readLine());
          switch(op)
          {
              case 1:
                  us.setCodigo(0);
                  us.setUsername("admin");
                  us.setContrasena("password");
                  sql1 = "INSERT INTO usuario VALUES(" +us.getCodigo()+",'"+ us.getUsername()+"','"+ us.getContrasena()+"')";
                  //INSERT INTO "LABORATORIO"."USUARIO" (US_CODIGO, US_NOMBREUSUARIO, US_PASSWORD) VALUES ('1', 'mvidal', 'mvidal')
                   x=b.registrar(sql1);
                  break;
              case 2:
                        sql="SELECT * FROM usuario";
                        b.peticion(sql);
                        datos=b.peticion(sql);
                        us.setCodigo(datos.getInt(1));
                        us.setContrasena(datos.getString(2));
                        us.setUsername(datos.getNString(3));
                        
                        System.out.println("codigo: " + us.getCodigo());
                        System.out.println("nombre: " + us.getUsername());
                        System.out.println("apellido: " + us.getContrasena());
                        
                        while( datos.next()){
                            us.setCodigo(datos.getInt(1));
                            us.setContrasena(datos.getString(2));
                            us.setUsername(datos.getNString(3)); 
                            System.out.println("codigo: " + us.getCodigo());
                            System.out.println("nombre: " + us.getUsername());
                            System.out.println("nombre: " + us.getContrasena());
                            
                         } 
                 default: System.out.println("error");
            }                  
          
               
     }while (op!=3);  
    
}
}


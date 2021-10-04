package modelo;

import java.sql.*;
import java.util.*;

public class BD  {
    ResultSet resultado;
    Connection conexion=null;
    int r;
    /** Creates a new instance of Base */
    public BD() {
        //llama ala funcion que se conecta a la base de datos
        init();

    }


   //esta funcion realiza peticiones query a la base de datos dependiendo
   //del string sql que le llega a la funcion
     public ResultSet peticion (String sql){
       ResultSet resultado= null;
        try{
            Statement sentencia = conexion.createStatement();
            /*IMPORTANTE: executeQuery solo sirve para sentencias que solo requieran informacion
             *como SELECT, para ejecutar cambios en la base de datos como DELETE O UPDATE se necesita executeUpdate*/
            resultado=sentencia.executeQuery(sql);
            //que imprima el resultado de la columna nombre para el primer registro encontrado
            //por medio del codigo (mirar el constructor de main)
            if(resultado.next())
            {
                //conexion.close();
                return resultado;
            }
          }
        catch(Exception e){
           System.out.println(e.getMessage());
        }

     return null;
    }

     public void cerrarconexion()throws Exception
     {
     conexion.close();
     System.out.println("se cerro la conexion");
     }
//esta funcion realiza peticiones update a la base de datos dependiendo
   //del string sql que le llega a la funcion
     public int registrar (String sql){

        try{
            Statement sentencia = conexion.createStatement();
            /*IMPORTANTE: executeQuery solo sirve para sentencias que solo requieran informacion
             *como SELECT, para ejecutar cambios en la base de datos como DELETE O UPDATE se necesita executeUpdate*/
            r=sentencia.executeUpdate(sql);
            //que imprima el resultado de la columna nombre para el primer registro encontrado
            //por medio del codigo (mirar el constructor de main)
            if(r!=0)
            {
               return r;
            }
          }
        catch(Exception e){
           System.out.println(e.getMessage());
        }
       return 0;
    }
       
    /*Esta funcion crea la conexion a la base de datos*/
    public  void init()
    {
        try{
        Class.forName( "oracle.jdbc.OracleDriver" );//invocar el jdbc
        //Usuario por defecto de la base de datos: usuario(0, 'admin', 'AnteDatabase')
        conexion = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","hojaDeVida","AnteDatabase" );
         System.out.println("Se conecto a la base de datos correctamente");
    } catch( Exception e ) {
        System.out.println( "No se pudo cargar el puente JDBC-ODBC."+e.getMessage() );
        }
    }


}


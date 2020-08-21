/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristianponceproyectofinal;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class CristianPonceProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null,"Bienvenido al Sistema de Autenticación\n","A.Segura2",JOptionPane.INFORMATION_MESSAGE );
        
        String marca;
        int cuotaF,año;
        
        String[] altaG = {"BMW", "AUDI","PORSCHE","VOLVO","ROLLS-ROYCE","FERRARI"};
        
        boolean log = LOGIN();
    
    if (log){
        marca = JOptionPane.showInputDialog(null, "Cual es la marca de su auto? ","A.Segura2",JOptionPane.QUESTION_MESSAGE);
        marca = marca.toUpperCase();
        año = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar año de su auto", "A.Segura2",JOptionPane.INFORMATION_MESSAGE));
        
        boolean Gama = buscadorG (altaG,marca);
        if (Gama){
        cuotaF = 1800;
        }else{
        cuotaF = 890;
        }
        
        int cuota = buscadorA (año);
        cuotaF = cuotaF + cuota; 
         
       JOptionPane.showMessageDialog(null, "Su auto " + marca + "\nModelo " + año + "\nTiene un valor de cuota de $ " + cuotaF,"A.Segura2",JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(null,"Gracias por usar el sistema de cotización","A.Segura2",JOptionPane.INFORMATION_MESSAGE );
    }
    else {     
             JOptionPane.showMessageDialog(null ,"Usuario Bloqueado" , "A.Segura2",JOptionPane.INFORMATION_MESSAGE ); 
       }
    }
    
    public static boolean buscadorG (String [] altaG, String marca){
    //Foreach
        for(String marcaF : altaG){
            if(marcaF.equals(marca)){
                return true;
            }
        }
        return false;
    }
    
    public static int buscadorA (int año){
        int cuota =0;
        if(año <= 1990){
        cuota = 350;
        }
        if(año >= 1990 && año <= 1999 ){
        cuota = 480;
        } 
        if (año >= 2000 && año <= 2010 ){
        cuota = 780;
        }
        if (año >= 2011 && año <= 2016 ){
        cuota = 950;
        }
        if (año >= 2017 && año <= 2020 ){
        cuota = 1200;
        }
        return cuota;

     }
    
   public static boolean LOGIN (){ 
       
      JPanel myPanel = new JPanel(); 
      JTextField Usuario = new JTextField(10);
      JTextField Clave = new JPasswordField(10);
   
      myPanel.add(new JLabel("Usuario:"));
      myPanel.add(Usuario);
          
      myPanel.add(Box.createHorizontalStrut(10)); // a spacer
      
      myPanel.add(new JLabel("Contraseña:"));
      myPanel.add(Clave);
    
      String [] baseUser = {"Admin1","Admin2"};
      String [] basePass = {"Admin123","Admin456"};
      int attempts = 1;    
      boolean bandera = false;  
      
        do{
           JOptionPane.showConfirmDialog(null, myPanel ,"A.Segura2 - Sistema de Autenticación", JOptionPane.OK_CANCEL_OPTION);
         
      bandera = BUSQUEDA ( baseUser , basePass , Usuario , Clave );
            
          if (bandera){
      
          JOptionPane.showMessageDialog(null ,"Bienvenido al Sistema de Cotización" , "A.Segura2",JOptionPane.INFORMATION_MESSAGE );
      
                }else{
      
          JOptionPane.showMessageDialog(null ,"Usuario o Clave erróneo" , "A.Segura2",JOptionPane.ERROR_MESSAGE );
     
      attempts ++;
                 }
          
             }while (attempts <= 3 && (!bandera));
         
              return bandera;
     }
    
    public static boolean BUSQUEDA (String [] arrayA, String [] arrayB, JTextField nombreA, JTextField nombreB   ){
                       
     for( String  N : arrayA){
        for( String  M : arrayB){
         if( N.equals(nombreA.getText() ) && M.equals(nombreB.getText()) )
         
         {return true;
                                    }
                                  }   
                                } 
            return false;
                
       }
}

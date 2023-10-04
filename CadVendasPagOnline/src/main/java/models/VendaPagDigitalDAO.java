package models;

import java.util.*;

import java.sql.*;  
  
public class VendaPagDigitalDAO {  
  
	
    public  static  Connection obterConexao(){ 

        Connection conexao=null;
        
        try{  
        	
		      String jdbcUrl = "jdbc:postgresql://localhost:5432/loja";
		      String usuario = "postgres";
		      String senha = "postgres";

		      Class.forName("org.postgresql.Driver");
		      conexao = DriverManager.getConnection(jdbcUrl, usuario, senha);

            
        }catch(Exception e){
        	
        	System.out.println(e);
        }
        
        return conexao;  
    }  
    
    public  int inserir(VendaPagDigital v){  
    	
        int status = 0;
        
        try{  
        	
            Connection con = VendaPagDigitalDAO.obterConexao();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO vendas_pag_digital (cliente, cliente_email, produto, valor_pago, tipo_pagamento, tipo_entrega, status_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?)");  
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getClienteEmail());
            ps.setString(3, v.getProduto());
            ps.setDouble(4, v.getValorPago());
            ps.setString(5, v.getTipoPagamento());
            ps.setString(6, v.getTipoEntrega());
            ps.setString(7, v.getStatusPagamento());
              
            status = ps.executeUpdate();  
              
            con.close(); 
            
        }catch(Exception ex){
        	
        	ex.printStackTrace();
        }  
          
        return status;  
    }  
    
      
    
    
    
    public  static List<VendaPagDigital> listarTodas(){ 
    	
        List<VendaPagDigital> listaVendasPagDigital = new ArrayList<VendaPagDigital>();  
          
        try{  
        	
            Connection con = VendaPagDigitalDAO.obterConexao();  
            PreparedStatement ps = con.prepareStatement("SELECT * FROM vendas_pag_digital ORDER BY id ASC");  

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            	
            	String valorPagoTxt = rs.getString("valor_pago");
            	double valor = Double.parseDouble(valorPagoTxt);  
            	
            	
                VendaPagDigital v = new VendaPagDigital();
                
                v.setId(rs.getInt("id"));  
                v.setCliente(rs.getString("cliente"));
                v.setClienteEmail(rs.getString("cliente_email"));
                v.setProduto(rs.getString("produto"));
                v.setValorPago(valor);
                v.setTipoPagamento(rs.getString("tipo_pagamento"));
                v.setTipoEntrega(rs.getString("tipo_entrega"));
                v.setStatusPagamento(rs.getString("status_pagamento"));  
                                
                listaVendasPagDigital.add(v);  
            }  
            
            con.close();
            
        }catch(Exception e){
        	
        	e.printStackTrace();
        }  
          
        return listaVendasPagDigital;  
    }
    
    // adicionado para uso pela EL
    public  List<VendaPagDigital> getListarTodas(){ 
    	
        return VendaPagDigitalDAO.listarTodas();
    }
    
    



public  static  VendaPagDigital findById(int id){ 
	  VendaPagDigital v = new VendaPagDigital();
    try{  
    	
        Connection con = VendaPagDigitalDAO.obterConexao();  
        PreparedStatement ps = con.prepareStatement("SELECT * FROM vendas_pag_digital where id = ? ORDER BY id ASC");  
        ps.setInt(0, id);
        ResultSet rs = ps.executeQuery();
        
         
        	String valorPagoTxt = rs.getString("valor_pago");
        	double valor = Double.parseDouble(valorPagoTxt);  
        	
        	
          
            
            v.setId(rs.getInt("id"));  
            v.setCliente(rs.getString("cliente"));
            v.setClienteEmail(rs.getString("cliente_email"));
            v.setProduto(rs.getString("produto"));
            v.setValorPago(valor);
            v.setTipoPagamento(rs.getString("tipo_pagamento"));
            v.setTipoEntrega(rs.getString("tipo_entrega"));
            v.setStatusPagamento(rs.getString("status_pagamento"));  
                            
               
          
        
        con.close();
        
    }catch(Exception e){
    	
    	e.printStackTrace();
    }  
      
    return v;  
}

}
package ifsul.pweb.CadVendasNovo.models;

public class Venda {
	
	public String item;
	public float valor;
	public Venda(String item, float valor) {
		super();
		this.item = item;
		this.valor = valor;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
	

}

package modelo;
public class Venda {
private int id;
private String item;
private double valor;
// construtor sem argumentos
public Venda() {
}
// métodos get e set para todos os atributos
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getItem() {
return item;
}
public void setItem(String item) {
this.item = item;
}
public double getValor() {
return valor;
}
public void setValor(double valor) {
this.valor = valor;
}
}
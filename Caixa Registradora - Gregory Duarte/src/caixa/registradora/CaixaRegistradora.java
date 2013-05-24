import java.util.Scanner;
 
/**
 *
 * prog73.java
 * Author: Samuel T. C Santos
 * Data: 07/04/2012
 *
 **/
public class CaixaRegistradora {
   
 public static double lerPrecoDoProduto(int numeroDoProduto ){

     Scanner  sc = new Scanner(System.in);
   print("Nome do Produto" + numeroDoProduto +  "?");
   String nome = sc.next();
   
  print("Preco do Produto " + numeroDoProduto +"? ");
  double preco = sc.nextDouble();
  
  //caso seja informado um valor invalido, fique pedindo outro valor!
  while ( preco < 0){
   preco = sc.nextDouble();
  }
  
  
  
  
  
    return preco;
  
 }
 
 
  
 
 




public static String nome(String nome ){
 
  
  
      print(nome);
      
      return nome;

  }

  
   
   
  
 public static double lerPagamento(){
   
   
  Scanner sc = new Scanner(System.in);
  
  print("Dinheiro R$: ");
  
   
  
  double dinheiroRecebido = sc.nextDouble();
   
  return dinheiroRecebido;
 }
   
 public static double darTroco(double dinheiroRecebido, 
                double valorCompra) throws Exception{
   
  if (dinheiroRecebido < valorCompra){
   double quantoFalta = valorCompra - dinheiroRecebido;
   throw new Exception("Valor insuficiente, falta ainda R$ :" + quantoFalta);
  }
    
  return dinheiroRecebido - valorCompra;
 }
  
 public static void finalizaVenda(double totalDaCompra){
  println("Total : R$" + totalDaCompra );
  double valorRecebido = lerPagamento();
   
  try {
   double troco = darTroco(valorRecebido, totalDaCompra);
   println("Troco: R$ " + troco);
  } catch (Exception e) {
   System.err.println(e.getMessage());
    
  }
   
 }
  
   
 public static void caixa(){
  int numeroDoProduto = 1;
   
  double preco = lerPrecoDoProduto(numeroDoProduto);
   
  double totalDaCompra = 0;
   
  while (preco != 0.0){
   totalDaCompra += preco;
   numeroDoProduto ++;
   preco = lerPrecoDoProduto(numeroDoProduto);
  }
   
  finalizaVenda(totalDaCompra);
 }
  
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
   
  while(true){
   caixa();
   print("Deseja fechar S/N?");
    
   String resposta = sc.next();
    
   if (resposta.toLowerCase().equals("s")) break;
  }
 }
  
 public static void print(String str){
  System.out.print(str);
 }
  
 public static void println(String str){
  System.out.println(str);
 }
  
 
}
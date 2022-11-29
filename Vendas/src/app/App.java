package app;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Estoque;
import model.Produto;
import model.enums.Tipo_Produto;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        
        List<Produto> produtos = new ArrayList<>();
        
        String path = "C:\\Users\\PC\\Downloads\\produtos.txt";
        
        
        String nome, tipo="";
        Double preco;
        int estoque;
        
        int opcao = -1;
        while(opcao!=0){
            System.out.println("[1]- Adicionar Produto");
            System.out.println("[2]- Listar Produto");
            System.out.println("[0]- Sair do Sistema");
            
            System.out.print("Opção:");
            opcao = scr.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("#######Cadastro Produto#####");
                    while(true){
                        
                        try {
                            System.out.print("Nome:");
                            nome = scr.next();
                            System.out.print("Preço:");
                            preco = scr.nextDouble();
                            System.out.print("Estoque:");
                            estoque = scr.nextInt();
                            opcao = -1;
                            while(true){
                                System.out.print("Tipo:\n");
                                System.out.println("[1]- Frios");
                                System.out.println("[2]- Bebida");
                                System.out.println("[3]- Enlatado");
                                System.out.println("[4]- Limpeza");
                                System.out.println("[5]- Alimento");
                                System.out.print("Opção:");
                                scr.nextLine();
                                try{    
                                    opcao = scr.nextInt();
                                }catch(InputMismatchException e){
                                    System.out.println("Opção tem que ser numérica");
                                    continue;
                                }

                                switch(opcao){
                                    case 1:
                                        tipo = "FRIOS";
                                        break;
                                    case 2:
                                        tipo = "BEBIDA";
                                        break;
                                    case 3:
                                        tipo = "ENLATADO";
                                        break;
                                    case 4:
                                        tipo = "LIMPEZA";
                                        break;
                                    case 5:
                                    	tipo = "ALIMENTO";
                                    	break;
                                    default:
                                        System.out.println("Opção não encontrada");
                                        continue;
                                }
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.err.println("Erro");
                            continue;
                        }
                        
                        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
                            bw.newLine();
                            bw.write(nome+","+preco+","+tipo+","+estoque);
                        }catch(IOException e){
                            e.getStackTrace();
                        }
                        
                        produtos.add(new Produto(nome, preco, 
                        		Tipo_Produto.valueOf(tipo), 
                        		new Estoque(estoque)));
                        
                        break;
                    }
                    break;
                case 2:
                    if(produtos.size() == 0) {
                    	System.out.println("Lista Vazia");
                    }else {
                    	System.out.println("##########################");
                    	System.out.println("     Lista de Produtos    ");
                    	System.out.println("##########################");
                    	for(Produto i: produtos) {
                    		System.out.println();
                        	System.out.println(i.toString());
                        }
                    	System.out.println();
                    }
                    
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção não encontrada");
                    continue;
            }
        }

        scr.close();
    }
}

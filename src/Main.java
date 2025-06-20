import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Tarefas> listaTarefas = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("-------Menu--------");
            System.out.println("1- Adicionar Tarefa");
            System.out.println("2- Ver lista");
            System.out.println("3- Excluir tarefa");
            System.out.println("4- Fazer tarefa");
            System.out.println("5- Sair ");
            System.out.println("-------------------");

            int escolha = Entrada.lerInteiros(s);

            switch (escolha) {
                case 1:
                    System.out.println("Digite a tarefa que deseja adcionar");
                    String nomeT = s.nextLine();
                    System.out.println("Digite a descrição da tarefa");
                    String descricaoT = s.nextLine();
                    listaTarefas.add(new Tarefas(nomeT, descricaoT));
                    break;
                case 2:
                    for (int i = 0; i < listaTarefas.size(); i++) {
                        System.out.println(i+1 + " - " + listaTarefas.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Digite qual voce quer excluir");
                    for (int i = 0; i < listaTarefas.size(); i++) {
                        System.out.println(i+1 + " - " + listaTarefas.get(i));
                    }
                    int exclui = Entrada.lerInteiros(s);
//                    int exclui = s.nextInt();
                    if (exclui < 0 && exclui > listaTarefas.size()){
                        System.out.println("Indice invalido!");
                    }else{
                        int indice = exclui-1;
                        listaTarefas.remove(indice);
                    }

                    break;
                case 4:
                    System.out.println("Qual tarefa quer concluir?");
                    for (int i = 0; i < listaTarefas.size(); i++) {
                        System.out.println(i+1 + " - " + listaTarefas.get(i));
                    }
                    int feito = Entrada.lerInteiros(s);
                    listaTarefas.get(feito).fazerTarefa();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + escolha);
            }
        }
    }
}
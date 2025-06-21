import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {

    public static void exibirMenu(){
        System.out.println("-------Menu--------");
        System.out.println("1- Adicionar Tarefa");
        System.out.println("2- Ver lista");
        System.out.println("3- Excluir tarefa");
        System.out.println("4- Fazer tarefa");
        System.out.println("5- Sair e Salvar ");
        System.out.println("-------------------");
    }
    public static void adicionarTarefas(List<Tarefas> lista, Scanner s){
        System.out.println("Digite a tarefa que deseja adcionar");
        String nomeT = s.nextLine();
        System.out.println("Digite a descrição da tarefa");
        String descricaoT = s.nextLine();
        lista.add(new Tarefas(nomeT, descricaoT));
    }

    public static void mostrarLista(List<Tarefas> lista, Scanner s){
        if(lista.isEmpty()){
            System.out.println("Nenhuma tarefa. Ainda! pode adicionar!");
        }else{
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i+1 + " - " + lista.get(i));
            }
        }
    }

    public static void excluirTarefa(List<Tarefas> lista, Scanner s){
        System.out.println("Digite qual voce quer excluir");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i+1 + " - " + lista.get(i));
        }
        int exclui = Entrada.lerInteiros(s);
        if (exclui < 0 || exclui > lista.size()){
            System.out.println("Indice invalido!");
        }else{
            lista.remove(exclui-1);
        }
    }

    public static void fazerTarefas(List<Tarefas> lista, Scanner s){
        System.out.println("Qual tarefa quer concluir?");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i+1 + " - " + lista.get(i));
        }
        int feito = Entrada.lerInteiros(s);
        if (feito < 0 || feito > lista.size()){
            System.out.println("Indice invalido!");
        }else{
            lista.get(feito - 1).fazerTarefa();
        }
    }

    public static void salvarTarefas(List<Tarefas> lista){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Tarefas.txt"))){

        for (Tarefas t : lista){
            writer.write(t.getNome() + " | " + t.getDescricao() + " | Feita? " + t.isConcluida());
            writer.newLine();
        }
            System.out.println("Tarefas salvas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
//            throw new RuntimeException(e);
        }
    }
}

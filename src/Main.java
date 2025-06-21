import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Tarefas> listaTarefas = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            Gerenciador.exibirMenu();
            int escolha = Entrada.lerInteiros(s);
            switch (escolha) {
                case 1:
                    Gerenciador.adicionarTarefas(listaTarefas, s);
                    break;
                case 2:
                    Gerenciador.mostrarLista(listaTarefas);
                    break;
                case 3:
                    Gerenciador.excluirTarefa(listaTarefas, s);
                    break;
                case 4:
                    Gerenciador.fazerTarefas(listaTarefas, s);
                    break;
                case 5:
                    Gerenciador.salvarTarefas(listaTarefas);
                    continuar = false;
                    break;
                default:
                    throw new IllegalStateException("Erro: " + escolha);
            }
        }
    }
}
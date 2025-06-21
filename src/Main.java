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
            Gerenciador.exibirMenu();
            int escolha = Entrada.lerInteiros(s);
            switch (escolha) {
                case 1:
                    Gerenciador.adicionarTarefas(listaTarefas, s);
                    break;
                case 2:
                    Gerenciador.mostrarLista(listaTarefas, s);
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
                    throw new IllegalStateException("Unexpected value: " + escolha);
            }
        }
    }
}
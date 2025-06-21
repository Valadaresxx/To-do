public class Tarefas {
    private final String nome;
    private final String descricao;
    private boolean concluida;

    public Tarefas(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.concluida = false;
    }

    public void fazerTarefa(){
        this.concluida = true;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString() {
        String status = concluida ? "[x] " : "[ ] ";
        return status + nome + " - " + descricao;

    }
}

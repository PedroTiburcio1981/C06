public class Cliente {
    private final String nome;
    private final long cpf;
    private final Computador[] computadores;
    private int numComputadores;

    public Cliente(String nome, long cpf, int maxComputadores) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[maxComputadores];
        this.numComputadores = 0;
    }

    public void addComputador(Computador pc) {
        if (numComputadores < computadores.length) {
            computadores[numComputadores++] = pc;
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < numComputadores; i++) {
            total += computadores[i].preco;
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public int getNumComputadores() {
        return numComputadores;
    }

    public Computador[] getComputadores() {
        return computadores;
    }
}
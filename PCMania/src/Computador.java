public class Computador {
    public String marca;
    public float preco;
    public Hardwarebasico[] hardware;
    public SistemaOperacional sistemaOperacional;
    public MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        this.hardware = new Hardwarebasico[3];
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco);
        for (Hardwarebasico hw : hardware) {
            if (hw != null) {
                System.out.println(hw.nome + " (" + hw.capacidade + 
                    (hw.nome.contains("RAM") || hw.nome.contains("HD") ? "Gb" : "Mhz") + ")");
            }
        }
        System.out.println("Sistema Operacional: " + sistemaOperacional.nome + 
                         " (" + sistemaOperacional.tipo + " bits)");
        System.out.println("Acompanha: " + memoriaUSB.nome + " de " + memoriaUSB.capacidade + 
                         (memoriaUSB.nome.contains("Pen-drive") ? "Gb" : "Tb"));
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }
}
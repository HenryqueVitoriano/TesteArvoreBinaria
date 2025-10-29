public class BNodeRB {
        long valor;
        Cor cor;
        BNodeRB esquerda, direita, pai;

        BNodeRB (long valor) {
            this.valor = valor;
            this.cor = Cor.VERMELHO; // novos nós começam vermelhos
        }

}

public class RBTree {
        private BNodeRB raiz;

        private void rotacaoEsquerda(BNodeRB x) {
            BNodeRB y = x.direita;
            x.direita = y.esquerda;
            if (y.esquerda != null)
                y.esquerda.pai = x;
            y.pai = x.pai;
            if (x.pai == null)
                raiz = y;
            else if (x == x.pai.esquerda)
                x.pai.esquerda = y;
            else
                x.pai.direita = y;
            y.esquerda = x;
            x.pai = y;
        }

        private void rotacaoDireita(BNodeRB y) {
            BNodeRB x = y.esquerda;
            y.esquerda = x.direita;
            if (x.direita != null)
                x.direita.pai = y;
            x.pai = y.pai;
            if (y.pai == null)
                raiz = x;
            else if (y == y.pai.direita)
                y.pai.direita = x;
            else
                y.pai.esquerda = x;
            x.direita = y;
            y.pai = x;
        }
        int profundidade(BNodeRB n) {
            if (n == null)
                return 0;
            int esquerda = profundidade(n.esquerda);
            int direita = profundidade(n.direita);
            return 1 + Math.max(esquerda, direita);
        }

        int profundidadeTotal() {
            return profundidade(raiz);
        }

        private void corrigirInsercao(BNodeRB z) {
            while (z.pai != null && z.pai.cor == Cor.VERMELHO) {
                if (z.pai == z.pai.pai.esquerda) {
                    BNodeRB tio = z.pai.pai.direita;
                    if (tio != null && tio.cor == Cor.VERMELHO) {
                        // Caso 1: Tio vermelho
                        z.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        z.pai.pai.cor = Cor.VERMELHO;
                        z = z.pai.pai;
                    } else {
                        if (z == z.pai.direita) {
                            // Caso 2: Z é filho direito
                            z = z.pai;
                            rotacaoEsquerda(z);
                        }
                        // Caso 3: Z é filho esquerdo
                        z.pai.cor = Cor.PRETO;
                        z.pai.pai.cor = Cor.VERMELHO;
                        rotacaoDireita(z.pai.pai);
                    }
                } else {
                    // Espelhado: pai é filho direito
                    BNodeRB tio = z.pai.pai.esquerda;
                    if (tio != null && tio.cor == Cor.VERMELHO) {
                        // Caso 1: Tio vermelho
                        z.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        z.pai.pai.cor = Cor.VERMELHO;
                        z = z.pai.pai;
                    } else {
                        if (z == z.pai.esquerda) {
                            // Caso 2: Z é filho esquerdo
                            z = z.pai;
                            rotacaoDireita(z);
                        }
                        // Caso 3: Z é filho direito
                        z.pai.cor = Cor.PRETO;
                        z.pai.pai.cor = Cor.VERMELHO;
                        rotacaoEsquerda(z.pai.pai);
                    }
                }
            }
            raiz.cor = Cor.PRETO; // raiz sempre preta
        }



        public void inserir(long valor) {
            BNodeRB novo = new BNodeRB(valor);
            BNodeRB y = null;
            BNodeRB x = raiz;

            // Inserção padrão de árvore binária
            while (x != null) {
                y = x;
                if (novo.valor < x.valor)
                    x = x.esquerda;
                else
                    x = x.direita;
            }

            novo.pai = y;
            if (y == null)
                raiz = novo;
            else if (novo.valor < y.valor)
                y.esquerda = novo;
            else
                y.direita = novo;

            // Corrige balanceamento e cores
            corrigirInsercao(novo);
        }

        public void emOrdem(BNodeRB no) {
            if (no != null) {
                emOrdem(no.esquerda);
                System.out.print(no.valor + "(" + no.cor + ") ");
                emOrdem(no.direita);
            }
        }

        public void exibir() {
            emOrdem(raiz);
            System.out.println();
        }
    }


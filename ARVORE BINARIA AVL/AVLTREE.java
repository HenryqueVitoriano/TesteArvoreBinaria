public class AVLTREE {
        BNodeAVL raiz;

        int altura(BNodeAVL n) {
            return (n == null) ? 0 : n.altura;
        }

        int fatorBalanceamento(BNodeAVL n) {
            return (n == null) ? 0 : altura(n.esquerda) - altura(n.direita);
        }

        int profundidade(BNodeAVL n) {
            if (n == null)
                return 0;

            int esquerda = profundidade(n.esquerda);
            int direita = profundidade(n.direita);

            return 1 + Math.max(esquerda, direita);
        }


        int profundidadeTotal() {
            return profundidade(raiz);
        }

        BNodeAVL rotacaoDireita(BNodeAVL y) {
            BNodeAVL x = y.esquerda;
            BNodeAVL T2 = x.direita;

            // Rotaciona
            x.direita = y;
            y.esquerda = T2;

            // Atualiza alturas
            y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
            x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

            return x; // Nova raiz
        }

        BNodeAVL rotacaoEsquerda(BNodeAVL x) {
            BNodeAVL y = x.direita;
            BNodeAVL T2 = y.esquerda;

            // Rotaciona
            y.esquerda = x;
            x.direita = T2;

            // Atualiza alturas
            x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
            y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

            return y; // Nova raiz
        }



        BNodeAVL inserir(BNodeAVL no, Long valor) {
            // Inserção normal em árvore binária de busca
            if (no == null)
                return new BNodeAVL(Math.toIntExact(valor));

            if (valor < no.valor)
                no.esquerda = inserir(no.esquerda, valor);
            else if (valor > no.valor)
                no.direita = inserir(no.direita, valor);
            else
                return no; // valores duplicados não são permitidos

            // Atualiza a altura do nó atual
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

            // Verifica o fator de balanceamento
            int balance = fatorBalanceamento(no);

            // Casos de desbalanceamento
            // Caso Esquerda-Esquerda (LL)
            if (balance > 1 && valor < no.esquerda.valor)
                return rotacaoDireita(no);

            // Caso Direita-Direita (RR)
            if (balance < -1 && valor > no.direita.valor)
                return rotacaoEsquerda(no);

            // Caso Esquerda-Direita (LR)
            if (balance > 1 && valor > no.esquerda.valor) {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }

            // Caso Direita-Esquerda (RL)
            if (balance < -1 && valor < no.direita.valor) {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }

            return no; // Nó não precisou de rotação
        }

        void inserir(Long valor) {
            raiz = inserir(raiz, valor);
        }

        void emOrdem(BNodeAVL no) {
            if (no != null) {
                emOrdem(no.esquerda);
                System.out.print(no.valor + " ");
                emOrdem(no.direita);
            }
        }

        void exibir() {
            emOrdem(raiz);
            System.out.println();
        }
    }

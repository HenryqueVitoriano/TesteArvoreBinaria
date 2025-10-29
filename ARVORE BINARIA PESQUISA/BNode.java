
public class BNode {

    private final long x;
    private BNode esq, dir;

    public BNode(long valor) {
        this.x = valor;
    }

    public void add (long valor) {
        if (valor <= x){ // add a esquerda
            if (esq != null){
                esq.add(valor);
            } else {
                esq = new BNode(valor);
            }
        } else { // add a direita
            if (dir != null) {
                dir.add(valor);
            } else {
                dir = new BNode(valor);
            }
        }
    }

    public void show() {
        if (esq != null) {
            esq.show();
        }

        System.out.println(x);

        if (dir != null) {
            dir.show();
        }
    }

    public long size() {
        long esquerdo = 0;
        long direito = 0;

        if (esq != null) {
            esquerdo = esq.size();
        }

        if (dir != null) {
            direito = dir.size();
        }

        return 1 + direito + esquerdo;
    }

    public long somar() {
        long esquerdo = 0;
        long direito = 0;

        if (esq != null) {
            esquerdo = esq.somar();
        }

        if (dir != null) {
            direito = dir.somar();
        }

        return x + direito + esquerdo;

    }

    // EXERCICIO 1
    public boolean buscar(long valor) {
        boolean confim = false;

        if (valor == this.x) {
            confim = true;

        } else {
            if (esq != null && this.x > valor) {
                confim = esq.buscar(valor);
            }

            if (dir != null && this.x < valor) {
                confim = dir.buscar(valor);
            }
        }

        return confim;
    }

    // EXERCICIO 2
    public long encontrarMinimo() {
        long menorNumero = this.x;

        if (esq != null && esq.getX() < menorNumero) {
            menorNumero = esq.encontrarMinimo();
        }

        if (dir != null && dir.getX() < menorNumero) {
            menorNumero = dir.encontrarMinimo();
        }

        return menorNumero;
    }

    // exercicio 3
    public long encontrarMaximo() {
        long maiorNumero = this.x;

        if (esq != null && esq.getX() > maiorNumero) {
            maiorNumero = esq.encontrarMaximo();
        }

        if (dir != null && dir.getX() > maiorNumero) {
            maiorNumero = dir.encontrarMaximo();
        }

        return maiorNumero;
    }
    // EXERCICIO 4

    public long altura() {
        long alturaEsquerda = 0;
        long alturaDireita = 0;

        if (esq != null) {
            alturaEsquerda = esq.altura();
        }

        if (dir != null) {
            alturaDireita = dir.altura();
        }

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    // EXERCICIO 5
    public long contarFolhas() {
        long quantidadeNosFilhosDireita = 0;
        long quantidadeNosFilhosEsquerda = 0;


        if (esq == null && dir == null) {
            return 1;
        }

        if (esq != null) {
            quantidadeNosFilhosEsquerda = esq.contarFolhas();
        }

        if (dir != null) {
            quantidadeNosFilhosDireita = dir.contarFolhas();
        }

        return quantidadeNosFilhosEsquerda + quantidadeNosFilhosDireita;
    }

    // EXERCICIO 6
    public long contarNosInternos() {
        long quantidadeNosFilhosDireita = 0;
        long quantidadeNosFilhosEsquerda = 0;

        if (esq == dir) {
            return 0;
        }

        if (esq != null) {
            quantidadeNosFilhosEsquerda = esq.contarNosInternos();
        }

        if (dir != null) {
            quantidadeNosFilhosDireita = dir.contarNosInternos();
        }

        return 1 + quantidadeNosFilhosEsquerda + quantidadeNosFilhosDireita;
    }

    // EXERCICIO 7
    public long encontrarProfundidade(long valor, long prof) {
        long esquerda = 0;
        long direita = 0;

        if (esq != null && this.x > valor) {
            esquerda = esq.encontrarProfundidade(valor, prof + 1);

        }

        if (dir != null && this.x < valor) {
            direita = dir.encontrarProfundidade(valor, prof + 1);

        }

        if (valor == x) {
            return prof;
        }

        return direita + esquerda;
    }

    //EXERCICIO 8
    public boolean isABB() {
        if (esq != null && !esq.isABB()){
            return false;
        }

        if (dir != null && !dir.isABB()){
            return false;
        }

        if (esq != null){
            long maiorValor = esq.maiorValor();
            if (maiorValor >= this.x){
                return false;
            }
        }

        if (dir != null){
            long menorValor = dir.menorValor();
            if (menorValor <= this.x){
                return false;
            }
        }

        return true;
    }

    public long maiorValor(){
        if (dir != null){
           return dir.maiorValor();
        }

        return this.x;
    }

    public long menorValor(){
        if(esq != null){
           return esq.menorValor();
        }

        return this.x;
    }

    //EXERCICIO 9
    public long saoIguais(BNode arvore) {
        long confirmDireito = 0;
        long confirmEsquerdo = 0;

        try{
            if (esq != null || arvore.esq != null){
                confirmEsquerdo = esq.saoIguais(arvore.esq);
            }

            if (dir != null || arvore.dir != null){
                confirmDireito =  dir.saoIguais(arvore.dir);
            }

            if (this.getX() != arvore.getX()){
                return  -1;
            }
        } catch (Exception e) {
            return -1;
        }

        return confirmDireito + confirmEsquerdo;
    }

    //EXERCICIO 10

    public long saoSemelhantes(BNode arvore){
        long confirmDireito = 0;
        long confirmEsquerdo = 0;

        try{
            if (esq != null || arvore.esq != null){
                confirmEsquerdo = esq.saoSemelhantes(arvore.esq);
            }

            if (dir != null || arvore.dir != null){
                confirmDireito =  dir.saoSemelhantes(arvore.dir);
            }

            if ((dir == null && arvore.dir != null) || (dir != null && arvore.dir == null)){
                return -1;
            }

            if ((esq == null && arvore.esq != null) || (esq != null && arvore.esq == null)){
                return -1;
            }
        }catch (Exception e){
            return -1;
        }


       return confirmDireito + confirmEsquerdo;
    }





    // GETTERS AND SETTERS
    public long getX() {
        return x;
    }

    public BNode getEsq() {
        return esq;
    }

    public BNode getDir() {
        return dir;
    }

    public void setDir(long valor) {
        this.dir = new BNode(valor);
    }

    public void setEsq(long valor) {
        this.esq = new BNode(valor);
    }


}
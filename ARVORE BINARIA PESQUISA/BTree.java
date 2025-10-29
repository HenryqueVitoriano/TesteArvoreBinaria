public class BTree {
    // raiz

    public BNode raiz;

    public BTree () {
        raiz = null;
    }

    public void add (long valor) {
        if (raiz != null){
            raiz.add(valor);
        } else {
            raiz = new BNode(valor);
        }
    }

    public void show () {
        if (raiz != null){
            raiz.show();
        } else {
            System.out.println("Árvore vazia!");
        }
    }

    public long size () {
        if (raiz != null){
            return raiz.size();
        } else {
            return 0;
        }
    }


    public long somar() {
        if (raiz != null){
            return raiz.somar();
        }else {
            return 0;
        }
    }

    public boolean busca(long valor) {
        if (raiz != null){
            return raiz.buscar(valor);
        }
        else {
            return false;
        }
    }

    public long encontrarMinimo() {
        if (raiz != null){
            return raiz.encontrarMinimo();
        }else {
            return 0;
        }
    }

    public long encontrarMaximo() {
        if (raiz != null){
            return raiz.encontrarMaximo();
        }else {
            return 0;
        }
    }

    public long altura() {
        if (raiz != null){
            return raiz.altura();
        }else {
            return 0;
        }
    }

    public long contarFolhas() {
        if (raiz != null){
            return raiz.contarFolhas();
        }else {
            return 0;
        }
    }

    public long contarNosInternos() {
        if (raiz != null){
            return raiz.contarNosInternos();
        }else {
            return 0;
        }
    }

    public long encontrarProfundidade(long valor){
        if (raiz!= null){
            if (raiz.encontrarProfundidade(valor, 1) != 0){
                return raiz.encontrarProfundidade(valor, 1);
            }
            else return -1;
        }else{
            return -1;
        }
    }

    public boolean isABB() {
        if (raiz != null){
            return raiz.isABB();
        }
        return false;
    }

    public boolean saoIguais(BTree arvore) {
        if(raiz != null && arvore.raiz != null){
            try {
                if (raiz.getX() == arvore.raiz.getX()){
                    return raiz.saoIguais(arvore.raiz) == 0;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        return false;
    }

    public boolean saoSemelhantes(BTree arvore) {
        if(raiz != null && arvore.raiz != null){
            try {
                    return raiz.saoSemelhantes(arvore.raiz) == 0;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("PASSEI AQUI DEU RUIM");

        return false;
    }
}

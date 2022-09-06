import java.util.LinkedList;

public class App {

    static int[][] Matrix_ady_no = { // 0, 1, 2, 3, 4
                                  /*0*/{0, 1 ,0 ,0, 1},
                                  /*1*/{1, 0 ,1 ,1, 1},
                                  /*2*/{0, 1 ,0 ,1, 0},
                                  /*3*/{0, 1 ,1 ,0, 1},
                                  /*4*/{1, 1 ,0 ,1, 0}};


    public static LinkedList<Vertice> lista = new LinkedList<Vertice>();

    public static void llenarLista(){
        for(int i = 0; i < Matrix_ady_no.length ;i++){
            Vertice temp = new Vertice(i);
            for(int j = 0; j < Matrix_ady_no.length ; j++){
                if (Matrix_ady_no[i][j] == 1){
                    temp.adyacentes.add(j);
                }
            }
            lista.add(temp);
        }
    }
    public static void mostrarLista(){
        for(Vertice vertice: lista){
            System.out.print(vertice.getDato());
            for(Integer adyacente: vertice.getAdyacentes()){
                System.out.print("->"+adyacente);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) throws Exception {
        llenarLista();
        mostrarLista();
    }
}

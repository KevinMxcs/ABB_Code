public class Arbol {
    private Nodo raiz;  //null

	Arbol(){
		this.raiz = null;
    }
        public boolean esVacio(){
            return (this.raiz == null); 
        }
        public Nodo getRaiz(){   //getRaiz  -- getter de atributo raiz
            return this.raiz;
        }
        public void insertarValor(int valor){
            if (this.raiz == null){
                System.out.println("Insertando raiz: " + valor);
                this.raiz = new Nodo();
                this.raiz.dato = valor;
                this.raiz.izquierdo = null;
                this.raiz.derecho = null;
            }	else insertarNodo(valor, getRaiz());
        }
        public void insertarNodo(int valor, Nodo nodoRef){
			if (valor <= nodoRef.dato) {
				if (nodoRef.izquierdo == null){
					System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
					nodoRef.izquierdo =  new Nodo();
					nodoRef.izquierdo.dato = valor;
					nodoRef.izquierdo.izquierdo = null;
					nodoRef.izquierdo.derecho = null;
				}
				else {
					insertarNodo(valor, nodoRef.izquierdo);
				}
			}else {
				if (valor > nodoRef.dato) {
					if (nodoRef.derecho == null){
						System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
						nodoRef.derecho =  new Nodo();
						nodoRef.derecho.dato = valor;
						nodoRef.derecho.izquierdo = null;
						nodoRef.derecho.derecho = null;
					}
					else {
						insertarNodo(valor, nodoRef.derecho);
					}
				}
			}
	}
	public void impArbol() {
        imprArbolUtil(raiz, 0);
    }

    private void imprArbolUtil(Nodo nodo, int espacio) {
        // Caso base
        if (nodo == null) {
            return;
        }

        // Aumentar el espacio entre niveles
        espacio += 10;

        // Procesar el subárbol derecho primero
        imprArbolUtil(nodo.derecho, espacio);

        // Imprimir el nodo actual después del espacio
        System.out.print("\n");
        for (int i = 10; i < espacio; i++)
            System.out.print(" ");
        System.out.print(nodo.dato + "\n");

        // Procesar el subárbol izquierdo
        imprArbolUtil(nodo.izquierdo, espacio);
    }
    
    public Nodo buscar(int valor) {
        return buscarN(raiz, valor);
    }

    private Nodo buscarN(Nodo nodo, int valor) {
        // Caso base: el nodo es nulo o el valor se encuentra en el nodo
        if (nodo == null || nodo.dato == valor) {
            return nodo;
        }

        // Si el valor es menor que el valor del nodo, buscar en el subárbol izquierdo
        if (valor < nodo.dato) {
            return buscarN(nodo.izquierdo, valor);
        }
        // Si el valor es mayor que el valor del nodo, buscar en el subárbol derecho
        else {
            return buscarN(nodo.derecho, valor);
        }
    }
    
    public void recorridoPreorden() {
        recorridoPreorden(raiz);
    }

    private void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            // Visitar el nodo (imprimir o realizar alguna operación)
            System.out.print(nodo.dato + " ");

            // Recorrer el subárbol izquierdo
            recorridoPreorden(nodo.izquierdo);

            // Recorrer el subárbol derecho
            recorridoPreorden(nodo.derecho);
        }
    }
    public void recorridoInorden() {
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            // Recorrer el subárbol izquierdo
            recorridoInorden(nodo.izquierdo);

            // Visitar el nodo (imprimir o realizar alguna operación)
            System.out.print(nodo.dato   + " ");

            // Recorrer el subárbol derecho
            recorridoInorden(nodo.derecho);
        }
    }
    public void recorridoPostorden() {
        recorridoPostorden(raiz);
    }

    private void recorridoPostorden(Nodo nodo) {
        if (nodo != null) {
            // Recorrer el subárbol izquierdo
            recorridoPostorden(nodo.izquierdo);

            // Recorrer el subárbol derecho
            recorridoPostorden(nodo.derecho);

            // Visitar el nodo (imprimir o realizar alguna operación)
            System.out.print(nodo.dato + " ");
        }
    }
    //Agregado: Metodo para eliminar un nodo
    public void eliminarUnNodo(int data)throws Exception{
        raiz = eliminarNodo(raiz,data);
    }
    //Metodo privado para eliminar un nodo
    protected Nodo  eliminarNodo(Nodo ref,int data)throws Exception{
        //Mandar mensaje cuando no se encuentre nodo
        if (ref == null){
            throw new Exception("No se encontro el nodo");
        }//procesando el arbol por el lado izquierdo
        else if(data < ref.dato){
            Nodo izq = eliminarNodo(ref.izquierdo, data);
            ref.izquierdo = izq;
        }//Procesando el arbol por el lado derecho
        else if (data > ref.dato){
            Nodo der = eliminarNodo(ref.derecho, data);
            ref.derecho = der;
        }else{
            Nodo temp = ref;
            //cuando no tiene hijo derecho
            if (temp.derecho == null){
                ref =temp.izquierdo;
            }//cuando no tiene hijo izquierdo
            else if (temp.izquierdo == null){
                ref = temp.derecho;
            }//en el caso de tener dos hijos
            else{
                temp = procesarNodo(temp);
            }
            temp = null;
        }
        return ref;
    }
    //Metodo para el metodo eliminar nodo
    protected Nodo procesarNodo(Nodo temp){
        Nodo tem = temp;
        Nodo tem2 = tem.izquierdo;
        while (tem2.derecho != null){
            tem = tem2;
            tem2 = tem2.derecho;
        }
        tem.dato = tem2.dato;
        if (tem == temp){
            tem.izquierdo = tem2.izquierdo;
        }else{
            tem.derecho = tem2.izquierdo;
        }
        return tem2;
    }
   
} 


public class Lista {
    Nodo head;

    public Lista() {
        this.head = null;
    }

    public Lista(String conjunto) {
        this.head = null;
        String[] conjuntoFinal = conjunto.split(", ");
        try {
            for (String s : conjuntoFinal) {
                InsertarFinal(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El conjunto contiene elementos no numéricos.");
        }
    }

    public void ListaRepetida(String conjunto) {
        this.head = null;
        String[] con = conjunto.split(", ");
        try {
            for (String s : con) {
                InsertarFinalConRepetidos(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El conjunto contiene elementos no numéricos.");
        }
    }

    public void InsertarFinalConRepetidos(int dato) {
        if (head == null) {
            head = new Nodo(dato);
            return;
        }

        Nodo p = head;
        while (p.getLiga() != null) {
            p = p.getLiga();
        }
        Nodo data = new Nodo(dato);
        p.setLiga(data);
    }

    public void InsertarFinal(int dato) {
        if (head == null) {
            head = new Nodo(dato);
            return;
        }

        if (Contains(dato)) {
            return;
        }
        Nodo p = head;
        while (p.getLiga() != null) {
            p = p.getLiga();
        }
        Nodo data = new Nodo(dato);
        p.setLiga(data);
    }

    public void Mostrar() {
        Nodo p = head;
        System.out.print("[ ");
        while (p != null) {
            System.out.print(p.getDato() + ((p.getLiga() == null) ? "" : ", "));
            p = p.getLiga();
        }
        System.out.print(" ]\n");
    }

    public int Size() {
        int cont = 0;
        Nodo p = head;
        while (p != null) {
            cont++;
            p = p.getLiga();
        }
        return cont;
    }

    public boolean Contains(int dato) {
        Nodo p = head;
        while (p != null) {
            if (p.getDato() == dato) return true;
            p = p.getLiga();
        }
        return false;
    }

    public boolean Contains(int dato, Nodo head) {
        Nodo p = head;
        while (p != null) {
            if (p.getDato() == dato) return true;
            p = p.getLiga();
        }
        return false;
    }

    public void Union(Nodo head1, Nodo head2) {
        this.head = null;
        Nodo p = head1;
        while (p != null) {
            InsertarFinal(p.getDato());
            p = p.getLiga();
        }

        Nodo q = head2;

        while (q != null) {
            InsertarFinal(q.getDato());
            q = q.getLiga();
        }
    }

    public void EliminarDuplicados() {
        Nodo p = head;
        while (p != null && p.getLiga() != null) {
            Nodo ant = p;
            Nodo q = p.getLiga();
            while (q != null) {
                if (p.getDato() == q.getDato()) {
                    ant.setLiga(q.getLiga());
                } else {
                    ant = q;
                }
                q = q.getLiga();
            }
            p = p.getLiga();
        }
    }

    public void Interseccion(Nodo head1, Nodo head2) {
        this.head = null;
        Nodo p = head1;
        while (p != null) {
            int dato = p.getDato();
            if (Contains(dato, head2)) InsertarFinal(dato);
            p = p.getLiga();
        }
    }

    public boolean Igualdad(Lista lista1, Lista lista2) {
        if (lista1.Size() != lista2.Size()) return false;

        Nodo p = lista1.head;

        while (p != null) {
            int dato = p.getDato();
            if (!Contains(dato, lista2.head)) return false;
            p = p.getLiga();
        }
        return true;
    }

    public boolean SubConjunto(Lista lista1) {
        Nodo q = head;

        while (q != null) {
            int dato = q.getDato();
            if (!Contains(dato, lista1.head)) return false;
            q = q.getLiga();
        }
        return true;
    }

    public void Complemento(Lista universal, Lista lista1) {
        this.head = null;

        boolean v = ValidarUniversal(universal, lista1);

        if (!v) {
            System.out.println("El conjunto universal no es correcto. ");
            return;
        }

        Nodo q = universal.head;

        while (q != null) {
            int dato = q.getDato();
            if (!Contains(dato, lista1.head)) InsertarFinal(dato);
            q = q.getLiga();
        }
    }

    public boolean ValidarUniversal(Lista universal, Lista lista1) {
        Nodo q = lista1.head;

        while (q != null) {
            int dato = q.getDato();
            if (!Contains(dato, universal.head)) return false;
            q = q.getLiga();
        }
        return true;
    }

    public void Diferencia(Lista Esta, Lista noEsta) {
        this.head = null;

        Nodo p = Esta.head;

        while (p != null) {
            int dato = p.getDato();
            if (!Contains(dato, noEsta.head)) InsertarFinal(dato);
            p = p.getLiga();
        }
    }

    public void DiferenciaSimetrica(Lista lista1, Lista lista2) {
        this.head = null;
        Lista union = new Lista();
        union.Union(lista1.head, lista2.head);
        Lista interseccion = new Lista();
        interseccion.Interseccion(lista1.head, lista2.head);

        Nodo p = union.head;
        while (p != null) {
            int dato = p.getDato();
            if (!Contains(dato, interseccion.head)) InsertarFinal(dato);
            p = p.getLiga();
        }
    }

    public void Eliminar(int dato) {
        if (!Contains(dato)) {
            System.out.println("El dato no existe en el conjunto.");
            return;
        }
        if (dato == head.getDato()) {
            head = head.getLiga();
            return;
        }
        Nodo ant = head;
        Nodo p = head.getLiga();

        while (p != null) {
            if (p.getDato() == dato) {
                ant.setLiga(p.getLiga());
            }
            ant = p;
            p = p.getLiga();
        }
    }

    //Empieza desde 0 como un vector normalmente lo hace
    public int Posicion(int dato) {
        if (!Contains(dato)) {
            System.out.println("El dato no existe en el conjunto.");
            return -1;
        }
        Nodo p = head;
        int cont = 0;

        while (p != null) {
            if (p.getDato() == dato) return cont;
            cont++;
            p = p.getLiga();
        }
        return -1;
    }
}

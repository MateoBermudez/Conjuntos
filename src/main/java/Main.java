import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    static String MenuInicial = """
                            1. Listas
                            2. Sets
                            3. Salir
                            """;

    static String MenuConjuntos = """
                            1. Ingresar conjunto (Lista simple)
                            2. Mostrar
                            3. Cantidad de elementos
                            4. Pertenece o no
                            5. Insertar al final
                            6. Union
                            7. Eliminar duplicados
                            8. Interseccion
                            9. Igualdad
                            10. SubConjunto
                            11. Complemento
                            12. Diferencia Simetrica
                            13. Diferencia
                            14. Eliminar
                            15. Posicion
                            16. Salir del menu de operaciones de conjuntos
                    """;

    public static void main(String[] args) {
        Testing();
        TestSet();
        int opcion;
        System.out.println(MenuInicial);
        opcion = in.nextInt();
        in.nextLine();
        while (opcion != 3) {
            switch (opcion) {
                case 1:
                    CasosListas();
                    break;
                case 2:
                    CasosSets();
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
            System.out.println(MenuInicial);
            opcion = in.nextInt();
        }
        System.out.println("Fin del programa.");
    }

    //Testear con todos los casos posibles
    public static void CasosListas() {
        Lista lista1 = null;
        Lista lista2 = null;
        Lista universal = null;
        Lista lista3;
        String elementos;
        int elemento;
        int opcionMenu;
        System.out.println("Ingrese su opcion: ");
        System.out.println(MenuConjuntos);
        opcionMenu = in.nextInt();
        in.nextLine();
        if (opcionMenu != 1 && opcionMenu != 16) {
            System.out.println("Primero debe ingresar los conjuntos. ");
            return;
        }
        while (opcionMenu != 16) {
            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese los elementos de la lista 1: ");
                    elementos = in.nextLine();
                    lista1 = new Lista(elementos);
                    System.out.println("Ingrese los elementos de la lista 2: ");
                    elementos = in.nextLine();
                    lista2 = new Lista(elementos);
                    System.out.println("Ingrese los elementos del conjunto universal: ");
                    elementos = in.nextLine();
                    universal = new Lista(elementos);
                    if (!lista1.ValidarUniversal(universal, lista1) || !lista2.ValidarUniversal(universal, lista2)) {
                        System.out.println("El conjunto universal no es correcto. ");
                        System.out.println("Vuelva a ingresar los conjuntos. ");
                        return;
                    }
                    break;
                case 2:
                    lista1.Mostrar();
                    lista2.Mostrar();
                    universal.Mostrar();
                    break;
                case 3:
                    System.out.println("Cantidad de elementos en la lista 1: " + lista1.Size());
                    System.out.println("Cantidad de elementos en la lista 2: " + lista2.Size());
                    System.out.println("Cantidad de elementos en el conjunto universal: " + universal.Size());
                    break;
                case 4:
                    System.out.println("Ingrese el elemento a buscar en la lista 1: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece a la lista 1: " + lista1.Contains(elemento));
                    System.out.println("Ingrese el elemento a buscar en la lista 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece a la lista 2: " + lista2.Contains(elemento));
                    System.out.println("Ingrese el elemento a buscar en el conjunto universal: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece al conjunto universal: " + universal.Contains(elemento));
                    break;
                case 5:
                    System.out.println("Ingrese el elemento a insertar al final de la lista 1: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    lista1.InsertarFinal(elemento);
                    System.out.println("Ingrese el elemento a insertar al final de la lista 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    lista2.InsertarFinal(elemento);
                    break;
                case 6:
                    lista3 = new Lista();
                    lista3.Union(lista1.head, lista2.head);
                    lista3.Mostrar();
                    break;
                case 7:
                    System.out.println("Ingrese un conjunto con elementos repetidos: ");
                    elementos = in.nextLine();
                    in.nextLine();
                    lista3 = new Lista();
                    lista3.ListaRepetida(elementos);
                    lista3.Mostrar();
                    lista3.EliminarDuplicados();
                    lista3.Mostrar();
                    break;
                case 8:
                    lista3 = new Lista();
                    lista3.Interseccion(lista1.head, lista2.head);
                    lista3.Mostrar();
                    break;
                case 9:
                    System.out.println("Ingrese una lista a comparar con la lista 1: ");
                    elementos = in.nextLine();
                    lista3 = new Lista(elementos);
                    System.out.println("Las listas son iguales: " + lista1.Igualdad(lista1, lista3));
                    System.out.println("Ingrese una lista a comparar con la lista 2: ");
                    elementos = in.nextLine();
                    lista3 = new Lista(elementos);
                    System.out.println("Las listas son iguales: " + lista2.Igualdad(lista2, lista3));
                    break;
                case 10:
                    System.out.println("Ingrese un conjunto, para verificar si es subconjunto de alguna lista: ");
                    elementos = in.nextLine();
                    lista3 = new Lista(elementos);
                    System.out.println("El conjunto es subconjunto de la lista 1: " + lista3.SubConjunto(lista1));
                    System.out.println("El conjunto es subconjunto de la lista 2: " + lista3.SubConjunto(lista2));
                    System.out.println("El conjunto es subconjunto del conjunto universal: " + lista3.SubConjunto(universal));
                    break;
                case 11:
                    System.out.println("Ingrese un conjunto para obtener su complemento: ");
                    elementos = in.nextLine();
                    Lista aux = new Lista(elementos);
                    lista3 = new Lista();
                    lista3.Complemento(universal, aux);
                    lista3.Mostrar();
                    break;
                case 12:
                    lista3 = new Lista();
                    lista3.DiferenciaSimetrica(lista1, lista2);
                    lista3.Mostrar();
                    break;
                case 13:
                    lista3 = new Lista();
                    lista3.Diferencia(lista1, lista2);
                    lista3.Mostrar();
                    break;
                case 14:
                    System.out.println("Ingrese un elemento a eliminar de la lista 1: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    lista1.Eliminar(elemento);
                    System.out.println("Ingrese un elemento a eliminar de la lista 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    lista2.Eliminar(elemento);
                    break;
                case 15:
                    System.out.println("Ingrese un elemento a buscar en la lista 1: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " se encuentra en la posicion: " + lista1.Posicion(elemento));
                    System.out.println("Ingrese un elemento a buscar en la lista 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " se encuentra en la posicion: " + lista2.Posicion(elemento));
                    break;
                default:
                    System.out.println("Opcion invalida. ");
            }
            System.out.println(MenuConjuntos);
            opcionMenu = in.nextInt();
            in.nextLine();
        }
    }

    public static void CasosSets() {
        Sets set1 = null;
        Sets set2 = null;
        Sets universal = null;
        Sets set3;
        int opcionMenu;
        System.out.println("Ingrese su opcion: ");
        System.out.println(MenuConjuntos);
        opcionMenu = in.nextInt();
        in.nextLine();
        while (opcionMenu != 16) {
            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese los elementos del conjunto 1: ");
                    String elementos = in.nextLine();
                    set1 = new Sets(elementos);
                    System.out.println("Ingrese los elementos del conjunto 2: ");
                    elementos = in.nextLine();
                    set2 = new Sets(elementos);
                    System.out.println("Ingrese los elementos del conjunto universal: ");
                    elementos = in.nextLine();
                    universal = new Sets(elementos);
                    if (!set1.ValidarUniversal(universal) || !set2.ValidarUniversal(universal)) {
                        System.out.println("El conjunto universal no es correcto. ");
                        System.out.println("Vuelva a ingresar los conjuntos. ");
                        return;
                    }
                    break;
                case 2:
                    set1.MostarConjunto();
                    set2.MostarConjunto();
                    universal.MostarConjunto();
                    break;
                case 3:
                    set1.CantElementos();
                    set2.CantElementos();
                    universal.CantElementos();
                    break;
                case 4:
                    System.out.println("Ingrese el elemento a buscar en el conjunto 1: ");
                    int elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece al conjunto 1: " + set1.Contains(elemento));
                    System.out.println("Ingrese el elemento a buscar en el conjunto 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece al conjunto 2: " + set2.Contains(elemento));
                    System.out.println("Ingrese el elemento a buscar en el conjunto universal: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elemento + " pertenece al conjunto universal: " + universal.Contains(elemento));
                    break;
                case 5:
                    System.out.println("Ingrese el elemento a insertar al conjunto 1: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    set1.Insertar(elemento);
                    System.out.println("Ingrese el elemento a insertar al conjunto 2: ");
                    elemento = in.nextInt();
                    in.nextLine();
                    set2.Insertar(elemento);
                    break;
                case 6:
                    set3 = new Sets();
                    set3.Union(set1, set2);
                    set3.MostarConjunto();
                    break;
                case 7:
                    System.out.println("La opcion no esta disponible. ");
                    break;
                case 8:
                    set3 = new Sets();
                    set3.Interseccion(set1, set2);
                    set3.MostarConjunto();
                    break;

                case 9:
                    System.out.println("Ingrese un conjunto a comparar con el conjunto 1: ");
                    String elementos1 = in.nextLine();
                    set3 = new Sets(elementos1);
                    if (set1.Igualdad(set1, set3)) {
                        System.out.println("Los conjuntos son iguales. ");
                    } else {
                        System.out.println("Los conjuntos no son iguales. ");
                    }
                    break;
                case 10:
                    System.out.println("Ingrese un conjunto para verificar si es subconjunto del conjunto 1: ");
                    elementos = in.nextLine();
                    set3 = new Sets(elementos);
                    if (set3.Subconjunto(set1, set3)) {
                        System.out.println("El conjunto es subconjunto del conjunto 1. ");
                    } else {
                        System.out.println("El conjunto no es subconjunto del conjunto 1. ");
                    }
                    break;
                case 11:
                    System.out.println("Ingrese un conjunto para obtener su complemento: ");
                    elementos = in.nextLine();
                    set3 = new Sets(elementos);
                    set3.Complemento(set1, universal);
                    set3.MostarConjunto();
                    break;
                case 12:
                    set3 = new Sets();
                    set3.DiferenciaSimetrica(set1, set2);
                    set3.MostarConjunto();
                    break;
                case 13:
                    set3 = new Sets();
                    set3.Diferencia(set1, set2);
                    set3.MostarConjunto();
                    break;
                case 14:
                    System.out.println("Ingrese un elemento a eliminar del conjunto 1: ");
                    int elementoEliminar = in.nextInt();
                    in.nextLine();
                    set1.Eliminar(elementoEliminar);
                    System.out.println("Ingrese un elemento a eliminar del conjunto 2: ");
                    elementoEliminar = in.nextInt();
                    in.nextLine();
                    set2.Eliminar(elementoEliminar);
                    break;
                case 15:
                    System.out.println("Ingrese un elemento a buscar en el conjunto 1: ");
                    int elementoBuscar = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elementoBuscar + " se encuentra en la posicion: " + set1.Posicion(elementoBuscar));
                    System.out.println("Ingrese un elemento a buscar en el conjunto 2: ");
                    elementoBuscar = in.nextInt();
                    in.nextLine();
                    System.out.println("El elemento " + elementoBuscar + " se encuentra en la posicion: " + set2.Posicion(elementoBuscar));
                    break;
                default:
                    System.out.println("Opcion invalida. ");
            }
            System.out.println(MenuConjuntos);
            opcionMenu = in.nextInt();
            in.nextLine();
        }
    }

    public static void Testing() {
        Lista lista1 = new Lista("1, 2, 3, 4, 5, 6, 7, 7, 7");

        Lista lista2 = new Lista("8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 3, 3");

        Lista universal = new Lista("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20, 20");

        Lista lista3 = new Lista();

        lista1.Mostrar();
        lista2.Mostrar();

        universal.Mostrar();

        System.out.println(lista1.Size());
        System.out.println(lista2.Size());
        System.out.println(universal.Size());

        System.out.println(lista1.Contains(4));
        System.out.println(lista2.Contains(835));
        System.out.println(universal.Contains(-1));

        lista1.InsertarFinal(8);
        lista2.InsertarFinal(3);

        lista1.Mostrar();
        lista2.Mostrar();

        lista1.Eliminar(8);

        lista3.Mostrar();


        lista3.Union(lista1.head, lista2.head);

        lista3.Mostrar();

        lista3 = new Lista();

        lista3.ListaRepetida("1, 2, 3, 4, 5, 6, 7, 7, 7");

        lista3.Mostrar();

        //Revisar -> Se cambio la actualizacion del nodo ant
        lista3.EliminarDuplicados();

        lista3.Mostrar();

        lista3 = new Lista();

        lista3.Interseccion(lista1.head, lista2.head);

        lista3.Mostrar();

        System.out.println(lista1.Igualdad(lista1, new Lista("1, 2, 3, 4, 5, 6, 7, 7, 7")));

        lista3 = new Lista("1, 2, 3");

        //Revisar -> Se cambio el orden de la logica
        System.out.println(lista3.SubConjunto(lista1));

        lista3.Complemento(universal, lista1);

        lista3.Mostrar();

        lista3.DiferenciaSimetrica(lista1, lista2);

        lista3.Mostrar();

        lista3.Diferencia(lista1, lista2);

        lista3.Mostrar();

        lista1.Eliminar(5);

        lista1.Mostrar();

        System.out.println(lista1.Posicion(5));

        System.out.println(lista1.Posicion(4));

        System.out.println(lista1.Posicion(6));
    }

    public static void TestSet() {
        Sets set1 = new Sets("1, 2, 3, 4, 5, 6, 7, 7, 7");
        set1.MostarConjunto();
        Sets set2 = new Sets("8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 3, 3");
        set2.MostarConjunto();
        Sets universal = new Sets("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20, 20");
        universal.MostarConjunto();
        Sets set3 = new Sets();

        set1.CantElementos();
        set2.CantElementos();
        universal.CantElementos();

        System.out.println(set1.Contains(4));
        System.out.println(set2.Contains(835));
        System.out.println(universal.Contains(-1));

        set1.Insertar(8);
        set2.Insertar(3);

        set1.MostarConjunto();
        set2.MostarConjunto();

        set3.Union(set1, set2);

        set3.MostarConjunto();

        set3.Interseccion(set1, set2);

        set3.MostarConjunto();

        System.out.println(set1.Igualdad(set1, new Sets("1, 2, 3, 4, 5, 6, 7, 7, 7, 8")));

        System.out.println(set3.Subconjunto(set1, set3));

        set3.Complemento(set1, universal);

        set3.MostarConjunto();

        set3.DiferenciaSimetrica(set1, set2);

        set3.MostarConjunto();

        set3.Diferencia(set1, set2);

        set3.MostarConjunto();

        set1.Eliminar(5);

        set1.MostarConjunto();

        set2.Eliminar(3);

        set2.MostarConjunto();

        System.out.println(set1.Posicion(5));

        System.out.println(set1.Posicion(4));

        System.out.println(set1.Posicion(6));

        System.out.println(set1.ValidarUniversal(universal));

        System.out.println(set2.ValidarUniversal(universal));
    }
}
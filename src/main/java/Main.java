import java.util.Scanner;

public class Main {

    /*
        1. Lista simple
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
     */

    public static Scanner in = new Scanner(System.in);

    static String Menu = """
                            1. Lista simple
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
                    """;

    public static void main(String[] args) {
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


//        int opcion;
//        System.out.println("Ingrese su opcion: ");
//        System.out.println(Menu);
//        opcion = in.nextInt();
//        switch (opcion) {
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            case 10:
//                break;
//            case 11:
//                break;
//            case 12:
//                break;
//            case 13:
//                break;
//            case 14:
//                break;
//            case 15:
//                break;
//            case 16:
//                break;
//            case 17:
//                break;
//            default:
//                System.out.println("Opcion invalida. ");
//        }
    }



}

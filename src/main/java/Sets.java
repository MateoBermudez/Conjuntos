import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sets {

    Set<Integer> conjunto = new HashSet<>();

    public Sets(String conjunto) {
        String[] conjuntoFinal = conjunto.split(", ");
        try {
            for (String s : conjuntoFinal) {
                this.conjunto.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El conjunto contiene elementos no numéricos.");
        }
    }

    public Sets() {
        this.conjunto = new HashSet<>();
    }

    public void MostarConjunto() {
        System.out.println(conjunto);
    }

    public void CantElementos() {
        System.out.println("El conjunto tiene " + conjunto.size() + " elementos.");
    }

    public boolean Contains(int dato) {
        return conjunto.contains(dato);
    }

    public void Insertar(int dato) {
        conjunto.add(dato);
    }

    public void Union (Sets set1, Sets set2) {
        conjunto.clear();
        conjunto.addAll(set1.conjunto);
        conjunto.addAll(set2.conjunto);
    }

    public void Interseccion (Sets set1, Sets set2) {
        conjunto.clear();
        conjunto.addAll(set1.conjunto);
        conjunto.retainAll(set2.conjunto);
    }

    public boolean Igualdad (Sets set1, Sets set2) {
        return set1.conjunto.equals(set2.conjunto);
    }

    public boolean Subconjunto (Sets set1, Sets set2) {
        return set1.conjunto.containsAll(set2.conjunto);
    }

    public void Complemento (Sets set1, Sets universal) {
        conjunto.clear();
        conjunto.addAll(universal.conjunto);
        conjunto.removeAll(set1.conjunto);
    }

    public void Diferencia (Sets set1, Sets set2) {
        conjunto.clear();
        conjunto.addAll(set1.conjunto);
        conjunto.removeAll(set2.conjunto);
    }

    public void DiferenciaSimetrica (Sets set1, Sets set2) {
        conjunto.clear();
        conjunto.addAll(set1.conjunto);
        conjunto.addAll(set2.conjunto);
        Set<Integer> temp = new HashSet<>();
        temp.addAll(set1.conjunto);
        temp.retainAll(set2.conjunto);
        conjunto.removeAll(temp);
    }

    public void Eliminar(int dato) {
        conjunto.remove(dato);
    }

    public int Posicion(int dato) {
        List<Integer> lista = new ArrayList<>(conjunto);
        return lista.indexOf(dato);
    }

    public boolean ValidarUniversal(Sets universal) {
        return universal.conjunto.containsAll(conjunto);
    }
}

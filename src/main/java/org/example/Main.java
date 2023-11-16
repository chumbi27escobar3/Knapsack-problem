package org.example;

import java.util.*;

public class Main {

    private static List<Mochila> bestItems = new ArrayList<Mochila>();
    private static List<Mochila> wortItems = new ArrayList<Mochila>();

    private static List<Mochila> elements = new ArrayList<Mochila>();

    public static void main(String[] args) {

        int capacity = 8;
        elements.add(new Mochila(2,3,capacity));
        elements.add(new Mochila(3,4,capacity));
        elements.add(new Mochila(4,5,capacity));
        elements.add(new Mochila(5,6,capacity));
        sortList(elements);
        itemsQuery();
        int itemsBackpackTotal = 0;
        for(Mochila mochila : bestItems){
            System.out.print("(" + mochila.getWeight() + ", " + mochila.getElements() + ") ");
            itemsBackpackTotal += mochila.getElements();
        }
        System.out.println("En el mejor caso la cantidad de elementos es " + itemsBackpackTotal);
        itemsBackpackTotal = 0;
        for(Mochila mochila : wortItems){
            System.out.print("(" + mochila.getWeight() + ", " + mochila.getElements() + ") ");
            itemsBackpackTotal += mochila.getElements();
        }
        System.out.println("Elementos que no se tomaron en cuenta y la cantidad de sus elementos es " + itemsBackpackTotal);

    }

    public static void itemsQuery(){
        int capacityMochila = 0;
        for(Mochila m: elements){
            if(capacityMochila + m.getWeight() <= m.getCapacity()){
                bestItems.add(m);
                capacityMochila += m.getWeight();
            } else {
                wortItems.add(m);
            }
        }
    }

    public static void sortList(List<Mochila> elements){
        Collections.sort(elements, new Comparator<Mochila>() {
            @Override
            public int compare(Mochila o1,Mochila o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
    }

    public static Integer randomNumber(){
        Random random = new Random();
        return (int) random.nextInt(50);
    }

}

class Mochila{
    private Integer weight;
    private Integer elements;

    private Integer capacity;

    public Mochila(Integer weight, Integer elements, Integer capacity) {
        this.weight = weight;
        this.elements = elements;
        this.capacity = capacity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getElements() {
        return elements;
    }

    public void setElements(Integer elements) {
        this.elements = elements;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
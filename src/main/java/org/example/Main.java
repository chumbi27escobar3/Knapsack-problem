package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.printf("");
        int random = (int) Math.random();
        int capacity = 8;
        List<Mochila> elements = new ArrayList<Mochila>();
        elements.add(new Mochila(2,3,capacity));
        elements.add(new Mochila(3,4,capacity));
        elements.add(new Mochila(4,5,capacity));
        elements.add(new Mochila(5,6,capacity));
        sortList(elements);
        List<Mochila> resultdList = itemsQuery(elements);
        int itemsBackpack = 0;
        for(Mochila mochila : resultdList){
            System.out.print("(" + mochila.getWeight() + ", " + mochila.getElements() + ") ");
            itemsBackpack += mochila.getElements();
        }
        System.out.println("La cantidad de elementos es " + itemsBackpack);

    }

    public static List<Mochila> itemsQuery(List<Mochila> listElement){
        List<Mochila> elementsResol = new ArrayList<Mochila>();
        int capacityMochila = 0;
        for(Mochila m: listElement){
            if(capacityMochila + m.getWeight() <= m.getCapacity()){
                elementsResol.add(m);
                capacityMochila += m.getWeight();
            }
        }
        return elementsResol;
    }

    public static void sortList(List<Mochila> elements){
        Collections.sort(elements, new Comparator<Mochila>() {
            @Override
            public int compare(Mochila o1,Mochila o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
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
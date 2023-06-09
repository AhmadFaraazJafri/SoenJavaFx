package com.example.demo6.SetClass;
/***............................................................
 Project Phase 2 , SOEN 6441
 ©Faraaz, Himangshu, Shivesh
 Written by: Himangshu Shekhar Baruah , Student ID 40229774
 Ahmad Faraaz Jafri, Student ID 40232742
 Shivesh Chaudhary, Student ID 40228107

 ............................................................
 ***/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetClass<S extends Identifiable> {
    //arraylist to store the elements of the Set class
    private List<S> elements = new ArrayList<>();

    // method to add a new element
    public void add(S newElement) {
        boolean flag = false;
        if (elements.isEmpty()) {
            elements.add(newElement);
        }
        for (S element : elements) {
            if (!(element.getID() == newElement.getID()) ) {
                flag = true;
            }

        }
        if (flag){
            elements.add(newElement);
        }
    }
    //method to remove an element
    public S remove(int id) {
        Iterator<S> iterator = elements.iterator();
        while (iterator.hasNext()) {
            S student = iterator.next();
            if (student.getID() == id) {
                iterator.remove();
                return student;
            }
        }
        return null;
    }

    //method to peek an element and return a boolean value
    public boolean peek(int id) {
        for (S element : elements) {
            if (element.getID() == id) {
                return true;
            }
        }
        return false;
    }
    //Method to return the size of the set
    public int size() {
        return elements.size();
    }
    //Method to check if elements are a part of a set
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SetClass) {
            SetClass<?> otherSet = (SetClass<?>) obj;
            if (size() == otherSet.size()) {
                for (S element : elements) {
                    boolean found = false;
                    for (Identifiable otherElement : otherSet.elements) {
                        if (otherElement.getID() == element.getID()) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    //Method to display the elements of the set
    public void display() {
        for (S element : elements) {
            System.out.println(element);
        }
    }


    }
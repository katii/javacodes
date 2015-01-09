/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author Ohjelmistokehitys
 */
public class person {
    
    // private ei näy aliluokalle
    // jos haluat että perityy aliluokalle, niin käytä protected
    // yläluokkaan kootaan yhteinen toiminnallisuus, kantaluokka huolehtii näistä, joten periaatteessa kaikki privateksi
    // vain jos tarttee niin protected (HYVÄ SYY) 
    // parempi ois jos aliluokka vois käsitellä yläluokan muuttujia vain yläluokan public funktioiden kautta
    // 
    private int age;
    protected float weight;
    private float hight;
    
    public person(){
    }
    
    public person(int age){
        System.out.println("Person created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }
    
}

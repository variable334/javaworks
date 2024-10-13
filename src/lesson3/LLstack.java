package lesson3;
import java.util.LinkedList;



public class LLstack {

    private LinkedList<String>Strstack = new LinkedList<>();


    public void push(String element){
        Strstack.addFirst(element);
    }
    public String peek(){
        return  Strstack.peekFirst();
    }

    public String pop(){

        return Strstack.removeFirst();
    }

    public LinkedList<String> getElem(){

        return new LinkedList<>(Strstack);
    }

}

package lesson3;

/**
 * Реализовать стэк с помощью массива.
 * Нужно реализовать методы:
 * <p>
 * size()
 * empty()
 * push()
 * peek()
 * pop()
 */

public class myStack {

    private int size = 0;
    private int capaciti = 2;
    private int[] stack = new int[capaciti];
    private int top = -1;

    private void addCap() {

        capaciti = capaciti * 2;
        int[] copStack = new int[capaciti];
        System.arraycopy(stack, 0, copStack, 0, size);
        stack = copStack;
    }

    public boolean empty() {
        return size == 0;
//      return top == -1;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capaciti;
    }

    public void push(int value) {
        if (isFull()) {
            addCap();
        }

        stack[++top] = value;
        size++;

    }

    public int peek(){
        if(empty()){ throw new RuntimeException("стэйк пуст");
        }
        return  stack[top];
    }

    public int pop(){
        if(empty()){ throw new RuntimeException("стэйк пуст");
        }
        size--;
        capaciti--;

        return  stack[--top];
    }

    @Override
    public String toString() {
        if (empty()) return "[]";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(stack[i]).append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());
        return String.format("[%s]", builder); //return builder.toString()
    }




}

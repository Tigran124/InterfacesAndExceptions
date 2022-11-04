public class DynamicArrayQueue implements Queue{
    Integer[] array = new Integer[6];
    int visbleReng = 0;

    public void add(int value) {
        if(array.length == visbleReng) {
            array = enlargeArrey(array);
        }
        array[visbleReng] = value;
        this.visbleReng ++;
    }

    public int remuveAt(int indexOfElement){
        int valueOfElement=array[indexOfElement];
        Integer[] smollArray = new Integer[array.length - 1];
        for (int i = 0; i < indexOfElement; i++) {
            smollArray[i] = array[i];
        }
        for (int i = indexOfElement; i < smollArray.length; i++) {
            smollArray[i] = array[i+1];
        }
        this.array = smollArray;
        return valueOfElement;
    }

    public void addAt(int index,int value) {
        if(index >= visbleReng){
            System.out.println("eror");
        }else {
            if(array.length == visbleReng) {
                array = enlargeArrey(array);
            }
            this.visbleReng ++;
            Integer[] largeArrey = new Integer[array.length];
            for (int i = 0; i < index; i++) {
                largeArrey[i] = array[i];
            }
            largeArrey[index] = value;
            for (int i = index+1; i < visbleReng; i++) {
                largeArrey[i] = array[i - 1];
            }
            this.array = largeArrey;
        }
    }


    public void remove(int value) {
        int count = 0;
        Integer[] temp = new Integer[array.length];
        for (int i = 0; i < visbleReng; i++) {
            if (array[i] != value){
                temp[count]=array[i];
                count ++;
            }
        }
        this.visbleReng = count;
        this.array = temp;
    }


    public Integer[] enlargeArrey(Integer[] array) {
        Integer[] largArray = new Integer[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            largArray[i] = array[i];
        }
        return largArray;
    }

    @Override
    public void add(Integer e) {
        try {
            addAt(0, e);
        }
        catch (EmptyQueueException e1) {
            System.out.println("iligal state exeption");
        }
    }

    @Override
    public Integer pop() {
        Integer lastNum = array[visbleReng];
        array[visbleReng] = null;
        this.visbleReng --;
        return lastNum;
    }

    @Override
    public Integer peek() {
        try {
            return array[0];
        }
        catch (EmptyQueueException e) {
            System.out.println("empty queue");
        }
        return null;
    }
}

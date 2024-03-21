package cloud.caravana.puzzlers.lang;

class Ints {
    public static void main(String... args){
        var a = (Integer) 42;
        var b = (Integer) 42;
        var i = (Integer) 333;
        var j = (Integer) 333;
        System.out.println(a == b);
        System.out.println(i == j);
    }
}